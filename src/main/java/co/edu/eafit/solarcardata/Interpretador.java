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
import java.util.HashMap;

/**
 *
 * @author Daniel
 */
public class Interpretador {
    public static String[] orden = null;
    
    private static void verificarOrden() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("ordenDatos.conf");
        BufferedReader bf;
        bf = new BufferedReader(fr);
        String configuracion = bf.readLine();
        //System.out.println(configuracion);
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
            //System.out.println("odenDatos.conf leido correctamente");
        }catch(Exception e){
            e.printStackTrace();
        }
        String[] datos = linea.split(",");
        //Tenemos datos y orden llenos correctamente
//        System.out.println("Orden:"+orden.length);
//        System.out.println("Datos:"+datos.length);
        HashMap<String, String> data = new HashMap<>();
        for(int i=0; i<datos.length;i++){
            //Se puede mejorar con Double.parseDouble(datos[i])
            data.put(orden[i], datos[i]);
        }
        //System.out.println("KeySet:"+data.keySet());
        //System.out.println("Data[0]:"+data.get("hhmmss"));
        //System.out.println("Data[96]:"+data.get("envtemp"));

//        System.out.println("Data:"+data.size());
        
        //para sacar mvoltaje -> data.get("mvoltaje")      
        //Cream ambiental
        ambiental = new Ambiental(Double.parseDouble(data.get("envtemp")));
        //Crear bateria
        bateria = new Bateria(Double.parseDouble(data.get("cmutmax")), Double.parseDouble(data.get("socpercent")), Double.parseDouble(data.get("cellvmin")),
            Double.parseDouble(data.get("cellvmax")), Double.parseDouble(data.get("celltmax")), Double.parseDouble(data.get("flagsb")), Double.parseDouble(data.get("pcbtemp0")),
            Double.parseDouble(data.get("pcbtemp1")), Double.parseDouble(data.get("pcbtemp2")), Double.parseDouble(data.get("pcbtemp3")), Double.parseDouble(data.get("pcbtemp4")),
            Double.parseDouble(data.get("celltemp0")), Double.parseDouble(data.get("celltemp1")), Double.parseDouble(data.get("celltemp2")),
            Double.parseDouble(data.get("celltemp3")), Double.parseDouble(data.get("celltemp4")), Double.parseDouble(data.get("socma")), Double.parseDouble(data.get("voltage")),
            Double.parseDouble(data.get("current")), Double.parseDouble(data.get("cvoltage0")), Double.parseDouble(data.get("cvoltage1")), Double.parseDouble(data.get("cvoltage2")),
            Double.parseDouble(data.get("cvoltage3")), Double.parseDouble(data.get("cvoltage4")), Double.parseDouble(data.get("cvoltage5")),
            Double.parseDouble(data.get("cvoltage6")), Double.parseDouble(data.get("cvoltage7")), Double.parseDouble(data.get("cvoltage8")),
            Double.parseDouble(data.get("cvoltage9")), Double.parseDouble(data.get("cvoltage10")), Double.parseDouble(data.get("cvoltage11")),
            Double.parseDouble(data.get("cvoltage12")), Double.parseDouble(data.get("cvoltage13")), Double.parseDouble(data.get("cvoltage14")),
            Double.parseDouble(data.get("cvoltage15")), Double.parseDouble(data.get("cvoltage16")), Double.parseDouble(data.get("cvoltage17")),
            Double.parseDouble(data.get("cvoltage18")), Double.parseDouble(data.get("cvoltage19")), Double.parseDouble(data.get("cvoltage20")),
            Double.parseDouble(data.get("cvoltage21")), Double.parseDouble(data.get("cvoltage22")),Double.parseDouble(data.get("cvoltage23")),
            Double.parseDouble(data.get("cvoltage24")), Double.parseDouble(data.get("cvoltage25")), Double.parseDouble(data.get("cvoltage26")),
            Double.parseDouble(data.get("cvoltage27")), Double.parseDouble(data.get("cvoltage28")), Double.parseDouble(data.get("cvoltage29")),
            Double.parseDouble(data.get("cvoltage30")), Double.parseDouble(data.get("cvoltage31")), Double.parseDouble(data.get("cvoltage32")),
            Double.parseDouble(data.get("cvoltage33")));
        
         //CrearPanel
         
        panel = new Panel(Double.parseDouble(data.get("mpptflagspanel0")), Double.parseDouble(data.get("mpptflagspanel1")), 
            Double.parseDouble(data.get("mpptflagspanel2")), Double.parseDouble(data.get("mpptvin0")), Double.parseDouble(data.get("mpptvin1")),
            Double.parseDouble(data.get("mpptvin2")), Double.parseDouble(data.get("mpptiin0")), Double.parseDouble(data.get("mpptiin1")), Double.parseDouble(data.get("mpptiin2")),
            Double.parseDouble(data.get("mpptvout0")), Double.parseDouble(data.get("mpptvout1")), Double.parseDouble(data.get("mpptvout2")), 
            Double.parseDouble(data.get("mpptiout0")), Double.parseDouble(data.get("mpptiout1")), Double.parseDouble(data.get("mpptiout2")), 
            Double.parseDouble(data.get("tempint")), Double.parseDouble(data.get("currentint")));
        //Crear Motor

        motor = new Motor(Double.parseDouble(data.get("railvoltageb")), Double.parseDouble(data.get("mcbuscurrent")), Double.parseDouble(data.get("mccurrentq")),
            Double.parseDouble(data.get("mctorque")), Double.parseDouble(data.get("mcbusvoltage")), Double.parseDouble(data.get("mcrailvoltage")), 
            Double.parseDouble(data.get("mcspeed")), Double.parseDouble(data.get("mcodo")), Double.parseDouble(data.get("mcrpm")), Double.parseDouble(data.get("mctemp")),
            Double.parseDouble(data.get("mcws22temp")), Double.parseDouble(data.get("mcflags")));
        

        //Crear General
        
        general = new General(Double.parseDouble(data.get("imuspeedgnd")), Double.parseDouble(data.get("imuyaw")), Double.parseDouble(data.get("imucourse")),
            Double.parseDouble(data.get("imulongitude")), Double.parseDouble(data.get("imupitch")), Double.parseDouble(data.get("imulattitude")),
            Double.parseDouble(data.get("imualttitude")), Double.parseDouble(data.get("imuroll")), Double.parseDouble(data.get("aux")));
        //System.out.println("Llamo a almacenar datos");
        almacenarDatos(ambiental,bateria,general,motor,panel);
    }
    
    private static void almacenarDatos(Dato ambiental, Dato bateria, Dato general,Dato motor, Dato panel){
//        System.out.println("Llego a almacenar datos");
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



