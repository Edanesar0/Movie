<?php
header("Content-Type: application/json charset=utf=8");
include_once "conections.php";
include_once "validation.php";
require_auth();
$connection = new DatabaseConnection();
$sql = "SELECT * FROM tblestado";
$datos = $connection->executeQuery($sql);
echo json_encode($datos);
?>
