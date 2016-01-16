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
public class RoomChooserControler {
    private RoomChooser vista;
    private ModeloReservaHotel modelo;
    
    public RoomChooserControler(RoomChooser w, ModeloReservaHotel m){
        
        vista = w;
        modelo = m;
    }
    public void reservar(){

        Main.getBoockingStateMachine().reservar();
    }
    public void cambiarFecha(){
        Main.getBoockingStateMachine().cambiarFecha();
    }
    
}
