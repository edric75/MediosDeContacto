$(document).ready(function () {


    var isIE = !!document.documentMode;

    if (isIE) {
        $("#boton1").addClass("aumento");
        $("#boton2").addClass("aumento");
    }

    var rfc = $('#rfcV').val();
    if (rfc.trim().length == 12) {
        $('#apaGuion').val('-');
        $('#amaGuion').val('-');
    }
});
function regresarF() {
    var x = location.href;
    var url = x.split('/');
    var a = url[0] + "//" + url[2] + "/" + url[3] + "/index.jsp";
    location.href = a;

}
function functionocultar6() {

    $('#datosGenerales').removeClass('ocultar');

    $('#autentifica').addClass('ocultar');
    $('#regimen').addClass('ocultar');
    $('#email').addClass('ocultar');
    $('#telefono').addClass('ocultar');

    $('#boton1').addClass('bordeBoton');
    $('#boton2').removeClass('bordeBoton');
    $('#boton3').removeClass('bordeBoton');
    $('#boton4').removeClass('bordeBoton');
    $('#boton5').removeClass('bordeBoton');

}
function functionocultar7() {
    $('#autentifica').removeClass('ocultar');

    $('#datosGenerales').addClass('ocultar');
    $('#regimen').addClass('ocultar');
    $('#email').addClass('ocultar');
    $('#telefono').addClass('ocultar');

    $('#boton2').addClass('bordeBoton');
    $('#boton1').removeClass('bordeBoton');
    $('#boton3').removeClass('bordeBoton');
    $('#boton4').removeClass('bordeBoton');
    $('#boton5').removeClass('bordeBoton');

    if($("#boton2").attr("data-status") == 0){
        autentificacionServlet();
    }

}
function functionocultar8() {

    $('#regimen').removeClass('ocultar');

    $('#datosGenerales').addClass('ocultar');
    $('#autentifica').addClass('ocultar');
    $('#email').addClass('ocultar');
    $('#telefono').addClass('ocultar');

    $('#boton3').addClass('bordeBoton');
    $('#boton1').removeClass('bordeBoton');
    $('#boton2').removeClass('bordeBoton');
    $('#boton4').removeClass('bordeBoton');
    $('#boton5').removeClass('bordeBoton');

    if($("#boton3").attr("data-status") == 0){
    	regimenServlet();
    }
    

}
function functionocultar9() {

    $('#email').removeClass('ocultar');

    $('#datosGenerales').addClass('ocultar');
    $('#autentifica').addClass('ocultar');
    $('#regimen').addClass('ocultar');
    $('#telefono').addClass('ocultar');

    $('#boton4').addClass('bordeBoton');
    $('#boton1').removeClass('bordeBoton');
    $('#boton2').removeClass('bordeBoton');
    $('#boton3').removeClass('bordeBoton');
    $('#boton5').removeClass('bordeBoton');

    if($("#boton4").attr("data-status") == 0){
        emailServlet();
    }
   
}
function functionocultar10() {

    $('#telefono').removeClass('ocultar');

    $('#datosGenerales').addClass('ocultar');
    $('#autentifica').addClass('ocultar');
    $('#regimen').addClass('ocultar');
    $('#email').addClass('ocultar');

    $('#boton5').addClass('bordeBoton');
    $('#boton1').removeClass('bordeBoton');
    $('#boton2').removeClass('bordeBoton');
    $('#boton3').removeClass('bordeBoton');
    $('#boton4').removeClass('bordeBoton');

    if($("#boton5").attr("data-status") == 0){
    	telefonoServlet();
    }

}

function validacionF(rfc, curp, email) {
    var letras = "";
    if (rfc.length > 0) {
        letras = rfc;
    } else if (curp.length > 0) {
        letras = curp;
    } else if (email.length > 0) {
        letras = email;
    }
    var parts = letras.split("");
    var validacion = false;

    for (var i = 0; i <= letras.length; i++) {
        switch (parts[i]) {
            case "*":
                validacion = true;
                break;
            case "<":
                validacion = true;
                break;
            case ">":
                validacion = true;
                break;
            case "/":
                validacion = true;
                break;
            case "[":
                validacion = true;
                break;
            case "]":
                validacion = true;
                break;
            case "^":
                validacion = true;
                break;
            case "%":
                validacion = true;
                break;
            case "$":
                validacion = true;
                break;
            case "#":
                validacion = true;
                break;
            case "":
                validacion = true;
                break;
        }
    }
    if (validacion === false) {
        return false;
    } else {
        return true;
    }

}

