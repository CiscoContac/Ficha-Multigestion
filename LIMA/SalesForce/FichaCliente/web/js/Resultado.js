 
 
 

 
 
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
  function envase(id,habilita){
     
    var rd1= document.getElementById('rdSi').checked;
     var rd2 = document.getElementById('rdNo').checked;
     var rid=  document.getElementById('radioenvase').checked;
    // alert(id);
    // alert(rid);
if (rd1 == false && rd2==false   )
    
     {  
         document.getElementById(id).checked=false;
       alert("elegir contacto al Cliente");
         
 }
if (rid == false)  {
     document.getElementById('txtenvase').disabled=true;
      document.getElementById('txtenvase').value='';
     
 }else {
        document.getElementById('txtenvase').disabled=false;
     
 }
 
 } 
 
 function valmodifica(radio,fecha,var1,var2,var3,var4,var5,var6,var7,var8,var9,var10,id){
     
        
        var f = new Date();
       var fc= f.getDate()+"/"+ (f.getMonth()+ 1 )+"/"+f.getFullYear();
      var cort= radio.substring(3,4);
        var camp=document.getElementById("dat"+cort).innerHTML;
       var cort2= camp.substr(0,9);
    
       
       
       //id de la fila 
           
       var cod=  document.getElementById(id).innerHTML;
       
         document.getElementById('codmodifi') .value= cod;
         
        var  txt1 =   document.getElementById(var1).innerHTML;
            // alert(txt1);
             var txt2 =  document.getElementById(var2).innerHTML;
             // alert(txt2);
             var txt3=  document.getElementById(var3).innerHTML;
              //alert(txt3);
             var txt4 =  document.getElementById(var4).innerHTML;
            // alert(txt4);
             var txt5 =  document.getElementById(var5).innerHTML;
             /// alert(txt5);
             var txt6 =  document.getElementById(var6).innerHTML;
            /// alert(txt6);
             var txt7 =  document.getElementById(var7).innerHTML;
            /// alert(txt7);
             var txt8 =  document.getElementById(var8).innerHTML;
              /// alert(txt8);
             var txt9 =  document.getElementById(var9).innerHTML;
             var txt10= document.getElementById(var10).innerHTML;
            // alert(txt9);
          
       
    // alert(fc);
    // alert(cort2);
 
         if   (fc.toString() == cort2.toString()) {
          
        // var cod=   document.getElementById(id).innerHTML;
         document.getElementById('button').disabled=true;
            //document.getElementById(radio).checked=false;
           

             document.getElementById(var1).innerHTML = '';
              document.getElementById(var2).innerHTML = '';
              document.getElementById(var3).innerHTML = '';
              document.getElementById(var4).innerHTML = '';
              document.getElementById(var5).innerHTML = '';
              document.getElementById(var6).innerHTML = '';
              document.getElementById(var7).innerHTML = '';
              document.getElementById(var8).innerHTML = '';
              document.getElementById(var9).innerHTML = '';
              document.getElementById(var10).innerHTML = '';
             
             var inp1 = document.getElementById(var1).appendChild(document.createElement('input'));
             var inp2 = document.getElementById(var2).appendChild(document.createElement('input'));
             var inp3 = document.getElementById(var3).appendChild(document.createElement('input'));
             var inp4 = document.getElementById(var4).appendChild(document.createElement('input'));
             var inp5 = document.getElementById(var5).appendChild(document.createElement('input'));
             var inp6 = document.getElementById(var6).appendChild(document.createElement('input'));
             var inp7 = document.getElementById(var7).appendChild(document.createElement('input'));
             var inp8 = document.getElementById(var8).appendChild(document.createElement('input'));
             var inp9 = document.getElementById(var9).appendChild(document.createElement('input'));
             var inp10 = document.getElementById(var10).appendChild(document.createElement('input'));
             
            inp1.value=txt1;
            document.getElementById('llamada').value= txt1;
            inp2.value=txt2;
            document.getElementById('norespondio').value= txt2;
            inp3.value=txt3;
            document.getElementById('realizventa').value=txt3;
            inp4.value=txt4;
             document.getElementById('descripventa').value= txt4;
            inp5.value=txt5;
            document.getElementById('noventacer').value=txt5;
            inp6.value=txt6;
            document.getElementById('noventagase').value=txt6;
            inp7.value=txt7;
             document.getElementById('noventaagua').value=txt7;
            inp8.value=txt8;
            document.getElementById('nomalta').value=txt8;
            inp9.value=txt9;
            document.getElementById('nocategoria').value=txt9;
            inp10.value=txt10;
            document.getElementById('valortipogestion').value=txt10;
            
               inp1.onblur = function() { 
                                       document.getElementById('llamada').value= this.value;}   
                               
           inp2.onblur = function() { this.parentNode.innerHTML = this.value ;
                                      document.getElementById('norespondio').value= this.value;
                                           }                           
           inp3.onblur = function() { //this.parentNode.innerHTML = this.value;
                                       document.getElementById('realizventa').value= this.value;   }   
           inp4.onblur = function() { //this.parentNode.innerHTML = this.value;
                                      document.getElementById('descripventa').value= this.value;}                           
           inp5.onblur = function() { //this.parentNode.innerHTML = this.value;
                                      document.getElementById('noventacer').value= this.value;}                           
           inp6.onblur = function() { //this.parentNode.innerHTML = this.value;
                                       document.getElementById('noventagase').value= this.value;}   
           inp7.onblur = function() { //this.parentNode.innerHTML = this.value ;
                                         document.getElementById('noventaagua').value= this.value;} 
           inp8.onblur = function() {// this.parentNode.innerHTML = this.value;
                                            document.getElementById('nomalta').value= this.value;} 
           inp9.onblur = function() {// this.parentNode.innerHTML = this.value ;
                                            document.getElementById('nocategoria').value= this.value;}  
                                        
            inp10.onblur = function() {// this.parentNode.innerHTML = this.value ;
                                            document.getElementById('valortipogestion').value= this.value;}                              
                                 
                 //  modifica(); 

       }else{    
            alert("solo se puede modificar la fecha del dia");  
           document.getElementById(radio).checked=false;
  } 
   }   
 function gestiadicion(id,habilita){
     
    var rd1= document.getElementById('rdSi').checked;
     var rd2 = document.getElementById('rdNo').checked;
     var rid=  document.getElementById('radio3').checked;
    // alert(id);
    // alert(rid);
if (rd1 == false && rd2==false   )
    
     {  
         document.getElementById(id).checked=false;
       alert("elegir contacto al Cliente");
         
 }
if (rid == false)  {
     document.getElementById('txtcobranza').disabled=true;
     document.getElementById('txtcobranza').value='';
 }else {
        document.getElementById('txtcobranza').disabled=false;
     
 }
 
 }  
 
  function gestirecojo(id,habilita){
     
    var rd1= document.getElementById('rdSi').checked;
     var rd2 = document.getElementById('rdNo').checked;
     var rid=  document.getElementById('radiorecojo').checked;
    // alert(id);
    // alert(rid);
if (rd1 == false && rd2==false   )
    
     {  
         document.getElementById(id).checked=false;
       alert("elegir contacto al Cliente");
         
 }
if (rid == false)  {
     document.getElementById('txtrecojo').disabled=true;
      document.getElementById('txtrecojo').value='';
     
 }else {
        document.getElementById('txtrecojo').disabled=false;
     
 }
 
 } 
 
 
 function evento (id ,texto){
   var rd1= document.getElementById('rdSi').checked;
     var rd2 = document.getElementById('rdNo').checked;
     var rdid=document.getElementById(id).checked;
    // alert(rdid);
if (rd1 == false && rd2==false   )
    
     {  
         document.getElementById(id).checked=false;
       alert("elegir contacto al Cliente");
         
     } if( rdid== true){
     
      document.getElementById(texto).value='Si';
    //  alert(document.getElementById(texto).value);
 }else{
      document.getElementById(texto).value='';
 }   
     
 }
      function ActualizarResultadoVentana(celda,id){
          var hoy = new Date();
 var dia = hoy.getDate(); 
 var mes = hoy.getMonth()+1;
 var anio= hoy.getFullYear();
// var checked= document.getElementById(celda).checked;
 //alert(checked);
 //if(checked==true){
 //document.getElementById(celda).checked=false;    
 //}
 if(mes <= 9){
     mes="0"+mes;
 }
 if(dia<=9){
 dia="0"+dia   ; 
 }
    var fecha_actual = String(dia+"/"+mes+"/"+anio);
   // alert(fecha_actual);
    var cort= celda.substring(3);
//    alert(celda);
    var camp=document.getElementById("dat"+cort).innerHTML;
  //  alert(camp);
    var cort2= camp.substr(0,10);
     var fech1=  fecha_actual.toString();
     var fech2= cort2.toString();
    // alert(fech1);
      //alert(fech2);
     if    (fech1 == fech2) {
          document.getElementById('idactualizado').value=id;
         // alert(document.getElementById('idactualizado').value);
      }else{
          alert("Solo Puede Modificar  la Fecha de Hoy");
          document.getElementById(celda).checked=false;
      }
     // alert("mando id");
       
       
       
      }
  function Modifica(ventaruta){
      
         f1 = document.forms[0]; 
               var radionocontac= f1.rdNo.checked;
               var sicontacto=f1.rdSi.checked;
               var cbtipogestion  = f1.valortipogestion.value;
               var cbrazonnocontac= f1.valorcbxrazonllamada.value;
               
              var rsventasi= f1.chbsi.checked;
              var  rsventano= f1.checkbox4.checked;
              ///alert("check resu no venta "+rsventano );
              var cbrznoventa= f1.valorcbxnocerveza.value;
   var evento =  f1.radio.checked;          
  var   recojo = f1. radiorecojo.checked;
 var cobranza =   f1.radio3.checked;
  var txtcobra = f1.txtcobranza.value;
 
  var txtrecojo = f1.txtrecojo.value;
   var rd1= document.getElementById('rdSi').checked;
     var rd2 = document.getElementById('rdNo').checked;


 var indice = document.getElementById('cbxrazonventa2').selectedIndex;
   
        var tabla=  document.getElementById('tbResuLlamada');
    var rowCount = tabla.rows.length;
   /// alert(rowCount);
    var validacheck;
 
    for(var i=0; i<rowCount; i++) {

                   /// var row = tabla.rows[i];

                   /// var chkbox = row.cells[0].childNodes[0] ;
                    
                var chkvar= 'chb'+i;
              
                var checked=  document.getElementById(chkvar).checked;
               
         
         
                   
                  if(true == checked ){
                      validacheck=true;
                        var idx= 'id'+i;
                         var varid=document.getElementById(idx).innerHTML;
                       
                    }
                }
  //// alert(validacheck);
    
  if(validacheck != true    ){
       alert("Por Favor seleccionar un registro");      
  }else if(rsventano == true && indice=="0")  {
           
     alert("Seleccionar  Raz\u00f3n No venta");      
       } else
if (rd1 == false && rd2==false   )
    
     {  
       //  document.getElementById(id).checked=false;
       alert("Tipificar un Resultado de Gesti\u00f3n");
         
 }else if( radionocontac == true && cbrazonnocontac=='' ){
              alert("Seleccione raz\u00f3n no contacto");
           }else if(sicontacto== true  && cbtipogestion !='' && (rsventano== false && rsventasi==false) ){
               
                   alert("Seleccione Resultado de Venta");
               
           }else if(sicontacto== true  && cbtipogestion =='' &&(evento == false &&  recojo ==false && cobranza ==false  )){
               alert("Seleccione tipo de Gesti\u00f3n");
           }else if(rsventano == true && cbrznoventa ==''){
                   alert("Seleccione Raz\u00f3n no venta");
           }else if((recojo== true  && txtrecojo =='' )){
                alert("llene datos en la caja de recojo");
           }else if(cobranza== true && txtcobra =='' ){
                alert("llene datos en la caja de cobranza");
           }  
            
           
           
           else{    
       if(sicontacto==true){
            document.getElementById('contacto').value='sicontacto';
       } else if(radionocontac== true){
             document.getElementById('contacto').value='nocontacto';
       }
           ///   alert(ventaruta);
             ///if(ventaruta > 0) {
      if(ventaruta > 0 &&  rsventasi==true){
           alert("Ya tiene venta realizado con este c\u00f3digo");
        } else if(ventaruta ==0 && rsventasi==true )     {
              document.getElementById('ventaruta').value='ventaruta';
              document.getElementById('imagrabaresulta').style.display='none';
                f1.accionResul.value = 'Modifica';
                f1.action = 'ServletResu';
                f1.method = 'POST';
                f1.submit();
        } else if (ventaruta > 0  &&  rsventasi==false){
            if (confirm("Ya tiene grabado una venta con este c\u00f3digo ¿ Desea realizar otra gesti\u00f3n?")) {
                 document.getElementById('imagrabaresulta').style.display='none';
                  document.getElementById('ventaruta').value='noruta';
                 f1.accionResul.value = 'Modifica';
                f1.action = 'ServletResu';
                f1.method = 'POST';
                f1.submit();
            }
        }else{
   /// }else{
        document.getElementById('imagrabaresulta').style.display='none';
         f1.accionResul.value = 'Modifica';
                f1.action = 'ServletResu';
                f1.method = 'POST';
                f1.submit();
 }
          
  } 
  
  }
     
