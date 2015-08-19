/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Basededatos.equipo;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class equipo {

    public boolean Insertar(datoequipo user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
        Statement st= con.createStatement();
        String sql=("Insert into equipo values('"+user.getSerialequipo()+"','"+user.getDelegado()+"','"+user.getSerialclub()+"'"
                + ",'"+user.getCategoria()+"','"+user.getBloqueo()+"','"+user.getDisciplina()+"','"+user.getIdentificador()+"');");
        boolean result;
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
    
    public boolean Bloquear(datobloquear user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
        Statement st=con.createStatement();
        boolean result;
        String sql="Update equipo Set bloqueo='"+user.getBloquear()+"' where id_equipo='"+user.getSerial()+"';";
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
        public boolean Desbloquear(datobloquear user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
        Statement st=con.createStatement();
        boolean result;
        String sql="Update equipo Set bloqueo='"+user.getBloquear()+"' where id_equipo='"+user.getSerial()+"';";
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
        public boolean Modificar(datomodificarequipo user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
        Statement st=con.createStatement();
        boolean result;
        String sql="Update equipo Set identificador='"+user.getIdentificador()+"', delegadoeq='"+user.getDelegado()+"'"
        + " where id_equipo='"+user.getEquipo()+"';";
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
}
