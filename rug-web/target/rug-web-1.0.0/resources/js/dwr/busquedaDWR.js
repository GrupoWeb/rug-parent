function busquedaDwr(ruta, idPersona, tipoBusqueda, tipoTramite) {
	//displayLoader(true);
		
	var idGarantia = trim(getObject('idGarantia').value);
	var nombre = trim(getObject('nombreOtorgante').value);
	//var folioMercantil = trim(getObject('folioMercantil').value);
	var folioMercantil = '';
	var descGarantia = '';
	//var curpOtorgante = trim(getObject('curpOtorgante').value);
	var rfcOtorgante = trim(getObject('rfcOtorgante').value);
	var curpOtorgante = trim(getObject('curpOtorgante').value);
	var noSerial = trim(getObject('serial').value);
	
	//se resetean campos
	if(tipoBusqueda == 1){
		idGarantia = '';
		nombre = '';
	} else if(tipoBusqueda == 2){
		rfcOtorgante = '';
		curpOtorgante = '';
		noSerial = '';
	}
	
	if(!isBlank(idGarantia) || !isBlank(nombre) || !isBlank(folioMercantil) || !isBlank(noSerial) || !isBlank(curpOtorgante)|| !isBlank(rfcOtorgante)){
		BusquedaDwrAction.buscar(idPersona, noSerial, idGarantia, nombre, folioMercantil,descGarantia,curpOtorgante,rfcOtorgante , ruta, tipoTramite, escribeTablaBusqueda);
	} else {
		alert("Falta criterio de búsqueda.");
		//displayLoader(false);
	}
}

function certificacionDwr(ruta){
	var idGarantia = trim(getObject('idGarantia').value);
	
	if(!isBlank(idGarantia)) {
		BusquedaDwrAction.tramites(idGarantia, ruta, escribeTablaBusqueda);
	} else {
		alert("Falta criterio de búsqueda.");
	}
	
}

function pagBusquedaDwr(ruta,registroTotales,pagActiva,regPagina) {
	displayLoader(true);
	var idGarantia = trim(getObject('idGarantia').value);
	var nombre = trim(getObject('nombreOtorgante').value);
	//var folioMercantil = trim(getObject('folioMercantil').value);
	var folioMercantil = '';
	var descGarantia = '';
	//var curpOtorgante = trim(getObject('curpOtorgante').value);
	var rfcOtorgante = trim(getObject('rfcOtorgante').value);
	var curpOtorgante = trim(getObject('curpOtorgante').value);
	var noSerial = trim(getObject('serial').value);
	
	if(!isBlank(idGarantia) || !isBlank(nombre) || !isBlank(folioMercantil) || !isBlank(noSerial) || !isBlank(curpOtorgante)|| !isBlank(rfcOtorgante)){
		BusquedaDwrAction.pagBuscar(idGarantia, nombre, folioMercantil,noSerial,curpOtorgante,rfcOtorgante, ruta, registroTotales, pagActiva,'20', escribeTablaBusqueda);
	}
	else {
		alert("Falta criterio de búsqueda.");
		//displayLoader(false);
		}
}

function escribeTablaBusqueda(response){
	fillObject('resultadoDIV', response.message);
	//displayLoader(false);
}

function escribeTablaOtorgantesPrevios(response){
	fillObject('resultadoOtorgantesPrevios', response.message);
}