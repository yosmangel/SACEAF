
package torneodatosadm;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class arbitro {
    
    public boolean Insertar(datoarbitro user) throws SQLException, ClassNotFoundException{
        
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
        public boolean Eliminar(borrararbitros user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros = new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        String sql="Delete from arbitro where id_arbitro='"+user.getId_arbitros()+"';";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
}
