package Modelo;

import Vista.Menu;
import java.net.*;
import java.io.*;

//=======================================================================================================

/**
 * [ControladorHilos] Clase que representa los clientes en el servidor
 * @since 24/11/2017
 * @version 2.0
 * @author Julian Andres Castaño - 1625743
 */

public class ControladorHilos extends Thread {
    
    //Declaracion de Variables de Conexion
    public static int puerto = 4000;
    public static String inet = "235.1.1.1";
    public static String miIP;   
      
    //Declaracion de Variables de Flujos    
    private DataInputStream streamIn =  null;
    private ObjectOutputStream streamOut = null;
    private MulticastSocket socketMulti = null;
    private DatagramPacket datagramaAEnviar = null;
    private final InetAddress direccionInet; 
    private Socket socket = null;
    
    //Declaracion de Variables Auxiliares
    private String preguntasRespondidas="#";
    private double calificacionGlobal=0.0;
    private int preguntaActual;
    private int ID = -1;  
    
//=======================================================================================================
    /**
     * Constructor de clase ControladorHilos
     * @param _socket Variable que almacena el objeto socket que representa cada cliente a conectar
     * @throws IOException 
     * @since ControladorHilos.java
     */
    
   public ControladorHilos(Socket _socket) throws IOException 
   {  
       socketMulti = new MulticastSocket();
       socket = _socket;  
       ID = socket.getPort(); 
       direccionInet = InetAddress.getByName(inet);
       miIP = InetAddress.getLocalHost().getHostAddress();
   }
//======================================================================================================= 
   /**
    * Sobreescritura del metodo run permite leer los datos de entrada de los clientes y en cuyo caso si un 
    * cliente se desconecta se genera una excepcion
    */
  
   @Override
   public void run()
   {          
        mostrarMensaje("Hilo " + ID + " corriendo.");
        try {
            while (true)
            {            
                String flujo = streamIn.readUTF();
                receptorPreguntas(flujo);            
            }
        }
        
        catch (IOException | InterruptedException ex)                                                                                                                                                  
        {
            ControladorServidor.numeroClientes--;
            System.out.println("Error en metodo run controlador de hilos: "+ex.getMessage());
        } 
   }
   
//=======================================================================================================
   /**
    * Metodo encargado de recibir el numero de pregunta del cliente con un identificador y segun eso realiza una accion
    * @param numeroPregunta Variable que almacena el numero de preunta con identificador
    * @throws InterruptedException
    * @throws IOException 
    */

