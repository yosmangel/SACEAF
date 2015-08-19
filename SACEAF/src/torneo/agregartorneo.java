
package torneo;

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
import torneodatos.datostorneo;
import torneodatos.torneo;


public class agregartorneo extends javax.swing.JPanel {
    DefaultComboBoxModel cdisciplina= new DefaultComboBoxModel();

    
    public agregartorneo() {
        initComponents();
        cargardisciplina();
    }
public void HabilitarGuardar(){
    String Nombre=agregartorneo.camponombre.getText();
    String Yearini=agregartorneo.yearini.getText();
    String Mesini=agregartorneo.mesini.getText();
    String Diaini=agregartorneo.diaini.getText();
    String Yearfin=agregartorneo.yearfin.getText();
    String Mesfin=agregartorneo.mesini.getText();
    String Diafin=agregartorneo.diafin.getText();
    
    if(Nombre.isEmpty() || Yearini.isEmpty() || Mesini.isEmpty() || Diaini.isEmpty() || Yearfin.isEmpty() || Mesfin.isEmpty() || Diafin.isEmpty()){
        agregartorneo.bguardar.setEnabled(false);
    }
    else{
        agregartorneo.bguardar.setEnabled(true);
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
        while(rs.next()){
            cdisciplina.addElement(rs.getObject("nombre_disciplina"));
            combodisciplina.setModel(cdisciplina);
        }
        st.close();
    }catch(SQLException | ClassNotFoundException ex){
        Logger.getLogger(agregartorneo.class.getName()).log(Level.SEVERE,null,ex);
    }
    } 
public void limpiar(){
        camponombre.setText("");
        yearini.setText("");
        mesini.setText("");
        diaini.setText("");
        yearfin.setText("");
        mesfin.setText("");
        diafin.setText("");
        bguardar.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        camponombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        combodisciplina = new javax.swing.JComboBox();
        yearini = new javax.swing.JTextField();
        mesini = new javax.swing.JTextField();
        diaini = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        yearfin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        mesfin = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        diafin = new javax.swing.JTextField();
        bguardar = new javax.swing.JButton();
        blimpiar = new javax.swing.JButton();
        bsalir = new javax.swing.JButton();
        rmasculino = new javax.swing.JRadioButton();
        rfemenino = new javax.swing.JRadioButton();

        setMinimumSize(new java.awt.Dimension(840, 288));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(840, 288));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar Torneo");

        camponombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                camponombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camponombreKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nombre del Torneo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tipo de Competencia");

