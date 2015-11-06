package Basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionReportes {
      
    public static Connection GetConnection()
    {
        Connection conectar=null;
      
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost/asomiranda";
            String usuarioDB="root";
            String passwordDB="123456";
            conectar= DriverManager.getConnection(servidor,usuarioDB,passwordDB);
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexion con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conectar=null;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexion con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conectar=null;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexion con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conectar=null;
        }
        finally
        {
            return conectar;
        }
    }
}
