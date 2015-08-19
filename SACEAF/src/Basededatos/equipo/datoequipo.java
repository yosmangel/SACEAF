/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Basededatos.equipo;


public class datoequipo {
   
    String serialequipo;
    String delegado;
    String serialclub;
    String categoria;
    String bloqueo;
    String disciplina;
    String identificador;
    
    public datoequipo(String serialequipo, String delegado, String serialclub, String categoria, String bloqueo, String disciplina, String identificador){
        
        this.serialequipo=serialequipo;
        this.delegado=delegado;
        this.serialclub=serialclub;
        this.categoria=categoria;
        this.bloqueo=bloqueo;
        this.disciplina=disciplina;
        this.identificador=identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getSerialequipo() {
        return serialequipo;
    }

    public String getDelegado() {
        return delegado;
    }

    public String getSerialclub() {
        return serialclub;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getBloqueo() {
        return bloqueo;
    }

    public String getDisciplina() {
        return disciplina;
    }
}
