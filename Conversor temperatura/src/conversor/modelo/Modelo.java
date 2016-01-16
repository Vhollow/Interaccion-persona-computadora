/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor.modelo;

/**
 *
 * @author Vicente
 */
public class Modelo {
    private double temp_cent;
    private double temp_far;
    
    public Modelo(){
        temp_cent=0.0;
        temp_far=-32.0;
    }

    public double getCentigrados() {
        return temp_cent;
    }

    public void setCentigrados(double temp_cent) {
        this.temp_cent = temp_cent;
    }

    public double getFarenheit() {
        return temp_far;
    }

    public void setFarenheit(double temp_far) {
        this.temp_far = temp_far;
    }
    public void centigradosAFarenheit(){
        temp_far= 1.8*temp_cent-32.0;
    }
    public void farenheitACentigrados(){
        temp_cent=(temp_far+32.0)/1.8;
    }

}
