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
public class Motor extends Dato{
    public double corriente;
    public double voltaje;
    public double temperatura;
    
    public Motor(double corriente, double voltaje, double temperatura){
        this.corriente=corriente;
        this.voltaje=voltaje;
        this.temperatura=temperatura;
    }
}
