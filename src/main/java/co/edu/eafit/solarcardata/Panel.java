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
    public float corriente;
    public float voltaje;
    public float potencia;
    
    public Panel(float corriente, float voltaje, float potencia){
        this.corriente=corriente;
        this.voltaje=voltaje;
        this.potencia=potencia;
    }
}
