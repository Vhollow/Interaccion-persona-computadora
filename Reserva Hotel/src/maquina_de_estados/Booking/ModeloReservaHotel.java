/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina_de_estados.Booking;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author alber_000
 */
public class ModeloReservaHotel {
    
    private int habitacion[][][];
    private int individual;
    private int doble;
    private int superior;
    private int suite;
    
    private GregorianCalendar inicio;
    private GregorianCalendar fin;
    private int tipo;
    private int personas;
    private int pension;
    private int[] precio;
    private int[] preciopension;
    private ArrayList<Reserva> reservas;

    public ModeloReservaHotel(){
        
        reservas=new <Reserva>ArrayList();
        
        habitacion=new int[31][12][4];
        individual=5;
        doble=5;
        superior=5;
        suite=5;
        inicio=new GregorianCalendar();
        fin=new GregorianCalendar();
        precio=new int[4];
        preciopension=new int[4];
        
        precio[0]=1000;
        precio[1]=2000;
        precio[2]=3000;
        precio[3]=4000;
        
        preciopension[0]=10;
        preciopension[1]=20;
        preciopension[2]=30;
        preciopension[3]=40;

        for(int i=0;i<31;i++){
            for(int j=0;j<12;j++){
                habitacion[i][j][0]=individual;
                habitacion[i][j][1]=doble;
                habitacion[i][j][2]=superior;
                habitacion[i][j][3]=suite;
            }
        }
    }
    
    public int getPrecio(int i){
        return precio[i];
    }
    public int getPrecioPension(int i){
        return preciopension[i];
    }
    public int getPension(){
        return pension;
    }
    public void setPension(int pension){
    	
    	this.pension=pension;
    }
    
    public void setTipo(int tipo){
    	
    	this.tipo=tipo;
    }
    
    public int getTipo(){
    	
    	return tipo;
    }
    
    public GregorianCalendar getInicio(){
    	
    	return inicio;
    }
    
    public GregorianCalendar getFin(){
    	
    	return fin;
    }
    
    public int getPersonas(){
        
        return personas;
    }
    
    public boolean comprobar(GregorianCalendar inicio, GregorianCalendar fin, int tipo,int personas){
    	
    	if(personas==2&&tipo==0||inicio.after(fin)){
    		
    		return false;
    	}
    	
    	int diainicio, mesinicio, diafin, mesfin;
        
        diainicio=inicio.get(GregorianCalendar.DATE);
        mesinicio=inicio.get(GregorianCalendar.MONTH);
        diafin=fin.get(GregorianCalendar.DATE);
        mesfin=fin.get(GregorianCalendar.MONTH);
        
    	int cont=0;
    	
    	if(mesinicio==mesfin){

            for(int i=diainicio;i<diafin;i++){
                
                if(habitacion[i][mesinicio][tipo]<=0){
                	cont++;
                }
            }
        }else{
        	
            for(int i=diainicio;i<31;i++){
                
            	if(habitacion[i][mesinicio][tipo]<=0){
                	cont++;
                }
            }
            for(int j=mesinicio+1;j<mesfin;j++){
            	
            	for(int i=0;i<31;i++){
                    
            		if(habitacion[i][j][tipo]<=0){
                    	cont++;
                    }
                }
            }
            for(int i=0;i<diafin;i++){
            	
            	if(habitacion[i][mesfin][tipo]<=0){
                	cont++;
                }
            }
        }
    	if(cont==0){
    		
            this.inicio.set(GregorianCalendar.DATE,diainicio);
            this.inicio.set(GregorianCalendar.MONTH,mesinicio);
            
            this.fin.set(GregorianCalendar.DATE,diafin);
            this.fin.set(GregorianCalendar.MONTH,mesfin);
            this.personas=personas;
            
    		return true;
    		
    		
    	}else{
    		return false;
    	}
        
    }
    
    public void reservar(GregorianCalendar inicio, GregorianCalendar fin, int tipo, Reserva nueva){
        
    	int diainicio, mesinicio, diafin, mesfin;
            
        diainicio=inicio.get(GregorianCalendar.DATE);
        mesinicio=inicio.get(GregorianCalendar.MONTH);
        diafin=fin.get(GregorianCalendar.DATE);
        mesfin=fin.get(GregorianCalendar.MONTH);
            
    	if(mesinicio==mesfin){
    	        
    		for(int i=diainicio;i<diafin;i++){
    	            
    	        habitacion[i][mesinicio][tipo]--;
    	    }
    	}else{
    	    	
    	 	for(int i=diainicio;i<31;i++){
    	            
    	        habitacion[i][mesinicio][tipo]--;
    	    }
    	    for(int j=mesinicio+1;j<mesfin;j++){
    	        	
    	      	for(int i=0;i<31;i++){
    	                
    	            habitacion[i][j][tipo]--;
    	        }
    	    }
    	    for(int i=0;i<diafin;i++){
    	        	
    	      	habitacion[i][mesfin][tipo]--;
    	    }
            
    	    
    	} 

        reservas.add(nueva);
    }
    
    
    public void imprimir(){
    	for(int j=0;j<=2;j++){
    		
    		for(int i=0;i<31;i++){
    		
    			System.out.println("Dia: "+i);

            	System.out.println(habitacion[i][j][0]);
                System.out.println(habitacion[i][j][1]);
                System.out.println(habitacion[i][j][2]);
                System.out.println(habitacion[i][j][3]);
        }
    }

    
}

}