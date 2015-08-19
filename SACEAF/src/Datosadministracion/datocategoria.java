
package Datosadministracion;


public class datocategoria {

    String serial;
    String nombre;
    int year_final;
    int year_ini;
    String sexo;
    
    public datocategoria(String serial, String nombre, int year_final, int year_ini, String sexo){
        
        this.serial=serial;
        this.nombre=nombre;
        this.year_final=year_final;
        this.year_ini=year_ini;
        this.sexo=sexo;
    }

    public String getSerial() {
        return serial;
    }

    public String getNombre() {
        return nombre;
    }

    public int getYear_final() {
        return year_final;
    }

    public int getYear_ini() {
        return year_ini;
    }

    public String getSexo() {
        return sexo;
    }
}
