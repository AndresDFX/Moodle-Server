package JavaClases;

import java.io.*;
import java.util.*;

/**
 * [GestionPreguntas] Clase que permite realizar la gestion sobre los objetos de clase Preguntas
 * @since 24/11/2017
 * @version 2.0
 * @author Julian Andres Castaño - 1625743
 */
public class GestionPreguntas {
    
    //Declaracion de Variables Estaticas
    public static ArrayList <Preguntas> arregloPreguntas;
   
    //Declaracion de Variables Auxiliares
    private GestionArchivo gestionarArchivos;
    private FileReader fileReader;
    private BufferedReader unBuffer;
    private File archivo;
    
//=======================================================================================================   
    /**
    * Constructor de la clase GestionPreguntas
    * @since GestionPreguntas.java
    */ 

    public GestionPreguntas()
    {
        arregloPreguntas = new ArrayList<>();
        gestionarArchivos = new GestionArchivo();
        fileReader = null;
        unBuffer = null;
        archivo = null;

    }
//=======================================================================================================
    /**
     * Metodo que dado un archivo, crea un arreglo de tipo Preguntas con toda la informacion cargada
     * @param archivo Varable que almacena el archivo cargado
     */
    
    public void crearPreguntas(File archivo) 
    {
        try{
            
            this.archivo = archivo;
            this.fileReader = new FileReader(this.archivo);           
            this.unBuffer = new BufferedReader(fileReader);
            
            String linea;

            String pregunta=null;
            String mensaje=null;
            String [] opcionesPregunta = null;
            String opcionCorrecta=null;
            String estadoPregunta=null;
            String calificacion=null;
            String respondidaPor=null;
           
            while((linea=unBuffer.readLine())!=null)
            {
                if(linea.indexOf("Pregunta")==0)
                {
                   pregunta=(linea.substring(9));
                   linea=unBuffer.readLine();
                }

                if(linea.indexOf("Mensaje")==0)
                {
                    mensaje = linea.substring(8);
                    linea=unBuffer.readLine();
                }

                if (linea.indexOf("Opciones")==0)
                {
                    String lineaTemp = linea.substring(9);
                    opcionesPregunta = lineaTemp.split(":");
                    linea=unBuffer.readLine();
                }

                if(linea.indexOf("Correcta")==0)
                {
                    opcionCorrecta= linea.substring(9);
                    linea=unBuffer.readLine();
                }

                if(linea.indexOf("Estado")==0)
                {
                    estadoPregunta = linea.substring(7);
                    linea=unBuffer.readLine();
                }
                
                if(linea.indexOf("Calificacion")==0)
                {
                    calificacion = linea.substring(13);
                    linea=unBuffer.readLine();
                }

                if(linea.indexOf("Respondida por")==0)
                {
                    respondidaPor = linea.substring(15);                                                           
                    arregloPreguntas.add(new Preguntas(pregunta, mensaje, opcionesPregunta, opcionCorrecta, estadoPregunta,calificacion,respondidaPor));
                }
                
            }           
        }
              
        catch(IOException e){
            System.out.println("Error al abrir archivo de preguntas: "+e.getMessage());
        }
        
        finally{
            try{                   
                if( null != fileReader )
                {  
                    fileReader.close();    
                }                 
            }

            catch (IOException e2){
                System.out.println("Error al cerrar flujo de crear preguntas: "+e2.getMessage());
            }
        }
    }
    
//=======================================================================================================
    
    /**
     * Metodo que permite guardar un examen calificado en la carpeta de Calificados
     * @param nombreArchivo Variable que almancena el nombre del archivo a guardar 
     */
    public void guardarExamen (String nombreArchivo)
    {       
        for(int i=0 ; i<arregloPreguntas.size(); i++)
        {
            String nombre = "Pregunta:"+arregloPreguntas.get(i).getNombre();
            String descripcion = "Mensaje:"+arregloPreguntas.get(i).getDescripcion();
            String[]opciones = arregloPreguntas.get(i).getOpciones();
            String auxOpciones = "Opciones:"+String.join(":", opciones);
            String correcta = "Correcta:"+arregloPreguntas.get(i).getCorrecta();
            String estado = "Estado:"+arregloPreguntas.get(i).getEstado();
            String calificacion = "Calificacion:"+arregloPreguntas.get(i).getCalificacion();                
            String quienRespondio = "Respondida por:"+arregloPreguntas.get(i).getQuienRespondio();
            gestionarArchivos.guardarExamen("Examenes\\Calificados\\"+nombreArchivo,nombre+"\r\n"+descripcion
                                                                        +"\r\n"+auxOpciones+"\r\n"+correcta+"\r\n"+estado
                                                                        +"\r\n"+calificacion+"\r\n"+quienRespondio+"\r\n",false);
            
            gestionarArchivos.guardarExamen("Examenes\\Calificados\\"+nombreArchivo,"\r\n",false);
        }      
    }   
//=======================================================================================================
    
}
