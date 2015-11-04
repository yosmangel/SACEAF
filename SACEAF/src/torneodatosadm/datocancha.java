
package torneodatosadm;

public class datocancha {
String id_cancha;
String nombre;
String numero_identificador;
String hora;
String torneo;

    public datocancha(String id_cancha, String nombre, String numero_identificador, String hora,String torneo) {
        this.id_cancha = id_cancha;
        this.nombre = nombre;
        this.numero_identificador = numero_identificador;
        this.hora = hora;
        this.torneo=torneo;
    }

    public String getTorneo() {
        return torneo;
    }

    public String getId_cancha() {
        return id_cancha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumero_identificador() {
        return numero_identificador;
    }

    public String getHora() {
        return hora;
    }

}
