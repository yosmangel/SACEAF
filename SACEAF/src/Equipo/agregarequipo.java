
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


public final class agregarequipo extends javax.swing.JPanel {

    DefaultComboBoxModel cdisciplina= new DefaultComboBoxModel();
    DefaultComboBoxModel cfemenino= new DefaultComboBoxModel();
    DefaultComboBoxModel cmasculino= new DefaultComboBoxModel();

    public agregarequipo() {
        initComponents();
        rmasculino.setSelected(true);
        cargarmasculino();
        bguardar.setEnabled(false); 
        cargardisciplina();


    }
    public void HabilitarGuardar(){
        String Identificador=agregarequipo.campoidentificador.getText();
        String SerialEquipo=agregarequipo.camposerialequipo.getText();
        String Delegado=agregarequipo.campodelegado.getText();
        String SerialClub=agregarequipo.camposerialclub.getText();
        
        if(Identificador.isEmpty() || SerialEquipo.isEmpty() || Delegado.isEmpty() || SerialClub.isEmpty()){
        agregarequipo.bguardar.setEnabled(false);
    }
        else{
            agregarequipo.bguardar.setEnabled(true);
        }
    }
 String nombre;
 int control;
    public void buscarclub(){
        String club=camposerialclub.getText();
        control=3;
        try{   
           String sql="Select nombre_club from club where id_club='"+club+"'";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
             control=2;
             nombre=rs.getString("nombre_club");
             break;
             
           }
       }catch(SQLException | ClassNotFoundException ex){
           Logger.getLogger(agregarequipo.class.getName()).log(Level.SEVERE,null,ex);
       }
        if(control==2){
          labelcontrol.setVisible(false);
          bguardar.setEnabled(true);
          nombreclub.setText(nombre);
          }else
        if(control!= 2){
              bguardar.setEnabled(false);
              labelcontrol.setVisible(true);
              nombreclub.setText("");
           } 

        
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
        Logger.getLogger(agregarequipo.class.getName()).log(Level.SEVERE,null,ex);
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
        Logger.getLogger(agregarequipo.class.getName()).log(Level.SEVERE,null,ex);
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
    }catch(SQLException | ClassNotFoundException ex){
        Logger.getLogger(agregarequipo.class.getName()).log(Level.SEVERE,null,ex);
    }
    }
    public void limpiar(){
        rmasculino.setSelected(true);
        rfemenino.setSelected(false);
        combocategoria.removeAllItems();
        cargarmasculino();
        combodisciplina.removeAllItems();
        cargardisciplina();
        camposerialclub.setText("");
        camposerialequipo.setText("");
        campodelegado.setText("");
        nombreclub.setText("");
        labelcontrol.setVisible(true);
        campoidentificador.setText("");
        bguardar.setEnabled(false);
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
        labelcontrol = new javax.swing.JLabel();
        nombreclub = new javax.swing.JLabel();
        campoidentificador = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(870, 300));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(870, 300));
        jPanel1.setOpaque(false);

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                camposerialclubKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camposerialclubKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Serial del Equipo");

        camposerialequipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                camposerialequipoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camposerialequipoKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Delegado");

        campodelegado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campodelegadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campodelegadoKeyTyped(evt);
            }
        });

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

        labelcontrol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelcontrol.setForeground(new java.awt.Color(255, 0, 102));
        labelcontrol.setText("El serial escrito no existe");

        nombreclub.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombreclub.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        campoidentificador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoidentificadorKeyReleased(evt);
            }
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rfemenino)
                                        .addComponent(rmasculino)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(camposerialclub, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nombreclub, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelcontrol))
                        .addGap(49, 49, 49)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 25, Short.MAX_VALUE)
                        .addComponent(combodisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(bguardar)
                                .addGap(18, 18, 18)
                                .addComponent(blimpiar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(70, 70, 70)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(camposerialequipo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campodelegado, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(47, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bsalir)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rmasculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combodisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rfemenino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(nombreclub, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(camposerialclub, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(camposerialequipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(campodelegado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blimpiar)
                    .addComponent(bguardar)
                    .addComponent(bsalir)
                    .addComponent(labelcontrol))
                .addContainerGap(37, Short.MAX_VALUE))
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
    
        String Categoria=combocategoria.getSelectedItem().toString();
        String Disciplina=combodisciplina.getSelectedItem().toString();
        
       
        if("Elige la Disciplina".equals(Disciplina)){
            JOptionPane.showMessageDialog(this,"Debe Elegir la Disciplina del Equipo a Registrar","Información",JOptionPane.INFORMATION_MESSAGE);
        }
        
        if("Elige la Categoria".equals(Categoria)){
            JOptionPane.showMessageDialog(this,"Debe Elegir la Categoria del Equipo a Registrar","Información",JOptionPane.INFORMATION_MESSAGE);
        }
        
        else{
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
           Logger.getLogger(agregarequipo.class.getName()).log(Level.SEVERE,null,ex);
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
           Logger.getLogger(agregarequipo.class.getName()).log(Level.SEVERE,null,ex);
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
           Logger.getLogger(agregarequipo.class.getName()).log(Level.SEVERE,null,ex);
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
           Logger.getLogger(agregarequipo.class.getName()).log(Level.SEVERE,null,ex);
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
                    pmostrar.equiposfemenino();
                    pmostrar.equiposmasculinos();
                }else{
                    Gclubes.panelclub.remove(this);
                    pmostrar.equiposfemenino();
                    pmostrar.equiposmasculinos();
                    pmostrar.rclubes.setEnabled(true);
                    pmostrar.rfemenino.setEnabled(true);
                    pmostrar.rmasculino.setEnabled(true);
                    pmostrar.tablaclub.setEnabled(true);
                    Gclubes.bbloquear.setEnabled(true);
                    Gclubes.bagregar.setEnabled(true);
                    pmostrar.combocategoria.setEnabled(true);
                }
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this,"Error "+ex.getMessage(),"Error...",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException e){
            Logger.getLogger(agregarequipo.class.getName()).log(Level.SEVERE,null, e);
        }
        }
        }
    }//GEN-LAST:event_bguardarActionPerformed

    private void blimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blimpiarActionPerformed
    limpiar();
    }//GEN-LAST:event_blimpiarActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
    Gclubes.panelclub.remove(this);
    pmostrar.rclubes.setEnabled(true);
    pmostrar.rfemenino.setEnabled(true);
    pmostrar.rmasculino.setEnabled(true);
    pmostrar.tablaclub.setEnabled(true);
    Gclubes.bbloquear.setEnabled(true);
    Gclubes.bagregar.setEnabled(true);
    pmostrar.combocategoria.setEnabled(true);
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

    private void camposerialclubKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camposerialclubKeyReleased

        buscarclub();
        this.HabilitarGuardar();
    }//GEN-LAST:event_camposerialclubKeyReleased

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
    if (campodelegado.getText().length()== Limite){
     evt.consume();
    }
    if(!(K<'0'|| K>'9')){
     evt.consume();
    }
    }//GEN-LAST:event_campodelegadoKeyTyped

    private void campoidentificadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoidentificadorKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_campoidentificadorKeyReleased

    private void camposerialequipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camposerialequipoKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_camposerialequipoKeyReleased

    private void campodelegadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campodelegadoKeyReleased
       this.HabilitarGuardar();
    }//GEN-LAST:event_campodelegadoKeyReleased


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
    public static javax.swing.JLabel labelcontrol;
    public static javax.swing.JLabel nombreclub;
    public static javax.swing.JRadioButton rfemenino;
    public static javax.swing.JRadioButton rmasculino;
    // End of variables declaration//GEN-END:variables
}
