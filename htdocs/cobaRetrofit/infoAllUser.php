<?php

	require_once('koneksidb.php');

	$query = " SELECT * FROM user ";

	$h = mysqli_query($conn, $query);
	$hasil = array();

	while($row = mysqli_fetch_array($h)){
		array_push($hasil,array(
			"name" =>$row['name'],		
			"email"=>$row['email'],
			"topic"=>$row['topic'],
			"age"=>$row['age']
		));
	}
	

	echo json_encode(array('result'=>$hasil) );

	mysqli_close($conn);


?>
