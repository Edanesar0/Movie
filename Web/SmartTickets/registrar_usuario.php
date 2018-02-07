<?php
header("Content-Type: application/json charset=utf=8");
include_once "conections.php";
$datos = file_get_contents('php://input');
$datos = urldecode($datos);
$data = json_decode($datos, true);
$connection = new DatabaseConnection();
$user = $data["email"];
$sql = "SELECT count(*) FROM tblusuario WHERE email='$user'";
$datos = $connection->executeQuery($sql)[0];
if ($datos) {
    if ($datos["count"] < 1) {
        $insert = "INSERT INTO tblusuario(email";

        $values = "'" . $data["email"] . "'";
        if (isset($data["nombre"])) {
            $nombre = $data["nombre"];
            $insert .= ",nombre";
            $values .= ",'$nombre'";
        }
        if (isset($data["apellido"])) {
            $apellido = $data["apellido"];
            $insert .= ",apellido";
            $values .= ",'$apellido'";
        }
        if (isset($data["cargo"])) {
            $cargo = $data["cargo"];
            $insert .= ",cargo";
            $values .= ",'$cargo'";
        }
        if (isset($data["password"])) {
            $password = $data["password"];
            $insert .= ",password";
            $values .= ",'$password'";
        }
        if (isset($data["telefono"])) {
            $telefono = $data["telefono"];
            $insert .= ",telefono";
            $values .= ",'$telefono'";
        }
        if (isset($data["idlider"])) {
            $idlider = $data["idlider"];
            $insert .= ",idlider";
            $values .= ",'$idlider'";
        }
        $sql = $insert . ") VALUES ($values)";
        $json = $connection->executeInsert($sql);
        if ($json >= 1) {
            $sql2 = "SELECT tblusuario.* " .
                "from tblusuario " .
                "WHERE email='" . $data["email"] . "' ";
            $json2 = $connection->executeQuery($sql2)[0];
            unset($json['password']);
            echo json_encode($json2);
        } else {
            echo "[{\"mensaje\":\"Error el usuario no se pudo crear\"}]";
        }
    } else {
        header('HTTP/1.1 400 Bad Request');
        echo "[{\"mensaje\":\"Error el usuario ya existe\"}]";
    }
}
?>