    public void receptorPreguntas(String numeroPregunta)throws IOException, InterruptedException 
    {
       System.out.println("El hilo "+currentThread().getName()+ " solicito la siguiente operacion "+numeroPregunta);
       String solicitudCliente = numeroPregunta.substring(0,1);
       preguntaActual = Integer.parseInt(numeroPregunta.substring(1,2));
       
       if (solicitudCliente.equals("N"))
        {
            if(GestionPreguntas.arregloPreguntas.get(preguntaActual).getEstado().equals("Libre"))
            {
                GestionPreguntas.arregloPreguntas.get(preguntaActual).setEstado("Ocupada");        
                streamOut.writeObject(GestionPreguntas.arregloPreguntas.get(preguntaActual));
                streamOut.flush();               
            }
            
            else if (GestionPreguntas.arregloPreguntas.get(preguntaActual).getEstado().equals("Ocupada"))
            {
                streamOut.writeObject(new Preguntas(null, null, null, null, "Ocupada por otro", null, null));
                streamOut.flush();
            }
            
            else if (GestionPreguntas.arregloPreguntas.get(preguntaActual).getEstado().equals("Respondida"))
            {
                streamOut.writeObject(new Preguntas(null, null, null, null, "Respondida", null, null));
                streamOut.flush();
            }
        }
       
        else if (solicitudCliente.equals("L"))
        {
            GestionPreguntas.arregloPreguntas.get(preguntaActual).setEstado("Libre"); 
        }
              
        else if (solicitudCliente.equals("R"))
        {
            String respuesta=numeroPregunta.substring(2,3);
            String nombreCliente = numeroPregunta.substring(3);
            
            GestionPreguntas.arregloPreguntas.get(preguntaActual).setEstado("Respondida");
            GestionPreguntas.arregloPreguntas.get(preguntaActual).setQuienRespondio(nombreCliente);
            
            if(GestionPreguntas.arregloPreguntas.get(preguntaActual).getCorrecta().equalsIgnoreCase(respuesta))
            {
                GestionPreguntas.arregloPreguntas.get(preguntaActual).setCalificacion("Bien");                
            }
       
            else
            {
                GestionPreguntas.arregloPreguntas.get(preguntaActual).setCalificacion("Mal");
            }            
        }
       
        else if (solicitudCliente.equals("T"))
        {
            Menu.jPaneInforme.setVisible(true);
            Menu.estadoExamen = 2;
            Menu.jLabelNumeros.setText("");
            Menu.jLabelTituloNumeros.setText("");        
        }
    } 
    
//=======================================================================================================
    /**
     * Metodo que permite enviar atravez del Multicast el tamaño de las preguntas y el hilo del tiempo
     * @param tiempo Variable que almacena el tiempo actual en el hilo del tiempo
     */  
    public void envioMulticast (String tiempo)
    {
        try {
            calificacionGlobal();
            preguntasRespondidas(); 
            estadoExamen();
            String mensaje = tiempo+"@"+GestionPreguntas.arregloPreguntas.size()+"@"+Menu.estadoExamen+"@"+preguntasRespondidas+"@"+String.format("%.2f",calificacionGlobal); 
            byte [] buffer =  mensaje.getBytes();
            datagramaAEnviar = new DatagramPacket(buffer, buffer.length,direccionInet, puerto);
            socketMulti.send(datagramaAEnviar);
            preguntasRespondidas="#";                                       
        }
            
        catch (IOException ex) {
            mostrarMensaje("Error al enviar preguntas: "+ex.getMessage());
        }          
    }
  
//=======================================================================================================
   /**
    * Metodo parar mostrar los mensajes de ejecucion por pantalla
    * @param mensaje Variable que almacena el mensaje a mostrar por pantalla
    */ 
   public void mostrarMensaje(String mensaje)
   {
       System.out.println(mensaje);
   }
//======================================================================================================= 
   /**
    * Metodo para abrir el flujo de conexion que envia del cliente al servidor
    * @throws IOException 
    */
   public void abrirFlujos() throws IOException
   {  
       streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
       streamOut = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
       streamOut.flush();
   }
   
//=======================================================================================================
   /**
    * Metodo para cerrar los flujos Socket y flujo de entrada al servidor
    * @throws IOException 
    */
   public void cerrarFlujos() throws IOException
   {  
        if (socket != null)   
           socket.close();
      
        if (streamIn != null)  
           streamIn.close();
       
        if (streamOut != null)  
           streamOut.close();
   }
       
//=======================================================================================================
   /**
    * Metodo que permite verificar la cantidad de preguntas  Respondidas
    */
    public void preguntasRespondidas()
    {
        for(int i=0; i<GestionPreguntas.arregloPreguntas.size();i++)
        {            
            if (GestionPreguntas.arregloPreguntas.get(i).getEstado().equalsIgnoreCase("Respondida"))
            {
                preguntasRespondidas+=","+i;
            }            
        }
    }
    
//=======================================================================================================
    /**
     * Metodo que permite verificar si todas las preguntas del examen estan respondidas
     */
    public void estadoExamen()
    {
        int contadorRespondidas=0;
        for(int i=0;i<GestionPreguntas.arregloPreguntas.size();i++)
        {
            if(GestionPreguntas.arregloPreguntas.get(i).getEstado().equals("Respondida"))
                {
                    contadorRespondidas++;
                }
        }

        if(contadorRespondidas==GestionPreguntas.arregloPreguntas.size())
        {
            Menu.estadoExamen=2;
        }        
    }
//=======================================================================================================
    /**
     * Metodo que permite hallar el calculo del promedio de las notas deacuerdo a las buenas
     */
    public void calificacionGlobal()
    {
        int contadorBuenas=0;
        for(int i=0;i<GestionPreguntas.arregloPreguntas.size();i++)
        {
            if(GestionPreguntas.arregloPreguntas.get(i).getCalificacion().equals("Bien"))
            {
                contadorBuenas++;
            }
        }
        double division =  (double) contadorBuenas/GestionPreguntas.arregloPreguntas.size();
        calificacionGlobal = division*5;        
    }
//=======================================================================================================
}
