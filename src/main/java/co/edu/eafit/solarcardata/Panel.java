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
    public float potencia;
    public float voltaje;
    public float corriente;
    
    public Panel(float potencia, float voltaje, float corriente){
        this.potencia=potencia;
        this.voltaje=voltaje;
        this.corriente=corriente;
    }
}
