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
public class VerDeudasEquipos extends javax.swing.JPanel {

    static DefaultTableModel Modelo;
    public VerDeudasEquipos() {
        initComponents();
        MostrarEquiposDeudores();
    }

    public static void MostrarEquiposDeudores(){
    String Club=(String) VerDeudasClubes.TablaDeudasClubes.getValueAt(VerDeudasClubes.TablaDeudasClubes.getSelectedRow(),0);

         try{
             String[] TitulosColumnas={"Serial del Equipo", "Categoría", "Deuda del Equipo (BsF)"};
             String[] Columna = new String[3];
             String SQL= "SELECT Equipo.id_equipo, Categoria.nombre_cat, Sum(Deuda.monto_deuda_restante) FROM Equipo INNER JOIN Categoria ON Equipo.id_categoria=Categoria.id_categoria INNER JOIN Deuda ON Equipo.id_equipo=Deuda.id_equipo WHERE Deuda.id_club='"+Club+"' and monto_deuda_restante>0 group by Equipo.id_equipo";
             Conexion parametro = new Conexion();
             Class.forName(parametro.getDriver());
             Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
             Modelo = new DefaultTableModel(null,TitulosColumnas);
             Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs=st.executeQuery(SQL);
              while(rs.next()){
               Columna [0]=rs.getString("id_equipo");
               Columna [1]=rs.getString("nombre_cat");
               Columna [2]=rs.getString("Sum(Deuda.monto_deuda_restante)");
               Modelo.addRow(Columna);
            }
             
            TablaDeudasEquipos.setModel(Modelo);
            TablaDeudasEquipos.getColumnModel().getColumn(0).setPreferredWidth(100);
            TablaDeudasEquipos.getColumnModel().getColumn(1).setPreferredWidth(100);
            TablaDeudasEquipos.getColumnModel().getColumn(2).setPreferredWidth(100);
           
         }catch(SQLException ex){
                Logger.getLogger(VerDeudasEquipos.class.getName()).log(Level.SEVERE, null, ex);
                }catch(ClassNotFoundException e){
                Logger.getLogger(VerDeudasEquipos.class.getName()).log(Level.SEVERE,null,e);
                        }
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelEquipos = new javax.swing.JLabel();
        PanelDeudasEquipos = new javax.swing.JScrollPane();
        TablaDeudasEquipos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };

        setOpaque(false);

        LabelEquipos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LabelEquipos.setText("Deudas de sus Equipos");

        TablaDeudasEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        PanelDeudasEquipos.setViewportView(TablaDeudasEquipos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelDeudasEquipos)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(LabelEquipos)
                .addContainerGap(282, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LabelEquipos)
                .addGap(29, 29, 29)
                .addComponent(PanelDeudasEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelEquipos;
    private javax.swing.JScrollPane PanelDeudasEquipos;
    public static javax.swing.JTable TablaDeudasEquipos;
    // End of variables declaration//GEN-END:variables
}
