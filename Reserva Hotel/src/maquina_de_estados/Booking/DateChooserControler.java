/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina_de_estados.Booking;

import java.util.Date;
import java.util.GregorianCalendar;
import maquina_de_estados.Main;

/**
 *
 * @author alber_000
 */
public class DateChooserControler {
    
    private DateChooser vista;
    private ModeloReservaHotel modelo;
    
    public DateChooserControler(DateChooser w, ModeloReservaHotel m){
        
        vista = w;
        modelo=m;
        
    }
    
    public void comprobarDisponibilidad(Date fecha_entrada,Date fecha_salida,int personas){
        //Llamada al modelo
        GregorianCalendar inicio,fin;
        
        inicio=new GregorianCalendar();
        fin=new GregorianCalendar();
        
        inicio.set(GregorianCalendar.DATE,fecha_entrada.getDate());
        inicio.set(GregorianCalendar.MONTH,fecha_entrada.getMonth());
        
        fin.set(GregorianCalendar.DATE,fecha_salida.getDate());
        fin.set(GregorianCalendar.MONTH,fecha_salida.getMonth());
        
        if(modelo.comprobar(inicio, fin, 0, personas)||modelo.comprobar(inicio, fin, 1, personas)||modelo.comprobar(inicio, fin, 2, personas)||modelo.comprobar(inicio, fin, 3, personas)){
            
            Main.getBoockingStateMachine().comprobarDisponibilidad();
        }
    }
    
}
