/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Basededatos.equipo;


public class datosjugador {

    String cedula;
    String nombre;
    String apellido;
    int dia;
    int mes;
    int year;
    String fechadenacimiento;
    String serialequipo;
    String ficha;
    String foto;
    String nacionalidad;
    String bloqueo;
    
     public datosjugador(String cedula, String nombre, String apellido, int dia, int mes, int year, String fechadenacimiento, String serialequipo, String ficha, String foto, String nacionalidad, String bloqueo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dia = dia;
        this.mes = mes;
        this.year = year;
        this.fechadenacimiento = fechadenacimiento;
        this.serialequipo = serialequipo;
        this.ficha = ficha;
        this.foto = foto;
        this.nacionalidad = nacionalidad;
        this.bloqueo = bloqueo;
    }

    public String getBloqueo() {
        return bloqueo;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getYear() {
        return year;
    }

    public String getFechadenacimiento() {
        return fechadenacimiento;
    }

    public String getSerialequipo() {
        return serialequipo;
    }

    public String getFicha() {
        return ficha;
    }

    public String getFoto() {
        return foto;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    
    
}
