/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datosadministracion;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class disciplina {
  
    public boolean Insertar(datosmunicipio user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st=con.createStatement();
        boolean result;
        String sql=("Insert into disciplina values('"+user.getSerial()+"','"+user.getNombre()+"')");
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
    
    public boolean Eliminar(datoeliminar user) throws SQLException, ClassNotFoundException{
        
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement st= con.createStatement();
        boolean result;
        String sql="Delete from disciplina where id_disciplina='"+user.getSerial()+"'";
        result=st.execute(sql);
        st.close();
        con.close();
        return result;
    }
}
