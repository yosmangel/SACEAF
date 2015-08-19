/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Administracion;

import javax.swing.JOptionPane;
import saceaf.Principal;


public class Gadministracion extends javax.swing.JPanel {


    public Gadministracion() {
        initComponents();
        abrirpresentacion();
    }

    public static void habilitar(){
        bcategorias.setEnabled(true);
        bmunicipios.setEnabled(true);
        bdisciplina.setEnabled(true);
        bsalir.setEnabled(true);
    }
    public static void deshabilitar(){
        bcategorias.setEnabled(false);
        bmunicipios.setEnabled(false);
        bdisciplina.setEnabled(false);
        bsalir.setEnabled(false);
    }
            
   public void abrircategoria(){
       
       pcategoria pca=new pcategoria();
       String titulo="Categoria";
       int index= paneladministracion.indexOfTab(titulo);
       if(index == -1){
           paneladministracion.add(titulo,pca);
           int i= paneladministracion.indexOfTab(titulo);
           paneladministracion.setSelectedIndex(i);
       }else{
           paneladministracion.remove(index);
           paneladministracion.add(titulo,pca);
           int i=paneladministracion.indexOfTab(titulo);
           paneladministracion.setSelectedIndex(i);
       }
   }
      public void abrirpresentacion(){
       
       presentacion p=new presentacion();
       String titulo="";
       int index= paneladministracion.indexOfTab(titulo);
       if(index == -1){
           paneladministracion.add(titulo,p);
           int i= paneladministracion.indexOfTab(titulo);
           paneladministracion.setSelectedIndex(i);
       }else{
           paneladministracion.remove(index);
           paneladministracion.add(titulo,p);
           int i=paneladministracion.indexOfTab(titulo);
           paneladministracion.setSelectedIndex(i);
       }
   }
   public void abrirdisciplina(){
       pdisciplina pdi= new pdisciplina();
       String titulo="Disciplina";
       int index=paneladministracion.indexOfTab(titulo);
       if(index==-1){
           paneladministracion.add(titulo,pdi);
           int i= paneladministracion.indexOfTab(titulo);
           paneladministracion.setSelectedIndex(i);
       }else{
           paneladministracion.remove(index);
           paneladministracion.add(titulo,pdi);
           int i=paneladministracion.indexOfTab(titulo);
           paneladministracion.setSelectedIndex(i);
       }
   }
   public void abrirmunicipio(){
       pmunicipio pmu= new pmunicipio();
       String titulo="Municipio";
       int index=paneladministracion.indexOfTab(titulo);
       if(index==-1){
           paneladministracion.add(titulo,pmu);
           int i=paneladministracion.indexOfTab(titulo);
           paneladministracion.setSelectedIndex(i);
       }else{
           paneladministracion.remove(index);
           paneladministracion.add(titulo, pmu);
           int i=paneladministracion.indexOfTab(titulo);
           paneladministracion.setSelectedIndex(i);
       }
   }
   public void AbrirAgregarSancionesEquipo(){
       SancionesEquipo AGS= new SancionesEquipo();
       String titulo="Agregar Sanciones de Equipos";
       int index=paneladministracion.indexOfTab(titulo);
       if(index==-1){
           paneladministracion.add(titulo,AGS);
           int i=paneladministracion.indexOfTab(titulo);
           paneladministracion.setSelectedIndex(i);
       }else{
           paneladministracion.remove(index);
           paneladministracion.add(titulo, AGS);
           int i=paneladministracion.indexOfTab(titulo);
           paneladministracion.setSelectedIndex(i);
       }
   }
   public void AbrirAgregarSancionesJugadores(){
       SancionesJugador AGS= new SancionesJugador();
       String titulo="Agregar Sanciones de Jugadores";
       int index=paneladministracion.indexOfTab(titulo);
       if(index==-1){
           paneladministracion.add(titulo,AGS);
           int i=paneladministracion.indexOfTab(titulo);
           paneladministracion.setSelectedIndex(i);
       }else{
           paneladministracion.remove(index);
           paneladministracion.add(titulo, AGS);
           int i=paneladministracion.indexOfTab(titulo);
           paneladministracion.setSelectedIndex(i);
       }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bmunicipios = new javax.swing.JButton();
        bcategorias = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bdisciplina = new javax.swing.JButton();
        paneladministracion = new javax.swing.JTabbedPane();
        bsalir = new javax.swing.JButton();
        BotonSanciones = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1000, 412));

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel1.setLayout(null);

        jPanel2.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 412));
        jPanel2.setLayout(null);

        bmunicipios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bmunicipios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconosadministracion/municipio60x60.png"))); // NOI18N
        bmunicipios.setText("Municipios");
        bmunicipios.setContentAreaFilled(false);
        bmunicipios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bmunicipios.setIconTextGap(-2);
        bmunicipios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconosadministracion/municipio80x80.png"))); // NOI18N
        bmunicipios.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bmunicipios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bmunicipios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmunicipiosActionPerformed(evt);
            }
        });
        jPanel2.add(bmunicipios);
        bmunicipios.setBounds(125, 92, 97, 83);

        bcategorias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bcategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconosadministracion/categoria60x60.png"))); // NOI18N
        bcategorias.setText("Categorias");
        bcategorias.setContentAreaFilled(false);
        bcategorias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bcategorias.setIconTextGap(-2);
        bcategorias.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconosadministracion/categoria80x80.png"))); // NOI18N
        bcategorias.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bcategorias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bcategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcategoriasActionPerformed(evt);
            }
        });
        jPanel2.add(bcategorias);
        bcategorias.setBounds(10, 92, 97, 83);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Administración de la Aplicación");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(401, 16, 243, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Seleccione el área a administrar");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(47, 53, 247, 22);

        bdisciplina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bdisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconosadministracion/disciplina60x60.png"))); // NOI18N
        bdisciplina.setText("Disciplina");
        bdisciplina.setContentAreaFilled(false);
        bdisciplina.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bdisciplina.setIconTextGap(-2);
        bdisciplina.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconosadministracion/disciplina80x80.png"))); // NOI18N
        bdisciplina.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bdisciplina.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bdisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdisciplinaActionPerformed(evt);
            }
        });
        jPanel2.add(bdisciplina);
        bdisciplina.setBounds(10, 173, 97, 100);

        paneladministracion.setMinimumSize(new java.awt.Dimension(630, 309));
        jPanel2.add(paneladministracion);
        paneladministracion.setBounds(360, 81, 630, 300);

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
        jPanel2.add(bsalir);
        bsalir.setBounds(909, 24, 63, 51);

        BotonSanciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BotonSanciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/sanciones60x60.png"))); // NOI18N
        BotonSanciones.setText("Sanciones");
        BotonSanciones.setBorder(null);
        BotonSanciones.setBorderPainted(false);
        BotonSanciones.setContentAreaFilled(false);
        BotonSanciones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonSanciones.setIconTextGap(-2);
        BotonSanciones.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/sanciones80x80.png"))); // NOI18N
        BotonSanciones.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonSanciones.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonSanciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSancionesActionPerformed(evt);
            }
        });
        jPanel2.add(BotonSanciones);
        BotonSanciones.setBounds(130, 170, 90, 100);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1000, 412);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondos/FondoMedioDifuminado.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-2, -5, 1000, 420);

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

    private void bcategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcategoriasActionPerformed
        abrircategoria();
        deshabilitar();
    }//GEN-LAST:event_bcategoriasActionPerformed

    private void bdisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdisciplinaActionPerformed
        abrirdisciplina();
        deshabilitar();
    }//GEN-LAST:event_bdisciplinaActionPerformed

    private void bmunicipiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmunicipiosActionPerformed
        abrirmunicipio();
        deshabilitar();
    }//GEN-LAST:event_bmunicipiosActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        Principal.panelprincipal.remove(this);
    }//GEN-LAST:event_bsalirActionPerformed

    private void BotonSancionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSancionesActionPerformed
        String [] botones = { " Equipo", "Jugador" };
        int variable = JOptionPane.showOptionDialog (null, "¿Para Quién Desea Registrar un Motivo de Sanción?","Informacion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, botones, botones[0]);
         int opc=variable;      
        if(opc==0){
                  AbrirAgregarSancionesEquipo();
                  deshabilitar();
                   
               } 
        else if(opc==1){
                   
                    
                  AbrirAgregarSancionesJugadores();
                  deshabilitar();
        }
        else{
            
        }
    }//GEN-LAST:event_BotonSancionesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton BotonSanciones;
    public static javax.swing.JButton bcategorias;
    public static javax.swing.JButton bdisciplina;
    public static javax.swing.JButton bmunicipios;
    public static javax.swing.JButton bsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JTabbedPane paneladministracion;
    // End of variables declaration//GEN-END:variables
}
