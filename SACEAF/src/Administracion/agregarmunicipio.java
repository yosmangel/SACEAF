

package Administracion;

import Basededatos.Conexion;
import Datosadministracion.datosmunicipio;
import Datosadministracion.municipio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class agregarmunicipio extends javax.swing.JPanel {

    public agregarmunicipio() {
        initComponents();
    }
public void HabilitarGuardar(){
    String Serial=this.camposerial.getText();
    String Nombre=this.camponombre.getText();
    
    if(Nombre.isEmpty() || Serial.isEmpty()){
        this.bguardar.setEnabled(false);
    }
    else{
        this.bguardar.setEnabled(true);
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bguardar = new javax.swing.JButton();
        blimpiar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        camposerial = new javax.swing.JTextField();
        camponombre = new javax.swing.JTextField();
        bsalir = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(630, 290));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(630, 290));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Agregar los Datos del");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Municipio");

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Serial del Municipio");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nombre del Municipio");

        camposerial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                camposerialKeyReleased(evt);
            }
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
                .addGap(200, 200, 200)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(camposerial, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(blimpiar)
                                .addComponent(camponombre, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(bguardar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(bsalir)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(camposerial, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(camponombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(blimpiar)
                            .addComponent(bguardar))))
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
int c;
    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        String serial= agregarmunicipio.camposerial.getText();
        String nombre= agregarmunicipio.camponombre.getText();
        
        try{
            String sql="Select * from municipio where id_municipio='"+serial+"';";
            Conexion parametros= new Conexion();
            Class.forName(parametros.getDriver());
            Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs= st.executeQuery(sql);
            while(rs.first()){
            c=2;    
            }
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(agregarmunicipio.class.getName()).log(Level.SEVERE,null,ex);
        }
        if(c==2){
         JOptionPane.showMessageDialog(this,"El serial del municipio ya se encuentra en la base de datos","Informacion",JOptionPane.INFORMATION_MESSAGE);
         camposerial.setText("");
         camponombre.setText("");
         camposerial.requestFocus();
        }else{
        try{
            datosmunicipio user= new datosmunicipio(serial,nombre);
            municipio in= new municipio();
            boolean r;
            r= in.Insertar(user);
            if(r==false){
                JOptionPane.showMessageDialog(this, "Registro Exitoso", "Guardado!", JOptionPane.INFORMATION_MESSAGE);
                int opc=JOptionPane.showConfirmDialog(null,"Desea guar otro Municipio en la Base de Datos?","Informacion", JOptionPane.YES_NO_OPTION);
               if(opc==0){
                   camposerial.setText("");
                   camponombre.setText("");
                   pmunicipio.cargarmunicipio();
                   camposerial.requestFocus();
                   bguardar.setEnabled(false);
               } else{
                   pmunicipio.tablamunicipios.remove(this);
                   pmunicipio.cargarmunicipio();
                    Gadministracion.paneladministracion.remove(this);
                    pmunicipio.habilitar();
               }
            }
            }catch(SQLException ex){
             JOptionPane.showMessageDialog(this,"Error"+ex.getMessage(),"Error...", JOptionPane.ERROR_MESSAGE);
            }catch(ClassNotFoundException e){
                Logger.getLogger(agregarmunicipio.class.getName()).log(Level.SEVERE,null,e);
            }
        }
    }//GEN-LAST:event_bguardarActionPerformed

    private void blimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blimpiarActionPerformed
      camponombre.setText("");
      camposerial.setText("");
      camposerial.requestFocus();
      bguardar.setEnabled(false);
    }//GEN-LAST:event_blimpiarActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
      Gadministracion.paneladministracion.remove(this);
      pmunicipio.habilitar();
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
               int Limite=50;
    char K;
    K=evt.getKeyChar();
    if (camposerial.getText().length()== Limite){
     evt.consume();
    }
    if(!(K<'0'|| K>'9')){
     evt.consume();
    }
    }//GEN-LAST:event_camponombreKeyTyped

    private void camposerialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camposerialKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_camposerialKeyReleased

    private void camponombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camponombreKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_camponombreKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bguardar;
    public static javax.swing.JButton blimpiar;
    public static javax.swing.JButton bsalir;
    public static javax.swing.JTextField camponombre;
    public static javax.swing.JTextField camposerial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
