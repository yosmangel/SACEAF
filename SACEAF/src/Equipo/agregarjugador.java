
package Equipo;

import Basededatos.Conexion;
import Basededatos.equipo.datosjugador;
import Basededatos.equipo.jugador;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class agregarjugador extends javax.swing.JPanel {

 String imagen, nombreimagen,ficha,nacionalidad,nombrecat;
 int ctrlinicio,ctrlfin,ctrc;
 
 
    public agregarjugador() {
        initComponents();
        agregarjugador.rvenezolano.setSelected(true);
    }

    public void HabilitarGuardar(){
        String Cedula=agregarjugador.campocedula.getText();
        String Nombre=agregarjugador.camponombre.getText();
        String Apellido=agregarjugador.campoapellido.getText();
        String Dia=agregarjugador.campodia.getText();
        String Mes=agregarjugador.campomes.getText();
        String Year=agregarjugador.campoyear.getText();

        if(Cedula.isEmpty() || Nombre.isEmpty() || Apellido.isEmpty() || Dia.isEmpty() || Mes.isEmpty() || Year.isEmpty()){
            agregarjugador.bguardar.setEnabled(false);
        }
        else{
            agregarjugador.bguardar.setEnabled(true);
        }
    }
    public void limpiar(){
        agregarjugador.campocedula.setText("");
        agregarjugador.camponombre.setText("");
        agregarjugador.campoapellido.setText("");
        agregarjugador.campodia.setText("");
        agregarjugador.campomes.setText("");
        agregarjugador.campoyear.setText("");
        agregarjugador.ruta.setText("");
        agregarjugador.lfoto.setIcon(null);
        agregarjugador.bguardar.setEnabled(false);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campocedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        camponombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoapellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campodia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campomes = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoyear = new javax.swing.JTextField();
        rvenezolano = new javax.swing.JRadioButton();
        rextranjero = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        ruta = new javax.swing.JTextField();
        bvisualizar = new javax.swing.JButton();
        lfoto = new javax.swing.JLabel();
        bguardar = new javax.swing.JButton();
        blimpiar = new javax.swing.JButton();
        bsalir = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(850, 305));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(850, 305));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar Datos del Jugador");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cedula");

        campocedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campocedulaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campocedulaKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombres");

        camponombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                camponombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camponombreKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Apellidos");

        campoapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoapellidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoapellidoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Fecha de Nacimiento");

        campodia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campodiaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campodiaKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("/");

        campomes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campomesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campomesKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("/");

        campoyear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoyearKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoyearKeyTyped(evt);
            }
        });

        rvenezolano.setText("V");
        rvenezolano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rvenezolanoActionPerformed(evt);
            }
        });

        rextranjero.setText("E");
        rextranjero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rextranjeroActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Foto");

        ruta.setEditable(false);

        bvisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/visualizar30x30.png"))); // NOI18N
        bvisualizar.setText("Buscar");
        bvisualizar.setContentAreaFilled(false);
        bvisualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bvisualizar.setIconTextGap(-2);
        bvisualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/visualizar40x40.png"))); // NOI18N
        bvisualizar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bvisualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bvisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bvisualizarActionPerformed(evt);
            }
        });

        lfoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lfoto.setMaximumSize(new java.awt.Dimension(164, 129));
        lfoto.setMinimumSize(new java.awt.Dimension(164, 129));
        lfoto.setPreferredSize(new java.awt.Dimension(164, 129));

        bguardar.setEnabled(false);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campodia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campomes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoyear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bvisualizar))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(bguardar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(blimpiar)
                            .addGap(104, 104, 104)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rvenezolano)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rextranjero))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campocedula, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(camponombre, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(368, 368, 368)
                                        .addComponent(lfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bsalir)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rvenezolano)
                            .addComponent(rextranjero))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campocedula, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(camponombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bsalir))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campodia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(campomes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(campoyear, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bvisualizar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bguardar)
                            .addComponent(blimpiar)))
                    .addComponent(lfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 36, Short.MAX_VALUE))
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
        String cedula= agregarjugador.campocedula.getText();
        String nombre=agregarjugador.camponombre.getText();
        String apellido=agregarjugador.campoapellido.getText();
        int dia=Integer.parseInt(agregarjugador.campodia.getText());
        int mes= Integer.parseInt(agregarjugador.campomes.getText());
        int year=Integer.parseInt(agregarjugador.campoyear.getText());
        String fechadenacimiento=year+"/"+mes+"/"+dia;
        String serialequipo=pequipo.labelserial.getText();
        
        try{
            if(agregarjugador.rvenezolano.isSelected()==true){
            ficha="V"+cedula;
            nacionalidad="Venezolano";
        }else{
            ficha="E"+cedula;
            nacionalidad="Extranjero";
        }
        }catch(Exception e){
            
        }
        String foto=ruta.getText();
        String bloqueo="No";
        nombrecat=pequipo.labelcategoria.getText();
        try{
            String sql="Select year_final, year_ini from categoria where nombre_cat='"+nombrecat+"';";
            Conexion parametros= new Conexion();
            Class.forName(parametros.getDriver());
            Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
            Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
                ctrlinicio=rs.getInt("year_ini");
                ctrlfin=rs.getInt("year_final");
                break;
            }
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(agregarjugador.class.getName()).log(Level.SEVERE,null,ex);
        }
        try{
            String sql="Select cedula from jugador where cedula='"+cedula+"';";
            Conexion parametros= new Conexion();
            Class.forName(parametros.getDriver());
            Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
            Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
                ctrc=2;
                break;
            }
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(agregarjugador.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        if(ctrc ==2){
            JOptionPane.showMessageDialog(this,"La cedula introducida ya se encuentra registrada en la base de datos","Informacion",JOptionPane.INFORMATION_MESSAGE);
            agregarjugador.campocedula.requestFocus();
        }else
            if(year>= ctrlfin && year<=ctrlinicio){
                try{
            datosjugador user= new datosjugador(cedula,nombre,apellido,dia,mes,year,fechadenacimiento,serialequipo,ficha,foto,nacionalidad,bloqueo);
            jugador in= new jugador();
            boolean r;
            r=in.Insertar(user);
            if(r==false){
                JOptionPane.showMessageDialog(this,"Registro Exitoso!","Guardado!",JOptionPane.INFORMATION_MESSAGE);
                int opc=JOptionPane.showConfirmDialog(null,"Desea registrar otro jugador en la Base de Datos?","Informacion",JOptionPane.YES_NO_OPTION);
                if(opc==0){
                    
                    limpiar();
                    agregarjugador.campocedula.requestFocus();
                    mostrarjugador.cargarjugadores();
                }else{
                    pequipo.paneljugadores.remove(this);
                    pequipo.habilitar();
                    mostrarjugador.cargarjugadores();
                    
                }
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error "+ e.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(agregarjugador.class.getName()).log(Level.SEVERE,null,ex);
        }
            }else{
       JOptionPane.showMessageDialog(this,"El año de nacimiento del jugador no corresponde con"
               + " la categoria a la cual se le quiere agregar.","Informacion",JOptionPane.INFORMATION_MESSAGE);
              limpiar();
            }
        
    }//GEN-LAST:event_bguardarActionPerformed

    private void blimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blimpiarActionPerformed
        limpiar();
        
    }//GEN-LAST:event_blimpiarActionPerformed

    private void bvisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bvisualizarActionPerformed
        final JFileChooser elegirImagen = new JFileChooser();
        elegirImagen.setMultiSelectionEnabled(false);
        int o = elegirImagen.showOpenDialog(this);
        if(o == JFileChooser.APPROVE_OPTION){
            imagen = elegirImagen.getSelectedFile().getAbsolutePath();
            nombreimagen = elegirImagen.getSelectedFile().getName();
            agregarjugador.ruta.setText(imagen);
            Image preview = Toolkit.getDefaultToolkit().getImage(imagen);
            if(preview != null){
                agregarjugador.lfoto.setText("");
                ImageIcon icon = new ImageIcon(preview.getScaledInstance(agregarjugador.lfoto.getWidth(), agregarjugador.lfoto.getHeight(), Image.SCALE_DEFAULT));
                agregarjugador.lfoto.setIcon(icon);
            }
        }
    }//GEN-LAST:event_bvisualizarActionPerformed

    private void rvenezolanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rvenezolanoActionPerformed
        agregarjugador.rvenezolano.setSelected(true);
        if(agregarjugador.rvenezolano.isSelected()==true){
            agregarjugador.rextranjero.setSelected(false);
            
        }
    }//GEN-LAST:event_rvenezolanoActionPerformed

    private void rextranjeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rextranjeroActionPerformed
        agregarjugador.rextranjero.setSelected(true);
        if(agregarjugador.rextranjero.isSelected()==true){
            agregarjugador.rvenezolano.setSelected(false);
        }
    }//GEN-LAST:event_rextranjeroActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        pequipo.paneljugadores.remove(this);
        pequipo.habilitar();
    }//GEN-LAST:event_bsalirActionPerformed

    private void campocedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campocedulaKeyTyped
        int Limite=8;
        char K;
        K=evt.getKeyChar();
        if (agregarjugador.campocedula.getText().length()== Limite){
         evt.consume();
        }
        if(K<'0'|| K>'9'){
         evt.consume();
        }
    }//GEN-LAST:event_campocedulaKeyTyped

    private void camponombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camponombreKeyTyped
        int Limite=50;
        char K;
        K=evt.getKeyChar();
        if (agregarjugador.camponombre.getText().length()== Limite){
         evt.consume();
        }
        if(!(K<'0'|| K>'9')){
         evt.consume();
        }
    }//GEN-LAST:event_camponombreKeyTyped

    private void campoapellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoapellidoKeyTyped
        int Limite=50;
        char K;
        K=evt.getKeyChar();
        if (agregarjugador.campoapellido.getText().length()== Limite){
         evt.consume();
        }
        if(!(K<'0'|| K>'9')){
         evt.consume();
        }
    }//GEN-LAST:event_campoapellidoKeyTyped

    private void campodiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campodiaKeyTyped
        int Limite=2;
        char K;
        K=evt.getKeyChar();
        if (agregarjugador.campodia.getText().length()== Limite){
         evt.consume();
        }
        if(K<'0'|| K>'9'){
         evt.consume();
        }
    }//GEN-LAST:event_campodiaKeyTyped

    private void campomesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campomesKeyTyped
        int Limite=2;
        char K;
        K=evt.getKeyChar();
        if (agregarjugador.campomes.getText().length()== Limite){
         evt.consume();
        }
        if(K<'0'|| K>'9'){
         evt.consume();
        }
    }//GEN-LAST:event_campomesKeyTyped

    private void campoyearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoyearKeyTyped
        int Limite=4;
        char K;
        K=evt.getKeyChar();
        if (agregarjugador.campoyear.getText().length()== Limite){
         evt.consume();
        }
        if(K<'0'|| K>'9'){
         evt.consume();
        }
    }//GEN-LAST:event_campoyearKeyTyped

    private void campocedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campocedulaKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_campocedulaKeyReleased

    private void camponombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camponombreKeyReleased
       this.HabilitarGuardar();
    }//GEN-LAST:event_camponombreKeyReleased

    private void campoapellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoapellidoKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_campoapellidoKeyReleased

    private void campodiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campodiaKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_campodiaKeyReleased

    private void campomesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campomesKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_campomesKeyReleased

    private void campoyearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoyearKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_campoyearKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bguardar;
    public static javax.swing.JButton blimpiar;
    public static javax.swing.JButton bsalir;
    public static javax.swing.JButton bvisualizar;
    public static javax.swing.JTextField campoapellido;
    public static javax.swing.JTextField campocedula;
    public static javax.swing.JTextField campodia;
    public static javax.swing.JTextField campomes;
    public static javax.swing.JTextField camponombre;
    public static javax.swing.JTextField campoyear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lfoto;
    public static javax.swing.JRadioButton rextranjero;
    public static javax.swing.JTextField ruta;
    public static javax.swing.JRadioButton rvenezolano;
    // End of variables declaration//GEN-END:variables
}
