function modificarparentesco(nro,parentesco,nombre) {
       f4 = document.forms[0]; 
    document.getElementById("relacion").disabled = true;
    document.getElementById("NombreParentesco").disabled = true;
    document.getElementById("Telefono").disabled = false;
  
                 }

 function enviarnumeroippc (id){
    ////// alert(id);
    var indice = document.getElementById(id).selectedIndex;
    var textoEscogido = document.getElementById(id).options[indice].text; 
     //alert(textoEscogido);
     if(textoEscogido == "(Selecione número)" ){
         alert("Por favor seleccionar numero");
     }else{
   /////  alert(textoEscogido);
     document.getElementById("framecuic").src="busquedaNumeroCUIC.jsp?numeroCuic="+textoEscogido;
     }
     }

 function soloNumeros(e) 
{ 
var key = window.Event ? e.which : e.keyCode 
//alert(key);
if(key == 13){
   fllamar();
    //alert("entro");
    //return;
}else{    
return ((key >= 48 && key <= 57) || (key==8)) 
}
}
 

function buscarnumero(){
    var numero = document.getElementById("txtbuscar").value;
   
    if(numero.length<7 ){
    
       alert("Ingresar como m\u00EDnimo 7 n\u00FAmeros");    
   
    }else {

   document.getElementById("framecuic").src="busquedaNumeroCUIC.jsp?numeroCuic="+numero;
   
    }
    
}
   function txNombres(e) {  if ((event.keyCode != 32) && (event.keyCode < 65) || (event.keyCode > 90) && (event.keyCode < 97) || (event.keyCode > 122))   event.returnValue = false; }
 
function Limpiar() {
f4 = document.forms[0];

//f4.Telefono.value="limpiar";
//f4.relacion.value="liclickpiar";
//f4.NombreParentesco.value="limpiar";
document.getElementById("relacion").disabled =false;
document.getElementById("NombreParentesco").disabled =false;
document.getElementById("Telefono").disabled =false;

//document.getElementById("relacion").disabled = false;
//document.getElementById("NombreParentesco").disabled = false;
//document.getElementById("Telefono").disabled = false;
f4.Telefono.value="";
f4.relacion.value="";
f4.NombreParentesco.value="";


document.getElementById("parentesco").value="";

//alert("Se limpio los campos nuevecito");

                 }
 
 function redireccionarJSP(){
      f1 = document.forms[0];
       document.getElementById("accionHtml").value='retornar'; 
      f1.submit();
 }
            function manual() {
                f2 = document.forms[0];
                var numero ="9961783052";
               //alert(numero);
               f2.document.getElementById("numeromanual").innerHTML=numero;

            }
            
 function Verificar(e)
{
   // alert(e);
var key = window.Event ? e.which : e.keycode 
///alert(key);
return ((key >= 48 && key <= 57) || (key==8) || (key==46)) 

}

/*
 function soloNumeros(e) 
{ 
var key = window.Event ? e.which : e.keyCode 
//alert(key);
return ((key >= 48 && key <= 57) || (key==8) || (key==46))  
}

*/
function verif(n){
var permitidos=/[^0-9.]/;
if(permitidos.test(n.value)){
alert("Solo se puedeingresar numeros");
n.value="";
n.focus();
}
}
            
  function grabarnumeronuevo(){
   //  alert(grabara);
  f1 = document.forms[0];
      document.getElementById("accionHtml").value='Grabar'; 
       f1.submit();}

  function ContactoModificado() {
             // alert("porfin0");
            f1 = document.forms[0];
            // alert("porfin1");
            var s=f1.contacto1.value;
           ///alert( "siiiii"+s);
               document.getElementById("accionHtml").value='modificarcontacto';  
             //   alert("exit");
        
        if (s  ==null  || s=="") {
        
      //alert("nuloooo");
        } else{
       document.getElementById('imgcontasave').style.display='none';
            //alert("submit");
             f1.submit();
         }
      }



