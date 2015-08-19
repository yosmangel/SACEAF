/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sanciones;

import Basededatos.Conexion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.DefaultComboBoxModel;


public final class VerSanciones extends javax.swing.JPanel {

    static DefaultTableModel Modelo;
     DefaultComboBoxModel cEquipo= new DefaultComboBoxModel();
      DefaultComboBoxModel cJugador= new DefaultComboBoxModel();
    static DefaultTableModel MEquipo=new DefaultTableModel();
    static DefaultTableModel MJugador=new DefaultTableModel();
    
    public VerSanciones() {
        initComponents();
        MostrarSanciones();
        comboEquipo();
        
        
    }
    
      public void comboEquipo(){
        ComboCategoria.removeAllItems();
        try{
            Conexion parametros =new Conexion();
            Class.forName(parametros.getDriver());
            Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
            Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery("Select nombre_cat from categoria");
            cEquipo.addElement("Elige la categoria");
            ComboCategoria.setModel(cEquipo);                    
            while(rs.next()){
                cEquipo.addElement(rs.getObject("nombre_cat"));
                ComboCategoria.setModel(cEquipo);
            }
            st.close();
            
        }catch(SQLException ex){
            Logger.getLogger(VerSanciones.class.getName()).log(Level.SEVERE,null,ex);
        }catch(ClassNotFoundException e){
            Logger.getLogger(VerSanciones.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    public void comboJugador(){
        
        ComboCategoria.removeAllItems();
        try{
            Conexion parametros= new Conexion();
            Class.forName(parametros.getDriver());
            Connection con= DriverManager.getConnection(parametros.getURL(),parametros.getUsuario(), parametros.getPass());
            Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery("Select nombre_cat from categoria");
            cJugador.addElement("Elige la categoria");
            ComboCategoria.setModel(cJugador);
            while(rs.next()){
                cJugador.addElement(rs.getObject("nombre_cat"));
                ComboCategoria.setModel(cJugador);
            }
            st.close();
        }catch(SQLException ex){
            Logger.getLogger(VerSanciones.class.getName()).log(Level.SEVERE,null,ex);
        }catch(ClassNotFoundException e){
            Logger.getLogger(VerSanciones.class.getName()).log(Level.SEVERE,null,e);
        }
    }
   
    
     public static void MostrarSancionesEquipo(){
        try{
            String[] TitulosColumnas={"Serial","id equipo", "Motivo", "Fechas de Sancion"};
            String[] Columna = new String[4];
            String SQL="Select*from sancion_equipo order by CAST(id_sancion_equipo AS SIGNED) ASC;";
            Conexion parametro = new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            MEquipo = new DefaultTableModel(null,TitulosColumnas);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(SQL);
            while(rs.next()){
               Columna [0]=rs.getString("id_sancion_equipo");
               Columna [1]=rs.getString("id_equipo");
               Columna [2]=rs.getString("motivo_sancion");
               Columna [3]=rs.getString("fechas_sus");
               MEquipo.addRow(Columna);
            }
            TablaSanciones.setModel(MEquipo);
            TablaSanciones.getColumnModel().getColumn(0).setPreferredWidth(100);
            TablaSanciones.getColumnModel().getColumn(1).setPreferredWidth(100);
            TablaSanciones.getColumnModel().getColumn(2).setPreferredWidth(100);
            
            TableRowSorter modeloordenado= new TableRowSorter(MEquipo);
            TablaSanciones.setRowSorter(modeloordenado);
            modeloordenado.setRowFilter(RowFilter.regexFilter(filtro.getText()));
            
        }catch(SQLException ex){
                Logger.getLogger(VerSanciones.class.getName()).log(Level.SEVERE, null, ex);
                }catch(ClassNotFoundException e){
                Logger.getLogger(VerSanciones.class.getName()).log(Level.SEVERE,null,e);
                        }
    }
    public static void MostrarSanciones(){
        try{
            String[] TitulosColumnas={"Serial","Cedula", "Motivo", "Fechas de Sancion"};
            String[] Columna = new String[4];
            String SQL="SELECT*FROM sancion_jugador";
            Conexion parametro = new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            MJugador = new DefaultTableModel(null,TitulosColumnas);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(SQL);
            while(rs.next()){
               Columna [0]=rs.getString("id_sancion_jugador");
               Columna [1]=rs.getString("cedula");
               Columna [2]=rs.getString("motivo_sancion");
               Columna [3]=rs.getString("fechas_sus");
               MJugador.addRow(Columna);
            }
            TablaSanciones.setModel(MJugador);
            TablaSanciones.getColumnModel().getColumn(0).setPreferredWidth(100);
            TablaSanciones.getColumnModel().getColumn(1).setPreferredWidth(100);
            TablaSanciones.getColumnModel().getColumn(2).setPreferredWidth(100);
            TableRowSorter modeloordenado= new TableRowSorter(MJugador);
            TablaSanciones.setRowSorter(modeloordenado);
            modeloordenado.setRowFilter(RowFilter.regexFilter(filtro.getText()));
           
            
            
         
        }catch(SQLException ex){
                Logger.getLogger(VerSanciones.class.getName()).log(Level.SEVERE, null, ex);
                }catch(ClassNotFoundException e){
                Logger.getLogger(VerSanciones.class.getName()).log(Level.SEVERE,null,e);
                        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelSanciones = new javax.swing.JLabel();
        JScrollPane = new javax.swing.JScrollPane();
        TablaSanciones = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }

        };
        filtro = new javax.swing.JTextField();
        ComboCategoria = new javax.swing.JComboBox();
        Equipo = new javax.swing.JRadioButton();
        Jugador = new javax.swing.JRadioButton();

        setOpaque(false);

        LabelSanciones.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LabelSanciones.setText("Sanciones");

        TablaSanciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JScrollPane.setViewportView(TablaSanciones);

        filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroActionPerformed(evt);
            }
        });
        filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtroKeyReleased(evt);
            }
        });

        ComboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ComboCategoriaMouseReleased(evt);
            }
        });
        ComboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCategoriaActionPerformed(evt);
            }
        });

        Equipo.setText("Equipo");
        Equipo.setContentAreaFilled(false);
        Equipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EquipoActionPerformed(evt);
            }
        });

        Jugador.setText("Jugador");
        Jugador.setContentAreaFilled(false);
        Jugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JugadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(LabelSanciones)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(Equipo)
                        .addGap(18, 18, 18)
                        .addComponent(Jugador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
                        .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelSanciones)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Equipo)
                    .addComponent(Jugador)
                    .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroActionPerformed

    private void EquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EquipoActionPerformed
        Equipo.setSelected(true);
        MostrarSancionesEquipo();
        if(Equipo.isSelected()==true){
            Jugador.setSelected(false);
        }

    }//GEN-LAST:event_EquipoActionPerformed

    private void JugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JugadorActionPerformed
        Jugador.setSelected(true);
        MostrarSanciones();
        if(Jugador.isSelected()==true){
            Equipo.setSelected(false);
        }
    }//GEN-LAST:event_JugadorActionPerformed

    @SuppressWarnings("empty-statement")
    private void filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyReleased
         
        if(Jugador.isSelected()==true){
            Equipo.setSelected(false);
        MostrarSanciones();
        }
        else{
           MostrarSancionesEquipo();
                        };
    }//GEN-LAST:event_filtroKeyReleased

    private void ComboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCategoriaActionPerformed
           try{
        if(Jugador.isSelected()== true){
            MostrarSanciones();
        }else
            if(Equipo.isSelected()== true){
                MostrarSancionesEquipo();
            }
       }catch(Exception e){
                
                }
    
    }//GEN-LAST:event_ComboCategoriaActionPerformed

    private void ComboCategoriaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboCategoriaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboCategoriaMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox ComboCategoria;
    public static javax.swing.JRadioButton Equipo;
    private javax.swing.JScrollPane JScrollPane;
    public static javax.swing.JRadioButton Jugador;
    private javax.swing.JLabel LabelSanciones;
    public static javax.swing.JTable TablaSanciones;
    public static javax.swing.JTextField filtro;
    // End of variables declaration//GEN-END:variables
}