function autentificacionServlet() {
  
    var rfcV = $("#rfcV").val();
    var curpV = $("#curpV").val();
    var emailV = $("#emailV").val();

  	$('#spinerAutentificacion').fadeIn();
  	
    var validacionFF = validacionF(rfcV, curpV, emailV);
    if (validacionFF === false ) {
        var x = 0;
        $.ajax({
            url: '../../AutenticacionServlet',
            data: {rfc: rfcV, curp: curpV, email: emailV},
            type: 'POST',
            dataType: 'text',
            success: function (respJson) {
            	try {
                    var data = JSON.parse(respJson); 
                    if (data.hasOwnProperty('dataAutenticacion')) {                	  
                  	  if(data.dataAutenticacion.length>0){
                  		  var fechaDWH = data.dataAutenticacion[0].fechaDWH.split(" "); 
                  		  var uniqueAutenticacion = removeDuplicatedAutenticacion(data.dataAutenticacion);
                          let myTable = "<table id='autenticacionTable' class='table-striped table-bordered' style='width:97%'><thead><tr> <div style='text-align: right; padding: 0% 1% 0% 0%;display:none'>Fecha registro DWH:" + formatDate(fechaDWH[0]) + " </div> <td>Nro.</td>";
                          myTable += "<td>Autentificación</td></tr>  </thead><tbody>";
                          var nRecord = 0;
                              for(var i=0;i<uniqueAutenticacion.length;i++){
                            	  nRecord++;
                              	myTable += "<tr><td>" + nRecord + "</td>";
                              	myTable += "<td>" + uniqueAutenticacion[i].autenticacion + "</td>";
                                	myTable += "</tr>";
                              }
                              myTable += "</tbody></table>";
                            document.getElementById('tablePrint2').innerHTML = myTable;
                            $("#autenticacionTable td").each(function() {
                          	  if (this.textContent == "null") this.textContent = "-"
                          	})
                          	generateDataTable('autenticacionTable');
                  	  }else{
                            let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existen datos de Autenticación</h3></center></div>";
                            document.getElementById('tablePrint2').innerHTML = myTable;
                  	  }         	
                    }else{
                  	 console.log(respJson);
                      let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existen datos de Autenticación</h3></center></div>";
                      document.getElementById('tablePrint2').innerHTML = myTable;
                    } 
                	  $("#boton2").attr("data-status",1);         
                }catch(e){
                	 if(respJson =""){
                       	 console.log(e);            	  
                      	 console.log(respJson);              		 
                      	document.getElementById('tablePrint2').innerHTML ="<div padding: 0% 0% 0% 39%;><center><h3>Error al leer la respuesta</h3></center></div>";              		 
                  	 }else{
                  		document.getElementById('tablePrint2').innerHTML = "<div padding: 0% 0% 0% 39%;><center><h3>Sesi&oacute;n expirada</h3></center></div>";
                  	 }
               	  
                 }                  
                   
          	  	$('#tablePrint2').show();
          	  	$('#spinerAutentificacion').fadeOut();

            }
        });
    } else {
        $('#tautenborrar').addClass('ocultar');
        let myTable = "<div padding: 0% 0% 0% 39%;><h3>No existen datos de Autenticación</h3></div>";
        document.getElementById('tablePrint2').innerHTML = myTable;
  	  	$('#tablePrint2').show();
  	  	$('#spinerAutentificacion').fadeOut();
    }

}
function regimenServlet() {
    var rfcV = $("#rfcV").val();
    var curpV = $("#curpV").val();
    var emailV = $("#emailV").val();

    $('#spinerRegimen').fadeIn();
    var validacionFF = validacionF(rfcV, curpV, emailV);
    if (validacionFF === false ) {
        var x = 0;
        $.ajax({
            url: '../../RegimenServlet',
            data: {rfc: rfcV, curp: curpV, email: emailV},
            type: 'POST',
            dataType: 'text',
            success: function (respJson) {
              try {
                  var data = JSON.parse(respJson); 
                  if (data.hasOwnProperty('dataRegimen')) {                	  
                	  if(data.dataRegimen.length>0){
                		  var fechaDWH = data.dataRegimen[0].fechaDWH.split(" "); 
                		  var countRegimen = 1;
                  		  var current_date = new Date();
                		  var uniqueRegimen = removeDuplicatedRegimen(data.dataRegimen);
                    	  let myTable = "<table id='regimenTable' class='table-striped table-bordered' style='width:97%'><thead><tr><div style='text-align: right; padding: 0% 1% 0% 0%;display:none'>Fecha registro DWH:" + formatDate(fechaDWH[0]) + " </div><td>Nro.</td><td>Clave Régimen</td>";
                          myTable += "<td>Descripción de Régimen</td> <td>Fecha de alta Régimen</td> <td>Fecha de baja Régimen</td> <td>Fecha efectiva alta</td> <td>Fecha efectiva baja</td><td>Estatus</td> </tr></thead>";                        
                           var status = "-";

                          
                          for(var i=0;i<uniqueRegimen.length;i++){
                        	  	if(uniqueRegimen[i].fechaBajaRegimen === null){
                        	  		status = "ACTIVO";
                        	  	}else{
                          		  fechaVigencia = new Date(uniqueRegimen[i].fechaBajaRegimen);
                        		  if(current_date.getTime() >  fechaVigencia.getTime())
                            	  {
                        			  status = "INACTIVO";
                            	  }else{
                            		  status = "ACTIVO";
                            	  }
                        	  	}
                        	                    	  
                        	  
                            	myTable += "<tr><td>"+ (countRegimen++) +"</td>";                            	
                            	myTable += "<td>" + uniqueRegimen[i].idRegimen + "</td>";
                            	myTable += "<td>" + uniqueRegimen[i].regimen + "</td>";
                              	myTable += "<td>" + formatDate(uniqueRegimen[i].fechaAltaRegimen) + "</td>";
                              	myTable += "<td>" + formatDate(uniqueRegimen[i].fechaBajaRegimen) + "</td>";
                              	myTable += "<td>" + formatDate(uniqueRegimen[i].fechaEfectivaAlta) + "</td>";
                              	myTable += "<td>" + formatDate(uniqueRegimen[i].fechaRegistroBaja) + "</td>";
                              	myTable += "<td>"+ status +"</td>";                              	
                              	myTable += "</tr>";
                            }
                            myTable += "</table>";
                          document.getElementById('tablePrint').innerHTML = myTable;
                          $("#regimenTable td").each(function() {
                        	  if (this.textContent == "null") this.textContent = "-"
                        	})

                        	generateDataTable("regimenTable");

                	  }else{
                          let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existe información de Régimen</h3></center></div>";
                          document.getElementById('tablePrint').innerHTML = myTable;
                	  }
                	
                  }else{
                	 console.log(respJson);
                    let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existe información de Régimen</h3></center></div>";
                    document.getElementById('tablePrint').innerHTML = myTable;
                  }      
                  $("#boton3").attr("data-status",1);
              }catch(e){
              	 if(respJson =""){
                   	 console.log(e);            	  
                  	 console.log(respJson);              		 
                  	document.getElementById('tablePrint').innerHTML ="<div padding: 0% 0% 0% 39%;><center><h3>Error al leer la respuesta</h3></center></div>";              		 
              	 }else{
              		document.getElementById('tablePrint').innerHTML = "<div padding: 0% 0% 0% 39%;><center><h3>Sesi&oacute;n expirada</h3></center></div>";
              	 }
                 $('#spinerRegimen').fadeOut();
                 $('#tablePrint').show();
             	  
               }                  
                             
            $('#spinerRegimen').fadeOut();
            $('#tablePrint').show();
            
            }
        });
    } else {
        let myTable = "<div padding: 0% 0% 0% 39%;><h3>No existe información de Régimen</h3></div>";
        document.getElementById('tablePrint').innerHTML = myTable;
        $('#spinerRegimen').fadeOut();
        $('#tablePrint').show();
    }
}

