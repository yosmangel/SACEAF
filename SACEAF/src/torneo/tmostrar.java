
package torneo;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class tmostrar extends javax.swing.JPanel {

  static DefaultTableModel torneo= new DefaultTableModel(); 
    public tmostrar() {
        initComponents();
        cargartorneo();
    }


    public static void cargartorneo(){
        try{
            String[] titulos={"Nombre del Torneo","Fecha de Inicio", "Fecha de Finalizacion","Tipo de competencia","Sexo"};
            String[] registros= new String[5];
            String sql="Select t.nombre_t, t.fecha_init, t.fecha_fint,d.nombre_disciplina, t.sexo from torneo t, disciplina d where t.id_disciplina=d.id_disciplina order by fecha_init;";
            Conexion parametros=new Conexion();
            Class.forName(parametros.getDriver());
            Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
            torneo=new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                registros [0]= rs.getString("t.nombre_t");
                registros [1]= rs.getString("t.fecha_init");
                registros [2]= rs.getString("t.fecha_fint");
                registros [3]= rs.getString("d.nombre_disciplina");
                registros [4]= rs.getString("t.sexo");                
                torneo.addRow(registros);
            }
            tablatorneo.setModel(torneo);
            tablatorneo.getColumnModel().getColumn(0).setPreferredWidth(168);
            tablatorneo.getColumnModel().getColumn(1).setPreferredWidth(168);
            tablatorneo.getColumnModel().getColumn(2).setPreferredWidth(168);
            tablatorneo.getColumnModel().getColumn(3).setPreferredWidth(168);
            tablatorneo.getColumnModel().getColumn(4).setPreferredWidth(168);
            TableRowSorter modeloordenado = new TableRowSorter(torneo);
            tablatorneo.setRowSorter(modeloordenado);
            modeloordenado.setRowFilter(RowFilter.regexFilter(filtro.getText()));
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(tmostrar.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablatorneo = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }

        };
        filtro = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(840, 288));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(840, 288));
        jPanel1.setOpaque(false);

        tablatorneo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablatorneo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablatorneo.setOpaque(false);
        jScrollPane1.setViewportView(tablatorneo);

        filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtroKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 635, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyReleased
        cargartorneo();
    }//GEN-LAST:event_filtroKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField filtro;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablatorneo;
    // End of variables declaration//GEN-END:variables
}
