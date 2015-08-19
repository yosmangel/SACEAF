
package Basededatos.equipo;


public class datomodificarjugador {
    
    String cedula;
    String nombre;
    String apellido;
    int idia;
    int imes;
    int iyear;
    String fechadenacimiento;
    String foto;
    String nacionalidad;

    public datomodificarjugador(String cedula, String nombre, String apellido, int idia, int imes, int iyear, String fechadenacimiento, String foto, String nacionalidad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idia = idia;
        this.imes = imes;
        this.iyear = iyear;
        this.fechadenacimiento = fechadenacimiento;
        this.foto = foto;
        this.nacionalidad = nacionalidad;
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

    public int getIdia() {
        return idia;
    }

    public int getImes() {
        return imes;
    }

    public int getIyear() {
        return iyear;
    }

    public String getFechadenacimiento() {
        return fechadenacimiento;
    }

    public String getFoto() {
        return foto;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    
    
}
