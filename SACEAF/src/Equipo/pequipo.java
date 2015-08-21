
package Equipo;

import Basededatos.equipo.datobloquear;
import Basededatos.equipo.jugador;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import saceaf.Principal;


public final class pequipo extends javax.swing.JPanel {

 
    public pequipo() {
        initComponents();
        mostrarjugadores();
        cargar();
    }

    public void cargar(){
        String nombre=(String) mostrarequipo.tablaequipos.getValueAt(mostrarequipo.tablaequipos.getSelectedRow(),1);
        String identificador=(String) mostrarequipo.tablaequipos.getValueAt(mostrarequipo.tablaequipos.getSelectedRow(),2);
        String categoria= (String) mostrarequipo.tablaequipos.getValueAt(mostrarequipo.tablaequipos.getSelectedRow(),3);       
        String serial= (String) mostrarequipo.tablaequipos.getValueAt(mostrarequipo.tablaequipos.getSelectedRow(),0);       
        pequipo.labelserial.setText(serial);
        pequipo.labelserial.setVisible(false);
        pequipo.labelcategoria.setText(categoria);
        pequipo.nombreequipo.setText(nombre+" "+identificador);
    }
    public static void habilitar(){
        pequipo.bagregar.setEnabled(true);
        pequipo.bbloquear.setEnabled(true);
        pequipo.bmodificar.setEnabled(true);
        pequipo.bsalir.setEnabled(true);
        pequipo.btraspaso.setEnabled(true);
    }
    public static void deshabilitar(){
        pequipo.bagregar.setEnabled(false);
        pequipo.bbloquear.setEnabled(false);
        pequipo.bmodificar.setEnabled(false);
        pequipo.bsalir.setEnabled(false);
        pequipo.btraspaso.setEnabled(false);
        
    }
    public void agregarjugadores(){
        agregarjugador aj=new agregarjugador();
        String titulo="Agregar Jugador";
        int index= paneljugadores.indexOfTab(titulo);
        if(index==-1){
            paneljugadores.addTab(titulo,aj);
            int i=paneljugadores.indexOfTab(titulo);
            paneljugadores.setSelectedIndex(i);
        }else{
            paneljugadores.remove(index);
            paneljugadores.addTab(titulo,aj);
            int i=paneljugadores.indexOfTab(titulo);
            paneljugadores.setSelectedIndex(i);
            
        }
    }
    public void mostrarjugadores(){
        mostrarjugador mj= new mostrarjugador();
        String titulo="";
        int index=paneljugadores.indexOfTab(titulo);
        if(index==-1){
            paneljugadores.addTab(titulo,mj);
            int i=paneljugadores.indexOfTab(titulo);
            paneljugadores.setSelectedIndex(i);
        }else{
            paneljugadores.remove(index);
            paneljugadores.addTab(titulo, mj);
            int i=paneljugadores.indexOfTab(titulo);
            paneljugadores.setSelectedIndex(i);
        }
                
        
    }
    public void bloquearjugador(){
        String serial=   (String) mostrarjugador.tablajugadores.getValueAt(mostrarjugador.tablajugadores.getSelectedRow(),0);
        String nombre=   (String) mostrarjugador.tablajugadores.getValueAt(mostrarjugador.tablajugadores.getSelectedRow(),1);
        String apellido= (String) mostrarjugador.tablajugadores.getValueAt(mostrarjugador.tablajugadores.getSelectedRow(),2);
        String bloquear="Si";
        int opc=JOptionPane.showConfirmDialog(null, "Desea Bloquear al jugador "+nombre+" "+apellido+"?" ,"Informacion" , JOptionPane.YES_NO_OPTION);
        if(opc==0){
            try{
         datobloquear user= new datobloquear(bloquear,serial);
         jugador in= new jugador();
         boolean r;
         r=in.Bloquear(user);
         if(r==false){
             mostrarjugador.cargarjugadores();     
        }
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(pequipo.class.getName()).log(Level.SEVERE,null,ex);
        }
        }
    }
    public void desbloquearjugador(){
        String serial=   (String) mostrarjugador.tablajugadores.getValueAt(mostrarjugador.tablajugadores.getSelectedRow(),0);
        String nombre=   (String) mostrarjugador.tablajugadores.getValueAt(mostrarjugador.tablajugadores.getSelectedRow(),1);
        String apellido= (String) mostrarjugador.tablajugadores.getValueAt(mostrarjugador.tablajugadores.getSelectedRow(),2);
        String bloquear="No";
        int opc=JOptionPane.showConfirmDialog(null, "Desea Desbloquear al jugador "+nombre+" "+apellido+"?" ,"Informacion" , JOptionPane.YES_NO_OPTION);
        if(opc==0){
            try{
         datobloquear user= new datobloquear(bloquear, serial);
         jugador in= new jugador();
         boolean r;
         r=in.Bloquear(user);
         if(r==false){
             mostrarjugador.cargarjugadores();     
        }
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(pequipo.class.getName()).log(Level.SEVERE,null,ex);
        } 
    }
    }
    public void bloqueojugadores(){
        String serial=(String) mostrarjugador.tablajugadores.getValueAt(mostrarjugador.tablajugadores.getSelectedRow(),0);
        String bloqueo=(String) mostrarjugador.tablajugadores.getValueAt(mostrarjugador.tablajugadores.getSelectedRow(),5);
        if(serial !=null){
            if(null != bloqueo) switch(bloqueo){
                case "No":
                    bloquearjugador();
                    break;
                case "Si":
                    desbloquearjugador();
                    break;
            }
        }
    }
    public void modificarjugadores(){
        modificarjugador mj= new modificarjugador();
        String titulo="Modificar jugador";
        int index=paneljugadores.indexOfTab(titulo);
        if(index==-1){
            paneljugadores.addTab(titulo,mj);
            int i=paneljugadores.indexOfTab(titulo);
            paneljugadores.setSelectedIndex(i);
        }else{
            paneljugadores.remove(index);
            paneljugadores.addTab(titulo, mj);
            int i=paneljugadores.indexOfTab(titulo);
            paneljugadores.setSelectedIndex(i);
        }
                
        
    }
    public void traspasojugadores(){
        traspasojugador tj= new traspasojugador();
        String titulo="Traspaso de jugador";
        int index=paneljugadores.indexOfTab(titulo);
        if(index==-1){
            paneljugadores.addTab(titulo,tj);
            int i=paneljugadores.indexOfTab(titulo);
            paneljugadores.setSelectedIndex(i);
        }else{
            paneljugadores.remove(index);
            paneljugadores.addTab(titulo, tj);
            int i=paneljugadores.indexOfTab(titulo);
            paneljugadores.setSelectedIndex(i);
        }
                
        
    }
    public void verificatraspaso(){
        String bloqueo=   (String) mostrarjugador.tablajugadores.getValueAt(mostrarjugador.tablajugadores.getSelectedRow(),5);
        
        if(bloqueo.equals("Si")){
            JOptionPane.showMessageDialog(this,"El jugador se encuentra bloqueado y no puede ser traspasado","Informacion",JOptionPane.INFORMATION_MESSAGE);
        }else{
         traspasojugadores();
         deshabilitar();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        paneljugadores = new javax.swing.JTabbedPane();
        bsalir = new javax.swing.JButton();
        bagregar = new javax.swing.JButton();
        nombreequipo = new javax.swing.JLabel();
        labelcategoria = new javax.swing.JLabel();
        bbloquear = new javax.swing.JButton();
        bmodificar = new javax.swing.JButton();
        labelserial = new javax.swing.JLabel();
        btraspaso = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1000, 412));

