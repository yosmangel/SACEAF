
package torneodatoscronograma;


public class datoscompetencia {
 
    String id_competencia;
    int datogrupos;
    int datoclasificaxgrupo;
    int datosequiposgrupos;
    int datomejor;
    int datopasanmejor;
    String id_modalidad;
    int ronda;

    public datoscompetencia(String id_competencia,int datogrupos, int datoclasificaxgrupo, int datosequiposgrupos, int datomejor, int datopasanmejor, String id_modalidad, int ronda) {
        this.id_competencia = id_competencia;
        this.datogrupos = datogrupos;
        this.datoclasificaxgrupo = datoclasificaxgrupo;
        this.datosequiposgrupos = datosequiposgrupos;
        this.datomejor = datomejor;
        this.datopasanmejor = datopasanmejor;
        this.id_modalidad = id_modalidad;
        this.ronda=ronda;
    }

    public int getRonda() {
        return ronda;
    }

    public String getId_competencia() {
        return id_competencia;
    }

    public int getDatogrupos() {
        return datogrupos;
    }

    public int getDatoclasificaxgrupo() {
        return datoclasificaxgrupo;
    }

    public int getDatosequiposgrupos() {
        return datosequiposgrupos;
    }

    public int getDatomejor() {
        return datomejor;
    }

    public int getDatopasanmejor() {
        return datopasanmejor;
    }

    public String getId_modalidad() {
        return id_modalidad;
    }
    
    
}
