/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPagos;
import Basededatos.Conexion;
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
public class VerPagosEquipos extends javax.swing.JPanel {

    static DefaultTableModel Modelo2;
    public VerPagosEquipos() {
        initComponents();
        MostrarPagosEquipos();
    }

    public static void MostrarPagosEquipos(){
        String Club=(String) VerDeudasClubes.TablaDeudasClubes.getValueAt(VerDeudasClubes.TablaDeudasClubes.getSelectedRow(),0);
         try{
             String[] TitulosColumnas={"Serial del Equipo", "Fecha de Pago", "Hora de Pago", "Titular", "Motivo del Pago", "Monto Total a Pagar", "Pago Efectuado"};
             String[] Columna = new String[8];
             String SQL="SELECT equipo.id_equipo, pagos.Fecha_Pago, pagos.Hora_Pago, pagos.titular_pago, pagos.motivo_pago, pagos.monto_total_pagar, pagos.pago_efectuado from pagos inner join equipo where pagos.id_equipo=equipo.id_equipo and pagos.id_club='"+Club+"';";
             Conexion parametro = new Conexion();
             Class.forName(parametro.getDriver());
             Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
             Modelo2 = new DefaultTableModel(null,TitulosColumnas);
             Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs=st.executeQuery(SQL);
              while(rs.next()){
               Columna [0]=rs.getString("id_equipo");
               Columna [1]=rs.getString("Fecha_Pago");
               Columna [2]=rs.getString("Hora_Pago");
               Columna [3]=rs.getString("titular_pago");
               Columna [4]=rs.getString("motivo_pago");
               Columna [5]=rs.getString("monto_total_pagar");
               Columna [6]=rs.getString("pago_efectuado");
               
               Modelo2.addRow(Columna);
            }
             
            TablaPagosEquipos.setModel(Modelo2);
            TablaPagosEquipos.getColumnModel().getColumn(0).setPreferredWidth(40);
            TablaPagosEquipos.getColumnModel().getColumn(1).setPreferredWidth(20);
            TablaPagosEquipos.getColumnModel().getColumn(2).setPreferredWidth(20);
            TablaPagosEquipos.getColumnModel().getColumn(3).setPreferredWidth(30);
            TablaPagosEquipos.getColumnModel().getColumn(4).setPreferredWidth(40);
            TablaPagosEquipos.getColumnModel().getColumn(5).setPreferredWidth(40);
            TablaPagosEquipos.getColumnModel().getColumn(6).setPreferredWidth(40);
         }catch(SQLException ex){
                Logger.getLogger(VerPagosEquipos.class.getName()).log(Level.SEVERE, null, ex);
                }catch(ClassNotFoundException e){
                Logger.getLogger(VerPagosEquipos.class.getName()).log(Level.SEVERE,null,e);
                        }
}
   public void VerDetallesPagos(){
    
        VerDetallesPago VDP=new VerDetallesPago();
        String titulo="Detalles del Pago";
        int index= VerClub.PanelDeudasEquipos.indexOfTab(titulo);
        if(index==-1){
            VerClub.PanelDeudasEquipos.add(titulo,VDP);
            int i= VerClub.PanelDeudasEquipos.indexOfTab(titulo);
            VerClub.PanelDeudasEquipos.setSelectedIndex(i);
        }else{
            VerClub.PanelDeudasEquipos.remove(index);
            VerClub.PanelDeudasEquipos.add(titulo,VDP);
            int i=VerClub.PanelDeudasEquipos.indexOfTab(titulo);
            VerClub.PanelDeudasEquipos.setSelectedIndex(i);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelPagosEquipos = new javax.swing.JLabel();
        PanelPagosEquipos = new javax.swing.JScrollPane();
        TablaPagosEquipos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        BotonVerDetallesPagos = new javax.swing.JButton();
        BotonCerrar = new javax.swing.JButton();

        setOpaque(false);

        LabelPagosEquipos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LabelPagosEquipos.setText("Pagos de Equipos");

        TablaPagosEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        PanelPagosEquipos.setViewportView(TablaPagosEquipos);

        BotonVerDetallesPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/entrar30x30.png"))); // NOI18N
        BotonVerDetallesPagos.setText("Ver Detalles");
        BotonVerDetallesPagos.setBorder(null);
        BotonVerDetallesPagos.setBorderPainted(false);
        BotonVerDetallesPagos.setContentAreaFilled(false);
        BotonVerDetallesPagos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonVerDetallesPagos.setIconTextGap(-2);
        BotonVerDetallesPagos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/entrar40x40.png"))); // NOI18N
        BotonVerDetallesPagos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonVerDetallesPagos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonVerDetallesPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVerDetallesPagosActionPerformed(evt);
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
                .addComponent(PanelPagosEquipos, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BotonVerDetallesPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(LabelPagosEquipos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(LabelPagosEquipos)
                        .addGap(35, 35, 35)
                        .addComponent(PanelPagosEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(BotonVerDetallesPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonVerDetallesPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVerDetallesPagosActionPerformed

        if(TablaPagosEquipos.getSelectedRows().length > 0 ){

            VerDetallesPagos();

        }
        else{
            JOptionPane.showMessageDialog(this,"Debe Seleccionar un Pago Para Ver Sus Detalles","Información", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_BotonVerDetallesPagosActionPerformed

    private void BotonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarActionPerformed
      VerClub.PanelDeudasEquipos.remove(this);
      VerClub.HabilitarBotones();
    }//GEN-LAST:event_BotonCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCerrar;
    private javax.swing.JButton BotonVerDetallesPagos;
    private javax.swing.JLabel LabelPagosEquipos;
    private javax.swing.JScrollPane PanelPagosEquipos;
    public static javax.swing.JTable TablaPagosEquipos;
    // End of variables declaration//GEN-END:variables
}
