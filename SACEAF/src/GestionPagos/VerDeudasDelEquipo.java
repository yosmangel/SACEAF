/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionPagos;

import Basededatos.Conexion;
import static GestionPagos.VerDeudasEquipos.TablaDeudasEquipos;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author Kevin_000
 */
public class VerDeudasDelEquipo extends javax.swing.JPanel {

    static DefaultTableModel Modelo;
    public VerDeudasDelEquipo() {
        initComponents();
        MostrarDeudasDelEquipo();
    }

   public static void MostrarDeudasDelEquipo(){
       String Club=(String) VerDeudasClubes.TablaDeudasClubes.getValueAt(VerDeudasClubes.TablaDeudasClubes.getSelectedRow(),0);
       String Equipo=(String) VerDeudasEquipos.TablaDeudasEquipos.getValueAt(VerDeudasEquipos.TablaDeudasEquipos.getSelectedRow(),0);

         try{
             String[] TitulosColumnas={"Serial del Equipo", "Categoría", "Deuda del Equipo (BsF)", "Motivo de la Deuda", "Nro Deuda"};
             String[] Columna = new String[5];
             String SQL= "SELECT Equipo.id_equipo, Categoria.nombre_cat, Deuda.monto_deuda_restante, Deuda.motivo_deuda, Deuda.id_deuda FROM Equipo INNER JOIN Categoria ON Equipo.id_categoria=Categoria.id_categoria INNER JOIN Deuda ON Equipo.id_equipo=Deuda.id_equipo WHERE Deuda.id_club='"+Club+"' and monto_deuda_restante>0 and Equipo.id_equipo='"+Equipo+"';";
             Conexion parametro = new Conexion();
             Class.forName(parametro.getDriver());
             Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
             Modelo = new DefaultTableModel(null,TitulosColumnas);
             Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs=st.executeQuery(SQL);
              while(rs.next()){
               Columna [0]=rs.getString("id_equipo");
               Columna [1]=rs.getString("nombre_cat");
               Columna [2]=rs.getString("monto_deuda_restante");
               Columna [3]=rs.getString("motivo_deuda");
               Columna [4]=rs.getString("id_deuda");
               Modelo.addRow(Columna);
            }
             
            TablaDeudasDelEquipo.setModel(Modelo);
            TablaDeudasDelEquipo.getColumnModel().getColumn(0).setPreferredWidth(100);
            TablaDeudasDelEquipo.getColumnModel().getColumn(1).setPreferredWidth(100);
            TablaDeudasDelEquipo.getColumnModel().getColumn(2).setPreferredWidth(100);
            TablaDeudasDelEquipo.getColumnModel().getColumn(3).setPreferredWidth(100);
            TablaDeudasDelEquipo.getColumnModel().getColumn(4).setPreferredWidth(30);
           
         }catch(SQLException ex){
                Logger.getLogger(VerDeudasDelEquipo.class.getName()).log(Level.SEVERE, null, ex);
                }catch(ClassNotFoundException e){
                Logger.getLogger(VerDeudasDelEquipo.class.getName()).log(Level.SEVERE,null,e);
                        }
   }
     public void AbrirCancelarPagos(){
    
        AgregarPago AP=new AgregarPago();
        String titulo="Cancelar Pago";
        int index= VerClub.PanelDeudasEquipos.indexOfTab(titulo);
        if(index==-1){
            VerClub.PanelDeudasEquipos.add(titulo,AP);
            int i= VerClub.PanelDeudasEquipos.indexOfTab(titulo);
            VerClub.PanelDeudasEquipos.setSelectedIndex(i);
        }else{
           VerClub.PanelDeudasEquipos.remove(index);
            VerClub.PanelDeudasEquipos.add(titulo,AP);
            int i=VerClub.PanelDeudasEquipos.indexOfTab(titulo);
            VerClub.PanelDeudasEquipos.setSelectedIndex(i);
        }
    }
     public static void DeshabilitarBotones(){
         BotonCerrar.setEnabled(false);
         BotonRealizarPago.setEnabled(false);
     }
     public static void HabilitarBotones(){
         BotonCerrar.setEnabled(true);
         BotonRealizarPago.setEnabled(true);
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        PanelDeudasDelEquipo = new javax.swing.JScrollPane();
        TablaDeudasDelEquipo = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        BotonRealizarPago = new javax.swing.JButton();
        BotonCerrar = new javax.swing.JButton();

        setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Deudas del Equipo");

        TablaDeudasDelEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        PanelDeudasDelEquipo.setViewportView(TablaDeudasDelEquipo);

        BotonRealizarPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/RealizarPago230x30.png"))); // NOI18N
        BotonRealizarPago.setText("Realizar Pago");
        BotonRealizarPago.setBorder(null);
        BotonRealizarPago.setBorderPainted(false);
        BotonRealizarPago.setContentAreaFilled(false);
        BotonRealizarPago.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonRealizarPago.setIconTextGap(-2);
        BotonRealizarPago.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/RealizarPago240x40.png"))); // NOI18N
        BotonRealizarPago.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonRealizarPago.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonRealizarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRealizarPagoActionPerformed(evt);
            }
        });

        BotonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 30x30.png"))); // NOI18N
        BotonCerrar.setText("Cerrar");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelDeudasDelEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonRealizarPago, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(BotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(BotonRealizarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(PanelDeudasDelEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonRealizarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRealizarPagoActionPerformed
         if(TablaDeudasDelEquipo.getSelectedRows().length > 0 ){
        AbrirCancelarPagos();
        DeshabilitarBotones();
        
        
    }
    else{
     JOptionPane.showMessageDialog(this,"Debe Seleccionar una Deuda para Realizar el Pago del Equipo Correspondiente","Información", JOptionPane.INFORMATION_MESSAGE);
 
   }
    }//GEN-LAST:event_BotonRealizarPagoActionPerformed

    private void BotonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarActionPerformed
        VerClub.PanelDeudasEquipos.remove(this);
        VerClub.HabilitarBotones();
                
    }//GEN-LAST:event_BotonCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton BotonCerrar;
    public static javax.swing.JButton BotonRealizarPago;
    private javax.swing.JScrollPane PanelDeudasDelEquipo;
    public static javax.swing.JTable TablaDeudasDelEquipo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
