
package torneocronograma.tresequipos;

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
import torneocronograma.panelcrear;
import static torneocronograma.verliga.comboronda;
import torneodatoscronograma.datojuego;
import torneodatoscronograma.juegos;


public class tresequiposA {
    String nombrecat,id_categoria,id_torneo,idcompetencia,idmodalidad,datopostfase,nombre_juego,equipo_local,equipo_visitante,id_juego,jornada,sexo;
    int rondas,nrondas,cont,numero_local,numero_visitante,grupos,ctrl,i;
    static String categoria, idtorneo,grupo,hequipo,idcategoria,lsexo;
    
    
    public void tresequiposa1(){
        rondas=Integer.parseInt(comboronda.getSelectedItem().toString());
        grupo="A";
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
            }
        i=1;
 ///////////////////////////////////////////////////////////////////////////////////////////1       
        numero_local=1;
        numero_visitante=2;
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ///////////////////////////////////////////////////////////////////////2
       
        numero_local=2;
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ///////////////////////////////////////////////////3
        
        numero_local=3;
        numero_visitante=1;
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"3";
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
           Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE,null,ex);
       }
      
    }
    public void tresequiposa2(){
        rondas=Integer.parseInt(comboronda.getSelectedItem().toString());
        i=2;
        grupo="A";
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
            }
        /////////////////////////////////////////////////////////////////////
        numero_local=2;
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ///////////////////////////////////////////////////////////////////////2
       
        numero_local=3;
        numero_visitante=2;
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ///////////////////////////////////////////////////3
              
        numero_local=1;
        numero_visitante=3;
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"3";
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
           Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE,null,ex);
       }
       
    }
    public void tresequiposa3(){
        rondas=Integer.parseInt(comboronda.getSelectedItem().toString());
        grupo="A";
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
            }
        i=3;
 ///////////////////////////////////////////////////////////////////////////////////////////1       
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ///////////////////////////////////////////////////////////////////////2
       
        numero_local=2;
        numero_visitante=3;
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ///////////////////////////////////////////////////3
        
        numero_local=3;
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"3";
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
           Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE,null,ex);
       }
      
    }
    public void tresequiposa4(){
        rondas=Integer.parseInt(comboronda.getSelectedItem().toString());
        i=4;
        grupo="A";
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
            }
        /////////////////////////////////////////////////////////////////////
        numero_local=2;
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ///////////////////////////////////////////////////////////////////////2
       
        numero_local=3;
        numero_visitante=2;
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ///////////////////////////////////////////////////3
              
        numero_local=1;
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"3";
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
           Logger.getLogger(tresequiposA.class.getName()).log(Level.SEVERE,null,ex);
       }
       
    }
}
