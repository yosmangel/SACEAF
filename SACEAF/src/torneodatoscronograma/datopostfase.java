
package torneodatoscronograma;


public class datopostfase {
  
    String idcruce;
    String instancia;
    String letra1;
    int numero1;
    String letra2;
    int numero2;
    String id_torneo;
    String id_categoria;
    

    public datopostfase(String idcruce, String instancia, String letra1, int numero1, String letra2, int numero2, String id_torneo, String id_categoria) {
        this.idcruce = idcruce;
        this.instancia = instancia;
        this.letra1 = letra1;
        this.numero1 = numero1;
        this.letra2 = letra2;
        this.numero2 = numero2;
        this.id_torneo = id_torneo;
        this.id_categoria = id_categoria;
    }

    public String getIdcruce() {
        return idcruce;
    }

    public String getInstancia() {
        return instancia;
    }

    public String getLetra1() {
        return letra1;
    }

    public int getNumero1() {
        return numero1;
    }

    public String getLetra2() {
        return letra2;
    }

    public int getNumero2() {
        return numero2;
    }

    public String getId_torneo() {
        return id_torneo;
    }

    public String getId_categoria() {
        return id_categoria;
    }
           
    
}
