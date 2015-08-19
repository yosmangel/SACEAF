
package torneodatoscronograma;


public class datoformulario2 {
        String idtorneo;
        String hlocal;
        String idformulario;
        String idhjugador;
        int numero;
        String formulariotitular;

    public datoformulario2(String idtorneo, String hlocal, String idformulario, String idhjugador, int numero, String formulariotitular) {
        this.idtorneo = idtorneo;
        this.hlocal = hlocal;
        this.idformulario = idformulario;
        this.idhjugador = idhjugador;
        this.numero = numero;
        this.formulariotitular = formulariotitular;
    }

    public String getFormulariotitular() {
        return formulariotitular;
    }



    public String getIdtorneo() {
        return idtorneo;
    }

    public String getHlocal() {
        return hlocal;
    }

    public String getIdformulario() {
        return idformulario;
    }

    public String getIdhjugador() {
        return idhjugador;
    }

    public int getNumero() {
        return numero;
    }
        
}
