
package Estadisticas;

import Basededatos.Conexion;
import static Estadisticas.Gestadisticas.panelestadisticas;
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

public class pgraficas extends javax.swing.JPanel {

    static DefaultTableModel modelo;
       
    public pgraficas() {
        initComponents();
        cargarestadisticas(); 
    }
        
    public static void cargarestadisticas(){
         try{
            String[] titulos={"Nombre Estadistica", "Total"};
            String[] registro= new String[2];
            String sql="SELECT nombre_estadisticas, total FROM estadisticas;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("nombre_estadisticas");
               registro [1]=rs.getString("total");
               
               modelo.addRow(registro);
            }
            tablaestadisticas.setModel(modelo);
            tablaestadisticas.getColumnModel().getColumn(0).setPreferredWidth(126);
            tablaestadisticas.getColumnModel().getColumn(1).setPreferredWidth(126);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            tablaestadisticas.setRowSorter(modeloordenado);
            modeloordenado.setRowFilter(RowFilter.regexFilter(filtro.getText()));
            }catch(SQLException ex){
                Logger.getLogger(pgraficas.class.getName()).log(Level.SEVERE, null, ex);
            }catch(ClassNotFoundException e){
                Logger.getLogger(pgraficas.class.getName()).log(Level.SEVERE,null,e);
            }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaestadisticas = new javax.swing.JTable();
        bsalir = new javax.swing.JButton();
        filtro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        GenerarGrafica = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(630, 318));
        setMinimumSize(new java.awt.Dimension(630, 318));
        setOpaque(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(630, 318));
        jPanel1.setMinimumSize(new java.awt.Dimension(630, 318));
        jPanel1.setOpaque(false);

        tablaestadisticas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaestadisticas.setOpaque(false);
        jScrollPane1.setViewportView(tablaestadisticas);

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

        filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtroKeyReleased(evt);
            }
        });

        jLabel2.setText("Buscar");

        GenerarGrafica.setText("Generar");
        GenerarGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarGraficaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(GenerarGrafica)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(bsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GenerarGrafica))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
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

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
     Gestadisticas.panelestadisticas.remove(this);
    }//GEN-LAST:event_bsalirActionPerformed

    private void filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyReleased
        cargarestadisticas();        
    }//GEN-LAST:event_filtroKeyReleased
    
     public void mostrargraficas(){
        Graficas p=new Graficas();
        String titulo="Graficas";
        int index =panelestadisticas.indexOfTab(titulo);
        if(index == -1){
           panelestadisticas.add(titulo,p);
           int i= panelestadisticas.indexOfTab(titulo);
           panelestadisticas.setSelectedIndex(i);
       }else{
           panelestadisticas.remove(index);
           panelestadisticas.add(titulo,p);
           int i=panelestadisticas.indexOfTab(titulo);
           panelestadisticas.setSelectedIndex(i);
       }
    }
     
    private void GenerarGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarGraficaActionPerformed
            mostrargraficas();
    }//GEN-LAST:event_GenerarGraficaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GenerarGrafica;
    public static javax.swing.JButton bsalir;
    public static javax.swing.JTextField filtro;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaestadisticas;
    // End of variables declaration//GEN-END:variables
}
