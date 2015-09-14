
package Basededatos.equipo;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class club {
  
    public boolean Insertar( datoclub user)throws SQLException, ClassNotFoundException{

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
    public boolean Modificar( datoclub user) throws SQLException, ClassNotFoundException{
            Conexion parametros= new Conexion();
            Class.forName(parametros.getDriver());
            Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
            Statement st=con.createStatement();
            boolean result;
            String sql="Update club set nombre_club='"+user.getNombreclub()+"',"
                    + "presidenteclub='"+user.getPresidente()+"',"
                    + "bloqueo='"+user.getBloqueo()+"',"
                    + "id_municipio='"+user.getMunicipio()+"' "
                    + "where id_club='"+user.getIdclub()+"' ;";
            String sqlb="Delete from imagenclub where id_imgclub='"+user.getIdclub()+"';";
            String insert="Insert into imagenclub values('"+user.getIdclub()+"', "
                    + "'"+user.getImagen()+"', '"+user.getNombreimagen()+"',"
                    + " '"+user.getIdclub()+"');";
            result=st.execute(sql);
            result=st.execute(sqlb);
            result=st.execute(insert);
            st.close();
            con.close();
            return result;

            
    }        
    }

