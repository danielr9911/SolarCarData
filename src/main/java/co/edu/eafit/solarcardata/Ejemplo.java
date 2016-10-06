/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eafit.solarcardata;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDB.ConsistencyLevel;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;

/**
 *
 * @author Daniel
 */
public class Ejemplo {
    public static void main(String[] args){
        InfluxDB influxDB = InfluxDBFactory.connect("http://localhost:8086", "root", "root");
        String dbName = "grafana";
        //influxDB.createDatabase(dbName);
        // Flush every 2000 Points, at least every 100ms
        influxDB.enableBatch(2000, 100, TimeUnit.MILLISECONDS);
        
        while(true){
            float minX = 50.0f;
            float maxX = 100.0f;
            Random randomVol = new Random();
            float voltaje = randomVol.nextFloat() * (maxX - minX) + minX;
            Random randomCor = new Random();
            float corriente = randomCor.nextFloat() * (maxX - minX) + minX;
            Random randomPot = new Random();
            float potencia = randomPot.nextFloat() * (maxX - minX) + minX;
            Point point1 = Point.measurement("Motor")
                        .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                        .addField("Voltaje", voltaje)
                        .addField("Corriente", corriente)
                        .addField("Potencia", potencia)
                        .build();
            
            influxDB.write(dbName, "autogen", point1);
            
            try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
                
        }
    }
}
