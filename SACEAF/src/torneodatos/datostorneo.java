
package torneodatos;


public class datostorneo {
    String serialtorneo;
    String nombretorneo;
    String fechaini;
    String fechafin;
    String disciplina;
    String sexo;
    
    public datostorneo(String serialtorneo,String nombretorneo, String fechaini, String fechafin, String disciplina, String sexo){
    this.serialtorneo=serialtorneo;
    this.nombretorneo=nombretorneo;
    this.fechaini=fechaini;
    this.fechafin=fechafin;
    this.disciplina=disciplina;
    this.sexo=sexo;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getSexo() {
        return sexo;
    }

    public String getSerialtorneo() {
        return serialtorneo;
    }

    public String getNombretorneo() {
        return nombretorneo;
    }

    public String getFechaini() {
        return fechaini;
    }

    public String getFechafin() {
        return fechafin;
    }
}
