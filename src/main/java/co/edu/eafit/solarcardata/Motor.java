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
            
           
    public Motor(double railvoltageb, double mcbuscurrent, double mccurrentq,
            double mctorque, double mcbusvoltage, double mcrailvoltage, 
            double mcspeed, double mcodo, double mcrpm, double mctemp,
            double mcws22temp){
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
        
          
    }
}
