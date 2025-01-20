<html>
<head>
<style>
.A{
	padding:4px;
	
	
}
.B{
	padding:4px;
}
#btn{
	border-radios=4px;
	
}
</style>

</head>
<body>

<form method="post">
    <h2>Multiplication Matrix</h2>
    <div class=A>
        <h3>Matrix A</h3>
        <input type="number" name="a1" placeholder="a">
        <input type="number" name="a2" placeholder="b"><br>
        <input type="number" name="a3" placeholder="c">
        <input type="number" name="a4" placeholder="d">
    </div>
    <div>
        <h3>Matrix B</h3>
        <input type="number" name="b1" placeholder="e">
        <input type="number" name="b2" placeholder="f"><br>
        <input type="number" name="b3" placeholder="g">
        <input type="number" name="b4" placeholder="h">
    </div>
	
    <button type="submit" name="submit" id=btn>Calculate</button>
</form>


<?php
if (isset($_POST['submit'])) {
   
    $a1 = $_POST['a1'];
    $a2 = $_POST['a2'];
    $a3 = $_POST['a3'];
    $a4 = $_POST['a4'];

    
    $b1 = $_POST['b1'];
    $b2 = $_POST['b2'];
    $b3 = $_POST['b3'];
    $b4 = $_POST['b4'];

    
    $c1 = $a1 * $b1 + $a2 * $b3;
    $c2 = $a1 * $b2 + $a2 * $b4;
    $c3 = $a3 * $b1 + $a4 * $b3;
    $c4 = $a3 * $b2 + $a4 * $b4;

   
    echo "Matrix C<br>";
    echo "$c1 $c2<br>";
    echo "$c3 $c4";
}
?>
</body>
<html>