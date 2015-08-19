
package torneodatoscronograma;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class formulario2 {
    
    public boolean Insertar(datoformulario2 user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(),parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        String sql="Insert into formulariotitular values('"+user.getFormulariotitular()+"',"
                + "'"+ user.getNumero()+"','"+user.getIdhjugador()+"', '"+user.getHlocal()+"',"
                + "'"+user.getIdformulario()+"');";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
}
