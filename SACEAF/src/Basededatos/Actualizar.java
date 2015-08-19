

package Basededatos;

import Estadisticas.Graficas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Actualizar {
        
    public boolean Actualizar(Graficas user)throws SQLException,ClassNotFoundException{ 
        
        Conexion parametros=new Conexion();
        Class.forName(parametros.getDriver());
        Connection con = DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        Statement stm = con.createStatement();
        boolean result;
        
        String  query = ("UPDATE estadisticas SET total = (SELECT count(id_arbitro) total From arbitro where id_total='0001') where id_total='0001';");
        result = stm.execute(query);

        String  query2 = ("UPDATE estadisticas SET total = (SELECT count(id_cancha) total From cancha where id_total='0002') where id_total='0002';");
        result = stm.execute(query);

        String  query3 = ("UPDATE estadisticas SET total = (SELECT count(id_categoria) total From categoria where id_total='0003') where id_total='0003';");
        result = stm.execute(query);

        String  query4 = ("UPDATE estadisticas SET total = (SELECT count(id_club) total From club where id_total='0004') where id_total='0004';");
        result = stm.execute(query);

        String  query5 = ("UPDATE estadisticas SET total = (SELECT count(id_disciplina) total From disciplina where id_total='0005') where id_total='0005';");
        result = stm.execute(query);

        String  query6 = ("UPDATE estadisticas SET total = (SELECT count(cedula) total From jugador where id_total='0006') where id_total='0006';");
        result = stm.execute(query);

        String  query7 = ("UPDATE estadisticas SET total = (SELECT count(id_usuario) total From usuario where id_total='0007') where id_total='0007';");
        result = stm.execute(query);

        stm.close();
        con.close();
        return result;
        }
    }