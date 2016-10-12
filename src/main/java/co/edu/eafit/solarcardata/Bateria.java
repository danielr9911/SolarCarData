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
public class Bateria extends Dato{
    public double soc;
    public double voltaje;
    public double corriente;
    
    public Bateria(double soc,double voltaje,double corriente){
        this.soc=soc;
        this.voltaje=voltaje;
        this.corriente=corriente;
    }
}
