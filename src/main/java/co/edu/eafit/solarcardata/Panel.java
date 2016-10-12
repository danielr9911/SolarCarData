/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eafit.solarcardata;

/**
 *
 * @author Daniel
 */
public class Panel extends Dato{
    public double corriente;
    public double voltaje;
    public double potencia;
    
    public Panel(double corriente, double voltaje, double potencia){
        this.corriente=corriente;
        this.voltaje=voltaje;
        this.potencia=potencia;
    }
}
