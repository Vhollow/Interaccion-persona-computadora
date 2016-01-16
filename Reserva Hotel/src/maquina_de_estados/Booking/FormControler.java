/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina_de_estados.Booking;

import maquina_de_estados.Main;

/**
 *
 * @author Vicente
 */
public class FormControler {
    private Form vista;
    private ModeloReservaHotel modelo;
    
    public FormControler(Form f,ModeloReservaHotel m){
        vista=f;
        modelo=m;
        
    }
    public void confirmarReserva(Reserva nueva){
        
        modelo.reservar(modelo.getInicio(), modelo.getFin(), modelo.getTipo(), nueva);
        
        Main.getBoockingStateMachine().confirmar();
    }
    public void cambiarHabitacion(){
        Main.getBoockingStateMachine().cambiarHabitacion();
    }
}