function formatDate (input) {
		if(input!=null){
			  var datePart = input.match(/\d+/g),
			  year = datePart[0].substring(0), // get only two digits
			  month = datePart[1], day = datePart[2];
			  return day+'-'+month+'-'+year;
		}else{
			return "-";
		}

}

function emailServlet() {
    var rfcV = $("#rfcV").val();
    var curpV = $("#curpV").val();
    var emailV = $("#emailV").val();

    $('#spinerInfoEMail').fadeIn();
    var validacionFF = validacionF(rfcV, curpV, emailV);
    if (validacionFF === false ) {
        $.ajax({
            url: '../../EmailServlet',
            data: {rfc: rfcV, curp: curpV, email: emailV},
            type: 'POST',
            dataType: 'text',
            success: function (respJson) {
                try {
                    var data = JSON.parse(respJson); 
                    if (data.hasOwnProperty('dataEmail')) {                	  
                  	  if(data.dataEmail.length>0){
                  		  var fechaDWH = data.dataEmail[0].fechaDWH.split(" "); 
                  		  var uniqueEmail = removeDuplicatedEmail(data.dataEmail);
                  		  var countEmail = 1;
                  		  var countAplicativo = 0;
                  		  var current_date = new Date();

                          let myTable = "<table id='emailTable' class='display compact table-striped table-bordered'><thead><tr>" +"<div style='text-align: right; padding: 0% 1% 0% 0%; display:none'>Fecha registro DWH:" +formatDate(fechaDWH[0]) + " </div>" +"<td>Nro.</td><td>Email</td>" +
                          				  "<td>Email DQ</td>" +
				                          "<td>Email principal</td>" +
				                          "<td>Fecha de registro</td>" +
				                          "<td>Estatus</td>" +
				                          "<td>Aplicativo</td>" +
				                          "<td>Fecha registro aplicativo</td>" +
				                          "<td>Fecha inicio vigencia</td>" +
				                          "<td>Fecha fin vigencia</td>" +
				                          "<td>Fecha baja</td>" +
				                          "<td>Estatus aplicativo</td>";
                          		myTable += "</tr>  </thead><tbody>";
                  
                              for(var i=0;i<uniqueEmail.length;i++){
                            	  var fechaRegistro = '-'
                                  var fechaVigencia = '';
                            	  var status = "-";
                            	  if(uniqueEmail[i].fechaRegistroAplicativo != null){
                            		  var split = uniqueEmail[i].fechaRegistroAplicativo.split(" ");
                            		  fechaRegistro = formatDate(split[0]);
                            	  }
                            	  if(uniqueEmail[i].fechaFinVigencia === null){
                          	  		status = "ACTIVO";
                          	  	}else{
                            		  fechaVigencia = new Date(uniqueEmail[i].fechaFinVigencia);
                          		  if(current_date.getTime() >  fechaVigencia.getTime())
                              	  {
                          			  status = "INACTIVO";
                              	  }else{
                              		  status = "ACTIVO";
                              	  }
                          	  	}
                            	  
                            	
                            	    myTable += "<tr><td>" + (countEmail++) + "</td>";
                              	    myTable += "<td>" + uniqueEmail[i].email + "</td>";
                                 	myTable += "<td>" + uniqueEmail[i].emailDq + "</td>";
                                	myTable += "<td>" + uniqueEmail[i].emailPrincipal + "</td>";
                                	myTable += "<td>" + formatDate(uniqueEmail[i].fechaRegistro) + "</td>";
                                	myTable += "<td>" + status + "</td>";
                                	myTable += "<td>" + uniqueEmail[i].aplicativo + "</td>";
                                	myTable += "<td>" + fechaRegistro + "</td>";
                                	myTable += "<td>" + formatDate(uniqueEmail[i].fechaInicioVigencia) + "</td>";
                                	myTable += "<td>" + formatDate(uniqueEmail[i].fechaFinVigencia) + "</td>";
                                	myTable += "<td>" + formatDate(uniqueEmail[i].fechaBaja) + "</td>";
                                	myTable += "<td>" + (uniqueEmail[i].estatusAplicativo) + "</td>";
                                	myTable += "</tr>";
                                	
                              }
                              myTable += "</tbody></table>";
                            document.getElementById('tablePrint3').innerHTML = myTable;
                            $("#emailTable td").each(function() {
                            	  if (this.textContent == "null") this.textContent = "-"
                            	})
                            generateDataTable("emailTable");     
                            findGoldenRecordEmail(uniqueEmail);
                         
                  	  }else{

                            let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existe información de Email</h3></center></div>";
                            document.getElementById('tablePrint3').innerHTML = myTable;
                  	  }
                  	
                    }else{
                  	console.log(respJson);
                      let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existe información de Email</h3></center></div>";
                      document.getElementById('tablePrint3').innerHTML = myTable;
                    }                  
                }catch(e){
                	 if(respJson =""){
                       	 console.log(e);            	  
                      	 console.log(respJson);              		 
                      	document.getElementById('tablePrint3').innerHTML ="<div padding: 0% 0% 0% 39%;><center><h3>Error al leer la respuesta</h3></center></div>";              		 
                  	 }else{
                  		document.getElementById('tablePrint3').innerHTML = "<div padding: 0% 0% 0% 39%;><center><h3>Sesi&oacute;n expirada</h3></center></div>";
                  	 }
                   $('#spinerInfoEMail').fadeOut();
                   $('#tablePrint3').show();
               	  
                 }                  
              
                $('#spinerInfoEMail').fadeOut();
                $('#tablePrint3').show();
       }
      })
    } else {
        let myTable = "<h3  style='padding: 0% 0% 0% 39%;'>No existe información de Email</h3>";
        document.getElementById('tablePrint3').innerHTML = myTable;
        $('#spinerInfoEMail').fadeOut();
        $('#tablePrint3').show();
    }
    
    EmailVerificacionServlet();
}