function modificarnroagregado(valor){   
         var txtvar= 'nronuevoa'+valor;
         
       var tel=   document.getElementById(txtvar).value;
 if(tel==''){
     alert("Ingresar N\u00famero");
 }else if(tel.length < 9) {
     alert("Ingresar  como minimo 9 n\u00fameros");
     
 }else{
    
if(valor==1){ f1 = document.forms[0];
document.getElementById("accionHtml").value='modificarnroag1';
f1.submit();}  
if(valor==2){ f1 = document.forms[0];
document.getElementById("accionHtml").value='modificarnroag2';
f1.submit();}    
if(valor==3){ f1 = document.forms[0];
document.getElementById("accionHtml").value='modificarnroag3';
f1.submit();}       
if(valor==4){ f1 = document.forms[0];
document.getElementById("accionHtml").value='modificarnroag4';
f1.submit();}      
if(valor==5){ f1 = document.forms[0];
document.getElementById("accionHtml").value='modificarnroag5';
f1.submit();}    
if(valor==6){ f1 = document.forms[0];
document.getElementById("accionHtml").value='modificarnroag6';
f1.submit();}    

if(valor==7){ f1 = document.forms[0];
document.getElementById("accionHtml").value='modificarnroag7';
f1.submit();}
if(valor==8){ f1 = document.forms[0];
document.getElementById("accionHtml").value='modificarnroag8';
f1.submit();}     
if(valor==9){ f1 = document.forms[0];
document.getElementById("accionHtml").value='modificarnroag9';
f1.submit();} 
if(valor==10){ f1 = document.forms[0];
document.getElementById("accionHtml").value='modificarnroag10';
f1.submit();}   
 }              
}





function eliminarnroagregado(valor){
     if(valor==1){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnroa1';
f1.submit();}
     if(valor==2){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnroa2';
f1.submit();}
 if(valor==3){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnroa3';
f1.submit();}
if(valor==4){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnroa4';
f1.submit();}
 if(valor==5){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnroa5';
f1.submit();}
 if(valor==6){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnroa6';
f1.submit();}
 if(valor==7){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnroa7';
f1.submit();}
 if(valor==8){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnroa8';
f1.submit();}
 if(valor==9){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnroa9';
f1.submit();}

 if(valor==10){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnroa10';
f1.submit();}

}

function eliminacontacto(){
    f1 = document.forms[0];
   
   f1.contacto1.value=f1.contacto.value;
   
    document.getElementById("accionHtml").value='eliminacontacto';
    f1.submit();
}

function agregaparent(){
    
      f1 = document.forms[0];
     var tel= f1.Telefono.value;
      var rel =  document.getElementById('relacion').value;
      var nom= document.getElementById('NombreParentesco').value;
    if(tel==''|| rel==''|| nom==''){
    alert("Por favor Ingresar Todos los campos");    
    
     }else if(tel.length < 9  ){
         alert("Ingresar como minimo 9 numeros");
     }
     else{
         document.getElementById('agregar').disabled=true;
     document.getElementById('accionHtml').value='Agregar';
    document.getElementById('accion').value='';
    document.getElementById('manual').value='';
       //  setTimeout(tiempo,100);
         f1.submit();
         
   
   
    }
}


function elimination(valor){
    if(valor==1){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnro1';
f1.submit();}
if(valor==2){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnro2';
f1.submit();}
if(valor==3){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnro3';
f1.submit();}
if(valor==4){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnro4';
f1.submit();}
if(valor==5){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnro5';
f1.submit();}
  if(valor==6){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnro6';
f1.submit();}
if(valor==7){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnro7';
f1.submit();}  
if(valor==8){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnro8';
f1.submit();}
if(valor==9){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnro9';
f1.submit();}
if(valor==10){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnro10';
f1.submit();}
}

function eliminitationa(valor){
    if(valor==1){ f1 = document.forms[0];
        
document.getElementById("accionHtml").value='eliminarnrom1';

f1.submit();}
     if(valor==2){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnrom2';
f1.submit();}
     if(valor==3){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnrom3';
f1.submit();}
     if(valor==4){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnrom4';
f1.submit();}
   if(valor==5){ f1 = document.forms[0];
document.getElementById("accionHtml").value='eliminarnrom5';
f1.submit();}  
    
    
}





