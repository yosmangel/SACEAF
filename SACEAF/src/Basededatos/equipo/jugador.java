
package Basededatos.equipo;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class jugador {

Conexion parametros= new Conexion();
    public boolean Insertar(datosjugador user) throws SQLException, ClassNotFoundException{

        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
        Statement stm=con.createStatement();
        boolean result;
        String sql="Insert into jugador values('"+user.getCedula()+"','"+user.getNombre()+"','"+user.getApellido()+"'"
                + ",'"+user.getDia()+"','"+user.getMes()+"','"+user.getYear()+"','"+user.getFechadenacimiento()+"',"
                + "'"+user.getSerialequipo()+"','"+user.getFicha()+"','"+user.getNacionalidad()+"',"
                + " '"+user.getBloqueo()+"');";
        String insert="Insert into imagenjugador values('"+user.getCedula()+"', '"+user.getFoto()+"',"
                + "'"+user.getNombre()+" "+user.getApellido()+"', '"+user.getCedula()+"');";
        result=stm.execute(sql);
        result=stm.execute(insert);
        stm.close();
 
        con.close();
        return result;
        
    }
    public boolean Modificar(datomodificarjugador user) throws SQLException, ClassNotFoundException{
        Class.forName(parametros.getDriver());
        Connection con=DriverManager.getConnection(parametros.getURL(),parametros.getUsuario(),parametros.getPass());
        Statement st=con.createStatement();
        String sql="Update jugador set nombre_j='"+user.getNombre()+"', apellido_j='"+user.getApellido()+"'"
                + ",dia_j='"+user.getIdia()+"', mes_j='"+user.getImes()+"', year_j='"+user.getIyear()+"',"
                + "fecha_nacimiento='"+user.getFechadenacimiento()+"',"
                + "foto='"+user.getFoto()+"',nacionalidad='"+user.getNacionalidad()+"' where cedula='"+user.getCedula()+"';";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
        
    }
    public boolean Traspaso(traspaso user) throws SQLException, ClassNotFoundException{
        Class.forName(parametros.getDriver());
        Connection con=DriverManager.getConnection(parametros.getURL(),parametros.getUsuario(),parametros.getPass());
        Statement st=con.createStatement();
        String sql="Update jugador set id_equipo='"+user.getIdequiporeceptor()+"' where cedula='"+user.getCedula()+"';";
        String sql1="Insert into traspaso values('"+user.getId_traspaso()+"','"+user.getIdequiporeceptor()+"','"+user.getIdequipoactual()+"'"
                + ",'"+user.getCedula()+"','"+user.getFecha()+"');";
        boolean result;
        result=st.execute(sql1);
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
        
    }
    public boolean Bloquear(datobloquear user) throws SQLException, ClassNotFoundException{
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st= con.createStatement();
        String sql="Update jugador set bloqueo_j='"+user.getBloquear()+"' where cedula='"+user.getSerial()+"'";
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
}
