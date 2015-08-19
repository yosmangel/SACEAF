
package torneodatoscronograma;


public class datomodalidad {
    String id_modalidad;
    String nombre_modalidad;
    String id_categoria;
    String datopostfase;
    String id_torneo;

    public datomodalidad(String id_modalidad, String nombre_modalidad, String id_categoria, String datopostfase, String id_torneo) {
        this.id_modalidad = id_modalidad;
        this.nombre_modalidad = nombre_modalidad;
        this.id_categoria = id_categoria;
        this.datopostfase = datopostfase;
        this.id_torneo = id_torneo;
    }

    public String getId_modalidad() {
        return id_modalidad;
    }

    public String getNombre_modalidad() {
        return nombre_modalidad;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public String getDatopostfase() {
        return datopostfase;
    }

    public String getId_torneo() {
        return id_torneo;
    }
    
    
}
