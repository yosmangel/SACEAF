package Equipo;

import Basededatos.Conexion;
import Basededatos.equipo.datomodificarequipo;
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


public final class modificarequipo extends javax.swing.JPanel {

    DefaultComboBoxModel cdisciplina= new DefaultComboBoxModel();
    DefaultComboBoxModel combo= new DefaultComboBoxModel();
    String nombre, sexo, disciplina, categoria,club, equipo,identificador,delegado,serialclub;
    int control,ctrse, ctrde;
 
    public modificarequipo() {
        initComponents();
        llenarcampos();

    }
    
    
    public void HabilitarGuardar(){
        String Identificador=modificarequipo.campoidentificador.getText();
        String Delegado=modificarequipo.campodelegado.getText();
        
        if(Identificador.isEmpty() || Delegado.isEmpty()){
            modificarequipo.bguardar.setEnabled(false);
        }
        else{
            modificarequipo.bguardar.setEnabled(true);
        }
    }
    public void llenarcampos(){
        equipo=(String) mostrarequipo.tablaequipos.getValueAt(mostrarequipo.tablaequipos.getSelectedRow(),0);
        club=(String) mostrarequipo.tablaequipos.getValueAt(mostrarequipo.tablaequipos.getSelectedRow(),1);
        identificador=(String) mostrarequipo.tablaequipos.getValueAt(mostrarequipo.tablaequipos.getSelectedRow(),2);
        categoria=(String) mostrarequipo.tablaequipos.getValueAt(mostrarequipo.tablaequipos.getSelectedRow(),3);
        disciplina=(String) mostrarequipo.tablaequipos.getValueAt(mostrarequipo.tablaequipos.getSelectedRow(),4);
        delegado=(String) mostrarequipo.tablaequipos.getValueAt(mostrarequipo.tablaequipos.getSelectedRow(),5);
        
        modificarequipo.campodelegado.setText(delegado);
        modificarequipo.campoidentificador.setText(identificador);
        modificarequipo.camposerialequipo.setText(equipo);
        combo.addElement(categoria);
        modificarequipo.combocategoria.setModel(combo);
        cdisciplina.addElement(disciplina);
        modificarequipo.combodisciplina.setModel(cdisciplina);
        try{   
           String sql="Select id_club from club where nombre_club='"+club+"'";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
             serialclub=rs.getString("id_club");
             break;
             
           }
            }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(modificarequipo.class.getName()).log(Level.SEVERE,null,ex);
            }
          modificarequipo.camposerialclub.setText(serialclub);
          try{   
           String sql="Select sexo from categoria where nombre_cat='"+categoria+"'";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
             sexo=rs.getString("sexo");
             break;
             
           }
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(modificarequipo.class.getName()).log(Level.SEVERE,null,ex);
        }
         if(sexo.equals("Masculino")){
             modificarequipo.rmasculino.setSelected(true);
         }else{
             modificarequipo.rfemenino.setSelected(true);
         }
         modificarequipo.rmasculino.setEnabled(false);
         modificarequipo.rfemenino.setEnabled(false);
         modificarequipo.combocategoria.setEnabled(false);
         modificarequipo.combodisciplina.setEnabled(false);
         modificarequipo.camposerialclub.setEnabled(false);
         modificarequipo.camposerialequipo.setEnabled(false);

    }
    public void limpiar(){
        modificarequipo.campodelegado.setText("");
        modificarequipo.campoidentificador.setText("");
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
        nombreclub = new javax.swing.JLabel();
        campoidentificador = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(870, 300));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(870, 300));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modificar Datos del Equipo");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Disciplina");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Categoria");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Sexo");

        rmasculino.setText("Masculino");

        rfemenino.setText("Femenino");

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
                        .addComponent(nombreclub, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(66, 66, 66))))
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
                    .addComponent(bsalir))
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


   
    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        equipo=null;
        delegado=null;
        identificador=null;
        equipo=modificarequipo.camposerialequipo.getText();
        delegado=modificarequipo.campodelegado.getText();
        identificador=modificarequipo.campoidentificador.getText();

    

        try{
            datomodificarequipo user= new datomodificarequipo(equipo,identificador,delegado);
            equipo in= new equipo();
            boolean r;
            r=in.Modificar(user);
            if(r==false){
                JOptionPane.showMessageDialog(this,"Registro Exitoso","Guardado",JOptionPane.INFORMATION_MESSAGE);
                
                      pclub.panelequipos.remove(this);
                      if(mostrarequipo.rmasculino.isSelected()==true){
                      mostrarequipo.equiposmasculinos();
                      }else{
                      mostrarequipo.equiposfemenino();
                      }
 
                    pclub.hablitar();
                
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this,"Error "+ex.getMessage(),"Error...",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException e){
            Logger.getLogger(modificarequipo.class.getName()).log(Level.SEVERE,null, e);
        }
        
        
    }//GEN-LAST:event_bguardarActionPerformed

    private void blimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blimpiarActionPerformed
         limpiar();
    }//GEN-LAST:event_blimpiarActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        pclub.panelequipos.remove(this);
        pclub.hablitar();
    }//GEN-LAST:event_bsalirActionPerformed

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
         if(Character.isLetter(K)) {
              getToolkit().beep();
              
              evt.consume();
              
              JOptionPane.showMessageDialog(this,"Ingrese solo números","Informacion",JOptionPane.INFORMATION_MESSAGE);
       
              
        }
    }//GEN-LAST:event_camposerialclubKeyTyped

    private void campoidentificadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoidentificadorKeyTyped
        int Limite=10;
        char K;
        K=evt.getKeyChar();
        if (campoidentificador.getText().length()== Limite){
         evt.consume();
        }
        if(!(K<'0'|| K>'9')){
         evt.consume();
        }
        if(Character.isLetter(K)) {
              getToolkit().beep();
              
              evt.consume();
              
              JOptionPane.showMessageDialog(this,"Ingrese solo números","Informacion",JOptionPane.INFORMATION_MESSAGE);
       
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
        if(Character.isLetter(K)) {
              getToolkit().beep();
              
              evt.consume();
              
              JOptionPane.showMessageDialog(this,"Ingrese solo números","Informacion",JOptionPane.INFORMATION_MESSAGE);
       
              
        }
    }//GEN-LAST:event_camposerialequipoKeyTyped

    private void campodelegadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campodelegadoKeyTyped
        int Limite=100;
        char K;
        K=evt.getKeyChar();
        if (campodelegado.getText().length()== Limite){
         evt.consume();
        }
        if(!(K<'0'|| K>'9')){
         evt.consume();
        }
        if(Character.isDigit(K)) {
              getToolkit().beep();
              
              evt.consume();
              
              JOptionPane.showMessageDialog(this,"Ingrese solo letras","Informacion",JOptionPane.INFORMATION_MESSAGE);
       
              
        }
    }//GEN-LAST:event_campodelegadoKeyTyped

    private void campoidentificadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoidentificadorKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_campoidentificadorKeyReleased

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
    public static javax.swing.JLabel nombreclub;
    public static javax.swing.JRadioButton rfemenino;
    public static javax.swing.JRadioButton rmasculino;
    // End of variables declaration//GEN-END:variables
}
