
package torneodatoscronograma;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class postfase {
    
        public boolean Insertar(datopostfase user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(),parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        String sql="Insert into crucepostfase values('"+user.getIdcruce()+"',"
                + "'"+ user.getInstancia()+"','"+user.getLetra1()+"', '"+user.getNumero1()+"',"
                + "'"+user.getLetra2()+"'"
                + ",'"+user.getNumero2()+"','"+user.getId_torneo()+"', '"+user.getId_categoria()+"');";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
}
