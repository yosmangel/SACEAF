
package torneodatosadm;


public class datoformulariogoles {
    String id_hequipo;
    String idhjugador;
        int numero;
        int minuto;
        int marcador_local;
        int marcador_visitante;
        String idformulario;
        String id_fgoles;
        int golesj;
        int golese;

    public datoformulariogoles(String id_hequipo, String idhjugador, int numero, int minuto, int marcador_local, int marcador_visitante, String idformulario, String id_fgoles, int golesj, int golese) {
        this.id_hequipo = id_hequipo;
        this.idhjugador = idhjugador;
        this.numero = numero;
        this.minuto = minuto;
        this.marcador_local = marcador_local;
        this.marcador_visitante = marcador_visitante;
        this.idformulario = idformulario;
        this.id_fgoles = id_fgoles;
        this.golesj = golesj;
        this.golese = golese;
    }

    public int getGolesj() {
        return golesj;
    }

    public int getGolese() {
        return golese;
    }
        


    public String getId_hequipo() {
        return id_hequipo;
    }

    public String getIdhjugador() {
        return idhjugador;
    }

    public int getNumero() {
        return numero;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getMarcador_local() {
        return marcador_local;
    }

    public int getMarcador_visitante() {
        return marcador_visitante;
    }

    public String getIdformulario() {
        return idformulario;
    }

    public String getId_fgoles() {
        return id_fgoles;
    }
        
        
}
