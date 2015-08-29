
package Basededatos.equipo;

import Basededatos.Conexion;
import static Equipo.pclub.labellogo;
import Equipo.pmostrar;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class club {
  
    public boolean Insertar( datoclub user)throws SQLException, ClassNotFoundException, FileNotFoundException{

        Conexion parametros=new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
        Statement stm=con.createStatement();
        boolean result;
        String query="Insert into club values ('"+user.getIdclub()+"','"+user.getNombreclub()+"',"
                + "'"+user.getPresidente()+"','"+user.getBloqueo()+"','"+user.getMunicipio()+"')";
        String insert="Insert into imagenclub values('"+user.getIdclub()+"', '"+user.getImagen()+"', '"+user.getNombreimagen()+"',"
                + " '"+user.getIdclub()+"');";
        result=stm.execute(query);
        result=stm.execute(insert);
        stm.close();
        con.close();
        return result;
    }
    public boolean Bloquear( datobloquear user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        boolean result;
        String sql="Update club set bloqueo='"+user.getBloquear()+"' where id_club='"+user.getSerial()+"';";
        String sql1="Update equipo set bloqueo='"+user.getBloquear()+"' where id_club='"+user.getSerial()+"';";
        result=st.execute(sql);
        result= st.execute(sql1);
        st.close();
        con.close();
        return result;
        
    }
    public boolean Desbloquear( datobloquear user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        boolean result;
        String sql="Update club set bloqueo='"+user.getBloquear()+"' where id_club='"+user.getSerial()+"';";
        String sql1="Update equipo set bloqueo='"+user.getBloquear()+"' where id_club='"+user.getSerial()+"';";
        result=st.execute(sql);
        result= st.execute(sql1);
        st.close();
        con.close();
        return result;
        
    }
    public boolean Modificar( datoclub user) throws SQLException, ClassNotFoundException, FileNotFoundException{
            try{
            FileInputStream fis = null;
            PreparedStatement ps = null;
            File file = new File(user.getImagen());
            fis = new FileInputStream(file);
            Conexion parametros= new Conexion();
            Class.forName(parametros.getDriver());
            Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
            Statement st= con.createStatement();
            boolean result;
            String sql="Update club set nombre_club='"+user.getNombreclub()+"',"
                    + "presidenteclub='"+user.getPresidente()+"',"
                    + "bloqueo='"+user.getBloqueo()+"',"
                    + "id_municipio='"+user.getMunicipio()+"' "
                    + "where id_club='"+user.getIdclub()+"' ;";
            String sql1="Delete from imagenclub where id_imgclub='"+user.getIdclub()+"';";
            result=st.execute(sql);
            result=st.execute(sql1);
            String insert="Insert into imagenclub(id_imgclub, logo_eq, nombre_imagen, id_club) values(?,?,?,?);";
        ps=con.prepareStatement(insert);
        ps.setString(1, user.getIdclub());
        ps.setBinaryStream(2,fis,(int)file.length());
        ps.setString(3, user.getNombreimagen() );
        ps.setString(4, user.getIdclub());
        ps.executeUpdate();
            st.close();
            ps.close();
            con.close();
            return result;
             }catch (Exception ex) {
            Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        }
    public static void getimagen(){
           
           try{
           String serialclub=(String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),0);
           System.out.println(serialclub);
           String sql="Select logo_eq from imagenclub where id_imgclub='"+serialclub+"'";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.next()){
             
               imagenclub imagen=new imagenclub();
                Blob blob = rs.getBlob("logo_eq");
                byte[] data = blob.getBytes(1, (int)blob.length());
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                } catch (IOException ex) {
                    Logger.getLogger(club.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                imagen.setImagen(img);
                ImageIcon icon = new ImageIcon(img.getScaledInstance(labellogo.getWidth(), labellogo.getHeight(), Image.SCALE_DEFAULT));
                System.out.println("leyendo Imagel");
                labellogo.setText("");
                System.out.println("leyendo Imagenm");
                labellogo.setIcon(icon);
               
              

                 } 
           rs.close();
       }catch(SQLException ex){

           Logger.getLogger(club.class.getName()).log(Level.SEVERE,null,ex);
       }catch(ClassNotFoundException e){
           Logger.getLogger(club.class.getName()).log(Level.SEVERE,null,e);
       }
        
       }

}

