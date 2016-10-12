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
    public float temperatura;
    public float radiacion;
    public float magViento;
    public String dirViento;
    
    public Ambiental(float temperatura, float radiacion, float magViento, String dirViento){
        this.temperatura=temperatura;
        this.radiacion=radiacion;
        this.magViento=magViento;
        this.dirViento=dirViento;
    }
}
