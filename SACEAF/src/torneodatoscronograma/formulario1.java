
package torneodatoscronograma;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class formulario1 {
   
     public boolean Insertar(datoformulario1 user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(),parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        String sql="Insert into formulario values('"+user.getId_formulario()+"',"
                + "'"+ user.getIdtorneo()+"','"+user.getIdcategoria()+"', '"+user.getIdcancha()+"',"
                + "'"+user.getId_formulario()+"'"
                + ",'"+user.getEequipo_local()+"','"+user.getEequipo_visitante()+"', '"+user.getId_formulario()+"');";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
}