function clicktocall(valorr) {
    
if(valorr==null){}else{    
f1 = document.forms[0];           
f1.telefonoSelect.value=valorr;
document.getElementById("accionHtml").value='llamadaManual';       
f1.submit();}}

function fllamar(){
    
f1 = document.forms[0];
var text = f1.numerox.value;
/*alert(text);*/
if (text=='' || text == null){
    alert("Ingresar Numero");
}
  else if(text.length < 9 ){
  
    alert("Ingresar como minimo nueve numeros");
    }else{
    
document.getElementById("accionHtml").value='Llamar';

f1.submit();
}

}

 function listado (fila) {
       
       
       if(fila ==1){
       
    f4 = document.forms[0];
    f4.numeroantiguo.value = f4.number1.value; 
    f4.parentescoantiguo.value=f4.parentescox1.value;
    f4.nombreantiguo.value=f4.nombrex1.value;
    f4.Telefono.value=f4.number1.value;
    f4.relacion.value=f4.parentescox1.value;
    f4.NombreParentesco.value=f4.nombrex1.value;
   // document.getElementById("numeroantiguo").innerHTML= f4.Telefono.value;  
     document.getElementById("relacion").disabled = true;
     document.getElementById("NombreParentesco").disabled = true;
      document.getElementById("Telefono").disabled = true;
      
      }
      if(fila==2){
      f4 = document.forms[0];
    f4.numeroantiguo.value = f4.number2.value; 
    f4.parentescoantiguo.value=f4.parentescox2.value;
    f4.nombreantiguo.value=f4.nombrex1.value;
    f4.Telefono.value=f4.number2.value;
    f4.relacion.value=f4.parentescox2.value;
    f4.NombreParentesco.value=f4.nombrex2.value;
   // document.getElementById("numeroantiguo").innerHTML= f4.Telefono.value;  
     document.getElementById("relacion").disabled = true;
     document.getElementById("NombreParentesco").disabled = true;
      document.getElementById("Telefono").disabled = true;
      
    
      
        }
        
         if(fila==3){
      f4 = document.forms[0];
    f4.numeroantiguo.value = f4.number3.value; 
    f4.parentescoantiguo.value=f4.parentescox3.value;
    f4.nombreantiguo.value=f4.nombrex3.value;
    f4.Telefono.value=f4.number3.value;
    f4.relacion.value=f4.parentescox3.value;
    f4.NombreParentesco.value=f4.nombrex3.value;
  //  document.getElementById("numeroantiguo").innerHTML= f4.Telefono.value;  
     document.getElementById("relacion").disabled = true;
     document.getElementById("NombreParentesco").disabled = true;
      document.getElementById("Telefono").disabled = true;
      
    
      
        }
         if(fila==4){
      f4 = document.forms[0];
    f4.numeroantiguo.value = f4.number4.value; 
    f4.parentescoantiguo.value=f4.parentescox4.value;
    f4.nombreantiguo.value=f4.nombrex4.value;
    f4.Telefono.value=f4.number4.value;
    f4.relacion.value=f4.parentescox4.value;
    f4.NombreParentesco.value=f4.nombrex4.value;
 //   document.getElementById("numeroantiguo").innerHTML= f4.Telefono.value;  
     document.getElementById("relacion").disabled = true;
     document.getElementById("NombreParentesco").disabled = true;
      document.getElementById("Telefono").disabled = true;}
        
            if(fila==5){
      f4 = document.forms[0];
    f4.numeroantiguo.value = f4.number5.value; 
    f4.parentescoantiguo.value=f4.parentescox5.value;
    f4.nombreantiguo.value=f4.nombrex5.value;
    f4.Telefono.value=f4.number5.value;
    f4.relacion.value=f4.parentescox5.value;
    f4.NombreParentesco.value=f4.nombrex5.value;
 //   document.getElementById("numeroantiguo").innerHTML= f4.Telefono.value;  
     document.getElementById("relacion").disabled = true;
     document.getElementById("NombreParentesco").disabled = true;
      document.getElementById("Telefono").disabled = true;}
        
           if(fila==6){
      f4 = document.forms[0];
    f4.numeroantiguo.value = f4.number6.value; 
    f4.parentescoantiguo.value=f4.parentescox6.value;
    f4.nombreantiguo.value=f4.nombrex6.value;
    f4.Telefono.value=f4.number6.value;
    f4.relacion.value=f4.parentescox6.value;
    f4.NombreParentesco.value=f4.nombrex6.value;
 //   document.getElementById("numeroantiguo").innerHTML= f4.Telefono.value;  
     document.getElementById("relacion").disabled = true;
     document.getElementById("NombreParentesco").disabled = true;
      document.getElementById("Telefono").disabled = true;} 
        
       if(fila==7){
      f4 = document.forms[0];
    f4.numeroantiguo.value = f4.number7.value; 
    f4.parentescoantiguo.value=f4.parentescox7.value;
    f4.nombreantiguo.value=f4.nombrex7.value;
    f4.Telefono.value=f4.number7.value;
    f4.relacion.value=f4.parentescox7.value;
    f4.NombreParentesco.value=f4.nombrex7.value;
 //   document.getElementById("numeroantiguo").innerHTML= f4.Telefono.value;  
     document.getElementById("relacion").disabled = true;
     document.getElementById("NombreParentesco").disabled = true;
      document.getElementById("Telefono").disabled = true;}     
     
         if(fila==8){
      f4 = document.forms[0];
    f4.numeroantiguo.value = f4.number8.value; 
    f4.parentescoantiguo.value=f4.parentescox8.value;
    f4.nombreantiguo.value=f4.nombrex8.value;
    f4.Telefono.value=f4.number8.value;
    f4.relacion.value=f4.parentescox8.value;
    f4.NombreParentesco.value=f4.nombrex8.value;
 //   document.getElementById("numeroantiguo").innerHTML= f4.Telefono.value;  
     document.getElementById("relacion").disabled = true;
     document.getElementById("NombreParentesco").disabled = true;
      document.getElementById("Telefono").disabled = true;}   
       if(fila==9){
      f4 = document.forms[0];
    f4.numeroantiguo.value = f4.number9.value; 
    f4.parentescoantiguo.value=f4.parentescox9.value;
    f4.nombreantiguo.value=f4.nombrex9.value;
    f4.Telefono.value=f4.number9.value;
    f4.relacion.value=f4.parentescox9.value;
    f4.NombreParentesco.value=f4.nombrex9.value;
 //   document.getElementById("numeroantiguo").innerHTML= f4.Telefono.value;  
     document.getElementById("relacion").disabled = true;
     document.getElementById("NombreParentesco").disabled = true;
      document.getElementById("Telefono").disabled = true;}     
        
        
        
   }
   
   
 function Elimiparent(){
       f1 = document.forms[0];
      
       document.getElementById('accionHtml').value='Eliminar';
    
       f1.submit();
   }
   
    
 function    gabventana(){
     
   
    f1 = document.forms[0];
   // var cod=  document.getElementById('rango').options[0].text;
     var indice = document.getElementById('rango').selectedIndex;

     if (indice=='0'){
       
    }else{
        document.getElementById('VentanaHoraria').disabled=true;
      document.getElementById('accionHtml').value='GrabarVentanaHoraria';
      f1.submit();
  
  }
 }

