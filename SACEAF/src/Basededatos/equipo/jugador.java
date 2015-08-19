
package Basededatos.equipo;

import Basededatos.Conexion;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class jugador {

Conexion parametros= new Conexion();
    public boolean Insertar(datosjugador user) throws SQLException, ClassNotFoundException{
        try{
       // FileInputStream fis = null;

        //PreparedStatement ps = null;
        //File file = new File(user.getFoto());
        //fis = new FileInputStream(file);
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
        Statement stm=con.createStatement();
        boolean result;
        String sql="Insert into jugador values('"+user.getCedula()+"','"+user.getNombre()+"','"+user.getApellido()+"'"
                + ",'"+user.getDia()+"','"+user.getMes()+"','"+user.getYear()+"','"+user.getFechadenacimiento()+"',"
                + "'"+user.getSerialequipo()+"','"+user.getFicha()+"','"+user.getNacionalidad()+"',"
                + " '"+user.getBloqueo()+"');";
        //String insert="Insert into imagenclub(id_imgjugador, foto, nombre_imgjugador, cedula) values(?,?,?,?);";
        result=stm.execute(sql);
        //ps=con.prepareStatement(insert);
        //ps.setString(1, user.getCedula());
        //ps.setBinaryStream(2,fis,(int)file.length());
        //ps.setString(3, user.getNombre() );
        //ps.setString(4, user.getCedula());
        //ps.executeUpdate();
        stm.close();
        //ps.close();
        con.close();
        return result;
        }catch (Exception ex) {
            Logger.getLogger(jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
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
