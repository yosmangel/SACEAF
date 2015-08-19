
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


public final class Semifinal extends javax.swing.JPanel {

    DefaultComboBoxModel combox1 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox2 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox3 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox4 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox1 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox2 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox3 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox4 = new DefaultComboBoxModel();

    public Semifinal() {
        initComponents();
        cargarcombo1();
        cargarcombo2();
        cargarcombo3();
        cargarcombo4();
        verificardatos();
    }
    static String dcategoria,id_categoria,id_torneo,letra1,letra2,instancia,idcruce, lsexo;
    static int numero1,numero2,opc;
    String categoria,idcategoria,idtorneo,idcompetencia,idmodalidad,postfase;
    int grupos;
    public void cargarcombo1(){
         categoria=panelcrear.combocategoria.getSelectedItem().toString();
         idtorneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+lsexo+"';");
          while(rs.first()){
          idcategoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo2(){
         categoria=panelcrear.combocategoria.getSelectedItem().toString();
         idtorneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+lsexo+"';");
          while(rs.first()){
          idcategoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo3(){
         categoria=panelcrear.combocategoria.getSelectedItem().toString();
         idtorneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+lsexo+"';");
          while(rs.first()){
          idcategoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(grupos!=0){
          combo3.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_variable from variables"+grupos+";");
          while(rs.next()){
              combox3.addElement(rs.getObject("id_variable"));
              combo3.setModel(combox3);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo4(){
         categoria=panelcrear.combocategoria.getSelectedItem().toString();
         idtorneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+lsexo+"';");
          while(rs.first()){
          idcategoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(grupos!=0){
          combo4.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_variable from variables"+grupos+";");
          while(rs.next()){
              combox4.addElement(rs.getObject("id_variable"));
              combo4.setModel(combox4);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
          }
         //////////////////////////////////////////////
          idcruce=id_torneo+id_categoria+"2"+"1";
          letra1=combo1.getSelectedItem().toString();
          letra2=combo2.getSelectedItem().toString();
          numero1=Integer.parseInt(equipo1.getText());
          numero2=Integer.parseInt(equipo2.getText());
          instancia="Semifinal";

          try{
             datopostfase user= new datopostfase(idcruce,instancia,letra1,numero1,letra2,numero2,id_torneo,id_categoria);
             postfase in= new postfase();
             boolean r;
             r=in.Insertar(user);
             
          }catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
          }catch(ClassNotFoundException ex){
              Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
          }
         //////////////////////////////////////////////////////////////////////
          idcruce=id_torneo+id_categoria+"2"+"2";
          letra1=combo3.getSelectedItem().toString();
          letra2=combo4.getSelectedItem().toString();
          numero1=Integer.parseInt(equipo3.getText());
          numero2=Integer.parseInt(equipo4.getText());
          instancia="Semifinal";

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
              Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
          }
         /////////////////////////////////////////////////////////////////////////////////
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
          equipo1.setText(Integer.toString(numero1));
          equipo2.setText(Integer.toString(numero2));
          combo1.setEnabled(false);
          combo2.setEnabled(false);
          equipo1.setEnabled(false);
          equipo2.setEnabled(false);
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
          }
         ////////////////////////////////////////////////////////////////////
          idcruce=id_torneo+id_categoria+"2"+"2";
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
          combo3.removeAllItems();
          scombox3.addElement(letra1);
          combo3.setModel(scombox3);
          combo4.removeAllItems();
          scombox4.addElement(letra2);
          combo4.setModel(scombox4);
          equipo3.setText(Integer.toString(numero1));
          equipo4.setText(Integer.toString(numero2));
          combo3.setEnabled(false);
          combo4.setEnabled(false);
          equipo3.setEnabled(false);
          equipo4.setEnabled(false);
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          

      }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        equipo3 = new javax.swing.JTextField();
        combo3 = new javax.swing.JComboBox();
        combo4 = new javax.swing.JComboBox();
        equipo4 = new javax.swing.JTextField();
        combo1 = new javax.swing.JComboBox();
        combo2 = new javax.swing.JComboBox();
        equipo1 = new javax.swing.JTextField();
        equipo2 = new javax.swing.JTextField();
        finalista1 = new javax.swing.JTextField();
        finalista2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Campeon = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(561, 240));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(561, 240));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        equipo3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(equipo3);
        equipo3.setBounds(413, 37, 87, 29);

        jPanel1.add(combo3);
        combo3.setBounds(506, 37, 42, 29);

        jPanel1.add(combo4);
        combo4.setBounds(506, 165, 42, 28);

        equipo4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(equipo4);
        equipo4.setBounds(413, 165, 87, 28);

        jPanel1.add(combo1);
        combo1.setBounds(10, 37, 42, 29);

        jPanel1.add(combo2);
        combo2.setBounds(10, 165, 42, 28);

        equipo1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(equipo1);
        equipo1.setBounds(58, 37, 87, 29);

        equipo2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(equipo2);
        equipo2.setBounds(58, 165, 87, 28);

        finalista1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        finalista1.setText("finalista1");
        finalista1.setEnabled(false);
        jPanel1.add(finalista1);
        finalista1.setBounds(98, 106, 100, 29);

        finalista2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        finalista2.setText("finalista2");
        finalista2.setEnabled(false);
        jPanel1.add(finalista2);
        finalista2.setBounds(359, 106, 100, 29);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Vs");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(270, 112, 13, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("|");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(110, 140, 10, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("|");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(420, 70, 10, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("|");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(420, 130, 10, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("|");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(110, 70, 10, 30);

        Campeon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Campeon.setText("Campeon");
        Campeon.setEnabled(false);
        jPanel1.add(Campeon);
        Campeon.setBounds(220, 150, 100, 30);

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField Campeon;
    public static javax.swing.JComboBox combo1;
    public static javax.swing.JComboBox combo2;
    public static javax.swing.JComboBox combo3;
    public static javax.swing.JComboBox combo4;
    public static javax.swing.JTextField equipo1;
    public static javax.swing.JTextField equipo2;
    public static javax.swing.JTextField equipo3;
    public static javax.swing.JTextField equipo4;
    public static javax.swing.JTextField finalista1;
    public static javax.swing.JTextField finalista2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
