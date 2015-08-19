/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Basededatos;

/**
 *
 * @author yosmangel
 */
public class Conexion {
    
   public String Driver;
   public String Usuario;
   public String Pass;
   public String URL;
   public String BD;
   
   public Conexion(){
       this.Driver="com.mysql.jdbc.Driver";
       this.Usuario="root";
       this.Pass="123456";
       this.BD="asomiranda";
       this.URL="jdbc:mysql://localhost/"+BD;
   }

    public String getDriver() {
        return Driver;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getPass() {
        return Pass;
    }

    public String getURL() {
        return URL;
    }

    public String getBD() {
        return BD;
    }
   
    
}
