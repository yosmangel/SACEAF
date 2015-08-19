
package Administracion;

import Basededatos.Conexion;
import Datosadministracion.categoria;
import Datosadministracion.datocategoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class agregarcategoria extends javax.swing.JPanel {

   
    public agregarcategoria() {
        initComponents();
        camposerial.requestFocus();
        rmasculino.setSelected(true);
    }

    public void HabilitarGuardar(){
        
        String Nombre=agregarcategoria.camponombre.getText();
        String Serial=agregarcategoria.camposerial.getText();
        String Ultimo=agregarcategoria.campoultimo.getText();
        String Primero=agregarcategoria.campoprimer.getText();

        
        if(Nombre.isEmpty() || Serial.isEmpty() || Ultimo.isEmpty() || Primero.isEmpty()){
            
            
            agregarcategoria.bguardar.setEnabled(false);
            
        }
        else{
            agregarcategoria.bguardar.setEnabled(true);
        }
    }
    
   public void limpiar(){
       camponombre.setText("");
        camposerial.setText("");
        rmasculino.setSelected(true);
        camposerial.requestFocus();
        campoultimo.setText("");
        campoprimer.setText("");
        bguardar.setEnabled(false);
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        camponombre = new javax.swing.JTextField();
        camposerial = new javax.swing.JTextField();
        rmasculino = new javax.swing.JRadioButton();
        rfemenino = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bguardar = new javax.swing.JButton();
        blimpiar = new javax.swing.JButton();
        bsalir = new javax.swing.JButton();
        campoultimo = new javax.swing.JTextField();
        campoprimer = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(630, 290));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(630, 290));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingresar Datos de la");

        camponombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                camponombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camponombreKeyTyped(evt);
            }
        });

        camposerial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                camposerialKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camposerialKeyTyped(evt);
            }
        });

        rmasculino.setText("Masculino");
        rmasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmasculinoActionPerformed(evt);
            }
        });
        rmasculino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rmasculinoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rmasculinoKeyReleased(evt);
            }
        });

        rfemenino.setText("Femenino");
        rfemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rfemeninoActionPerformed(evt);
            }
        });
        rfemenino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rfemeninoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rfemeninoKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Serial de la Categoria");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre de la Categoria");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sexo");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Categoria");

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

        campoultimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoultimoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoultimoKeyTyped(evt);
            }
        });

        campoprimer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoprimerKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoprimerKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Último año");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Primer año");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(camposerial, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(bguardar)
                                .addGap(32, 32, 32)
                                .addComponent(blimpiar)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(camponombre, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 42, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bsalir)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(campoultimo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(rfemenino))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rmasculino)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(campoprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(camposerial, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(camponombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(campoultimo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(campoprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rmasculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rfemenino)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(blimpiar)
                            .addComponent(bsalir))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bguardar)
                        .addGap(38, 38, 38))))
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

    private void rmasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmasculinoActionPerformed
        rmasculino.setSelected(true);
        if(rmasculino.isSelected()==true){
            rmasculino.setSelected(true);
            rfemenino.setSelected(false);
        }
    }//GEN-LAST:event_rmasculinoActionPerformed

    private void blimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_blimpiarActionPerformed

    private void rfemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rfemeninoActionPerformed
       if(rfemenino.isSelected()==true){
           rfemenino.setSelected(true);
           rmasculino.setSelected(false);
       }
    }//GEN-LAST:event_rfemeninoActionPerformed
   int crt;
    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        
        String serial= agregarcategoria.camposerial.getText();
        String nombre= agregarcategoria.camponombre.getText();
        int year_final= Integer.parseInt(agregarcategoria.campoultimo.getText());
        int year_ini= Integer.parseInt(agregarcategoria.campoprimer.getText());
        String sexo;
        if(rmasculino.isSelected()==true){
           sexo="Masculino";
        }else{
            sexo="Femenino";
        }
        
        try{
            String sql="Select * from categoria where id_categoria='"+serial+"'";
            Conexion parametros = new Conexion();
            Class.forName(parametros.getDriver());
            Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            if(rs.first()){
           crt=2;     
            }
        }catch(SQLException ex){
            Logger.getLogger(agregarcategoria.class.getName()).log(Level.SEVERE,null,ex);
        }catch(ClassNotFoundException e){
            Logger.getLogger(agregarcategoria.class.getName()).log(Level.SEVERE,null,e);
        }
        
        if(crt==2){
            JOptionPane.showMessageDialog(this,"El serial ya se encuentra en la base de datos","Informacion", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
        }else{
            try{
                datocategoria user=new datocategoria(serial,nombre,year_final,year_ini,sexo);
                categoria in = new categoria();
                boolean r;
                r=in.Insertar(user);
                if(r==false){
                    JOptionPane.showMessageDialog(this,"Registro Exitoso","Guardado",JOptionPane.INFORMATION_MESSAGE);
                    int opc=JOptionPane.showConfirmDialog(null,"Desea guardar otra categoria?","Informacion",JOptionPane.YES_NO_OPTION);
                    if(opc==0){
                        limpiar();
                       if(pcategoria.rmasculino.isSelected()==true){
                            pcategoria.cargarmasculino();  
                        }else{
                                pcategoria.cargarfemenino();
                        }
                    }else{
                        if(pcategoria.rmasculino.isSelected()==true){
                            pcategoria.cargarmasculino();  
                        }else{
                                pcategoria.cargarfemenino();
                        }
                      
                    
                        Gadministracion.paneladministracion.remove(this);
                        pcategoria.habilitar();
                    }
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }catch(ClassNotFoundException e){
                Logger.getLogger(agregarcategoria.class.getName()).log(Level.SEVERE,null,e);
            }
        }
    }//GEN-LAST:event_bguardarActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        Gadministracion.paneladministracion.remove(this);
        pcategoria.habilitar();
    }//GEN-LAST:event_bsalirActionPerformed

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

    private void camponombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camponombreKeyTyped
       

    }//GEN-LAST:event_camponombreKeyTyped

    private void campoultimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoultimoKeyTyped
        int Limite=4;
    char K;
    K=evt.getKeyChar();
    if (campoultimo.getText().length()== Limite){
     evt.consume();
    }
    if(K<'0'|| K>'9'){
     evt.consume();
    }
    }//GEN-LAST:event_campoultimoKeyTyped

    private void campoprimerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoprimerKeyTyped
        int Limite=4;
    char K;
    K=evt.getKeyChar();
    if (campoprimer.getText().length()== Limite){
     evt.consume();
    }
    if(K<'0'|| K>'9'){
     evt.consume();
    }
    }//GEN-LAST:event_campoprimerKeyTyped

    private void camposerialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camposerialKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_camposerialKeyReleased

    private void camponombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camponombreKeyReleased
         this.HabilitarGuardar();
    }//GEN-LAST:event_camponombreKeyReleased

    private void campoultimoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoultimoKeyReleased
         this.HabilitarGuardar();
    }//GEN-LAST:event_campoultimoKeyReleased

    private void campoprimerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoprimerKeyReleased
         this.HabilitarGuardar();
    }//GEN-LAST:event_campoprimerKeyReleased

    private void rmasculinoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rmasculinoKeyReleased
         this.HabilitarGuardar();
    }//GEN-LAST:event_rmasculinoKeyReleased

    private void rfemeninoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rfemeninoKeyReleased
         this.HabilitarGuardar();
    }//GEN-LAST:event_rfemeninoKeyReleased

    private void rmasculinoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rmasculinoKeyPressed
         this.HabilitarGuardar();
    }//GEN-LAST:event_rmasculinoKeyPressed

    private void rfemeninoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rfemeninoKeyPressed
         this.HabilitarGuardar();
    }//GEN-LAST:event_rfemeninoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bguardar;
    public static javax.swing.JButton blimpiar;
    public static javax.swing.JButton bsalir;
    public static javax.swing.JTextField camponombre;
    public static javax.swing.JTextField campoprimer;
    public static javax.swing.JTextField camposerial;
    public static javax.swing.JTextField campoultimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JRadioButton rfemenino;
    public static javax.swing.JRadioButton rmasculino;
    // End of variables declaration//GEN-END:variables
}
