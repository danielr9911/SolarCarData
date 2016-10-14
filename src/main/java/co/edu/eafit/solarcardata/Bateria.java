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
    public double cmutmax;
    public double socpercent;
    public double cellvmin;
    public double cellvmax;
    public double celltmax;
    
    public Bateria(double cmutmax, double socpercent, double cellvmin,
            double cellvmax, double celltmax){
        this.cmutmax=cmutmax;
        this.socpercent = socpercent;
        this.cellvmin = cellvmin;
        this.cellvmax = cellvmax;
        this.celltmax = celltmax;
        
    }
}
