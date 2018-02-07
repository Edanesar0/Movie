<?php

class DatabaseConnection extends PDO
{

    private $dbname = "SmartTickets";
    private $host = "localhost";
    private $user = "postgres";
    private $password = "root";
    private $port = 5432;


    public function __construct()
    {
        try {
            parent::__construct("pgsql:host=$this->host;port=$this->port;dbname=$this->dbname;user=$this->user;password=$this->password");
            $this->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch (PDOException $e) {
            echo $e->getMessage();
        }

    }

    #get the number of rows in a result
    public function num_rows($query)
    {
        # create a prepared statement
        $stmt = parent::prepare($query);

        if ($stmt) {
            # execute query
            $stmt->execute();

            return $stmt->rowCount();
        } else {
            return self::get_error();
        }
    }

    #display error
    public function get_error()
    {
        $this->connection->errorInfo();
    }

    # closes the database connection when object is destroyed.
    public function __destruct()
    {
        $this->connection = null;
    }

    #get the number of rows in a result
    public function executeQuery($query)
    {
        # create a prepared statement
        $stmt = parent::prepare($query);

        if ($stmt) {
            # execute query
            $stmt->execute();

            return $stmt->fetchAll(PDO::FETCH_ASSOC);
        } else {
            return self::get_error();
        }
    }

    public function executeInsert($query)
    {
        # create a prepared statement
        $stmt = parent::prepare($query);

        if ($stmt) {
            # execute query
            $stmt->execute();

            return $stmt->rowCount();
        } else {
            return self::get_error();
        }
    }

}

?>