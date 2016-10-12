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
            float radiacion = 
            float
            
        }else if(tipo.equals('p')){
            
        }else if(tipo.equals('m')){
            
        }else if(tipo.equals('b')){
            
        }else if(tipo.equals('g')){
            
        }
        
        Conexion.guardar(dato);
        
    }
    
    public Dato crearDato(){
        
        return;
    }
}
