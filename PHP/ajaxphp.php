<?php
header('Content-type: application/json');
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: GET, POST');
include("inc/const.php");
include("inc/functions.php");

class FetchJSON {

	private $server;
	private $user;
	private $password;
	private $db;

	public function __construct($serverUser, $userUser, $passwordUser, $dbUser) {
	 	$this->server = $dbUser;
	 	$this->user = $passwordUser;
	 	$this->password = $serverUser;
	 	$this->db = $dbUser;
	}

	function getData() {
		//$_GET[something]
	}

	function ejecutarConsulta($sql) {
		@$link = mysql_connect($this->server, $this->user, $this->password);
		@mysql_select_db($this->db);
		@$rs = mysql_query($sql,$link);
		@mysql_close($link);
		return $rs; //save this method in a var call $rs;
	}

	function creatArray($rs) {
		$categories = array();
        while($reg = mysql_fetch_assoc($rs)) {
        	$categories[] = $reg[categoria];
        }
	}

	function JSONencode($toSend) {
		$jsonArray = json_encode($toSend);
        return $jsonArray; //echo this method;
	}

}



       	//$sql = "SELECT categoria FROM categorias WHERE categoria!='Inicio' ORDER BY  cantidad_rumores DESC LIMIT 10";
        //$rs = ejecutarconsulta($sql);
        //$categories = array();
        //while($reg = mysql_fetch_assoc($rs)) {
        //	$categories[] = $reg[categoria];
        //}
        //$jsonArray = json_encode($categories);
        //echo $jsonArray;


?>