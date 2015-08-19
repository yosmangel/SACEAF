
package Basededatos.equipo;


public class traspaso {
 
    String id_traspaso;
    String cedula;
    String idequipoactual;
    String idequiporeceptor;
    String fecha;

    public traspaso(String id_traspaso, String cedula, String idequipoactual, String idequiporeceptor, String fecha) {
        this.id_traspaso = id_traspaso;
        this.cedula = cedula;
        this.idequipoactual = idequipoactual;
        this.idequiporeceptor = idequiporeceptor;
        this.fecha = fecha;
    }

    public String getId_traspaso() {
        return id_traspaso;
    }

    public String getCedula() {
        return cedula;
    }

    public String getIdequipoactual() {
        return idequipoactual;
    }

    public String getIdequiporeceptor() {
        return idequiporeceptor;
    }

    public String getFecha() {
        return fecha;
    }
    
}
