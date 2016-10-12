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
public class Ambiental extends Dato{
    public double temperatura;
    public double radiacion;
    public double magViento;
    public String dirViento;
    
    public Ambiental(double temperatura, double radiacion, double magViento, String dirViento){
        this.temperatura=temperatura;
        this.radiacion=radiacion;
        this.magViento=magViento;
        this.dirViento=dirViento;
    }
}
