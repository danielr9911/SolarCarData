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
public class SolarCarData {
    public static void main(String[] args){
        //Conexion conexion = new Conexion();
        //conexion.conectar();
        //conexion.ingresarDato("Ejemplo", "Dato1", 6.5f);
        Serial serial = new Serial();
        serial.puertosDisponibles();
    }
}
