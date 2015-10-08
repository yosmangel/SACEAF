
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
import saceaf.Principal;
import torneodatosadm.datoborrart;
import torneodatosadm.datosexception;
import torneodatosadm.exception;
import torneodatosadm.torneocategoria;

public final class torneopexception extends javax.swing.JPanel {

    static DefaultTableModel modelo;
    static DefaultTableModel modelo1;
    DefaultComboBoxModel masculino= new DefaultComboBoxModel();
    DefaultComboBoxModel femenino= new DefaultComboBoxModel();
    String idcategoria, idtorneo, idcategoriatorneo,serialtorneo,serialcategoria, serialborrart,ValidException;
    int ctr,edad;
    
    public torneopexception() {
        initComponents();
        cargartabla();
        cargarcombo();
        habilitarBPrimarios();
        deshabilitarBSecundario();
    }

    public static void habilitarBPrimarios(){
        beliminar.setEnabled(true);
        bsalir.setEnabled(true);
        tablatcategoria.setEnabled(true);
    }
    public static void deshabilitarBPrimarios(){
        beliminar.setEnabled(false);
        bsalir.setEnabled(false);
        tablatcategoria.setEnabled(false);
    }
    public static void habilitarBSecundario(){
        bguardar.setEnabled(true);
        combocategorias.setEnabled(true);
        campoEdad.setEnabled(true);

    }
    public static void deshabilitarBSecundario(){

        bguardar.setEnabled(false);
        combocategorias.setEnabled(false);
        campoEdad.setEnabled(false);
    }
    public static void cargartabla(){
        String sexo=Principal.labelsexo.getText();
        String idtorneo=Principal.labelserialtorneo.getText();
        try{
               String[] titulos={"Nombre","Edad"};
               String[] registro= new String[2];
               String sql="Select c.nombre_cat , ex.edad from categoria c, categoria_torneo ct, exceptionj ex  where c.id_categoria= ct.id_categoria and ct.id_torneo='"+idtorneo+"' and c.sexo='"+sexo+"' and c.id_categoria=ex.id_exceptionj and ex.torneo='"+idtorneo+"';";
               Conexion parametro= new Conexion();
               Class.forName(parametro.getDriver());
               Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
               modelo= new DefaultTableModel(null,titulos);
               Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
               ResultSet rs=st.executeQuery(sql);
               while(rs.next()){
                  registro [0]=rs.getString("c.nombre_cat");
                  registro [1]=rs.getString("ex.edad");
                  modelo.addRow(registro);
               }
               tablatcategoria.setModel(modelo);
               tablatcategoria.getColumnModel().getColumn(0).setPreferredWidth(131);
               tablatcategoria.getColumnModel().getColumn(1).setPreferredWidth(131);
               TableRowSorter modeloordenado= new TableRowSorter(modelo);
               tablatcategoria.setRowSorter(modeloordenado);
               modeloordenado.setRowFilter(RowFilter.regexFilter(filtro.getText()));

           }catch(SQLException | ClassNotFoundException ex){
                   Logger.getLogger(torneopexception.class.getName()).log(Level.SEVERE, null, ex);
                   }
        }
    public void cargarcombo(){
           combocategorias.removeAllItems();
        String sexo=Principal.labelsexo.getText();
           try{
               Conexion parametros =new Conexion();
               Class.forName(parametros.getDriver());
               Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
               Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
               ResultSet rs=st.executeQuery("Select nombre_cat from categoria where sexo='"+sexo+"'");
               femenino.addElement("Elige la categoria");
               combocategorias.setModel(femenino);                    
               while(rs.next()){
                   femenino.addElement(rs.getObject("nombre_cat"));
                   combocategorias.setModel(femenino);
               }
               st.close();

           }catch(SQLException | ClassNotFoundException ex){
               Logger.getLogger(torneopexception.class.getName()).log(Level.SEVERE,null,ex);
           }
       }
    public void guardardatosexception(){
        idtorneo=Principal.labelserialtorneo.getText();
        try{
        datosexception de = new datosexception(serialcategoria,edad,idtorneo);
        exception in= new exception();
        boolean r;
        r=in.Insertar(de);
        if(r==false){
            torneopexception.campoEdad.setText("");
            combocategorias.removeAllItems();
            cargarcombo();
            deshabilitarBSecundario();
            habilitarBPrimarios();
            cargartabla();
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error "+ e.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(torneopexception.class.getName()).log(Level.SEVERE,null,ex);
        }
            
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablatcategoria = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }

        };
        bagregar = new javax.swing.JButton();
        beliminar = new javax.swing.JButton();
        bsalir = new javax.swing.JButton();
        filtro = new javax.swing.JTextField();
        combocategorias = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        campoEdad = new javax.swing.JTextField();
        bguardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(630, 290));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(630, 290));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Excepciones en el torneo");

        tablatcategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablatcategoria.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablatcategoria.setOpaque(false);
        jScrollPane1.setViewportView(tablatcategoria);

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Edad");

        campoEdad.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Categoría");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addComponent(jLabel1))
                            .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(bguardar)
                                            .addComponent(campoEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(104, 104, 104)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(beliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bsalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(combocategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(bagregar)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(combocategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bagregar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(beliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bsalir))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bguardar))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
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
        if(torneopexception.bguardar.isEnabled()==true){
            deshabilitarBSecundario();
            habilitarBPrimarios();
        }else{
            habilitarBSecundario();
            deshabilitarBPrimarios();
        }
    }//GEN-LAST:event_bagregarActionPerformed

    private void beliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliminarActionPerformed
     try{
         String nombre= (String) tablatcategoria.getValueAt(tablatcategoria.getSelectedRow(),0);
        if( nombre != null){
        int opc=JOptionPane.showConfirmDialog(null,"Desea eliminar la excepción de la categoria "+nombre+"?", "Informacion",JOptionPane.YES_NO_OPTION);
        if(opc==0){
     
         try{
           String sql="Select id_categoria from categoria where nombre_cat='"+nombre+"'";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
               serialcategoria=rs.getString("id_categoria");
               break;
          } 
       }catch(SQLException | ClassNotFoundException ex){
           Logger.getLogger(torneopexception.class.getName()).log(Level.SEVERE,null,ex);
        }
         
          try{
                edad=0;
                idtorneo="";
                datosexception de = new datosexception(serialcategoria,edad,idtorneo);
                exception in= new exception();
                boolean r;
                r=in.Eliminar(de);
                if(r==false){
                 cargartabla();
          }
                
                
            }catch(SQLException ex){
                Logger.getLogger(torneopexception.class.getName()).log(Level.SEVERE,null, ex);
            }catch(ClassNotFoundException e){
                Logger.getLogger(torneopexception.class.getName()).log(Level.SEVERE, null,e);
            }
         
        }
        }
         }catch(Exception e){
       JOptionPane.showMessageDialog(null,"Debe seleccionar una excepción para poder Eliminarla","Informacion", JOptionPane.INFORMATION_MESSAGE);
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
        
        String categoria=torneopexception.combocategorias.getSelectedItem().toString();
        try{
           String sql="Select id_categoria from categoria where nombre_cat='"+categoria+"'";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
               serialcategoria=rs.getString("id_categoria");
               break;
          } 
       }catch(SQLException | ClassNotFoundException ex){
           Logger.getLogger(torneopexception.class.getName()).log(Level.SEVERE,null,ex);
       }
       
        
        try{
           String sql="call asomiranda.verificarIdException('"+serialcategoria+"');";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
               ValidException=rs.getString("@id");
               break;
          } 
       }catch(SQLException | ClassNotFoundException ex){
           Logger.getLogger(torneopexception.class.getName()).log(Level.SEVERE,null,ex);
       }
        
        if("Elige la categoria".equals(categoria)){
            JOptionPane.showMessageDialog(null,"Debe seleccionar alguna categoría para poder registrar la excepción","", JOptionPane.INFORMATION_MESSAGE);
          
        }else
        if("NE".equals(ValidException)){
            JOptionPane.showMessageDialog(null,"Ya guardo excepción para esta categoria, inténtelo con otra.","Información", JOptionPane.INFORMATION_MESSAGE);
        
        } else 
        if("".equals(campoEdad.getText()) || " ".equals(campoEdad.getText()) || campoEdad.getText()==null ){
            JOptionPane.showMessageDialog(null,"El campo edad se encuentra vacío, por favor introduzca un valor","Información", JOptionPane.INFORMATION_MESSAGE);
            torneopexception.campoEdad.setText("");
            torneopexception.campoEdad.requestFocus();
        } else {
            edad=Integer.parseInt(torneopexception.campoEdad.getText());
            guardardatosexception();
            
        }
        
        
    }//GEN-LAST:event_bguardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bagregar;
    public static javax.swing.JButton beliminar;
    public static javax.swing.JButton bguardar;
    public static javax.swing.JButton bsalir;
    public static javax.swing.JTextField campoEdad;
    public static javax.swing.JComboBox combocategorias;
    public static javax.swing.JTextField filtro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablatcategoria;
    // End of variables declaration//GEN-END:variables
}
