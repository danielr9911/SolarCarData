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
    public double imuspeedgnd;
    public double imuyaw;
    public double imucourse;
    public double imulongitude;
    public double imupitch;
    public double imulattitude;
    public double imualttitude;
    public double imuroll;
    public double aux;
    
    public General(double imuspeedgnd, double imuyaw, double imucourse,
            double imulongitude, double imupitch, double imulattitude,
            double imualttitude, double imuroll, double aux){
        this.imuspeedgnd = imuspeedgnd;
        this.imuyaw = imuyaw;
        this.imucourse = imucourse;
        this.imulongitude = imulongitude;
        this.imulattitude = imulattitude;
        this.imualttitude = imualttitude;
        this.imuroll = imuroll;
        this.aux = aux;
    }
}
