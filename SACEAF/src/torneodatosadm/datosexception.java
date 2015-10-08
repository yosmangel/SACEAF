
package torneodatosadm;


public class datosexception {
    
    String idexception;
    int edad;
    String torneo;

    public datosexception(String idexception, int edad, String torneo) {
        this.idexception = idexception;
        this.edad = edad;
        this.torneo = torneo;
    }

    public String getTorneo() {
        return torneo;
    }


    public String getIdexception() {
        return idexception;
    }

    public int getEdad() {
        return edad;
    }
    
    
    
}
