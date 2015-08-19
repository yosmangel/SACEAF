

package Equipo;

import Basededatos.Conexion;
import Basededatos.equipo.datoequipo;
import Basededatos.equipo.equipo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class cagregarequipo extends javax.swing.JPanel {

    DefaultComboBoxModel cdisciplina= new DefaultComboBoxModel();
    DefaultComboBoxModel cfemenino= new DefaultComboBoxModel();
    DefaultComboBoxModel cmasculino= new DefaultComboBoxModel();

    public cagregarequipo() {
        initComponents();
        rmasculino.setSelected(true);
        cargarmasculino();
        cargarserial();
        cargardisciplina();
    }

    public void cargarserial(){
        
     String serial=(String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),0);
  
     camposerialclub.setText(serial);
     camposerialclub.setEnabled(false);
    }
    public void cargardisciplina(){
    combodisciplina.removeAllItems();
    try{
        Conexion parametros=new Conexion();
        Class.forName(parametros.getDriver());
        Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs= st.executeQuery("Select nombre_disciplina from disciplina;");
        cdisciplina.addElement("Elige la Disciplina");
        combodisciplina.setModel(cdisciplina);
        while(rs.next()){
            cdisciplina.addElement(rs.getObject("nombre_disciplina"));
            combodisciplina.setModel(cdisciplina);
        }
        st.close();
    }catch(SQLException | ClassNotFoundException ex){
        Logger.getLogger(cagregarequipo.class.getName()).log(Level.SEVERE,null,ex);
    }
    }
    public void cargarfemenino(){
        combocategoria.removeAllItems();
    try{
        Conexion parametros=new Conexion();
        Class.forName(parametros.getDriver());
        Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs= st.executeQuery("Select nombre_cat from categoria where sexo='Femenino';");
        cfemenino.addElement("Elige la Categoria");
        combocategoria.setModel(cfemenino);
        while(rs.next()){
            cfemenino.addElement(rs.getObject("nombre_cat"));
            combocategoria.setModel(cfemenino);
        }
        st.close();
    }catch(SQLException | ClassNotFoundException ex){
        Logger.getLogger(cagregarequipo.class.getName()).log(Level.SEVERE,null,ex);
    }
    }
    public void cargarmasculino(){
        combocategoria.removeAllItems();
    try{
        Conexion parametros=new Conexion();
        Class.forName(parametros.getDriver());
        Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs= st.executeQuery("Select nombre_cat from categoria where sexo='Masculino';");
        cmasculino.addElement("Elige la Categoria");
        combocategoria.setModel(cmasculino);
        while(rs.next()){
            cmasculino.addElement(rs.getObject("nombre_cat"));
            combocategoria.setModel(cmasculino);
        }
        st.close();
    }catch(SQLException ex){
        Logger.getLogger(cagregarequipo.class.getName()).log(Level.SEVERE,null,ex);
    }catch(ClassNotFoundException e){
        Logger.getLogger(cagregarequipo.class.getName()).log(Level.SEVERE,null,e);
    }
    }
    public void limpiar(){
        rmasculino.setSelected(true);
        rfemenino.setSelected(false);
        combocategoria.removeAllItems();
        cargarmasculino();
        combodisciplina.removeAllItems();
        cargardisciplina();
        camposerialequipo.setText("");
        campodelegado.setText("");
        camposerialclub.requestFocus();
        campoidentificador.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        combodisciplina = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        combocategoria = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        rmasculino = new javax.swing.JRadioButton();
        rfemenino = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        camposerialclub = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        camposerialequipo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campodelegado = new javax.swing.JTextField();
        bguardar = new javax.swing.JButton();
        blimpiar = new javax.swing.JButton();
        bsalir = new javax.swing.JButton();
        campoidentificador = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(800, 300));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 300));

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 300));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 300));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar Datos del Equipo");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Disciplina");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Categoria");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Sexo");

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Serial del Club");

        camposerialclub.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camposerialclubKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Serial del Equipo");

        camposerialequipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camposerialequipoKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Delegado");

        campodelegado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campodelegadoKeyTyped(evt);
            }
        });

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

        campoidentificador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoidentificadorKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Identificador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rfemenino)
                            .addComponent(rmasculino))
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(combodisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(camposerialclub, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(camposerialequipo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campoidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campodelegado, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 31, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(bguardar)
                .addGap(18, 18, 18)
                .addComponent(blimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bsalir)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(9, 9, 9))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(combodisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(combocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(rmasculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rfemenino)
                        .addGap(45, 45, 45)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(camposerialclub, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(camposerialequipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(campodelegado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blimpiar)
                    .addComponent(bguardar)
                    .addComponent(bsalir))
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
   String categoria,disciplina;
   int ctrse, ctrde;
    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
    String nombrecate= combocategoria.getSelectedItem().toString();
    try{
           String sql="Select id_categoria from categoria where nombre_cat='"+nombrecate+"'";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
               categoria=rs.getString("id_categoria");
               break;
          } 
       }catch(SQLException | ClassNotFoundException ex){
           Logger.getLogger(cagregarequipo.class.getName()).log(Level.SEVERE,null,ex);
       }
    String nombredisciplina=combodisciplina.getSelectedItem().toString();
    try{
           String sql="Select id_disciplina from disciplina where nombre_disciplina='"+nombredisciplina+"'";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
               disciplina=rs.getString("id_disciplina");
               break;
          } 
       }catch(SQLException | ClassNotFoundException ex){
           Logger.getLogger(cagregarequipo.class.getName()).log(Level.SEVERE,null,ex);
       }
    
        String equipo=camposerialequipo.getText();
        String serialclub=camposerialclub.getText();
        String serialequipo=serialclub+disciplina+categoria+equipo;
        String delegado=campodelegado.getText();
        String bloqueo="No";
        String identificador=campoidentificador.getText();
         try{
           String sql="Select id_equipo from equipo where id_equipo='"+serialequipo+"'";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
               ctrse=2;
               break;
          } 
       }catch(SQLException | ClassNotFoundException ex){
           Logger.getLogger(cagregarequipo.class.getName()).log(Level.SEVERE,null,ex);
       }
    try{
           String sql="Select id_equipo from equipo where delegadoeq='"+delegado+"'";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
               ctrde=2;
               break;
          } 
       }catch(SQLException | ClassNotFoundException ex){
           Logger.getLogger(cagregarequipo.class.getName()).log(Level.SEVERE,null,ex);
       }
    
    if(ctrse==2){
       JOptionPane.showMessageDialog(this,"El serial del equipo ya se encuentra guardado en la Base de Datos","Informacion",JOptionPane.INFORMATION_MESSAGE);
       camposerialequipo.setText("");
       camposerialequipo.requestFocus();
    }else{
        try{
            datoequipo user= new datoequipo(serialequipo,delegado,serialclub,categoria,bloqueo,disciplina,identificador);
            equipo in= new equipo();
            boolean r;
            r=in.Insertar(user);
            if(r==false){
                JOptionPane.showMessageDialog(this,"Registro Exitoso","Guardado",JOptionPane.INFORMATION_MESSAGE);
                int opc= JOptionPane.showConfirmDialog(null, "Desea Guardar otro equipo en la base de datos?", "Informacion", JOptionPane.YES_NO_OPTION);
                if(opc==0){
                    limpiar();
                    mostrarequipo.equiposfemenino();
                    mostrarequipo.equiposmasculinos();
                }else{
                    pclub.panelequipos.remove(this);
                    mostrarequipo.equiposfemenino();
                    mostrarequipo.equiposmasculinos();
                    pclub.hablitar();
                }
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this,"Error "+ex.getMessage(),"Error...",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException e){
            Logger.getLogger(cagregarequipo.class.getName()).log(Level.SEVERE,null, e);
        }
        }
    }//GEN-LAST:event_bguardarActionPerformed

    private void blimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blimpiarActionPerformed
    limpiar();
    }//GEN-LAST:event_blimpiarActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
    pclub.panelequipos.remove(this);
    pclub.hablitar();
    }//GEN-LAST:event_bsalirActionPerformed

    private void rmasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmasculinoActionPerformed
      rmasculino.setSelected(true);
      cargarmasculino();
      if(rmasculino.isSelected()==true){
          rfemenino.setSelected(false);
      }
    }//GEN-LAST:event_rmasculinoActionPerformed

    private void rfemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rfemeninoActionPerformed
     rfemenino.setSelected(true);
     cargarfemenino();
     if(rfemenino.isSelected()==true){
         rmasculino.setSelected(false);
     }
    }//GEN-LAST:event_rfemeninoActionPerformed

    private void camposerialclubKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camposerialclubKeyTyped
              int Limite=50;
    char K;
    K=evt.getKeyChar();
    if (camposerialclub.getText().length()== Limite){
     evt.consume();
    }
    if(K<'0'|| K>'9'){
     evt.consume();
    }
    }//GEN-LAST:event_camposerialclubKeyTyped

    private void campoidentificadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoidentificadorKeyTyped
                    int Limite=2;
    char K;
    K=evt.getKeyChar();
    if (campoidentificador.getText().length()== Limite){
     evt.consume();
    }
    if(!(K<'0'|| K>'9')){
     evt.consume();
    }
    }//GEN-LAST:event_campoidentificadorKeyTyped

    private void camposerialequipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camposerialequipoKeyTyped
                 int Limite=50;
    char K;
    K=evt.getKeyChar();
    if (camposerialequipo.getText().length()== Limite){
     evt.consume();
    }
    if(K<'0'|| K>'9'){
     evt.consume();
    }
    }//GEN-LAST:event_camposerialequipoKeyTyped

    private void campodelegadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campodelegadoKeyTyped
    int Limite=50;
    char K;
    K=evt.getKeyChar();
    if (campoidentificador.getText().length()== Limite){
     evt.consume();
    }
    if(!(K<'0'|| K>'9')){
     evt.consume();
    }
    }//GEN-LAST:event_campodelegadoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bguardar;
    public static javax.swing.JButton blimpiar;
    public static javax.swing.JButton bsalir;
    public static javax.swing.JTextField campodelegado;
    public static javax.swing.JTextField campoidentificador;
    public static javax.swing.JTextField camposerialclub;
    public static javax.swing.JTextField camposerialequipo;
    public static javax.swing.JComboBox combocategoria;
    public static javax.swing.JComboBox combodisciplina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JRadioButton rfemenino;
    public static javax.swing.JRadioButton rmasculino;
    // End of variables declaration//GEN-END:variables
}
