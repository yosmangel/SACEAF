
package torneodatoseq;


public class datosjugadort {
    
    String id_hjugador;
    String cedulaj;
    String idcategoria;
    int n_nomina;
    int goles;
    int tarjetas_a;
    int tarjetas_r;
    String id_equipo;
    String id_torneo;

    public datosjugadort(String id_hjugador, String cedulaj, String idcategoria, int n_nomina, int goles, int tarjetas_a, int tarjetas_r, String id_equipo, String id_torneo) {
        this.id_hjugador = id_hjugador;
        this.cedulaj = cedulaj;
        this.idcategoria = idcategoria;
        this.n_nomina = n_nomina;
        this.goles = goles;
        this.tarjetas_a = tarjetas_a;
        this.tarjetas_r = tarjetas_r;
        this.id_equipo = id_equipo;
        this.id_torneo = id_torneo;
    }

    public String getId_hjugador() {
        return id_hjugador;
    }

    public String getCedulaj() {
        return cedulaj;
    }

    public String getIdcategoria() {
        return idcategoria;
    }

    public int getN_nomina() {
        return n_nomina;
    }

    public int getGoles() {
        return goles;
    }

    public int getTarjetas_a() {
        return tarjetas_a;
    }

    public int getTarjetas_r() {
        return tarjetas_r;
    }

    public String getId_equipo() {
        return id_equipo;
    }

    public String getId_torneo() {
        return id_torneo;
    }
    
    
    
}
