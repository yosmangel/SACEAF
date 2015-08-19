
package torneodatoseq;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class torneojugador {
    
    public boolean Insertar(datosjugadort user) throws SQLException, ClassNotFoundException{
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
        Statement st= con.createStatement();
        String sql="Insert into h_jugador values('"+user.getId_hjugador()+"', '"+user.getCedulaj()+"', '"+user.getIdcategoria()+"',"
                + " '"+user.getN_nomina()+"','"+user.getGoles()+"',"
                + "'"+user.getTarjetas_a()+"','"+user.getTarjetas_r()+"', '"+user.getId_equipo()+"', '"+user.getId_torneo()+"');";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
    
     public boolean Eliminar(borrarjugadort user) throws SQLException, ClassNotFoundException{
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
        Statement st= con.createStatement();
        String sql="Delete from h_jugador where id_hjugador='"+user.getId_hjugador()+"';";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
     public boolean Modificar(actualizarnomina user1) throws SQLException, ClassNotFoundException{
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
        Statement st= con.createStatement();
        String sql="Update h_jugador set n_nomina='"+user1.getN_nomina()+"' where id_hjugador='"+user1.getId_hjugador()+"';";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
}
