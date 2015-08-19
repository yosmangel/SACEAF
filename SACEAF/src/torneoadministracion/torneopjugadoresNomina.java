/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package torneoadministracion;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import saceaf.Principal;
import torneodatosadm.datoborrart;
import torneodatosadm.datosnominatorneo;
import torneodatosadm.torneocategoria;
import torneodatosadm.torneonomina;

public class torneopjugadoresNomina extends javax.swing.JPanel {

    static DefaultTableModel modelo;


    String idcategoria, idtorneo, idcategoriatorneo;
    String serialtorneo,serialcategoria, serialborrart;
    int ctr;
    public torneopjugadoresNomina() {
        initComponents();
        cargarnumero();
   
    }

public static void cargarnumero(){
   String torneo=Principal.labelserialtorneo.getText();
    try{
        String[] titulos ={"N° de jugadores en nomina"};
        String[] registro= new String[1];
        String sql= "Select numero_j from n_jugadores where id_torneo='"+torneo+"'";
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
        modelo= new DefaultTableModel(null,titulos);
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()){
            registro [0]= rs.getString("numero_j");
            modelo.addRow(registro);
        }
        numeron.setModel(modelo);
        numeron.getColumnModel().getColumn(0).setPreferredWidth(243);
        TableRowSorter modeloordenado=new TableRowSorter(modelo);
        numeron.setRowSorter(modeloordenado);
    }catch(SQLException ex){
        Logger.getLogger(torneopjugadoresNomina.class.getName()).log(Level.SEVERE,null,ex);
    }catch(ClassNotFoundException e){
        Logger.getLogger(torneopjugadoresNomina.class.getName()).log(Level.SEVERE,null,e);
    }
}
public void agregar(){
    int numero=Integer.parseInt(camponumero.getText());
    String torneo= Principal.labelserialtorneo.getText();
    String idnomina= torneo+"1";
    ctr=0;
   try{
         String sql="Select id_njugadores from n_jugadores where id_njugadores='"+idnomina+"';";
         Conexion parametros= new Conexion();
         Class.forName(parametros.getDriver());
         Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
         Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs=st.executeQuery(sql);
         while(rs.first()){
             ctr=2;
             break;
         }
     }catch(SQLException ex){
         Logger.getLogger(torneopjugadoresNomina.class.getName()).log(Level.SEVERE,null,ex);
     }catch(ClassNotFoundException e){
         Logger.getLogger(torneopjugadoresNomina.class.getName()).log(Level.SEVERE,null,e);
     }
   if(ctr==2){
       JOptionPane.showMessageDialog(this,"Ya se registro un numero de jugadores por nomina","Informacion", JOptionPane.INFORMATION_MESSAGE);
   }else{
       try{
           datosnominatorneo user= new datosnominatorneo(idnomina, numero, torneo);
           torneonomina in = new torneonomina();
           boolean r;
           r=in.Insertar(user);
           if(r==false){
               JOptionPane.showMessageDialog(this,"Registro exitoso","Guardado",JOptionPane.INFORMATION_MESSAGE);
             cargarnumero();
           }
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(this,"Error.. "+ex.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException e){
           Logger.getLogger(torneopjugadoresNomina.class.getName()).log(Level.SEVERE,null,e);
       }
   }
 }
public void eliminar(){
    String dato= (String)numeron.getValueAt(numeron.getSelectedRow(),0);
    if(dato!= null){
        serialtorneo=Principal.labelserialtorneo.getText();
        serialborrart= serialtorneo+"1";
        try{
            datoborrart user = new datoborrart(serialborrart);
            torneonomina in = new torneonomina();
            boolean r;
            r=in.Eliminar(user);
            if(r==false){
                JOptionPane.showMessageDialog(this,"Registro eliminado","Eliminado",JOptionPane.INFORMATION_MESSAGE);
                cargarnumero();
            }
        }catch(SQLException ex){
            Logger.getLogger(torneopjugadoresNomina.class.getName()).log(Level.SEVERE,null,ex);
        }catch(ClassNotFoundException e){
            Logger.getLogger(torneopjugadoresNomina.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bagregar = new javax.swing.JButton();
        beliminar = new javax.swing.JButton();
        bsalir = new javax.swing.JButton();
        camponumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        numeron = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }

        };

        setMinimumSize(new java.awt.Dimension(630, 290));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(630, 290));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("N° de jugadores en Nómina");

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

        beliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Delete 30x30.png"))); // NOI18N
        beliminar.setText("Eliminar");
        beliminar.setContentAreaFilled(false);
        beliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        beliminar.setIconTextGap(-2);
        beliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Delete 40x40.png"))); // NOI18N
        beliminar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        beliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        beliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beliminarActionPerformed(evt);
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

        jLabel2.setText("N° de jugadores");

        numeron.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        numeron.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(numeron);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(camponumero, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(beliminar)
                    .addComponent(bagregar)
                    .addComponent(bsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(162, 162, 162))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bagregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(beliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bsalir)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(camponumero, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

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

    private void bagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagregarActionPerformed
        
          try{
          agregar();
      }catch(Exception e){
          JOptionPane.showMessageDialog(this,"Debe llenar el campo para poder agregar un registro","Informacion", JOptionPane.INFORMATION_MESSAGE);
      }
    }//GEN-LAST:event_bagregarActionPerformed

    private void beliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliminarActionPerformed
      try{
          eliminar();
      }catch(Exception e){
          JOptionPane.showMessageDialog(this,"Debe seleccionar algun registro en la tabla para poder eliminar","Informacion", JOptionPane.INFORMATION_MESSAGE);
      }
      
    }//GEN-LAST:event_beliminarActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
     torneogadministracion.paneltadministracion.remove(this);
     torneogadministracion.habilitar();
    }//GEN-LAST:event_bsalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bagregar;
    public static javax.swing.JButton beliminar;
    public static javax.swing.JButton bsalir;
    public static javax.swing.JTextField camponumero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable numeron;
    // End of variables declaration//GEN-END:variables
}
