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
    public double mpptflagspanel0;
    public double mpptflagspanel1;
    public double mpptflagspanel2;
    public double mpptvin0;
    public double mpptvin1;
    public double mpptvin2;
    
            
            
    public Panel(double mpptflagspanel0, double mpptflagspanel1, 
            double mpptflagspanel2, double mpptvin0, double mpptvin1,
            double mpptvin2){
        this.mpptflagspanel0 = mpptflagspanel0;
        this.mpptflagspanel1 = mpptflagspanel1;
        this.mpptflagspanel2 = mpptflagspanel2;
        this.mpptvin0 = mpptvin0;
        this.mpptvin1 = mpptvin1;
        this.mpptvin2 = mpptvin2;
        
}
