
package torneodatoscronograma;

public class datosnumeroeq {
    String idhequipo;
    int numeroeq;
    String grupo;
    String id_categoria;
    String id_torneo;

    public datosnumeroeq(String idhequipo, int numeroeq, String grupo,String id_categoria, String id_torneo) {
        this.idhequipo = idhequipo;
        this.numeroeq = numeroeq;
        this.grupo = grupo;
        this.id_categoria=id_categoria;
        this.id_torneo=id_torneo;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public String getId_torneo() {
        return id_torneo;
    }

    public String getIdhequipo() {
        return idhequipo;
    }

    public int getNumeroeq() {
        return numeroeq;
    }

    public String getGrupo() {
        return grupo;
    }
    
    
}