function EmailVerificacionServlet() {
    var rfcV = $("#rfcV").val();
    var curpV = $("#curpV").val();
    var emailV = $("#emailV").val();

    $('#spinerInfoVEMail').fadeIn();
    var validacionFF = validacionF(rfcV, curpV, emailV);
    if (validacionFF === false ) {
        var x = 0;
        $.ajax({
            url: '../../EmailVerificacionServlet',
            data: {rfc: rfcV, curp: curpV, email: emailV},
            type: 'POST',
            dataType: 'text',
            success: function (respJson) {
                try {
                    var data = JSON.parse(respJson); 
                    if (data.hasOwnProperty('dataVerificacionEmail')) {                	  
                  	  if(data.dataVerificacionEmail.length>0){
                  		  var countVerificacionEmail = 1;
                  		  var fechaDWH = data.dataVerificacionEmail[0].fechaDWH.split(" "); 
                  		  var uniqueEmailVer = removeDuplicatedEmail(data.dataVerificacionEmail);
                  		  var filasVacias = 0;
                  		  var numFilas = uniqueEmailVer.length;
                  		  
                  		let myTable = "<table id='verificacionEmailTable' class='display compact table-striped table-bordered'><thead><tr>" +
				                        "<div style='text-align: right; padding: 0% 1% 0% 0%;display:none'>Fecha registro DWH:" + formatDate(fechaDWH[0]) + " </div>" +
				                        "<td>Nro.</td>" +				                        
				                        "<td>Email</td>" +
				                        "<td>Envió verificación</td>" +
				                        "<td>Fecha envió verificación</td>" +
				                        "<td>Fecha verificación</td>" +
				                        "<td>Estatus verificación</td>" +
				                        "<td>Causa no verificado</td>";
			                myTable += "</tr>  </thead><tbody>";
			                
                              for(var i=0;i<uniqueEmailVer.length;i++){
                            	  	
                            	  	if(uniqueEmailVer[i].envioVerificacion == null && uniqueEmailVer[i].fechaEnvioVerificacion == null && uniqueEmailVer[i].fechaVerificacion == null && uniqueEmailVer[i].estatusVerificacion == null && uniqueEmailVer[i].causaNoVerificADA == null){
                            	  		filasVacias++;
                            	  	}
                                	myTable += "<tr><td>" + (countVerificacionEmail++) + "</td>";                            	  
                                	myTable += "<td>" + uniqueEmailVer[i].email + "</td>";
                                	myTable += "<td>" + uniqueEmailVer[i].envioVerificacion + "</td>";
                                	myTable += "<td>" + formatDate(uniqueEmailVer[i].fechaEnvioVerificacion) + "</td>";
                                	myTable += "<td>" + formatDate(uniqueEmailVer[i].fechaVerificacion) + "</td>";
                                	myTable += "<td>" + uniqueEmailVer[i].estatusVerificacion + "</td>";
                                	myTable += "<td>" + uniqueEmailVer[i].causaNoVerificADA + "</td>";
                                	myTable += "</tr>";
                              }
                              myTable += "</tbody></table>";
                              
                              if(filasVacias < numFilas){
                            	  document.getElementById('tablePrint4').innerHTML = myTable;
                                  $("#verificacionEmailTable td").each(function() {
                                	  if (this.textContent == "null") this.textContent = "-"
                                  })                                	
                                  generateDataTable("verificacionEmailTable");   
                              }else{
                            	  let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existe información de verificación</h3></center></div>";
                                  document.getElementById('tablePrint4').innerHTML = myTable;
                              }
                                   
                            
                  	  }else{
                            let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existe información de verificación</h3></center></div>";
                            document.getElementById('tablePrint4').innerHTML = myTable;
                  	  }
                  	
                    }else{
                  	 console.log(respJson);
                      let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existe información de verificación</h3></center></div>";
                      document.getElementById('tablePrint4').innerHTML = myTable;
                    }                  
                }catch(e){
                	if(respJson =""){
                      	 console.log(e);            	  
                     	 console.log(respJson);              		 
                     	document.getElementById('tablePrint4').innerHTML ="<div padding: 0% 0% 0% 39%;><center><h3>Error al leer la respuesta</h3></center></div>";              		 
                 	 }else{
                 		document.getElementById('tablePrint4').innerHTML = "<div padding: 0% 0% 0% 39%;><center><h3>Sesi&oacute;n expirada</h3></center></div>";
                 	 }
                   $('#spinerInfoVEMail').fadeOut();
                   $('#tablePrint4').show();
               	  
                 }                  
            
                $('#spinerInfoVEMail').fadeOut();
                $('#tablePrint4').show();

            }
            
        });
    } else {
        let myTable = "<h3  style='padding: 0% 0% 0% 39%;'>No existe información de verificación</h3>";
        document.getElementById('tablePrint4').innerHTML = myTable;
        $('#spinerInfoVEMail').fadeOut();
        $('#tablePrint4').show();

    }
    
    
    EmailAcuseServlet();
}
function EmailAcuseServlet() {
    var rfcV = $("#rfcV").val();
    var curpV = $("#curpV").val();
    var emailV = $("#emailV").val();

    $('#spinerAcuseEMail').fadeIn();

    var validacionFF = validacionF(rfcV, curpV, emailV);
    if (validacionFF === false ) {
        var x = 0;
        $.ajax({
            url: '../../EmailAcuseServlet',
            data: {rfc: rfcV, curp: curpV, email: emailV},
            type: 'POST',
            dataType: 'text',
            success: function (respJson) {
                try {
                    var data = JSON.parse(respJson); 
                    if (data.hasOwnProperty('dataAcuseEmail')) {                	  
                  	  if(data.dataAcuseEmail.length>0){
                  		  var fechaDWH = data.dataAcuseEmail[0].fechaDWH.split(" "); 
                  		  var countAcuseEmail = 1;
                  		 var filasVacias = 0;
                  	      var numFilas = data.dataAcuseEmail.length;
                  		  let myTable = "<table id='AcuseMailTable' class='display compact table-striped table-bordered'><thead><tr> <div style='text-align: right; padding: 0% 1% 0% 0%;display:none'>Fecha registro DWH:" + formatDate(fechaDWH[0]) + " </div>";
                  		  	  myTable += "<td>Nro.</td>";                  		  
                  		      myTable += "<td>Email</td>";
                  		      myTable += "<td>Fecha de emisión</td>" ;
                  		      myTable  +="<td>Cadena acuse</td>" ;
                  		      myTable += "<td>Forlio acuse</td>";
                  		  	  myTable += "</tr>  </thead><tbody>";
			                
                              for(var i=0;i<data.dataAcuseEmail.length;i++){
                            	  if(data.dataAcuseEmail[i].fechaEmision == null && data.dataAcuseEmail[i].cadenaAcuse == null && data.dataAcuseEmail[i].folioAcuse == null){
                            	         filasVacias++;
                            	  }
                            	  myTable += "<tr><td>" + (countAcuseEmail++) + "</td>";                            	  
                              	myTable += "<td>" + data.dataAcuseEmail[i].email + "</td>";
                              	myTable += "<td>" + data.dataAcuseEmail[i].fechaEmision + "</td>";
                                	myTable += "<td>" + data.dataAcuseEmail[i].cadenaAcuse + "</td>";
                                	myTable += "<td>" + data.dataAcuseEmail[i].folioAcuse + "</td>";
                                	myTable += "</tr>";
                              }
                              myTable += "</tbody></table>";        
                              
                              if(filasVacias < numFilas){ 
                            document.getElementById('tablePrint5').innerHTML = myTable;
                            $("#AcuseMailTable td").each(function() {
                            	  if (this.textContent == "null") this.textContent = "-"
                            	})
                            	generateDataTable("AcuseMailTable");  
                              }else{
                            	  let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existe información de Acuse</h3></center></div>";
                                  document.getElementById('tablePrint4').innerHTML = myTable;
                              }
                  	  }else{
                            let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existe información de Acuse</h3></center></div>";
                            document.getElementById('tablePrint5').innerHTML = myTable;
                  	  }
                  	
                    }else{
                      let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existe información de Acuse</h3></center></div>";
                      document.getElementById('tablePrint5').innerHTML = myTable;
                    }                

                    $("#boton4").attr("data-status",1);
                }catch(e){
                	if(respJson =""){
                     	 console.log(e);            	  
                    	 console.log(respJson);              		 
                    	document.getElementById('tablePrint5').innerHTML ="<div padding: 0% 0% 0% 39%;><center><h3>Error al leer la respuesta</h3></center></div>";              		 
                	 }else{
                		document.getElementById('tablePrint5').innerHTML = "<div padding: 0% 0% 0% 39%;><center><h3>Sesi&oacute;n expirada</h3></center></div>";
                	 }
                   $('#spinerAcuseEMail').fadeOut();
                   $('#tablePrint5').show();
               	  
                 }     
                $('#spinerAcuseEMail').fadeOut();
                $('#tablePrint5').show();
            }
            
        });
    } else {
        let myTable = "<h3  style='padding: 0% 0% 0% 39%;'>No existe información de Acuse</h3>";
        document.getElementById('tablePrint5').innerHTML = myTable;
        $('#spinerAcuseEMail').fadeOut();
        $('#tablePrint5').show();


    }
}

