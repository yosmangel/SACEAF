
package torneocronograma.cuatroequipos;

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




public class cuatroequiposD {
    
    String nombrecat,id_categoria,id_torneo,idcompetencia,idmodalidad,datopostfase,nombre_juego,equipo_local,equipo_visitante,id_juego,jornada,sexo;
    int rondas,nrondas,cont,numero_local,numero_visitante,grupos,ctrl,i;
    static String categoria, idtorneo,grupo,hequipo,idcategoria,lsexo;
    
    public void cuatroequiposd1(){
        grupo="D";
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
            }
        rondas=Integer.parseInt(comboronda.getSelectedItem().toString());
        i=1;
////////////////////////////////////////////////////////////////////////////////1
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       /////////////////////////////////////////////////////////////////////////2
       
        numero_local=3;
        numero_visitante=4;
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////3
       
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ///////////////////////////////////////////////////////////////////////4
       
        numero_local=4;
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
      ////////////////////////////////////////////////////////////////////////5
       
        numero_local=1;
        numero_visitante=3;
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////6
       
        numero_local=2;
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"6";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
           if(r==false){
               JOptionPane.showMessageDialog(null,"Primera Ronda guardada","Informacion", JOptionPane.INFORMATION_MESSAGE);
           }
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
      
    }
    public void cuatroequiposd2(){
        grupo="D";
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
            }
        rondas=Integer.parseInt(comboronda.getSelectedItem().toString());
        i=2;
////////////////////////////////////////////////////////////////////////////////1
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       /////////////////////////////////////////////////////////////////////////2
       
        numero_local=4;
        numero_visitante=3;
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////3
       
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ///////////////////////////////////////////////////////////////////////4
       
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
      ////////////////////////////////////////////////////////////////////////5
       
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////6
       
        numero_local=4;
        numero_visitante=2;
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"6";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
           if(r==false){
               JOptionPane.showMessageDialog(null,"Segunda Ronda guardada","Informacion", JOptionPane.INFORMATION_MESSAGE);
           }
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
      
    }
    public void cuatroequiposd3(){
        grupo="D";
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
            }
        rondas=Integer.parseInt(comboronda.getSelectedItem().toString());
        i=3;
////////////////////////////////////////////////////////////////////////////////1
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       /////////////////////////////////////////////////////////////////////////2
       
        numero_local=3;
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////3
       
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ///////////////////////////////////////////////////////////////////////4
       
        numero_local=4;
        numero_visitante=1;
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
      ////////////////////////////////////////////////////////////////////////5
       
        numero_local=1;
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////6
       
        numero_local=2;
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"6";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
           if(r==false){
               JOptionPane.showMessageDialog(null,"Tercera Ronda guardada","Informacion", JOptionPane.INFORMATION_MESSAGE);
           }
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
      
    }
    public void cuatroequiposd4(){
        grupo="D";
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
            }
        rondas=Integer.parseInt(comboronda.getSelectedItem().toString());
        i=4;
////////////////////////////////////////////////////////////////////////////////1
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       /////////////////////////////////////////////////////////////////////////2
       
        numero_local=4;
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////3
       
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ///////////////////////////////////////////////////////////////////////4
       
        numero_local=1;
        numero_visitante=4;
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
      ////////////////////////////////////////////////////////////////////////5
       
        numero_local=3;
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
       
       ////////////////////////////////////////////////////////////////////////6
       
        numero_local=4;
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE, null, ex);
            }
       id_juego=id_torneo+id_categoria+i+jornada+grupo+"6";
       try{
           datojuego user=new datojuego(id_juego,jornada,nombre_juego,equipo_local,equipo_visitante,grupo,id_categoria,id_torneo);
           juegos in=new juegos();
           boolean r;
           r=in.Insertar(user);
           if(r==false){
               JOptionPane.showMessageDialog(null,"Cuarta Ronda guardada","Informacion", JOptionPane.INFORMATION_MESSAGE);
           }
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException ex){
           Logger.getLogger(cuatroequiposD.class.getName()).log(Level.SEVERE,null,ex);
       }
      
    }
    
}
