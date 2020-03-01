package Vista;

import Modelo.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import javax.swing.filechooser.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * [Menu] Clase de interfaz GUI que administra todas las funciones del servidor de examenes
 * @since 24/11/2017
 * @version 2.0
 * @author Julian Andres Castaño - 1625743
 */

public class Menu extends javax.swing.JFrame {
      
    //Declaracion de variables estaticas
    public static int estadoExamen = 0;
    private int numeroClientes;
    public static int hora = 0;
    public static int minuto = 0;
    public static int segundo = 0;
 
    //Declaracion de variables no estaticas
    private File carpetaNuevos;
    private File carpetaCalificados;
    private File archivo;
    private JFileChooser archivoSeleccionado;
    private FileNameExtensionFilter filtroTxt; 
    private GestionArchivo gestionarArchivos;
    private GestionPreguntas gestionarPreguntas;   
    private String variableEdicion;
    private DefaultListModel modeloLista;
    private ControladorServidor conexionServidor;
    private Validaciones validacionTotal;
        
//=======================================================================================================
    /**
     * Constructor de la clase Menu
     * @since Menu.java
     */
    public Menu() {
        
        initComponents();
                
        //Inicializacion de variables   
        archivo = null;
        carpetaNuevos = new File("evaluations\\new");
        carpetaCalificados = new File("evaluations\\qualification");
        modeloLista = new DefaultListModel();
        archivoSeleccionado = new JFileChooser();
        gestionarArchivos =  new GestionArchivo();
        gestionarPreguntas = new GestionPreguntas();
        filtroTxt =  new FileNameExtensionFilter("Archivos de Texto", "txt");
        conexionServidor = new ControladorServidor();
        numeroClientes = Integer.parseInt(jSpinnerEstudiantes.getValue().toString());
        validacionTotal = new Validaciones();
               
        //Implementacion ajustes
        ajustesGraficos();
        ajustesFuncionales();        
    }
//=======================================================================================================
    /**
     * Metodo que realiza ajustes visuales a la interfaz
     */
    public final void ajustesGraficos()
    {        
        this.setLocationRelativeTo(null); 
        this.setIconImage(Login.iconoVentana);
        this.getRootPane().setBorder(Login.bordeNegro);         
    }
//======================================================================================================= 
    /**
     * Metodo que realiza al ajuste de lista de los nombres de archivos en determinada carpeta
     */      
    public void ajusteLista ()
    {   
        ArrayList <String> arreglo = gestionarArchivos.listarFicherosPorCarpeta(carpetaNuevos);
        int totalNombres=arreglo.size();
        
        for(int i = 0; i<totalNombres; i++)
        {
            modeloLista.addElement(arreglo.get(i));
        }
        jListOtrosExamenes.setModel(modeloLista);
    }
//======================================================================================================= 
    /**
     * Metodo que realiza ajustes para que los componentes funcionen de manera personalizada
     */
    public final void ajustesFuncionales()
    {
        archivoSeleccionado.setFileFilter(filtroTxt);         
        archivoSeleccionado.setMultiSelectionEnabled(false);
    }
   
//======================================================================================================= 
    /**
     * Metodo que realiza ajustes para que los componentes funcionen de manera personalizada
     * @param tabla Variable que almacena la tabla en la que se va aplicar el modelo
     */    
    
    public final void mostrarTabla(JTable tabla)
    {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        Object[] fila = new Object[modelo.getColumnCount()];
        
        for (int i = 0; i < GestionPreguntas.arregloPreguntas.size(); i++) {
            fila[0] = i+1;
            fila[1] = GestionPreguntas.arregloPreguntas.get(i).getQuienRespondio();
            fila[2] = GestionPreguntas.arregloPreguntas.get(i).getCalificacion();
            modelo.addRow(fila);                     
        }
        
    }
    
//======================================================================================================= 
    /**
     * Metodo que realiza ajustes para que los componentes funcionen de manera personalizada
     * @param tabla Variable que almacena la tabla la cual se le borrara el modelo
     */
    
    public final void borrarTabla(JTable tabla)
    {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();        
        int cFilas = modelo.getRowCount();
        for (int i = cFilas-1; i >= 0; i--) {
            modelo.removeRow(i);            
        }
        
    }
   
//=======================================================================================================
    /**
     * Metodo para poner un color cuando el mouse este encima del panel
     * @param panel Panel que se pondra el color 
     */
    public void ponerColor(JPanel panel)
    {
        panel.setBackground(new Color(240, 240, 240));
    }
    
//=======================================================================================================
    /**
     * Metodo para poner un color cuando el mouse se quite del panel
     * @param panel Panel que se pondra el color 
     */
    public void repintarColor(JPanel panel)
    {
        panel.setBackground(new Color(204,204,204));
    }
    
//=======================================================================================================    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanePpal = new javax.swing.JPanel();
        jPaneContain = new javax.swing.JPanel();
        jPaneMenu = new javax.swing.JPanel();
        jPanelTitulo = new javax.swing.JPanel();
        jLabelSubtitulo = new javax.swing.JLabel();
        jLabelimgTitulo = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelSalir = new javax.swing.JLabel();
        jLabelAcerca = new javax.swing.JLabel();
        jPanelIniciar = new javax.swing.JPanel();
        jLabelIniciar = new javax.swing.JLabel();
        jLabelimgIniciar = new javax.swing.JLabel();
        jPanelCargar = new javax.swing.JPanel();
        jLabelCargar = new javax.swing.JLabel();
        jLabelimgCargar = new javax.swing.JLabel();
        jPanelEditar = new javax.swing.JPanel();
        jLabelEditar = new javax.swing.JLabel();
        jLabelimgEditar = new javax.swing.JLabel();
        jPanelTiempo = new javax.swing.JPanel();
        jLabelTiempo = new javax.swing.JLabel();
        jLabelimgTiempo = new javax.swing.JLabel();
        jPanelConfiguracion = new javax.swing.JPanel();
        jLabelConfiguracion = new javax.swing.JLabel();
        jLabelimgConfiguracion = new javax.swing.JLabel();
        jPanelLista = new javax.swing.JPanel();
        jLabelLista = new javax.swing.JLabel();
        jLabelimgLista = new javax.swing.JLabel();
        jLabelNumeros = new javax.swing.JLabel();
        jLabelTituloNumeros = new javax.swing.JLabel();
        jPaneTiempo = new javax.swing.JPanel();
        jPanelTitulo2 = new javax.swing.JPanel();
        jLabelTitulo2 = new javax.swing.JLabel();
        jLabelimgTitulo2 = new javax.swing.JLabel();
        jPanelGuardar1 = new javax.swing.JPanel();
        jLabelGuardar1 = new javax.swing.JLabel();
        jLabelimgGuardar1 = new javax.swing.JLabel();
        jPanelMenu2 = new javax.swing.JPanel();
        jLabelMenu1 = new javax.swing.JLabel();
        jLabelimgMenu1 = new javax.swing.JLabel();
        jSpinnerHoras = new javax.swing.JSpinner();
        jSpinnerMinutos = new javax.swing.JSpinner();
        jSpinnerSegundos = new javax.swing.JSpinner();
        jLabeHoras = new javax.swing.JLabel();
        jLabelMinutos = new javax.swing.JLabel();
        jLabelSegundos = new javax.swing.JLabel();
        jLabelPuntos1 = new javax.swing.JLabel();
        jLabelPuntos2 = new javax.swing.JLabel();
        jPaneEditar = new javax.swing.JPanel();
        jPanelTitulo1 = new javax.swing.JPanel();
        jLabelTitulo1 = new javax.swing.JLabel();
        jLabelimgTitulo1 = new javax.swing.JLabel();
        jPanelActivar = new javax.swing.JPanel();
        jLabelActivar = new javax.swing.JLabel();
        jLabelimgActivar = new javax.swing.JLabel();
        jPanelGuardar = new javax.swing.JPanel();
        jLabelGuardar = new javax.swing.JLabel();
        jLabelimgGuardar = new javax.swing.JLabel();
        jPanelMenu1 = new javax.swing.JPanel();
        jLabelMenu = new javax.swing.JLabel();
        jLabelimgMenu = new javax.swing.JLabel();
        jScrollPaneMostrar = new javax.swing.JScrollPane();
        jTextAreaMostrar = new javax.swing.JTextArea();
        jPaneExamenes = new javax.swing.JPanel();
        jPanelTitulo3 = new javax.swing.JPanel();
        jLabelTitulo3 = new javax.swing.JLabel();
        jLabelimgTitulo3 = new javax.swing.JLabel();
        jPanelGuardar2 = new javax.swing.JPanel();
        jLabelGuardar2 = new javax.swing.JLabel();
        jLabelimgGuardar2 = new javax.swing.JLabel();
        jPanelMenu3 = new javax.swing.JPanel();
        jLabelMenu2 = new javax.swing.JLabel();
        jLabelimgMenu2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListOtrosExamenes = new javax.swing.JList<>();
        jPaneConfiguracion = new javax.swing.JPanel();
        jPanelTitulo6 = new javax.swing.JPanel();
        jLabelTitulo6 = new javax.swing.JLabel();
        jLabelimgTitulo6 = new javax.swing.JLabel();
        jPanelSincronizar = new javax.swing.JPanel();
        jLabelSincronizar = new javax.swing.JLabel();
        jLabelimgSincronizar = new javax.swing.JLabel();
        jPanelMenu6 = new javax.swing.JPanel();
        jLabelMenu5 = new javax.swing.JLabel();
        jLabelimgMenu5 = new javax.swing.JLabel();
        jLabelPuerto = new javax.swing.JLabel();
        jTextFieldPuerto = new javax.swing.JTextField();
        jTextFieldDireccionIP = new javax.swing.JTextField();
        jLabelDireccionIP = new javax.swing.JLabel();
        jTextFieldDireccionInet = new javax.swing.JTextField();
        jLabelDireccionInet = new javax.swing.JLabel();
        jSpinnerEstudiantes = new javax.swing.JSpinner();
        jLabelEstudiantes = new javax.swing.JLabel();
        jPaneInforme = new javax.swing.JPanel();
        jPanelInforme = new javax.swing.JPanel();
        jPanelTitulo5 = new javax.swing.JPanel();
        jLabelTitulo5 = new javax.swing.JLabel();
        jLabelimgTitulo5 = new javax.swing.JLabel();
        jPanelAceptar = new javax.swing.JPanel();
        jLabelAceptar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rSTableInforme = new rojerusan.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanePpal.setBackground(new java.awt.Color(255, 255, 255));
        jPanePpal.setMinimumSize(new java.awt.Dimension(860, 600));
        jPanePpal.setPreferredSize(new java.awt.Dimension(854, 600));

