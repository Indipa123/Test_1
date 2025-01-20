<!DOCTYPE html>
<html lang="en">
    <head>
        <meta chartset='utf-8'>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'>
        <title>Pascal Triangle</title>
        <style>
            h1 {
                text-align: center;
                font-size: 3vw;
                font-family: "Helvetica";
                color: blue;
            }
            .btn {
                  padding: 10px 15px;
                  border: none;
                  background-color: #28a745;
                  color: #fff;
                  cursor: pointer;
                  border-radius: 5px;
                  font-size: 16px;
            }
            .btn:hover {
                   background-color: #218838;
            }
            form {
                color: black;
                font-size: 2vw;
            }
            .pascal {
                width: 70%;
                margin: auto;
                padding: 2vw;
                font-size: 2vw;
                font-family: "Helvitica";
                text-align: center;
                color: black;
                font-weight: 10;
            }
            body {
                background-color: pink;
                padding: 2vw;
            }
            

        </style>
    </head>

    <body>
        <h1>Pascal Triangle</h1>

        <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" onsubmit="return validateForm()">
            <label for="rows"> Enter number of rows: </label> 
            <input type="number" name="rows" id="rows" min="1" max="10" required>
            <input type="submit" class="btn" value="Submit">
            <div id="error-message" style="color: red;"></div>
        </form>

        <div class="pascal" id="pascal">
        <?php
            function printPascal($rows) {
                $pascal = array();
                
                for ($i = 0; $i < $rows; $i++) {
                    $pascal[$i] = array();

                    for($k = $rows-$i; $k >= 0; $k--) {
                        echo " ";
                    }

                    for ($j = 0; $j <= $i; $j++) {
                        if ($j == 0 || $j == $i) {
                            $pascal[$i][$j] = 1;
                        } else {
                            $pascal[$i][$j] = $pascal[$i - 1][$j - 1] + $pascal[$i - 1][$j];
                        }
                        echo $pascal[$i][$j] . " ";
                    }
                    echo "<br>";
                }
            }

            if ($_SERVER["REQUEST_METHOD"] == "POST") {
                $rows = htmlspecialchars($_POST['rows']);
                printPascal($rows);
            }

            if (isset($_GET['action']) && $_GET['action'] === 'terminate') {
                exit('Script terminated');
            }
        ?>
        </div>
        <script>
            function validateForm() {
                var number = document.getElementById("rows").value;
                var errorMessage = document.getElementById("error-message");

                if (number === "" || isNaN(number)) {
                    errorMessage.textContent = "Please enter a valid number.";
                    return false;
                } else if (number > 10) {
                    errorMessage.textContent = "The number must be between 1 and 10.";
                    return false;
                } else {
                    errorMessage.textContent = "";
                    return true;
                }
            } 

            document.addEventListener('keydown', function(event) {
            if (event.key === 'N' || event.key === 'n') {
                fetch('your_script.php?action=terminate')
                    .then(response => response.text())
                    .then(data => console.log(data));
            }
        });
        </script>
    </body>
</html>
    
