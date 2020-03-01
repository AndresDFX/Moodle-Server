package Modelo;

import Vista.*;

/**
 * [HiloTiempo] Clase para el manejo del Hilo del tiempo de examen
 * @since 18/11/2017
 * @version 2.0
 * @author Julian Andres Castaño - 1625743
 */

public class HiloTiempo extends Thread{

    private int hora;
    private int minuto;
    private int segundo;

//=======================================================================================================
/**
 * Constructor de la clase HiloTiempo
 * @param hora Variable que almacena la cantidad de horas
 * @param minuto Variable que almacena la cantidad de minutos
 * @param segundo Variable que almacena la cantidad de segundos
 * @since HiloTiempo.java
 */
    
    public HiloTiempo(int hora, int minuto, int segundo)
    {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    

//=======================================================================================================
    /**
     * Metodo que permite decrementar las variables estaticas, dormiendo el hilo por aproximadamente 1 segundo
     * @throws java.lang.InterruptedException
     * @since HiloTiempo.java
     */
    public void ejecutarHilo() throws InterruptedException 
    {  
            String hour="";
            String min="";
            String seg="";
               
            while(true)
            {
                if(Menu.estadoExamen!=2)
                {
                //Decremento de variables estaticas en ciclo infinito
                if(segundo!=0) {
                    segundo--;                                  
                }else{
                    if(minuto!=0){
                        segundo=59;
                        minuto--;
                    }else{
                        if(hora!=0)
                        {
                           
                            minuto = 59;
                            segundo = 59;
                            hora--;
                        }
                        
                        else
                        {
                            Menu.jLabelTituloNumeros.setText("");
                            Menu.jLabelNumeros.setText("");
                            Menu.estadoExamen = 2;  
                      //      GestionPreguntas.arregloPreguntas.clear();                                                       
                            break;
                        }
                    }
                }    
                
                //Formatear Texto en dos digitos
                if(segundo<10){            
                    seg="0"+segundo;
                }else{
                    seg=""+segundo;
                }
                
                if(minuto<10){            
                    min="0"+minuto;
                }
                else{
                    min=""+minuto;
                }
                
                if(hora<10){            
                    hour="0"+hora;
                }
                else{
                    hour=""+hora;
                }
                
                Menu.jLabelNumeros.setText(hour+":"+min+":"+seg);
                HiloTiempo.sleep(1000);
            }
                
            else
                {
                    Menu.jLabelTituloNumeros.setText("");
                    Menu.jLabelNumeros.setText("");
                    Menu.estadoExamen = 2;  
                    //GestionPreguntas.arregloPreguntas.clear();                                                       
                    break;
                }
        }
    }
    
//=======================================================================================================    
    /**
     * Sobreescritura del metodo run, ejecuta el hilo si la variable estatica iniciaHilo es true
     */        
    @Override
    public void run()
    {  
        try {

            ejecutarHilo();
        } 

        catch (InterruptedException ex) {
            System.out.println("Error en el metodo run en la Clase HiloTiempo: "+ex.getMessage());
        }      
    }
//=======================================================================================================     
    
}
