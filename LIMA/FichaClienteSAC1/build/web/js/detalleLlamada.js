


       function locationVars (vr)
{
        var src = String( window.location.href ).split('?')[1];
        var vrs = src.split('&');
 
        for (var x = 0, c = vrs.length; x < c; x++) 
        {
        	if (vrs[x].indexOf(vr) != -1)
        	{
        		return decodeURI( vrs[x].split('=')[1] );
        		break;
        	}
        }
}  

            function manual() {
                f2 = document.form5;
                var numero = "9" + f2.numerox.value;
                //alert(numero);
                document.getElementById("numeromanual").innerHTML = numero;

                //var num1=  document.getElementById("numero").innerHTML;
//alert("hola");
//document.getElementById("numeromanual").innerHTML=num1;

            }

 /*function soloNumeros(e) 
{ 
var key = window.Event ? e.which : e.keyCode 
alert(key);
if( key == 13 ){
    buscarXnombre();
}
return ((key >= 48 && key <= 57) || (key==8)) 
}*/

function enter(e) 
{ 
var key = window.Event ? e.which : e.keyCode 
//alert(key);
if( key == 13 ){
    buscarXnombre();
}
//return ((key >= 48 && key <= 57) || (key==8)) 
}
 
function verif(n){
var permitidos=/[^0-9.]/;
if(permitidos.test(n.value)){
alert("Solo se puedeingresar numeros");
n.value="";
n.focus();
}
}
 
 function numero(){
 var campa= locationVars('campa');
var campaña ="CAMP_"+campa;
var codigo =locationVars('codclisession');
alert(codigo);
        top.framenumero.document.location.href="listaNumero.jsp?campa="+campa+"&campana="+campaña+"&codcli="+codigo;   
 }
 
 function redifiltro(text){//aqui falta un parametro para que sepa si esta
      //en estado manual o no preaprado
             location.href= text;
             //document.getElementById('div2').style.display = 'block'; 
        }



function buscarXnombre() {
		f = document.forms[0];
                    var telefono = f.txtbuscaXtelef.value;
                var identificador = f.txtbuscaXidenti.value;
              
                var gestion =  f.txtbuscaXgesti.value;
                var tipocliente= f.txtbuscaXtipoCliente.value;
                var tipollamada=f.txtbuscaXtipoLlamada.value;
                var resLlamada=f.txtbuscaXresultadoLlamada.value;
                var tipificacion=f.txtbuscaXtipificacionLlamada.value;
               
                if(telefono==='' && identificador==='' &&  gestion==='' && tipocliente=='' && tipollamada=='' && resLlamada=='' && tipificacion==''   ){
                    //alert("nahhh");
                }else{
                f.accionHTML.value='filtro';
		f.action = 'ServletDetallado';
                f.method='post';
		f.submit();
            }
	}

function buscarXnombre1() {
   
		f = document.forms[0];   
                f.accionHTML.value='filtro1';
		f.action = 'ServletDetallado';
                f.method='post';
		f.submit();
                
	}
 

            function copiar(valor) {
               // alert('llega ' + valor.value);
                f1 = document.forms[0];
                //alert("llego");
                 //alert(valor);
                f1.codCliente.value = document.getElementById(valor).value;
              // alert("1");
                var codcli=  document.getElementById(valor).value;
                
                document.getElementById(valor).disabled=true;
              
                var campa= f1.campa.value;
                var campaign = f1.campaign.value;
                var manual= document.getElementById('manual').value;
              
                f1.consultor.value="noconsultor";
                var consultor= f1.consultor.value;
              
               top.framecabecera.document.location.href="cabecera.jsp?campa="+campaign+"&campana="+campa+"&manual=valor"+"&grabar=valor"+"&codCliente="+codcli; 
              // alert("valor de campa click codigo "+campaign);
                top.framenumero.document.location.href="listaNumero.jsp?campa="+campaign+"&campana="+campa+"&codcli="+codcli+"&valor=valor"; 
               
                ///  alert("1");
                
                window.open("http://10.165.70.249:8084/FichaClienteSAC1/CONSULTOR2.jsp?codCliente="+codcli+"&campana="+campa+"&campa="+campaign+"&manual="+manual+"&noconsultor="+consultor,"consultor");
               //alert(codcli);
                setTimeout(function tiempo(){
                  document.getElementById(valor).disabled=false;
                   // alert(valor);
              },4000);
            }

    
      /* function tiempo(){
       
               /*  document.getElementById(valor).disabled=false;
                     alert(valor);*/
          /// alert("lelgo");
       //} 
        
        function desbotones(valor){
           // alert("deshabilitado");
         var i=0;for(i=0;i<valor  ;i++){
     document.getElementById("codcliente"+i).disabled = true; 
     return ;
      }
    }
        
          
        
        
        
        function redireccionar(text){
            
             location.href = text;
        }
           
             function mostrar(){
            document.getElementById('div60').style.display = 'block';
           
    }
    
       function ocultar(){
            document.getElementById('div60').style.display = 'none';
           
    }
    
    
    

  function quitarf5(){
 document.onkeydown = function(e){ 
tecla = (document.all) ? e.keyCode : e.which;
alert(tecla);
if (tecla = 116) {
    return false;
}
}
      }
