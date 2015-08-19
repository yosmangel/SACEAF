/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SancionesJugadorBdD;

public class DatosSancionesJugador {
    
    private final int id_Sancion;
    private final String MotivoSancion;
    private final int FechasSuspension;
    private final String Cedula;
    
   
    
    public DatosSancionesJugador(int id_Sancion, String MotivoSancion, int FechasSuspension, String Cedula){
        
        this.id_Sancion=id_Sancion;
        this.MotivoSancion=MotivoSancion;
        this.FechasSuspension=FechasSuspension;
        this.Cedula=Cedula;
       
    
}
    public int getid_Sancion() {
        return id_Sancion;
    }

    public String getMotivoSancion() {
        return MotivoSancion;
    }

    public int getFechasSuspension() {
        return FechasSuspension;
    }
    public String getCedula() {
        return Cedula;
    }

 


    
    
}