function modificarx(valor,conteo){
 
      var txtvar= 'nronuevo'+valor;
 ///alert(txtvar);
    var txttelef= document.getElementById(txtvar).value;
   // alert("telef de text "+txttelef);
    var cont = conteo ;
    var number= document.getElementById('numerito').value;
  //  alert("number de de ippc "+number);
    if (txttelef== number){
        
        alert("Numero existe");
    }
    else
   if(cont==2){
        var txtcamp1= document.getElementById('nronuevo1').value;
         var txtcamp2= document.getElementById('nronuevo2').value;
         
        /* alert("Telefono ingresa:"+txttelef);
         alert("tel 1"+txtcamp1);
         alert("tel 2"+txtcamp2); */
            
             if(valor==1){
                 
             if(txttelef==number  ||  txttelef == txtcamp2  ){
              
               alert("Numero existe");
               return;  
          }
          
          
    }else if(   txttelef==number  ||     txttelef == txtcamp1){  
            alert("Numero existe");
               return; 
             }  
           
            
            
            
             
    }else if(cont==3){
    
    
    
    var txtcamp1= document.getElementById('nronuevo1').value;
         var txtcamp2= document.getElementById('nronuevo2').value;
        var txtcamp3= document.getElementById('nronuevo3').value;  
        /* alert("Telefono ingresa:"+txttelef);
         alert("tel 1"+txtcamp1);
         alert("tel 2"+txtcamp2); */
            
             if(valor==1){
                 
             if(txttelef==number  ||  txttelef == txtcamp2  ||   txttelef ==txtcamp3 ){
              
               alert("Numero existe");
               return;  
          }
          
          
    }
    if ( valor ==2){
        
        
        
        if(   txttelef==number  ||     txttelef == txtcamp1 ||   txttelef ==txtcamp3   ){  
          alert("Numero existe");
               return; 
             }  
    
    
        }
        
    if (valor ==3)  {  
        
        if (txttelef==number  ||     txttelef == txtcamp2 ||   txttelef ==txtcamp1 ){
           alert("Numero existe");
               return; 
        }
    
        }
    
    }else if(cont==4){
        var txtcamp1= document.getElementById('nronuevo1').value;
        var txtcamp2= document.getElementById('nronuevo2').value;
       var txtcamp3= document.getElementById('nronuevo3').value;
       var txtcamp4= document.getElementById('nronuevo4').value;
       if(valor==1){
                 
             if(txttelef==number  ||  txttelef == txtcamp2  ||   txttelef ==txtcamp3 ||  txttelef ==txtcamp4  ){
              
              alert("Numero existe");
               return;  
          }
          
          
    }
    if ( valor ==2){
        
        if(   txttelef==number  ||     txttelef == txtcamp1 ||   txttelef ==txtcamp3  ||  txttelef ==txtcamp4  ){  
          alert("Numero existe");
               return; 
             }  
    
    
        }
    if(valor ==3)  {  
        
        
        
        if (txttelef==number  ||     txttelef == txtcamp2 ||   txttelef ==txtcamp1  ||  txttelef ==txtcamp4){
           alert("Numero existe");
               return; 
        }
         
         
         
         
        }
        
    if(valor ==4)  {      
        
         if (txttelef==number  ||     txttelef == txtcamp2 ||   txttelef ==txtcamp1  || txttelef ==txtcamp3){
               alert("Numero existe");
               return; 
        }
         
         
        }     
         
         
         
         
         
         
    }else if(cont==5){
    var txtcamp1= document.getElementById('nronuevo1').value;
        var txtcamp2= document.getElementById('nronuevo2').value;
       var txtcamp3= document.getElementById('nronuevo3').value;
       var txtcamp4= document.getElementById('nronuevo4').value;
       var txtcamp5= document.getElementById('nronuevo5').value;
       
       
         if(valor==1){
                 
             if(txttelef==number  ||  txttelef == txtcamp2  ||   txttelef ==txtcamp3 ||  txttelef ==txtcamp4 || txttelef ==txtcamp5 ){
              
                alert("Numero existe");
               return;  
          }
          
          
    }
    if ( valor ==2){
        
        if(   txttelef==number  ||     txttelef == txtcamp1 ||   txttelef ==txtcamp3  ||  txttelef ==txtcamp4 || txttelef ==txtcamp5 ){  
          alert("Numero existe");
               return; 
             }  
    
    
        }
    if(valor ==3)  {  
        
        
        
        if (txttelef==number  ||     txttelef == txtcamp2 ||   txttelef ==txtcamp1  ||  txttelef ==txtcamp4|| txttelef ==txtcamp5){
           alert("Numero existe");
               return; 
        }
         
         
         
         
        }
        
    if(valor ==4)  {      
        
         if (txttelef==number  ||     txttelef == txtcamp2 ||   txttelef ==txtcamp1  || txttelef ==txtcamp3|| txttelef ==txtcamp5){
                 alert("Numero existe");
               return; 
        }
         
         
        }     
     if(valor ==5)  {    
         
     if (txttelef==number  ||     txttelef == txtcamp2 ||   txttelef ==txtcamp1  || txttelef ==txtcamp3|| txttelef ==txtcamp4){
                alert("Numero existe");
               return; 
        }     
         
         
         
     }   
        
    }
   
    
   /* 
    if(txttelef==txtcamp1 || txttelef==txtcamp2 || txttelef==txtcamp3 ||txttelef==txtcamp4 ||txttelef==txtcamp5 ){
     
     alert("El numero ya existe12");   
        
    }else*/
    
    
    
    
    
 if(txttelef==''){
     alert("Ingresar N\u00famero");
 }else if(txttelef.length < 9) {
     alert("Ingresar  como minimo 9 n\u00fameros");
     
 }else /*if(txttelef==number){
          alert("El numero ya existe");
     }else*/
 
    if(valor==1){ f1 = document.forms[0];
      document.getElementById('imgippcsave').style.display='none';
        document.getElementById("accionHtml").value='modificarnro1';
 
    f1.submit();


}
     if(valor==2){ f1 = document.forms[0];
           document.getElementById('imgippcsave').style.display='none';
    document.getElementById("accionHtml").value='modificarnro2';
    f1.submit();}
     if(valor==3){ f1 = document.forms[0];
           document.getElementById('imgippcsave').style.display='none';
    document.getElementById("accionHtml").value='modificarnro3';
    f1.submit();}
      if(valor==4){ f1 = document.forms[0];
   document.getElementById("accionHtml").value='modificarnro4';
    f1.submit();}
      if(valor==5){ f1 = document.forms[0];
   document.getElementById("accionHtml").value='modificarnro5';
    f1.submit();}
  if(valor==6){ f1 = document.forms[0];
   document.getElementById("accionHtml").value='modificarnro6';
    f1.submit();}

  if(valor==7){ f1 = document.forms[0];
   document.getElementById("accionHtml").value='modificarnro7';
    f1.submit();}
  if(valor==8){ f1 = document.forms[0];
   document.getElementById("accionHtml").value='modificarnro8';
    f1.submit();}
  if(valor==9){ f1 = document.forms[0];
   document.getElementById("accionHtml").value='modificarnro9';
    f1.submit();}
  if(valor==10){ f1 = document.forms[0];
   document.getElementById("accionHtml").value='modificarnro10';
    f1.submit();}
 }


            function modifica() {
           
       
                document.getElementById("text_1").disabled = false;
                 document.getElementById("text_2").disabled = false;
                 document.getElementById("text_3").disabled = false;
                 document.getElementById("text_4").disabled = false;
                 }
               

            function LlamadaManual() {
          // alert("jossy cabro");
               document.getElementById('div1').style.display = 'block';

        //f1.submit();


            }
            
            
            function GuardarNumero(){ 
            
    ///alert("agregara");
    
    f1 = document.forms[0];
    
    
       /// var txtvar= 'nronuevo'+valor;
 ///alert(txtvar);
    var txttelef= document.getElementById('nronuevo').value;
 if(txttelef==''){
     alert("Ingresar N\u00famero");
 }else if(txttelef.length < 9) {
     alert("Ingresar  como minimo 9 numeros");
     
 }else{
    document.getElementById('imanumnew').style.display='none';
     document.getElementById("accionHtml").value='Grabar';
     f1.submit();
 }
    }
            
            
            
  function AgregarNro() {
         //alert("Agrega nuevo numero");
               document.getElementById('div1').style.display = 'block';

        //f1.submit();


            }
            
        function  modificarcontacto () {f4 = document.forms[0];
            f4.contactoa.value=f4.contacto.value;
         document.getElementById("contacto").disabled = true;
  
    }
            
        function valorcontador(){
            var contador=  document.getElementById("contador").value;
            var consultor="consultor";
            var campaña= f1.campana.value;
             var campa= f1.campaign.value;
            var   codCliente= f1.codCliente.value;
            var manual="manual";
            var drop="drop";
            //alert("Entro al valorccontador");
           window.open("http://10.165.70.249:8084/FichaClienteSAC1mada.jsp?campana="+campaña.toString()+"&consultor="+consultor+"&contador="+contador+"&campa="+campa+"&manual="+manual+"&Drop="+drop+"&codcli="+codCliente,"detalle");
        }   
        
 function  modificaContacto() {
    // alert ("entra todito");
f4 = document.forms[0];
 f4.contacto1.value=f4.contacto.value;
 document.getElementById("contacto").disabled = false;
 
    
    }       
        
        
