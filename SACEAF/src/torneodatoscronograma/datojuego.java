
package torneodatoscronograma;


public class datojuego {
    String id_juego;
    String jornada;
    String nombre_juego;
    String equipo_local;
    String equipo_visitante;
    String grupos;
    String id_categoria;
    String id_torneo;

    public datojuego(String id_juego, String jornada, String nombre_juego, String equipo_local, String equipo_visitante, String grupos, String id_categoria, String id_torneo) {
        this.id_juego = id_juego;
        this.jornada = jornada;
        this.nombre_juego = nombre_juego;
        this.equipo_local = equipo_local;
        this.equipo_visitante = equipo_visitante;
        this.grupos = grupos;
        this.id_categoria = id_categoria;
        this.id_torneo = id_torneo;
    }

    public String getId_juego() {
        return id_juego;
    }

    public String getJornada() {
        return jornada;
    }

    public String getNombre_juego() {
        return nombre_juego;
    }

    public String getEquipo_local() {
        return equipo_local;
    }

    public String getEquipo_visitante() {
        return equipo_visitante;
    }

    public String getGrupos() {
        return grupos;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public String getId_torneo() {
        return id_torneo;
    }
    
}
