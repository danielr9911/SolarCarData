/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eafit.solarcardata;
import java.io.*;
import java.util.*;
import javax.comm.*;
/**
 *
 * @author Daniel
 */
public class Serial {
    static Enumeration portList;
    static CommPortIdentifier portId;
    static String messageString = "Hello, world!\n";
    static SerialPort serialPort;
    static OutputStream outputStream;
    
    public void leerSerial(){
        portList = CommPortIdentifier.getPortIdentifiers();

        while (portList.hasMoreElements()) {
            portId = (CommPortIdentifier) portList.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                 if (portId.getName().equals("COM1")) {
                //if (portId.getName().equals("/dev/term/a")) {
                    try {
                        serialPort = (SerialPort)
                            portId.open("SimpleWriteApp", 2000);
                    } catch (PortInUseException e) {}
                    try {
                        outputStream = serialPort.getOutputStream();
                    } catch (IOException e) {}
                    try {
                        serialPort.setSerialPortParams(9600,
                            SerialPort.DATABITS_8,
                            SerialPort.STOPBITS_1,
                            SerialPort.PARITY_NONE);
                    } catch (UnsupportedCommOperationException e) {}
                    try {
                        outputStream.write(messageString.getBytes());
                    } catch (IOException e) {}
                }
            }
        }
    }
    
    public void listarPuertos() {
        // get list of ports available on this particular computer,
        // by calling static method in CommPortIdentifier.
        Enumeration pList = CommPortIdentifier.getPortIdentifiers();

        // Process the list.
        while (pList.hasMoreElements()) {
          CommPortIdentifier cpi = (CommPortIdentifier) pList.nextElement();
          System.out.print("Port " + cpi.getName() + " ");
          if (cpi.getPortType() == CommPortIdentifier.PORT_SERIAL) {
            System.out.println("is a Serial Port: " + cpi);
          } else if (cpi.getPortType() == CommPortIdentifier.PORT_PARALLEL) {
            System.out.println("is a Parallel Port: " + cpi);
          } else {
            System.out.println("is an Unknown Port: " + cpi);
          }
        }
    }
    
    public void puertosDisponibles(){
        Enumeration ports = CommPortIdentifier.getPortIdentifiers();
        while (ports.hasMoreElements()) {
          CommPortIdentifier port = (CommPortIdentifier) ports.nextElement();
          String type;
          switch (port.getPortType()) {
          case CommPortIdentifier.PORT_PARALLEL:
            type = "Parallel";
            break;
          case CommPortIdentifier.PORT_SERIAL:
            type = "Serial";
            break;
          default: /// Shouldn't happen
            type = "Unknown";
            break;
          }
          System.out.println(port.getName() + ": " + type);
        }
    }
}
