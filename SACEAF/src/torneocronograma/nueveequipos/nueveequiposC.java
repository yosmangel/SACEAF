
package torneocronograma.nueveequipos;

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
import torneocronograma.dosgrupos;
import torneocronograma.panelcrear;
import torneodatoscronograma.datojuego;
import torneodatoscronograma.juegos;


public class nueveequiposC {
    
    String nombrecat,id_categoria,id_torneo,idcompetencia,idmodalidad,datopostfase,nombre_juego,equipo_local,equipo_visitante,id_juego,jornada,sexo;
    int rondas,nrondas,cont,numero_local,numero_visitante,grupos,ctrl,i;
    static String categoria, idtorneo,grupo,hequipo,idcategoria,lsexo;
    
    public void nueveequiposc1(){
        grupo="C";
        nombre_juego="Jornada";
        id_torneo=Principal.labelserialtorneo.getText();
        nombrecat=panelcrear.combocategoria.getSelectedItem().toString();
        sexo=Principal.labelsexo.getText();
        try{ 
            String sql="Select id_categoria from categoria where nombre_cat= '"+nombrecat+"' and sexo='"+sexo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            id_categoria=rs.getString("id_categoria");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
        i=1;
       
        ///////////////////////////////////////////////////////////////////1
        
        numero_local=1;
        numero_visitante=8;
        jornada="1";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"1";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       /////////////////////////////////////////////////////////////////////////2
       
       numero_local=2;
        numero_visitante=7;
        jornada="1";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"2";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////3
       
       numero_local=3;
        numero_visitante=6;
        jornada="1";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"3";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ///////////////////////////////////////////////////////////////////////4
       
       numero_local=4;
        numero_visitante=5;
        jornada="1";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"4";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
      ////////////////////////////////////////////////////////////////////////5
       numero_local=5;
        numero_visitante=3;
        jornada="2";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"5";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////6
       numero_local=6;
        numero_visitante=2;
        jornada="2";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"6";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////7
       numero_local=7;
        numero_visitante=1;
        jornada="2";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"7";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////8
       numero_local=8;
        numero_visitante=9;
        jornada="2";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"8";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////9
       
        numero_local=9;
        numero_visitante=7;
        jornada="3";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"9";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////10
       
       numero_local=1;
        numero_visitante=6;
        jornada="3";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"10";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////11
       
       ////////////////////////////////////////////////////////////////////////11

       
       numero_local=2;
        numero_visitante=5;
        jornada="3";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"11";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////12

       numero_local=3;
        numero_visitante=4;
        jornada="3";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"12";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////13
       
       ////////////////////////////////////////////////////////////////////////13

       
       numero_local=4;
        numero_visitante=2;
        jornada="4";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"13";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////14
       
       ////////////////////////////////////////////////////////////////////////14

       
       numero_local=5;
        numero_visitante=1;
        jornada="4";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"14";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////15
       
       numero_local=6;
        numero_visitante=9;
        jornada="4";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"15";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////16
       
       ////////////////////////////////////////////////////////////////////////16
       
       
       numero_local=7;
        numero_visitante=8;
        jornada="4";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"16";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////17
       
       ////////////////////////////////////////////////////////////////////////17
       
       
       numero_local=8;
        numero_visitante=6;
        jornada="5";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"17";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////18
       
       ////////////////////////////////////////////////////////////////////////18
       
       
       numero_local=9;
        numero_visitante=5;
        jornada="5";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"18";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////19
       
       numero_local=1;
        numero_visitante=4;
        jornada="5";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"19";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////20
       
       ////////////////////////////////////////////////////////////////////////20
       
       
       numero_local=2;
        numero_visitante=3;
        jornada="5";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"20";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////21
       
       numero_local=3;
        numero_visitante=1;
        jornada="6";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"21";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////22
       
       numero_local=4;
        numero_visitante=9;
        jornada="6";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"22";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////23
       
       numero_local=5;
        numero_visitante=8;
        jornada="6";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"23";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////24
       
       numero_local=6;
        numero_visitante=7;
        jornada="6";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"24";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////25
       
       numero_local=7;
        numero_visitante=5;
        jornada="7";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"25";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////26
       
       numero_local=8;
        numero_visitante=4;
        jornada="7";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"26";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////27
       
       numero_local=9;
        numero_visitante=3;
        jornada="7";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"27";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////28
       numero_local=1;
        numero_visitante=2;
        jornada="7";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"28";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////29
       
       numero_local=2;
        numero_visitante=9;
        jornada="8";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"29";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////30
       numero_local=3;
        numero_visitante=8;
        jornada="8";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"30";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////31
       numero_local=4;
        numero_visitante=7;
        jornada="8";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"31";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////32
       
       numero_local=5;
        numero_visitante=6;
        jornada="8";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"32";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////33
       numero_local=6;
        numero_visitante=4;
        jornada="9";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"33";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////34
       
       numero_local=7;
        numero_visitante=3;
        jornada="9";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"34";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////35
       
       numero_local=8;
        numero_visitante=2;
        jornada="9";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"35";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
      ////////////////////////////////////////////////////////////////////////36
       numero_local=9;
        numero_visitante=1;
        jornada="9";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"36";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
           if(r==false){
               JOptionPane.showMessageDialog(null,"Primera ronda guardada","Informacion", JOptionPane.INFORMATION_MESSAGE);
           }
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
    }
    public void nueveequiposc2(){
        grupo="C";
        nombre_juego="Jornada";
        id_torneo=Principal.labelserialtorneo.getText();
        nombrecat=panelcrear.combocategoria.getSelectedItem().toString();
        sexo=Principal.labelsexo.getText();
        try{ 
            String sql="Select id_categoria from categoria where nombre_cat= '"+nombrecat+"' and sexo='"+sexo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            id_categoria=rs.getString("id_categoria");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }

        i=2;
        ///////////////////////////////////////////////////////////////////1
        
        numero_local=8;
        numero_visitante=1;
        jornada="10";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"1";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       /////////////////////////////////////////////////////////////////////////2
       
       numero_local=7;
        numero_visitante=2;
        jornada="10";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"2";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////3
       
       numero_local=6;
        numero_visitante=3;
        jornada="10";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"3";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ///////////////////////////////////////////////////////////////////////4
       
       numero_local=5;
        numero_visitante=4;
        jornada="10";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"4";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
      ////////////////////////////////////////////////////////////////////////5
       numero_local=3;
        numero_visitante=5;
        jornada="11";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"5";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////6
       numero_local=2;
        numero_visitante=6;
        jornada="11";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"6";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////7
       numero_local=1;
        numero_visitante=7;
        jornada="11";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"7";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////8
       numero_local=9;
        numero_visitante=8;
        jornada="11";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"8";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////9
       
        numero_local=7;
        numero_visitante=9;
        jornada="12";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"9";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////10
       
       numero_local=6;
        numero_visitante=1;
        jornada="12";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"10";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////11
       
       ////////////////////////////////////////////////////////////////////////11

       
       numero_local=5;
        numero_visitante=2;
        jornada="12";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"11";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////12

       numero_local=4;
        numero_visitante=3;
        jornada="12";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"12";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////13
       
       ////////////////////////////////////////////////////////////////////////13

       
       numero_local=2;
        numero_visitante=4;
        jornada="13";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"13";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////14
       
       ////////////////////////////////////////////////////////////////////////14

       
       numero_local=1;
        numero_visitante=5;
        jornada="13";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"14";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////15
       
       numero_local=9;
        numero_visitante=6;
        jornada="13";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"15";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////16
       
       ////////////////////////////////////////////////////////////////////////16
       
       
       numero_local=8;
        numero_visitante=7;
        jornada="13";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"16";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////17
       
       ////////////////////////////////////////////////////////////////////////17
       
       
       numero_local=6;
        numero_visitante=8;
        jornada="14";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"17";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////18
       
       ////////////////////////////////////////////////////////////////////////18
       
       
       numero_local=5;
        numero_visitante=9;
        jornada="14";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"18";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////19
       
       numero_local=4;
        numero_visitante=1;
        jornada="14";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"19";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////20
       
       ////////////////////////////////////////////////////////////////////////20
       
       
       numero_local=3;
        numero_visitante=2;
        jornada="14";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"20";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////21
       
       numero_local=1;
        numero_visitante=3;
        jornada="15";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"21";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////22
       
       numero_local=9;
        numero_visitante=4;
        jornada="15";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"22";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////23
       
       numero_local=8;
        numero_visitante=5;
        jornada="15";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"23";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////24
       
       numero_local=7;
        numero_visitante=6;
        jornada="15";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"24";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////25
       
       numero_local=5;
        numero_visitante=7;
        jornada="16";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"25";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////26
       
       numero_local=4;
        numero_visitante=8;
        jornada="16";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"26";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////27
       
       numero_local=3;
        numero_visitante=9;
        jornada="16";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"27";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////28
       numero_local=2;
        numero_visitante=1;
        jornada="16";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"28";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////29
       
       numero_local=9;
        numero_visitante=2;
        jornada="17";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"29";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////30
       numero_local=8;
        numero_visitante=3;
        jornada="17";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"30";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////31
       numero_local=7;
        numero_visitante=4;
        jornada="17";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"31";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////32
       
       numero_local=6;
        numero_visitante=5;
        jornada="17";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"32";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////33
       numero_local=4;
        numero_visitante=6;
        jornada="18";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"33";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////34
       
       numero_local=3;
        numero_visitante=7;
        jornada="18";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"34";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////35
       
       numero_local=2;
        numero_visitante=8;
        jornada="18";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"35";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
      ////////////////////////////////////////////////////////////////////////36
       numero_local=1;
        numero_visitante=9;
        jornada="18";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"36";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
           if(r==false){
               JOptionPane.showMessageDialog(null,"Segunda ronda guardada","Informacion", JOptionPane.INFORMATION_MESSAGE);
           }
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }

    }
    public void nueveequiposc3(){
        grupo="C";
        nombre_juego="Jornada";
        id_torneo=Principal.labelserialtorneo.getText();
        nombrecat=panelcrear.combocategoria.getSelectedItem().toString();
        sexo=Principal.labelsexo.getText();
        try{ 
            String sql="Select id_categoria from categoria where nombre_cat= '"+nombrecat+"' and sexo='"+sexo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            id_categoria=rs.getString("id_categoria");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
        i=3;
       
        ///////////////////////////////////////////////////////////////////1
        
        numero_local=1;
        numero_visitante=8;
        jornada="1";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"1";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       /////////////////////////////////////////////////////////////////////////2
       
       numero_local=2;
        numero_visitante=7;
        jornada="1";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"2";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////3
       
       numero_local=3;
        numero_visitante=6;
        jornada="1";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"3";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ///////////////////////////////////////////////////////////////////////4
       
       numero_local=4;
        numero_visitante=5;
        jornada="1";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"4";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
      ////////////////////////////////////////////////////////////////////////5
       numero_local=5;
        numero_visitante=3;
        jornada="2";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"5";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////6
       numero_local=6;
        numero_visitante=2;
        jornada="2";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"6";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////7
       numero_local=7;
        numero_visitante=1;
        jornada="2";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"7";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////8
       numero_local=8;
        numero_visitante=9;
        jornada="2";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"8";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////9
       
        numero_local=9;
        numero_visitante=7;
        jornada="3";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"9";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////10
       
       numero_local=1;
        numero_visitante=6;
        jornada="3";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"10";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////11
       
       ////////////////////////////////////////////////////////////////////////11

       
       numero_local=2;
        numero_visitante=5;
        jornada="3";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"11";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////12

       numero_local=3;
        numero_visitante=4;
        jornada="3";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"12";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////13
       
       ////////////////////////////////////////////////////////////////////////13

       
       numero_local=4;
        numero_visitante=2;
        jornada="4";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"13";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////14
       
       ////////////////////////////////////////////////////////////////////////14

       
       numero_local=5;
        numero_visitante=1;
        jornada="4";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"14";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////15
       
       numero_local=6;
        numero_visitante=9;
        jornada="4";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"15";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////16
       
       ////////////////////////////////////////////////////////////////////////16
       
       
       numero_local=7;
        numero_visitante=8;
        jornada="4";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"16";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////17
       
       ////////////////////////////////////////////////////////////////////////17
       
       
       numero_local=8;
        numero_visitante=6;
        jornada="5";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"17";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////18
       
       ////////////////////////////////////////////////////////////////////////18
       
       
       numero_local=9;
        numero_visitante=5;
        jornada="5";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"18";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////19
       
       numero_local=1;
        numero_visitante=4;
        jornada="5";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"19";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////20
       
       ////////////////////////////////////////////////////////////////////////20
       
       
       numero_local=2;
        numero_visitante=3;
        jornada="5";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"20";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////21
       
       numero_local=3;
        numero_visitante=1;
        jornada="6";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"21";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////22
       
       numero_local=4;
        numero_visitante=9;
        jornada="6";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"22";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////23
       
       numero_local=5;
        numero_visitante=8;
        jornada="6";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"23";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////24
       
       numero_local=6;
        numero_visitante=7;
        jornada="6";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"24";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////25
       
       numero_local=7;
        numero_visitante=5;
        jornada="7";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"25";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////26
       
       numero_local=8;
        numero_visitante=4;
        jornada="7";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"26";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////27
       
       numero_local=9;
        numero_visitante=3;
        jornada="7";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"27";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////28
       numero_local=1;
        numero_visitante=2;
        jornada="7";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"28";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////29
       
       numero_local=2;
        numero_visitante=9;
        jornada="8";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"29";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////30
       numero_local=3;
        numero_visitante=8;
        jornada="8";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"30";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////31
       numero_local=4;
        numero_visitante=7;
        jornada="8";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"31";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////32
       
       numero_local=5;
        numero_visitante=6;
        jornada="8";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"32";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////33
       numero_local=6;
        numero_visitante=4;
        jornada="9";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"33";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////34
       
       numero_local=7;
        numero_visitante=3;
        jornada="9";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"34";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////35
       
       numero_local=8;
        numero_visitante=2;
        jornada="9";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"35";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
      ////////////////////////////////////////////////////////////////////////36
       numero_local=9;
        numero_visitante=1;
        jornada="9";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"36";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
           if(r==false){
               JOptionPane.showMessageDialog(null,"Tercera ronda guardada","Informacion", JOptionPane.INFORMATION_MESSAGE);
           }
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
    }
    public void nueveequiposc4(){
        grupo="C";
        nombre_juego="Jornada";
        id_torneo=Principal.labelserialtorneo.getText();
        nombrecat=panelcrear.combocategoria.getSelectedItem().toString();
        sexo=Principal.labelsexo.getText();
        try{ 
            String sql="Select id_categoria from categoria where nombre_cat= '"+nombrecat+"' and sexo='"+sexo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            id_categoria=rs.getString("id_categoria");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }

        i=4;
        ///////////////////////////////////////////////////////////////////1
        
        numero_local=8;
        numero_visitante=1;
        jornada="10";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"1";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       /////////////////////////////////////////////////////////////////////////2
       
       numero_local=7;
        numero_visitante=2;
        jornada="10";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"2";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////3
       
       numero_local=6;
        numero_visitante=3;
        jornada="10";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"3";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ///////////////////////////////////////////////////////////////////////4
       
       numero_local=5;
        numero_visitante=4;
        jornada="10";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"4";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
      ////////////////////////////////////////////////////////////////////////5
       numero_local=3;
        numero_visitante=5;
        jornada="11";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"5";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////6
       numero_local=2;
        numero_visitante=6;
        jornada="11";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"6";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////7
       numero_local=1;
        numero_visitante=7;
        jornada="11";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"7";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////8
       numero_local=9;
        numero_visitante=8;
        jornada="11";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"8";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////9
       
        numero_local=7;
        numero_visitante=9;
        jornada="12";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"9";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////10
       
       numero_local=6;
        numero_visitante=1;
        jornada="12";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"10";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////11
       
       ////////////////////////////////////////////////////////////////////////11

       
       numero_local=5;
        numero_visitante=2;
        jornada="12";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"11";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////12

       numero_local=4;
        numero_visitante=3;
        jornada="12";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"12";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////13
       
       ////////////////////////////////////////////////////////////////////////13

       
       numero_local=2;
        numero_visitante=4;
        jornada="13";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"13";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////14
       
       ////////////////////////////////////////////////////////////////////////14

       
       numero_local=1;
        numero_visitante=5;
        jornada="13";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"14";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////15
       
       numero_local=9;
        numero_visitante=6;
        jornada="13";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"15";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////16
       
       ////////////////////////////////////////////////////////////////////////16
       
       
       numero_local=8;
        numero_visitante=7;
        jornada="13";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"16";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////17
       
       ////////////////////////////////////////////////////////////////////////17
       
       
       numero_local=6;
        numero_visitante=8;
        jornada="14";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"17";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////18
       
       ////////////////////////////////////////////////////////////////////////18
       
       
       numero_local=5;
        numero_visitante=9;
        jornada="14";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"18";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////19
       
       numero_local=4;
        numero_visitante=1;
        jornada="14";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"19";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////20
       
       ////////////////////////////////////////////////////////////////////////20
       
       
       numero_local=3;
        numero_visitante=2;
        jornada="14";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"20";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////21
       
       numero_local=1;
        numero_visitante=3;
        jornada="15";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"21";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////22
       
       numero_local=9;
        numero_visitante=4;
        jornada="15";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"22";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////23
       
       numero_local=8;
        numero_visitante=5;
        jornada="15";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"23";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////24
       
       numero_local=7;
        numero_visitante=6;
        jornada="15";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"24";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////25
       
       numero_local=5;
        numero_visitante=7;
        jornada="16";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"25";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////26
       
       numero_local=4;
        numero_visitante=8;
        jornada="16";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"26";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////27
       
       numero_local=3;
        numero_visitante=9;
        jornada="16";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"27";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////28
       numero_local=2;
        numero_visitante=1;
        jornada="16";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"28";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////29
       
       numero_local=9;
        numero_visitante=2;
        jornada="17";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"29";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////30
       numero_local=8;
        numero_visitante=3;
        jornada="17";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"30";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////31
       numero_local=7;
        numero_visitante=4;
        jornada="17";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"31";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////32
       
       numero_local=6;
        numero_visitante=5;
        jornada="17";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"32";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////33
       numero_local=4;
        numero_visitante=6;
        jornada="18";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"33";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////34
       
       numero_local=3;
        numero_visitante=7;
        jornada="18";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"34";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////35
       
       numero_local=2;
        numero_visitante=8;
        jornada="18";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"35";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }
       
      ////////////////////////////////////////////////////////////////////////36
       numero_local=1;
        numero_visitante=9;
        jornada="18";
        try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_local+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       try{ 
            String sql="Select id_hequipo from h_equipo where id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and numero_eq='"+numero_visitante+"' and grupo_equipo='"+grupo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_visitante=rs.getString("id_hequipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"36";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
           if(r==false){
               JOptionPane.showMessageDialog(null,"Cuarta ronda guardada","Informacion", JOptionPane.INFORMATION_MESSAGE);
           }
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(nueveequiposC.class.getName()).log(Level.SEVERE,null,ex);
       }

    }
    
}