        yearini.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                yeariniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                yeariniKeyTyped(evt);
            }
        });

        mesini.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mesiniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mesiniKeyTyped(evt);
            }
        });

        diaini.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                diainiKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                diainiKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("/");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("/");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Inicio");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Finaliza");

        yearfin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                yearfinKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                yearfinKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("/");

        mesfin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mesfinKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mesfinKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mesfinKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("/");

        diafin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                diafinKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                diafinKeyTyped(evt);
            }
        });

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

        rmasculino.setText("Masculino");
        rmasculino.setContentAreaFilled(false);

        rfemenino.setText("Femenino");
        rfemenino.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(365, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(352, 352, 352))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bguardar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(22, 22, 22)
                                .addComponent(diaini, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mesini, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yearini, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(camponombre, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(blimpiar)
                                .addGap(96, 96, 96))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(22, 22, 22)
                                .addComponent(diafin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(mesfin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bsalir)
                                .addGap(27, 27, 27))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yearfin, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(combodisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rfemenino)
                            .addComponent(rmasculino))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(camponombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(combodisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rmasculino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rfemenino)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yearfin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mesfin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(yearini, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mesini, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(diaini, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diafin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bguardar)
                            .addComponent(blimpiar)))
                    .addComponent(bsalir))
                .addContainerGap(30, Short.MAX_VALUE))
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

    String serialtorneo;
    int nserial,total;
    String disciplina,sexo;
    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        try{
            String sql="Select id_torneo from torneo ;";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           if(rs.last()){
             serialtorneo=rs.getString("id_torneo");
             int serial=Integer.parseInt(serialtorneo);
             serial=serial+1;
             serialtorneo=Integer.toString(serial);
             }else{
              int serial=0;
                 serial=serial+1;
                 serialtorneo=Integer.toString(serial);
             }
             
           
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(agregartorneo.class.getName()).log(Level.SEVERE,null,ex);
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
           Logger.getLogger(agregartorneo.class.getName()).log(Level.SEVERE,null,ex);
       }
    
        serialtorneo=serialtorneo+disciplina;
        String nombretorneo=camponombre.getText();
        String anoini=yearini.getText();
        String meini=mesini.getText();
        String diainic=diaini.getText();
        String fechaini=anoini+"/"+meini+"/"+diainic;
        String anofin=yearfin.getText();
        String mefin=mesfin.getText();
        String difin=diafin.getText();
        String fechafin=anofin+"/"+mefin+"/"+difin;
        if(rmasculino.isSelected()==true){
            sexo="Masculino";
        }else{
            sexo="Femenino";
        }
        try{
            datostorneo user= new datostorneo(serialtorneo,nombretorneo,fechaini,fechafin,disciplina,sexo);
            torneo in= new torneo();
            boolean r;
            r=in.Insertar(user);
            if(r==false){
                JOptionPane.showMessageDialog(this,"Registro Exitoso","Guardado",JOptionPane.INFORMATION_MESSAGE);
                int opc= JOptionPane.showConfirmDialog(null, "Desea Guardar otro torneo en la base de datos?", "Informacion", JOptionPane.YES_NO_OPTION);
                if(opc==0){
                    limpiar();
                    tmostrar.cargartorneo();
                }else{
                    principaltorneo.paneltorneo.remove(this);
                   tmostrar.cargartorneo();
                }
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this,"Error "+ex.getMessage(),"Error...",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException e){
            Logger.getLogger(agregartorneo.class.getName()).log(Level.SEVERE,null, e);
        }
    }//GEN-LAST:event_bguardarActionPerformed

    private void blimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_blimpiarActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        principaltorneo.paneltorneo.remove(this);
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

    private void yeariniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yeariniKeyTyped
                     int Limite=4;
    char K;
    K=evt.getKeyChar();
    if (yearini.getText().length()== Limite){
     evt.consume();
    }
    if(K<'0'|| K>'9'){
     evt.consume();
    }
    }//GEN-LAST:event_yeariniKeyTyped

    private void mesiniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mesiniKeyTyped
                     int Limite=2;
    char K;
    K=evt.getKeyChar();
    if (mesini.getText().length()== Limite){
     evt.consume();
    }
    if(K<'0'|| K>'9'){
     evt.consume();
    }
    }//GEN-LAST:event_mesiniKeyTyped

    private void diainiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_diainiKeyTyped
                     int Limite=2;
    char K;
    K=evt.getKeyChar();
    if (diaini.getText().length()== Limite){
     evt.consume();
    }
    if(K<'0'|| K>'9'){
     evt.consume();
    }
    }//GEN-LAST:event_diainiKeyTyped

    private void yearfinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearfinKeyTyped
                     int Limite=4;
    char K;
    K=evt.getKeyChar();
    if (yearfin.getText().length()== Limite){
     evt.consume();
    }
    if(K<'0'|| K>'9'){
     evt.consume();
    }
    }//GEN-LAST:event_yearfinKeyTyped

    private void mesfinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mesfinKeyTyped
                     int Limite=2;
    char K;
    K=evt.getKeyChar();
    if (mesfin.getText().length()== Limite){
     evt.consume();
    }
    if(K<'0'|| K>'9'){
     evt.consume();
    }
    }//GEN-LAST:event_mesfinKeyTyped

    private void diafinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_diafinKeyTyped
                     int Limite=2;
    char K;
    K=evt.getKeyChar();
    if (diafin.getText().length()== Limite){
     evt.consume();
    }
    if(K<'0'|| K>'9'){
     evt.consume();
    }
    }//GEN-LAST:event_diafinKeyTyped

    private void camponombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camponombreKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_camponombreKeyReleased

    private void yeariniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yeariniKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_yeariniKeyReleased

    private void mesiniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mesiniKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_mesiniKeyReleased

    private void diainiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_diainiKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_diainiKeyReleased

    private void yearfinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearfinKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_yearfinKeyReleased

    private void mesfinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mesfinKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesfinKeyPressed

    private void mesfinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mesfinKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_mesfinKeyReleased

    private void diafinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_diafinKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_diafinKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bguardar;
    public static javax.swing.JButton blimpiar;
    public static javax.swing.JButton bsalir;
    public static javax.swing.JTextField camponombre;
    public static javax.swing.JComboBox combodisciplina;
    public static javax.swing.JTextField diafin;
    public static javax.swing.JTextField diaini;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField mesfin;
    public static javax.swing.JTextField mesini;
    public static javax.swing.JRadioButton rfemenino;
    public static javax.swing.JRadioButton rmasculino;
    public static javax.swing.JTextField yearfin;
    public static javax.swing.JTextField yearini;
    // End of variables declaration//GEN-END:variables
}
