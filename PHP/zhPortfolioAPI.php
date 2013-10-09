<?php
header('Content-type: application/json');
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: GET, POST');

class FetchJSON {

        private $server;
        private $user;
        private $password;
        private $db;
        private $allProjects = array();


        public function __construct($serverUser, $userUser, $passwordUser, $dbUser) {
                $this->server = $serverUser;
                $this->user = $userUser;
                $this->password = $passwordUser;
                $this->db = $dbUser;
        }

        public function getData() {
                //$_GET[something]
        }

        function makeQuery($sql) {
                $link = mysql_connect($this->server, $this->user, $this->password);
                mysql_select_db($this->db);
                $rs = mysql_query($sql,$link);
                mysql_close($link);
                return $rs; //save this method in a var call $rs;
        }

        public function creatArray($rs, $projectsQuery) {
                $jsonObject = array();
                while($reg = mysql_fetch_assoc($rs)) {
                        $jsonObject["name"] = $reg[name];
                        $jsonObject["nick_name"] = $reg[nick_name];
                        $jsonObject["normal_img"] = $reg[normal_img];
                        $jsonObject["fun_img"] = $reg[fun_img];
                        $jsonObject["quote"] = $reg[quote];
                        $jsonObject["contact"]["bio"] = $reg[bio];
                        $jsonObject["contact"]["email"] = $reg[email];
                        $jsonObject["contact"]["twitter"] = $reg[twitter];
                        $jsonObject["contact"]["github"] = $reg[github];
                        $jsonObject["contact"]["phone"] = $reg[phone];
                        $jsonObject["contact"]["url"] = $reg[url];
                        //get the projects. $projectsQuery = "SELECT * FROM projects"
                        $rsProjects = $this -> makeQuery($projectsQuery);
                        //Creat a var to get the num of the project.
                        $numProject = 0;
                        while($reg = mysql_fetch_assoc($rsProjects)) {
                                //add one to the var.
                                $numProject++;
                                //check if we are in a new project.
                                if($reg[type] == "name") {
                                        //creat an array for one project.
                                        $project = array();
                                        $project[$reg[type]] = $reg[value];
                                }

                                else if($reg[type] == "finish") {
                                        //insert the project in the $jsonObject["projects"][$numProject] array.
                                        $jsonObject["projects"][$numProject] = $project;
                                }

                                //add types and values to the project array.
                                else $project[$reg[type]] = $reg[value];
                        }
                }
                return $jsonObject;
        }

        public function JSONencode($toSend) {
                $jsonArray = json_encode($toSend);
                return $jsonArray; //echo this method;
        }

}

$martin = new FetchJSON("localhost", "puertosu", "eo0Ir1Oc39", "puertosu_andPorfolio");
$rs = $martin -> makeQuery("SELECT * FROM userInfo");
$jsonObject = $martin -> creatArray($rs, "SELECT * FROM projects");
echo $martin -> JSONencode($jsonObject);

?>