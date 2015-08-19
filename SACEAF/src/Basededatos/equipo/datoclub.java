
package Basededatos.equipo;


public class datoclub {
   
    String idclub;
    String nombreclub;
    String presidente;
    String imagen;
    String nombreimagen;
    String bloqueo;
    String municipio;
    
    public datoclub(String idclub, String nombreclub, String presidente, String imagen, String nombreimagen,String bloqueo,String municipio){
        
        this.idclub=idclub;
        this.nombreclub=nombreclub;
        this.presidente=presidente;
        this.imagen=imagen;
        this.nombreimagen=nombreimagen;
        this.bloqueo=bloqueo;
        this.municipio=municipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getBloqueo() {
        return bloqueo;
    }

    public String getIdclub() {
        return idclub;
    }

    public String getNombreclub() {
        return nombreclub;
    }


    public String getPresidente() {
        return presidente;
    }

    public String getImagen() {
        return imagen;
    }

    public String getNombreimagen() {
        return nombreimagen;
    }

}