        jPaneContain.setBackground(new java.awt.Color(255, 255, 255));
        jPaneContain.setMinimumSize(new java.awt.Dimension(860, 600));
        jPaneContain.setPreferredSize(new java.awt.Dimension(854, 600));
        jPaneContain.setLayout(new java.awt.CardLayout());

        jPaneMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPaneMenu.setMinimumSize(new java.awt.Dimension(860, 600));
        jPaneMenu.setPreferredSize(new java.awt.Dimension(854, 600));
        jPaneMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTitulo.setBackground(new java.awt.Color(45, 118, 232));
        jPanelTitulo.setPreferredSize(new java.awt.Dimension(854, 170));
        jPanelTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelSubtitulo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabelSubtitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSubtitulo.setText("Sistema de asignacion de examenes");
        jPanelTitulo.add(jLabelSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        jLabelimgTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/usuario.png"))); // NOI18N
        jPanelTitulo.add(jLabelimgTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 90, 100));

        jLabelTitulo.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Welcome Teacher");
        jPanelTitulo.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        jLabelSalir.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabelSalir.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSalir.setText("X");
        jLabelSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelSalirMousePressed(evt);
            }
        });
        jPanelTitulo.add(jLabelSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, -1, -1));

        jLabelAcerca.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabelAcerca.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAcerca.setText("?");
        jLabelAcerca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelAcercaMousePressed(evt);
            }
        });
        jPanelTitulo.add(jLabelAcerca, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, -1, -1));

        jPaneMenu.add(jPanelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 854, 170));

        jPanelIniciar.setBackground(new java.awt.Color(204, 204, 204));
        jPanelIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelIniciarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelIniciarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelIniciarMousePressed(evt);
            }
        });

        jLabelIniciar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelIniciar.setForeground(new java.awt.Color(45, 118, 232));
        jLabelIniciar.setText("Iniciar examen");

        jLabelimgIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/enviar.png"))); // NOI18N

        javax.swing.GroupLayout jPanelIniciarLayout = new javax.swing.GroupLayout(jPanelIniciar);
        jPanelIniciar.setLayout(jPanelIniciarLayout);
        jPanelIniciarLayout.setHorizontalGroup(
            jPanelIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIniciarLayout.createSequentialGroup()
                .addGroup(jPanelIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelIniciarLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabelimgIniciar))
                    .addGroup(jPanelIniciarLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabelIniciar)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanelIniciarLayout.setVerticalGroup(
            jPanelIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIniciarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelimgIniciar)
                .addGap(18, 18, 18)
                .addComponent(jLabelIniciar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPaneMenu.add(jPanelIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 140, 120));

        jPanelCargar.setBackground(new java.awt.Color(204, 204, 204));
        jPanelCargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelCargarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelCargarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelCargarMousePressed(evt);
            }
        });

        jLabelCargar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelCargar.setForeground(new java.awt.Color(45, 118, 232));
        jLabelCargar.setText("Cargar examen");

        jLabelimgCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/cargar.png"))); // NOI18N

        javax.swing.GroupLayout jPanelCargarLayout = new javax.swing.GroupLayout(jPanelCargar);
        jPanelCargar.setLayout(jPanelCargarLayout);
        jPanelCargarLayout.setHorizontalGroup(
            jPanelCargarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCargarLayout.createSequentialGroup()
                .addGroup(jPanelCargarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCargarLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabelCargar))
                    .addGroup(jPanelCargarLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabelimgCargar)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanelCargarLayout.setVerticalGroup(
            jPanelCargarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCargarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelimgCargar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCargar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPaneMenu.add(jPanelCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 140, 120));

        jPanelEditar.setBackground(new java.awt.Color(204, 204, 204));
        jPanelEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelEditarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelEditarMousePressed(evt);
            }
        });

        jLabelEditar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelEditar.setForeground(new java.awt.Color(45, 118, 232));
        jLabelEditar.setText("Editar examen");

        jLabelimgEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/editar.png"))); // NOI18N

        javax.swing.GroupLayout jPanelEditarLayout = new javax.swing.GroupLayout(jPanelEditar);
        jPanelEditar.setLayout(jPanelEditarLayout);
        jPanelEditarLayout.setHorizontalGroup(
            jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEditarLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEditar)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditarLayout.createSequentialGroup()
                        .addComponent(jLabelimgEditar)
                        .addGap(17, 17, 17)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanelEditarLayout.setVerticalGroup(
            jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEditarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelimgEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEditar)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPaneMenu.add(jPanelEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 140, 120));

        jPanelTiempo.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTiempo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelTiempoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelTiempoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelTiempoMousePressed(evt);
            }
        });

        jLabelTiempo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTiempo.setForeground(new java.awt.Color(45, 118, 232));
        jLabelTiempo.setText("Definir tiempo");

        jLabelimgTiempo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/tiempo.png"))); // NOI18N

        javax.swing.GroupLayout jPanelTiempoLayout = new javax.swing.GroupLayout(jPanelTiempo);
        jPanelTiempo.setLayout(jPanelTiempoLayout);
        jPanelTiempoLayout.setHorizontalGroup(
            jPanelTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTiempoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTiempo)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTiempoLayout.createSequentialGroup()
                        .addComponent(jLabelimgTiempo)
                        .addGap(18, 18, 18)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanelTiempoLayout.setVerticalGroup(
            jPanelTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTiempoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelimgTiempo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTiempo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPaneMenu.add(jPanelTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 140, 120));

        jPanelConfiguracion.setBackground(new java.awt.Color(204, 204, 204));
        jPanelConfiguracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelConfiguracionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelConfiguracionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelConfiguracionMousePressed(evt);
            }
        });

        jLabelConfiguracion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelConfiguracion.setForeground(new java.awt.Color(45, 118, 232));
        jLabelConfiguracion.setText("Configuracion");

        jLabelimgConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/configuracion.png"))); // NOI18N

        javax.swing.GroupLayout jPanelConfiguracionLayout = new javax.swing.GroupLayout(jPanelConfiguracion);
        jPanelConfiguracion.setLayout(jPanelConfiguracionLayout);
        jPanelConfiguracionLayout.setHorizontalGroup(
            jPanelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfiguracionLayout.createSequentialGroup()
                .addGroup(jPanelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConfiguracionLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabelimgConfiguracion))
                    .addGroup(jPanelConfiguracionLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabelConfiguracion)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanelConfiguracionLayout.setVerticalGroup(
            jPanelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfiguracionLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelimgConfiguracion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelConfiguracion)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPaneMenu.add(jPanelConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 140, 120));

        jPanelLista.setBackground(new java.awt.Color(204, 204, 204));
        jPanelLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelListaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelListaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelListaMousePressed(evt);
            }
        });

        jLabelLista.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelLista.setForeground(new java.awt.Color(45, 118, 232));
        jLabelLista.setText("Lista examenes");

        jLabelimgLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu/lista.png"))); // NOI18N

        javax.swing.GroupLayout jPanelListaLayout = new javax.swing.GroupLayout(jPanelLista);
        jPanelLista.setLayout(jPanelListaLayout);
        jPanelListaLayout.setHorizontalGroup(
            jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabelimgLista)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListaLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabelLista)
                .addGap(18, 18, 18))
        );
        jPanelListaLayout.setVerticalGroup(
            jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListaLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabelimgLista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLista)
                .addGap(16, 16, 16))
        );

        jPaneMenu.add(jPanelLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 140, 120));

        jLabelNumeros.setFont(new java.awt.Font("DS-Digital", 1, 24)); // NOI18N
        jLabelNumeros.setForeground(new java.awt.Color(45, 118, 232));
        jLabelNumeros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPaneMenu.add(jLabelNumeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 540, 130, 40));

        jLabelTituloNumeros.setFont(new java.awt.Font("DS-Digital", 1, 18)); // NOI18N
        jLabelTituloNumeros.setForeground(new java.awt.Color(45, 118, 232));
        jLabelTituloNumeros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPaneMenu.add(jLabelTituloNumeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 540, 180, 40));

        jPaneContain.add(jPaneMenu, "card2");

        jPaneTiempo.setBackground(new java.awt.Color(255, 255, 255));
        jPaneTiempo.setMinimumSize(new java.awt.Dimension(860, 600));
        jPaneTiempo.setPreferredSize(new java.awt.Dimension(854, 600));
        jPaneTiempo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTitulo2.setBackground(new java.awt.Color(45, 118, 232));
        jPanelTitulo2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo2.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabelTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo2.setText("Tiempo de examen");
        jPanelTitulo2.add(jLabelTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        jLabelimgTitulo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Submenus/tiempoM.png"))); // NOI18N
        jPanelTitulo2.add(jLabelimgTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 100, 90));

        jPaneTiempo.add(jPanelTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 110));

        jPanelGuardar1.setBackground(java.awt.SystemColor.controlHighlight);
        jPanelGuardar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelGuardar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelGuardar1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelGuardar1MousePressed(evt);
            }
        });

        jLabelGuardar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelGuardar1.setForeground(new java.awt.Color(45, 118, 232));
        jLabelGuardar1.setText("Guardar");

        jLabelimgGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Submenus/guardar.png"))); // NOI18N

        javax.swing.GroupLayout jPanelGuardar1Layout = new javax.swing.GroupLayout(jPanelGuardar1);
        jPanelGuardar1.setLayout(jPanelGuardar1Layout);
        jPanelGuardar1Layout.setHorizontalGroup(
            jPanelGuardar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGuardar1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelGuardar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelimgGuardar1)
                    .addComponent(jLabelGuardar1))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanelGuardar1Layout.setVerticalGroup(
            jPanelGuardar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGuardar1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabelimgGuardar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPaneTiempo.add(jPanelGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 100, 100));

        jPanelMenu2.setBackground(java.awt.SystemColor.controlHighlight);
        jPanelMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelMenu2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelMenu2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelMenu2MousePressed(evt);
            }
        });

        jLabelMenu1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelMenu1.setForeground(new java.awt.Color(45, 118, 232));
        jLabelMenu1.setText("Menu");

        jLabelimgMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Submenus/menu.png"))); // NOI18N

        javax.swing.GroupLayout jPanelMenu2Layout = new javax.swing.GroupLayout(jPanelMenu2);
        jPanelMenu2.setLayout(jPanelMenu2Layout);
        jPanelMenu2Layout.setHorizontalGroup(
            jPanelMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenu2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenu2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelMenu1))
                    .addComponent(jLabelimgMenu1))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanelMenu2Layout.setVerticalGroup(
            jPanelMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenu2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabelimgMenu1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPaneTiempo.add(jPanelMenu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 100, 100));

        jSpinnerHoras.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));
        jPaneTiempo.add(jSpinnerHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 60, 30));
        JFormattedTextField tf2 = ((JSpinner.DefaultEditor) jSpinnerHoras.getEditor()).getTextField();
        tf2.setEditable(false);

        jSpinnerMinutos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));
        jPaneTiempo.add(jSpinnerMinutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 70, 30));
        JFormattedTextField tf1 = ((JSpinner.DefaultEditor) jSpinnerMinutos.getEditor()).getTextField();
        tf1.setEditable(false);

        jSpinnerSegundos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));
        jPaneTiempo.add(jSpinnerSegundos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 90, 30));
        JFormattedTextField tf = ((JSpinner.DefaultEditor) jSpinnerSegundos.getEditor()).getTextField();
        tf.setEditable(false);

        jLabeHoras.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabeHoras.setForeground(new java.awt.Color(45, 118, 232));
        jLabeHoras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeHoras.setText("Horas");
        jPaneTiempo.add(jLabeHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 70, -1));

        jLabelMinutos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMinutos.setForeground(new java.awt.Color(45, 118, 232));
        jLabelMinutos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinutos.setText("Minutos");
        jPaneTiempo.add(jLabelMinutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 90, -1));

        jLabelSegundos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelSegundos.setForeground(new java.awt.Color(45, 118, 232));
        jLabelSegundos.setText("Segundos");
        jPaneTiempo.add(jLabelSegundos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, -1, -1));

        jLabelPuntos1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPuntos1.setForeground(new java.awt.Color(45, 118, 232));
        jLabelPuntos1.setText(":");
        jPaneTiempo.add(jLabelPuntos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 10, 30));

        jLabelPuntos2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPuntos2.setForeground(new java.awt.Color(45, 118, 232));
        jLabelPuntos2.setText(":");
        jPaneTiempo.add(jLabelPuntos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 10, 30));

        jPaneContain.add(jPaneTiempo, "card5");

        jPaneEditar.setBackground(new java.awt.Color(255, 255, 255));
        jPaneEditar.setMinimumSize(new java.awt.Dimension(860, 600));
        jPaneEditar.setPreferredSize(new java.awt.Dimension(854, 600));
        jPaneEditar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTitulo1.setBackground(new java.awt.Color(45, 118, 232));
        jPanelTitulo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo1.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabelTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo1.setText("Edicion examen");
        jPanelTitulo1.add(jLabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        jLabelimgTitulo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Submenus/editarM.png"))); // NOI18N
        jPanelTitulo1.add(jLabelimgTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 80, 90));

        jPaneEditar.add(jPanelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 110));

        jPanelActivar.setBackground(java.awt.SystemColor.controlHighlight);
        jPanelActivar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelActivarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelActivarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelActivarMousePressed(evt);
            }
        });
        jPanelActivar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelActivar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelActivar.setForeground(new java.awt.Color(45, 118, 232));
        jLabelActivar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelActivar.add(jLabelActivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 100, 60));

        jLabelimgActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Submenus/edicion.png"))); // NOI18N
        jPanelActivar.add(jLabelimgActivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        jPaneEditar.add(jPanelActivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 470, 100, 100));

        jPanelGuardar.setBackground(java.awt.SystemColor.controlHighlight);
        jPanelGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelGuardarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelGuardarMousePressed(evt);
            }
        });

        jLabelGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelGuardar.setForeground(new java.awt.Color(45, 118, 232));
        jLabelGuardar.setText("Guardar");

        jLabelimgGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Submenus/guardar.png"))); // NOI18N

        javax.swing.GroupLayout jPanelGuardarLayout = new javax.swing.GroupLayout(jPanelGuardar);
        jPanelGuardar.setLayout(jPanelGuardarLayout);
        jPanelGuardarLayout.setHorizontalGroup(
            jPanelGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGuardarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelGuardar)
                    .addComponent(jLabelimgGuardar))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanelGuardarLayout.setVerticalGroup(
            jPanelGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGuardarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabelimgGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPaneEditar.add(jPanelGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 100, 100));

        jPanelMenu1.setBackground(java.awt.SystemColor.controlHighlight);
        jPanelMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelMenu1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelMenu1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelMenu1MousePressed(evt);
            }
        });

        jLabelMenu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelMenu.setForeground(new java.awt.Color(45, 118, 232));
        jLabelMenu.setText("Menu");

        jLabelimgMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Submenus/menu.png"))); // NOI18N

        javax.swing.GroupLayout jPanelMenu1Layout = new javax.swing.GroupLayout(jPanelMenu1);
        jPanelMenu1.setLayout(jPanelMenu1Layout);
        jPanelMenu1Layout.setHorizontalGroup(
            jPanelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenu1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenu1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelMenu))
                    .addComponent(jLabelimgMenu))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanelMenu1Layout.setVerticalGroup(
            jPanelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenu1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabelimgMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPaneEditar.add(jPanelMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 100, 100));

        jTextAreaMostrar.setBackground(new java.awt.Color(45, 118, 232));
        jTextAreaMostrar.setColumns(20);
        jTextAreaMostrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextAreaMostrar.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaMostrar.setRows(5);
        jScrollPaneMostrar.setViewportView(jTextAreaMostrar);

        jPaneEditar.add(jScrollPaneMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 690, 310));

        jPaneContain.add(jPaneEditar, "card5");

        jPaneExamenes.setBackground(new java.awt.Color(255, 255, 255));
        jPaneExamenes.setMinimumSize(new java.awt.Dimension(860, 600));
        jPaneExamenes.setPreferredSize(new java.awt.Dimension(854, 600));
        jPaneExamenes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTitulo3.setBackground(new java.awt.Color(45, 118, 232));
        jPanelTitulo3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo3.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabelTitulo3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo3.setText("Lista de Examenes");
        jPanelTitulo3.add(jLabelTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        jLabelimgTitulo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Submenus/listaM.png"))); // NOI18N
        jPanelTitulo3.add(jLabelimgTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 100, 90));

        jPaneExamenes.add(jPanelTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 110));

        jPanelGuardar2.setBackground(java.awt.SystemColor.controlHighlight);
        jPanelGuardar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelGuardar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelGuardar2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelGuardar2MousePressed(evt);
            }
        });

        jLabelGuardar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelGuardar2.setForeground(new java.awt.Color(45, 118, 232));
        jLabelGuardar2.setText("Cargar");

        jLabelimgGuardar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Submenus/cargar.png"))); // NOI18N

        javax.swing.GroupLayout jPanelGuardar2Layout = new javax.swing.GroupLayout(jPanelGuardar2);
        jPanelGuardar2.setLayout(jPanelGuardar2Layout);
        jPanelGuardar2Layout.setHorizontalGroup(
            jPanelGuardar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGuardar2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelGuardar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelimgGuardar2)
                    .addComponent(jLabelGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanelGuardar2Layout.setVerticalGroup(
            jPanelGuardar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGuardar2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelimgGuardar2)
                .addGap(5, 5, 5)
                .addComponent(jLabelGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPaneExamenes.add(jPanelGuardar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 470, 100, 100));

        jPanelMenu3.setBackground(java.awt.SystemColor.controlHighlight);
        jPanelMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelMenu3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelMenu3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelMenu3MousePressed(evt);
            }
        });

        jLabelMenu2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelMenu2.setForeground(new java.awt.Color(45, 118, 232));
        jLabelMenu2.setText("Menu");

        jLabelimgMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Submenus/menu.png"))); // NOI18N

        javax.swing.GroupLayout jPanelMenu3Layout = new javax.swing.GroupLayout(jPanelMenu3);
        jPanelMenu3.setLayout(jPanelMenu3Layout);
        jPanelMenu3Layout.setHorizontalGroup(
            jPanelMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenu3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenu3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelMenu2))
                    .addComponent(jLabelimgMenu2))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanelMenu3Layout.setVerticalGroup(
            jPanelMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenu3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabelimgMenu2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPaneExamenes.add(jPanelMenu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 100, 100));

        jListOtrosExamenes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jListOtrosExamenes.setForeground(new java.awt.Color(45, 118, 232));
        jListOtrosExamenes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListOtrosExamenes);

        jPaneExamenes.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 190, 310));

        jPaneContain.add(jPaneExamenes, "card5");

        jPaneConfiguracion.setBackground(new java.awt.Color(255, 255, 255));
        jPaneConfiguracion.setMinimumSize(new java.awt.Dimension(860, 600));
        jPaneConfiguracion.setPreferredSize(new java.awt.Dimension(854, 600));
        jPaneConfiguracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTitulo6.setBackground(new java.awt.Color(45, 118, 232));
        jPanelTitulo6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo6.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabelTitulo6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo6.setText("Configuracion");
        jPanelTitulo6.add(jLabelTitulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        jLabelimgTitulo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Submenus/configuracionM.png"))); // NOI18N
        jPanelTitulo6.add(jLabelimgTitulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 100, 90));

        jPaneConfiguracion.add(jPanelTitulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 110));

        jPanelSincronizar.setBackground(java.awt.SystemColor.controlHighlight);
        jPanelSincronizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelSincronizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelSincronizarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelSincronizarMousePressed(evt);
            }
        });

        jLabelSincronizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelSincronizar.setForeground(new java.awt.Color(45, 118, 232));
        jLabelSincronizar.setText("Sincronizar");

        jLabelimgSincronizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Submenus/sincronizar.png"))); // NOI18N

        javax.swing.GroupLayout jPanelSincronizarLayout = new javax.swing.GroupLayout(jPanelSincronizar);
        jPanelSincronizar.setLayout(jPanelSincronizarLayout);
        jPanelSincronizarLayout.setHorizontalGroup(
            jPanelSincronizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSincronizarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelSincronizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSincronizar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelimgSincronizar))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanelSincronizarLayout.setVerticalGroup(
            jPanelSincronizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSincronizarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabelimgSincronizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelSincronizar, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPaneConfiguracion.add(jPanelSincronizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 470, 100, 100));

        jPanelMenu6.setBackground(java.awt.SystemColor.controlHighlight);
        jPanelMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelMenu6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelMenu6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelMenu6MousePressed(evt);
            }
        });

        jLabelMenu5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelMenu5.setForeground(new java.awt.Color(45, 118, 232));
        jLabelMenu5.setText("Menu");

        jLabelimgMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Submenus/menu.png"))); // NOI18N

        javax.swing.GroupLayout jPanelMenu6Layout = new javax.swing.GroupLayout(jPanelMenu6);
        jPanelMenu6.setLayout(jPanelMenu6Layout);
        jPanelMenu6Layout.setHorizontalGroup(
            jPanelMenu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenu6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelMenu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenu6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelMenu5))
                    .addComponent(jLabelimgMenu5))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanelMenu6Layout.setVerticalGroup(
            jPanelMenu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenu6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabelimgMenu5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPaneConfiguracion.add(jPanelMenu6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 100, 100));

        jLabelPuerto.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabelPuerto.setForeground(new java.awt.Color(45, 118, 232));
        jLabelPuerto.setText("Puerto");
        jPaneConfiguracion.add(jLabelPuerto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jTextFieldPuerto.setBackground(new java.awt.Color(240, 240, 240));
        jTextFieldPuerto.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jTextFieldPuerto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPuerto.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jPaneConfiguracion.add(jTextFieldPuerto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 150, -1));

        jTextFieldDireccionIP.setEditable(false);
        jTextFieldDireccionIP.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jTextFieldDireccionIP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDireccionIP.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jPaneConfiguracion.add(jTextFieldDireccionIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 150, -1));

        jLabelDireccionIP.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabelDireccionIP.setForeground(new java.awt.Color(45, 118, 232));
        jLabelDireccionIP.setText("Direccion IP");
        jPaneConfiguracion.add(jLabelDireccionIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, -1));

        jTextFieldDireccionInet.setBackground(new java.awt.Color(240, 240, 240));
        jTextFieldDireccionInet.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jTextFieldDireccionInet.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDireccionInet.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jPaneConfiguracion.add(jTextFieldDireccionInet, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 150, -1));

        jLabelDireccionInet.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabelDireccionInet.setForeground(new java.awt.Color(45, 118, 232));
        jLabelDireccionInet.setText("Direccion Inet");
        jPaneConfiguracion.add(jLabelDireccionInet, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, -1, -1));

        jSpinnerEstudiantes.setModel(new javax.swing.SpinnerNumberModel(2, 2, 4, 1));
        jPaneConfiguracion.add(jSpinnerEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 90, 30));
        JFormattedTextField tf3 = ((JSpinner.DefaultEditor) jSpinnerEstudiantes.getEditor()).getTextField();
        tf3.setEditable(false);

        jLabelEstudiantes.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabelEstudiantes.setForeground(new java.awt.Color(45, 118, 232));
        jLabelEstudiantes.setText("#Estudiantes");
        jPaneConfiguracion.add(jLabelEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, -1, -1));

        jPaneContain.add(jPaneConfiguracion, "card5");

        jPaneInforme.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPaneInformeComponentShown(evt);
            }
        });

        jPanelInforme.setBackground(new java.awt.Color(255, 255, 255));
        jPanelInforme.setMinimumSize(new java.awt.Dimension(860, 600));
        jPanelInforme.setPreferredSize(new java.awt.Dimension(854, 600));
        jPanelInforme.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTitulo5.setBackground(new java.awt.Color(45, 118, 232));
        jPanelTitulo5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo5.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabelTitulo5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo5.setText("Informe de Examen");
        jPanelTitulo5.add(jLabelTitulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        jLabelimgTitulo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Submenus/listaM.png"))); // NOI18N
        jPanelTitulo5.add(jLabelimgTitulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 100, 90));

        jPanelInforme.add(jPanelTitulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 110));

        jPanelAceptar.setBackground(java.awt.SystemColor.controlHighlight);
        jPanelAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelAceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelAceptarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelAceptarMousePressed(evt);
            }
        });
        jPanelAceptar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelAceptar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelAceptar.setForeground(new java.awt.Color(45, 118, 232));
        jLabelAceptar.setText("Aceptar");
        jPanelAceptar.add(jLabelAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanelInforme.add(jPanelAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 530, 130, 30));

        rSTableInforme.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "# Pregunta", "Quien respondio", "Calificacion"
            }
        ));
        rSTableInforme.setColorBackgoundHead(new java.awt.Color(45, 118, 232));
        rSTableInforme.setColorFilasForeground1(new java.awt.Color(45, 118, 232));
        rSTableInforme.setColorFilasForeground2(new java.awt.Color(45, 118, 232));
        rSTableInforme.setColorSelBackgound(new java.awt.Color(45, 118, 232));
        jScrollPane2.setViewportView(rSTableInforme);

        jPanelInforme.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 710, 350));

        javax.swing.GroupLayout jPaneInformeLayout = new javax.swing.GroupLayout(jPaneInforme);
        jPaneInforme.setLayout(jPaneInformeLayout);
        jPaneInformeLayout.setHorizontalGroup(
            jPaneInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneInformeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelInforme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPaneInformeLayout.setVerticalGroup(
            jPaneInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneInformeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelInforme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPaneContain.add(jPaneInforme, "card8");

        javax.swing.GroupLayout jPanePpalLayout = new javax.swing.GroupLayout(jPanePpal);
        jPanePpal.setLayout(jPanePpalLayout);
        jPanePpalLayout.setHorizontalGroup(
            jPanePpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPaneContain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanePpalLayout.setVerticalGroup(
            jPanePpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPaneContain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanePpal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanePpal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalirMousePressed
        new jConfirmacion(this, true, "<html><center>¿Esta seguro que desea salir del servidor? </center></html>").setVisible(true);
        if(jConfirmacion.opcion ==1)
        {
            if(estadoExamen==1)
            {
                new jAdvertencia(this, true, "<html><center> Hay un examen activo en estos momentos usted no puede salir, por favor intente mas tarde </center></html>").setVisible(true);
            }
            
            else
            {
                this.setVisible(false);
                new Login().setVisible(true);
                conexionServidor.detenerServidor();
            }
        }      
    }//GEN-LAST:event_jLabelSalirMousePressed

    private void jPanelCargarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCargarMouseEntered
        ponerColor(jPanelCargar);
    }//GEN-LAST:event_jPanelCargarMouseEntered

    private void jPanelCargarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCargarMouseExited
        repintarColor(jPanelCargar);
    }//GEN-LAST:event_jPanelCargarMouseExited
     
    private void jPanelEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelEditarMouseEntered
        ponerColor(jPanelEditar);
    }//GEN-LAST:event_jPanelEditarMouseEntered

    private void jPanelEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelEditarMouseExited
        repintarColor(jPanelEditar);
    }//GEN-LAST:event_jPanelEditarMouseExited

    private void jPanelTiempoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTiempoMouseEntered
        ponerColor(jPanelTiempo);
    }//GEN-LAST:event_jPanelTiempoMouseEntered

    private void jPanelTiempoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTiempoMouseExited
        repintarColor(jPanelTiempo);
    }//GEN-LAST:event_jPanelTiempoMouseExited

    private void jPanelConfiguracionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelConfiguracionMouseEntered
        ponerColor(jPanelConfiguracion);
    }//GEN-LAST:event_jPanelConfiguracionMouseEntered

    private void jPanelConfiguracionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelConfiguracionMouseExited
        repintarColor(jPanelConfiguracion);  
    }//GEN-LAST:event_jPanelConfiguracionMouseExited

    private void jPanelListaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelListaMouseEntered
        ponerColor(jPanelLista);
    }//GEN-LAST:event_jPanelListaMouseEntered

    private void jPanelListaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelListaMouseExited
        repintarColor(jPanelLista);
    }//GEN-LAST:event_jPanelListaMouseExited

    private void jPanelIniciarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelIniciarMouseEntered
        ponerColor(jPanelIniciar);
    }//GEN-LAST:event_jPanelIniciarMouseEntered

    private void jPanelIniciarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelIniciarMouseExited
        repintarColor(jPanelIniciar);
    }//GEN-LAST:event_jPanelIniciarMouseExited

    private void jPanelCargarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCargarMousePressed
       
        if (estadoExamen!=1)
        {     
            if (archivoSeleccionado.showDialog(this, "Abrir")== JFileChooser.APPROVE_OPTION)
            {
                archivo = archivoSeleccionado.getSelectedFile();            
                if (archivo.canRead())
                {
                    if (archivo.getName().endsWith("txt"))
                    {
                        String contenido = gestionarArchivos.abrirArchivo(archivo);
                        jTextAreaMostrar.setText(contenido);
                        jTextAreaMostrar.setEditable(false);
                        new jInformacion(this, true, "<html><center>Se ha cargado correctamente el archivo "+ archivo.getName()+"</center></html>").setVisible(true);

                    }

                    else
                    {
                        new jAdvertencia(this, true, "<html><center>Por favor seleccione un archivo en formato txt </center></html>").setVisible(true);
                    }                
                }
            }
        }
        
        else
        {
            new jAdvertencia(this, true, "<html><center>El examen ya esta activo no cargar un examen</center></html>").setVisible(true);
        }
    }//GEN-LAST:event_jPanelCargarMousePressed

    private void jPanelEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelEditarMousePressed
        if (estadoExamen!=1)
        {
            if(archivo==null)
            {
                new jAdvertencia(this, true, "<html><center>No se ha cargado ningun examen seleccione la opcion Cargar Examen para ello </center></html>").setVisible(true);
            }
        
            else
            {
                jPaneMenu.setVisible(false);
                jPaneEditar.setVisible(true);
                jTextAreaMostrar.setEditable(false);
                jLabelActivar.setText("Activar");
            }
        }
        
        else
        {
            new jAdvertencia(this, true, "<html><center>El examen ya esta activo no se puede editar el archivo</center></html>").setVisible(true);
        }
        
        
    }//GEN-LAST:event_jPanelEditarMousePressed

    private void jPanelIniciarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelIniciarMousePressed
        if (estadoExamen!=1)
        {
            if(hora== 0 && minuto==0 && segundo==0)
            {
                new jAdvertencia(this, true, "<html></center>Aun no se ha seleccionado el tiempo por favor verifiquelo en el boton 'Definir Tiempo' </center></html>").setVisible(true);
            }

            else if(archivo==null)
            {
                new jAdvertencia(this, true, "<html><center>Aun no se ha cargado un archivo por favor verifiquelo en el boton 'Cargar Examen' </center></html>").setVisible(true);
            }

            else if(ControladorServidor.numeroClientes!=numeroClientes)
            {
                new jAdvertencia(this, true, "<html><center>Aun no se ha encuentra conectados los clientes minimos ("+numeroClientes+")</center></html>").setVisible(true);
            }

            else
            {           
                try{
                   GestionPreguntas.arregloPreguntas.clear();
                   gestionarPreguntas.crearPreguntas(archivo); 
                   jLabelTituloNumeros.setText("TIEMPO RESTANTE:");                
                   conexionServidor.ejecucionTiempo(hora, minuto, segundo);                    
                   estadoExamen = 1; 
                }
                catch(InterruptedException | ExecutionException e)
                {
                    new jAdvertencia(this, true, "<html><center>No se puede enviar el examen a los estudiantes </center></html>").setVisible(true);
                }

            }
        }
        
        else
        {
            new jAdvertencia(this, true, "<html><center>El examen ya esta activo no puede iniciar otro examen hasta que finalice</center></html>").setVisible(true);
        }
    }//GEN-LAST:event_jPanelIniciarMousePressed

    private void jPanelConfiguracionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelConfiguracionMousePressed
        if (estadoExamen!=1)
        {
            jPaneMenu.setVisible(false);
            jPaneConfiguracion.setVisible(true);
            jTextFieldPuerto.setText(String.valueOf(ControladorHilos.puerto));
            jTextFieldDireccionInet.setText(ControladorHilos.inet);
            jTextFieldDireccionIP.setText(ControladorHilos.miIP);
        }
        
        else
        {
            new jAdvertencia(this, true, "<html><center>El examen ya esta activo no puede cambiar la configuracion</center></html>").setVisible(true);
        }
    }//GEN-LAST:event_jPanelConfiguracionMousePressed

    private void jPanelTiempoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTiempoMousePressed
        if (estadoExamen!=1)
        {
            jPaneMenu.setVisible(false);
            jPaneTiempo.setVisible(true);
        }
        
        else
        {
            new jAdvertencia(this, true, "<html><center>El examen ya esta activo no puede cambiar el tiempo</center></html>").setVisible(true);
        }
    }//GEN-LAST:event_jPanelTiempoMousePressed

    private void jPanelListaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelListaMousePressed
        
        if (estadoExamen!=1)
        {
            jPaneMenu.setVisible(false);
            jPaneExamenes.setVisible(true);
            gestionarArchivos.listarFicherosPorCarpeta(carpetaCalificados);
            jListOtrosExamenes.removeAll();
            ajusteLista();     
        }
        
        else
        {
            new jAdvertencia(this, true, "<html><center>El examen ya esta activo no pueden ver otros examenes</center></html>").setVisible(true);
        }
        
          
    }//GEN-LAST:event_jPanelListaMousePressed

    private void jPanelGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelGuardarMouseEntered
        ponerColor(jPanelGuardar);
    }//GEN-LAST:event_jPanelGuardarMouseEntered

    private void jPanelGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelGuardarMouseExited
        repintarColor(jPanelGuardar);
    }//GEN-LAST:event_jPanelGuardarMouseExited

    private void jPanelGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelGuardarMousePressed
        if (archivoSeleccionado.showDialog(null, "Guardar")== JFileChooser.APPROVE_OPTION)
        {
            archivo = archivoSeleccionado.getSelectedFile();
            if (archivo.getName().endsWith("txt"))
            {
                String contenido = jTextAreaMostrar.getText();
                String respuesta = gestionarArchivos.guardarArchivo(archivo, contenido);

                if(respuesta!=null)
                {
                    new jInformacion(this, true, "<html><center>Se ha guardado correctamente el archivo "+ archivo.getName()+"</center></html>").setVisible(true);
                    jTextAreaMostrar.setEditable(false);
                }

                else
                {
                    new jAdvertencia(this, true, "<html><center>Error al guardar el archivo </center></html>").setVisible(true);
                }
            }

            else
            {
                new jAdvertencia(this, true, "<html><center>El formato de archivo debe ser txt </center></html>").setVisible(true);
            }
        }
    }//GEN-LAST:event_jPanelGuardarMousePressed

    private void jPanelMenu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMenu1MouseEntered
        ponerColor(jPanelMenu1);
    }//GEN-LAST:event_jPanelMenu1MouseEntered

    private void jPanelMenu1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMenu1MouseExited
        repintarColor(jPanelMenu1);
    }//GEN-LAST:event_jPanelMenu1MouseExited

    private void jPanelMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMenu1MousePressed
        jPaneEditar.setVisible(false);
        jPaneMenu.setVisible(true);
    }//GEN-LAST:event_jPanelMenu1MousePressed

    private void jPanelGuardar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelGuardar1MouseEntered
        ponerColor(jPanelGuardar1);
    }//GEN-LAST:event_jPanelGuardar1MouseEntered

    private void jPanelGuardar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelGuardar1MouseExited
        repintarColor(jPanelGuardar1);
    }//GEN-LAST:event_jPanelGuardar1MouseExited

    private void jPanelGuardar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelGuardar1MousePressed
        
        int horasSpinner = Integer.parseInt(jSpinnerHoras.getValue().toString());
        int minutosSpinner = Integer.parseInt(jSpinnerMinutos.getValue().toString());
        int segundosSpinner = Integer.parseInt(jSpinnerSegundos.getValue().toString());

        new jConfirmacion(this, true, "<html><center>¿Esta seguro que desea asignar a este examen 0"+horasSpinner+":0"+minutosSpinner+":0"+segundosSpinner+" horas? </center></html>").setVisible(true);
        if(jConfirmacion.opcion ==1)
        {
            hora = horasSpinner;
            minuto = minutosSpinner;
            segundo = segundosSpinner;           
            new jInformacion(this, true, "<html><center> El tiempo de examen se guardo correctamente </center></html>").setVisible(true);
        }
    }//GEN-LAST:event_jPanelGuardar1MousePressed

    private void jPanelMenu2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMenu2MouseEntered
        ponerColor(jPanelMenu2);
    }//GEN-LAST:event_jPanelMenu2MouseEntered

    private void jPanelMenu2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMenu2MouseExited
        repintarColor(jPanelMenu2);
    }//GEN-LAST:event_jPanelMenu2MouseExited

    private void jPanelMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMenu2MousePressed
        jPaneTiempo.setVisible(false);
        jPaneMenu.setVisible(true);
    }//GEN-LAST:event_jPanelMenu2MousePressed

    private void jPanelGuardar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelGuardar2MouseEntered
        ponerColor(jPanelGuardar2);
    }//GEN-LAST:event_jPanelGuardar2MouseEntered

    private void jPanelGuardar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelGuardar2MouseExited
        repintarColor(jPanelGuardar2);
    }//GEN-LAST:event_jPanelGuardar2MouseExited

    private void jPanelGuardar2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelGuardar2MousePressed
        String archivoActual= jListOtrosExamenes.getSelectedValue();        
        if (archivoActual !=null)
        {            
            File nuevoarchivo = new File("Examenes\\Calificados\\"+archivoActual);
            archivo = nuevoarchivo;
            String contenido = gestionarArchivos.abrirArchivo(archivo);
            jTextAreaMostrar.setText(contenido);
            jTextAreaMostrar.setEditable(false);
            new jInformacion(this, true, "<html><center>Se ha cargado correctamente el archivo "+ archivo.getName()+"</center></html>").setVisible(true);
        }
        
        else
        {
            new jAdvertencia(this, true, "<html><center>Aun no ha seleccionado ningun archivo de la lista </center></html>").setVisible(true);
        }
    }//GEN-LAST:event_jPanelGuardar2MousePressed

    private void jPanelMenu3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMenu3MouseEntered
        ponerColor(jPanelMenu3);
    }//GEN-LAST:event_jPanelMenu3MouseEntered

    private void jPanelMenu3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMenu3MouseExited
        repintarColor(jPanelMenu3);
    }//GEN-LAST:event_jPanelMenu3MouseExited

    private void jPanelMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMenu3MousePressed
        jPaneExamenes.setVisible(false);
        jPaneMenu.setVisible(true);
        modeloLista.clear();        
    }//GEN-LAST:event_jPanelMenu3MousePressed

    private void jLabelAcercaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAcercaMousePressed
         new jInformacion(this, true,"© 2017 Julian Castaño, reservados todos los derechos.").setVisible(true);
    }//GEN-LAST:event_jLabelAcercaMousePressed

    private void jPanelSincronizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelSincronizarMouseEntered
        ponerColor(jPanelSincronizar);   
    }//GEN-LAST:event_jPanelSincronizarMouseEntered

    private void jPanelSincronizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelSincronizarMouseExited
        repintarColor(jPanelSincronizar);   
    }//GEN-LAST:event_jPanelSincronizarMouseExited

    private void jPanelSincronizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelSincronizarMousePressed
         
        String direccionInet = jTextFieldDireccionInet.getText();
        String puerto = jTextFieldPuerto.getText();

        String arregloValidar[] = {direccionInet, puerto};

        if (!(validacionTotal.validarExcepciones(arregloValidar, 2, 0, 0).equals("")))
        {
            new jAdvertencia(this, true,validacionTotal.validarExcepciones(arregloValidar, 2, 0, 0)).setVisible(true);                 
        }

        else
        {               
            new jConfirmacion(this, true, "<html><center>¿Esta seguro que desea sincronizar esta configuracion? </center></html>").setVisible(true);
            if(jConfirmacion.opcion ==1)
            {
                ControladorHilos.inet = jTextFieldDireccionInet.getText();
                ControladorHilos.puerto = Integer.valueOf(jTextFieldPuerto.getText());       
                numeroClientes = Integer.parseInt(jSpinnerEstudiantes.getValue().toString());
                new jInformacion(this, true, "<html><center>Se ha sincronizado correctamente la configuracion de conexion</center></html>").setVisible(true);
            }
        }

    }//GEN-LAST:event_jPanelSincronizarMousePressed

    private void jPanelMenu6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMenu6MouseEntered
        ponerColor(jPanelMenu6);   
    }//GEN-LAST:event_jPanelMenu6MouseEntered

    private void jPanelMenu6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMenu6MouseExited
        repintarColor(jPanelMenu6);
    }//GEN-LAST:event_jPanelMenu6MouseExited

    private void jPanelMenu6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMenu6MousePressed
       jPaneConfiguracion.setVisible(false);
       jPaneMenu.setVisible(true);
    }//GEN-LAST:event_jPanelMenu6MousePressed

    private void jPanelActivarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelActivarMousePressed
        variableEdicion = jLabelActivar.getText();
        if(variableEdicion.equals("Activar"))
        {
            jTextAreaMostrar.setEditable(true);
            variableEdicion = "Desactivar";
            jLabelActivar.setText(variableEdicion);
        }

        else
        {
            variableEdicion = "Activar";
            jLabelActivar.setText(variableEdicion);
            jTextAreaMostrar.setEditable(false);
        }
    }//GEN-LAST:event_jPanelActivarMousePressed

    private void jPanelActivarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelActivarMouseExited
        repintarColor(jPanelActivar);
    }//GEN-LAST:event_jPanelActivarMouseExited

    private void jPanelActivarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelActivarMouseEntered
        ponerColor(jPanelActivar);
    }//GEN-LAST:event_jPanelActivarMouseEntered

    private void jPanelAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAceptarMouseEntered
        ponerColor(jPanelAceptar);
    }//GEN-LAST:event_jPanelAceptarMouseEntered

    private void jPanelAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAceptarMouseExited
        repintarColor(jPanelAceptar);
    }//GEN-LAST:event_jPanelAceptarMouseExited

    private void jPanelAceptarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAceptarMousePressed
                      
        jPaneMenu.setVisible(true);
        jPaneInforme.setVisible(false);
        String nombreArchivo = archivo.getName();
        nombreArchivo = nombreArchivo.substring(0,nombreArchivo.lastIndexOf("."));
        String nombreCalificado = nombreArchivo+" - Calificado.txt";
        File fichero = new File("Examenes\\Calificados\\"+nombreCalificado);
        fichero.delete();
        new jInformacion(this, true, "<html><center>Se ha guardado correctamente el archivo "+ nombreCalificado+" en la carpeta "+carpetaCalificados.getName()+"</center></html>").setVisible(true);
        gestionarPreguntas.guardarExamen(nombreCalificado);
    }//GEN-LAST:event_jPanelAceptarMousePressed

    private void jPaneInformeComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPaneInformeComponentShown
        jPaneMenu.setVisible(false);
        borrarTabla(rSTableInforme);
        mostrarTabla(rSTableInforme);
    }//GEN-LAST:event_jPaneInformeComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabeHoras;
    private javax.swing.JLabel jLabelAceptar;
    private javax.swing.JLabel jLabelAcerca;
    private javax.swing.JLabel jLabelActivar;
    private javax.swing.JLabel jLabelCargar;
    private javax.swing.JLabel jLabelConfiguracion;
    private javax.swing.JLabel jLabelDireccionIP;
    private javax.swing.JLabel jLabelDireccionInet;
    private javax.swing.JLabel jLabelEditar;
    private javax.swing.JLabel jLabelEstudiantes;
    private javax.swing.JLabel jLabelGuardar;
    private javax.swing.JLabel jLabelGuardar1;
    private javax.swing.JLabel jLabelGuardar2;
    private javax.swing.JLabel jLabelIniciar;
    private javax.swing.JLabel jLabelLista;
    private javax.swing.JLabel jLabelMenu;
    private javax.swing.JLabel jLabelMenu1;
    private javax.swing.JLabel jLabelMenu2;
    private javax.swing.JLabel jLabelMenu5;
    private javax.swing.JLabel jLabelMinutos;
    public static javax.swing.JLabel jLabelNumeros;
    private javax.swing.JLabel jLabelPuerto;
    private javax.swing.JLabel jLabelPuntos1;
    private javax.swing.JLabel jLabelPuntos2;
    private javax.swing.JLabel jLabelSalir;
    private javax.swing.JLabel jLabelSegundos;
    private javax.swing.JLabel jLabelSincronizar;
    private javax.swing.JLabel jLabelSubtitulo;
    private javax.swing.JLabel jLabelTiempo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JLabel jLabelTitulo2;
    private javax.swing.JLabel jLabelTitulo3;
    private javax.swing.JLabel jLabelTitulo5;
    private javax.swing.JLabel jLabelTitulo6;
    public static javax.swing.JLabel jLabelTituloNumeros;
    private javax.swing.JLabel jLabelimgActivar;
    private javax.swing.JLabel jLabelimgCargar;
    private javax.swing.JLabel jLabelimgConfiguracion;
    private javax.swing.JLabel jLabelimgEditar;
    private javax.swing.JLabel jLabelimgGuardar;
    private javax.swing.JLabel jLabelimgGuardar1;
    private javax.swing.JLabel jLabelimgGuardar2;
    private javax.swing.JLabel jLabelimgIniciar;
    private javax.swing.JLabel jLabelimgLista;
    private javax.swing.JLabel jLabelimgMenu;
    private javax.swing.JLabel jLabelimgMenu1;
    private javax.swing.JLabel jLabelimgMenu2;
    private javax.swing.JLabel jLabelimgMenu5;
    private javax.swing.JLabel jLabelimgSincronizar;
    private javax.swing.JLabel jLabelimgTiempo;
    private javax.swing.JLabel jLabelimgTitulo;
    private javax.swing.JLabel jLabelimgTitulo1;
    private javax.swing.JLabel jLabelimgTitulo2;
    private javax.swing.JLabel jLabelimgTitulo3;
    private javax.swing.JLabel jLabelimgTitulo5;
    private javax.swing.JLabel jLabelimgTitulo6;
    javax.swing.JList<String> jListOtrosExamenes;
    private javax.swing.JPanel jPaneConfiguracion;
    private javax.swing.JPanel jPaneContain;
    private javax.swing.JPanel jPaneEditar;
    private javax.swing.JPanel jPaneExamenes;
    public static javax.swing.JPanel jPaneInforme;
    private javax.swing.JPanel jPaneMenu;
    private javax.swing.JPanel jPanePpal;
    private javax.swing.JPanel jPaneTiempo;
    private javax.swing.JPanel jPanelAceptar;
    private javax.swing.JPanel jPanelActivar;
    private javax.swing.JPanel jPanelCargar;
    private javax.swing.JPanel jPanelConfiguracion;
    private javax.swing.JPanel jPanelEditar;
    private javax.swing.JPanel jPanelGuardar;
    private javax.swing.JPanel jPanelGuardar1;
    private javax.swing.JPanel jPanelGuardar2;
    private javax.swing.JPanel jPanelInforme;
    private javax.swing.JPanel jPanelIniciar;
    private javax.swing.JPanel jPanelLista;
    private javax.swing.JPanel jPanelMenu1;
    private javax.swing.JPanel jPanelMenu2;
    private javax.swing.JPanel jPanelMenu3;
    private javax.swing.JPanel jPanelMenu6;
    private javax.swing.JPanel jPanelSincronizar;
    private javax.swing.JPanel jPanelTiempo;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JPanel jPanelTitulo1;
    private javax.swing.JPanel jPanelTitulo2;
    private javax.swing.JPanel jPanelTitulo3;
    private javax.swing.JPanel jPanelTitulo5;
    private javax.swing.JPanel jPanelTitulo6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneMostrar;
    public static javax.swing.JSpinner jSpinnerEstudiantes;
    private javax.swing.JSpinner jSpinnerHoras;
    private javax.swing.JSpinner jSpinnerMinutos;
    private javax.swing.JSpinner jSpinnerSegundos;
    private javax.swing.JTextArea jTextAreaMostrar;
    private javax.swing.JTextField jTextFieldDireccionIP;
    private javax.swing.JTextField jTextFieldDireccionInet;
    private javax.swing.JTextField jTextFieldPuerto;
    private rojerusan.RSTableMetro rSTableInforme;
    // End of variables declaration//GEN-END:variables
}
