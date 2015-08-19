/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPagosBdD;
import Basededatos.Conexion;
import java.sql.*;

public class InsertarPagosEquipos {
    
    Conexion parametros = new Conexion();
    public boolean InsertarBdD(DatosPagosEquipos user)throws SQLException,
            
    ClassNotFoundException{
        Class.forName(parametros.getDriver());
        Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement stm = con.createStatement();
        String query="INSERT INTO Pagos VALUES('"+user.getId_pago()+"','"+user.getFechaPago()+"','"+user.getHoraPago()+"','"+user.getNombreTitular()+"','"+user.getMotivoPago()+"','"+user.getMontoDeudaRestante()+"','"+user.getPagoEfectuado()+"','"+user.getSerialEquipo()+"','"+user.getSerialClub()+"')";
        boolean Result=stm.execute(query);
        stm.close();
        con.close();
        return Result;
    }
   
    
}
