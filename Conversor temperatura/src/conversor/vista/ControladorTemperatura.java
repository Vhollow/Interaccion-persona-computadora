/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor.vista;
import conversor.modelo.Modelo;
/**
 *
 * @author Vicente
 */
public class ControladorTemperatura {
    private VistaTemperatura vista;
    private Modelo modelo;
    
    public ControladorTemperatura(VistaTemperatura vista,Modelo modelo){
        this.vista=vista;
        this.modelo=modelo;
    }
    public void salir(){
        System.exit(0);
    }
    public void convertirCent(){
        //1.Coger datos
        double temperatura=vista.getCentigrados();
        //2.Llevar datos al modelo
        modelo.setCentigrados(temperatura);
        //3.Modelo convierte grados
        modelo.centigradosAFarenheit();
        //4.Vista se actualiza
        vista.actualiza();
    }public void convertirFar(){
        //1.Coger datos
        double temperatura=vista.getFarenheit();
        //2.Llevar datos al modelo
        modelo.setFarenheit(temperatura);
        //3.Modelo convierte grados
        modelo.farenheitACentigrados();
        //4.Vista se actualiza
        vista.actualiza();
    }
}
