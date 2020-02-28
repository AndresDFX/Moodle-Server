package JavaClases;

import java.io.*;
import java.util.ArrayList;

/**
 * [GestionArchivo] Clase plantilla para la creacion de objetos Matricula
 * @since 24/11/2017
 * @version 2.0
 * @author Julian Andres Castaño - 1625743
 */
public class GestionArchivo {
    
    //Declaracion de Variables de Flujos
    private FileInputStream entrada;
    private FileOutputStream salida;
    private File archivo;
    
//=======================================================================================================     
    /**
     * Constructor de la clase GestionArchivo
     * @since GestionArchivo.java
     */
    
    public GestionArchivo()
    {
        entrada = null;
        salida = null;
        archivo = null;        
    }
    
//=======================================================================================================    
    /**
     * Metodo que permite abrir un archivo y retornar su contenido
     * @param archivo Variable que almacena el archivo que se le va pasar al jFileChooser
     * @return el contenido [String] del archivo que se le paso como parametro al metodo
     */
    public String abrirArchivo(File archivo)
    {        
        String contenido="";
        try{
            entrada = new FileInputStream(archivo);
            int identificador;
            while((identificador =entrada.read())!=-1)
            {
              char caracter = (char)identificador;
              contenido+= caracter;
            }
        }
        catch(IOException e){
            System.out.println("Error al abrir el archivo"+e.getMessage());
        }
        return contenido;
    }
    
//=======================================================================================================     
   /**
    * Metodo que obtiene un String con el contenido del archivo a guardar y escribe el archivo en Bytes
    * @param archivo Variable que almacena el archivo nuevo de texto que se va crear
    * @param contenido Variable que almacena el contenido del nuevo archivo de texto
    * @return Mensaje de confirmacion si el archivo se guardo con exito
    */  
    public String guardarArchivo(File archivo, String contenido)
    {
        String respuesta=null;
        try{
             salida= new FileOutputStream(archivo);
             byte[] bytesTexto = contenido.getBytes();
             salida.write(bytesTexto);
             respuesta = "Se guardo con exito el archivo";
         }
        catch(IOException e){
            respuesta="Error al guardar el archivo"+e.getMessage();
        }    
        return respuesta;       
    }
       
//=======================================================================================================     
    /**
     * Metodo que permite listar los ficheros de una determinada carpeta
     * @param carpeta variable que almacena el nombre de la carpeta
     * @return 
     */
    public ArrayList <String> listarFicherosPorCarpeta(File carpeta)
    {
        ArrayList <String> nombres = new ArrayList<>();
        for (File ficheroEntrada : carpeta.listFiles()) 
        {        
            if (ficheroEntrada.isDirectory()) 
            {
                listarFicherosPorCarpeta(ficheroEntrada);
            } 
            else if(ficheroEntrada.getName().endsWith("txt")) 
            {
                nombres.add(ficheroEntrada.getName());
            }
        }
        return nombres;
    }
    
//=======================================================================================================
    /**
    * Metodo que permite guardar un archivo de texto dado su contenido
    * @param rutaArchivo Variable que almacena la ruta del archivo a guardar
    * @param linea Variable que almacena la linea que se ira guardando ene l archivo
    * @param variableExiste Variable que permite determinar si el archivo ya existe, si es asi lo sobreescribe
    * @return Mensaje de confirmacion si el archivo se guardo con exito
    */  
    public String guardarExamen(String rutaArchivo, String linea, boolean variableExiste)
    {
        String respuesta=null;
        try{
            File archivoGuardar = new File(rutaArchivo);
            variableExiste = archivoGuardar.exists();
            FileWriter escritura = new FileWriter(archivoGuardar, variableExiste);
            escritura.write(linea);
            escritura.close();
            respuesta = "Se guardo con exito el archivo";
         }
        catch(IOException e){
            respuesta="Error al guardar el archivo: "+e.getMessage();
        }    
        return respuesta;
    }
//=======================================================================================================    
}    



         
    
    
            
  