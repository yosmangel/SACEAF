/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sanciones;


import java.sql.Connection;
import javax.swing.JOptionPane;
import saceaf.Principal;
import static saceaf.Principal.panelprincipal;
/**
 *

 */
public class Gsanciones extends javax.swing.JPanel {

    /**
     * Creates new form Gequipos
     */
    public Gsanciones() {
        initComponents();
        AbrirSanciones();
        
    }
public void AbrirAgregarSancionEquipo(){
    AgregarSancionEquipo AbrirAgregarSancion= new AgregarSancionEquipo();
    String titulo="Agregar Sancion";
        int index=PanelSanciones.indexOfTab(titulo);
        if(index==-1){
            PanelSanciones.addTab(titulo, AbrirAgregarSancion);
            int i=PanelSanciones.indexOfTab(titulo);
            PanelSanciones.setSelectedIndex(i);
        }else{
            PanelSanciones.remove(index);
            PanelSanciones.addTab(titulo, AbrirAgregarSancion);
            int i=PanelSanciones.indexOfTab(titulo);
            PanelSanciones.setSelectedIndex(i);
        }
    
}
public void AbrirAgregarSancionJugador(){
    AgregarSancionJugador AbrirAgregarSancionJugador= new AgregarSancionJugador();
    String titulo="Agregar Sancion de Jugador";
        int index=PanelSanciones.indexOfTab(titulo);
        if(index==-1){
            PanelSanciones.addTab(titulo, AbrirAgregarSancionJugador);
            int i=PanelSanciones.indexOfTab(titulo);
            PanelSanciones.setSelectedIndex(i);
        }else{
            PanelSanciones.remove(index);
            PanelSanciones.addTab(titulo, AbrirAgregarSancionJugador);
            int i=PanelSanciones.indexOfTab(titulo);
            PanelSanciones.setSelectedIndex(i);
        }
    
}
public void AbrirSanciones(){
    VerSanciones AbrirSanciones= new VerSanciones();
    String titulo="Sanciones";
        int index=PanelSanciones.indexOfTab(titulo);
        if(index==-1){
            PanelSanciones.addTab(titulo, AbrirSanciones);
            int i=PanelSanciones.indexOfTab(titulo);
            PanelSanciones.setSelectedIndex(i);
        }else{
            PanelSanciones.remove(index);
            PanelSanciones.addTab(titulo, AbrirSanciones);
            int i=PanelSanciones.indexOfTab(titulo);
            PanelSanciones.setSelectedIndex(i);
        }
    
}
   public void abrirsanciones(){
       Gsanciones gs = new Gsanciones();
       String titulo= " Gestionar Sanciones";
       int index= panelprincipal.indexOfTab(titulo);
       if (index== -1){
           panelprincipal.addTab(titulo,gs);
           int i= panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }else{
           panelprincipal.remove(index);
           panelprincipal.addTab(titulo, gs);
           int i=panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }
   }
  
    
   
    
    
   
    
    public static void habilitar(){
        bagregar.setEnabled(true);
        bsalir.setEnabled(true);
    }
    public static void deshabilitar(){
        bagregar.setEnabled(false);
        bsalir.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        PanelSanciones = new javax.swing.JTabbedPane();
        bsalir = new javax.swing.JButton();
        bagregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1000, 412));

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel1.setLayout(null);

        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1000, 410);
        jPanel1.add(PanelSanciones);
        PanelSanciones.setBounds(130, 80, 830, 310);

        bsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 30x30.png"))); // NOI18N
        bsalir.setText("Salir");
        bsalir.setContentAreaFilled(false);
        bsalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bsalir.setIconTextGap(-2);
        bsalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 40x40.png"))); // NOI18N
        bsalir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bsalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsalirActionPerformed(evt);
            }
        });
        jPanel1.add(bsalir);
        bsalir.setBounds(930, 0, 63, 70);

        bagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Add 30x30.png"))); // NOI18N
        bagregar.setText("Agregar");
        bagregar.setContentAreaFilled(false);
        bagregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bagregar.setIconTextGap(-2);
        bagregar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Add 40x40.png"))); // NOI18N
        bagregar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bagregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bagregarActionPerformed(evt);
            }
        });
        jPanel1.add(bagregar);
        bagregar.setBounds(30, 90, 71, 60);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Gestionar Sanciones");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(440, 30, 214, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondos/FondoMedioDifuminado.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 602);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        Principal.panelprincipal.remove(this);
    }//GEN-LAST:event_bsalirActionPerformed

    private void bagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagregarActionPerformed
        String [] botones = { " Equipo", "Jugador" };
        int variable = JOptionPane.showOptionDialog (null, "Desea Agregar la sancion a un equipo(si) o jugador(no)","Informacion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, botones, botones[0]);
         int opc=variable;      
        if(opc==0){
                  AbrirAgregarSancionEquipo();
                  deshabilitar();
                   
               } else{
                   
                    
                  AbrirAgregarSancionJugador();
                  deshabilitar();
               }
       

    }//GEN-LAST:event_bagregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTabbedPane PanelSanciones;
    public static javax.swing.JButton bagregar;
    public static javax.swing.JButton bsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables
 
    
}
