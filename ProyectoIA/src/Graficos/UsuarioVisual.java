/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import Logica.Bloque;
import Logica.Amplitud;
import Logica.Coordenadas;
import Logica.Funcionalidades;
import java.awt.GridLayout;
import Recursos.IcoRecurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauro
 */
public class UsuarioVisual extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form UsuarioVisual
     */
    ArrayList<Bloque> objetivos;
    public Bloque[][] matrix;
    public Bloque[][] matrixGrafico;
    Bloque init = new Bloque();
    Funcionalidades funciones;

    public UsuarioVisual() {
        initComponents();
        //Funcines para el Inicio del Mapa
        funciones = new Funcionalidades();
        matrix = funciones.crearTablero();
        this.objetivos = new ArrayList<>();
        creacionBotones(matrix);
        this.repaint();
        this.setSize(580, 620);
        this.setResizable(false);

    }

    //Diseñada para generar los iconos
    private ImageIcon IconoMapa(Bloque bloque) {
        ImageIcon imagen = new ImageIcon();
        //Poner condicionales para elementos graficos
        if (bloque.getContenido() == 0) {
            //VACIO
            imagen = IcoRecurso.ICON_VACIO;
        }
        if (bloque.getContenido() == 1) {
            //CABALLO NEGRO
            imagen = IcoRecurso.ICON_CABALLO_NEGRO;
        }
        if (bloque.getContenido() == 2) {
            //CABALLO BLANCO
            imagen = IcoRecurso.ICON_CABALLO_BLANCO;
        }
        if (bloque.getContenido() == 3) {
            //CESPED
            imagen = IcoRecurso.ICON_CESPED;
        }
        if (bloque.getContenido() == 4) {
            //FLOR
            imagen = IcoRecurso.ICON_FLOR;
        }
        return imagen;
    }

    /*Funcion diseñada para llenar el JPmapa de Botones*/
    //Como se usan los arreglos de bloques si el programa suelta array de array con enteros?
    public void creacionBotones(Bloque[][] matrix) {

        //this.setSize(450, 492);
        jPmapa.removeAll();
        int filas = 8;
        int columnas = 8;
        jPmapa.setLayout(new GridLayout(8, 8));

        //*AQUI CREO LOS BOTONES CON TAMAÑO 8 -- A que se refieren con tamaño 8?
        for (int PosY = 0; PosY < 8; PosY++) {
            for (int PosX = 0; PosX < 8; PosX++) {
                Boton[][] MatFichas = new Boton[8][8];
                MatFichas[PosX][PosY] = new Boton();
                /*Agrego Coordenadas*/
                Coordenadas ubicacion = new Coordenadas(PosX, PosY);
                MatFichas[PosX][PosY].setCordenada(ubicacion);
                /*Fin de insertcion de coordenadas*/
                //Escucha del Boton
                MatFichas[PosX][PosY].addActionListener(this);
                //Icono del Boton
                MatFichas[PosX][PosY].setIcon(IconoMapa(matrix[PosY][PosX]));
                jPmapa.add(MatFichas[PosX][PosY]);

            }
        }

        jPmapa.updateUI();
        jPmapa.revalidate();
        jPmapa.repaint();

    }

    void printmatrix(Bloque[][] matrix) {
        System.out.println("Pintando Matriz");
        for (int i = 0; i < matrix.length; i++) {
            //Filas
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(" " + matrix[j][i].getContenido() + " |");
            }
            System.out.println("-");
        }

    }

    private void MostrarCamino(ArrayList<Bloque> entrada) {
        /*Esta funcion Pinta el camino probeniente de los algoritmos de busqueda*/
        Bloque[][] mapa = new Bloque[8][8];
        mapa = matrix.clone();
        for (int i = 0; i < entrada.size(); i++) {
            try {
                mapa[entrada.get(i).getUbicacion().x][entrada.get(i).getUbicacion().y].setContenido(2);
                creacionBotones(mapa);
                Thread.sleep(800);
                printmatrix(mapa);
                creacionBotones(mapa);
                mapa[entrada.get(i).getUbicacion().x][entrada.get(i).getUbicacion().y].setContenido(-1);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Error en Tiempo de espera del Hilo de Ejecucion");
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jBbuscar = new javax.swing.JButton();
        jPBanner = new javax.swing.JPanel();
        jPmapa = new javax.swing.JPanel();
        jLTitle = new javax.swing.JLabel();
        jComboBoxDificultad = new javax.swing.JComboBox();
        jLabelDificultad = new javax.swing.JLabel();
        jLabelMaquina = new javax.swing.JLabel();
        jLabelHumano = new javax.swing.JLabel();
        jLabelPuntosMaquina = new javax.swing.JLabel();
        jLabelPuntosHumano = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jBbuscar.setBackground(new java.awt.Color(255, 255, 255));
        jBbuscar.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jBbuscar.setText("Empezar el juego");
        jBbuscar.setContentAreaFilled(false);
        jBbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbuscarActionPerformed(evt);
            }
        });

        jPBanner.setBackground(new java.awt.Color(204, 255, 204));

        jPmapa.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPmapaLayout = new javax.swing.GroupLayout(jPmapa);
        jPmapa.setLayout(jPmapaLayout);
        jPmapaLayout.setHorizontalGroup(
                jPmapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
        );
        jPmapaLayout.setVerticalGroup(
                jPmapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 337, Short.MAX_VALUE)
        );

        jLTitle.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLTitle.setForeground(new java.awt.Color(0, 0, 153));
        jLTitle.setText("Hungry horses 1.0");

        javax.swing.GroupLayout jPBannerLayout = new javax.swing.GroupLayout(jPBanner);
        jPBanner.setLayout(jPBannerLayout);
        jPBannerLayout.setHorizontalGroup(
                jPBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPBannerLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLTitle)
                        .addContainerGap(326, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBannerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPmapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
        jPBannerLayout.setVerticalGroup(
                jPBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBannerLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLTitle)
                        .addGap(17, 17, 17)
                        .addComponent(jPmapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );

        jComboBoxDificultad.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Principiante", "Amateur", "Experto"}));

        jLabelDificultad.setText("Seleccione un nivel de dificultad:");

        jLabelMaquina.setText("Máquina:");

        jLabelHumano.setText("Humano:");

        jLabelPuntosMaquina.setText("0");

        jLabelPuntosHumano.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabelMaquina)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabelPuntosMaquina))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabelHumano)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabelPuntosHumano)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBbuscar)
                                        .addGap(25, 25, 25))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabelDificultad)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jComboBoxDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, Short.MAX_VALUE)))
                                        .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelDificultad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jBbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelMaquina)
                                                .addComponent(jLabelPuntosMaquina))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelHumano)
                                                .addComponent(jLabelPuntosHumano))))
                        .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbuscarActionPerformed

        System.out.println("Tamaño matrix " + matrix[0].length);
        Amplitud amplitud = new Amplitud((String) jComboBoxDificultad.getSelectedItem());
        ArrayList<Bloque> s = new ArrayList<>();
        s = amplitud.minimax(init);

        //Como creo el tablero con un arraylist anidado?
    }//GEN-LAST:event_jBbuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UsuarioVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioVisual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBbuscar;
    private javax.swing.JComboBox jComboBoxDificultad;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JLabel jLabelDificultad;
    private javax.swing.JLabel jLabelHumano;
    private javax.swing.JLabel jLabelMaquina;
    private javax.swing.JLabel jLabelPuntosHumano;
    private javax.swing.JLabel jLabelPuntosMaquina;
    private javax.swing.JPanel jPBanner;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPmapa;
    // End of variables declaration//GEN-END:variables

    private Coordenadas convertidorACoordenadas(String entrada) {
        
        int principio = entrada.indexOf("Boton[,");
        principio += 7;
        int fin = entrada.indexOf(",65x43");
        String procesado = entrada.substring(principio, fin);   
        //Convierto el string en tokens
        StringTokenizer st = new StringTokenizer(procesado, ",");
        String parametroX  = st.nextToken();
        String parametroY= st.nextToken();
        int X = Integer.parseInt(parametroX);
        int Y = Integer.parseInt(parametroY);
        X = X/65;
        Y = Y/43;
        System.out.println(" -+-+- Coordenadas  inicio: " + procesado + " X = "+ X + " Y = " + Y);
        Coordenadas salida = new Coordenadas(X,Y);
        return salida;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Graficos.UsuarioVisual.actionPerformed()" + ae.getSource());
        convertidorACoordenadas(ae.getSource().toString());
    }
}
