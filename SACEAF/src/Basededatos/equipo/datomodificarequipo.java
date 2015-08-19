/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basededatos.equipo;


public class datomodificarequipo {
    String equipo;
    String identificador;
    String delegado;

    public datomodificarequipo(String equipo, String identificador, String delegado) {
        this.equipo = equipo;
        this.identificador = identificador;
        this.delegado = delegado;
    }

    public String getEquipo() {
        return equipo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getDelegado() {
        return delegado;
    }
    
}
