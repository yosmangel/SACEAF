
package torneodatoscronograma;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class juegos {
    
    public boolean Insertar(datojuego user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(),parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        String sql="Insert into juego values('"+user.getId_juego()+"',"
                + "'"+ user.getJornada()+"','"+user.getNombre_juego()+"', '"+user.getEquipo_local()+"',"
                + "'"+user.getEquipo_visitante()+"'"
                + ",'"+user.getGrupos()+"','"+user.getId_categoria()+"', '"+user.getId_torneo()+"');";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
}
