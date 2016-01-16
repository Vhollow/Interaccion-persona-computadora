/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina_de_estados;

/**
 *
 * @author alber_000
 */
public class Main {
    
    private static BookingStateMachine bookingStateMachine;
    
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        bookingStateMachine = new BookingStateMachine();
    }
    
     public static BookingStateMachine getBoockingStateMachine() {
        
        return bookingStateMachine;
    }
}
