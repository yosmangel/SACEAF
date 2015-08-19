/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Basededatos.equipo;


public class datobloquear {

    String bloquear;
    String serial;
    
    public datobloquear(String bloquear, String serial){
        this.bloquear=bloquear;
        this.serial=serial;
    }

    public String getBloquear() {
        return bloquear;
    }

    public String getSerial() {
        return serial;
    }
}
