/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eafit.solarcardata;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Interpretador {
    public static void reconocer(String linea){
        
        
        String[] arr = linea.split(" ");
        //System.out.print("linea: ");
        //System.out.println(linea);
        //System.out.print("arr: ");
        //System.out.println(Arrays.toString(arr));
        String tipo = arr[0];
        Dato dato = null;
        //Reconocemos el tipo de dato entrante
        
        if(tipo.equals("a")){
            double temperatura = Double.parseDouble(arr[1])/10;
            System.out.println("tempSC---->"+arr[1]);
            System.out.println("temp---->"+temperatura);
            float radiacion = Integer.parseInt(arr[2])/10;
            String dirViento = arr[3];
            float magViento = Integer.parseInt(arr[4])/10;
            dato = new Ambiental(temperatura, radiacion, magViento, dirViento);                    
        }else if(tipo.equals("p")){
            float corriente = Integer.parseInt(arr[1])/10;
            float voltaje = Integer.parseInt(arr[2])/10;
            float potencia = Integer.parseInt(arr[3])/10;
            dato = new Panel(corriente, voltaje, potencia);
        }else if(tipo.equals("m")){
            float corriente = Integer.parseInt(arr[1])/10;
            float voltaje = Integer.parseInt(arr[2])/10;
            float temperatura = Integer.parseInt(arr[3])/10;
            dato = new Motor(corriente, voltaje, temperatura);
        }else if(tipo.equals("b")){
            float soc = Integer.parseInt(arr[1])/10;
            float voltaje = Integer.parseInt(arr[2])/10;
            float corriente = Integer.parseInt(arr[3])/10;
            dato = new Bateria(soc, voltaje, corriente);
        }else if(tipo.equals("g")){
            float velocidad = Integer.parseInt(arr[1])/10;
            float distancia = Integer.parseInt(arr[2])/10;
            dato = new General(velocidad, distancia);
        }
        if(dato != null){
            Conexion.guardar(dato);
        }else{
            //Error -  Dato basura
            System.out.println("Dato no reconocido");
        }
        
    }
}
