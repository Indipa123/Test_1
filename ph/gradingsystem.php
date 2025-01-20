<html>
<head>
    <title>Grading System</title>
</head>
<body>
    <form method="post">
        <label for="marks">Enter your marks:</label>
        <input type="number" id="marks" name="marks" required>
        <input type="submit" value="Check Grade">
    </form>

    <?php
    function getGrade($marks) {
        switch (true) {
            case ($marks >= 75):
                return "A";
            case ($marks >= 65):
                return "B";
            case ($marks >= 55):
                return "C";
            case ($marks >= 40):
                return "S";
            default:
                return "F";
        }
    }

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $inputMarks = (int)$_POST['marks'];
        $grade = getGrade($inputMarks);
        echo "Your grade is: $grade";
    }
    ?>
</body>
</html>
