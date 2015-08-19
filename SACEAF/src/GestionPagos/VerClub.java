/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPagos;

import static GestionPagos.VerDeudasClubes.TablaDeudasClubes;
import static GestionPagos.VerDeudasEquipos.TablaDeudasEquipos;
import javax.swing.JOptionPane;
import saceaf.Principal;

/**
 *
 * @author Kevin_000
 */
public class VerClub extends javax.swing.JPanel {

    /**
     * Creates new form VerDeudasEquiposFinal
     */
    public VerClub() {
        initComponents();
        VerDeudasEquipos();
    }

   public void VerDeudasEquipos(){
    VerDeudasEquipos AbrirDeudasEquipos= new VerDeudasEquipos();
    String titulo="Equipos Deudores";
        int index=PanelDeudasEquipos.indexOfTab(titulo);
        if(index==-1){
            PanelDeudasEquipos.addTab(titulo, AbrirDeudasEquipos);
            int i=PanelDeudasEquipos.indexOfTab(titulo);
            PanelDeudasEquipos.setSelectedIndex(i);
        }else{
            PanelDeudasEquipos.remove(index);
            PanelDeudasEquipos.addTab(titulo, AbrirDeudasEquipos);
            int i=PanelDeudasEquipos.indexOfTab(titulo);
            PanelDeudasEquipos.setSelectedIndex(i);
        }
    
}
   public void VerPagosEquipos(){
    VerPagosEquipos AbrirPagosEquipos= new VerPagosEquipos();
    String titulo="Pagos de los Equipos";
        int index=PanelDeudasEquipos.indexOfTab(titulo);
        if(index==-1){
            PanelDeudasEquipos.addTab(titulo, AbrirPagosEquipos);
            int i=PanelDeudasEquipos.indexOfTab(titulo);
            PanelDeudasEquipos.setSelectedIndex(i);
        }else{
            PanelDeudasEquipos.remove(index);
            PanelDeudasEquipos.addTab(titulo, AbrirPagosEquipos);
            int i=PanelDeudasEquipos.indexOfTab(titulo);
            PanelDeudasEquipos.setSelectedIndex(i);
        }
    
}
   public void VerDeudasDelEquipo(){
       VerDeudasDelEquipo AbrirDeudasDelEquipo= new VerDeudasDelEquipo();
       String titulo="Deudas Del Equipo";
        int index=PanelDeudasEquipos.indexOfTab(titulo);
        if(index==-1){
            PanelDeudasEquipos.addTab(titulo, AbrirDeudasDelEquipo);
            int i=PanelDeudasEquipos.indexOfTab(titulo);
            PanelDeudasEquipos.setSelectedIndex(i);
        }else{
            PanelDeudasEquipos.remove(index);
            PanelDeudasEquipos.addTab(titulo, AbrirDeudasDelEquipo);
            int i=PanelDeudasEquipos.indexOfTab(titulo);
            PanelDeudasEquipos.setSelectedIndex(i);
        }
   }
   public static void DeshabilitarBotones(){
       BotonAcceder.setEnabled(false);
       BotonVerPagos.setEnabled(false);
       BotonCerrar.setEnabled(false);
   }
   public static void HabilitarBotones(){
       BotonAcceder.setEnabled(true);
       BotonVerPagos.setEnabled(true);
       BotonCerrar.setEnabled(true);
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        LabelNombreEquipo = new javax.swing.JLabel();
        PanelDeudasEquipos = new javax.swing.JTabbedPane();
        BotonCerrar = new javax.swing.JButton();
        BotonVerPagos = new javax.swing.JButton();
        BotonAcceder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setLayout(null);

        jPanel2.setOpaque(false);

        LabelNombreEquipo.setText(TablaDeudasClubes.getValueAt(TablaDeudasClubes.getSelectedRow(),1).toString());
        LabelNombreEquipo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LabelNombreEquipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        BotonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 30x30.png"))); // NOI18N
        BotonCerrar.setText("Salir");
        BotonCerrar.setBorder(null);
        BotonCerrar.setBorderPainted(false);
        BotonCerrar.setContentAreaFilled(false);
        BotonCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonCerrar.setIconTextGap(-2);
        BotonCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 40x40.png"))); // NOI18N
        BotonCerrar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarActionPerformed(evt);
            }
        });

        BotonVerPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/entrar2 30x30.png"))); // NOI18N
        BotonVerPagos.setText("Ver Pagos");
        BotonVerPagos.setBorder(null);
        BotonVerPagos.setBorderPainted(false);
        BotonVerPagos.setContentAreaFilled(false);
        BotonVerPagos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonVerPagos.setIconTextGap(-2);
        BotonVerPagos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/entrar2 40x40.png"))); // NOI18N
        BotonVerPagos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonVerPagos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonVerPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVerPagosActionPerformed(evt);
            }
        });

        BotonAcceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/acceder30x30.png"))); // NOI18N
        BotonAcceder.setText("Acceder");
        BotonAcceder.setBorderPainted(false);
        BotonAcceder.setContentAreaFilled(false);
        BotonAcceder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonAcceder.setIconTextGap(-2);
        BotonAcceder.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/acceder40x40.png"))); // NOI18N
        BotonAcceder.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonAcceder.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAccederActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(237, Short.MAX_VALUE)
                        .addComponent(LabelNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(BotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BotonVerPagos, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(BotonAcceder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelDeudasEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(LabelNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelDeudasEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BotonAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonVerPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1000, 412);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondos/FondoMedioDifuminado.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 412);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarActionPerformed
        Principal.panelprincipal.remove(this);
        GestionPagos.HabilitarBotones();
    }//GEN-LAST:event_BotonCerrarActionPerformed

    private void BotonVerPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVerPagosActionPerformed
        VerPagosEquipos();
        DeshabilitarBotones();
    }//GEN-LAST:event_BotonVerPagosActionPerformed

    private void BotonAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAccederActionPerformed
        if(TablaDeudasEquipos.getSelectedRows().length > 0 ){
        DeshabilitarBotones();
        VerDeudasDelEquipo();
        }
        else{
                 JOptionPane.showMessageDialog(this,"Debe Seleccionar un Equipo al Cual Acceder","Información", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_BotonAccederActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton BotonAcceder;
    public static javax.swing.JButton BotonCerrar;
    public static javax.swing.JButton BotonVerPagos;
    private javax.swing.JLabel LabelNombreEquipo;
    public static javax.swing.JTabbedPane PanelDeudasEquipos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