function habilitar()
{
    
   f1 = document.forms[0]; 
   var ele = f1.rdSi.checked;
       
   var texto=  f1.rdSi.value;

   f1.valoradio.value= texto;
  
   if (ele == true){
       
      
          document.getElementById('valorcbxrazonllamada').value="";
          document.getElementById('selectResuLlamada').selectedIndex='0';
        document.getElementById('selectResuLlamada').disabled = true; 
        document.getElementById('rdNo').checked = false; 
         document.getElementById('tipogestion').disabled=false;
       //  document.getElementById('radgenesi').disabled=false;
         //  document.getElementById('radgeneno').disabled=false;
   }
     
 }
 
 
 
 function deshabilitar()  
 { f2 = document.forms[0]; 
  var ele2 = f2.rdNo.checked;
   var texto=  f2.rdNo.value;
   f2.valoradio.value= texto;
  if (ele2 == true){
      
         document.getElementById('rdSi').checked = false;
          document.getElementById('selectResuLlamada').disabled = false; 
          
            document.getElementById('tipogestion').disabled=true;
           
            document.getElementById('tipogestion').selectedIndex='0';
            document.getElementById('valortipogestion').value='';
           
            //document.getElementById('radgenesi').disabled=true;
             
           // document.getElementById('radgeneno').disabled=true;
              document.getElementById('chbsi').disabled=true; 
          document.getElementById('checkbox4').disabled=true; 
            /*document.getElementById('checkbox5').disabled=true; 
            document.getElementById('checkbox6').disabled=true; 
            document.getElementById('checkbox7').disabled=true; 
            document.getElementById('checkbox8').disabled=true; 
            document.getElementById('checkbox9').disabled=true; 
            document.getElementById('checkbox10').disabled=true; */
            
            
            
            
            
            
             document.getElementById('chbsi').checked=false;
           document.getElementById('checkbox4').checked=false;
          // document.getElementById('checkbox5').checked=false;
          //  document.getElementById('checkbox6').checked=false;
          //  document.getElementById('checkbox7').checked=false;
          //  document.getElementById('checkbox8').checked=false;
          /////  document.getElementById('checkbox9').checked=false;
          //  document.getElementById('checkbox10').checked=false; 
            
       
       document.getElementById('valorcbxnocerveza').value='';
       document.getElementById('valorcbxnogaseosas').value='';
       document.getElementById('valorcbxnoagua').value='';
       document.getElementById('valorcbxnomalta').value='';
         
         
         document.getElementById('cbxrazonventa2').selectedIndex='0';
      // document.getElementById('cbxrazonventa3').selectedIndex='0';
      // document.getElementById('cbxrazonventa4').selectedIndex='0';
       //document.getElementById('cbxrazonventa5').selectedIndex='0';
         
         
         
          document.getElementById('cbxrazonventa2').disabled=true;
       //document.getElementById('cbxrazonventa3').disabled=true;
      // document.getElementById('cbxrazonventa4').disabled=true;
      // document.getElementById('cbxrazonventa5').disabled=true;
       
        /// alert("este 1111111");
         
         document.getElementById('valorrbcerveza').value = '';
         document.getElementById('valorrbgaseosa').value = '';
          document.getElementById('valorrbagua').value = '';
           document.getElementById('valorrbmalta').value = '';


document.getElementById('radio3').checked=false;
document.getElementById('radiorecojo').checked=false;
document.getElementById('radio').checked=false;

document.getElementById('radio3').disabled=true;
document.getElementById('radiorecojo').disabled=true;
document.getElementById('radio').disabled=true;


document.getElementById('txtrecojo').value='';
document.getElementById('txtcobranza').value='';

document.getElementById('txtrecojo').disabled=true;
document.getElementById('txtcobranza').disabled=true;
        }
 }
   function habisi(valor,cbm,valono,cattext,etino){
  
   var ele = document.getElementById(valor).checked;
  // var texto=  valor.value;
   if (ele == true){
        document.getElementById(cbm).disabled = true; 
        document.getElementById(valono).checked = false; 
         document.getElementById(cattext).value = "si"; 
         
         
         ///setaer vacio la etiqueta
         
         document.getElementById(etino).value='';
         document.getElementById(cbm).selectedIndex='0';
           
           // document.getElementById('btnEliminarresullamada').disabled = true; 
         document.getElementById('radio').disabled=false;
   }
   
   }
   
   function habino(valor,cbm,valosi,cattext){
  
   var ele = document.getElementById(valor).checked;
  // var texto=  valor.value;
   if (ele == true){
        document.getElementById(cbm).disabled = false; 
        document.getElementById(valosi).checked = false; 
        document.getElementById(cattext).value = "No"; 
         // document.getElementById('btnEliminarresullamada').disabled = true; 
              document.getElementById('radio').disabled=true;
   }    
   
   }
   
   
