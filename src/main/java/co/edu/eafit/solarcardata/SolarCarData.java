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
        String url = "http://localhost:3000/";
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            Logger.getLogger(SolarCarData.class.getName()).log(Level.SEVERE, null, ex);
        }
        Serial serial = new Serial();
        System.out.println("Listar Puertos:");
        serial.listarPuertos();
        //System.out.println("Puertos Disponibles:");
        //serial.puertosDisponibles();
        
        
//        try {
//            GeneradorDatos.generar();
//        } catch (IOException ex) {
//            Logger.getLogger(SolarCarData.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
       
        Conexion.conectar();
        try{
        FileReader fr = new FileReader("puerto.conf");
        BufferedReader bf = new BufferedReader(fr);
        String puerto = bf.readLine();
        bf.close();
        serial.conectar(puerto);
        }catch ( Exception e ){
            // TODO Auto-gene-rated catch block
            e.printStackTrace();
        }
        
        

        
        
    }
}
