
package torneodatosadm;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class formulariogoles {
    
     public boolean Insertar(datoformulariogoles user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(),parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        String sql="Insert into formulariogoles values('"+user.getId_fgoles()+"',"
                + "'"+ user.getId_hequipo()+"','"+user.getIdhjugador()+"', '"+user.getNumero()+"',"
                + "'"+user.getMinuto()+"'"
                + ",'"+user.getMarcador_local()+"','"+user.getMarcador_visitante()+"', '"+user.getIdformulario()+"');";
        String sql2="Update h_equipo set equipo_goles='"+user.getGolese()+"' where id_hequipo='"+user.getId_hequipo()+"';";
        String sql3="Update h_jugador set goles='"+user.getGolesj()+"' where id_hjugador='"+user.getIdhjugador()+"';";
        boolean result;
        result=st.execute(sql);
        result=st.execute(sql2);
        result=st.execute(sql3);
        st.close();
        con.close();
        return result;
    }
}