function telefonoServlet() {
    var rfcV = $("#rfcV").val();
    var curpV = $("#curpV").val();
    var emailV = $("#emailV").val();
    $('#spineraInfoTelefono').fadeIn();
    var validacionFF = validacionF(rfcV, curpV, emailV);
    if (validacionFF === false ) {
        var x = 0;
        $.ajax({
            url: '../../TelefonoServlet',
            data: {rfc: rfcV, curp: curpV, email: emailV},
            type: 'POST',
            dataType: 'text',
            success: function (respJson) {
            	try {
                    var data = JSON.parse(respJson); 
                    if (data.hasOwnProperty('dataTelefono')) {                	  
                  	  if(data.dataTelefono.length>0){
                  		  var countTelefono = 1;
                  		  var fechaDWH = data.dataTelefono[0].fechaDWH.split(" "); 
                  		  var uniqueTelefono = removeDuplicatedTelefono(data.dataTelefono);
                  		  var current_date = new Date();
                          let myTable = "<table id='telefonoTable' class='display compact table-striped table-bordered'><thead><tr>" +
                          "<div style='text-align: right; padding: 0% 1% 0% 0%;display:none'>Fecha registro DWH:" + formatDate(fechaDWH[0]) + " </div>" +
                          "<td>Nro.</td>" +
                          "<td>Teléfono</td>" +
                          "<td>Teléfono DQ</td>" +
                          "<td>Teléfono principal</td>" +
                          "<td>Fecha registro</td>" +
                          "<td>Estatus</td>" +
                          "<td>Aplicativo</td>" +
                          "<td>Fecha registro aplicativo</td>" +
                          "<td>Fecha inicio vigencia</td>" +
                          "<td>Fecha fin vigencia</td>" +
                          "<td>Fecha baja</td>" +
                          "<td>Estatus aplicativo</td>";
		                  myTable += "</tr>  </thead><tbody>";

                  		  
                              for(var i=0;i<uniqueTelefono.length;i++){
                            	  var fechaVigencia = '';
                            	  var status = "-";
                            	  
                            	  if(uniqueTelefono[i].fechaFinVigencia === null){
                          	  		status = "ACTIVO";
                          	  	}else{
                            		  fechaVigencia = new Date(uniqueTelefono[i].fechaFinVigencia);
                          		  if(current_date.getTime() >  fechaVigencia.getTime())
                              	  {
                          			  status = "INACTIVO";
                              	  }else{
                              		  status = "ACTIVO";
                              	  }
                          	  	}
                            	  
                            	  	myTable += "<tr><td>" + (countTelefono++) + "</td>";                            	  
                              		myTable += "<td>" + uniqueTelefono[i].telefono + "</td>";
                              		myTable += "<td>" + uniqueTelefono[i].telefonoDq + "</td>";
                                	myTable += "<td>" + uniqueTelefono[i].telefonoPrincipal + "</td>";
                                	myTable += "<td>" + formatDate(uniqueTelefono[i].fechaRegistro) + "</td>";
                                	myTable += "<td>" + status + "</td>";
                                	myTable += "<td>" + uniqueTelefono[i].aplicativo + "</td>";
                                	myTable += "<td>" + formatDate(uniqueTelefono[i].fechaRegistroAplicativo) + "</td>";
                                	myTable += "<td>" + formatDate(uniqueTelefono[i].fechaInicioVigencia) + "</td>";
                                	myTable += "<td>" + formatDate(uniqueTelefono[i].fechaFinVigencia) + "</td>";                                	
                                	myTable += "<td>" + formatDate(uniqueTelefono[i].fechaBaja) + "</td>";    
                                	myTable += "<td>" + uniqueTelefono[i].estatusAplicativo + "</td>";                                	
                                	myTable += "</tr>";
                                	
                                	
                              }
                              myTable += "</tbody></table>";
                            document.getElementById('tablePrint6').innerHTML = myTable;
                            $("#telefonoTable td").each(function() {
                          	  if (this.textContent == "null") this.textContent = "-"
                          	})
                        	generateDataTable("telefonoTable");   
                            findGoldenRecordTelefono(uniqueTelefono);

                  	  }else{
                            let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existe información de Teléfono</h3></center></div>";
                            document.getElementById('tablePrint6').innerHTML = myTable;
                  	  }
                  	
                    }else{
                  	 console.log(respJson);
                      let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existe información de Teléfono</h3></center></div>";
                      document.getElementById('tablePrint6').innerHTML = myTable;
                    }                  
                }catch(e){
                	if(respJson =""){
                     	 console.log(e);            	  
                    	 console.log(respJson);              		 
                    	document.getElementById('tablePrint6').innerHTML ="<div padding: 0% 0% 0% 39%;><center><h3>Error al leer la respuesta</h3></center></div>";              		 
                	 }else{
                		document.getElementById('tablePrint6').innerHTML = "<div padding: 0% 0% 0% 39%;><center><h3>Sesi&oacute;n expirada</h3></center></div>";
                	 }
                   $('#spineraInfoTelefono').fadeOut();
                   $('#tablePrint6').show();

                 }
                $('#spineraInfoTelefono').fadeOut();
                $('#tablePrint6').show();

                   
            }
        });
    } else {
         let myTable = "<h3  style='padding: 0% 0% 0% 39%;'>No existe información de Teléfono</h3>";
         document.getElementById('tablePrint6').innerHTML = myTable;
        $('#spineraInfoTelefono').fadeOut();
        $('#tablePrint6').show();
        
    }
    verificacionTelefono();

}
function verificacionTelefono() {
    var rfcV = $("#rfcV").val();
    var curpV = $("#curpV").val();
    var emailV = $("#emailV").val();

	  $('#spinerVeriTelefono').fadeIn();
    var validacionFF = validacionF(rfcV, curpV, emailV);
    if (validacionFF === false ) {
        var x = 0;
        $.ajax({
            url: '../../VerificacionTelefonoServlet',
            data: {rfc: rfcV, curp: curpV, email: emailV},
            type: 'POST',
            dataType: 'text',
            success: function (respJson) {
            	try {
                    var data = JSON.parse(respJson); 
                    if (data.hasOwnProperty('dataVerificacionTelefono')) {                	  
                  	  if(data.dataVerificacionTelefono.length>0){
                  		  var fechaDWH = data.dataVerificacionTelefono[0].fechaDWH.split(" "); 
                  		  var countVerificacionTel = 1;
                  		  var uniqueVerTelefono = removeDuplicatedTelefono(data.dataVerificacionTelefono);
                  		  var filasVacias = 0;
                 	      var numFilas = uniqueVerTelefono.length;                  		  
                          let myTable = "<table id='verificacionTelTable' class='display compact table-striped table-bordered'><thead><tr>" +
                          "<div style='text-align: right; padding: 0% 1% 0% 0%;display:none'>Fecha registro DWH:" + formatDate(fechaDWH[0]) + " </div>" +
                          "<td>Nro.</td>" +                          
                          "<td>Teléfono</td>" +
                          "<td>Envió verificación</td>" +
                          "<td>Fecha envió verificación</td>" +
                          "<td>Fecha verificación</td>" +
                          "<td>Estatus verificación</td>" +
                          "<td>Causa no verificado</td></thead>";

                              for(var i=0;i<uniqueVerTelefono.length;i++){
                                	myTable += "<tr><td>" + (countVerificacionTel++) + "</td>";
                                	myTable += "<td>" + uniqueVerTelefono[i].telefono + "</td>";
                                	myTable += "<td>" + uniqueVerTelefono[i].envioVerificacion + "</td>";
                                	myTable += "<td>" + formatDate(uniqueVerTelefono[i].fechaEnvioVerificacion) + "</td>";
                                	myTable += "<td>" + formatDate(uniqueVerTelefono[i].fechaVerificacion) + "</td>";
                                	myTable += "<td>" + uniqueVerTelefono[i].estatus + "</td>";
                                	myTable += "<td>" + uniqueVerTelefono[i].causaNoVerificado + "</td>";
                                	myTable += "</tr>";
                                	if(uniqueVerTelefono[i].envioVerificacion == null && uniqueVerTelefono[i].fechaEnvioVerificacion == null && uniqueVerTelefono[i].fechaVerificacion == null && uniqueVerTelefono[i].estatusVerificacion == null && uniqueVerTelefono[i].causaNoVerificADA == null){
                                        filasVacias++;
                                     }
                              }
                              myTable += "</tbody></table>";
                              
                              if(filasVacias < numFilas){
                            	  document.getElementById('tablePrint7').innerHTML = myTable;
                                  $("#verificacionTelTable td").each(function() {
                                  	  if (this.textContent == "null") this.textContent = "-"
                                  	})
                                  	
                                  	generateDataTable("verificacionTelTable");  
                              }else{
                            	  let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existe información de verificación</h3></center></div>";
                                  document.getElementById('tablePrint7').innerHTML = myTable;
                              }
                            

                  	  }else{
                            let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existe información de verificación</h3></center></div>";
                            document.getElementById('tablePrint7').innerHTML = myTable;
                  	  }
                  	
                    }else{
                  	 console.log(respJson);
                      let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existe información de verificación</h3></center></div>";
                      document.getElementById('tablePrint7').innerHTML = myTable;
                    }                  
                }catch(e){
                	if(respJson =""){
                     	 console.log(e);            	  
                    	 console.log(respJson);              		 
                    	document.getElementById('tablePrint7').innerHTML ="<div padding: 0% 0% 0% 39%;><center><h3>Error al leer la respuesta</h3></center></div>";              		 
                	 }else{
                		document.getElementById('tablePrint7').innerHTML = "<div padding: 0% 0% 0% 39%;><center><h3>Sesi&oacute;n expirada</h3></center></div>";
                	 }
             	  $('#spinerVeriTelefono').fadeOut();
             	  $('#tablePrint7').show();
               	  
                 }                  
           	  $('#spinerVeriTelefono').fadeOut();
         	  $('#tablePrint7').show();
                   
            }
        });
    } else {
        let myTable = "<h3  style='padding: 0% 0% 0% 39%;'>No existe información de verificación</h3>";
        document.getElementById('tablePrint7').innerHTML = myTable;
        $('#spinerVeriTelefono').fadeOut();
        $('#tablePrint7').show();
    }
    acuceTelefono();
}
function acuceTelefono() {
    var rfcV = $("#rfcV").val();
    var curpV = $("#curpV").val();
    var emailV = $("#emailV").val();
	  $('#spinerAcuseTelefono').fadeIn();
    var validacionFF = validacionF(rfcV, curpV, emailV);
    if (validacionFF === false ) {
        var x = 0;
        $.ajax({
            url: '../../AcuseTelefonoServlet',
            data: {rfc: rfcV, curp: curpV, email: emailV},
            type: 'POST',
            dataType: 'text',
            success: function (respJson) {
                try {
                    var data = JSON.parse(respJson); 
                    if (data.hasOwnProperty('dataAcuseTelefono')) {                	  
                  	  if(data.dataAcuseTelefono.length>0){
                  		  var fechaDWH = data.dataAcuseTelefono[0].fechaDWH.split(" "); 
                  		  var countAcuseTel = 1;
                  		  var uniqueAcuTelefono = removeDuplicatedTelefono(data.dataAcuseTelefono);
                  		  var filasVacias = 0;
                  	      var numFilas = uniqueAcuTelefono.length;
                  	      
                          let myTable = "<table id='acuseTelTable' class='display compact table-striped table-bordered'><thead><tr>" +
                          "<div style='text-align: right; padding: 0% 1% 0% 0%;display:none'>Fecha registro DWH:" + formatDate(fechaDWH[0]) + " </div>" +
                          "<td>Nro.</td>" +                          
                          "<td>Teléfono</td>" +
                          "<td>Fecha emisión</td>" +
                          "<td>Cadena acuse</td>" +
                          "<td>Folio acuce</td></thead>";

                              for(var i=0;i<uniqueAcuTelefono.length;i++){
                                	myTable += "<tr><td>" + (countAcuseTel++) + "</td>";
                            	  	myTable += "<td>" + uniqueAcuTelefono[i].telefono + "</td>";
                                	myTable += "<td>" + formatDate(uniqueAcuTelefono[i].fechaRegistro) + "</td>";
                                	myTable += "<td>" + uniqueAcuTelefono[i].cadenaAcuse + "</td>";
                                	myTable += "<td>" + uniqueAcuTelefono[i].folioAcuse + "</td>";
                                	myTable += "</tr>";
                                	
                                	if(uniqueAcuTelefono[i].fechaRegistro == null && uniqueAcuTelefono[i].cadenaAcuse == null && uniqueAcuTelefono[i].folioAcuse == 0){
                                        filasVacias++;
                                      }
                               	  
                              }
                              myTable += "</tbody></table>";
                              
                              if(filasVacias < numFilas){
                            	  document.getElementById('tablePrint8').innerHTML = myTable;
                                  $("#acuseTelTable td").each(function() {
                                	  if (this.textContent == "null") this.textContent = "-"
                                	})
                                	generateDataTable("acuseTelTable"); 
                              }else{
                            	  let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existe información de Acuse</h3></center></div>";
                                  document.getElementById('tablePrint8').innerHTML = myTable;
                              }
                             

                  	  }else{
                            let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existe información de Acuse</h3></center></div>";
                            document.getElementById('tablePrint8').innerHTML = myTable;
                  	  }                  	
                    }else{
                  	 console.log(respJson);
                      let myTable = "<div padding: 0% 0% 0% 39%;><center><h3>No existe información de Acuse</h3></center></div>";
                      document.getElementById('tablePrint8').innerHTML = myTable;
                    }  
                  	$("#boton5").attr("data-status",1);
                }catch(e){
                	if(respJson =""){
                     	 console.log(e);            	  
                    	 console.log(respJson);              		 
                    	document.getElementById('tablePrint8').innerHTML ="<div padding: 0% 0% 0% 39%;><center><h3>Error al leer la respuesta</h3></center></div>";              		 
                	 }else{
                		document.getElementById('tablePrint8').innerHTML = "<div padding: 0% 0% 0% 39%;><center><h3>Sesi&oacute;n expirada</h3></center></div>";
                	 }
             	  $('#spinerAcuseTelefono').fadeOut();
             	  $('#tablePrint8').show();
               	  
                 }       
           	  $('#spinerAcuseTelefono').fadeOut();
         	  $('#tablePrint8').show();
                   
            }
        });
    } else {
        let myTable = "<h3 style='padding: 0% 0% 0% 39%;'>No existe información de Acuse</h3>";
        document.getElementById('tablePrint8').innerHTML = myTable;
     	  $('#spinerAcuseTelefono').fadeOut();
     	  $('#tablePrint8').show();

    }
}


