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
public class Ejemplo {
    public static void main(String[] args){
        InfluxDB influxDB = InfluxDBFactory.connect("http://localhost:8086", "root", "root");
        String dbName = "SolarCar";
        influxDB.createDatabase(dbName);
        // Flush every 2000 Points, at least every 100ms
        influxDB.enableBatch(2000, 100, TimeUnit.MILLISECONDS);
        
        Point point1 = Point.measurement("Motor")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("corriente", 1.5)
                    .addField("voltaje", 1.5)
                    .addField("temperatura", 1.5)
                    .build();
           
        Point point2 = Point.measurement("Ambiental")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("temperatura", 1.5)
                    .addField("radiacion", 1.5)
                    .addField("magViento", 1.5)
                    .addField("dirViento", "NE")
                    .build();
        
        Point point3 = Point.measurement("Panel")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("corriente", 1.5)
                    .addField("voltaje", 1.5)
                    .addField("potencia", 1.5)
                    .build();
        
        Point point4 = Point.measurement("Bateria")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("soc", 1.5)
                    .addField("voltaje", 1.5)
                    .addField("corriente", 1.5)
                    .build();
        
        
        Point point5 = Point.measurement("General")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("velocidad", 1.5)
                    .addField("distancia", 1.5)
                    .build();
   
        influxDB.write(dbName, "autogen", point1);
        influxDB.write(dbName, "autogen", point2);
        influxDB.write(dbName, "autogen", point3);
        influxDB.write(dbName, "autogen", point4);
        influxDB.write(dbName, "autogen", point5);
                
        }
    }

