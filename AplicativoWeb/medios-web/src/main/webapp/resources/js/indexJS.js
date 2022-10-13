

$('#rfcRadio').click(function() {
$('#rfc').prop('disabled', false);
        $('#curp').prop('disabled', true);
        $('#correo').prop('disabled', true);
        $('#curp').val("");
        $('#correo').val("");
});
        $('#curpRadio').click(function() {
$('#curp').prop('disabled', false);
        $('#rfc').prop('disabled', true);
        $('#correo').prop('disabled', true);
        $('#rfc').val("");
        $('#correo').val("");
});
        $('#emailRadio').click(function() {
$('#curp').prop('disabled', true);
        $('#rfc').prop('disabled', true);
        $('#correo').prop('disabled', false);
        $('#correo').val("");
        $('#rfc').val("");
        $('#curp').val("");
});


$(document).ready(function(){
    
   	$(".bloqeuarEspeciales").keyup(function(){
    	var a = $('#rfc').val();	
        var b = $('#curp').val();
        var c = $('#correo').val();
        var letras = "";
        if(a.length > 0){
            letras = a;
        }else if(b.length > 0){
            letras = b;
        }else if(c.length > 0){
        letras = c;
        }
        
        var parts = letras.split("");
        var validacion = false;

             for(var i = 0;i <= letras.length;i++){
                 switch (parts[i]){
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
         
             if(validacion === false){
                 $(".buscar").prop('disabled', false);
                 $(".quitarR").addClass("ocultar");
                 $("#Aerror").addClass("ocultar");
                  


             }else{
                  $(".quitarR").removeClass("ocultar");
                  $("#Aerror").removeClass("ocultar");
                   $(".buscar").prop('disabled', true);
$("#ARFC").addClass("ocultar");
                  $("#ACURP").addClass("ocultar");
                  $("#AEMAIL").addClass("ocultar");
                  $(".quitarR").css("display", "");

             }
            
	}); 
	
});

$("#regresar").click(function(e) {
	   e.preventDefault();
	   $("#correo").val("");
       document.getElementById('indexForm:busquedaEmail').value = ""; 
	   $('#resultadosEmailTable').DataTable().destroy();
	   $("#resultadosEmail").html("");
	   $("#seccionResultados").hide();
	   $("#seccionBusqueda").fadeIn();		
	   $("#indexForm").removeAttr("target");
});

$(document).on('click', '.consultar',  function(e){	  
	   e.preventDefault();
	  // $("#indexForm").prop("target","_blank");
       document.getElementById('indexForm:busquedaEmail').value =  $("#correo").val();	   
       document.getElementById('indexForm:curp').value = "";
       document.getElementById('indexForm:correo').value = "";   
	   document.getElementById('indexForm:rfc').value = $(this).attr("data-rfc");
	   document.getElementById('indexForm:buscar').click();
});


function searchEmail() {
	var rfcV = $("#rfcV").val();
	var curpV = $("#curpV").val();
    var emailV = $("#correo").val();

	$("#overlay").fadeIn();
    $.ajax({
        url: '../../EmailServlet',
        data: {rfc: "", curp: "", email: emailV},
        type: 'POST',
        dataType: 'text',
            success: function (respJson) {		            
            	if(!($.isEmptyObject(respJson))){
            		 var data = JSON.parse(respJson); 
						 var uniqueRFC = removeDuplicatedBusquedaEmail(data.dataEmail);
						 var numResult = 1;
						 var table = "<table id='resultadosEmailTable' class='display compact table-striped table-bordered'><thead><tr>" +
                         "<th>Nro.</th>" +                          
                         "<th>RFC</th>" +
                         "<th>Denominación</th>" +
                         "<th>Nombre</th>" +
                         "<th>Email</th>" +
                         "<th></th>" +
                         "</tr></thead>";
						 
						 if(uniqueRFC.length == 1){
							document.getElementById('indexForm:buscar').click();
						 }else if(uniqueRFC.length > 1){
							for(var i=0;i<uniqueRFC.length;i++){
							    table += "<tr>";
								table += "<td>"+(numResult++)+"</td>";
								table += "<td>"+uniqueRFC[i].rfc+"</td>";
								table += "<td>"+uniqueRFC[i].denominacion+"</td>";
								table += "<td>"+uniqueRFC[i].nombre+"</td>";
								table += "<td>"+uniqueRFC[i].email+"</td>";
								table += "<td><a class='consultar' data-rfc="+uniqueRFC[i].rfc+" href='#'>Ver información</a></td>";
								table += "</tr>";

							}
						  
						  $("#resultadosEmail").append(table);
						  $("#resultadosEmail td").each(function() {
                        	  if (this.textContent == "undefined") this.textContent = "-"
                        	})
						  generateDataTable("resultadosEmailTable");
						   $("#seccionBusqueda").hide();							  
						   $("#seccionResultados").fadeIn();
						 }else if(uniqueRFC.length == 0){
							 $(".quitarR").removeClass("ocultar");
			                  $("#AEMAIL").removeClass("ocultar");
			                  $('.quitarR').delay(1000).fadeOut(100);
						 }
            	}else{
	                $(".quitarR").removeClass("ocultar");
            		$("#AEMAIL").show("ocultar");
	                $('.quitarR').delay(1000).fadeOut(100);
            	}
            	

            	$("#overlay").fadeOut();

	            }
        });

}


function removeDuplicatedBusquedaEmail(data){	
	const output = data.reduce((acc, curr) => {
		  curr.count = 1;
		  const exists = acc.find(o => o.rfc === curr.rfc);
		  
		  exists ? exists.count++ : acc.push(({ rfc, count } = curr));
		  
		  return acc;
		}, []);
	return output;
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

