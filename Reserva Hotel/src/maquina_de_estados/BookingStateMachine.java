/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina_de_estados;

import javax.swing.JFrame;
import maquina_de_estados.Booking.DateChooser;
import maquina_de_estados.Booking.Form;
import maquina_de_estados.Booking.RoomChooser;
import maquina_de_estados.Booking.ModeloReservaHotel;

/**
 *
 * @author alber_000
 */
public class BookingStateMachine {
    
    private JFrame olderState;
    private JFrame previousState;
    private JFrame currentState;
    private ModeloReservaHotel modelo;
    
    public BookingStateMachine() {
    	
    	modelo=new ModeloReservaHotel();
        
        java.awt.EventQueue.invokeLater(
        new Runnable() {
            public void run() {
            currentState = new DateChooser();
            currentState.setVisible(true);
            }
        });
    }
    
    public ModeloReservaHotel getModelo(){
        
        return this.modelo;
    }
    
    public void comprobarDisponibilidad(){
        
        currentState.dispose();
        
        java.awt.EventQueue.invokeLater(
        new Runnable() {
            public void run() {
            previousState=currentState;
            previousState.setVisible(false);
            currentState = new RoomChooser();
            currentState.setVisible(true);
            }
        });
    }
    
    public void cambiarFecha(){
        
        currentState.dispose();
        
        java.awt.EventQueue.invokeLater(
        new Runnable() {
            public void run() {
            currentState = previousState;
            currentState.setVisible(true);
            }
        });
    }
    
    public void reservar(){
        
        currentState.dispose();
        
        java.awt.EventQueue.invokeLater(
        new Runnable() {
            public void run() {
            olderState=previousState;
            previousState=currentState;
            previousState.setVisible(false);
            currentState = new Form();
            currentState.setVisible(true);
            }
        });
    }
    
    public void cambiarHabitacion(){
        
        currentState.dispose();
        
        java.awt.EventQueue.invokeLater(
        new Runnable() {
            public void run() {
            currentState = previousState;
            currentState.setVisible(true);
            previousState=olderState;
            }
        });
    }
    
    public void confirmar(){
        
        currentState.dispose();
        
        java.awt.EventQueue.invokeLater(
        new Runnable() {
            public void run() {
            currentState = new DateChooser();
            currentState.setVisible(true);
            }
        });
    }
    
    
}