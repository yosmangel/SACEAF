/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPagosBdD;

public class DatosPagosEquipos {
    
    private int id_pago;
    
    private String FechaPago;
    
    private String HoraPago;
    
    private String NombreTitular;
    
    private String MotivoPago;
    
    private float MontoDeudaRestante;
    
    private float PagoEfectuado;
    
    private String SerialEquipo;
    
    private String SerialClub;
    
    public DatosPagosEquipos(int id_pago, String FechaPago, String HoraPago, String NombreTitular, String MotivoPago, float MontoDeudaRestante, float PagoEfectuado, String SerialEquipo, String SerialClub){
        
        this.id_pago=id_pago;
        this.FechaPago=FechaPago;
        this.HoraPago=HoraPago;
        this.NombreTitular=NombreTitular;
        this.MotivoPago=MotivoPago;
        this.MontoDeudaRestante=MontoDeudaRestante;
        this.PagoEfectuado=PagoEfectuado;
        this.SerialEquipo=SerialEquipo;
        this.SerialClub=SerialClub;
    
}


    public int getId_pago() {
        return id_pago;
    }

    public String getFechaPago() {
        return FechaPago;
    }

    public String getHoraPago() {
        return HoraPago;
    }

    public String getNombreTitular() {
        return NombreTitular;
    }

    public String getMotivoPago() {
        return MotivoPago;
    }

    public float getMontoDeudaRestante() {
        return MontoDeudaRestante;
    }

    public float getPagoEfectuado() {
        return PagoEfectuado;
    }

    public String getSerialEquipo() {
        return SerialEquipo;
    }

    public String getSerialClub() {
        return SerialClub;
    }
 


    
    
}
