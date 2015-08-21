
package Equipo;

import Basededatos.Conexion;
import Basededatos.equipo.jugador;
import Basededatos.equipo.traspaso;
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


public final class traspasojugador extends javax.swing.JPanel {

    static DefaultTableModel receptor=new DefaultTableModel();
    String nombre, apellido, cedula, fecha,equipo_actual,id_traspaso,equiporeceptor,categoria,id_categoria,idequipoactual,idequiporeceptor,identificador;
    static String idcategoria;
    
    
    public traspasojugador() {
        initComponents();
        traspasojugador.labelserialactual.setVisible(false);
        cargardatos();
        cargarequipos();
        traspasojugador.bguardar.setEnabled(true);
    }

  
    public void cargardatos(){
        cedula=(String)mostrarjugador.tablajugadores.getValueAt(mostrarjugador.tablajugadores.getSelectedRow(), 0);
        nombre=(String)mostrarjugador.tablajugadores.getValueAt(mostrarjugador.tablajugadores.getSelectedRow(), 1);
        apellido=(String)mostrarjugador.tablajugadores.getValueAt(mostrarjugador.tablajugadores.getSelectedRow(), 2);
        
         try{
           String sql="Select id_equipo from jugador where cedula='"+cedula+"'";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
               idequipoactual=rs.getString("id_equipo");
               break;
          } 
       }catch(SQLException | ClassNotFoundException ex){
           Logger.getLogger(traspasojugador.class.getName()).log(Level.SEVERE,null,ex);
       }
         
