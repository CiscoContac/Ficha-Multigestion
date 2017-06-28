
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

function refrescar(){
 ///document.getElementById('fresh').style.visibility='hidden';
//alert("jaaa");
   f1 = document.forms[0];
var campa= f1.campa.value;
//alert("campa de refrescar "+ campa);

var campaign=f1.campana.value;
//alert("campaign detallado refrecar ="+campaign );
//alert("hola");
var refrescar= locationVars('refrescar');
//alert(refrescar);
document.getElementById('divactu').style.display='none';
document.getElementById('mensaje').style.display='block';

if(refrescar!=null){
 //alert("valor campa1"+campa);
top.framedetalla.document.location.href="index.jsp?campana="+campaign+"&campa="+campa;
top.framenumero.document.location.href="listaNumero.jsp?campana="+campaign+"&campa="+campa;
///alert("entro al refrescar1");
 }else{
 //alert("valor campa2"+campa);     
top.framedetalla.document.location.href="index.jsp?campa="+campa+"&campana="+campaign+"&manual=valor"; 
top.framenumero.document.location.href="listaNumero.jsp?campana="+campaign+"&campa="+campa;
/////alert("no al refrescar");
}
setTimeout(time,5000);
  }
    

 function time(){
     document.getElementById('divactu').style.display='block';
     document.getElementById('mensaje').style.display='none';
    //alert("set");
     
 }