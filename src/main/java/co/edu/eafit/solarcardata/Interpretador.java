/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eafit.solarcardata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Daniel
 */
public class Interpretador {
    public static String[] orden = null;
    
    private static void verificarOrden() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("ordenDatos.conf");
        BufferedReader bf = new BufferedReader(fr);
        String configuracion = bf.readLine();
        bf.close();
        orden = configuracion.split(",");
    }
    
    public static void reconocer(String linea){
        Dato ambiental = null;
        Dato bateria = null;
        Dato general = null;
        Dato motor = null;
        Dato panel = null;
        try{
            verificarOrden();
            System.out.println("odenDatos.conf leido correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }
        String[] datos = linea.split(",");
       
        //Tenemos datos y orden llenos correctamente
        HashMap<String, String> data = new HashMap<>();
        for(int i=0; i<datos.length;i++){
            data.put(orden[i], datos[i]);
        }
        
        //para sacar mvoltaje -> data.get("mvoltaje")      
       
        //System.out.print("linea: ");
        //System.out.println(linea);
        //System.out.print("arr: ");
        //System.out.println(Arrays.toString(arr));
        //// String tipo = arr[0];
        
        //Reconocemos el tipo de dato entrante
        /**
        if(tipo.equals("a")){
            double temperatura = Double.parseDouble(arr[1]);
            double radiacion = Double.parseDouble(arr[2]);
            String dirViento = arr[3];
            double magViento = Double.parseDouble(arr[4]);
            dato = new Ambiental(temperatura, radiacion, magViento, dirViento);
        }else if(tipo.equals("p")){
            double corriente = Double.parseDouble(arr[1])/10;
            double voltaje = Double.parseDouble(arr[2])/10;
            double potencia = Double.parseDouble(arr[3])/10;
            dato = new Panel(corriente, voltaje, potencia);
        }else if(tipo.equals("m")){
            double corriente = Double.parseDouble(arr[1])/10;
            double voltaje = Double.parseDouble(arr[2])/10;
            double temperatura = Double.parseDouble(arr[3])/10;
            dato = new Motor(corriente, voltaje, temperatura);
        }else if(tipo.equals("b")){
            double soc = Double.parseDouble(arr[1])/10;
            double voltaje = Double.parseDouble(arr[2])/10;
            double corriente = Double.parseDouble(arr[3])/10;
            dato = new Bateria(soc, voltaje, corriente);
        }else if(tipo.equals("g")){
            double velocidad = Double.parseDouble(arr[1])/10;
            double distancia = Double.parseDouble(arr[2])/10;
            dato = new General(velocidad, distancia);
        }
        */
        almacenarDatos(ambiental,bateria,general,motor,panel);
    }
    
    private static void almacenarDatos(Dato ambiental, Dato bateria, Dato general,Dato motor, Dato panel){
        if(ambiental != null){
            Conexion.guardar(ambiental);
        }else{
            System.out.println("Dato ambiental no encontrado");
        }
        if(bateria != null){
            Conexion.guardar(bateria);
        }else{
            System.out.println("Dato bateria no encontrado");
        }
        if(general != null){
            Conexion.guardar(general);
        }else{
            System.out.println("Dato general no encontrado");
        }
        if(motor != null){
            Conexion.guardar(motor);
        }else{
            System.out.println("Dato motor no encontrado");
        }
        if(panel != null){
            Conexion.guardar(panel);
        }else{
            System.out.println("Dato panel no encontrado");
        }
    }
}
