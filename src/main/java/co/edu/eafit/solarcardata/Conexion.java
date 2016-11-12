/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eafit.solarcardata;
import java.util.concurrent.TimeUnit;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
/**
 *
 * @author Daniel
 */
public class Conexion {
    private static InfluxDB influxDB;
    private static String dbName;
    
    public static void conectar(){
        influxDB = InfluxDBFactory.connect("http://localhost:8086", "root", "root");
        dbName = "SolarCar";
        influxDB.createDatabase(dbName);
        // Flush every 2000 Points, at least every 100ms
        influxDB.enableBatch(2000, 100, TimeUnit.MILLISECONDS);
        System.out.println("Connecting..");
    }
    
    //Borrar
    public void ingresarDato(String tabla, String nCampo1, float vCampo1){
        Point point1 = Point.measurement(tabla)
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField(nCampo1, vCampo1)
                    .build();
        influxDB.write(dbName, "autogen", point1);
    }
    
    public static void guardar(Dato dato){
        
        if(dato instanceof Panel){
//            System.out.println("Panel");
            Point point1 = Point.measurement("Panel")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("mpptflagspanel0", ((Panel) dato).mpptflagspanel0)
                    .addField("mpptflagspanel1", ((Panel) dato).mpptflagspanel1)
                    .addField("mpptflagspanel2", ((Panel) dato).mpptflagspanel2)
                    .addField("mpptvin0", ((Panel) dato).mpptvin0)
                    .addField("mpptvin1", ((Panel) dato).mpptvin1)
                    .addField("mpptvin2", ((Panel) dato).mpptvin2)
                    .addField("mpptiin0", ((Panel) dato).mpptiin0)
                    .addField("mpptiin1", ((Panel) dato).mpptiin1)
                    .addField("mpptiin2", ((Panel) dato).mpptiin2)
                    .addField("mpptvout0", ((Panel) dato).mpptvout0)
                    .addField("mpptvout1", ((Panel) dato).mpptvout1)
                    .addField("mpptvout2", ((Panel) dato).mpptvout2)
                    .addField("mpptiout0", ((Panel) dato).mpptiout0)
                    .addField("mpptiout1", ((Panel) dato).mpptiout1)
                    .addField("mpptiout2", ((Panel) dato).mpptiout2)
                    .addField("currentint", ((Panel) dato).currentint)
                    .build();
            influxDB.write(dbName, "autogen", point1);
            System.out.println("Se encontro intancia panel");
        }else if(dato instanceof Motor){
            Point point1 = Point.measurement("Motor")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("railvoltageb", ((Motor) dato).railvoltageb)
                    .addField("mcbuscurrent", ((Motor) dato).mcbuscurrent)
                    .addField("mccurrentq", ((Motor) dato).mccurrentq)
                    .addField("mctorque", ((Motor) dato).mctorque)
                    .addField("mcbusvoltage", ((Motor) dato).mcbusvoltage)
                    .addField("mcrailvoltage", ((Motor) dato).mcrailvoltage)
                    .addField("mcspeed", ((Motor) dato).mcspeed)
                    .addField("mcodo", ((Motor) dato).mcodo)
                    .addField("mcrpm", ((Motor) dato).mcrpm)
                    .addField("mctemp", ((Motor) dato).mctemp)
                    .addField("mcws22temp", ((Motor) dato).mcws22temp)
                    .addField("mcflags", ((Motor) dato).mcflags)
                    .build();
            influxDB.write(dbName, "autogen", point1);
            System.out.println("Se encontro intancia motor");
        }else if(dato instanceof Bateria){
            Point point1 = Point.measurement("Bateria")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("cmutmax", ((Bateria) dato).cmutmax)
                    .addField("socpercent", ((Bateria) dato).socpercent)
                    .addField("cellvmin", ((Bateria) dato).cellvmin)
                    .addField("cellvmax", ((Bateria) dato).cellvmax)
                    .addField("celltmax", ((Bateria) dato).celltmax)
                    .addField("flagsb", ((Bateria) dato).flagsb)
                    .addField("pcbtemp0", ((Bateria) dato).pcbtemp0)
                    .addField("pcbtemp1", ((Bateria) dato).pcbtemp1)
                    .addField("pcbtemp2", ((Bateria) dato).pcbtemp2)
                    .addField("pcbtemp3", ((Bateria) dato).pcbtemp3)
                    .addField("pcbtemp4", ((Bateria) dato).pcbtemp4)
                    .addField("celltemp0", ((Bateria) dato).celltemp0)
                    .addField("celltemp1", ((Bateria) dato).celltemp1)
                    .addField("celltemp2", ((Bateria) dato).celltemp2)
                    .addField("celltemp3", ((Bateria) dato).celltemp3)
                    .addField("celltemp4", ((Bateria) dato).celltemp4)
                    .addField("socma", ((Bateria) dato).socma)
                    .addField("voltage", ((Bateria) dato).voltage)
                    .addField("current", ((Bateria) dato).current)
                    .addField("cvoltage0", ((Bateria) dato).cvoltage0)
                    .addField("cvoltage1", ((Bateria) dato).cvoltage1)
                    .addField("cvoltage2", ((Bateria) dato).cvoltage2)
                    .addField("cvoltage3", ((Bateria) dato).cvoltage3)
                    .addField("cvoltage4", ((Bateria) dato).cvoltage4)
                    .addField("cvoltage5", ((Bateria) dato).cvoltage5)
                    .addField("cvoltage6", ((Bateria) dato).cvoltage6)
                    .addField("cvoltage7", ((Bateria) dato).cvoltage7)
                    .addField("cvoltage8", ((Bateria) dato).cvoltage8)
                    .addField("cvoltage9", ((Bateria) dato).cvoltage9)
                    .addField("cvoltage10", ((Bateria) dato).cvoltage10)
                    .addField("cvoltage11", ((Bateria) dato).cvoltage11)
                    .addField("cvoltage12", ((Bateria) dato).cvoltage12)
                    .addField("cvoltage13", ((Bateria) dato).cvoltage13)
                    .addField("cvoltage14", ((Bateria) dato).cvoltage14)
                    .addField("cvoltage15", ((Bateria) dato).cvoltage15)
                    .addField("cvoltage16", ((Bateria) dato).cvoltage16)
                    .addField("cvoltage17", ((Bateria) dato).cvoltage17)
                    .addField("cvoltage18", ((Bateria) dato).cvoltage18)
                    .addField("cvoltage19", ((Bateria) dato).cvoltage19)
                    .addField("cvoltage20", ((Bateria) dato).cvoltage20)
                    .addField("cvoltage21", ((Bateria) dato).cvoltage21)
                    .addField("cvoltage22", ((Bateria) dato).cvoltage22)
                    .addField("cvoltage23", ((Bateria) dato).cvoltage23)
                    .addField("cvoltage24", ((Bateria) dato).cvoltage24)
                    .addField("cvoltage25", ((Bateria) dato).cvoltage25)
                    .addField("cvoltage26", ((Bateria) dato).cvoltage26)
                    .addField("cvoltage27", ((Bateria) dato).cvoltage27)
                    .addField("cvoltage28", ((Bateria) dato).cvoltage28)
                    .addField("cvoltage29", ((Bateria) dato).cvoltage29)
                    .addField("cvoltage30", ((Bateria) dato).cvoltage30)
                    .addField("cvoltage31", ((Bateria) dato).cvoltage31)
                    .addField("cvoltage32", ((Bateria) dato).cvoltage32)
                    .addField("cvoltage33", ((Bateria) dato).cvoltage33)
                    .build();
            influxDB.write(dbName, "autogen", point1);
            System.out.println("Se encontro intancia bateria");
        }else if(dato instanceof General){
            Point point1 = Point.measurement("General")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("imuspeedgnd", ((General) dato).posvmax)
                    .addField("imuspeedgnd", ((General) dato).posvmin)
                    .addField("imuspeedgnd", ((General) dato).imuspeedgnd)
                    .addField("imuyaw", ((General) dato).imuyaw)
                    .addField("imucourse", ((General) dato).imucourse)
                    .addField("imulongitude", ((General) dato).imulongitude)
                    .addField("imupitch", ((General) dato).imupitch)
                    .addField("imulattitude", ((General) dato).imulattitude)
                    .addField("imualttitude", ((General) dato).imualttitude)
                    .addField("imuroll", ((General) dato).imuroll)
                    .build();
            influxDB.write(dbName, "autogen", point1);
            System.out.println("Se encontro intancia general");
        }else{
            //Error
            System.out.println("El dato a guardar es un tipo de dato desconocido");
        }
    }
}
