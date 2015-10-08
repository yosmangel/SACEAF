
package torneodatosadm;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class exception {
  
    
      public boolean Insertar(datosexception user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros = new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        String sql="Insert into exceptionj values('"+user.getIdexception()+"', '"+user.getEdad()+"', '"+user.getTorneo()+"',"
                + " '"+user.getIdexception()+"');";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
          
      }
      
      public boolean Eliminar(datosexception user) throws SQLException, ClassNotFoundException{
        Conexion parametros = new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        String sql="Delete from exceptionj where id_exceptionj=('"+user.getIdexception()+"');";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
}