function removeDuplicatedEmail(data){	
	const output = data.reduce((acc, curr) => {
		  curr.count = 1;
		  const exists = acc.find(o => o.email === curr.email);
		  
		  exists ? exists.count++ : acc.push(({ email, count } = curr));
		  
		  return acc;
		}, []);
	return output;
}

function removeDuplicatedTelefono(data){
	const output = data.reduce((acc, curr) => {
		  curr.count = 1;
		  const exists = acc.find(o => o.telefono === curr.telefono);
		  
		  exists ? exists.count++ : acc.push(({ telefono, count } = curr));
		  
		  return acc;
		}, []);
	return output;
}

function removeDuplicatedAutenticacion(data){
	const output = data.reduce((acc, curr) => {
		  curr.count = 1;
		  const exists = acc.find(o => o.autenticacion === curr.autenticacion);
		  
		  exists ? exists.count++ : acc.push(({ autenticacion, count } = curr));
		  
		  return acc;
		}, []);
	return output;
}

function removeDuplicatedRegimen(data){
	const output = data.reduce((acc, curr) => {
		  curr.count = 1;
		  const exists = acc.find(o => o.regimen === curr.regimen && o.fechaAltaRegimen === curr.fechaAltaRegimen);		  
		  exists ? exists.count++ : acc.push(({ autenticacion, count } = curr));
		  return acc;
		}, []);
	return output;
}

