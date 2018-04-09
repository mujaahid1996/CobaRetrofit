 <?php

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
    $name          = $_POST['name'];
    $email         = $_POST['email'];
    $topic         = $_POST['topic'];    
    $age           = $_POST['age'];    
    

    require_once('koneksidb.php');

    $sql = "update user set email = '$email' ,  topic = '$topic',  age = '$age' where name = '$name'  ";

    if(mysqli_query($conn, $sql)){
        echo "Successfully Registered";
    }
    else{
        echo "Could not register";
    }
}else{
    echo 'error';
}