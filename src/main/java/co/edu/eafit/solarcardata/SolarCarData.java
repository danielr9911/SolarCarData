/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eafit.solarcardata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class SolarCarData {
    public static void main(String[] args){
        //Comando cmd para ejecutar grafana
        //start /B /D "Documents\GitHub\SolarCarData\grafana-3.1.1\bin" grafana-server.exe
        //Comando cmd para ejecutar influxdb
        //start /B /D "../../influxdb-1.0.0-1" influxd.exe
        
        try {
            //Ejecuta InfluxDB
            String cmd1 = "cmd start /B /D \"../../influxdb-1.0.0-1\" influxd.exe";
            Runtime.getRuntime().exec(cmd1); 
            //Ejecuta Grafana-Server
            String cmd2 = "cmd start /B /D \"Documents/GitHub/SolarCarData/grafana-3.1.1/bin\" grafana-server.exe"; 
            Runtime.getRuntime().exec(cmd2); 
            //Abre la interfaz de grafana en el explorador
            String url = "http://localhost:3000/";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            System.exit(1);
            System.err.println("No se pudo ejecutar influxdb o grafana");
            Logger.getLogger(SolarCarData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Serial serial = new Serial();
        System.out.println("Listar Puertos:");
        serial.listarPuertos();
                     
        Conexion.conectar();
        try{
            FileReader fr = new FileReader("puerto.conf");
            BufferedReader bf;
            bf = new BufferedReader(fr);
            String puerto = bf.readLine();
            bf.close();
            serial.conectar(puerto);
        }catch ( Exception e ){
            Logger.getLogger(SolarCarData.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
