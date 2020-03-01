package Modelo;

import Vista.*;
import java.net.*;
import java.io.*;
import java.util.concurrent.*;

/**
 * [ControladorServidor] Clase que representa el hilo de ejecucion del servidor
 * @since 24/11/2017
 * @version 2.0
 * @author Julian Andres Castaño - 1625743
 */

public class ControladorServidor implements Runnable{

    //Declaracion de Variables de conexion
    private int puertoSocket = ControladorHilos.puerto;
    private ServerSocket socketServidor = null;
    public static int numeroClientes = 0;
    
    //Declaracion de variables auxiliares
    private ControladorHilos hilosClientes = null;   
    private Thread hilos = null;   
    private int numeroClientesGUI;
    
//=======================================================================================================
    /**
     * Constructor de la clase ControladorServidor
     * @since ControladorServidor.java
     */

    public ControladorServidor()
    {
        try
        {  
           mostrarMensajes("Conectandose al puerto " + puertoSocket + ", Espere un momento....");
           socketServidor = new ServerSocket(puertoSocket);         
           mostrarMensajes("Server iniciado: " + socketServidor);
           iniciarServidor();
        }
        
        catch(IOException ioe){  
           mostrarMensajes("Error en constructor: "+ioe.getMessage()); 
        }
   }
    
//=======================================================================================================    
   /**
    * Sobreescritura del metodo run para esperar por clientes a que 
    * los clientes se conecten y por cada uno de ellos crea un subproceso nuevo
    */
   @Override
   public void run()
   {
        while(true)
        {
            numeroClientesGUI = Integer.parseInt(Menu.jSpinnerEstudiantes.getValue().toString());
            if (numeroClientes<numeroClientesGUI && Menu.estadoExamen!=1)
            {      
                try
                {  
                    mostrarMensajes("Esperando por clientes..."); 
                    agregarHilos(socketServidor.accept());                    
                }
                catch(IOException ie)
                {  
                    mostrarMensajes("Error al ejecutar el controlador del servidor: "+ie.getMessage());
                }      
            }
            else
            {
                System.out.print("");      
            }
        }
        
   }
   
//=======================================================================================================   
   /**
    * Metodo auxiliar que permite agregar nuevos clientes e inicializarnos
    * @param socket Variable que almacena el socket de conexion que representa el cliente
    */
   public void agregarHilos(Socket socket) 
   {   
        try
        {         
            mostrarMensajes("==================================================================================");
            mostrarMensajes("Conectado #"+(numeroClientes+1)+"\nCliente aceptado: " + socket);
            hilosClientes = new ControladorHilos(socket);
            hilosClientes.abrirFlujos();
            hilosClientes.start();
            numeroClientes++;
                    
        }catch(IOException ex){  
            mostrarMensajes("Error al agregar hilos :"+ ex.getMessage());
        }
    
   }
     
//=======================================================================================================   
  
   /**
    * Método que muestra por pantalla la información que se va produciendo en ejecución en la interfaz del servidor
    * @param mensaje Variable que almacena el mensaje a mostrar por pantalla
    */
   public final void mostrarMensajes(String mensaje)
   {
       System.out.println(mensaje);
   }
//=======================================================================================================     
   /**
    * Metodo que permite arrancar el hilo de ejecucion del servidor
    */
   public final void iniciarServidor()
   {       
        if (hilos == null)
        {  
           hilos = new Thread(this); 
           hilos.start();
        }
   }
//=======================================================================================================   
   /**
    * Metodo que permite detener el hilo de ejecucion del servidor
    */
   public void detenerServidor()
   {    
//    if (hilos != null)
//      {  
//        hilos.interrupt();
//        hilos = null;
//      }
       hilos.interrupt();
   }
   
 //=======================================================================================================
   /**
    * Metodo que ejecuta un hilo de tiempo y pone la informacion en JLabel de la interfaz GUI y ademas lo 
    * envia simultaneamente atravez del Multicast
    * @param hora Variable que almacena las horas determinada en la interfaz GUI
    * @param minutos Variable que almacena los minutos determinada en la interfaz GUI
    * @param segundos Variable que almacena los segundos determinada en la interfaz GUI
    * @throws InterruptedException
    * @throws ExecutionException 
    */
    
   public void ejecucionTiempo(int hora, int minutos, int segundos) throws InterruptedException, ExecutionException
   {        
        HiloTiempo nuevoTiempo = new HiloTiempo(hora, minutos, segundos); 
        nuevoTiempo.start();      
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        
        executorService.scheduleAtFixedRate(() -> {
            if(Menu.estadoExamen==2)
            {
                Menu.jLabelNumeros.setText("");
                Menu.jLabelTituloNumeros.setText("");
                enviarMulticast(Menu.jLabelNumeros.getText());
                executorService.shutdownNow();
            }
            else
            {
                enviarMulticast(Menu.jLabelNumeros.getText());
            }
             
        }, 0, 1, TimeUnit.SECONDS);
    }

//=======================================================================================================
   /**
    * Metodo auxiliar que permite enviar el hilo de tiempo atravez del Multicast
    * @param reloj Variable que almacena el tiempo actual del hilo
    */
    public void enviarMulticast(String reloj) 
    {
       hilosClientes.envioMulticast(reloj);
    }
//=======================================================================================================        
    
}


 
  
 


