
package Datosadministracion;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class categoria {
    
    
    public boolean Insertar(datocategoria user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st= con.createStatement();
        String sql=("Insert into categoria values('"+user.getSerial()+"','"+user.getNombre()+"','"+user.getYear_final()+"','"+user.getYear_ini()+"','"+user.getSexo()+"')");
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
    
    public boolean Eliminar(datoeliminar user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st= con.createStatement();
        String sql=" Delete from categoria where id_categoria='"+user.getSerial()+"'";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
}
