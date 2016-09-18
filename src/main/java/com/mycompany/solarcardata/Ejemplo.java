package com.mycompany.solarcardata;


import java.util.concurrent.TimeUnit;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lauramv21
 */
public class Ejemplo {
    public static void main(String[] args){
        InfluxDB influxDB = InfluxDBFactory.connect("http://localhost:8083", "root", "root");
String dbName = "aTimeSeries";
influxDB.createDatabase(dbName);

// Flush every 2000 Points, at least every 100ms
influxDB.enableBatch(2000, 100, TimeUnit.MILLISECONDS);

Point point1 = Point.measurement("cpu")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("idle", 90L)
                    .addField("user", 9L)
                    .addField("system", 1L)
                    .build();
Point point2 = Point.measurement("disk")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("used", 80L)
                    .addField("free", 1L)
                    .build();

influxDB.write(dbName, "autogen", point1);
influxDB.write(dbName, "autogen", point2);
Query query = new Query("SELECT idle FROM cpu", dbName);
influxDB.query(query);
influxDB.deleteDatabase(dbName);
    }
}