function findGoldenRecordEmail(uniqueEmail){
	var  goldenRecordEmail = "";
	var  fechaReciente = uniqueEmail.reduce((a, b) => (a.fechaRegistroAplicativo > b.fechaRegistroAplicativo ? a : b));

	for(var i=0;i<uniqueEmail.length;i++){
       	if(uniqueEmail[i].aplicativo=="BUZON" && uniqueEmail[i].fechaRegistroAplicativo == fechaReciente.fechaRegistroAplicativo){
       		goldenRecordEmail = uniqueEmail[i].email;
       		break;
       	}else if(uniqueEmail[i].aplicativo=="RFC_AMPLIADO"  && uniqueEmail[i].fechaRegistroAplicativo == fechaReciente.fechaRegistroAplicativo){
       		goldenRecordEmail = uniqueEmail[i].email;
       		break;       		
       	}else if(uniqueEmail[i].aplicativo=="CITAS_SAT"  && uniqueEmail[i].fechaRegistroAplicativo == fechaReciente.fechaRegistroAplicativo){
       		goldenRecordEmail = uniqueEmail[i].email;
       		break;       		
       	}else if(uniqueEmail[i].aplicativo=="PKI_CERTIFICADO"  && uniqueEmail[i].fechaRegistroAplicativo == fechaReciente.fechaRegistroAplicativo){
       		goldenRecordEmail = uniqueEmail[i].email;
       		break;       		
       	}
	  }
	   $("#goldenEmail").append(goldenRecordEmail);
       $("#goldenEmail").fadeIn();
}

