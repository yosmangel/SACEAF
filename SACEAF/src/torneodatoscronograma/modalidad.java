
package torneodatoscronograma;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class modalidad {
    
    public boolean Insertar(datomodalidad user) throws SQLException, ClassNotFoundException {
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(),parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        String sql="Insert into modalidad values('"+user.getId_modalidad()+"','"+user.getNombre_modalidad()+"','"+user.getId_categoria()+"',"
                + " '"+user.getDatopostfase()+"', '"+user.getId_torneo()+"');";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
}
