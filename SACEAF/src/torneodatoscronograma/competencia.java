
package torneodatoscronograma;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class competencia {
    
    public boolean Insertar(datoscompetencia user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(),parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        String sql="Insert into competencia values('"+user.getId_competencia()+"',"
                + "'"+ user.getDatogrupos()+"','"+user.getDatosequiposgrupos()+"', '"+user.getDatoclasificaxgrupo()+"',"
                + "'"+user.getDatomejor()+"'"
                + ",'"+user.getDatopasanmejor()+"','"+user.getId_modalidad()+"', '"+user.getRonda()+"');";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
    
    public boolean Modificar(datomodificarrondas user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(),parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        String sql="Update competencia set rondas='"+user.getNrondas()+"' where id_competencia='"+user.getIdcompetencia()+"';";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
}
