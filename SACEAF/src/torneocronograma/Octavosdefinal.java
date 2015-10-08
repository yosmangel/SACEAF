
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


public final class Octavosdefinal extends javax.swing.JPanel {

    DefaultComboBoxModel combox1 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox2 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox3 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox4 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox5 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox6 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox7 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox8 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox9 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox10 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox11 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox12 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox13 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox14 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox15 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox16 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox1 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox2 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox3 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox4 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox5 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox6 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox7 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox8 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox9 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox10 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox11 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox12 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox13 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox14 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox15 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox16 = new DefaultComboBoxModel();
    static String dcategoria,id_categoria,id_torneo,letra1,letra2,instancia,idcruce,lsexo;
    static int numero1,numero2,opc;
    String categoria,idcategoria,idtorneo,idcompetencia,idmodalidad,postfase;
    int grupos;
    
    public Octavosdefinal() {
        initComponents();
        cargarcombo1();
        cargarcombo2();
        cargarcombo3();
        cargarcombo4();
        cargarcombo5();
        cargarcombo6();
        cargarcombo7();
        cargarcombo8();
        cargarcombo9();
        cargarcombo10();
        cargarcombo11();
        cargarcombo12();
        cargarcombo13();
        cargarcombo14();
        cargarcombo15();
        cargarcombo16();
        verificardatos();
        
    }

    
    public void cargarcombo1(){
         dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo2(){
         dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo3(){
         dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo4(){
         dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo5(){
         dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(grupos!=0){
          combo5.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_variable from variables"+grupos+";");
          while(rs.next()){
              combox5.addElement(rs.getObject("id_variable"));
              combo5.setModel(combox5);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo6(){
         dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(grupos!=0){
          combo6.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_variable from variables"+grupos+";");
          while(rs.next()){
              combox6.addElement(rs.getObject("id_variable"));
              combo6.setModel(combox6);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo7(){
         dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(grupos!=0){
          combo7.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_variable from variables"+grupos+";");
          while(rs.next()){
              combox7.addElement(rs.getObject("id_variable"));
              combo7.setModel(combox7);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo8(){
         dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(grupos!=0){
          combo8.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_variable from variables"+grupos+";");
          while(rs.next()){
              combox8.addElement(rs.getObject("id_variable"));
              combo8.setModel(combox8);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo9(){
         dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(grupos!=0){
          combo9.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_variable from variables"+grupos+";");
          while(rs.next()){
              combox9.addElement(rs.getObject("id_variable"));
              combo9.setModel(combox9);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo10(){
         dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(grupos!=0){
          combo10.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_variable from variables"+grupos+";");
          while(rs.next()){
              combox10.addElement(rs.getObject("id_variable"));
              combo10.setModel(combox10);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo11(){
         dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(grupos!=0){
          combo11.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_variable from variables"+grupos+";");
          while(rs.next()){
              combox11.addElement(rs.getObject("id_variable"));
              combo11.setModel(combox11);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo12(){
         dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(grupos!=0){
          combo12.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_variable from variables"+grupos+";");
          while(rs.next()){
              combox12.addElement(rs.getObject("id_variable"));
              combo12.setModel(combox12);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo13(){
         dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(grupos!=0){
          combo13.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_variable from variables"+grupos+";");
          while(rs.next()){
              combox13.addElement(rs.getObject("id_variable"));
              combo13.setModel(combox13);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo14(){
         dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(grupos!=0){
          combo14.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_variable from variables"+grupos+";");
          while(rs.next()){
              combox14.addElement(rs.getObject("id_variable"));
              combo14.setModel(combox14);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo15(){
         dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(grupos!=0){
          combo15.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_variable from variables"+grupos+";");
          while(rs.next()){
              combox15.addElement(rs.getObject("id_variable"));
              combo15.setModel(combox15);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo16(){
          dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(grupos!=0){
          combo16.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_variable from variables"+grupos+";");
          while(rs.next()){
              combox16.addElement(rs.getObject("id_variable"));
              combo16.setModel(combox16);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
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
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
        
          /////////////////////////////////////////////////////////////
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          //////////////////////////////////////////////////////////////////////////////
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
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          //////////////////////////////////////////////////////////////////////////////
          idcruce=id_torneo+id_categoria+"2"+"3";
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
          combo5.removeAllItems();
          scombox5.addElement(letra1);
          combo5.setModel(scombox5);
          combo6.removeAllItems();
          scombox6.addElement(letra2);
          combo6.setModel(scombox6);
          equipo5.setText(Integer.toString(numero1));
          equipo6.setText(Integer.toString(numero2));
          combo5.setEnabled(false);
          combo6.setEnabled(false);
          equipo5.setEnabled(false);
          equipo6.setEnabled(false);
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          ////////////////////////////////////////////////////////////////////////
          idcruce=id_torneo+id_categoria+"2"+"4";
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
          combo7.removeAllItems();
          scombox7.addElement(letra1);
          combo7.setModel(scombox7);
          combo8.removeAllItems();
          scombox8.addElement(letra2);
          combo8.setModel(scombox8);
          equipo7.setText(Integer.toString(numero1));
          equipo8.setText(Integer.toString(numero2));
          combo7.setEnabled(false);
          combo8.setEnabled(false);
          equipo7.setEnabled(false);
          equipo8.setEnabled(false);
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          ///////////////////////////////////////////////////////////////////////
          idcruce=id_torneo+id_categoria+"2"+"5";
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
          combo9.removeAllItems();
          scombox9.addElement(letra1);
          combo9.setModel(scombox9);
          combo10.removeAllItems();
          scombox10.addElement(letra2);
          combo10.setModel(scombox10);
          equipo9.setText(Integer.toString(numero1));
          equipo10.setText(Integer.toString(numero2));
          combo9.setEnabled(false);
          combo10.setEnabled(false);
          equipo9.setEnabled(false);
          equipo10.setEnabled(false);
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          ////////////////////////////////////////////////////////////////////////////
          idcruce=id_torneo+id_categoria+"2"+"6";
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
          combo11.removeAllItems();
          scombox11.addElement(letra1);
          combo11.setModel(scombox11);
          combo12.removeAllItems();
          scombox12.addElement(letra2);
          combo12.setModel(scombox12);
          equipo11.setText(Integer.toString(numero1));
          equipo12.setText(Integer.toString(numero2));
          combo11.setEnabled(false);
          combo12.setEnabled(false);
          equipo11.setEnabled(false);
          equipo12.setEnabled(false);
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          ////////////////////////////////////////////////////////////////////////////
          idcruce=id_torneo+id_categoria+"2"+"7";
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
          combo13.removeAllItems();
          scombox13.addElement(letra1);
          combo13.setModel(scombox13);
          combo14.removeAllItems();
          scombox14.addElement(letra2);
          combo14.setModel(scombox14);
          equipo13.setText(Integer.toString(numero1));
          equipo14.setText(Integer.toString(numero2));
          combo13.setEnabled(false);
          combo14.setEnabled(false);
          equipo13.setEnabled(false);
          equipo14.setEnabled(false);
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          ////////////////////////////////////////////////////////////
          idcruce=id_torneo+id_categoria+"2"+"8";
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
          combo15.removeAllItems();
          scombox15.addElement(letra1);
          combo15.setModel(scombox15);
          combo16.removeAllItems();
          scombox16.addElement(letra2);
          combo16.setModel(scombox16);
          equipo15.setText(Integer.toString(numero1));
          equipo16.setText(Integer.toString(numero2));
          combo15.setEnabled(false);
          combo16.setEnabled(false);
          equipo15.setEnabled(false);
          equipo16.setEnabled(false);
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"' and sexo'"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          //////////////////////////////////////////////////////////////////////////
          idcruce=id_torneo+id_categoria+"2"+"1";
          letra1=combo1.getSelectedItem().toString();
          letra2=combo2.getSelectedItem().toString();
          numero1=Integer.parseInt(equipo1.getText());
          numero2=Integer.parseInt(equipo2.getText());
          instancia="Octavos de final";

          try{
             datopostfase user= new datopostfase(idcruce,instancia,letra1,numero1,letra2,numero2,id_torneo,id_categoria);
             postfase in= new postfase();
             boolean r;
             r=in.Insertar(user);
             
          }catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
          }catch(ClassNotFoundException ex){
              Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          ////////////////////////////////////////////////////////////////////////////////////////
          idcruce=id_torneo+id_categoria+"2"+"2";
          letra1=combo3.getSelectedItem().toString();
          letra2=combo4.getSelectedItem().toString();
          numero1=Integer.parseInt(equipo3.getText());
          numero2=Integer.parseInt(equipo4.getText());
          instancia="Octavos de final";

          try{
             datopostfase user= new datopostfase(idcruce,instancia,letra1,numero1,letra2,numero2,id_torneo,id_categoria);
             postfase in= new postfase();
             boolean r;
             r=in.Insertar(user);
          }catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
          }catch(ClassNotFoundException ex){
              Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          ////////////////////////////////////////////////////////////////////////////////////
          idcruce=id_torneo+id_categoria+"2"+"3";
          letra1=combo5.getSelectedItem().toString();
          letra2=combo6.getSelectedItem().toString();
          numero1=Integer.parseInt(equipo5.getText());
          numero2=Integer.parseInt(equipo6.getText());
          instancia="Octavos de final";

          try{
             datopostfase user= new datopostfase(idcruce,instancia,letra1,numero1,letra2,numero2,id_torneo,id_categoria);
             postfase in= new postfase();
             boolean r;
             r=in.Insertar(user);
             
          }catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
          }catch(ClassNotFoundException ex){
              Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
         //////////////////////////////////////////////////////////////////////////
          idcruce=id_torneo+id_categoria+"2"+"4";
          letra1=combo7.getSelectedItem().toString();
          letra2=combo8.getSelectedItem().toString();
          numero1=Integer.parseInt(equipo7.getText());
          numero2=Integer.parseInt(equipo8.getText());
          instancia="Octavos de final";

          try{
             datopostfase user= new datopostfase(idcruce,instancia,letra1,numero1,letra2,numero2,id_torneo,id_categoria);
             postfase in= new postfase();
             boolean r;
             r=in.Insertar(user);
          }catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
          }catch(ClassNotFoundException ex){
              Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          ////////////////////////////////////////////////////////////////////////
          idcruce=id_torneo+id_categoria+"2"+"5";
          letra1=combo9.getSelectedItem().toString();
          letra2=combo10.getSelectedItem().toString();
          numero1=Integer.parseInt(equipo9.getText());
          numero2=Integer.parseInt(equipo10.getText());
          instancia="Octavos de final";

          try{
             datopostfase user= new datopostfase(idcruce,instancia,letra1,numero1,letra2,numero2,id_torneo,id_categoria);
             postfase in= new postfase();
             boolean r;
             r=in.Insertar(user);
             
          }catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
          }catch(ClassNotFoundException ex){
              Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          /////////////////////////////////////////////////////////////////////////////////
          idcruce=id_torneo+id_categoria+"2"+"6";
          letra1=combo11.getSelectedItem().toString();
          letra2=combo12.getSelectedItem().toString();
          numero1=Integer.parseInt(equipo11.getText());
          numero2=Integer.parseInt(equipo12.getText());
          instancia="Octavos de final";

          try{
             datopostfase user= new datopostfase(idcruce,instancia,letra1,numero1,letra2,numero2,id_torneo,id_categoria);
             postfase in= new postfase();
             boolean r;
             r=in.Insertar(user);
          }catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
          }catch(ClassNotFoundException ex){
              Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
         ///////////////////////////////////////////////////////////////////////////
          idcruce=id_torneo+id_categoria+"2"+"7";
          letra1=combo13.getSelectedItem().toString();
          letra2=combo14.getSelectedItem().toString();
          numero1=Integer.parseInt(equipo5.getText());
          numero2=Integer.parseInt(equipo6.getText());
          instancia="Octavos de final";

          try{
             datopostfase user= new datopostfase(idcruce,instancia,letra1,numero1,letra2,numero2,id_torneo,id_categoria);
             postfase in= new postfase();
             boolean r;
             r=in.Insertar(user);
             
          }catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
          }catch(ClassNotFoundException ex){
              Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          /////////////////////////////////////////////////////////////////////////////////
          idcruce=id_torneo+id_categoria+"2"+"8";
          letra1=combo15.getSelectedItem().toString();
          letra2=combo16.getSelectedItem().toString();
          numero1=Integer.parseInt(equipo15.getText());
          numero2=Integer.parseInt(equipo16.getText());
          instancia="Octavos de final";

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
              Logger.getLogger(Octavosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
      }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        combo1 = new javax.swing.JComboBox();
        combo2 = new javax.swing.JComboBox();
        combo3 = new javax.swing.JComboBox();
        combo4 = new javax.swing.JComboBox();
        combo5 = new javax.swing.JComboBox();
        combo6 = new javax.swing.JComboBox();
        combo8 = new javax.swing.JComboBox();
        combo7 = new javax.swing.JComboBox();
        combo9 = new javax.swing.JComboBox();
        combo10 = new javax.swing.JComboBox();
        combo11 = new javax.swing.JComboBox();
        combo12 = new javax.swing.JComboBox();
        combo13 = new javax.swing.JComboBox();
        combo14 = new javax.swing.JComboBox();
        combo15 = new javax.swing.JComboBox();
        combo16 = new javax.swing.JComboBox();
        equipo1 = new javax.swing.JTextField();
        equipo2 = new javax.swing.JTextField();
        equipo3 = new javax.swing.JTextField();
        equipo4 = new javax.swing.JTextField();
        equipo5 = new javax.swing.JTextField();
        equipo6 = new javax.swing.JTextField();
        equipo7 = new javax.swing.JTextField();
        equipo8 = new javax.swing.JTextField();
        equipo9 = new javax.swing.JTextField();
        equipo10 = new javax.swing.JTextField();
        equipo11 = new javax.swing.JTextField();
        equipo12 = new javax.swing.JTextField();
        equipo13 = new javax.swing.JTextField();
        equipo14 = new javax.swing.JTextField();
        equipo15 = new javax.swing.JTextField();
        equipo16 = new javax.swing.JTextField();
        ganador1 = new javax.swing.JTextField();
        ganador2 = new javax.swing.JTextField();
        ganador3 = new javax.swing.JTextField();
        ganador4 = new javax.swing.JTextField();
        ganador5 = new javax.swing.JTextField();
        ganador6 = new javax.swing.JTextField();
        ganador7 = new javax.swing.JTextField();
        ganador8 = new javax.swing.JTextField();
        semi1 = new javax.swing.JTextField();
        semi2 = new javax.swing.JTextField();
        semi3 = new javax.swing.JTextField();
        semi4 = new javax.swing.JTextField();
        finalista1 = new javax.swing.JTextField();
        finalista2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        campeon = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(561, 240));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(561, 240));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jPanel1.add(combo1);
        combo1.setBounds(0, 0, 43, 20);

        jPanel1.add(combo2);
        combo2.setBounds(0, 31, 43, 20);

        jPanel1.add(combo3);
        combo3.setBounds(0, 62, 43, 20);

        jPanel1.add(combo4);
        combo4.setBounds(0, 93, 43, 20);

        jPanel1.add(combo5);
        combo5.setBounds(0, 119, 43, 20);

        jPanel1.add(combo6);
        combo6.setBounds(0, 150, 43, 20);

        jPanel1.add(combo8);
        combo8.setBounds(0, 209, 43, 20);

        jPanel1.add(combo7);
        combo7.setBounds(0, 181, 43, 20);

        jPanel1.add(combo9);
        combo9.setBounds(518, 0, 43, 20);

        jPanel1.add(combo10);
        combo10.setBounds(518, 31, 43, 20);

        jPanel1.add(combo11);
        combo11.setBounds(518, 62, 43, 20);

        jPanel1.add(combo12);
        combo12.setBounds(518, 93, 43, 20);

        jPanel1.add(combo13);
        combo13.setBounds(518, 119, 43, 20);

        jPanel1.add(combo14);
        combo14.setBounds(518, 150, 43, 20);

        jPanel1.add(combo15);
        combo15.setBounds(518, 181, 43, 20);

        jPanel1.add(combo16);
        combo16.setBounds(518, 209, 43, 20);
        jPanel1.add(equipo1);
        equipo1.setBounds(49, 0, 23, 20);
        jPanel1.add(equipo2);
        equipo2.setBounds(49, 31, 23, 20);
        jPanel1.add(equipo3);
        equipo3.setBounds(49, 62, 23, 20);
        jPanel1.add(equipo4);
        equipo4.setBounds(49, 93, 23, 20);
        jPanel1.add(equipo5);
        equipo5.setBounds(49, 119, 23, 20);
        jPanel1.add(equipo6);
        equipo6.setBounds(49, 150, 23, 20);
        jPanel1.add(equipo7);
        equipo7.setBounds(49, 181, 23, 20);
        jPanel1.add(equipo8);
        equipo8.setBounds(49, 209, 23, 20);
        jPanel1.add(equipo9);
        equipo9.setBounds(489, 0, 23, 20);
        jPanel1.add(equipo10);
        equipo10.setBounds(489, 31, 23, 20);
        jPanel1.add(equipo11);
        equipo11.setBounds(489, 62, 23, 20);
        jPanel1.add(equipo12);
        equipo12.setBounds(489, 93, 23, 20);
        jPanel1.add(equipo13);
        equipo13.setBounds(489, 119, 23, 20);
        jPanel1.add(equipo14);
        equipo14.setBounds(489, 150, 23, 20);
        jPanel1.add(equipo15);
        equipo15.setBounds(489, 181, 23, 20);
        jPanel1.add(equipo16);
        equipo16.setBounds(489, 209, 23, 20);

        ganador1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ganador1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ganador1.setText("ganador1");
        ganador1.setEnabled(false);
        jPanel1.add(ganador1);
        ganador1.setBounds(80, 20, 60, 30);

        ganador2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ganador2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ganador2.setText("ganador2");
        ganador2.setEnabled(false);
        jPanel1.add(ganador2);
        ganador2.setBounds(80, 70, 60, 30);

        ganador3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ganador3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ganador3.setText("ganador3");
        ganador3.setEnabled(false);
        jPanel1.add(ganador3);
        ganador3.setBounds(80, 130, 60, 30);

        ganador4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ganador4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ganador4.setText("ganador4");
        ganador4.setEnabled(false);
        jPanel1.add(ganador4);
        ganador4.setBounds(80, 190, 60, 30);

        ganador5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ganador5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ganador5.setText("ganador5");
        ganador5.setEnabled(false);
        jPanel1.add(ganador5);
        ganador5.setBounds(412, 20, 60, 30);

        ganador6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ganador6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ganador6.setText("ganador6");
        ganador6.setEnabled(false);
        jPanel1.add(ganador6);
        ganador6.setBounds(412, 69, 60, 30);

        ganador7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ganador7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ganador7.setText("ganador7");
        ganador7.setEnabled(false);
        jPanel1.add(ganador7);
        ganador7.setBounds(412, 130, 60, 30);

        ganador8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ganador8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ganador8.setText("ganador8");
        ganador8.setEnabled(false);
        jPanel1.add(ganador8);
        ganador8.setBounds(410, 189, 60, 30);

        semi1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        semi1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        semi1.setText("semi1");
        semi1.setEnabled(false);
        jPanel1.add(semi1);
        semi1.setBounds(163, 50, 40, 19);

        semi2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        semi2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        semi2.setText("semi2");
        semi2.setEnabled(false);
        jPanel1.add(semi2);
        semi2.setBounds(163, 160, 40, 19);

        semi3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        semi3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        semi3.setText("semi3");
        semi3.setEnabled(false);
        jPanel1.add(semi3);
        semi3.setBounds(343, 50, 40, 19);

        semi4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        semi4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        semi4.setText("semi4");
        semi4.setEnabled(false);
        jPanel1.add(semi4);
        semi4.setBounds(343, 170, 40, 19);

        finalista1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        finalista1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        finalista1.setText("Finalista1");
        finalista1.setEnabled(false);
        jPanel1.add(finalista1);
        finalista1.setBounds(191, 100, 60, 19);

        finalista2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        finalista2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        finalista2.setText("Finalista2");
        finalista2.setEnabled(false);
        jPanel1.add(finalista2);
        finalista2.setBounds(301, 100, 60, 19);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel9.setText("\\");
            jPanel1.add(jLabel9);
            jLabel9.setBounds(140, 130, 30, 40);

            jLabel10.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
            jLabel10.setText("/");
            jPanel1.add(jLabel10);
            jLabel10.setBounds(400, 140, 20, 40);

            jLabel11.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
            jLabel11.setText("/");
            jPanel1.add(jLabel11);
            jLabel11.setBounds(390, 20, 30, 40);

            jLabel12.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
            jLabel12.setText("/");
            jPanel1.add(jLabel12);
            jLabel12.setBounds(140, 170, 30, 40);

            jLabel13.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
            jLabel13.setText("/");
            jPanel1.add(jLabel13);
            jLabel13.setBounds(140, 60, 30, 40);

            jLabel14.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
            jLabel14.setText("/");
            jPanel1.add(jLabel14);
            jLabel14.setBounds(210, 120, 30, 40);

            jLabel15.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
            jLabel15.setText("/");
            jPanel1.add(jLabel15);
            jLabel15.setBounds(330, 60, 30, 40);

            jLabel16.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
            jLabel16.setText("\\");
                jPanel1.add(jLabel16);
                jLabel16.setBounds(330, 130, 30, 40);

                jLabel17.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
                jLabel17.setText("\\");
                    jPanel1.add(jLabel17);
                    jLabel17.setBounds(390, 60, 30, 40);

                    jLabel18.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
                    jLabel18.setText("\\");
                        jPanel1.add(jLabel18);
                        jLabel18.setBounds(400, 180, 30, 40);

                        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
                        jLabel19.setText("\\");
                            jPanel1.add(jLabel19);
                            jLabel19.setBounds(210, 60, 30, 40);

                            jLabel20.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
                            jLabel20.setText("\\");
                                jPanel1.add(jLabel20);
                                jLabel20.setBounds(140, 20, 30, 40);

                                campeon.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
                                campeon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                                campeon.setText("Campeon");
                                campeon.setEnabled(false);
                                jPanel1.add(campeon);
                                campeon.setBounds(239, 130, 60, 19);

                                jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                                jLabel1.setText("Vs");
                                jPanel1.add(jLabel1);
                                jLabel1.setBounds(250, 100, 50, 15);

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
    public static javax.swing.JTextField campeon;
    public static javax.swing.JComboBox combo1;
    public static javax.swing.JComboBox combo10;
    public static javax.swing.JComboBox combo11;
    public static javax.swing.JComboBox combo12;
    public static javax.swing.JComboBox combo13;
    public static javax.swing.JComboBox combo14;
    public static javax.swing.JComboBox combo15;
    public static javax.swing.JComboBox combo16;
    public static javax.swing.JComboBox combo2;
    public static javax.swing.JComboBox combo3;
    public static javax.swing.JComboBox combo4;
    public static javax.swing.JComboBox combo5;
    public static javax.swing.JComboBox combo6;
    public static javax.swing.JComboBox combo7;
    public static javax.swing.JComboBox combo8;
    public static javax.swing.JComboBox combo9;
    public static javax.swing.JTextField equipo1;
    public static javax.swing.JTextField equipo10;
    public static javax.swing.JTextField equipo11;
    public static javax.swing.JTextField equipo12;
    public static javax.swing.JTextField equipo13;
    public static javax.swing.JTextField equipo14;
    public static javax.swing.JTextField equipo15;
    public static javax.swing.JTextField equipo16;
    public static javax.swing.JTextField equipo2;
    public static javax.swing.JTextField equipo3;
    public static javax.swing.JTextField equipo4;
    public static javax.swing.JTextField equipo5;
    public static javax.swing.JTextField equipo6;
    public static javax.swing.JTextField equipo7;
    public static javax.swing.JTextField equipo8;
    public static javax.swing.JTextField equipo9;
    public static javax.swing.JTextField finalista1;
    public static javax.swing.JTextField finalista2;
    public static javax.swing.JTextField ganador1;
    public static javax.swing.JTextField ganador2;
    public static javax.swing.JTextField ganador3;
    public static javax.swing.JTextField ganador4;
    public static javax.swing.JTextField ganador5;
    public static javax.swing.JTextField ganador6;
    public static javax.swing.JTextField ganador7;
    public static javax.swing.JTextField ganador8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField semi1;
    public static javax.swing.JTextField semi2;
    public static javax.swing.JTextField semi3;
    public static javax.swing.JTextField semi4;
    // End of variables declaration//GEN-END:variables
}
