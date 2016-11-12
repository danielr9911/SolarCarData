/*
 * Proyecto Solar Car Data
 * Proyecto Integrador 1
 * Universidad EAFIT
 * 2016
 */
package co.edu.eafit.solarcardata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Solar Car Data
 * @author Daniel Rendon
 * @author Laura Mejia
 * @author Daniela Serna
 */
public class SolarCarData {
    public static void main(String[] args){
        //Comando cmd para ejecutar grafana
        //start /B /D "Documents\GitHub\SolarCarData\grafana-3.1.1\bin" grafana-server.exe
        //Comando cmd para ejecutar influxdb
        //start /B /D "../../influxdb-1.0.0-1" influxd.exe
        try {
            //Ejecuta InfluxDB
            String cmd1 = "cmd /c start /D \"..\\..\\..\\..\\..\\influxdb-1.0.0-1\" influxd.exe";
            Runtime.getRuntime().exec(cmd1); 
            //Ejecuta Grafana
            String cmd2 = "cmd /c start /D \"grafana-3.1.1\\bin\" grafana-server.exe"; 
            Runtime.getRuntime().exec(cmd2); 
            //Abre la interfaz grafica de grafana en el explorador
            String url = "http://localhost:3000/";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            System.err.println("No se pudo ejecutar influxdb o grafana correctamente");
            Logger.getLogger(SolarCarData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Lista los puertos disponibles
        Serial serial = new Serial();
        System.out.println("Listar Puertos:");
        serial.listarPuertos();
        
        //Realiza la conexion con InfluxDB
        Conexion.conectar();
        
        //Realiza la conexion con el puerto serial indicado en el archivo puerto.conf
        try{
            FileReader fr = new FileReader("puerto.conf");
            BufferedReader bf;
            bf = new BufferedReader(fr);
            String puerto = bf.readLine();
            bf.close();
            serial.conectar(puerto);
        }catch ( Exception e ){
            System.err.println("No se pudo realizar la conexion con el puerto serial");
            Logger.getLogger(SolarCarData.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
