
package torneodatosadm;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class torneocategoria {

    public boolean Insertar(datoscategoria user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros = new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        String sql="Insert into categoria_torneo values('"+user.getIdcategoriatorneo()+"', '"+user.getIdtorneo()+"','"+user.getIdcategoria()+"');";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
    
    public boolean Eliminar(datoborrart user) throws SQLException, ClassNotFoundException{
        Conexion parametros = new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        String sql="Delete from categoria_torneo where id_categoriatorneo=('"+user.getSerialborrart()+"');";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
}
