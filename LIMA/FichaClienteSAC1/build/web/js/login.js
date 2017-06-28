
            
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
function sinclicktocall(){   
//alert("sinclicktocall");
var campa= locationVars('CAMPAIGN') ;
var campaña ="CAMP_"+campa;
var codcli= locationVars('Account_Number');
var valor = "valor";
//window.open("http://10.165.70.249:8084/FichaClienteSAC1/logon.jsp?CAMPAIGN="+campa+"&Account_Number="+codcli,"procedure");
window.open("http://10.165.70.249:8084/FichaClienteSAC1/CONSULTOR2.jsp?campana="+campaña.toString()+"&campa="+campa,"consultor");
window.open("http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?campana="+campaña.toString()+"&Drop="+valor,"infomacion");
window.open("http://10.165.70.249:8084/FichaClienteSAC1/Resultados.jsp?campana="+campaña.toString()+"&campa="+campa,"resultados");
window.open("http://10.165.70.249:8084/FichaClienteSAC1/detalleLlamada.jsp?campana="+campaña.toString()+"&campa="+campa+"&Drop="+valor+"&frame=valor","detalle");

}    


function sincliente(){ 
///alert("sincliente");
   f1 = document.forms[0];
var campa= locationVars('CAMPAIGN') ;
var codcli= locationVars('Account_Number');
var campaña ="CAMP_"+campa;
//alert("CAMPAsincliente"+campaña);
var valor = "valor";
var manual="hola a todos" ;
var contador =0;
var consultor="consultor";
var codcliente = f1.codcli.value;
var numero = f1.numero.value;

window.open("http://10.165.70.249:8084/FichaClienteSAC1/CONSULTOR2.jsp?codCliente="+codcliente+"&ANI="+numero+"&campana="+campaña.toString()+"&campa="+campa+"&consultor="+consultor+"&contador="+contador,"consultor");

//window.open("http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?campana="+campaña.toString()+"&valor="+valor,"infomacion");
//window.open("http://10.165.70.249:8084/FichaClienteSAC1/Resultados.jsp?campana="+campaña.toString()+"&campa="+campa,"resultados");
//alert("ddd222"+codcliente);
///window.open("http://10.165.70.249:8084/FichaClienteSAC1/detalleLlamada.jsp?campana="+campaña.toString()+"&campa="+campa+"&frame=valor","detalle");

}

function concliente(){
////alert("concliente");
f1 = document.forms[0];
var campa= locationVars('CAMPAIGN') ;
//alert("campañaconcliente"+campa);
var campaña ="CAMP_"+campa;
var manual="hola a todos";
var drop="valor";

var codcliente = f1.codcli.value;
var numero = f1.numero.value;
var consultor ="consultor";
var contador =0;
//alert(campaña);
//alert(drop);

//window.open("http://10.165.70.249:8084/FichaClienteSAC1/CONSULTOR2.jsp?campana="+campaña.toString()+"&campa="+campa+"&codCliente="+codcliente+"&consultor="+consultor+"&manual="+manual,"consultor");
window.open("http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?campana="+campaña.toString()+"&manual="+manual+"&Drop="+drop+"&codcli="+codcliente+"&ANI="+numero+"&campa="+campa,"infomacion");
//window.open("http://10.165.70.249:8084/FichaClienteSAC1/Resultados.jsp?campana="+campaña.toString()+"&campa="+campa+"&codcli="+codcliente,"resultados");
///window.open("http://10.165.70.249:8084/FichaClienteSAC1/detalleLlamada.jsp?campana="+campaña.toString()+"&campa="+campa+"&codcli="+codcliente+"&concliente=valor","detalle");


}
function soloprepa(){
  //// alert("solopreprado");
    var campa= locationVars('CAMPAIGN') ;
var campaña ="CAMP_"+campa;
///alert("campañasoloprepa"+campaña);
var valor = "valor";
 window.open("http://10.165.70.249:8084/FichaClienteSAC1/detalleLlamada.jsp?campana="+campaña+"&campa="+campa+"&valor="+valor+"&refrescar=valor","detalle");
}

function enviarcodnull(){
     var campa= locationVars('CAMPAIGN') ;
var campaña ="CAMP_"+campa;
var codcli= document.getElementById("codnull").value;

if( codcli=='' || codcli=='null' || codcli==null ){
///  alert("no hay codigo");
}else{
    window.open("http://10.165.70.249:8084/FichaClienteSAC1/CONSULTOR2.jsp?campana="+campaña+"&Account_Number="+codcli+"&campa="+campa,"consultor");
    }
    //window.open("http://10.165.70.249:8084/FichaClienteSAC1/logon.jsp?CAMPAIGN="+campa+"&Account_Number="+codcli,"procedure");
 
}


