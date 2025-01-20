<?php

// Create a connection to the MySQL server

$conn = new mysqli("localhost", "root", "1234", "php");

// Check the connection

if ($conn->connect_error){
    die("Connection failed : " . $conn->connect_error);
}

// Insert data into the users table
$sql = "INSERT INTO users (id, firstname, lastname, district) VALUES (1, 'John', 'Doe', 'District A')";

if ($conn->query($sql) === TRUE) {
   echo "Data inserted successfully";
} else {
    echo "Error inserting data: " . $conn->error;
}

$conn->close();
?>