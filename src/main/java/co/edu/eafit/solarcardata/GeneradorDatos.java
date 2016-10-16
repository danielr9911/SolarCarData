/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eafit.solarcardata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Daniel
 */
public class GeneradorDatos {
    public static void generar() throws FileNotFoundException, IOException{
        
        FileReader fr = new FileReader("datosreales.txt");
        BufferedReader bf = new BufferedReader(fr);
        
        FileWriter fw = new FileWriter("datosgenerados.txt");
        PrintWriter pw = new PrintWriter(fw);
        
        
        String linea;
        while((linea=bf.readLine())!=null){
            String lineaNueva = linea + ",2.00,3.00,4.00";
            pw.println(lineaNueva);
            System.out.println(linea);
            System.out.println(lineaNueva);
        }
    }
}
