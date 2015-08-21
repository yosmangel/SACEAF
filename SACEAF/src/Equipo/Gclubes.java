package Equipo;

import Basededatos.equipo.club;
import Basededatos.equipo.datobloquear;
import Basededatos.equipo.equipo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import saceaf.Principal;

public final class Gclubes extends javax.swing.JPanel {

   
    public Gclubes() {
        initComponents();
        mostrarclub();
    }

    
    public void abrirclub() {
       String nombre=(String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),1);
       pclub pb= new pclub();
       String titulo=""+nombre+"";
       int index= Principal.panelprincipal.indexOfTab(titulo);
       if(index==-1){
           Principal.panelprincipal.addTab(titulo, pb);
           int i=Principal.panelprincipal.indexOfTab(titulo);
           Principal.panelprincipal.setSelectedIndex(i);
       }else{
           Principal.panelprincipal.remove(index);
           Principal.panelprincipal.addTab(titulo, pb);
           int i=Principal.panelprincipal.indexOfTab(titulo);
           Principal.panelprincipal.setSelectedIndex(i);
       }
    }
    public void agregarequipo(){
    agregarequipo ac=new agregarequipo();
    String titulo= "Agregar Equipo";
    int index= panelclub.indexOfTab(titulo);
    if(index==-1){
        panelclub.addTab(titulo,ac);
        int i= panelclub.indexOfTab(titulo);
        panelclub.setSelectedIndex(i);
    }else{
        panelclub.remove(index);
        panelclub.addTab(titulo, ac);
        int i= panelclub.indexOfTab(titulo);
        panelclub.setSelectedIndex(i);        
    }
    }
    public void bloquearc(){
        String serial= (String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),0);
        String nombre= (String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),1);
        String bloquear="Si";
        int opc=JOptionPane.showConfirmDialog(null, "Desea bloquear el club "+nombre+"?", "Informacion", JOptionPane.YES_NO_OPTION);
        if(opc==0){
            try{
                datobloquear user= new datobloquear(bloquear, serial);
                club in= new club();
                boolean r;
                r=in.Bloquear(user);
                if(r==false){
                   pmostrar.cargarclubes();
                }
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(Gclubes.class.getName()).log(Level.SEVERE,null,ex);
        }
        }
        
    }
    public void desbloquearc(){
        String serial= (String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),0);
        String nombre= (String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),1);
        String bloquear="No";
        int opc=JOptionPane.showConfirmDialog(null, "Desea Desbloquear el club "+nombre+"?", "Informacion", JOptionPane.YES_NO_OPTION);
        if(opc==0){
            try{
                datobloquear user= new datobloquear(bloquear, serial);
                club in= new club();
                boolean r;
                r=in.Desbloquear(user);
                if(r==false){
                   pmostrar.cargarclubes();
                }
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(Gclubes.class.getName()).log(Level.SEVERE,null,ex);
        }
        }
        
    }
    public void bloquearclub(){

        String bloqueo= (String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),4);
        if(null != bloqueo)switch (bloqueo) {
            case "No":
                bloquearc();
                break;
            case "Si":
                desbloquearc();
                break;
        }
        
        
    }
    public void bloqueare(){
        String serial= (String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),0);
        String nombre= (String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),1);
        String bloquear="Si";
        int opc=JOptionPane.showConfirmDialog(null, "Desea bloquear el equipo del club "+nombre+"?", "Informacion", JOptionPane.YES_NO_OPTION);
        if(opc==0){
            try{
                datobloquear user= new datobloquear(bloquear, serial);
                equipo in= new equipo();
                boolean r;
                r=in.Bloquear(user);
                if(r==false){
                if(pmostrar.rmasculino.isSelected()==true){
                   pmostrar.equiposmasculinos();
                }else
                if(pmostrar.rfemenino.isSelected()==true){
                   pmostrar.equiposfemenino(); 
                }
                }
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(Gclubes.class.getName()).log(Level.SEVERE,null,ex);
        }
        }
    }
    public void desbloqueare(){
        String serial= (String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),0);
        String nombre= (String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),1);
        String bloquear="No";
        int opc=JOptionPane.showConfirmDialog(null, "Desea Desbloquear el equipo del club "+nombre+"?", "Informacion", JOptionPane.YES_NO_OPTION);
        if(opc==0){
            try{
                datobloquear user= new datobloquear(bloquear, serial);
                equipo in= new equipo();
                boolean r;
                r=in.Desbloquear(user);
                if(r==false){
                   if(pmostrar.rmasculino.isSelected()==true){
                   pmostrar.equiposmasculinos();
                   }else
                   if(pmostrar.rfemenino.isSelected()==true){
                   pmostrar.equiposfemenino(); 
                   }
                }
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(Gclubes.class.getName()).log(Level.SEVERE,null,ex);
        }
        }
    }
    public void bloquearequipo(){
        String serial= (String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),0);
        String bloqueo= (String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(), 5);
        if(serial !=null){
            if(null != bloqueo)switch (bloqueo) {
                case "No":
                    bloqueare();
                    break;
                case "Si":
                    desbloqueare();
                    break;
            }
        }
    }
    public void mostrarclub(){
        pmostrar pm= new pmostrar();
        String titulo="";
        int index=panelclub.indexOfTab(titulo);
        if(index==-1){
            panelclub.addTab(titulo, pm);
            int i=panelclub.indexOfTab(titulo);
            panelclub.setSelectedIndex(i);
        }else{
            panelclub.remove(index);
            panelclub.addTab(titulo, pm);
            int i=panelclub.indexOfTab(titulo);
            panelclub.setSelectedIndex(i);
        }
    }
    public void agregarclub(){
        
        Agregarclub ac=new Agregarclub();
        String titulo= "Agregar Club";
        int index= panelclub.indexOfTab(titulo);
        if(index==-1){
            panelclub.addTab(titulo,ac);
            int i= panelclub.indexOfTab(titulo);
            panelclub.setSelectedIndex(i);
        }else{
            panelclub.remove(index);
            panelclub.addTab(titulo, ac);
            int i= panelclub.indexOfTab(titulo);
            panelclub.setSelectedIndex(i);        
        }
    }
    public void modificarclub(){
        modificarclub mc= new modificarclub();
        String titulo="Modificar Club";
        int index=panelclub.indexOfTab(titulo);
        if(index==-1){
            panelclub.addTab(titulo, mc);
            int i=panelclub.indexOfTab(titulo);
            panelclub.setSelectedIndex(i);
        }else{
            panelclub.remove(index);
            panelclub.addTab(titulo, mc);
            int i=panelclub.indexOfTab(titulo);
            panelclub.setSelectedIndex(i);
        }
    }
    public static void habilitar(){
        Gclubes.bacceder.setEnabled(true);
        Gclubes.bagregar.setEnabled(true);
        Gclubes.bbloquear.setEnabled(true);
        Gclubes.bmodificar.setEnabled(true);
        Gclubes.bsalir.setEnabled(true);
        pmostrar.tablaclub.setEnabled(true);
        pmostrar.rclubes.setEnabled(true);
        pmostrar.rfemenino.setEnabled(true);
        pmostrar.rmasculino.setEnabled(true);
    }
    public static void deshabilitar(){
        Gclubes.bacceder.setEnabled(false);
        Gclubes.bagregar.setEnabled(false);
        Gclubes.bbloquear.setEnabled(false);
        Gclubes.bmodificar.setEnabled(false);
        Gclubes.bsalir.setEnabled(false);
        pmostrar.tablaclub.setEnabled(false);
        pmostrar.rclubes.setEnabled(false);
        pmostrar.rfemenino.setEnabled(false);
        pmostrar.rmasculino.setEnabled(false);
        pmostrar.combocategoria.setEnabled(false);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelclub = new javax.swing.JTabbedPane();
        jLabel3 = new javax.swing.JLabel();
        bacceder = new javax.swing.JButton();
        bbloquear = new javax.swing.JButton();
        bagregar = new javax.swing.JButton();
        bmodificar = new javax.swing.JButton();
        bsalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1000, 412));

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel1.setLayout(null);

        jPanel2.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Gestionar Clubes");

        bacceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/acceder30x30.png"))); // NOI18N
        bacceder.setText("Acceder");
        bacceder.setContentAreaFilled(false);
        bacceder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bacceder.setIconTextGap(-2);
        bacceder.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/acceder40x40.png"))); // NOI18N
        bacceder.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bacceder.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bacceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baccederActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bacceder, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bbloquear, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bagregar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bmodificar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(panelclub, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bsalir)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(bsalir)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bacceder)
                        .addGap(18, 18, 18)
                        .addComponent(bbloquear)
                        .addGap(18, 18, 18)
                        .addComponent(bagregar)
                        .addGap(18, 18, 18)
                        .addComponent(bmodificar))
                    .addComponent(panelclub, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        Principal.panelprincipal.remove(this);
    }//GEN-LAST:event_bsalirActionPerformed

    private void baccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baccederActionPerformed
     
       try{
        String serial=(String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),0);
       if(serial!=null){
       
            abrirclub();
            deshabilitar();
       }
       }catch(Exception e){
       JOptionPane.showMessageDialog(null,"Debe Seleccionar algun Club para poder acceder","Informacion",JOptionPane.INFORMATION_MESSAGE);
       }
    }//GEN-LAST:event_baccederActionPerformed

    private void bbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbloquearActionPerformed
   try{
       if(pmostrar.rclubes.isSelected()==true){
              bloquearclub();
       }else
            if(pmostrar.rfemenino.isSelected() || pmostrar.rmasculino.isSelected() == true){
              bloquearequipo();
       }
   }catch(Exception e){
       if(pmostrar.rclubes.isSelected()==true){
          JOptionPane.showMessageDialog(this,"Debe seleccionar un Club para poder bloquearlo","Informacion", JOptionPane.INFORMATION_MESSAGE);
       }else
       if(pmostrar.rfemenino.isSelected() || pmostrar.rmasculino.isSelected() == true){
          JOptionPane.showMessageDialog(this,"Debe seleccionar un Equipo para poder bloquearlo","Informacion", JOptionPane.INFORMATION_MESSAGE);
       }
       } 
    }//GEN-LAST:event_bbloquearActionPerformed

    private void bagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagregarActionPerformed

        if(pmostrar.rclubes.isSelected()==true){
        agregarclub();
        deshabilitar();
       }else
        if(pmostrar.rfemenino.isSelected() || pmostrar.rmasculino.isSelected() == true){
        agregarequipo();
        deshabilitar();
       }

    }//GEN-LAST:event_bagregarActionPerformed

    private void bmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmodificarActionPerformed
       try{
       String serial=(String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),0);
       if(serial!=null){
       
            modificarclub();
            deshabilitar();
        }
       }catch(Exception e){
       JOptionPane.showMessageDialog(null,"Debe Seleccionar algun Club para poder modificar","Informacion",JOptionPane.INFORMATION_MESSAGE);
       }
    }//GEN-LAST:event_bmodificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bacceder;
    public static javax.swing.JButton bagregar;
    public static javax.swing.JButton bbloquear;
    public static javax.swing.JButton bmodificar;
    public static javax.swing.JButton bsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JTabbedPane panelclub;
    // End of variables declaration//GEN-END:variables
}
