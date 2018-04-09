<?php

$name      = $_GET['name'];

require_once('koneksidb.php');

$query = " SELECT * FROM user WHERE name = '$name' ";

$h = mysqli_query($conn, $query);

$hasil = array();

$row = mysqli_fetch_array($h);

array_push($hasil,array(
		"name" =>$row['name'],		
		"email"=>$row['email'],
		"topic"=>$row['topic'],
		"age"=>$row['age']
	)
);

echo json_encode(array('result'=>$hasil) );

mysqli_close($conn);


?>
