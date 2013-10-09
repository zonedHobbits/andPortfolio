<?php

function esUnMailValido($mail) {
	if(substr_count($mail,"@")!=1){
		return false;	
	}
	else {
		$partes = explode("@",$mail);
		$cuenta = $partes[0];
		$dominio = $partes[1];
		if(strlen($cuenta)<3) {
			return false;
		}
		if(substr_count($dominio,".")==0) {
			return false;
		}
		return true;
	}
}

function checkPass($pass) {
	if(empty ($pass)){
		return 1;
	}
	if(strlen($pass)<6) {
		return 2;
	}
	return 0;
}

function existeUsuario ($usuario) {
	@$link = mysql_connect(SERVER,USER,PASSWORD);
	@mysql_select_db(LABASE);
	$sql = "SELECT nombre FROM usuarios WHERE usuario='$usuario'";
	@$rs = mysql_query($sql,$link);
	@mysql_close($link);
	return (mysql_num_rows($rs)>0);
}

function existeRumor ($rumor) {
	@$link = mysql_connect(SERVER,USER,PASSWORD);
	@mysql_select_db(LABASE);
	$sql = "SELECT usuario FROM rumores WHERE rumor='$rumor'";
	@$rs = mysql_query($sql,$link);
	@mysql_close($link);
	return (mysql_num_rows($rs)>0);
}

//FUNCIONES QUE NO SE USAN
function existeRespuesta ($respuesta, $idPregunta) {
	@$link = mysql_connect(SERVER,USER,PASSWORD);
	@mysql_select_db(LABASE);
	$sql = "SELECT usuarioresponde FROM respuestas WHERE respuesta='$respuesta' AND idPregunta = '$idPregunta'";
	@$rs = mysql_query($sql,$link);
	@mysql_close($link);
	return (mysql_num_rows($rs)>0);
}

function contadorVisitas() {
	include("inc/const.php");
	if(file_exists(VISITAS)) {
		$cant = file_get_contents(VISITAS);
	}
	else {
		$cant = 0;
	}
	$cant++;
	file_put_contents(VISITAS,$cant);
	return "Sos el visitante numero: ".$cant;
}

//funcion para conectarme a MySQL
function ejecutarConsulta($sql) {
	@$link = mysql_connect(SERVER,USER,PASSWORD);
	@mysql_select_db(LABASE);
	@$rs = mysql_query($sql,$link);
	@mysql_close($link);
	return $rs; //si falla algo me devuelve falso, por eso apo los errores con @. Si es un SELECT me muestra los datos, si es un INSERT INTO, UPDATE o DELETE me devuelve un booleano
}

function recortar_texto($texto, $longitud = 180) { 
if((mb_strlen($texto) > $longitud)) { 
    $pos_espacios = mb_strpos($texto, ' ', $longitud) - 1; 
    if($pos_espacios > 0) { 
        $caracteres = count_chars(mb_substr($texto, 0, ($pos_espacios + 1)), 1); 
        if ($caracteres[ord('<')] > $caracteres[ord('>')]) { 
            $pos_espacios = mb_strpos($texto, ">", $pos_espacios) - 1; 
        } 
        $texto = mb_substr($texto, 0, ($pos_espacios + 1)).'...'; 
    } 
    if(preg_match_all("|(<([\w]+)[^>]*>)|", $texto, $buffer)) { 
        if(!empty($buffer[1])) { 
            preg_match_all("|</([a-zA-Z]+)>|", $texto, $buffer2); 
            if(count($buffer[2]) != count($buffer2[1])) { 
                $cierrotags = array_diff($buffer[2], $buffer2[1]); 
                $cierrotags = array_reverse($cierrotags); 
                foreach($cierrotags as $tag) { 
                        $texto .= '</'.$tag.'>'; 
                } 
            } 
        } 
    } 
 
} 
return $texto; 
} 

function diaRumor ($x) {
	date_default_timezone_set("America/Buenos_Aires");
	$hora = date("H");
	$minutos = date("i");
	$segundos = date("s");
	$dia = date(d);
	$mes = date(m);
	$fecha = explode("-",$x);
	$fecha2 = explode(" ",$fecha[2]);
	$fecha3 = explode(":", $fecha2[1]);
	$anoRumor = $fecha[0];
	$mesRumor = $fecha[1];
	$diaRumor = $fecha2[0];
	$horaRumor = $fecha3[0];
	$minutosRumor = $fecha3[1];
	$segundosRumor = $fecha3[2];
	if($mesRumor == $mes and $diaRumor == $dia) {
		//return "Hoy";
		if($hora == $horaRumor){
			if($minutos == $minutosRumor){
				if($segundos == $segundosRumor){
					return "Ahora";
				}
				else{
					$tiempo = $segundos-$segundosRumor;
					return "Hace ".$tiempo." segundos";
				}
			}
			else{
				$tiempo = $minutos-$minutosRumor;
				return "Hace ".$tiempo." minutos";
			}
		}
		else{
			$tiempo = $hora-$horaRumor;
			return "Hace ".$tiempo." horas";
		}
		
	}
	else if($mesRumor == $mes and $diaRumor == $dia-1) {
		return "Ayer";
	}
	else {
		return $diaRumor."/".$mesRumor."/".$anoRumor;
	}
}

	/* returns the shortened url */
function get_bitly_short_url($url,$login,$appkey,$format='txt') {
	$connectURL = 'http://api.bit.ly/v3/shorten?login='.$login.'&apiKey='.$appkey.'&uri='.urlencode($url).'&format='.$format;
	return curl_get_result($connectURL);
}

/* returns a result form url */
function curl_get_result($url) {
	$ch = curl_init();
	$timeout = 5;
	curl_setopt($ch,CURLOPT_URL,$url);
	curl_setopt($ch,CURLOPT_RETURNTRANSFER,1);
	curl_setopt($ch,CURLOPT_CONNECTTIMEOUT,$timeout);
	$data = curl_exec($ch);
	curl_close($ch);
	return $data;
}


?>