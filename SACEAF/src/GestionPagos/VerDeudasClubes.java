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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
public class VerDeudasClubes extends javax.swing.JPanel {

    static DefaultTableModel Modelo;
    static DefaultTableModel Modelo2;
    public VerDeudasClubes() {
        initComponents();
        MostrarDeudasClubes();
    }

   public static void MostrarDeudasClubes(){
       
         try{
             String[] TitulosColumnas={"Serial del Club", "Nombre del Club", "Deuda del Club (BsF)"};
             String[] Columna = new String[3];
             String SQL="SELECT Club.id_Club, Club.nombre_club, Sum(Deuda.Monto_Deuda_restante) from Club inner join deuda on Club.id_club=Deuda.id_club inner join Equipo on Equipo.id_equipo=deuda.id_equipo group by id_club";
             Conexion parametro = new Conexion();
             Class.forName(parametro.getDriver());
             Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
             Modelo = new DefaultTableModel(null,TitulosColumnas);
             Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs=st.executeQuery(SQL);
              while(rs.next()){
               Columna [0]=rs.getString("id_club");
               Columna [1]=rs.getString("nombre_club");
               Columna [2]=rs.getString("Sum(Deuda.monto_deuda_restante)");
               Modelo.addRow(Columna);
            }
             
            TablaDeudasClubes.setModel(Modelo);
            TablaDeudasClubes.getColumnModel().getColumn(0).setPreferredWidth(40);
            TablaDeudasClubes.getColumnModel().getColumn(1).setPreferredWidth(100);
            TablaDeudasClubes.getColumnModel().getColumn(2).setPreferredWidth(100);
            TableRowSorter TablaFiltro = new TableRowSorter(Modelo);
            TablaDeudasClubes.setRowSorter(TablaFiltro);
            TablaFiltro.setRowFilter(RowFilter.regexFilter(CampoFiltro.getText()));
           
         }catch(SQLException ex){
                Logger.getLogger(VerDeudasEquipos.class.getName()).log(Level.SEVERE, null, ex);
                }catch(ClassNotFoundException e){
                Logger.getLogger(VerDeudasEquipos.class.getName()).log(Level.SEVERE,null,e);
                        }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelDeudasClubes = new javax.swing.JLabel();
        PanelDeudasClubes = new javax.swing.JScrollPane();
        TablaDeudasClubes = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        CampoFiltro = new javax.swing.JTextField();

        setOpaque(false);

        LabelDeudasClubes.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LabelDeudasClubes.setText("Deudas de Clubes");

        TablaDeudasClubes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        PanelDeudasClubes.setViewportView(TablaDeudasClubes);

        CampoFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CampoFiltroKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CampoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelDeudasClubes)
                        .addGap(324, 324, 324))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelDeudasClubes, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelDeudasClubes)
                    .addComponent(CampoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(PanelDeudasClubes, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CampoFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoFiltroKeyReleased
        MostrarDeudasClubes();
    }//GEN-LAST:event_CampoFiltroKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField CampoFiltro;
    private javax.swing.JLabel LabelDeudasClubes;
    public static javax.swing.JScrollPane PanelDeudasClubes;
    public static javax.swing.JTable TablaDeudasClubes;
    // End of variables declaration//GEN-END:variables
}
