/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SancionesEquipoBdD;



public class DatosSancionesEquipo {
    
    private final int id_Sancion;
    private final String MotivoSancion;
    private final int FechasSuspension;
    private final String id_equipo;
    
   
    
    public DatosSancionesEquipo(int id_Sancion, String MotivoSancion, int FechasSuspension, String id_equipo){
        
        this.id_Sancion=id_Sancion;
        this.MotivoSancion=MotivoSancion;
        this.FechasSuspension=FechasSuspension;
        this.id_equipo=id_equipo;
       
    
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
    public String getid_equipo() {
        return id_equipo;
    }

 


    
    
}
