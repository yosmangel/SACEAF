/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SancionesEquipoBdD;


public class DatosDeudaEquipo {
    
    private int ID_Deuda;
    
    private String Fecha_Deuda;
    
    private String Hora_Deuda;
    
    private String Motivo_Deuda;
    
    private float Monto_Deuda_Total;
    
    private float Monto_Deuda_Restante;
    
    private String ID_Club;
    
    private String ID_Equipo;
    
    
    public DatosDeudaEquipo(int ID_Deuda, String Fecha_Deuda, String Hora_Deuda, String Motivo_Deuda, float Monto_Deuda_Total, float Monto_Deuda_Restante, String ID_Club, String ID_Equipo){
        
        this.ID_Deuda=ID_Deuda;
        this.Fecha_Deuda=Fecha_Deuda;
        this.Hora_Deuda=Hora_Deuda;
        this.Motivo_Deuda=Motivo_Deuda;
        this.Monto_Deuda_Total=Monto_Deuda_Total;
        this.Monto_Deuda_Restante=Monto_Deuda_Restante;
        this.ID_Club=ID_Club;
        this.ID_Equipo=ID_Equipo;
    }

    public int getID_Deuda() {
        return ID_Deuda;
    }

    public String getFecha_Deuda() {
        return Fecha_Deuda;
    }

    public String getHora_Deuda() {
        return Hora_Deuda;
    }

    public String getMotivo_Deuda() {
        return Motivo_Deuda;
    }

    public float getMonto_Deuda_Total() {
        return Monto_Deuda_Total;
    }

    public float getMonto_Deuda_Restante() {
        return Monto_Deuda_Restante;
    }

    public String getID_Club() {
        return ID_Club;
    }

    public String getID_Equipo() {
        return ID_Equipo;
    }
    
    
}
