/*
 * Proyecto Solar Car Data
 * Proyecto Integrador 1
 * Universidad EAFIT
 * 2016
 */
package co.edu.eafit.solarcardata;

/**
 *
 * @author Daniel
 */
public class Motor extends Dato{
    public double railvoltageb;
    public double mcbuscurrent;
    public double mccurrentq;
    public double mctorque;
    public double mcbusvoltage;
    public double mcrailvoltage;
    public double mcspeed;
    public double mcodo;
    public double mcrpm;
    public double mctemp;
    //temperatura variador
    public double mcws22temp;
    public double mcflags;
            
           
    public Motor(double railvoltageb, double mcbuscurrent, double mccurrentq,
            double mctorque, double mcbusvoltage, double mcrailvoltage, 
            double mcspeed, double mcodo, double mcrpm, double mctemp,
            double mcws22temp, double mcflags){
        this.railvoltageb = railvoltageb;
        this.mcbuscurrent = mcbuscurrent;
        this.mccurrentq = mccurrentq;
        this.mctorque = mctorque;
        this.mcbusvoltage = mcbusvoltage;
        this.mcrailvoltage = mcrailvoltage;
        this.mcspeed = mcspeed;
        this.mcodo = mcodo;
        this.mcrpm = mcrpm;
        this.mctemp = mctemp;
        this.mcws22temp = mcws22temp;
        this.mcflags = mcflags;
        
          
    }
}
