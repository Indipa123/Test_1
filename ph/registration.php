<?php
// Database connection details

$servername = "localhost";    // Change if not using localhost
$username = "root";           // Replace with your MySQL username
$password = "1234";           // Replace with your MySQL password
$dbname = "students";         // Database name

// Create connection

$conn = new mysqli($servername, $username, $password ,$dbname);

// Check connection

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Check if the form is submitted

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $studentID = $_POST['StudentID'];
    $userName = $_POST['UserName'];
    $password = $_POST['Password'];


    // Prepare and bind the SQL statement
    $stmt = $conn->prepare("INSERT INTO registration (StudentID, UserName, Password) VALUES (?, ?, ?)");
    $stmt->bind_param("sss", $studentID, $userName, $password);

    // Execute the statement and check if successful
    if ($stmt->execute()) {
        echo "Student registered successfully!";
    } else {
        echo "Error: " . $stmt->error;
    }

    // Close the statement
    $stmt->close();
}

// Close the database connection
$conn->close();
?>



<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
</head>
<body>
    <h2>Register a Student</h2>
    <form method="POST" action="">
        <label for="StudentID">Student ID:</label>
        <input type="text" id="StudentID" name="StudentID" required><br><br>

        <label for="UserName">Username:</label>
        <input type="text" id="UserName" name="UserName" required><br><br>

        <label for="Password">Password:</label>
        <input type="password" id="Password" name="Password" required><br><br>

        <button type="submit">Register</button>
    </form>
</body>
</html>
