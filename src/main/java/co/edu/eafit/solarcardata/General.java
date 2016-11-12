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
    public double posvmax;
    public double posvmin;
    public double imuspeedgnd;
    public double imuyaw;
    public double imucourse;
    public double imulongitude;
    public double imupitch;
    public double imulattitude;
    public double imualttitude;
    public double imuroll;
    
    public General(double posvmax, double posvmin, double imuspeedgnd,
            double imuyaw, double imucourse, double imulongitude,
            double imupitch, double imulattitude,
            double imualttitude, double imuroll){
        this.posvmax=posvmax;
        this.posvmin=posvmin;
        this.imuspeedgnd = imuspeedgnd;
        this.imuyaw = imuyaw;
        this.imucourse = imucourse;
        this.imulongitude = imulongitude;
        this.imupitch=imupitch;
        this.imulattitude = imulattitude;
        this.imualttitude = imualttitude;
        this.imuroll = imuroll;
    }
}
