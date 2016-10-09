/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eafit.solarcardata;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
/**
 *
 * @author Daniel
 */
public class Conexion {
    InfluxDB influxDB;
    String dbName;
    
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
}