function tipoGestion(cbvalor,txtvalor){
    var indice = document.getElementById(cbvalor).selectedIndex;
   
       if(indice=="1" || indice == "2" || indice=="3" ||indice=="4")  {
       
             document.getElementById('chbsi').disabled=false; 
            document.getElementById('checkbox4').disabled=false; 
document.getElementById('radio').disabled=false;
document.getElementById('radiorecojo').disabled=false;
document.getElementById('radioenvase').disabled=false;
document.getElementById('radio3').disabled=false;
       }else{
            document.getElementById('chbsi').disabled=true; 
            document.getElementById('radio').disabled=true;
            document.getElementById('txtrecojo').disabled=true;
            document.getElementById('txtevento').disabled=true;
            document.getElementById('txtcobranza').disabled=true;
            document.getElementById('radiorecojo').disabled=true;
            document.getElementById('radioevento').disabled=true;
            document.getElementById('radio3').disabled=true;            
            document.getElementById('checkbox4').disabled=true; 
            
             document.getElementById('checkbox4').checked=false; 
             document.getElementById('chbsi').checked=false; 
             document.getElementById('radio').checked=false;
            document.getElementById('radiorecojo').checked=false;
             document.getElementById('radioevento').checked=false;
            document.getElementById('radio3').checked=false;
             


            document.getElementById('txtrecojo').value='';
            document.getElementById('txtcobranza').value='';
            document.getElementById('valorrbcerveza').value='';
            document.getElementById('txtevento').value='';




       }  
           

    var textoEscogido = document.getElementById(cbvalor).options[indice].text;
  /// alert(textoEscogido);
       document.getElementById(txtvalor).value=textoEscogido;
}

    function dimePropiedades(cbvalor,txtvalor){
    var texto;
    
    var indice = document.getElementById(cbvalor).selectedIndex;
    var textoEscogido = document.getElementById(cbvalor).options[indice].text;
  // alert(textoEscogido);
       document.getElementById(txtvalor).value=textoEscogido;
}
  /*
function enviar(){
  
                f1 = document.forms[0]; 
               var radionocontac= f1.rdNo.checked;
               var sicontacto=f1.rdSi.checked;
               var cbtipogestion  = f1.valortipogestion.value;
               var cbrazonnocontac= f1.valorcbxrazonllamada.value;
               
              var rsventasi= f1.chbsi.checked;
              var  rsventano= f1.checkbox4.checked;
              //alert("check resu no venta "+rsventano );
              var cbrznoventa= f1.valorcbxnocerveza.value;
   var evento =  f1.radio.checked;          
  var   recojo = f1. radiorecojo.checked;
 var cobranza =   f1.radio3.checked;
  var txtcobra = f1.txtcobranza.value;
 
  var txtrecojo = f1.txtrecojo.value;
   var rd1= document.getElementById('rdSi').checked;
     var rd2 = document.getElementById('rdNo').checked;
 var indice = document.getElementById('cbxrazonventa2').selectedIndex;
   
       if(rsventano == true && indice=="0")  {
           
     alert("Seleccionar  Raz\u00f3n No venta");      
       }else
if (rd1 == false && rd2==false   )
    
     {  
       //  document.getElementById(id).checked=false;
       alert("Tipificar un Resultado de Gesti\u00f3n");
         
 }else if( radionocontac == true && cbrazonnocontac=='' ){
              alert("Seleccione raz\u00f3n no contacto");
           }else if(sicontacto== true  && cbtipogestion !='' && (rsventano== false && rsventasi==false) ){
               
                   alert("Seleccione Resultado de Venta");
               
           }else if(sicontacto== true  && cbtipogestion =='' &&(evento == false &&  recojo ==false && cobranza ==false  )){
               alert("Seleccione tipo de Gesti\u00f3n");
           }else if(rsventano == true && cbrznoventa ==''){
                   alert("Seleccione Raz\u00f3n no venta");
           }else if((recojo== true  && txtrecojo =='' )){
                alert("llene datos en la caja de recojo");
           }else if(cobranza== true && txtcobra =='' ){
                alert("llene datos en la caja de cobranza");
           }  
            
           
           
           else{    
                
                document.getElementById('imagrabaresulta').style.display='none';
                f1.accionResul.value = 'GrabaResultado';
                f1.action = 'ServletResu';
                f1.method = 'POST';
                f1.submit();
            }
} 
/*function enviar(contdia ,contaventa){

                f1 = document.forms[0]; 
               var radionocontac= f1.rdNo.checked;
               var sicontacto=f1.rdSi.checked;
               var cbtipogestion  = f1.valortipogestion.value;
               var cbrazonnocontac= f1.valorcbxrazonllamada.value;
               
              var rsventasi= f1.chbsi.checked;
              var  rsventano= f1.checkbox4.checked;
              //alert("check resu no venta "+rsventano );
              var cbrznoventa= f1.valorcbxnocerveza.value;
   var evento =  f1.radio.checked;          
  var   recojo = f1. radiorecojo.checked;
 var cobranza =   f1.radio3.checked;
  var txtcobra = f1.txtcobranza.value;
 
  var txtrecojo = f1.txtrecojo.value;
   var rd1= document.getElementById('rdSi').checked;
     var rd2 = document.getElementById('rdNo').checked;
 var indice = document.getElementById('cbxrazonventa2').selectedIndex;
   
       if(rsventano == true && indice=="0")  {
           
     alert("Seleccionar  Raz\u00f3n No venta");      
       }else
if (rd1 == false && rd2==false   )
    
     {  
       //  document.getElementById(id).checked=false;
       alert("Tipificar un Resultado de Gesti\u00f3n");
         
 }else if( radionocontac == true && cbrazonnocontac=='' ){
              alert("Seleccione raz\u00f3n no contacto");
           }else if(sicontacto== true  && cbtipogestion !='' && (rsventano== false && rsventasi==false) ){
               
                   alert("Seleccione Resultado de Venta");
               
           }else if(sicontacto== true  && cbtipogestion =='' &&(evento == false &&  recojo ==false && cobranza ==false  )){
               alert("Seleccione tipo de Gesti\u00f3n");
           }else if(rsventano == true && cbrznoventa ==''){
                   alert("Seleccione Raz\u00f3n no venta");
           }else if((recojo== true  && txtrecojo =='' )){
                alert("llene datos en la caja de recojo");
           }else if(cobranza== true && txtcobra =='' ){
                alert("llene datos en la caja de cobranza");
           }  
           else{
              // alert(contaventa);
           if( contaventa>0   ){
               
         if(contaventa >0 && rsventasi==true ){
             alert("Ya tiene venta realizado con este c\u00f3digo");
         }else
          if(contdia > 0){
   if (confirm("Ya tiene grabado una venta con este c\u00f3digo ¿ Desea realizar otra gesti\u00f3n?")) {
// Respuesta afirmativa...      
                document.getElementById('imagrabaresulta').style.display='none';
                f1.accionResul.value = 'GrabaResultado';
                f1.action = 'ServletResu';
                f1.method = 'POST';
                f1.submit();
            }
        }
        
                  }else{
            document.getElementById('imagrabaresulta').style.display='none';
                f1.accionResul.value = 'GrabaResultado';
                f1.action = 'ServletResu';
                f1.method = 'POST';
                f1.submit(); 
        }
            }
      
           
} */
 
 function enviar(ventaruta){

                f1 = document.forms[0]; 
               var radionocontac= f1.rdNo.checked;
               var sicontacto=f1.rdSi.checked;
               var cbtipogestion  = f1.valortipogestion.value;
               var cbrazonnocontac= f1.valorcbxrazonllamada.value;
              var cod= f1.codcli.value;
            /////  alert(cod);
              var rsventasi= f1.chbsi.checked;
              var  rsventano= f1.checkbox4.checked;
              //alert("check resu no venta "+rsventano );
              var cbrznoventa= f1.valorcbxnocerveza.value;
   var evento =  f1.radio.checked;          
  var   recojo = f1. radiorecojo.checked;
 var cobranza =   f1.radio3.checked;
  var txtcobra = f1.txtcobranza.value;
 
  var txtrecojo = f1.txtrecojo.value;
   var rd1= document.getElementById('rdSi').checked;
     var rd2 = document.getElementById('rdNo').checked;
 var indice = document.getElementById('cbxrazonventa2').selectedIndex;
   if(cod=='null' || cod=='' ){
          alert("Seleccionar un cliente");    
   }else
       if(rsventano == true && indice=="0")  {
           
     alert("Seleccionar  Raz\u00f3n No venta");      
       }else
if (rd1 == false && rd2==false   )
    
     {  
       //  document.getElementById(id).checked=false;
       alert("Tipificar un Resultado de Gesti\u00f3n");
         
 }else if( radionocontac == true && cbrazonnocontac=='' ){
              alert("Seleccione raz\u00f3n no contacto");
           }else if(sicontacto== true  && cbtipogestion !='' && (rsventano== false && rsventasi==false) ){
               
                   alert("Seleccione Resultado de Venta");
               
           }else if(sicontacto== true  && cbtipogestion =='' &&(evento == false &&  recojo ==false && cobranza ==false  )){
               alert("Seleccione tipo de Gesti\u00f3n");
           }else if(rsventano == true && cbrznoventa ==''){
                   alert("Seleccione Raz\u00f3n no venta");
           }else if((recojo== true  && txtrecojo =='' )){
                alert("llene datos en la caja de recojo");
           }else if(cobranza== true && txtcobra =='' ){
                alert("llene datos en la caja de cobranza");
           }  
           else{
              /// alert(ventaruta);
              
       if(sicontacto==true){
            document.getElementById('contacto').value='sicontacto';
       } else if(radionocontac== true){
             document.getElementById('contacto').value='nocontacto';
       }
             //// alert(ventaruta);
             ///if(ventaruta > 0) {
        if(ventaruta > 0 &&  rsventasi==true){
           alert("Ya tiene venta realizado con este c\u00f3digo");
        } else if(ventaruta ==0 && rsventasi==true )     {
              document.getElementById('ventaruta').value='ventaruta';
              document.getElementById('imagrabaresulta').style.display='none';
                f1.accionResul.value = 'GrabaResultado';
                f1.action = 'ServletResu';
                f1.method = 'POST';
                f1.submit();
        } else if (ventaruta > 0  &&  rsventasi==false){
            if (confirm("Ya tiene grabado una venta con este c\u00f3digo ¿ Desea realizar otra gesti\u00f3n?")) {
                 document.getElementById('imagrabaresulta').style.display='none';
                  document.getElementById('ventaruta').value='noruta';
                  document.getElementById('actuventa').value='actuventa';
                 f1.accionResul.value = 'GrabaResultado';
                f1.action = 'ServletResu';
                f1.method = 'POST';
                f1.submit();
            }
        }else{
   /// }else{
        document.getElementById('imagrabaresulta').style.display='none';
         f1.accionResul.value = 'GrabaResultado';
                f1.action = 'ServletResu';
                f1.method = 'POST';
                f1.submit();
 }
               
           
            }
      
           
} 
function eliminar(){
    
                f1 = document.forms[0]; 
                f1.accionResul.value = 'EliminaNollama';
                f1.action = 'ServletResu';
                f1.method = 'POST';
                f1.submit();
}
  
      
        function redireccionar(){
            
             location.href= "#graba";
        }
        
        
        function gensi()
        {
            
      document.getElementById('radgeneno').checked   =false;     
        document.getElementById('chbsi').checked   =true;   
          document.getElementById('checkbox5').checked   =true;  
            document.getElementById('checkbox7').checked   =true;  
              document.getElementById('checkbox9').checked   =true;  
         
                 ///////no
   
      document.getElementById('checkbox4').checked   =false;   
          document.getElementById('checkbox6').checked   =false;  
            document.getElementById('checkbox8').checked   =false;  
              document.getElementById('checkbox10').checked   =false; 
            
        }


 function genno(){
     
     ///////no
     document.getElementById('radgenesi').checked   =false;
      document.getElementById('checkbox4').checked   =true;   
          document.getElementById('checkbox6').checked   =true;  
            document.getElementById('checkbox8').checked   =true;  
              document.getElementById('checkbox10').checked   =true;  
         
     /////si
      document.getElementById('chbsi').checked   =false;   
          document.getElementById('checkbox5').checked   =false;  
            document.getElementById('checkbox7').checked   =false;  
              document.getElementById('checkbox9').checked   =false; 
     
     
 }
 function clicktocall(valorr) {
   // alert(valorr);
if(valorr==null){
   /// alert("nullclicttocall");
}else{   
   // desbotones(size);
  
f5 = document.forms[0];  
//alert(f5);
document.getElementById('div12').style.display = 'none'; 
document.getElementById('telefonoSelect').value=valorr;//telefono
//alert("condata1");
document.getElementById('accionResul').value = 'llamadaManual';//mandar una accion
f5.action = 'ServletResuLLamada';
f5.method = 'POST';
f5.submit();

 
 }

 }
  function fllamar(){
              f1 = document.forms[0];
               // f1.codCliente.value = valor.value;
                // f1.codCampana.value=valor1.value;
                f1.accionResul.value = 'Llamar';
                f1.action = 'ServletResuLLamada';
                f1.method = 'POST';
                //alert("llamarmnuermo");
                               f1.submit();
            
        }
        
    function  fonavi(){
   
    //document.getElementById('tdtexto').innerHTML='Estas en Llamada';
     f1 = document.forms[0];
     //document.getElementById('accionResul').value='llamadaManual';
     f1.submit();
/// document.location.reload();
  // alert("Lo hizo");
 
}