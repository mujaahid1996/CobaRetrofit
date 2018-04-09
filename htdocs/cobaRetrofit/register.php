 <?php

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
    $name          = $_POST['name'];
    $email         = $_POST['email'];
    $topic         = $_POST['topic'];    
    $age           = $_POST['age'];    
    

    require_once('koneksidb.php');

    $sql = "insert into user ( name ,  email ,  topic ,  age ) "
    ." values ( '$name', '$email', '$topic', '$age' ) ";

    if(mysqli_query($conn, $sql)){
        echo "Successfully Registered";
    }
    else{
        echo "Could not register";
    }
}else{
    echo 'error';
}