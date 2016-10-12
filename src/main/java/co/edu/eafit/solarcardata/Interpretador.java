/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eafit.solarcardata;

/**
 *
 * @author Daniel
 */
public class Interpretador {
    public static void reconocer(String linea){
        String[] arr = linea.split(" ");
        String tipo = arr[0];
        Dato dato = null;
        //Reconocemos el tipo de dato entrante
        
        if(tipo.equals('a')){
            float temperatura = Integer.parseInt(arr[1])/10;
            float radiacion = Integer.parseInt(arr[2])/10;
            String dirViento = arr[3];
            float magViento = Integer.parseInt(arr[4])/10;
            dato = new Ambiental(temperatura, radiacion, magViento, dirViento);                    
        }else if(tipo.equals('p')){
            float corriente = Integer.parseInt(arr[1])/10;
            float voltaje = Integer.parseInt(arr[2])/10;
            float potencia = Integer.parseInt(arr[3])/10;
            dato = new Panel(corriente, voltaje, potencia);
        }else if(tipo.equals('m')){
            float corriente = Integer.parseInt(arr[1])/10;
            float voltaje = Integer.parseInt(arr[2])/10;
            float temperatura = Integer.parseInt(arr[3])/10;
            dato = new Motor(corriente, voltaje, temperatura);
        }else if(tipo.equals('b')){
            float soc = Integer.parseInt(arr[1])/10;
            float voltaje = Integer.parseInt(arr[2])/10;
            float corriente = Integer.parseInt(arr[3])/10;
            dato = new Bateria(soc, voltaje, corriente);
        }else if(tipo.equals('g')){
            float velocidad = Integer.parseInt(arr[1])/10;
            float distancia = Integer.parseInt(arr[2])/10;
            dato = new General(velocidad, distancia);
        }
        if(dato != null){
            Conexion.guardar(dato);
        }else{
            //Error -  Dato basura
        }
        
    }
}
