




function soloNumeros(e) 
{ 
var key = window.Event ? e.which : e.keyCode 
//alert(key);
if( key == 13 ){
    grabar();
 
}
return ((key >= 48 && key <= 57) || (key==8)) 
}




function soloNumerosbusqueda(e) 
{ 
  var key = window.Event ? e.which : e.keyCode 
//alert(key);
if( key == 13 ){
    busqueda();
 
}
return ((key >= 48 && key <= 57) || (key==8))   
}


function busqueda(parametro,valor){
 ///// alert("valorrrrrrr " + valor);
    var codigo = document.getElementById(valor).value;
    var codcliente = document.getElementById('codigo').value;
    var campana = document.getElementById('campa').value;
    var campa = document.getElementById('campaign').value;
    var checkdni = document.getElementById('checkDNI').checked;
    var checkruc = document.getElementById('checkRUC').checked;
    var numero_Entrante= document.getElementById('numeroentrante').value;
    f1 = document.forms[0];
    f1.action = 'servletCliente';
    f1.method = 'POST';
    f1.actionResul.value = 'busqueda';
    var identificadoor;
    var txtdni = f1.txtDNI.value;
    var txtruc = f1.txtruc.value;

    if (txtdni == null || txtdni == "null" || txtdni == "") {
        identificadoor = txtruc;
    } else {
        identificadoor = txtdni;
    }
         
         
  /////  alert("checkdni"+checkdni+"checkruc"+checkruc);
    if(checkdni== true || checkruc==true){
       ////alert("true");
         ///location.href='frameConsultorCuerpo.jsp? campana='+campana+"&campa="+campa;
   top.consultorcuerpo.document.location.href="frameConsultorCuerpo.jsp?campa="+campa+"&campana="+campana; 
  window.open("http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?campana="+campana.toString()+"&campa="+campa,"infomacion");
  window.open("http://10.165.70.249:8084/FichaClienteSAC1/Resultados.jsp?Identificador="+identificadoor+"&campana="+campana+"&campa="+campa,"resultados");
  top.frameinvisible.document.location.href="frmConsulInvisible.jsp?campa="+campa+"&campana="+campana+"&txtcodigo="+identificadoor;
        
        f1.submit();
   
    }else{
    ///alert("false");
 location.href='frameconsultor1.jsp?parametro='+parametro+'&valor='+codigo+'&txtcodigo='+codcliente+"&campana="+campana+"&campa="+campa+"&ANI="+numero_Entrante;
  
  }
            
}
 
