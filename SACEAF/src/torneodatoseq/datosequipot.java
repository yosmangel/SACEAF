
package torneodatoseq;


public class datosequipot {
    String id_hequipo;
    String id_equipo;
    String id_torneo;
    String idcategoria;
    
    public datosequipot(String id_hequipo, String id_equipo, String id_torneo,String idcategoria){
        this.id_hequipo=id_hequipo;
        this.id_equipo=id_equipo;
        this.id_torneo=id_torneo;
        this.idcategoria=idcategoria;
    }

    public String getIdcategoria() {
        return idcategoria;
    }

    public String getId_equipo() {
        return id_equipo;
    }

    public String getId_torneo() {
        return id_torneo;
    }

    public String getId_hequipo() {
        return id_hequipo;
    }
}
