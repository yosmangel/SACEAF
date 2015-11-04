
package torneodatosadm;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class cancha {
    
    public boolean Insertar(datocancha user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros = new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        String sql="Insert into cancha values('"+user.getId_cancha()+"', '"+user.getNombre()+"', '"+user.getNumero_identificador()+"',"
                + " '"+user.getHora()+"','"+user.getTorneo()+"');";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
    public boolean Eliminar(datoarbitro user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros = new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        String sql="Insert into arbitro values('"+user.getCedula()+"', '"+user.getNombre()+"');";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
}
