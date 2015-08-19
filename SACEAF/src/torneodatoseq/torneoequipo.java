
package torneodatoseq;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class torneoequipo {
        int p=0;
    public boolean Insertar(datosequipot user)throws SQLException , ClassNotFoundException{
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
    
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        String sql="Insert into h_equipo values('"+user.getId_hequipo()+"' ,'"+user.getId_equipo()+"','"+p+"',"
                + "'"+p+"','"+user.getId_torneo()+"', '"+p+"','"+p+"','"+p+"','"+p+"','"+user.getIdcategoria()+"');";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
    public boolean Eliminar(borrarequipot user)throws SQLException , ClassNotFoundException{
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
    
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        String sql="Delete from h_equipo where id_hequipo='"+user.getId_serialb()+"';";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
}
}
