
package torneocronograma;

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
import saceaf.Principal;
import torneodatoscronograma.datopostfase;
import torneodatoscronograma.postfase;


public final class Final extends javax.swing.JPanel {

    DefaultComboBoxModel combox1 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox2 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox1 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox2 = new DefaultComboBoxModel();
    static String dcategoria,id_categoria,id_torneo,letra1,letra2,instancia,idcruce,lsexo;
    String categoria,idcategoria,idtorneo,idcompetencia,idmodalidad,postfase;
    int grupos;
    static int numero1,numero2,opc;
    
    public Final() {
        initComponents();
        cargarcombo1();
        cargarcombo2();
        verificardatos();
    }
    
      public void cargarcombo1(){
         categoria=panelcrear.combocategoria.getSelectedItem().toString();
         idtorneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          idcategoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Final.class.getName()).log(Level.SEVERE,null,ex);
          }
          idmodalidad=idtorneo+idcategoria+"2";
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select postfase from modalidad where id_modalidad='"+idmodalidad+"';");
          while(rs.first()){
          postfase=rs.getString("postfase");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Final.class.getName()).log(Level.SEVERE,null,ex);
          }
          idcompetencia=idmodalidad+postfase;
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select grupos from competencia where id_competencia='"+idcompetencia+"';");
          while(rs.first()){
          grupos=rs.getInt("grupos");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Final.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(grupos!=0){
          combo1.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_variable from variables"+grupos+";");
          while(rs.next()){
              combox1.addElement(rs.getObject("id_variable"));
              combo1.setModel(combox1);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Final.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
      public void cargarcombo2(){
         categoria=panelcrear.combocategoria.getSelectedItem().toString();
         idtorneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getName();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          idcategoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Final.class.getName()).log(Level.SEVERE,null,ex);
          }
          idmodalidad=idtorneo+idcategoria+"2";
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select postfase from modalidad where id_modalidad='"+idmodalidad+"';");
          while(rs.first()){
          postfase=rs.getString("postfase");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Final.class.getName()).log(Level.SEVERE,null,ex);
          }
          idcompetencia=idmodalidad+postfase;
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select grupos from competencia where id_competencia='"+idcompetencia+"';");
          while(rs.first()){
          grupos=rs.getInt("grupos");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Final.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(grupos!=0){
          combo2.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_variable from variables"+grupos+";");
          while(rs.next()){
              combox2.addElement(rs.getObject("id_variable"));
              combo2.setModel(combox2);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Final.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
      public static void guardardatos(){
          dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo='"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Final.class.getName()).log(Level.SEVERE,null,ex);
          }
          idcruce=id_torneo+id_categoria+"2"+"1";
          letra1=combo1.getSelectedItem().toString();
          letra2=combo2.getSelectedItem().toString();
          numero1=Integer.parseInt(finalista1.getText());
          numero2=Integer.parseInt(finalista2.getText());
          instancia="Final";

          try{
             datopostfase user= new datopostfase(idcruce,instancia,letra1,numero1,letra2,numero2,id_torneo,id_categoria);
             postfase in= new postfase();
             boolean r;
             r=in.Insertar(user);
             if(r==false){
                 JOptionPane.showMessageDialog(null,"Postfase guardada","Informacion",JOptionPane.INFORMATION_MESSAGE);
             }
          }catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
          }catch(ClassNotFoundException ex){
              Logger.getLogger(Final.class.getName()).log(Level.SEVERE,null,ex);
          }
          
      }
      public static void verificardatos(){
          dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo='"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Final.class.getName()).log(Level.SEVERE,null,ex);
          }
          idcruce=id_torneo+id_categoria+"2"+"1";
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select letra_grupo1,numero_clasificado1,letra_grupo2,numero_clasificado2"
                  + " from crucepostfase where id_crucepostfase='"+idcruce+"';");
          while(rs.first()){
          letra1=rs.getString("letra_grupo1");
          letra2=rs.getString("letra_grupo2");
          numero1=rs.getInt("numero_clasificado1");
          numero2=rs.getInt("numero_clasificado2");
          combo1.removeAllItems();
          scombox1.addElement(letra1);
          combo1.setModel(scombox1);
          combo2.removeAllItems();
          scombox2.addElement(letra2);
          combo2.setModel(scombox2);
          finalista1.setText(Integer.toString(numero1));
          finalista2.setText(Integer.toString(numero2));
          combo1.setEnabled(false);
          combo2.setEnabled(false);
          finalista1.setEnabled(false);
          finalista2.setEnabled(false);
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Final.class.getName()).log(Level.SEVERE,null,ex);
          }
       }
      
      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        combo1 = new javax.swing.JComboBox();
        combo2 = new javax.swing.JComboBox();
        finalista1 = new javax.swing.JTextField();
        finalista2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Campeon = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(561, 240));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(561, 240));
        jPanel1.setOpaque(false);

        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
            }
        });

        finalista2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Vs");

        Campeon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Campeon.setText("Campeon");
        Campeon.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finalista1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(finalista2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(Campeon, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finalista1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finalista2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(Campeon, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
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

    private void combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1ActionPerformed
        
    }//GEN-LAST:event_combo1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField Campeon;
    public static javax.swing.JComboBox combo1;
    public static javax.swing.JComboBox combo2;
    public static javax.swing.JTextField finalista1;
    public static javax.swing.JTextField finalista2;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
