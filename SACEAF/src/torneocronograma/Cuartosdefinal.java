
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


public class Cuartosdefinal extends javax.swing.JPanel {

    DefaultComboBoxModel combox1 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox2 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox3 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox4 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox5 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox6 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox7 = new DefaultComboBoxModel();
    DefaultComboBoxModel combox8 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox1 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox2 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox3 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox4 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox5 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox6 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox7 = new DefaultComboBoxModel();
    static DefaultComboBoxModel scombox8 = new DefaultComboBoxModel();
    public Cuartosdefinal() {
        initComponents();
        cargarcombo1();
        cargarcombo2();
        cargarcombo3();
        cargarcombo4();
        cargarcombo5();
        cargarcombo6();
        cargarcombo7();
        cargarcombo8();
        verificardatos();
    }

    static String dcategoria,id_categoria,id_torneo,letra1,letra2,instancia,idcruce,lsexo;
    static int numero1,numero2,opc;
    String categoria,idcategoria,idtorneo,idcompetencia,idmodalidad,postfase,sexo;
    int grupos;
    public void cargarcombo1(){
         categoria=panelcrear.combocategoria.getSelectedItem().toString();
         idtorneo=Principal.labelserialtorneo.getText();
         sexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+sexo+"';");
          while(rs.first()){
          idcategoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo2(){
          categoria=panelcrear.combocategoria.getSelectedItem().toString();
         idtorneo=Principal.labelserialtorneo.getText();
         sexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+sexo+"';");
          while(rs.first()){
          idcategoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo3(){
          categoria=panelcrear.combocategoria.getSelectedItem().toString();
         idtorneo=Principal.labelserialtorneo.getText();
         sexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+sexo+"';");
          while(rs.first()){
          idcategoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo4(){
          categoria=panelcrear.combocategoria.getSelectedItem().toString();
         idtorneo=Principal.labelserialtorneo.getText();
         sexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+sexo+"';");
          while(rs.first()){
          idcategoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo5(){
          categoria=panelcrear.combocategoria.getSelectedItem().toString();
         idtorneo=Principal.labelserialtorneo.getText();
         sexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+sexo+"';");
          while(rs.first()){
          idcategoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo6(){
          categoria=panelcrear.combocategoria.getSelectedItem().toString();
         idtorneo=Principal.labelserialtorneo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"';");
          while(rs.first()){
          idcategoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo7(){
          categoria=panelcrear.combocategoria.getSelectedItem().toString();
         idtorneo=Principal.labelserialtorneo.getText();
         sexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+sexo+"';");
          while(rs.first()){
          idcategoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void cargarcombo8(){
          categoria=panelcrear.combocategoria.getSelectedItem().toString();
         idtorneo=Principal.labelserialtorneo.getText();
         sexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+sexo+"';");
          while(rs.first()){
          idcategoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          idcruce=id_torneo+id_categoria+"2"+"1";
          letra1=combo1.getSelectedItem().toString();
          letra2=combo2.getSelectedItem().toString();
          numero1=Integer.parseInt(equipo1.getText());
          numero2=Integer.parseInt(equipo2.getText());
          instancia="Cuartos de final";

          try{
             datopostfase user= new datopostfase(idcruce,instancia,letra1,numero1,letra2,numero2,id_torneo,id_categoria);
             postfase in= new postfase();
             boolean r;
             r=in.Insertar(user);
             
          }catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
          }catch(ClassNotFoundException ex){
              Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          idcruce=id_torneo+id_categoria+"2"+"2";
          letra1=combo3.getSelectedItem().toString();
          letra2=combo4.getSelectedItem().toString();
          numero1=Integer.parseInt(equipo3.getText());
          numero2=Integer.parseInt(equipo4.getText());
          instancia="Cuartos de final";

          try{
             datopostfase user= new datopostfase(idcruce,instancia,letra1,numero1,letra2,numero2,id_torneo,id_categoria);
             postfase in= new postfase();
             boolean r;
             r=in.Insertar(user);
          }catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
          }catch(ClassNotFoundException ex){
              Logger.getLogger(Final.class.getName()).log(Level.SEVERE,null,ex);
          }
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          idcruce=id_torneo+id_categoria+"2"+"3";
          letra1=combo5.getSelectedItem().toString();
          letra2=combo6.getSelectedItem().toString();
          numero1=Integer.parseInt(equipo5.getText());
          numero2=Integer.parseInt(equipo6.getText());
          instancia="Cuartos de final";

          try{
             datopostfase user= new datopostfase(idcruce,instancia,letra1,numero1,letra2,numero2,id_torneo,id_categoria);
             postfase in= new postfase();
             boolean r;
             r=in.Insertar(user);
             
          }catch(SQLException e){
              JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
          }catch(ClassNotFoundException ex){
              Logger.getLogger(Final.class.getName()).log(Level.SEVERE,null,ex);
          }
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          idcruce=id_torneo+id_categoria+"2"+"4";
          letra1=combo7.getSelectedItem().toString();
          letra2=combo8.getSelectedItem().toString();
          numero1=Integer.parseInt(equipo7.getText());
          numero2=Integer.parseInt(equipo8.getText());
          instancia="Cuartos de final";

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
              Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
          equipo1.setText(Integer.toString(numero1));
          equipo2.setText(Integer.toString(numero2));
          combo1.setEnabled(false);
          combo2.setEnabled(false);
          equipo1.setEnabled(false);
          equipo2.setEnabled(false);
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
          
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
          }
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
          Logger.getLogger(Cuartosdefinal.class.getName()).log(Level.SEVERE,null,ex);
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
        combo7 = new javax.swing.JComboBox();
        combo8 = new javax.swing.JComboBox();
        equipo1 = new javax.swing.JTextField();
        equipo2 = new javax.swing.JTextField();
        equipo3 = new javax.swing.JTextField();
        equipo4 = new javax.swing.JTextField();
        equipo5 = new javax.swing.JTextField();
        equipo6 = new javax.swing.JTextField();
        equipo7 = new javax.swing.JTextField();
        equipo8 = new javax.swing.JTextField();
        ganador3 = new javax.swing.JTextField();
        ganador1 = new javax.swing.JTextField();
        ganador4 = new javax.swing.JTextField();
        ganador2 = new javax.swing.JTextField();
        finalista1 = new javax.swing.JTextField();
        finalista2 = new javax.swing.JTextField();
        campeon = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(561, 240));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(561, 240));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jPanel1.add(combo1);
        combo1.setBounds(0, 11, 41, 28);

        jPanel1.add(combo2);
        combo2.setBounds(0, 71, 41, 28);

        jPanel1.add(combo3);
        combo3.setBounds(0, 143, 41, 28);

        jPanel1.add(combo4);
        combo4.setBounds(0, 201, 41, 28);

        jPanel1.add(combo5);
        combo5.setBounds(510, 11, 41, 28);

        jPanel1.add(combo6);
        combo6.setBounds(510, 71, 41, 28);

        jPanel1.add(combo7);
        combo7.setBounds(510, 143, 41, 28);

        jPanel1.add(combo8);
        combo8.setBounds(510, 201, 41, 28);
        jPanel1.add(equipo1);
        equipo1.setBounds(47, 11, 37, 28);
        jPanel1.add(equipo2);
        equipo2.setBounds(47, 71, 37, 28);
        jPanel1.add(equipo3);
        equipo3.setBounds(47, 143, 37, 28);
        jPanel1.add(equipo4);
        equipo4.setBounds(47, 201, 37, 28);
        jPanel1.add(equipo5);
        equipo5.setBounds(467, 11, 37, 28);
        jPanel1.add(equipo6);
        equipo6.setBounds(467, 71, 37, 28);
        jPanel1.add(equipo7);
        equipo7.setBounds(467, 143, 37, 28);
        jPanel1.add(equipo8);
        equipo8.setBounds(467, 201, 37, 28);

        ganador3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ganador3.setText("ganador3");
        ganador3.setEnabled(false);
        jPanel1.add(ganador3);
        ganador3.setBounds(389, 45, 68, 28);

        ganador1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ganador1.setText("ganador1");
        ganador1.setEnabled(false);
        jPanel1.add(ganador1);
        ganador1.setBounds(102, 45, 68, 28);

        ganador4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ganador4.setText("ganador4");
        ganador4.setEnabled(false);
        jPanel1.add(ganador4);
        ganador4.setBounds(393, 171, 68, 28);

        ganador2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ganador2.setText("ganador2");
        ganador2.setEnabled(false);
        jPanel1.add(ganador2);
        ganador2.setBounds(102, 171, 72, 28);

        finalista1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        finalista1.setText("finalista1");
        finalista1.setEnabled(false);
        jPanel1.add(finalista1);
        finalista1.setBounds(156, 108, 68, 28);

        finalista2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        finalista2.setText("finalista2");
        finalista2.setEnabled(false);
        jPanel1.add(finalista2);
        finalista2.setBounds(329, 109, 68, 28);

        campeon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campeon.setText("Campeon");
        campeon.setEnabled(false);
        jPanel1.add(campeon);
        campeon.setBounds(239, 143, 68, 28);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("\\");
            jPanel1.add(jLabel1);
            jLabel1.setBounds(460, 200, 10, 22);

            jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jLabel2.setText("/");
            jPanel1.add(jLabel2);
            jLabel2.setBounds(460, 20, 7, 22);

            jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jLabel3.setText("/");
            jPanel1.add(jLabel3);
            jLabel3.setBounds(90, 70, 7, 22);

            jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jLabel4.setText("/");
            jPanel1.add(jLabel4);
            jLabel4.setBounds(90, 200, 7, 22);

            jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jLabel5.setText("/");
            jPanel1.add(jLabel5);
            jLabel5.setBounds(460, 150, 7, 22);

            jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jLabel6.setText("/");
            jPanel1.add(jLabel6);
            jLabel6.setBounds(380, 70, 7, 22);

            jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jLabel7.setText("/");
            jPanel1.add(jLabel7);
            jLabel7.setBounds(170, 150, 10, 22);

            jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jLabel8.setText("\\");
                jPanel1.add(jLabel8);
                jLabel8.setBounds(90, 30, 10, 22);

                jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                jLabel9.setText("\\");
                    jPanel1.add(jLabel9);
                    jLabel9.setBounds(460, 70, 10, 22);

                    jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                    jLabel10.setText("\\");
                        jPanel1.add(jLabel10);
                        jLabel10.setBounds(160, 80, 10, 22);

                        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                        jLabel11.setText("\\");
                            jPanel1.add(jLabel11);
                            jLabel11.setBounds(90, 150, 10, 22);

                            jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
                            jLabel12.setText("\\");
                                jPanel1.add(jLabel12);
                                jLabel12.setBounds(380, 140, 10, 22);

                                jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
                                jLabel13.setText("Vs");
                                jPanel1.add(jLabel13);
                                jLabel13.setBounds(270, 120, 13, 15);

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
    public static javax.swing.JComboBox combo2;
    public static javax.swing.JComboBox combo3;
    public static javax.swing.JComboBox combo4;
    public static javax.swing.JComboBox combo5;
    public static javax.swing.JComboBox combo6;
    public static javax.swing.JComboBox combo7;
    public static javax.swing.JComboBox combo8;
    public static javax.swing.JTextField equipo1;
    public static javax.swing.JTextField equipo2;
    public static javax.swing.JTextField equipo3;
    public static javax.swing.JTextField equipo4;
    public static javax.swing.JTextField equipo5;
    public static javax.swing.JTextField equipo6;
    public static javax.swing.JTextField equipo7;
    public static javax.swing.JTextField equipo8;
    public static javax.swing.JTextField finalista1;
    public static javax.swing.JTextField finalista2;
    public static javax.swing.JTextField ganador1;
    public static javax.swing.JTextField ganador2;
    public static javax.swing.JTextField ganador3;
    public static javax.swing.JTextField ganador4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
