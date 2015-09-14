package Equipo;

import Basededatos.Conexion;
import Basededatos.equipo.datoclub;
import Basededatos.equipo.club;
import static Equipo.Agregarclub.campoimagen;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public final class modificarclub extends javax.swing.JPanel {
 

    DefaultComboBoxModel combo= new DefaultComboBoxModel();
    DefaultComboBoxModel combo2= new DefaultComboBoxModel();
    String presidente,municipio,imagen, nombreimagen,img;
    int ctrserial,ctrnombre,ctrpre;

    
    public modificarclub() {
        initComponents();
        cargarcampos();
        
    }
    
    public void HabilitarGuardar(){
        String Nombre=modificarclub.camponombre.getText();
        String Presidente=modificarclub.campopresidente.getText();
        
        if(Nombre.isEmpty() || Presidente.isEmpty()){
            modificarclub.bguardar.setEnabled(false);
        }
        else{
            modificarclub.bguardar.setEnabled(true);
        }
    }   
    public void limpiar(){
       modificarclub.camponombre.setText("");
       modificarclub.campopresidente.setText("");
       modificarclub.campoimagen.setText("");
    }
    public void cargarcampos(){
        String serial= (String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),0);
        camposerial.setText(serial);
        camposerial.setEnabled(false);
        String nombre=(String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),1);
        camponombre.setText(nombre);
        String muni=(String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),2);
        combo.addElement(muni);
        combomunicipio.setModel(combo);
        combomunicipio.setEnabled(false);
        presidente = (String)pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),3);
        campopresidente.setText(presidente);
        try{
              String sql="Select logo_eq from imagenclub where id_club='"+serial+"'";
              Conexion parametros = new Conexion();
              Class.forName(parametros.getDriver());
              Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
              Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
              ResultSet rs=st.executeQuery(sql);
              while(rs.first()){
                  img=rs.getString("logo_eq");
                  break;
             } 
          }catch(SQLException | ClassNotFoundException ex){
              Logger.getLogger(modificarclub.class.getName()).log(Level.SEVERE,null,ex);
          }
        
        if("".equals(img) || " ".equals(img) || img==null ){
        }else{
            campoimagen.setText(img);
        }
        
     
 }
    public void cargarmunicipio(){
        combomunicipio.removeAllItems();
        try{
            Conexion parametros= new Conexion();
            Class.forName(parametros.getDriver());
            Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery("Select nombre_municipio from municipio");
            combo.addElement("Seleccione el Municipio");
            combomunicipio.setModel(combo);
            while(rs.next()){
                combo.addElement(rs.getObject("nombre_municipio"));
                combomunicipio.setModel(combo);
            }
            st.close();
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(modificarclub.class.getName()).log(Level.SEVERE,null,ex);
        }
      
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bguardar = new javax.swing.JButton();
        blimpiar = new javax.swing.JButton();
        combomunicipio = new javax.swing.JComboBox();
        camposerial = new javax.swing.JTextField();
        camponombre = new javax.swing.JTextField();
        campopresidente = new javax.swing.JTextField();
        campoimagen = new javax.swing.JTextField();
        bbuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        bsalir = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(870, 300));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(870, 300));

        jPanel1.setMinimumSize(new java.awt.Dimension(870, 300));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(870, 300));

        bguardar.setEnabled(false);
        bguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Add 30x30.png"))); // NOI18N
        bguardar.setText("Guardar");
        bguardar.setContentAreaFilled(false);
        bguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bguardar.setIconTextGap(-2);
        bguardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Add 40x40.png"))); // NOI18N
        bguardar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bguardarActionPerformed(evt);
            }
        });

        blimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/limpiar30x30.png"))); // NOI18N
        blimpiar.setText("Limpiar");
        blimpiar.setContentAreaFilled(false);
        blimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        blimpiar.setIconTextGap(-2);
        blimpiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/limpiar40x40.png"))); // NOI18N
        blimpiar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        blimpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        blimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blimpiarActionPerformed(evt);
            }
        });

        camposerial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camposerialKeyTyped(evt);
            }
        });

        camponombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                camponombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camponombreKeyTyped(evt);
            }
        });

        campopresidente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campopresidenteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campopresidenteKeyTyped(evt);
            }
        });

        campoimagen.setEditable(false);

        bbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/visualizar30x30.png"))); // NOI18N
        bbuscar.setText("Buscar");
        bbuscar.setContentAreaFilled(false);
        bbuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bbuscar.setIconTextGap(-2);
        bbuscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/visualizar40x40.png"))); // NOI18N
        bbuscar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bbuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbuscarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Modificar datos del Club");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Serial ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Municipio");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Nombre");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Presidente");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Logo");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(285, 285, 285))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(camponombre, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(combomunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(465, 465, 465)
                        .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campopresidente, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(camposerial))
                .addGap(173, 175, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bguardar)
                        .addGap(37, 37, 37)
                        .addComponent(blimpiar)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campoimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(bsalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(bbuscar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combomunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(camposerial, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(camponombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(campopresidente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bbuscar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(bsalir)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bguardar)
                                .addComponent(blimpiar)))))
                .addGap(28, 28, 28))
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
   
    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
       String nombremunicipio= combomunicipio.getSelectedItem().toString();
       try{
           String sql="Select id_municipio from municipio where nombre_municipio='"+nombremunicipio+"'";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
               municipio=rs.getString("id_municipio");
               break;
          } 
       }catch(SQLException | ClassNotFoundException ex){
           Logger.getLogger(modificarclub.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       String idclub=modificarclub.camposerial.getText();
       String nombreclub=modificarclub.camponombre.getText();
       presidente=modificarclub.campopresidente.getText();
       String bloqueo=(String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),4);
      
       try{
           String sql="Select id_club from club where nombre_club='"+nombreclub+"'";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
               ctrnombre=2;
               break;
                 } 
       }catch(SQLException | ClassNotFoundException ex){
           Logger.getLogger(modificarclub.class.getName()).log(Level.SEVERE,null,ex);
       }
       try{
           String sql="Select id_club from club where presidenteclub='"+presidente+"'";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
               ctrpre=2;
               break;
          } 
       }catch(SQLException | ClassNotFoundException ex){
           Logger.getLogger(modificarclub.class.getName()).log(Level.SEVERE,null,ex);
       }
       
      
           if(ctrnombre==2){
           JOptionPane.showMessageDialog(this,"El Nombre del Club se encuentra guardado en la Base de Datos","Informacion",JOptionPane.INFORMATION_MESSAGE);
           camponombre.setText("");
           camponombre.requestFocus();
       
           }else{
       
       try{
       
           datoclub user= new datoclub(idclub, nombreclub, presidente, imagen,nombreimagen,bloqueo,municipio);
       
           club in= new club();
       
           boolean r;
           r=in.Modificar(user);
          
           if(r==false){
               JOptionPane.showMessageDialog(this,"Modificacion Exitosa","Guardado!",JOptionPane.INFORMATION_MESSAGE);
                   Gclubes.panelclub.remove(this);
                   pmostrar.cargarclubes();
                   Gclubes.habilitar();
               
           }
           
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(this,"Error "+ex.getMessage(),"Error...",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException e){
           Logger.getLogger(modificarclub.class.getName()).log(Level.SEVERE,null,e);
       }
               }
    }//GEN-LAST:event_bguardarActionPerformed

    private void blimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blimpiarActionPerformed
       limpiar();
       
    }//GEN-LAST:event_blimpiarActionPerformed

    private void bbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbuscarActionPerformed
       final JFileChooser elegirImagen = new JFileChooser();
        FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("Imagenes de los escudos","jpg","png");
        elegirImagen.setFileFilter(filtroImagen);
        int o = elegirImagen.showOpenDialog(this);
        if(o == JFileChooser.APPROVE_OPTION){
           try {
               imagen = elegirImagen.getSelectedFile().getCanonicalPath();
              if(imagen.endsWith(".png") || imagen.endsWith(".jpg") 
                     || imagen.endsWith(".PNG") || imagen.endsWith(".JPG")){
                  nombreimagen = elegirImagen.getSelectedFile().getName();
                  campoimagen.setText(imagen);
                  imagen=imagen.replace("\\", "-");
              }else{
                  imagen="";
                  JOptionPane.showMessageDialog(null,"Recuerde que debe elegir una imagen en formato jpg y png.",
                          "Información", JOptionPane.INFORMATION_MESSAGE);
                  
              }
     
           } catch (IOException ex) {
               Logger.getLogger(Agregarclub.class.getName()).log(Level.SEVERE, null, ex);
           }
            
        }
    }//GEN-LAST:event_bbuscarActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        Gclubes.panelclub.remove(this);
        Gclubes.habilitar();
    }//GEN-LAST:event_bsalirActionPerformed

    private void camponombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camponombreKeyTyped
        int Limite=50;
        char K;
        K=evt.getKeyChar();
        if (camponombre.getText().length()== Limite){
         evt.consume();
        }
        if(!(K<'0'|| K>'9')){
         evt.consume();
        }
    }//GEN-LAST:event_camponombreKeyTyped

    private void camposerialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camposerialKeyTyped
        int Limite=50;
        char K;
        K=evt.getKeyChar();
        if (camposerial.getText().length()== Limite){
         evt.consume();
        }
        if(K<'0'|| K>'9'){
         evt.consume();
        }
    }//GEN-LAST:event_camposerialKeyTyped

    private void campopresidenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campopresidenteKeyTyped
        int Limite=50;
        char K;
        K=evt.getKeyChar();
        if (campopresidente.getText().length()== Limite){
         evt.consume();
        }
        if(!(K<'0'|| K>'9')){
         evt.consume();
        }
    }//GEN-LAST:event_campopresidenteKeyTyped

    private void camponombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camponombreKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_camponombreKeyReleased

    private void campopresidenteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campopresidenteKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_campopresidenteKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bbuscar;
    private static javax.swing.JButton bguardar;
    public static javax.swing.JButton blimpiar;
    public static javax.swing.JButton bsalir;
    public static javax.swing.JTextField campoimagen;
    public static javax.swing.JTextField camponombre;
    public static javax.swing.JTextField campopresidente;
    public static javax.swing.JTextField camposerial;
    public static javax.swing.JComboBox combomunicipio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
