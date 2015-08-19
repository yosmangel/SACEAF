
package torneodatosadm;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class torneonomina {
    
     public boolean Insertar(datosnominatorneo user) throws SQLException, ClassNotFoundException{
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
        Statement st= con.createStatement();
        String sql="Insert into n_jugadores values('"+user.getIdnomina()+"', '"+user.getNumero()+"', '"+user.getTorneo()+"');";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
    
     public boolean Eliminar(datoborrart user) throws SQLException, ClassNotFoundException{
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
        Statement st= con.createStatement();
        String sql="Delete from n_jugadores where id_njugadores='"+user.getSerialborrart()+"';";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
}
