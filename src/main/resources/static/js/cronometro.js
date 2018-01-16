var cronometro;
	function detenerse(){
		clearInterval(cronometro);
	}

	function carga(){
		horaBase=document.getElementById("horaInicio").value;
		horaBaseF=document.getElementById("horaFin").value;
		
		timeReal = new Date(); 
	   	hora = timeReal.getHours(); 
	   	minuto = timeReal.getMinutes();
	   	segundo=timeReal.getSeconds();
	   	
	   	horaInicio=horaBase.split(":");
	   	iniHr=horaInicio[0];
	   	iniMin=horaInicio[1];
	   	
		horaFin=horaBaseF.split(":");
	   	finHrs=horaFin[0];
	   	finMin=horaFin[1];
	   	finSeg="0";
	   	
	   	//if(hora<=finHrs && minuto>finMin && segundo>finSeg ){
	   		
	   	
	   	transcurridoSegundos = finSeg - segundo;
	    transcurridoMinutos = finMin - minuto;
	    transcurridoHoras = finHrs - hora;
	    
	    
	  if(transcurridoHoras<=0 && transcurridoMinutos<=0 && transcurridoSegundos<=0){
		  transcurridoHoras=0;
		  transcurridoMinutos=0;
		  transcurridoSegundos=1;
	    }
	    
	    
	    if (transcurridoSegundos < 0) {
		      transcurridoMinutos--;
		      transcurridoSegundos = 60 + transcurridoSegundos;
		 }
	    
	    if (transcurridoMinutos < 0) {
	      transcurridoHoras--;
	      transcurridoMinutos = 60 + transcurridoMinutos;
	    }
	    
	    
	    
	    //alert(transcurridoHoras+" "+transcurridoMinutos+" "+transcurridoSegundos);
	    
	    horas = transcurridoHoras.toString();
	    minutos = transcurridoMinutos.toString();
	    segundos = transcurridoSegundos.toString();
	    
	    //if(transcurridoHoras<=0 && transcurridoMinutos<=0 && transcurridoSegundos<=0){
	    	
	    //}
	    /*if(horas<=0 && minutos<=0 && segundos<=0){
	    	horas=0;
	    	minutos=0;
	    	segundos=1
	    }*/
	    if (horas.length < 2) {
	      horas = "0"+horas;
	    }
	    
	    if (minutos.length < 2) {
	      minutos = "0"+minutos;
	    }
	    
	    if (segundos.length < 2) {
		      segundos = "0"+segundos;
		}
	   	
	   	
	   	/////////////////////////////////////////////////////////////////////////////////////////////////
		/*tiempo=document.getElementById("tiempo").value;
		fecha=tiempo.split(":");
		
		contador_s =fecha[2];
		contador_m =fecha[1];
		contador_h =fecha[0];
        */
	    
	    contador_s = segundos;
		contador_m =minutos;
		contador_h =horas;
		
		//alert(contador_h+" "+contador_m+" "+contador_s);
		
		
		s = document.getElementById("segundos");
		m = document.getElementById("minutos");
		h = document.getElementById("horas");
        
        if(h.length<2){
            h.innerHTML = "0"+contador_h;
        }else{
            h.innerHTML = contador_h;
        }

        if(m.length<2){
            m.innerHTML = "0"+contador_m;
        }else{
            m.innerHTML = contador_m;
        }

        if(s.length<2){
            s.innerHTML = "0"+contador_s;
        }else{
            s.innerHTML = contador_s;
        }
                
		cronometro = setInterval(
			function(){
				if (contador_s<=0 && contador_m==0) {
	                contador_m=60;
	                contador_h-=1;
	                if(contador_h<10){
	                    h.innerHTML = "0"+contador_h;
	                }else{
	                    h.innerHTML = contador_h;
	                }
	            }
				if(contador_s<=0){
	                contador_s=60;
	                contador_m-=1;
		            if(contador_m<10){
	                    m.innerHTML = "0"+contador_m;
	                }else{
	                    m.innerHTML = contador_m;
	                }
				}
				
	                           
                contador_s--;

                if(contador_s<10){
                    s.innerHTML = "0"+contador_s;
                }else{
                    s.innerHTML = contador_s;
                }

                if (contador_s<=0 && contador_m==0 && contador_h==0) {
                     alert("Se te a agotado el tiempo del Examen");
                     detenerse();
                }
			},1000);
	   	//}else{
	   		//alert("Se te a agotado el tiempo del Examen");
	   	//}
	   	
	}