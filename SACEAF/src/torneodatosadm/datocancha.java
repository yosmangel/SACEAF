
package torneodatosadm;

public class datocancha {
String id_cancha;
String nombre;
String numero_identificador;
String hora;

    public datocancha(String id_cancha, String nombre, String numero_identificador, String hora) {
        this.id_cancha = id_cancha;
        this.nombre = nombre;
        this.numero_identificador = numero_identificador;
        this.hora = hora;
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
