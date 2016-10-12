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
    
    public void conectar(){
        influxDB = InfluxDBFactory.connect("http://localhost:8086", "root", "root");
        dbName = "SolarCar";
        influxDB.createDatabase(dbName);
        // Flush every 2000 Points, at least every 100ms
        influxDB.enableBatch(2000, 100, TimeUnit.MILLISECONDS);
    }
    
    public void ingresarDato(String tabla, String nCampo1, float vCampo1){
        Point point1 = Point.measurement(tabla)
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField(nCampo1, vCampo1)
                    .build();
        influxDB.write(dbName, "autogen", point1);
    }
    
    public static void guardar(Dato dato){
        if(dato instanceof Ambiental){
            Point point1 = Point.measurement("Ambiental")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("temperatura", ((Ambiental) dato).temperatura)
                    .addField("radiacion", ((Ambiental) dato).radiacion)
                    .addField("dirViento", ((Ambiental) dato).dirViento)
                    .addField("magViento", ((Ambiental) dato).magViento)
                    .build();
            influxDB.write(dbName, "autogen", point1);
        }else if(dato instanceof Panel){
            Point point1 = Point.measurement("Panel")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("corriente", ((Panel) dato).corriente)
                    .addField("voltaje", ((Panel) dato).voltaje)
                    .addField("potencia", ((Panel) dato).potencia)
                    .build();
            influxDB.write(dbName, "autogen", point1);
        }else if(dato instanceof Motor){
            Point point1 = Point.measurement("Motor")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("corriente", ((Motor) dato).corriente)
                    .addField("voltaje", ((Motor) dato).voltaje)
                    .addField("temperatura", ((Motor) dato).temperatura)
                    .build();
            influxDB.write(dbName, "autogen", point1);
        }else if(dato instanceof Bateria){
            Point point1 = Point.measurement("Bateria")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("soc", ((Bateria) dato).soc)
                    .addField("voltaje", ((Bateria) dato).voltaje)
                    .addField("corriente", ((Bateria) dato).corriente)
                    .build();
            influxDB.write(dbName, "autogen", point1);
        }else if(dato instanceof General){
            Point point1 = Point.measurement("General")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("velocidad", ((General) dato).velocidad)
                    .addField("distancia", ((General) dato).distancia)
                    .build();
            influxDB.write(dbName, "autogen", point1);
        }else{
            //Error
            System.out.println("El dato a guardar es un tipo de dato desconocido");
        }
    }
}
