/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneo;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import saceaf.Principal;
import saceaf.torneoprincipal;

/**
 *
 * @author Gatito
 */
public class principaltorneo extends javax.swing.JPanel {

    /**
     * Creates new form principaltorneo
     */
    public principaltorneo() {
        initComponents();
        abrirmostrar();
    }

    public static void torneop(){
       
        String nombre=(String) tmostrar.tablatorneo.getValueAt(tmostrar.tablatorneo.getSelectedRow(),0);
        torneoprincipal tp= new torneoprincipal();
        String titulo="'"+nombre+"'";
        int index= Principal.panelprincipal.indexOfTab(titulo);
        if(index==-1){
            Principal.panelprincipal.addTab(titulo, tp);
            int i= Principal.panelprincipal.indexOfTab(titulo);
            Principal.panelprincipal.setSelectedIndex(i);
        }else{
            Principal.panelprincipal.remove(index);
            Principal.panelprincipal.addTab(titulo, tp);
            int i= Principal.panelprincipal.indexOfTab(titulo);
            Principal.panelprincipal.setSelectedIndex(i);
        }
    }
    public void acceder(){
        String nombretorneo= (String) tmostrar.tablatorneo.getValueAt(tmostrar.tablatorneo.getSelectedRow(),0);
          String disciplina=(String) tmostrar.tablatorneo.getValueAt(tmostrar.tablatorneo.getSelectedRow(),3 );
          String sexo=(String) tmostrar.tablatorneo.getValueAt(tmostrar.tablatorneo.getSelectedRow(),4);
          Principal.labelnombretorneo.setText(nombretorneo);
          Principal.labeldisciplina.setText(disciplina);
          Principal.labelsexo.setText(sexo);
          try{
           String sql="Select id_torneo from torneo where nombre_t='"+nombretorneo+"'";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
               String idtorneo=rs.getString("id_torneo");
               Principal.labelserialtorneo.setText(idtorneo);
               break;
          } 
       }catch(SQLException ex){
           Logger.getLogger(principaltorneo.class.getName()).log(Level.SEVERE,null,ex);
       }catch(ClassNotFoundException e){
           Logger.getLogger(principaltorneo.class.getName()).log(Level.SEVERE,null,e);
       }  
        Principal.habilitar2();
        Principal.inhabilitar2();
        try{
        int tamano=Principal.panelprincipal.getTabCount();              
        for(int i=0;i<=tamano;i++){
                 Principal.panelprincipal.remove(i);
                 i--;
                 tamano=Principal.panelprincipal.getTabCount(); 
                 if( tamano== 0){
                     break;
                 }
                 }
          torneop();
          
        }catch(Exception e){
            
        }
    }
    public void abrirmostrar(){
        tmostrar tm= new tmostrar();
        String titulo="";
        int index= paneltorneo.indexOfTab(titulo);
        if(index==-1){
            paneltorneo.addTab(titulo, tm);
            int i= paneltorneo.indexOfTab(titulo);
            paneltorneo.setSelectedIndex(i);
        }else{
            paneltorneo.remove(index);
            paneltorneo.addTab(titulo, tm);
            int i= paneltorneo.indexOfTab(titulo);
            paneltorneo.setSelectedIndex(i);
        }
    }
    public void agregartorneo(){
        agregartorneo at= new agregartorneo();
        String titulo="Agregar Torneo";
        int index= paneltorneo.indexOfTab(titulo);
        if(index==-1){
            paneltorneo.addTab(titulo, at);
            int i= paneltorneo.indexOfTab(titulo);
            paneltorneo.setSelectedIndex(i);
        }else{
            paneltorneo.remove(index);
            paneltorneo.addTab(titulo, at);
            int i= paneltorneo.indexOfTab(titulo);
            paneltorneo.setSelectedIndex(i);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        paneltorneo = new javax.swing.JTabbedPane();
        jLabel2 = new javax.swing.JLabel();
        bagregar = new javax.swing.JButton();
        bacceder = new javax.swing.JButton();
        bmodificar = new javax.swing.JButton();
        bsalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1000, 412));
        setVerifyInputWhenFocusTarget(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel1.setLayout(null);

        jPanel2.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 412));

        paneltorneo.setMinimumSize(new java.awt.Dimension(832, 280));
        paneltorneo.setPreferredSize(new java.awt.Dimension(832, 208));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Torneos");

        bagregar.setForeground(new java.awt.Color(255, 255, 255));
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

        bacceder.setForeground(new java.awt.Color(255, 255, 255));
        bacceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/acceder30x30.png"))); // NOI18N
        bacceder.setText("Acceder");
        bacceder.setContentAreaFilled(false);
        bacceder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bacceder.setIconTextGap(-2);
        bacceder.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/acceder40x40.png"))); // NOI18N
        bacceder.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bacceder.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bacceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baccederActionPerformed(evt);
            }
        });

        bmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Edit 30x30.png"))); // NOI18N
        bmodificar.setText("Modificar");
        bmodificar.setContentAreaFilled(false);
        bmodificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bmodificar.setIconTextGap(-2);
        bmodificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Edit 40x40.png"))); // NOI18N
        bmodificar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bmodificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmodificarActionPerformed(evt);
            }
        });

        bsalir.setForeground(new java.awt.Color(255, 255, 255));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(471, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(370, 370, 370)
                .addComponent(bsalir)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(bagregar)
                        .addComponent(bacceder))
                    .addComponent(bmodificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paneltorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bsalir)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(bagregar)
                        .addGap(44, 44, 44)
                        .addComponent(bacceder)
                        .addGap(32, 32, 32)
                        .addComponent(bmodificar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(paneltorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1000, 410);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondos/FondoMedioDifuminado.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 410);

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

    private void bmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmodificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bmodificarActionPerformed

    private void baccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baccederActionPerformed
        try{
            acceder();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Debe seleccionar un torneo para poder acceder","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_baccederActionPerformed

    private void bagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagregarActionPerformed
        agregartorneo();
    }//GEN-LAST:event_bagregarActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        Principal.panelprincipal.remove(this);
    }//GEN-LAST:event_bsalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bacceder;
    public static javax.swing.JButton bagregar;
    public static javax.swing.JButton bmodificar;
    public static javax.swing.JButton bsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JTabbedPane paneltorneo;
    // End of variables declaration//GEN-END:variables
}
