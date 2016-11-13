/*
 * Proyecto Solar Car Data
 * Proyecto Integrador 1
 * Universidad EAFIT
 * 2016
 */
package co.edu.eafit.solarcardata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Interpretador
 * Interpreta y clasifica cada dato para facilitar su manejo.
 * @author Daniel Rendon
 * @author Laura Mejia
 * @author Daniela Serna
 */
public class Interpretador {
    public static String[] orden = null;
    public static boolean verificado = false;
    
    private static void verificarOrden() throws FileNotFoundException, IOException{
        verificado=true;
        FileReader fr = new FileReader("ordenDatosCorrecto.conf");
        BufferedReader bf;
        bf = new BufferedReader(fr);
        String configuracion = bf.readLine();
        bf.close();
        orden = configuracion.split(",");
    }
    
    public static void reconocer(String linea){
        Dato bateria = null;
        Dato general = null;
        Dato motor = null;
        Dato panel = null;
        if(!verificado){
            try{
                verificarOrden();
                System.out.println("odenDatos.conf leido correctamente");
            }catch(Exception e){
               e.printStackTrace();
            }
        }
        String[] datos = linea.split(",");
        HashMap<String, Double> data = new HashMap<>();
        for(int i=0; i<datos.length;i++){
            data.put(orden[i], Double.parseDouble(datos[i]));
        }
        //System.out.println("Orden:"+orden.length);
        //System.out.println("Datos:"+datos.length);
        //System.out.println("KeySet:"+data.keySet());
        //System.out.println("Data:"+data.size());
        //para sacar mvoltaje -> data.get("mvoltaje")      

        //Crear bateria
        bateria = new Bateria(data.get("cmutmax"), data.get("socpercent"), data.get("cellvmin"),
            data.get("cellvmax"), data.get("celltmax"), data.get("flagsb"), data.get("pcbtemp0"),
            data.get("pcbtemp1"), data.get("pcbtemp2"), data.get("pcbtemp3"), data.get("pcbtemp4"),
            data.get("celltemp0"), data.get("celltemp1"), data.get("celltemp2"),
            data.get("celltemp3"), data.get("celltemp4"), data.get("socma"), data.get("voltage"),
            data.get("current"), data.get("cvoltage0"), data.get("cvoltage1"), data.get("cvoltage2"),
            data.get("cvoltage3"), data.get("cvoltage4"), data.get("cvoltage5"),
            data.get("cvoltage6"), data.get("cvoltage7"), data.get("cvoltage8"),
            data.get("cvoltage9"), data.get("cvoltage10"), data.get("cvoltage11"),
            data.get("cvoltage12"), data.get("cvoltage13"), data.get("cvoltage14"),
            data.get("cvoltage15"), data.get("cvoltage16"), data.get("cvoltage17"),
            data.get("cvoltage18"), data.get("cvoltage19"), data.get("cvoltage20"),
            data.get("cvoltage21"), data.get("cvoltage22"),data.get("cvoltage23"),
            data.get("cvoltage24"), data.get("cvoltage25"), data.get("cvoltage26"),
            data.get("cvoltage27"), data.get("cvoltage28"), data.get("cvoltage29"),
            data.get("cvoltage30"), data.get("cvoltage31"), data.get("cvoltage32"),
            data.get("cvoltage33"));
        
         //CrearPanel
        panel = new Panel(data.get("mpptflagspanel0"), data.get("mpptflagspanel1"), 
            data.get("mpptflagspanel2"), data.get("mpptvin0"), data.get("mpptvin1"),
            data.get("mpptvin2"), data.get("mpptiin0"), data.get("mpptiin1"), data.get("mpptiin2"),
            data.get("mpptvout0"), data.get("mpptvout1"), data.get("mpptvout2"), 
            data.get("mpptiout0"), data.get("mpptiout1"), data.get("mpptiout2"), 
            data.get("currentint"));
        
        //Crear Motor
        motor = new Motor(data.get("railvoltageb"), data.get("mcbuscurrent"), data.get("mccurrentq"),
            data.get("mctorque"), data.get("mcbusvoltage"), data.get("mcrailvoltage"), 
            data.get("mcspeed"), data.get("mcodo"), data.get("mcrpm"), data.get("mctemp"),
            data.get("mcws22temp"), data.get("mcflags"));

        //Crear General
        general = new General(data.get("posvmax"), data.get("posvmin"), data.get("imuspeedgnd"), data.get("imuyaw"), data.get("imucourse"),
            data.get("imulongitude"), data.get("imupitch"), data.get("imulattitude"),
            data.get("imualttitude"), data.get("imuroll"));
       
        almacenarDatos(bateria,general,motor,panel);
    }
    
    private static void almacenarDatos(Dato bateria, Dato general,Dato motor, Dato panel){
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