function verif(n){
var permitidos=/[^0-9.]/;
if(permitidos.test(n.value)){
alert("Solo se puedeingresar numeros");
n.value="";
n.focus();
}
}
       function valanot(celda,valor,id,graba,valor1){
       
        
          
          
            f1 = document.forms[0];
              //  f1.actionResul.value = 'GrabaAnotacion';
               // f1.acciondos.value='ModificaAnotac';
               // f1.action = 'servletCliente';
               // f1.method = 'POST';
              f1.btngraanot.value="Modificar";
              f1.valordes.value=valor;
              f1.idllamada.value=id;
        //alert(graba);
              
            if(graba == "1"){
                
           //  f1.txtanot.disabled=true;
             
              }
       
        
        
        
        var hoy = new Date();
 var dia = hoy.getDate(); 
 var mes = hoy.getMonth()+1;
 var anio= hoy.getFullYear();
 
 if(mes <= 9){
     mes="0"+mes;
 }
 if(dia<=9){
 dia="0"+dia   ; 
 }
    var fecha_actual = String(dia+"/"+mes+"/"+anio);
   // alert(fecha_actual);
    var cort= celda.substring(3);
    var camp=document.getElementById("fech"+cort).innerHTML;
    var cort2= camp.substr(0,10);
     var fech1=  fecha_actual.toString();
     var fech2= cort2.toString();
     if    (fech1 == fech2) {
      //  alert("entro a la funcion");
            document.getElementById(valor).disabled = false; 
         document.getElementById(valor1).disabled = false;
         deshabilitar1();
         var cod=   document.getElementById(id).innerHTML;
         document.getElementById(celda).checked=true;
              //habilita el modifcar y el cancelar
            document.getElementById('btngraanot').style.visibility = 'visible';
            
             document.getElementById('cancelarx').style.visibility = 'visible';
           
                document.getElementById('id').value=  cod;
        
       }else{    
            alert("solo se puede modificar la fecha del dia");  
            document.getElementById(celda).checked=false;
           document.getElementById('btngraanot').style.visibility = 'visible';
           document.getElementById('cancelarx').style.visibility = 'visible';    
    }
}
   
   
   function myTrim(x)
{
return x.replace(/^\s+|\s+$/gm,'');
}


 
   
   function cancelaranotacion(){
      // alert("cancelar")
        f1 = document.forms[0];
          f1.actionResul.value = 'GrabaAnotacion';
       // f1.actionResul.value = 'Cancelar';
       f1.acciondos.value="Cancelar";
        f1.action ='servletCliente';
        f1.method = 'POST';
         f1.idcheck.value="";
                f1.valordes.value="";
                f1.idllamada.value="";
        f1.submit();
       
   }
       
  function  fgrabaanotacion()
  {
            //   ("llego");
               f1 = document.forms[0];
               // f1.actionResul.value = 'GrabaAnotacion';
               // f1.action ='servletCliente';
                //f1.method = 'POST';
                f1.btngraanot.value="Modificar";
                var campaign= f1.campaign.value;
                var campa=  f1.campa.value;
                var  des= document.getElementById("valordes").value;
               // alert(des);
             f1.idcheck.value=document.getElementById(des).value;///textomodificado
              //alert(f1.idcheck.value);
              var textmodifica=f1.idcheck.value;
              
              var idllama =f1.idllamada.value;//id del registro
              //alert(idllama);
                var xcodigo = f1.codigo.value;
               // f1.submit();
     top.frameinvisible.document.location.href="frmConsulInvisible.jsp?campa="+campaign+"&campana="+campa+"&accion=GrabaAnotacion&acciondos=ModificaAnotac&idcheck="+textmodifica+"&idllamada="+idllama+"&codianot="+xcodigo;

 setTimeout(function tiempo(){
top.consultorcuerpo.document.location.href="frameConsultorCuerpo.jsp?campa="+campaign+"&campana="+campa+"&xcodigo="+xcodigo;     
//alert("cincuenta");
 },1000);
  }
  
  
    function grabar() {
           
f1 = document.forms[0];

  //  alert("num1");
var valor=   f1.txtcodigo.value ;
var contvar= valor.length;
        if  (valor==''|| contvar!=10 ){
    alert("Por Favor Ingresar Codigo de Cliente");
}else{

  var numerox= document.getElementById('numeroentrante').value;

var campaign= f1.campaign.value;
var manual="manual";
var drop="Drop";
var campa=  f1.campa.value;
var consultor= f1.consultor.value;
 var contador =0;
            
                f1.action = 'servletCliente';
                  f1.method = 'POST';
                 // f1.disabled=true;
                 // alert("llego");
 
 ///alert(numerox);
  
  top.frameinvisible.document.location.href="frmConsulInvisible.jsp?campa="+campaign+"&campana="+campa+"&txtcodigo="+valor;
  top.consultorcuerpo.document.location.href="frameConsultorCuerpo.jsp?campa="+campaign+"&campana="+campa+"&xcodigo="+valor+"&ANI="+numerox;    
   top.consutorcabecera.document.location.href="frameconsultor1.jsp?campa="+campaign+"&campana="+campa+"&txtcodigo="+valor+"&ANI="+numerox;
  //   f1.submit();
    
         
  window.open("http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?campana="+campa.toString()+"&campa="+campaign+"&manual="+manual+"&Drop="+drop+"&codcli="+valor+"&consultor="+consultor+"&contador="+contador,"infomacion");
  window.open("http://10.165.70.249:8084/FichaClienteSAC1/Resultados.jsp?codcli="+valor+"&ANI="+numerox+"&campana="+campa+"&campa="+campaign,"resultados");
 
    }

            }
            
      function       filtro(){
        //  alert("holaaa");
         f1 = document.forms[0];
           f1.txtcodigo.value=f1.codigo.value;
       //  alert(f1.txtcodigo.value);  
        f1.action = 'servletCliente';
                  f1.method = 'POST';
                  f1.submit();
      }
   function grabaranotacionllamada(){
      // alert("graba");
 f1 = document.forms[0];
 var anotacion=f1.txtanot.value;
 var anotaxion=myTrim(anotacion);

 if(anotaxion  ==''){
     alert("Por favor Ingresar Anotacion");
     
 }else{
     
    f1 = document.forms[0];
             //   f1.actionResul.value = 'GrabaAnotacion';
             //   f1.action ='servletCliente';
               // f1.method = 'POST';
              //  f1.acciondos.value="ActualizarModificacion";
                var xcodigo = f1.codigo.value;
                 var descrip= f1.txtanot.value;
                 var  graba = f1.graba.value;
                 
var campaign= f1.campaign.value;
var campa=  f1.campa.value;
top.frameinvisible.document.location.href="frmConsulInvisible.jsp?campa="+campaign+"&campana="+campa+"&accion=GrabaAnotacion&acciondos=ActualizarModificacion&descrip="+descrip+"&graba="+graba+"&codianot="+xcodigo;

 setTimeout(function tiempo(){
top.consultorcuerpo.document.location.href="frameConsultorCuerpo.jsp?campa="+campaign+"&campana="+campa+"&xcodigo="+xcodigo;     
//alert("cincuenta");
 },1000);


           
    
     
 }
       
   }         
            
            
            
   function  desabi(){
       document.getElementById('grabanotacionllamada').style.visibility = 'hidden';
       document.getElementById('txtanot').style.visibility='hidden';
   }
 
            
            
            
            
            
   function grabacodcli (){
        f1 = document.forms[0];
      var valor=   f1.codCliente.value ;  
     var campaign= f1.campaign.value;
                  
                var campa=  f1.campa.value;
                var numerox= document.getElementById('numeroentrante').value;

                  window.open("http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?codcli="+valor+"&campana="+campa+"&campa="+campaign,"infomacion");
                  window.open("http://10.165.70.249:8084/FichaClienteSAC1/Resultados.jsp?codcli="+valor+"&ANI="+numerox+"&campana="+campa+"&campa="+campaign,"resultados");
               // window.open("http://10.165.70.249:8084/FichaClienteSAC1/detalleLlamada.jsp?codcli="+valor+"&campana="+campa+"&campa="+campaign+"&manual="+manual+"&consultor="+consultor+"&contador="+contador+"&click=valor","detalle");
              
                  /*f1.action = 'servletCliente';
                  f1.method = 'POST';
                  f1.submit();  */
      
   }   
   
  /* function desabilita(e){
     // alert("entro");
        habilitar(e);
       
   }*/
   
  
   
  function grabaprecod (){
     /////// alert(valor);
       f1 = document.forms[0];
      var valor=   f1.prepcodigo.value ;  
       
     var campaign= document.getElementById("campaign").value;
          
     var campa=  document.getElementById("campa").value; 
     var vari= "valor";
         var numerox= document.getElementById('numeroentrante').value;
        //// alert(numerox);
    top.frameinvisible.document.location.href="frmConsulInvisible.jsp?campa="+campaign+"&campana="+campa+"&prepxcodigo="+valor;
      
    window.open("http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?codcli="+valor+"&campana="+campa+"&valor="+vari+"&campa="+campaign,"infomacion"); 
    window.open("http://10.165.70.249:8084/FichaClienteSAC1/Resultados.jsp?codcli="+valor+"&ANI="+numerox+"&campana="+campa+"&campa="+campaign,"resultados");     
   // window.open("http://10.165.70.249:8084/FichaClienteSAC1/detalleLlamada.jsp?codcli="+valor+"&campana="+campa+"&campa="+campaign+"&valor="+vari,"detalle");
   //alert("entro a preaprado");
                 // f1.action = 'servletCliente';
                 // f1.method = 'POST';
                  //f1.submit();             
                
                
  }
            
            

            
            
             function mostrar(){
            document.getElementById('div1').style.display = 'block';
             document.getElementById('div2').style.display = 'block';
    }
              function ocultar(){
                   document.getElementById('div1').style.display = 'none';
            document.getElementById('div2').style.display = 'none';}
        
        
        
        function redireccionar(){
            location.href= "#anotacion";
           
   
      var campa =  document.getElementById("campaign").value; 
      // alert("vamos peru");     
   var campana= "CAMP_" + campa;
  
   var codcli =document.getElementById("codigo").value;

  document.URL="http://10.165.70.249:8084/FichaClienteSAC1/CONSULTOR2.jsp?campana="+campana+"&campa="+campa+"&txtcodigo="+codcli+"#anotacion";   

        }
    

  function  telefono(){
      document.getElementById('div10').style.display = 'block'; 
      
  }
   function deshabilitar1(){
      
        
         //document.getElementById('btngraanot').value="Modificar";
        document.getElementById('txtanot').disabled=true;
document.getElementById('grabanotacionllamada').disabled=true;
   }     
   
 function clicktocall(valorr) {
   // alert(valorr);
if(valorr==null){
   /// alert("nullclicttocall");
}else{   
   // desbotones(size);
  
f5 = document.forms[0];  
//alert(f5);
document.getElementById('div10').style.display = 'none'; 
document.getElementById('telefonoSelect').value=valorr;//telefono
var telefono= document.getElementById('telefonoSelect').value;
//alert("condata1");
//document.getElementById('accionHTML').value = 'llamadaManual';//mandar una accion
//f5.action = 'ServletDetallado';
//f5.method = 'POST';
var campaign= document.getElementById("campaign").value;
          
     var campa=  document.getElementById("campa").value; 

    var xcodigo = f5.codigo.value;
    
top.frameinvisible.document.location.href="frmConsulInvisible.jsp?campa="+campaign+"&campana="+campa+"&accion=llamadaManual&CodCliente="+xcodigo+"&telefonoSelect="+telefono;
 setTimeout(function tiempo(){
         top.consutorcabecera.document.location.href="frameconsultor1.jsp?campa="+campaign+"&campana="+campa+"&txtcodigo="+xcodigo;
        // alert("llego");
     },1000);
///alert("fredom");
//top.framedetalla.document.location.href="index.jsp?validacion=valor&campana="+campaña.toString()+"&campa="+campa.toString();    
//top.framecabecera.document.location.href="cabecera.jsp?campa="+campa.toString();    
//window.open("http://10.165.70.249:8084/FichaClienteSAC1/Informacion_Cliente.jsp?campana="+campaña.toString()+"&valor="+valor+"&codcli="+codcliente,"infomacion");
//alert("CAMPAÑA DE LISTANUMERO"+campaña);
//f5.submit();

 
 }

 }
 
