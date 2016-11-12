/*
 * Proyecto Solar Car Data
 * Proyecto Integrador 1
 * Universidad EAFIT
 * 2016
 */

package co.edu.eafit.solarcardata;

/**
 * Dato - General
 * Contiene las variables generales mas importantes del vehiculo solar. 
 * @author Daniel Rendon
 * @author Laura Mejia
 * @author Daniela Serna
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
