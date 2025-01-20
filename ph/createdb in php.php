<?php

// Create a connection to the MySQL server

$conn = new mysqli("localhost", "root", "1234", "");

// Check the connection

if ($conn->connect_error){
    die("Connection failed : " . $conn->connect_error);
}

$conn->query ("CREATE DATABASE php");

$conn->select_db("php");

$conn->query("CREATE TABLE users (
id INT(10) PRIMARY KEY,
firstname VARCHAR(150),
lastname VARCHAR(150),
district VARCHAR(150))");

echo "Database and Table are created Successfully";

$conn->close();
?>