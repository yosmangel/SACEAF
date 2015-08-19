
package torneodatoscronograma;


public class datoformulario1 {
    
    String id_formulario;
    String idtorneo;
    String idcategoria;
    String idcancha;
    String eequipo_local;
    String eequipo_visitante;

    public datoformulario1(String id_formulario, String idtorneo, String idcategoria, String idcancha, String eequipo_local, String eequipo_visitante) {
        this.id_formulario = id_formulario;
        this.idtorneo = idtorneo;
        this.idcategoria = idcategoria;
        this.idcancha = idcancha;
        this.eequipo_local = eequipo_local;
        this.eequipo_visitante = eequipo_visitante;
    }

    public String getId_formulario() {
        return id_formulario;
    }

    public String getIdtorneo() {
        return idtorneo;
    }

    public String getIdcategoria() {
        return idcategoria;
    }

    public String getIdcancha() {
        return idcancha;
    }

    public String getEequipo_local() {
        return eequipo_local;
    }

    public String getEequipo_visitante() {
        return eequipo_visitante;
    }
    
    
}
