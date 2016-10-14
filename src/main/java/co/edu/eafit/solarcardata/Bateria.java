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
    public double flagsb;
    public double pcbtemp0;
    public double pcbtemp1;
    public double pcbtemp2;
    public double pcbtemp3;
    public double pcbtemp4;
    public double celltemp0;
    public double celltemp1;
    public double celltemp2;
    public double celltemp3;
    public double celltemp4;
    
    public Bateria(double cmutmax, double socpercent, double cellvmin,
            double cellvmax, double celltmax, double flagsb, double pcbtemp0,
            double pcbtemp1, double pcbtemp2, double pcbtemp3, double pcbtemp4,
            double celltemp0, double celltemp1, double celltemp2,
            double celltemp3, double celltemp4){
        this.cmutmax=cmutmax;
        this.socpercent = socpercent;
        this.cellvmin = cellvmin;
        this.cellvmax = cellvmax;
        this.celltmax = celltmax;
        this.flagsb = flagsb;
        this.pcbtemp0 = pcbtemp0;
        this.pcbtemp1 = pcbtemp1;
        this.pcbtemp2 = pcbtemp2;
        this.pcbtemp3 = pcbtemp3;
        this.pcbtemp4 = pcbtemp4;
        this.celltemp0 = celltemp0;
        this.celltemp1 = celltemp1;
        this.celltemp2 = celltemp2;
        this.celltemp3 = celltemp3;
        this.celltemp4 = celltemp4;
        
    }
}