function  modificanro1() {
f4 = document.forms[0];

 f4.nroantiguo1.value=f4.nronuevo1.value;

 document.getElementById("nronuevo1").disabled = false;

}
 
 
 
function  modificanro2() { 
f4 = document.forms[0];
f4.nroantiguo2.value=f4.nronuevo2.value;
document.getElementById("nronuevo2").disabled = false;
}function  modificanro3() {
f4 = document.forms[0];
f4.nroantiguo3.value=f4.nronuevo3.value;        
document.getElementById("nronuevo3").disabled = false;}
function  modificanro4() {
f4 = document.forms[0];
f4.nroantiguo4.value=f4.nronuevo4.value;          
document.getElementById("nronuevo4").disabled = false;}
function  modificanro5() {
f4 = document.forms[0];
f4.nroantiguo5.value=f4.nronuevo5.value;          
document.getElementById("nronuevo5").disabled = false;}
function  modificanroagregado1() {
f4 = document.forms[0];
f4.nroantiguoa1.value=f4.nronuevoa1.value;          
document.getElementById("nronuevoa1").disabled = false;}      
function  modificanroagregado2() {
f4 = document.forms[0];
f4.nroantiguoa2.value=f4.nronuevoa2.value;          
document.getElementById("nronuevoa2").disabled = false;}
function  modificanroagregado3() {
f4 = document.forms[0];
f4.nroantiguoa3.value=f4.nronuevoa3.value;          
document.getElementById("nronuevoa3").disabled = false;}
function  modificanroagregado4() {
f4 = document.forms[0];
f4.nroantiguoa4.value=f4.nronuevoa4.value;          
document.getElementById("nronuevoa4").disabled = false;}
function  modificanroagregado5() {
f4 = document.forms[0];
f4.nroantiguoa5.value=f4.nronuevoa5.value;          
document.getElementById("nronuevoa5").disabled = false;}

