
package torneodatos;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class torneo {
    
    public boolean Insertar(datostorneo user) throws SQLException, ClassNotFoundException {
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        boolean result;
        String sql="Insert into torneo values('"+user.getSerialtorneo()+"','"+user.getNombretorneo()+"',"
                + "'"+user.getFechaini()+"','"+user.getFechafin()+"', '"+user.getDisciplina()+"','"+user.getSexo()+"')";
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
        
    }
}
