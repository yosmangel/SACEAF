/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPagos;

import Basededatos.Conexion;
import static GestionPagos.VerClub.PanelDeudasEquipos;
import static GestionPagos.VerDeudasDelEquipo.TablaDeudasDelEquipo;
import static GestionPagos.VerDeudasEquipos.TablaDeudasEquipos;
import GestionPagosBdD.DatosPagosEquipos;
import GestionPagosBdD.InsertarPagosEquipos;
import java.awt.MenuComponent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import saceaf.Principal;
import static saceaf.Principal.panelprincipal;

public class AgregarPago extends javax.swing.JPanel {
    private MenuComponent VerDeudasDelEquipo;


    /**
     * Creates new form AgregarPago
     */
    public AgregarPago() {
        initComponents();
    }
public void HabilitarGuardar(){
        
        String Titular=this.CampoTitular.getText();
        String PagoEfectuar=this.CampoPago.getText();
        String MotivoPago=this.CampoMotivo.getText();

        
        if(Titular.isEmpty() || PagoEfectuar.isEmpty() || MotivoPago.isEmpty()){
            
            this.BotonRealizarPago.setEnabled(false);
        }
        
        else{
            this.BotonRealizarPago.setEnabled(true);
        }
    }

public void VerDeudasDelEquipo(){
       VerDeudasDelEquipo AbrirDeudasDelEquipo= new VerDeudasDelEquipo();
       String titulo="Deudas Del Equipo";
        int index=PanelDeudasEquipos.indexOfTab(titulo);
        if(index==-1){
            PanelDeudasEquipos.addTab(titulo, AbrirDeudasDelEquipo);
            int i=PanelDeudasEquipos.indexOfTab(titulo);
            PanelDeudasEquipos.setSelectedIndex(i);
        }else{
            PanelDeudasEquipos.remove(index);
            PanelDeudasEquipos.addTab(titulo, AbrirDeudasDelEquipo);
            int i=PanelDeudasEquipos.indexOfTab(titulo);
            PanelDeudasEquipos.setSelectedIndex(i);
        }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CampoMotivo = new javax.swing.JTextArea();
        LabelTitular = new javax.swing.JLabel();
        CampoTitular = new javax.swing.JTextField();
        LabelDeuda = new javax.swing.JLabel();
        CampoDeuda = new javax.swing.JTextField();
        CampoPago = new javax.swing.JTextField();
        LabelPago = new javax.swing.JLabel();
        BotonRealizarPago = new javax.swing.JButton();
        BotonLimpiar = new javax.swing.JButton();
        BotonCerrar = new javax.swing.JButton();
        LabelSerialEquipo = new javax.swing.JLabel();
        CampoSerialEquipo = new javax.swing.JTextField();
        LabelMotivoDeuda = new javax.swing.JLabel();
        CampoMotivoDeuda = new javax.swing.JTextField();
        CampoIdDeuda = new javax.swing.JTextField();

        setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Cancelar Pago de Equipo");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Motivo de Pago:");

        CampoMotivo.setColumns(20);
        CampoMotivo.setRows(5);
        CampoMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CampoMotivoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(CampoMotivo);

        LabelTitular.setText("Títular de Pago:");

        CampoTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoTitularActionPerformed(evt);
            }
        });
        CampoTitular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CampoTitularKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoTitularKeyTyped(evt);
            }
        });

        LabelDeuda.setText("Monto Deuda:");

        CampoDeuda.setEditable(false);
        CampoDeuda.setText(TablaDeudasDelEquipo.getValueAt(TablaDeudasDelEquipo.getSelectedRow(),2).toString());
        CampoDeuda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CampoDeudaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoDeudaKeyTyped(evt);
            }
        });

        CampoPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CampoPagoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoPagoKeyTyped(evt);
            }
        });

        LabelPago.setText("Pago a Efectuar:");

        BotonRealizarPago.setEnabled(false);
        BotonRealizarPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/RealizarPago230x30.png"))); // NOI18N
        BotonRealizarPago.setText("Realizar Pago");
        BotonRealizarPago.setBorder(null);
        BotonRealizarPago.setBorderPainted(false);
        BotonRealizarPago.setContentAreaFilled(false);
        BotonRealizarPago.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonRealizarPago.setIconTextGap(-2);
        BotonRealizarPago.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/RealizarPago240x40.png"))); // NOI18N
        BotonRealizarPago.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonRealizarPago.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonRealizarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRealizarPagoActionPerformed(evt);
            }
        });

        BotonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/limpiar30x30.png"))); // NOI18N
        BotonLimpiar.setText("Limpiar Campos");
        BotonLimpiar.setBorder(null);
        BotonLimpiar.setBorderPainted(false);
        BotonLimpiar.setContentAreaFilled(false);
        BotonLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonLimpiar.setIconTextGap(-2);
        BotonLimpiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/limpiar40x40.png"))); // NOI18N
        BotonLimpiar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonLimpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLimpiarActionPerformed(evt);
            }
        });

        BotonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 30x30.png"))); // NOI18N
        BotonCerrar.setText("Salir");
        BotonCerrar.setBorder(null);
        BotonCerrar.setBorderPainted(false);
        BotonCerrar.setContentAreaFilled(false);
        BotonCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonCerrar.setIconTextGap(-2);
        BotonCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 40x40.png"))); // NOI18N
        BotonCerrar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarActionPerformed(evt);
            }
        });

        LabelSerialEquipo.setText("Serial del Equipo:");

        CampoSerialEquipo.setEditable(false);
        CampoSerialEquipo.setText(TablaDeudasDelEquipo.getValueAt(TablaDeudasDelEquipo.getSelectedRow(),0).toString());
        CampoSerialEquipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoSerialEquipoKeyTyped(evt);
            }
        });

        LabelMotivoDeuda.setText("Motivo Deuda:");

        CampoMotivoDeuda.setEditable(false);
        CampoMotivoDeuda.setText(TablaDeudasDelEquipo.getValueAt(TablaDeudasDelEquipo.getSelectedRow(),3).toString());
        CampoMotivoDeuda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoMotivoDeudaKeyTyped(evt);
            }
        });

        CampoIdDeuda.setText(TablaDeudasDelEquipo.getValueAt(TablaDeudasDelEquipo.getSelectedRow(),4).toString());
        CampoIdDeuda.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(BotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CampoIdDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(LabelMotivoDeuda)
                                .addComponent(LabelDeuda)
                                .addComponent(LabelTitular)
                                .addComponent(LabelPago))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CampoDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CampoMotivoDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CampoTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CampoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LabelSerialEquipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoSerialEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(BotonRealizarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(BotonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(CampoIdDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(49, 49, 49))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CampoSerialEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LabelSerialEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(7, 7, 7)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CampoDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LabelDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CampoMotivoDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LabelMotivoDeuda))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LabelTitular)
                                        .addComponent(CampoTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CampoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LabelPago)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(BotonRealizarPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BotonLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))))))
                    .addComponent(BotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CampoTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoTitularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoTitularActionPerformed

    private void BotonRealizarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRealizarPagoActionPerformed
    
//Fecha y Hora del Pago
    Calendar fecha = new GregorianCalendar();
    
    int año = fecha.get(Calendar.YEAR);
    int mes = fecha.get(Calendar.MONTH);
    int dia = fecha.get(Calendar.DAY_OF_MONTH);
    int M   = fecha.get(Calendar.AM_PM);
    String AmPm;
        if(M==0){
            AmPm="AM";
        }
        else{
            AmPm="PM";
        }
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    String FechaPago=año+"/"+(mes+1)+"/"+dia;
    String Hora=sdf.format(fecha.getTime()); 
    String HoraPago=Hora+" "+AmPm;

    //Aqui empieza el procesamiento de los demás datos para registrar pagos.
    String SerialClub="";
    String SerialDelEquipo=this.CampoSerialEquipo.getText();
    try{
    
    String SQL20="SELECT id_club FROM Equipo WHERE id_equipo='"+SerialDelEquipo+"'";
    Conexion parametros = new Conexion();
    Class.forName(parametros.getDriver());
    Connection con20=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
    Statement st20=con20.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    ResultSet rs20=st20.executeQuery(SQL20);
    if(rs20.next()){
         SerialClub=rs20.getString(1);  
    }
   }catch(SQLException ex){
            Logger.getLogger(AgregarPago.class.getName()).log(Level.SEVERE,null,ex);
        }catch(ClassNotFoundException e){
            Logger.getLogger(AgregarPago.class.getName()).log(Level.SEVERE,null,e);
        }
        
         
int Opcion=JOptionPane.showConfirmDialog(null,"¿Está seguro que desea realizar el pago con los datos introducidos?","Información",JOptionPane.YES_NO_OPTION);
 
if(Opcion==0){

float CantidadDeuda=Float.parseFloat(this.CampoDeuda.getText());
float PagoEfectuar=Float.parseFloat(this.CampoPago.getText()); 

if(PagoEfectuar > CantidadDeuda){
JOptionPane.showMessageDialog(this,"El Pago a Efectuar No Puede Ser Mayor a la Deuda a Cancelar","Información",JOptionPane.INFORMATION_MESSAGE);
}
else{
        try{
    String id_pagos="";
    String query="SELECT MAX(CAST(id_pago AS SIGNED)) FROM pagos";
    Conexion parametros = new Conexion();
    Class.forName(parametros.getDriver());
    Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
    Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    ResultSet rs=st.executeQuery(query);
    if(rs.next()){
         id_pagos=rs.getString(1);  
    }
    if(id_pagos==null){
         id_pagos="1";
         try{
             
       int id_pago=Integer.parseInt(id_pagos);
       
       String Id_Deuda=this.CampoIdDeuda.getText();
             
       String SerialEquipo=this.CampoSerialEquipo.getText();
       
       float MontoDeudaRestante=Float.parseFloat(this.CampoDeuda.getText());
       
       String NombreTitular=this.CampoTitular.getText();
       
       float PagoEfectuado=Float.parseFloat(this.CampoPago.getText());
       
       String MotivoPago=this.CampoMotivo.getText();
       
       
             DatosPagosEquipos user = new DatosPagosEquipos(id_pago, FechaPago, HoraPago, NombreTitular, MotivoPago, MontoDeudaRestante, PagoEfectuado, SerialEquipo, SerialClub);
             
             InsertarPagosEquipos in = new InsertarPagosEquipos();
             
             boolean r;
             r=in.InsertarBdD(user);
             
             if(r==false){
                String query2="UPDATE Deuda SET Monto_Deuda_Restante=Monto_Deuda_Restante-'"+PagoEfectuado+"' WHERE id_Equipo = '"+SerialEquipo+"' and id_deuda='"+Id_Deuda+"'";
                Conexion parametros2 = new Conexion();
                Class.forName(parametros2.getDriver());
                Connection con2=DriverManager.getConnection(parametros2.getURL(), parametros2.getUsuario(), parametros2.getPass());
                Statement st2=con2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                st2.executeUpdate(query2);
                
                 JOptionPane.showMessageDialog(this,"Pago de Equipo Registrado Exitosamente","Guardado",JOptionPane.INFORMATION_MESSAGE);
                 VerClub.PanelDeudasEquipos.remove(VerDeudasDelEquipo);
                 VerClub.PanelDeudasEquipos.remove(this);
                 VerDeudasDelEquipo();
                 
                 
                 
                 
                 
             }
         }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }catch(ClassNotFoundException e){
                Logger.getLogger(AgregarPago.class.getName()).log(Level.SEVERE,null,e);
            }
    }
    else{
       try{
             
       int id_pago=Integer.parseInt(id_pagos);
       id_pago=id_pago+1;
       String Id_Deuda=this.CampoIdDeuda.getText();
             
       String SerialEquipo=this.CampoSerialEquipo.getText();
       
       float MontoDeuda=Float.parseFloat(this.CampoDeuda.getText());
       
       String NombreTitular=this.CampoTitular.getText();
       
       float PagoEfectuado=Float.parseFloat(this.CampoPago.getText());
       
       String MotivoPago=this.CampoMotivo.getText();
       
       
             DatosPagosEquipos user = new DatosPagosEquipos(id_pago, FechaPago, HoraPago, NombreTitular, MotivoPago, MontoDeuda, PagoEfectuado, SerialEquipo, SerialClub);
             
             InsertarPagosEquipos in = new InsertarPagosEquipos();
             
             boolean r;
             r=in.InsertarBdD(user);
             
             if(r==false){
                String query2="UPDATE Deuda SET Monto_Deuda_Restante=Monto_Deuda_Restante-'"+PagoEfectuado+"' WHERE id_Equipo = '"+SerialEquipo+"' and id_deuda='"+Id_Deuda+"'";
                Conexion parametros2 = new Conexion();
                Class.forName(parametros2.getDriver());
                Connection con2=DriverManager.getConnection(parametros2.getURL(), parametros2.getUsuario(), parametros2.getPass());
                Statement st2=con2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                st2.executeUpdate(query2);
                
                 JOptionPane.showMessageDialog(this,"Pago de Equipo Registrado Exitosamente","Guardado",JOptionPane.INFORMATION_MESSAGE);
                 VerClub.PanelDeudasEquipos.remove(VerDeudasDelEquipo);
                 VerClub.PanelDeudasEquipos.remove(this);
                 VerDeudasDelEquipo();
                 
                 
                 
                 
                 
                 
             }
         }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }catch(ClassNotFoundException e){
                Logger.getLogger(AgregarPago.class.getName()).log(Level.SEVERE,null,e);
            }
    
    }
    
   
}catch(SQLException ex){
            Logger.getLogger(AgregarPago.class.getName()).log(Level.SEVERE,null,ex);
        }catch(ClassNotFoundException e){
            Logger.getLogger(AgregarPago.class.getName()).log(Level.SEVERE,null,e);
        }

}   
}
    }//GEN-LAST:event_BotonRealizarPagoActionPerformed

    private void CampoTitularKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoTitularKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_CampoTitularKeyReleased

    private void CampoPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoPagoKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_CampoPagoKeyReleased

    private void CampoMotivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoMotivoKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_CampoMotivoKeyReleased

    private void BotonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLimpiarActionPerformed
        this.CampoTitular.setText("");
        this.CampoPago.setText("");
        this.CampoMotivo.setText("");
        this.CampoTitular.requestFocus();
    }//GEN-LAST:event_BotonLimpiarActionPerformed

    private void CampoTitularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoTitularKeyTyped
                   int Limite=50;
    char K;
    K=evt.getKeyChar();
    if (CampoTitular.getText().length()== Limite){
     evt.consume();
    }
    if(!(K<'0'|| K>'9')){
     evt.consume();
    
    }        // TODO add your handling code here:
    }//GEN-LAST:event_CampoTitularKeyTyped

    private void CampoDeudaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoDeudaKeyReleased
        this.HabilitarGuardar();
    }//GEN-LAST:event_CampoDeudaKeyReleased

    private void BotonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarActionPerformed
    VerClub.PanelDeudasEquipos.remove(this);
    VerClub.PanelDeudasEquipos.remove(VerDeudasDelEquipo);
    VerDeudasDelEquipo();
    }//GEN-LAST:event_BotonCerrarActionPerformed

    private void CampoPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoPagoKeyTyped
               int Limite=50;
    char K;
    K=evt.getKeyChar();
    if (CampoPago.getText().length()== Limite){
     evt.consume();
    }
    if(K<'0'|| K>'9'){
     evt.consume();
    }
    }//GEN-LAST:event_CampoPagoKeyTyped

    private void CampoSerialEquipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoSerialEquipoKeyTyped
                   int Limite=50;
    char K;
    K=evt.getKeyChar();
    if (CampoSerialEquipo.getText().length()== Limite){
     evt.consume();
    }
    if(K<'0'|| K>'9'){
     evt.consume();
    }
    }//GEN-LAST:event_CampoSerialEquipoKeyTyped

    private void CampoDeudaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoDeudaKeyTyped
                   int Limite=50;
    char K;
    K=evt.getKeyChar();
    if (CampoDeuda.getText().length()== Limite){
     evt.consume();
    }
    if(K<'0'|| K>'9'){
     evt.consume();
    }
    }//GEN-LAST:event_CampoDeudaKeyTyped

    private void CampoMotivoDeudaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoMotivoDeudaKeyTyped
                   int Limite=50;
    char K;
    K=evt.getKeyChar();
    if (CampoMotivoDeuda.getText().length()== Limite){
     evt.consume();
    }
    if(!(K<'0'|| K>'9')){
     evt.consume();
    }
    }//GEN-LAST:event_CampoMotivoDeudaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCerrar;
    private javax.swing.JButton BotonLimpiar;
    private javax.swing.JButton BotonRealizarPago;
    private javax.swing.JTextField CampoDeuda;
    private javax.swing.JTextField CampoIdDeuda;
    private javax.swing.JTextArea CampoMotivo;
    private javax.swing.JTextField CampoMotivoDeuda;
    private javax.swing.JTextField CampoPago;
    private javax.swing.JTextField CampoSerialEquipo;
    private javax.swing.JTextField CampoTitular;
    private javax.swing.JLabel LabelDeuda;
    private javax.swing.JLabel LabelMotivoDeuda;
    private javax.swing.JLabel LabelPago;
    private javax.swing.JLabel LabelSerialEquipo;
    private javax.swing.JLabel LabelTitular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

 
}