function  fonavi(){
    f5 = document.forms[0];  
    var campaign= document.getElementById("campaign").value;
          
     var campa=  document.getElementById("campa").value; 

    var xcodigo = f5.codigo.value;
    
   ///document.getElementById('tdtext').innerHTML='Estas en Llamada';
 ////  alert("Lo hizo");
 
var txtpara= document.getElementById('txtparametro').value; 
///alert("txtpara"+txtpara);
var txtvalor= document.getElementById('txtvalor').value; 
top.consutorcabecera.document.location.href="frameconsultor1.jsp?campa="+campaign+"&campana="+campa+"&txtcodigo="+xcodigo+"&numerito=valor"+"&parametro="+txtpara+"&valor="+txtvalor;
       //  alert("llego");
    
}

function buscardetalle(){
    f1 = document.forms[0];
     var direccion = f1.txtDireccion.value;
    var distrito = f1.txtDistrito.value;
    var parametro = f1.txtparametro.value;
            var valor=f1.txtvalor.value;  
    
    
    
    location.href="busquedaFiltro.jsp?txtdireccion="+direccion+"&txtdistrito="+distrito+"&filtro=valor&parametro="+parametro+"&valor="+valor;
}
function refrescartotal(){
     f1 = document.forms[0];
    var parametro = f1.txtparametro.value;
            var valor=f1.txtvalor.value;   
   /// var compara=f1.txtcompara.value;
    location.href="busquedaFiltro.jsp?parametro="+parametro+"&valor="+valor  ;
    
}
function buscarenter(e){
  var key = window.Event ? e.which : e.keyCode 
//////alert(key);
if( key == 13 ){
    buscardetalle();
}  
}
function enviacodigo(codigo,conta,filtro){
    //////alert("llego");
  /// alert(conta)  ;
    f1 = document.forms[0];
    var campaign= f1.campaign.value;
///alert(campaign);
 var numerox= document.getElementById('numeroentrante').value;
var campa=  f1.campa.value;
var txtpara= document.getElementById('txtparametro').value; 
///alert("txtpara"+txtpara);
var txtvalor= document.getElementById('txtvalor').value; 

    top.frameinvisible.document.location.href="frmConsulInvisible.jsp?campa="+campaign+"&campana="+campa+"&txtcodigo="+codigo;
    
      top.consultorcuerpo.document.location.href="frameConsultorCuerpo.jsp?campa="+campaign+"&campana="+campa+"&xcodigo="+codigo;   
    parent.location.href="frameconsultor1.jsp?campa="+campaign+"&campana="+campa+"&txtcodigo="+codigo+"&parametro="+txtpara+"&valor="+txtvalor+"&comparacodigo="+codigo+"&numeroancla="+conta+"&filtro="+filtro+"&llega=valor";

  


}

