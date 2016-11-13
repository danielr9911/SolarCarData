/*
 * Proyecto Solar Car Data
 * Proyecto Integrador 1
 * Universidad EAFIT
 * 2016
 */
package co.edu.eafit.solarcardata;

/**
 * Dato - Panel
 * Contiene las variables correspondientes al panel del vehiculo solar. 
 * @author Daniel Rendon
 * @author Laura Mejia
 * @author Daniela Serna
 */
public class Panel extends Dato{
    public double mpptflagspanel0;
    public double mpptflagspanel1;
    public double mpptflagspanel2;
    public double mpptvin0;
    public double mpptvin1;
    public double mpptvin2;
    public double mpptiin0;
    public double mpptiin1;
    public double mpptiin2;
    public double mpptvout0;
    public double mpptvout1;
    public double mpptvout2;
    public double mpptiout0;
    public double mpptiout1;
    public double mpptiout2;
    public double currentint;
                
    public Panel(double mpptflagspanel0, double mpptflagspanel1, 
            double mpptflagspanel2, double mpptvin0, double mpptvin1,
            double mpptvin2, double mpptiin0, double mpptiin1, double mpptiin2,
            double mpptvout0, double mpptvout1, double mpptvout2, 
            double mpptiout0, double mpptiout1, double mpptiout2, double currentint){
        this.mpptflagspanel0 = mpptflagspanel0;
        this.mpptflagspanel1 = mpptflagspanel1;
        this.mpptflagspanel2 = mpptflagspanel2;
        this.mpptvin0 = mpptvin0;
        this.mpptvin1 = mpptvin1;
        this.mpptvin2 = mpptvin2;
        this.mpptiin0 = mpptiin0;
        this.mpptiin1 = mpptiin1;
        this.mpptiin2 = mpptiin2;
        this.mpptvout0 = mpptvout0;
        this.mpptvout1 = mpptvout1;
        this.mpptvout2 = mpptvout2;
        this.mpptiout0 = mpptiout0;
        this.mpptiout1 = mpptiout1;
        this.mpptiout2 = mpptiout2;
        this.currentint = currentint;
    }
}