         try{
           String sql="Select c.nombre_club, e.identificador from club c, equipo e where e.id_equipo='"+idequipoactual+"' and e.id_club=c.id_club;";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
               equipo_actual=rs.getString("c.nombre_club");
               identificador=rs.getString("e.identificador");
               break;
          } 
       }catch(SQLException | ClassNotFoundException ex){
           Logger.getLogger(traspasojugador.class.getName()).log(Level.SEVERE,null,ex);
       }
         traspasojugador.campocedula.setText(cedula);
         traspasojugador.camponombre.setText(nombre);
         traspasojugador.campoapellido.setText(apellido);
         traspasojugador.equipoactual.setText(equipo_actual+" "+identificador);
         traspasojugador.labelserialactual.setText(idequipoactual);
    }
    public static void cargarequipos(){

        String nseriale=pequipo.labelserial.getText();
        try{
           String sql="Select id_categoria from equipo where id_equipo='"+nseriale+"'";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
               idcategoria=rs.getString("id_categoria");
               break;
          } 
       }catch(SQLException | ClassNotFoundException ex){
           Logger.getLogger(traspasojugador.class.getName()).log(Level.SEVERE,null,ex);
       }
        try{
            String[] titulos= {"Nombre"," "};
            String[] registros= new String[2];
            String sql="Select c.nombre_club, e.identificador from club c, equipo e where e.id_club=c.id_club and e.id_categoria='"+idcategoria+"';";
            Conexion parametros=new Conexion();
            Class.forName(parametros.getDriver());
            Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
            receptor = new DefaultTableModel(null,titulos);
            Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                registros [0]=rs.getString("c.nombre_club");
                registros [1]=rs.getString("e.identificador");
                receptor.addRow(registros);
            }
            traspasojugador.tablareceptor.setModel(receptor);
            traspasojugador.tablareceptor.getColumnModel().getColumn(0).setPreferredWidth(138);
            traspasojugador.tablareceptor.getColumnModel().getColumn(1).setPreferredWidth(140);
            TableRowSorter modeloordenado= new TableRowSorter(receptor);
            traspasojugador.tablareceptor.setRowSorter(modeloordenado);
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(traspasojugador.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    public void guardar(){
        cedula= traspasojugador.campocedula.getText();
        fecha=Principal.labelfecha.getText();
        idequipoactual=traspasojugador.labelserialactual.getText();
        equiporeceptor=(String)tablareceptor.getValueAt(tablareceptor.getSelectedRow(),0);
        identificador=(String)tablareceptor.getValueAt(tablareceptor.getSelectedRow(),1);
        try{
            String sql="Select e.id_equipo from club c, equipo e where e.id_club=c.id_club and e.identificador='"+identificador+"' and c.nombre_club='"+equiporeceptor+"';";
            Conexion parametros= new Conexion();
            Class.forName(parametros.getDriver());
            Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
            Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
                idequiporeceptor=rs.getString("e.id_equipo");
                break;
            }
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(traspasojugador.class.getName()).log(Level.SEVERE,null,ex);
        }
        id_traspaso=cedula+idequiporeceptor;
        if(idequipoactual.equals(idequiporeceptor)){
            JOptionPane.showMessageDialog(this,"Esta seleccionando el equipo donde ya esta el jugador, por favor seleccione otro.","Informacion",JOptionPane.INFORMATION_MESSAGE);
        }else{
        try{
            traspaso user=new traspaso(id_traspaso,cedula,idequipoactual,idequiporeceptor,fecha);
            jugador in =new jugador();
            boolean r;
            r=in.Traspaso(user);
            if(r==false){
                JOptionPane.showMessageDialog(this,"Traspaso realizado","Guardado",JOptionPane.INFORMATION_MESSAGE);
                mostrarjugador.cargarjugadores();
                pequipo.paneljugadores.remove(this);
                pequipo.habilitar();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(traspasojugador.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campocedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        camponombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bguardar = new javax.swing.JButton();
        bsalir = new javax.swing.JButton();
        campoapellido = new javax.swing.JTextField();
        equipoactual = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelserialactual = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablareceptor = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(850, 305));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(850, 305));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Traspaso de Jugador");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(340, 0, 165, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cedula");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 30, 56, 30);

        campocedula.setEditable(false);
        campocedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campocedulaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campocedulaKeyTyped(evt);
            }
        });
        jPanel1.add(campocedula);
        campocedula.setBounds(90, 30, 143, 32);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombres");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(280, 30, 51, 31);

        camponombre.setEditable(false);
        camponombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                camponombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camponombreKeyTyped(evt);
            }
        });
        jPanel1.add(camponombre);
        camponombre.setBounds(340, 30, 171, 31);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Apellidos");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(540, 30, 52, 32);

        bguardar.setEnabled(false);
        bguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/guardar30x30.png"))); // NOI18N
        bguardar.setText("Guardar");
        bguardar.setContentAreaFilled(false);
        bguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bguardar.setIconTextGap(-2);
        bguardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/guardar40x40.png"))); // NOI18N
        bguardar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bguardarActionPerformed(evt);
            }
        });
        jPanel1.add(bguardar);
        bguardar.setBounds(390, 210, 90, 60);

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
        jPanel1.add(bsalir);
        bsalir.setBounds(780, 0, 70, 51);

        campoapellido.setEditable(false);
        jPanel1.add(campoapellido);
        campoapellido.setBounds(600, 30, 179, 33);

        equipoactual.setEditable(false);
        jPanel1.add(equipoactual);
        equipoactual.setBounds(200, 110, 220, 31);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Equipo actual");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(110, 110, 90, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Equipo receptor");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(580, 70, 98, 30);
        jPanel1.add(labelserialactual);
        labelserialactual.setBounds(30, 210, 0, 0);

        tablareceptor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablareceptor);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(490, 100, 280, 100);

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

    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        try{
            guardar();
        }catch(Exception e){
        JOptionPane.showMessageDialog(this,"Debe seleccionar algun equipo al cual quiere traspasar el jugador","Informacion",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_bguardarActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        pequipo.paneljugadores.remove(this);
        pequipo.habilitar();
    }//GEN-LAST:event_bsalirActionPerformed

    private void campocedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campocedulaKeyTyped
        int Limite=8;
        char K;
        K=evt.getKeyChar();
        if (traspasojugador.campocedula.getText().length()== Limite){
         evt.consume();
        }
        if(K<'0'|| K>'9'){
         evt.consume();
        }
    }//GEN-LAST:event_campocedulaKeyTyped

    private void camponombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camponombreKeyTyped
        int Limite=50;
        char K;
        K=evt.getKeyChar();
        if (traspasojugador.camponombre.getText().length()== Limite){
         evt.consume();
        }
        if(!(K<'0'|| K>'9')){
         evt.consume();
        }
    }//GEN-LAST:event_camponombreKeyTyped

    private void campocedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campocedulaKeyReleased
       
    }//GEN-LAST:event_campocedulaKeyReleased

    private void camponombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camponombreKeyReleased
       
    }//GEN-LAST:event_camponombreKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bguardar;
    public static javax.swing.JButton bsalir;
    public static javax.swing.JTextField campoapellido;
    public static javax.swing.JTextField campocedula;
    public static javax.swing.JTextField camponombre;
    public static javax.swing.JTextField equipoactual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel labelserialactual;
    public static javax.swing.JTable tablareceptor;
    // End of variables declaration//GEN-END:variables
}
