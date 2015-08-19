
package torneodatoscronograma;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class equiponumero {

    int p=0;
    public boolean Guardar(datosnumeroeq user) throws SQLException, ClassNotFoundException{
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        String sql="update h_equipo set numero_eq='"+user.getNumeroeq()+"', posicion='"+user.getNumeroeq()+"', "
                + "grupo_equipo='"+user.getGrupo()+"' where id_hequipo='"+user.getIdhequipo()+"';";
        String sql2="Insert into posiciones values('"+user.getIdhequipo()+"','"+user.getNumeroeq()+"','"+p+"','"+p+"','"+p+"','"+p+"',"
                + "'"+p+"','"+p+"','"+p+"','"+p+"','"+user.getIdhequipo()+"','"+user.getId_categoria()+"','"+user.getId_torneo()+"');";
        boolean result;
        result=st.execute(sql);
        result=st.execute(sql2);
        st.close();
        con.close();
        return result;
    }
}
