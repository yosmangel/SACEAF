

package Administracion;

import Basededatos.Conexion;
import Datosadministracion.categoria;
import Datosadministracion.datoeliminar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class pcategoria extends javax.swing.JPanel {

    static DefaultTableModel modelo;
    static DefaultTableModel modelo1;
    public pcategoria() {
        initComponents();
         cargarmasculino();
        rmasculino.setSelected(true);
      
    }

 public static void habilitar(){
     bagregar.setEnabled(true);
     beliminar.setEnabled(true);
     bsalir.setEnabled(true);
     tablacategoria.setEnabled(true);
     
 }
 public static void deshabilitar(){
     bagregar.setEnabled(false);
     beliminar.setEnabled(false);
     bsalir.setEnabled(false);
     tablacategoria.setEnabled(false);
 }
    public static void cargarmasculino(){
         try{
            String[] titulos={"Serial", "Nombre", "Año inicio", "Año final"};
            String[] registro= new String[4];
            String sql="Select id_categoria, nombre_cat, year_final, year_ini from categoria where sexo='Masculino';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("id_categoria");
               registro [1]=rs.getString("nombre_cat");
               registro [2]=rs.getString("year_final");
               registro [3]=rs.getString("year_ini");
               modelo.addRow(registro);
            }
            tablacategoria.setModel(modelo);
            tablacategoria.getColumnModel().getColumn(0).setPreferredWidth(126);
            tablacategoria.getColumnModel().getColumn(1).setPreferredWidth(126);
            tablacategoria.getColumnModel().getColumn(2).setPreferredWidth(126);
            tablacategoria.getColumnModel().getColumn(3).setPreferredWidth(126);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            tablacategoria.setRowSorter(modeloordenado);
            modeloordenado.setRowFilter(RowFilter.regexFilter(filtro.getText()));
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(pcategoria.class.getName()).log(Level.SEVERE, null, ex);
                }
     }
    public static void cargarfemenino(){
        
            try{
            String[] titulos={"Serial", "Nombre", "Año inicio", "Año final"};
            String[] registro= new String[4];
            String sql="Select id_categoria, nombre_cat, year_final, year_ini from categoria where sexo='Femenino';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo1= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("id_categoria");
               registro [1]=rs.getString("nombre_cat");
               registro [2]=rs.getString("year_final");
               registro [3]=rs.getString("year_ini");
               modelo1.addRow(registro);
            }
            tablacategoria.setModel(modelo1);
            tablacategoria.getColumnModel().getColumn(0).setPreferredWidth(126);
            tablacategoria.getColumnModel().getColumn(1).setPreferredWidth(126);
            tablacategoria.getColumnModel().getColumn(2).setPreferredWidth(126);
            tablacategoria.getColumnModel().getColumn(3).setPreferredWidth(126);
            TableRowSorter modeloordenado= new TableRowSorter(modelo1);
            tablacategoria.setRowSorter(modeloordenado);
            modeloordenado.setRowFilter(RowFilter.regexFilter(filtro.getText()));
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(pcategoria.class.getName()).log(Level.SEVERE, null, ex);
                }
        
       
    }
    public void agregarcategoria(){
    
        agregarcategoria agc=new agregarcategoria();
        String titulo="Agregar categoria";
        int index= Gadministracion.paneladministracion.indexOfTab(titulo);
        if(index==-1){
            Gadministracion.paneladministracion.add(titulo,agc);
            int i= Gadministracion.paneladministracion.indexOfTab(titulo);
            Gadministracion.paneladministracion.setSelectedIndex(i);
        }else{
            Gadministracion.paneladministracion.remove(index);
            Gadministracion.paneladministracion.add(titulo,agc);
            int i=Gadministracion.paneladministracion.indexOfTab(titulo);
            Gadministracion.paneladministracion.setSelectedIndex(i);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablacategoria = new javax.swing.JTable();
        bagregar = new javax.swing.JButton();
        beliminar = new javax.swing.JButton();
        bsalir = new javax.swing.JButton();
        rmasculino = new javax.swing.JRadioButton();
        rfemenino = new javax.swing.JRadioButton();
        filtro = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(630, 290));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(630, 290));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Categorias");

        tablacategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablacategoria.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablacategoria.setOpaque(false);
        jScrollPane1.setViewportView(tablacategoria);

        bagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Add 30x30.png"))); // NOI18N
        bagregar.setText("Agregar");
        bagregar.setContentAreaFilled(false);
        bagregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bagregar.setIconTextGap(-2);
        bagregar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Add 40x40.png"))); // NOI18N
        bagregar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bagregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bagregarActionPerformed(evt);
            }
        });

        beliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Delete 30x30.png"))); // NOI18N
        beliminar.setText("Eliminar");
        beliminar.setContentAreaFilled(false);
        beliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        beliminar.setIconTextGap(-2);
        beliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Delete 40x40.png"))); // NOI18N
        beliminar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        beliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        beliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beliminarActionPerformed(evt);
            }
        });

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

        rmasculino.setText("Masculino");
        rmasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmasculinoActionPerformed(evt);
            }
        });

        rfemenino.setText("Femenino");
        rfemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rfemeninoActionPerformed(evt);
            }
        });

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rmasculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rfemenino)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bagregar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(bsalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(beliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(226, 226, 226)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rfemenino)
                            .addComponent(rmasculino))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bagregar)
                        .addGap(18, 18, 18)
                        .addComponent(beliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(bsalir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(19, 19, 19))
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

    private void bagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagregarActionPerformed
        agregarcategoria();
        deshabilitar();
    }//GEN-LAST:event_bagregarActionPerformed

    private void beliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliminarActionPerformed
        String serial=(String) tablacategoria.getValueAt(tablacategoria.getSelectedRow(),0);
        String nombre= (String) tablacategoria.getValueAt(tablacategoria.getSelectedRow(),1);
        if( serial != null){
        int opc=JOptionPane.showConfirmDialog(null,"Desea eliminar la categoria "+nombre+"?", "Informacion",JOptionPane.YES_NO_OPTION);
        if(opc==0){
            try{
                datoeliminar user=new datoeliminar(serial);
                categoria in= new categoria();
                boolean r;
                r=in.Eliminar(user);
                if(r==false){
                    cargarmasculino();
                    cargarfemenino();
                }
                
            }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(pcategoria.class.getName()).log(Level.SEVERE,null, ex);
            }
        }
        }else{
            JOptionPane.showConfirmDialog(null,"Debe seleccionar una categoria para poder Eliminar","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_beliminarActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
     Gadministracion.paneladministracion.remove(this);
     Gadministracion.habilitar();
    }//GEN-LAST:event_bsalirActionPerformed

    private void rmasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmasculinoActionPerformed
         cargarmasculino();   
        rmasculino.setSelected(true);
           
        if(rmasculino.isSelected()==true){
            cargarmasculino();
            rfemenino.setSelected(false);
        }
    }//GEN-LAST:event_rmasculinoActionPerformed

    private void rfemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rfemeninoActionPerformed
       cargarfemenino();
        rfemenino.setSelected(true);
       
        if(rfemenino.isSelected()==true){
           cargarfemenino();
            rmasculino.setSelected(false);
        }
    }//GEN-LAST:event_rfemeninoActionPerformed

    private void filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyReleased
        if(rmasculino.isSelected()==true){
            cargarmasculino();
        }else{
            cargarfemenino();
        }
        
    }//GEN-LAST:event_filtroKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bagregar;
    public static javax.swing.JButton beliminar;
    public static javax.swing.JButton bsalir;
    public static javax.swing.JTextField filtro;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JRadioButton rfemenino;
    public static javax.swing.JRadioButton rmasculino;
    public static javax.swing.JTable tablacategoria;
    // End of variables declaration//GEN-END:variables
}
