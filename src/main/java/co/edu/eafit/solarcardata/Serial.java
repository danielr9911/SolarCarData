/*
 * Proyecto Solar Car Data
 * Proyecto Integrador 1
 * Universidad EAFIT
 * 2016
 */
package co.edu.eafit.solarcardata;
import gnu.io.*; 
import java.io.*;
/**
 *
 * @author Daniel
 */
public class Serial {
   public void conectar(String puerto) throws Exception{
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(puerto);
        if ( portIdentifier.isCurrentlyOwned() )
        {
            System.out.println("Error: El puerto esta actualmente en uso");
        }
        else
        {
            CommPort commPort = portIdentifier.open(this.getClass().getName(),2000);
            if ( commPort instanceof SerialPort )
            {
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(38400,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
                //System.out.println("InputStream");
                InputStream in = serialPort.getInputStream();
                serialPort.addEventListener(new SerialReader(in));
                serialPort.notifyOnDataAvailable(true);
                //System.out.println("Termina");
                //OutputStream out = serialPort.getOutputStream();
                //(new Thread(new SerialWriter(out))).start();

            }
            else
            {
                System.out.println("Error: El puerto especificado no es un puerto serial");
            }
        }
    }
    private class SerialReader implements SerialPortEventListener 
    {
        private final InputStream in;
        private final byte[] buffer = new byte[1024];
        
        public SerialReader ( InputStream in )
        {
            this.in = in;
        }
        
        @Override
        public void serialEvent(SerialPortEvent arg0) {
            int data;
          
            try
            {
                int len = 0;
                while ( ( data = in.read()) > -1 )
                {
                    if ( data == '\n' ) {
                        break;
                    }
                    buffer[len++] = (byte) data;
                }
                String linea = new String(buffer,0,len);
                //Elimino el '\n' al final de la linea
                linea = linea.substring(0, linea.length()-1);
                //System.out.println(linea);
                Interpretador.reconocer(linea);
                
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }             
        }

    }
    public void listarPuertos()
    {
        java.util.Enumeration<CommPortIdentifier> portEnum = CommPortIdentifier.getPortIdentifiers();
        while ( portEnum.hasMoreElements() ) 
        {
            CommPortIdentifier portIdentifier = portEnum.nextElement();
            System.out.println(portIdentifier.getName()  +  " - " +  getPortTypeName(portIdentifier.getPortType()) );
        }        
    }
    
    private String getPortTypeName ( int portType )
    {
        switch ( portType )
        {
            case CommPortIdentifier.PORT_I2C:
                return "I2C";
            case CommPortIdentifier.PORT_PARALLEL:
                return "Parallel";
            case CommPortIdentifier.PORT_RAW:
                return "Raw";
            case CommPortIdentifier.PORT_RS485:
                return "RS485";
            case CommPortIdentifier.PORT_SERIAL:
                return "Serial";
            default:
                return "unknown type";
        }
    }
}