        jPanel1.setLayout(null);

        jPanel2.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 412));

        paneljugadores.setPreferredSize(new java.awt.Dimension(849, 311));

        bsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 30x30.png"))); // NOI18N
        bsalir.setText("Salir");
        bsalir.setContentAreaFilled(false);
        bsalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bsalir.setIconTextGap(-2);
        bsalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 40x40.png"))); // NOI18N
        bsalir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bsalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsalirActionPerformed(evt);
            }
        });

        bagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Add 30x30.png"))); // NOI18N
        bagregar.setText("Agregar");
        bagregar.setContentAreaFilled(false);
        bagregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bagregar.setIconTextGap(-2);
        bagregar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Add 40x40.png"))); // NOI18N
        bagregar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bagregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bagregarActionPerformed(evt);
            }
        });

        nombreequipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nombreequipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        bbloquear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/bloquear30x30.png"))); // NOI18N
        bbloquear.setText("Bloquear");
        bbloquear.setContentAreaFilled(false);
        bbloquear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bbloquear.setIconTextGap(-2);
        bbloquear.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/bloquear40x40.png"))); // NOI18N
        bbloquear.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bbloquear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbloquearActionPerformed(evt);
            }
        });

        bmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Edit 30x30.png"))); // NOI18N
        bmodificar.setText("Modificar");
        bmodificar.setContentAreaFilled(false);
        bmodificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bmodificar.setIconTextGap(-2);
        bmodificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Edit 40x40.png"))); // NOI18N
        bmodificar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bmodificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmodificarActionPerformed(evt);
            }
        });

        btraspaso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Traspaso60x60.png"))); // NOI18N
        btraspaso.setText("Traspaso");
        btraspaso.setContentAreaFilled(false);
        btraspaso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btraspaso.setIconTextGap(-2);
        btraspaso.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Traspaso80x80.png"))); // NOI18N
        btraspaso.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btraspaso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btraspaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btraspasoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bagregar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bbloquear, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bmodificar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btraspaso, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelserial))
                            .addComponent(nombreequipo, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(bsalir))
                    .addComponent(paneljugadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(bsalir))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(labelserial, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreequipo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bagregar)
                        .addGap(18, 18, 18)
                        .addComponent(bbloquear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bmodificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btraspaso)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(paneljugadores, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1000, 410);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondos/FondoMedioDifuminado.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 410);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagregarActionPerformed
        agregarjugadores();
        deshabilitar();
    }//GEN-LAST:event_bagregarActionPerformed

    private void bbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbloquearActionPerformed
       try{
     bloqueojugadores();    
      }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Debe seleccionar un jugador del equipo para poder bloquearla","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    
    }//GEN-LAST:event_bbloquearActionPerformed

    private void bmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmodificarActionPerformed
       try{
         modificarjugadores();
         deshabilitar();
      }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Debe seleccionar un jugador del equipo para poder modificarlo","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bmodificarActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        Principal.panelprincipal.remove(this);
        pclub.hablitar();
    }//GEN-LAST:event_bsalirActionPerformed

    private void btraspasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btraspasoActionPerformed
        try{
         verificatraspaso();
       
      }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Debe seleccionar un jugador del equipo para poder traspasarlo a otro equipo","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btraspasoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bagregar;
    public static javax.swing.JButton bbloquear;
    public static javax.swing.JButton bmodificar;
    public static javax.swing.JButton bsalir;
    public static javax.swing.JButton btraspaso;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel labelcategoria;
    public static javax.swing.JLabel labelserial;
    public static javax.swing.JLabel nombreequipo;
    public static javax.swing.JTabbedPane paneljugadores;
    // End of variables declaration//GEN-END:variables
}
