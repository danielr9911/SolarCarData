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
    public float temperatura;
    public float voltaje;
    public float corriente;
    
    public Motor(float temperatura, float voltaje, float corriente){
        this.temperatura=temperatura;
        this.voltaje=voltaje;
        this.corriente=corriente;
    }
}
