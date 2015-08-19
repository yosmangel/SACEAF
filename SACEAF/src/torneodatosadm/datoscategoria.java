/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package torneodatosadm;


public class datoscategoria {
    
    String idcategoriatorneo;
    String idcategoria;
    String idtorneo;
    
    public datoscategoria(String idcategoriatorneo, String idcategoria, String idtorneo){
        this.idcategoriatorneo=idcategoriatorneo;
        this.idcategoria=idcategoria;
        this.idtorneo=idtorneo;
    }

    public String getIdcategoriatorneo() {
        return idcategoriatorneo;
    }

    public String getIdcategoria() {
        return idcategoria;
    }

    public String getIdtorneo() {
        return idtorneo;
    }
}
