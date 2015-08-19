/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPagos;

import Basededatos.Conexion;
import static GestionPagos.VerPagosEquipos.TablaPagosEquipos;
import GestionPagosBdD.DatosPagosEquipos;
import GestionPagosBdD.InsertarPagosEquipos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import saceaf.Principal;
import static saceaf.Principal.panelprincipal;

public class VerDetallesPago extends javax.swing.JPanel {

    /**
     * Creates new form AgregarPago
     */
    public VerDetallesPago() {
        initComponents();
    }

public void abrirGestionPagos(){
GestionPagos Pagos= new GestionPagos();

String titulo= "Gestionar Pagos";
       int index= panelprincipal.indexOfTab(titulo);
       
       if (index== -1){
           panelprincipal.addTab(titulo, Pagos);
           int i=panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }else{
           panelprincipal.remove(index);
           panelprincipal.addTab(titulo, Pagos);
           int i=panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }
}
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelDetallePagosEquipos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CampoMotivo = new javax.swing.JTextArea();
        LabelTitular = new javax.swing.JLabel();
        CampoTitular = new javax.swing.JTextField();
        LabelDeuda = new javax.swing.JLabel();
        CampoDeuda = new javax.swing.JTextField();
        CampoPago = new javax.swing.JTextField();
        LabelPago = new javax.swing.JLabel();
        BotonCerrar = new javax.swing.JButton();
        LabelSerialEquipo = new javax.swing.JLabel();
        CampoNombreEquipo = new javax.swing.JTextField();

        setOpaque(false);

        LabelDetallePagosEquipos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LabelDetallePagosEquipos.setText("Detalles del Pago");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Motivo de Pago:");

        CampoMotivo.setEditable(false);
        CampoMotivo.setText(TablaPagosEquipos.getValueAt(TablaPagosEquipos.getSelectedRow(),2).toString());
        CampoMotivo.setColumns(20);
        CampoMotivo.setRows(5);
        CampoMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CampoMotivoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(CampoMotivo);

        LabelTitular.setText("Títular de Pago:");

        CampoTitular.setEditable(false);
        CampoTitular.setText(TablaPagosEquipos.getValueAt(TablaPagosEquipos.getSelectedRow(),1).toString());
        CampoTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoTitularActionPerformed(evt);
            }
        });
        CampoTitular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CampoTitularKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoTitularKeyTyped(evt);
            }
        });

        LabelDeuda.setText("Monto Deuda:");

        CampoDeuda.setEditable(false);
        CampoDeuda.setText(TablaPagosEquipos.getValueAt(TablaPagosEquipos.getSelectedRow(),4).toString());
        CampoDeuda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CampoDeudaKeyReleased(evt);
            }
        });

        CampoPago.setEditable(false);
        CampoPago.setText(TablaPagosEquipos.getValueAt(TablaPagosEquipos.getSelectedRow(),3).toString());
        CampoPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CampoPagoKeyReleased(evt);
            }
        });

        LabelPago.setText("Pago Efectuado:");

        BotonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit7 30x30.png"))); // NOI18N
        BotonCerrar.setText("Cerrar");
        BotonCerrar.setBorder(null);
        BotonCerrar.setBorderPainted(false);
        BotonCerrar.setContentAreaFilled(false);
        BotonCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonCerrar.setIconTextGap(-2);
        BotonCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit7 40x40.png"))); // NOI18N
        BotonCerrar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarActionPerformed(evt);
            }
        });

        LabelSerialEquipo.setText("Serial del Equipo:");

        CampoNombreEquipo.setEditable(false);
        CampoNombreEquipo.setText(TablaPagosEquipos.getValueAt(TablaPagosEquipos.getSelectedRow(),0).toString());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(LabelTitular))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelSerialEquipo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelDeuda, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelPago, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(CampoPago, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                        .addComponent(CampoTitular, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                    .addComponent(CampoDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(BotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(201, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelDetallePagosEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(246, 246, 246))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelDetallePagosEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CampoNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelSerialEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CampoDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CampoTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelTitular))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CampoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelPago))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CampoTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoTitularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoTitularActionPerformed

    private void CampoTitularKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoTitularKeyReleased

    }//GEN-LAST:event_CampoTitularKeyReleased

    private void CampoPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoPagoKeyReleased

    }//GEN-LAST:event_CampoPagoKeyReleased

    private void CampoMotivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoMotivoKeyReleased

    }//GEN-LAST:event_CampoMotivoKeyReleased

    private void CampoTitularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoTitularKeyTyped
        char K;
        K=evt.getKeyChar();
        if(!(K<'0'||K>'9')){
        evt.consume();
    }        // TODO add your handling code here:
    }//GEN-LAST:event_CampoTitularKeyTyped

    private void CampoDeudaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoDeudaKeyReleased

    }//GEN-LAST:event_CampoDeudaKeyReleased

    private void BotonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarActionPerformed
    VerClub.PanelDeudasEquipos.remove(this);
    }//GEN-LAST:event_BotonCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCerrar;
    private javax.swing.JTextField CampoDeuda;
    private javax.swing.JTextArea CampoMotivo;
    private javax.swing.JTextField CampoNombreEquipo;
    private javax.swing.JTextField CampoPago;
    private javax.swing.JTextField CampoTitular;
    private javax.swing.JLabel LabelDetallePagosEquipos;
    private javax.swing.JLabel LabelDeuda;
    private javax.swing.JLabel LabelPago;
    private javax.swing.JLabel LabelSerialEquipo;
    private javax.swing.JLabel LabelTitular;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

 
}
