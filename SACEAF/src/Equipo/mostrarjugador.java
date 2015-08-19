
package Equipo;

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


public class mostrarjugador extends javax.swing.JPanel {

    static DefaultTableModel jugadores= new DefaultTableModel();
    public mostrarjugador() {
        initComponents();
        cargarjugadores();
    }

   
    public static void cargarjugadores(){
        String serial=(String) mostrarequipo.tablaequipos.getValueAt(mostrarequipo.tablaequipos.getSelectedRow(),0);
        try{
            String[] titulos= {"Cedula", "Nombre","Apellido","Fecha de Nacimiento","Ficha","Bloqueo"};
            String[] registros= new String[6];
            String sql="Select jugador.cedula, jugador.nombre_j, jugador.apellido_j, jugador.fecha_nacimiento, jugador.n_ficha, jugador.bloqueo_j from jugador where jugador.id_equipo='"+serial+"';";
            Conexion parametros=new Conexion();
            Class.forName(parametros.getDriver());
            Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
            jugadores = new DefaultTableModel(null,titulos);
            Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                registros [0]=rs.getString("jugador.cedula");
                registros [1]=rs.getString("jugador.nombre_j");
                registros [2]=rs.getString("jugador.apellido_j");
                registros [3]=rs.getString("jugador.fecha_nacimiento");
                registros [4]=rs.getString("jugador.n_ficha");
                registros [5]=rs.getString("jugador.bloqueo_j");
                jugadores.addRow(registros);
            }
            tablajugadores.setModel(jugadores);
            tablajugadores.getColumnModel().getColumn(0).setPreferredWidth(138);
            tablajugadores.getColumnModel().getColumn(1).setPreferredWidth(140);
            tablajugadores.getColumnModel().getColumn(2).setPreferredWidth(140);
            tablajugadores.getColumnModel().getColumn(3).setPreferredWidth(138);
            tablajugadores.getColumnModel().getColumn(4).setPreferredWidth(140);
            tablajugadores.getColumnModel().getColumn(5).setPreferredWidth(138);
            TableRowSorter modeloordenado= new TableRowSorter(jugadores);
            tablajugadores.setRowSorter(modeloordenado);
            modeloordenado.setRowFilter(RowFilter.regexFilter(filtro.getText()));
        }catch(SQLException ex){
            Logger.getLogger(mostrarjugador.class.getName()).log(Level.SEVERE,null,ex);
        }catch(ClassNotFoundException e){
            Logger.getLogger(mostrarjugador.class.getName()).log(Level.SEVERE,null,e);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablajugadores = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }

        }
        ;
        filtro = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(850, 305));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(850, 305));
        jPanel1.setOpaque(false);

        tablajugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablajugadores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablajugadores.setOpaque(false);
        jScrollPane1.setViewportView(tablajugadores);

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
                        .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 663, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
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
        cargarjugadores();
    }//GEN-LAST:event_filtroKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField filtro;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablajugadores;
    // End of variables declaration//GEN-END:variables
}