function  modificanroagregado6() {
f4 = document.forms[0];
f4.nroantiguoa6.value=f4.nronuevoa6.value;          
document.getElementById("nronuevoa6").disabled = false;}

function  modificanroagregado7() {
f4 = document.forms[0];
f4.nroantiguoa7.value=f4.nronuevoa7.value;          
document.getElementById("nronuevoa7").disabled = false;}
function  modificanroagregado8() {
f4 = document.forms[0];
f4.nroantiguoa8.value=f4.nronuevoa8.value;          
document.getElementById("nronuevoa8").disabled = false;}
function  modificanroagregado9() {
f4 = document.forms[0];
f4.nroantiguoa9.value=f4.nronuevoa9.value;          
document.getElementById("nronuevoa9").disabled = false;}
function  modificanroagregado10() {
f4 = document.forms[0];
f4.nroantiguoa10.value=f4.nronuevoa10.value;          
document.getElementById("nronuevoa10").disabled = false;}





  function redireccionar(text){//aqui falta un parametro para que sepa si esta
      //en estado manual o no preaprado
             location.href= text;
             document.getElementById('div2').style.display = 'none'; 
        }
  
function redireccionarconcliente(text){//aqui falta un parametro para que sepa si esta
      //en estado manual o no preaprado
             location.href= text;
             document.getElementById('div2').style.display = 'block'; 
        }

 function  fonavi(){
       f5 = document.forms[0]; 
       ///alert("joooo");
      document.getElementById('accionHtml').value='regresa';
   /// document.getElementById('tdmensaje').innerHTML='Estas en Llamada';
 f5.submit();

 
}
 


