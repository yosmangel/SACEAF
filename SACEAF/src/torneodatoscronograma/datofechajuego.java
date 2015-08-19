
package torneodatoscronograma;

public class datofechajuego {
   
    String id_juego;
    String fecha_juego;

    public datofechajuego(String id_juego, String fecha_juego) {
        this.id_juego = id_juego;
        this.fecha_juego = fecha_juego;
    }

    public String getId_juego() {
        return id_juego;
    }

    public String getFecha_juego() {
        return fecha_juego;
    }
    
}
