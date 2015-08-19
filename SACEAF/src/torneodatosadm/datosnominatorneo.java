
package torneodatosadm;


public class datosnominatorneo {
    
    String idnomina;
    int numero;
    String torneo;

    public datosnominatorneo(String idnomina, int numero, String torneo) {
        this.idnomina = idnomina;
        this.numero = numero;
        this.torneo = torneo;
    }

    public String getIdnomina() {
        return idnomina;
    }

    public int getNumero() {
        return numero;
    }

    public String getTorneo() {
        return torneo;
    }
    
    
}