function findGoldenRecordTelefono(uniqueTelefono){
	var  goldenRecordTelefono = "";
	var  fechaReciente = uniqueTelefono.reduce((a, b) => (a.fechaRegistroAplicativo > b.fechaRegistroAplicativo ? a : b));

	for(var i=0;i<uniqueTelefono.length;i++){
       	if(uniqueTelefono[i].aplicativo=="BUZON" && uniqueTelefono[i].fechaRegistroAplicativo == fechaReciente.fechaRegistroAplicativo){
       		goldenRecordTelefono = uniqueTelefono[i].telefono;
       		break;
       	}else if(uniqueTelefono[i].aplicativo=="RFC_AMPLIADO"  && uniqueTelefono[i].fechaRegistroAplicativo == fechaReciente.fechaRegistroAplicativo){
       		goldenRecordTelefono = uniqueTelefono[i].telefono;
       		break;       		
       	}else if(uniqueTelefono[i].aplicativo=="CITAS_SAT"  && uniqueTelefono[i].fechaRegistroAplicativo == fechaReciente.fechaRegistroAplicativo){
       		goldenRecordTelefono = uniqueTelefono[i].telefono;
       		break;       		
       	}else if(uniqueTelefono[i].aplicativo=="PKI_CERTIFICADO"  && uniqueTelefono[i].fechaRegistroAplicativo == fechaReciente.fechaRegistroAplicativo){
       		goldenRecordTelefono = uniqueTelefono[i].telefono;
       		break;       		
       	}
	  }
	   $("#goldenTelefono").append(goldenRecordTelefono);
       $("#goldenTelefono").fadeIn();
}


function generateDataTable($idTable){
	  $('#'+$idTable+'').DataTable({
		  'columnDefs': [
			    {
			        "targets": 0, 
			        "className": "text-center",
			   }],
		  "language": {
			  "sProcessing":     "Procesando...",
				"sLengthMenu":     "Mostrar _MENU_ registros",
				"sZeroRecords":    "No se encontraron resultados",
				"sEmptyTable":     "Ningún dato disponible en esta tabla",
				"sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
				"sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
				"sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
				"sInfoPostFix":    "",
				"sSearch":         "Buscar:",
				"sUrl":            "",
				"sInfoThousands":  ",",
				"sLoadingRecords": "Cargando...",
				"oPaginate": {
					"sFirst":    "Primero",
					"sLast":     "Último",
					"sNext":     "Siguiente",
					"sPrevious": "Anterior"
				},
				"oAria": {
					"sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
					"sSortDescending": ": Activar para ordenar la columna de manera descendente"
				}		  
		  }
	  });
	 }
