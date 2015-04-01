<?php


class SessionManagement {

    protected $userName;
    protected $password;

    protected $database;
    protected $user;     // stores the user data

    public function __construct(PDO $db, $userName, $password)
    {
        $this->database = $db;
        $this->userName = $userName;
        $this->password = $password;
    }

    public function login()
    {
        $user = $this->_checkCredentials();
        if ($user) {
            $this->user = $user; // store it so it can be accessed later
            //$_SESSION['user'] = $this->user;
            return $user;//$user['id'];
        }
        return false;
    }

    protected function _checkCredentials()
    {
        $stmt = $this->database->prepare('SELECT * FROM personel WHERE personelNo=?');
        $stmt->execute(array($this->userName));
        if ($stmt->rowCount() > 0) {
            $user = $stmt->fetch(PDO::FETCH_ASSOC);
            // $submitted_pass = sha1($user['salt'] . $this->_password);
            if ($this->password == $user['sifre']) {
                return $user;
            }
        }
        return false;
    }

    public function getUser()
    {
        return $this->_user;
    }

    /*if(mysql_num_rows($result) == 1)
    {
        $_SESSION["user"] = serialize(new User(mysql_fetch_assoc($result)));
        $_SESSION["login_time"] = time();
        $_SESSION["logged_in"] = 1;
        return true;
    }else{
        return false;
    }
}

//Log the user out. Destroy the session variables.
public function logout() {
    unset($_SESSION["user"]);
    unset($_SESSION["login_time"]);
    unset($_SESSION["logged_in"]);
    session_destroy();
}*/



}

