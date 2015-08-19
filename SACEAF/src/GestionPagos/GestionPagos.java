/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPagos;

import static GestionPagos.VerDeudasClubes.TablaDeudasClubes;
import javax.swing.JOptionPane;
import saceaf.Principal;

public class GestionPagos extends javax.swing.JPanel {

    /**
     * Creates new form GestionPagos
     */
    public GestionPagos() {
        initComponents();
        VerDeudasClubes();
        
    }
public void VerDeudasClubes(){
    VerDeudasClubes AbrirDeudasClubes= new VerDeudasClubes();
    String titulo="Clubes Deudores";
        int index=PanelPagos.indexOfTab(titulo);
        if(index==-1){
            PanelPagos.addTab(titulo, AbrirDeudasClubes);
            int i=PanelPagos.indexOfTab(titulo);
            PanelPagos.setSelectedIndex(i);
        }else{
            PanelPagos.remove(index);
            PanelPagos.addTab(titulo, AbrirDeudasClubes);
            int i=PanelPagos.indexOfTab(titulo);
            PanelPagos.setSelectedIndex(i);
        }
    
}
public void AbrirClub(){
    String NombreClub=(String) VerDeudasClubes.TablaDeudasClubes.getValueAt(VerDeudasClubes.TablaDeudasClubes.getSelectedRow(),1);
    VerClub VC=new VerClub();
    String Titulo=""+NombreClub+"";
       int index= Principal.panelprincipal.indexOfTab(Titulo);
       if(index==-1){
           Principal.panelprincipal.addTab(Titulo, VC);
           int i=Principal.panelprincipal.indexOfTab(Titulo);
           Principal.panelprincipal.setSelectedIndex(i);
       }else{
           Principal.panelprincipal.remove(index);
           Principal.panelprincipal.addTab(Titulo, VC);
           int i=Principal.panelprincipal.indexOfTab(Titulo);
           Principal.panelprincipal.setSelectedIndex(i);
       }
    }


public static void DeshabilitarBotones(){
    BotonAcceder.setEnabled(false);
    BotonSalir.setEnabled(false);
}
public static void HabilitarBotones(){
    BotonAcceder.setEnabled(true);
    BotonSalir.setEnabled(true);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        PanelPagos = new javax.swing.JTabbedPane();
        BotonSalir = new javax.swing.JButton();
        BotonAcceder = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1000, 412));

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 412));
        jPanel1.setLayout(null);

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

        jPanel1.add(jPanel2);
        jPanel2.setBounds(1000, 412, 100, 100);
        jPanel1.add(PanelPagos);
        PanelPagos.setBounds(150, 80, 830, 315);

        BotonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 30x30.png"))); // NOI18N
        BotonSalir.setText("Salir");
        BotonSalir.setBorder(null);
        BotonSalir.setBorderPainted(false);
        BotonSalir.setContentAreaFilled(false);
        BotonSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonSalir.setIconTextGap(-2);
        BotonSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 40x40.png"))); // NOI18N
        BotonSalir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });
        jPanel1.add(BotonSalir);
        BotonSalir.setBounds(930, 0, 53, 60);

        BotonAcceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/acceder30x30.png"))); // NOI18N
        BotonAcceder.setText("Acceder");
        BotonAcceder.setBorder(null);
        BotonAcceder.setBorderPainted(false);
        BotonAcceder.setContentAreaFilled(false);
        BotonAcceder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jPanel1.add(BotonAcceder);
        BotonAcceder.setBounds(40, 70, 60, 70);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Gestionar Pagos");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(510, 20, 180, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondos/FondoMedioDifuminado.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 412);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
        Principal.panelprincipal.remove(this);
    }//GEN-LAST:event_BotonSalirActionPerformed

    private void BotonAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAccederActionPerformed
         if(TablaDeudasClubes.getSelectedRows().length > 0 ){
        DeshabilitarBotones();
        AbrirClub();
        
        
    }
    else{
     JOptionPane.showMessageDialog(this,"Debe Seleccionar un Club al Cual Acceder","Información", JOptionPane.INFORMATION_MESSAGE);
 
   }
    }//GEN-LAST:event_BotonAccederActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton BotonAcceder;
    public static javax.swing.JButton BotonSalir;
    public static javax.swing.JTabbedPane PanelPagos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
