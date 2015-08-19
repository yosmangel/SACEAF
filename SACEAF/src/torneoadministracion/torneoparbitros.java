

package torneoadministracion;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import torneodatosadm.arbitro;
import torneodatosadm.borrararbitros;
import torneodatosadm.datoarbitro;

public class torneoparbitros extends javax.swing.JPanel {

    static DefaultTableModel modelo;
    static DefaultTableModel modelo1;
    DefaultComboBoxModel masculino= new DefaultComboBoxModel();
    DefaultComboBoxModel femenino= new DefaultComboBoxModel();
    String idcategoria, idtorneo, idcategoriatorneo;
    String serialtorneo,serialcategoria, serialborrart,id_arbitros;
    int ctr;
    public torneoparbitros() {
        initComponents();
        cargartabla();
       campocedula.setEnabled(false);
       camponombre.setEnabled(false);
       bguardar.setEnabled(false);
      
    }

 public void habilitar(){
     campocedula.setEnabled(true);
     camponombre.setEnabled(true);
     bguardar.setEnabled(true);
     bagregar.setEnabled(false);
     beliminar.setEnabled(false);
     bsalir.setEnabled(true);
     
 }
 public static void deshabilitar(){
     campocedula.setEnabled(false);
     camponombre.setEnabled(false);
     bguardar.setEnabled(false);
     bagregar.setEnabled(true);
     beliminar.setEnabled(true);
     bsalir.setEnabled(true);
 }
 public static void cargartabla(){
     
     try{
            String[] titulos={"Cedula","Nombre"};
            String[] registro= new String[2];
            String sql="Select id_arbitro, nombre_arbitro from arbitro;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("id_arbitro");
               registro [1]=rs.getString("nombre_arbitro");
               modelo.addRow(registro);
            }
            tablatarbitros.setModel(modelo);
            tablatarbitros.getColumnModel().getColumn(0).setPreferredWidth(100);
            tablatarbitros.getColumnModel().getColumn(1).setPreferredWidth(162);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            tablatarbitros.setRowSorter(modeloordenado);
            modeloordenado.setRowFilter(RowFilter.regexFilter(filtro.getText()));
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(torneoparbitros.class.getName()).log(Level.SEVERE, null, ex);
                }
     }
 public void guardararbitro(){
    String nombre=camponombre.getText();
    String cedula=campocedula.getText();
       try{
           String sql="Select id_arbitro from arbitro where id_arbitro='"+cedula+"';";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
               ctr=2;
               break;
          } 
       }catch(SQLException | ClassNotFoundException ex){
           Logger.getLogger(torneoparbitros.class.getName()).log(Level.SEVERE,null,ex);
       }
       
             if(ctr==2){
                 JOptionPane.showMessageDialog(this,"La categoria ya esta agregada en el torneo", "Informacion", JOptionPane.INFORMATION_MESSAGE);
              campocedula.setText("");
              camponombre.setText("");
             }else{
      try{
      datoarbitro user= new datoarbitro(cedula,nombre);
      arbitro in = new arbitro();
      boolean r;
      r=in.Insertar(user);
      if(r==false){
         cargartabla();
         campocedula.setText("");
         camponombre.setText("");
         deshabilitar();
      }
      
       }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error "+ e.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(torneoparbitros.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
 }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablatarbitros = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }

        };
        bagregar = new javax.swing.JButton();
        beliminar = new javax.swing.JButton();
        bsalir = new javax.swing.JButton();
        filtro = new javax.swing.JTextField();
        campocedula = new javax.swing.JTextField();
        camponombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bguardar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(630, 290));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(630, 290));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Arbitros en el Torneo");

        tablatarbitros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablatarbitros.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablatarbitros.setOpaque(false);
        jScrollPane1.setViewportView(tablatarbitros);

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

        filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtroKeyReleased(evt);
            }
        });

        campocedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cedula");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre");

        bguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/guardar30x30.png"))); // NOI18N
        bguardar.setText("Guardar");
        bguardar.setContentAreaFilled(false);
        bguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bguardar.setIconTextGap(-2);
        bguardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/guardar40x40.png"))); // NOI18N
        bguardar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bguardarActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(campocedula)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                                .addGap(79, 79, 79)
                                .addComponent(bagregar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(camponombre)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                                        .addGap(58, 58, 58))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(bguardar)
                                        .addGap(95, 95, 95)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bsalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(beliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 466, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(191, 191, 191))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(bagregar)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campocedula, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(beliminar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(camponombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bguardar)
                            .addComponent(bsalir)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
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
        habilitar();
    }//GEN-LAST:event_bagregarActionPerformed

    private void beliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliminarActionPerformed
      
        try{
        String nombre= (String) tablatarbitros.getValueAt(tablatarbitros.getSelectedRow(),1);
        if( nombre != null){
        int opc=JOptionPane.showConfirmDialog(null,"Desea eliminar al arbitro "+nombre+"?", "Informacion",JOptionPane.YES_NO_OPTION);
        if(opc==0){
        id_arbitros=(String) tablatarbitros.getValueAt(tablatarbitros.getSelectedRow(),0);
       
                
                borrararbitros user=new borrararbitros(id_arbitros);
                arbitro in= new arbitro();
                boolean r;
                r=in.Eliminar(user);
                if(r==false){
                 cargartabla();
          }
                
           
        }
        }
        }catch(Exception e){
       JOptionPane.showMessageDialog(null,"Debe seleccionar una categoria para poder Eliminarla","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_beliminarActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
     torneogadministracion.paneltadministracion.remove(this);
     torneogadministracion.habilitar();
    }//GEN-LAST:event_bsalirActionPerformed

    private void filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyReleased
        cargartabla();
        
    }//GEN-LAST:event_filtroKeyReleased

    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        guardararbitro();
    }//GEN-LAST:event_bguardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bagregar;
    public static javax.swing.JButton beliminar;
    public static javax.swing.JButton bguardar;
    public static javax.swing.JButton bsalir;
    public static javax.swing.JTextField campocedula;
    public static javax.swing.JTextField camponombre;
    public static javax.swing.JTextField filtro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablatarbitros;
    // End of variables declaration//GEN-END:variables
}
