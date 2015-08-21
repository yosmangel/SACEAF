

package Equipo;

import Basededatos.Conexion;
import Basededatos.equipo.datobloquear;
import Basededatos.equipo.equipo;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import saceaf.Principal;


public final class pclub extends javax.swing.JPanel {

 String imagen, nombreimagen, ruta;
 
    public pclub()  {
        initComponents();
        tomadato();
        mostrarequipos();
    }


    public void tomadato(){

        String nombre=(String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),1);
        nombreclub.setText(nombre);
        String id=(String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),0);
         try{   
           String sql="Select logo_eq from imagenclub where id_club='"+id+"'";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
             
             imagen=rs.getString("logo_eq");
             break;
           }
       }catch(SQLException | ClassNotFoundException ex){
           Logger.getLogger(pclub.class.getName()).log(Level.SEVERE,null,ex);
       }
        
        
        Image preview = Toolkit.getDefaultToolkit().getImage(imagen);
        if(preview != null){
             pclub.labellogo.setText("");
             ImageIcon icon = new ImageIcon(preview.getScaledInstance(pclub.labellogo.getWidth(), pclub.labellogo.getHeight(), Image.SCALE_DEFAULT));
             pclub.labellogo.setIcon(icon);
            }
       
            
        
        

    }
    public void agregarequipo(){
        cagregarequipo cae=new cagregarequipo();
        String titulo="Agregar Equipo";
        int index= panelequipos.indexOfTab(titulo);
        if(index== -1){
            panelequipos.addTab(titulo, cae);
            int i=panelequipos.indexOfTab(titulo);
            panelequipos.setSelectedIndex(i);
        }else{
            panelequipos.remove(index);
            panelequipos.addTab(titulo, cae);
            int i=panelequipos.indexOfTab(titulo);
            panelequipos.setSelectedIndex(i);
            
        }
    }
    public void mostrarequipos(){
        mostrarequipo mp=new mostrarequipo();
        String titulo="Equipos";
        int index= panelequipos.indexOfTab(titulo);
        if(index== -1){
            panelequipos.addTab(titulo, mp);
            int i=panelequipos.indexOfTab(titulo);
            panelequipos.setSelectedIndex(i);
        }else{
            panelequipos.remove(index);
            panelequipos.addTab(titulo, mp);
            int i=panelequipos.indexOfTab(titulo);
            panelequipos.setSelectedIndex(i);
            
        }
    }
    public static void hablitar(){
       pclub.bagregar.setEnabled(true);
       pclub.bacceder.setEnabled(true);
       pclub.bmodificar.setEnabled(true);
       pclub.bsalir.setEnabled(true);
       pclub.bbloquear.setEnabled(true);
       mostrarequipo.rmasculino.setEnabled(true);
       mostrarequipo.rfemenino.setEnabled(true);
       
    }
    public static void deshabilitar(){
       bagregar.setEnabled(false);
       bacceder.setEnabled(false);
       bmodificar.setEnabled(false);
       bsalir.setEnabled(false);
       bbloquear.setEnabled(false);
       mostrarequipo.rmasculino.setEnabled(false);
       mostrarequipo.rfemenino.setEnabled(false);
        
    }
    public void panelequipo(){
        pequipo ae= new pequipo();
        String titulo="";
        int index=Principal.panelprincipal.indexOfTab(titulo);
        if(index==-1){
            Principal.panelprincipal.addTab(titulo, ae);
            int i= Principal.panelprincipal.indexOfTab(titulo);
            Principal.panelprincipal.setSelectedIndex(i);
        }else{
            Principal.panelprincipal.remove(index);
            Principal.panelprincipal.addTab(titulo, ae);
            int i= Principal.panelprincipal.indexOfTab(titulo);
            Principal.panelprincipal.setSelectedIndex(i);
            
        }
        
    }
    public void bloquearequipo(){
        String serial= (String) mostrarequipo.tablaequipos.getValueAt(mostrarequipo.tablaequipos.getSelectedRow(),0);
        String bloqueo= (String) mostrarequipo.tablaequipos.getValueAt(mostrarequipo.tablaequipos.getSelectedRow(), 6);
        if(serial !=null){
            if(null != bloqueo)switch (bloqueo) {
                case "No":
                    bloquear();
                    break;
                case "Si":
                    desbloquear();
                    break;
            }
        }
    }
    public void bloquear(){
        String serial= (String) mostrarequipo.tablaequipos.getValueAt(mostrarequipo.tablaequipos.getSelectedRow(),0);
        String nombre= (String) mostrarequipo.tablaequipos.getValueAt(mostrarequipo.tablaequipos.getSelectedRow(),1);
        String bloquear="Si";
        int opc=JOptionPane.showConfirmDialog(null, "Desea bloquear el equipo del club "+nombre+"?", "Informacion", JOptionPane.YES_NO_OPTION);
        if(opc==0){
            try{
                datobloquear user= new datobloquear(bloquear, serial);
                equipo in= new equipo();
                boolean r;
                r=in.Bloquear(user);
                if(r==false){
                if(mostrarequipo.rmasculino.isSelected()==true){
                   mostrarequipo.equiposmasculinos();
                }else
                if(mostrarequipo.rfemenino.isSelected()==true){
                   mostrarequipo.equiposfemenino(); 
                }
                }
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(pclub.class.getName()).log(Level.SEVERE,null,ex);
        }
        }
    }
    public void desbloquear(){
        String serial= (String) mostrarequipo.tablaequipos.getValueAt(mostrarequipo.tablaequipos.getSelectedRow(),0);
        String nombre= (String) mostrarequipo.tablaequipos.getValueAt(mostrarequipo.tablaequipos.getSelectedRow(),1);
        String bloquear="No";
        int opc=JOptionPane.showConfirmDialog(null, "Desea Desbloquear el equipo del club "+nombre+"?", "Informacion", JOptionPane.YES_NO_OPTION);
        if(opc==0){
            try{
                datobloquear user= new datobloquear(bloquear, serial);
                equipo in= new equipo();
                boolean r;
                r=in.Desbloquear(user);
                if(r==false){
                   if(mostrarequipo.rmasculino.isSelected()==true){
                   mostrarequipo.equiposmasculinos();
                   }else
                   if(mostrarequipo.rfemenino.isSelected()==true){
                   mostrarequipo.equiposfemenino(); 
                   }
                }
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(pclub.class.getName()).log(Level.SEVERE,null,ex);
        }
        }
    }
    public void modificarequipo(){
        modificarequipo mp=new modificarequipo();
        String titulo="Modificar";
        int index= panelequipos.indexOfTab(titulo);
        if(index== -1){
            panelequipos.addTab(titulo, mp);
            int i=panelequipos.indexOfTab(titulo);
            panelequipos.setSelectedIndex(i);
        }else{
            panelequipos.remove(index);
            panelequipos.addTab(titulo, mp);
            int i=panelequipos.indexOfTab(titulo);
            panelequipos.setSelectedIndex(i);
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        labellogo = new javax.swing.JLabel();
        nombreclub = new javax.swing.JLabel();
        bsalir = new javax.swing.JButton();
        bagregar = new javax.swing.JButton();
        bbloquear = new javax.swing.JButton();
        bacceder = new javax.swing.JButton();
        panelequipos = new javax.swing.JTabbedPane();
        bmodificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1000, 412));
        setPreferredSize(new java.awt.Dimension(1000, 412));

        jPanel2.setLayout(null);

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 412));

        labellogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labellogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        nombreclub.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        nombreclub.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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

        panelequipos.setMinimumSize(new java.awt.Dimension(800, 331));
        panelequipos.setPreferredSize(new java.awt.Dimension(800, 331));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labellogo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bacceder)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(bbloquear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bagregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bmodificar)
                        .addGap(59, 59, 59)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nombreclub, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bsalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelequipos, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labellogo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bagregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bbloquear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bacceder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bmodificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreclub, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bsalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(panelequipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 412);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondos/FondoMedioDifuminado.jpg"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 1000, 602);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagregarActionPerformed
      agregarequipo();
      deshabilitar();
    }//GEN-LAST:event_bagregarActionPerformed

    private void bbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbloquearActionPerformed
        
     try{
     bloquearequipo();    
      }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Debe seleccionar una categoria del club para poder bloquearla","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bbloquearActionPerformed

    private void baccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baccederActionPerformed
         try{
        panelequipo();
        deshabilitar(); 
      }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Debe seleccionar una categoria del club para poder acceder","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_baccederActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
    Principal.panelprincipal.remove(this);
    Gclubes.habilitar();
    }//GEN-LAST:event_bsalirActionPerformed

    private void bmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmodificarActionPerformed

       try{
        modificarequipo();
        deshabilitar(); 
      }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Debe seleccionar una categoria del club para poder modificarla","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bmodificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bacceder;
    public static javax.swing.JButton bagregar;
    public static javax.swing.JButton bbloquear;
    public static javax.swing.JButton bmodificar;
    public static javax.swing.JButton bsalir;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel labellogo;
    public static javax.swing.JLabel nombreclub;
    public static javax.swing.JTabbedPane panelequipos;
    // End of variables declaration//GEN-END:variables
}
