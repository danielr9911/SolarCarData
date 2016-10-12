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
public class General extends Dato{
    public double velocidad;
    public double distancia;
    
    public General(double velocidad, double distancia){
        this.velocidad=velocidad;
        this.distancia=distancia;
    }
}
