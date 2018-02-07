<?php
header("Content-Type: application/json charset=utf=8");
include_once "conections.php";
$datos = file_get_contents('php://input');
$datos = urldecode($datos);

$data = json_decode($datos, true);
$connection = new DatabaseConnection();
$pass = $data["pass"];
$user = $data["user"];
$sql = "SELECT activo FROM tblusuario WHERE email='$user'";
if ($pass) {
    $sql .= " AND password='$pass'";
}
//var_dump($sql);
$datos = $connection->executeQuery($sql);

if ($datos) {
    if ($datos [0]['activo']) {
        $sql2 = "SELECT tblusuario.* " .
            "from tblusuario " .
            "WHERE email='$user' ";

        $json = $connection->executeQuery($sql2)[0];
        unset($json['password']);
        $json['cargo'] = consultaCargo($json['cargo'], $connection);
        $json['idlider'] = consultaUsuario($json['idlider'], $connection);
        $sql3 = "SELECT tblproyecto.* " .
            "FROM tbl_usr_pro " .
            "INNER JOIN tblusuario ON tblusuario.idusuario = tbl_usr_pro.idusuario " .
            "INNER JOIN tblproyecto ON tblproyecto.idproyecto = tbl_usr_pro.idproyecto " .
            "INNER JOIN tblestado t ON tbl_usr_pro.idestado = t.idestado " .
            "WHERE email = '$user' ";
        $json2 = $connection->executeQuery($sql3);
        $idproyectos = "";
        for ($i = 0; $i < count($json2); $i++) {
            $json2[$i]['idestado'] = consultaEstado($json2[$i]['idestado'], $connection);
            $idproyectos .= $json2[$i]['idproyecto'] . ",";
        }
        $idproyectos = substr($idproyectos, 0, -1);
        $json['proyectos'] = $json2;
        $sql5 = "SELECT * FROM tblticket " .
            " WHERE idresponsable =" . $json['idusuario'] .
            " OR idquienpide =" . $json['idusuario'] .
            " OR idproyecto IN (" . $idproyectos . ")";
        $jsonTickets = $connection->executeQuery($sql5);
        for ($i = 0; $i < count($jsonTickets); $i++) {
            $jsonTickets[$i]['idresponsable'] = consultaUsuario($jsonTickets[$i]['idresponsable'], $connection);
            $jsonTickets[$i]['idquienpide'] = consultaUsuario($jsonTickets[$i]['idquienpide'], $connection);
            $jsonTickets[$i]['idestado'] = consultaEstado($jsonTickets[$i]['idestado'], $connection);
            $jsonTickets[$i]['idprioridad'] = consultaPrioridad($jsonTickets[$i]['idprioridad'], $connection);
            $jsonTickets[$i]['idproyecto'] = consultaProyecto($jsonTickets[$i]['idproyecto'], $connection);
            $jsonTickets[$i]['idtipo'] = consultaTipo($jsonTickets[$i]['idtipo'], $connection);
        }
        $json['tickets'] = $jsonTickets;
        echo json_encode($json);
    } else {
        header('HTTP/1.1 401 Authorization Required');
        header('WWW-Authenticate: Basic realm="Access denied Activo"');
        echo "[{\"mensaje\":\"Error Usuario no activo\"}]";
    }
} else {
    header('HTTP/1.1 401 Authorization Required');
    header('WWW-Authenticate: Basic realm="Access denied"');
    echo "[{\"mensaje\":\"Error el usuario no existe\"}]";
}

function consultaEstado($estado, $connection)
{
    $sql4 = "SELECT * FROM tblestado WHERE idestado=" . $estado;
    return $connection->executeQuery($sql4)[0];
}

function consultaProyecto($proyecto, $connection)
{
    $sql3 = "SELECT tblproyecto.* " .
        "FROM tbl_usr_pro " .
        "INNER JOIN tblproyecto ON tblproyecto.idproyecto = tbl_usr_pro.idproyecto " .
        "INNER JOIN tblestado t ON tbl_usr_pro.idestado = t.idestado " .
        "WHERE tblproyecto.idproyecto = '$proyecto' ";
    $json2 = $connection->executeQuery($sql3);
    for ($i = 0; $i < count($json2); $i++) {
        $json2[$i]['idestado'] = consultaEstado($json2[$i]['idestado'], $connection);
    }
    return $json2;
}

function consultaPrioridad($estado, $connection)
{
    $sql4 = "SELECT * FROM tblprioridad WHERE idprioridad=" . $estado;
    return $connection->executeQuery($sql4)[0];
}

function consultaTipo($tipo, $connection)
{
    $sql4 = "SELECT * FROM tbltipoticket WHERE idtipoticket=" . $tipo;
    return $connection->executeQuery($sql4)[0];
}

function consultaCargo($json, $connection)
{
    $sql6 = "SELECT * FROM tblcargo WHERE  idcargo=" . $json;
    $json3 = $connection->executeQuery($sql6)[0];
    return $json3;
}

function consultaUsuario($user, $connection)
{

    $sql = "SELECT idusuario,nombre,apellido,cargo,email,telefono,idlider FROM tblusuario WHERE idusuario=" . $user;
    $json = $connection->executeQuery($sql)[0];
    $json['cargo'] = consultaCargo($json['cargo'], $connection);
    $json['idlider'] = consultaLider($json['idlider'], $connection);
    return $json;
}

function consultaLider($user, $connection)
{
    if ($user) {
        $sql = "SELECT idusuario,nombre,apellido,cargo,email,telefono,idlider FROM tblusuario WHERE idusuario=" . $user;
        $json = $connection->executeQuery($sql)[0];
        $json['cargo'] = consultaCargo($json['cargo'], $connection);
        return $json;
    }
}

?>
