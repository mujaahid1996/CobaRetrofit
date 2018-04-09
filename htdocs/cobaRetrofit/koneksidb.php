<?php
	define ('HOST', 'localhost');
	define ('USER', 'root');
	define ('PASS', '');
	define ('DB', 'cobaRetrofit');
	
	$conn = mysqli_connect(HOST,USER,PASS,DB) or die ("Database gagal terhubung. Alasan : ". mysqli_errno);
?>