

package torneoequipo;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import saceaf.Principal;
import torneodatoseq.actualizarnomina;
import torneodatoseq.borrarjugadort;
import torneodatoseq.datosjugadort;
import torneodatoseq.torneojugador;


public class jugadoresequipot extends javax.swing.JPanel {
    static DefaultTableModel modelo;
    static DefaultTableModel modelo1;
    static String idcategoria, idclub,id_equipo, id_hjugador,id_serialb, cedulaj,id_torneo,equipo,bloqueo,year_final;
    static int ctrl,n_nomina,ctrn,nfinal,ncomienzo,i,limite;
    boolean seleccionException;
            
    public jugadoresequipot() {
        initComponents();
        cargar();
        cargarjugadorestorneo();
        jugadoresequipot.labelserialexce.setVisible(false);

    }
 
 public void cargar(){
     idcategoria=null;
     idclub=null;
     id_equipo=null;
     String categoria= Equipostorneo.combocategorias.getSelectedItem().toString();
     String identificador= (String) Equipostorneo.equipostorneo.getValueAt(Equipostorneo.equipostorneo.getSelectedRow(),1);
     String nombre=(String) Equipostorneo.equipostorneo.getValueAt(Equipostorneo.equipostorneo.getSelectedRow(),0);
     String lsexo=Principal.labelsexo.getText();
     try{
         String sql="Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+lsexo+"';";
         Conexion parametros= new Conexion();
         Class.forName(parametros.getDriver());
         Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
         Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs=st.executeQuery(sql);
         while(rs.first()){
             idcategoria=rs.getString("id_categoria");
             break;
         }
     }catch(SQLException | ClassNotFoundException ex){
         Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE,null,ex);
     }
      try{
         String sql="Select id_club from club where nombre_club='"+nombre+"';";
         Conexion parametros= new Conexion();
         Class.forName(parametros.getDriver());
         Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
         Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs=st.executeQuery(sql);
         while(rs.first()){
             idclub=rs.getString("id_club");
             break;
         }
     }catch(SQLException | ClassNotFoundException ex){
         Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE,null,ex);
     }
            try{
         String sql="Select id_equipo from equipo where id_club='"+idclub+"' and id_categoria='"+idcategoria+"' and identificador='"+identificador+"';";
         Conexion parametros= new Conexion();
         Class.forName(parametros.getDriver());
         Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
         Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs=st.executeQuery(sql);
         while(rs.first()){
             id_equipo=rs.getString("id_equipo");
             break;
         }
     }catch(SQLException | ClassNotFoundException ex){
         Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE,null,ex);
     }
            labelcategoria.setText(idcategoria);
            labelserial.setText(id_equipo);
            labelcategoria.setVisible(false);
            labelserial.setVisible(false);
            labelnombreeq.setText(nombre+" "+identificador);
            cargarjugadorequipo();
 }
 public static void cargarjugadorequipo(){
     
        String equipoc=labelserial.getText();
        try{
            String[] titulos={"Cedula","Nombre","Apellido"};
            String[] registro= new String[3];
            String sql="Select j.cedula, j.nombre_j, j.apellido_j from jugador j where j.id_equipo='"+equipoc+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("j.cedula");
               registro [1]=rs.getString("j.nombre_j");
               registro [2]=rs.getString("j.apellido_j");
               modelo.addRow(registro);
            }
            jugadores.setModel(modelo);
            jugadores.getColumnModel().getColumn(0).setPreferredWidth(144);
            jugadores.getColumnModel().getColumn(1).setPreferredWidth(144);
            jugadores.getColumnModel().getColumn(2).setPreferredWidth(144);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            jugadores.setRowSorter(modeloordenado);
            modeloordenado.setRowFilter(RowFilter.regexFilter(filtro.getText()));
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE, null, ex);
                }
 }
 public static void cargarjugadorestorneo(){

     id_torneo= Principal.labelserialtorneo.getText();
     equipo=id_torneo+labelserial.getText();
     
             try{
            String[] titulos={"N°","Cedula","Nombre","Apellido"};
            String[] registro= new String[4];
            String sql="Select hj.n_nomina ,j.cedula, j.nombre_j, j.apellido_j from jugador j, h_jugador hj where hj.cedula=j.cedula and hj.id_torneo='"+id_torneo+"' and hj.id_equipo='"+equipo+"' order by hj.n_nomina;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo1= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("hj.n_nomina"); 
               registro [1]=rs.getString("j.cedula");
               registro [2]=rs.getString("j.nombre_j");
               registro [3]=rs.getString("j.apellido_j");
               modelo1.addRow(registro);
            }
            jugadorestorneo.setModel(modelo1);
            jugadorestorneo.getColumnModel().getColumn(0).setPreferredWidth(27);
            jugadorestorneo.getColumnModel().getColumn(1).setPreferredWidth(135);
            jugadorestorneo.getColumnModel().getColumn(2).setPreferredWidth(135);
            jugadorestorneo.getColumnModel().getColumn(3).setPreferredWidth(135);
            TableRowSorter modeloordenado= new TableRowSorter(modelo1);
            jugadorestorneo.setRowSorter(modeloordenado);
            modeloordenado.setRowFilter(RowFilter.regexFilter(filtro2.getText()));
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE, null, ex);
                }
        
       
    }
 public void agregarjugador(){
     idcategoria=null;
     id_equipo=null;
     id_hjugador=null;
     ctrl=0;
     id_torneo=null;
     n_nomina=0;
     ctrn=0;
       idcategoria=labelcategoria.getText();
       equipo=labelserial.getText();
       cedulaj=(String) jugadores.getValueAt(jugadores.getSelectedRow(), 0);
       id_torneo= Principal.labelserialtorneo.getText();
       id_hjugador=id_torneo+cedulaj;
       id_equipo=id_torneo+equipo;
       int goles=0;
       int tarjetas_a=0;
       int tarjetas_r=0;
                  try{
         String sql="Select bloqueo_j from jugador where cedula='"+cedulaj+"';";
         Conexion parametros= new Conexion();
         Class.forName(parametros.getDriver());
         Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
         Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs=st.executeQuery(sql);
         while(rs.last()){
             bloqueo=rs.getString("bloqueo_j");
             break;
         }
     }catch(SQLException | ClassNotFoundException ex){
         Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE,null,ex);
     }
                    try{
         String sql="Select hj.n_nomina ,j.cedula, j.nombre_j, j.apellido_j from jugador j, h_jugador hj where hj.cedula=j.cedula and hj.id_torneo='"+id_torneo+"' and hj.id_hequipo='"+id_equipo+"' order by hj.n_nomina;";
         Conexion parametros= new Conexion();
         Class.forName(parametros.getDriver());
         Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
         Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs=st.executeQuery(sql);
         while(rs.last()){
             n_nomina=Integer.parseInt(rs.getString("n_nomina"));
             break;
         }
     }catch(SQLException | ClassNotFoundException ex){
         Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE,null,ex);
     }
                try{
         String sql="Select numero_j from n_jugadores where id_torneo='"+id_torneo+"';";
         Conexion parametros= new Conexion();
         Class.forName(parametros.getDriver());
         Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
         Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs=st.executeQuery(sql);
         while(rs.first()){
             ctrn=Integer.parseInt(rs.getString("numero_j"));
             break;
         }
     }catch(SQLException | ClassNotFoundException ex){
         Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE,null,ex);
     }
       
       n_nomina=n_nomina+1;
       ctrn=ctrn+1;
       try{
         String sql="Select id_hjugador from h_jugador where id_hjugador='"+id_hjugador+"';";
         Conexion parametros= new Conexion();
         Class.forName(parametros.getDriver());
         Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
         Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs=st.executeQuery(sql);
         while(rs.first()){
             ctrl=2;
             break;
         }
     }catch(SQLException | ClassNotFoundException ex){
         Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE,null,ex);
     }
       if(bloqueo.equals("Si")){
           JOptionPane.showMessageDialog(this,"El jugador se encuentra bloqueado, por lo cual no puede agregarlo a ningun torneo","Informacion",JOptionPane.INFORMATION_MESSAGE);
       }else
       if(ctrl==2){
        JOptionPane.showMessageDialog(null,"El jugador ya esta registrado en el torneo","Informacion", JOptionPane.INFORMATION_MESSAGE);
       }else
       if(n_nomina==ctrn){
       JOptionPane.showMessageDialog(null,"Ya Posee el limite de jugadores en nomina en el torneo ","Informacion", JOptionPane.INFORMATION_MESSAGE);
       }else{
       try{
           datosjugadort user= new datosjugadort(id_hjugador, cedulaj, idcategoria, n_nomina, goles, tarjetas_a, tarjetas_r, id_equipo,id_torneo);
          torneojugador in= new torneojugador();
           boolean r;
           r=in.Insertar(user);
           if(r==false){
               JOptionPane.showMessageDialog(null,"Jugador agregado al torneo.", "Informacion",JOptionPane.INFORMATION_MESSAGE);
             cargarjugadorestorneo();
           }
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Error "+ex.getMessage(),"Informacion",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException e){
           Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE,null,e);
       }
       }
 }
 public static void eliminarjugador(){
     ncomienzo=Integer.parseInt((String)jugadorestorneo.getValueAt(jugadorestorneo.getSelectedRow(), 0));
     cedulaj=(String)jugadorestorneo.getValueAt(jugadorestorneo.getSelectedRow(), 1);
     id_torneo=Principal.labelserialtorneo.getText();
     id_hjugador=id_torneo+cedulaj;
     equipo=id_torneo+labelserial.getText();
 
     ctrn=0;
     ctrn=ncomienzo;

     try{
         String sql="Select hj.n_nomina ,j.cedula, j.nombre_j, j.apellido_j from jugador j, h_jugador hj where hj.cedula=j.cedula and hj.id_torneo='"+id_torneo+"' and hj.id_hequipo='"+equipo+"' order by hj.n_nomina;";
         Conexion parametros= new Conexion();
         Class.forName(parametros.getDriver());
         Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
         Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs=st.executeQuery(sql);
         while(rs.last()){
             nfinal=rs.getInt("hj.n_nomina");
             break;
         }
     }catch(SQLException | ClassNotFoundException ex){
         Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE,null,ex);
     }
     try{
         borrarjugadort user= new borrarjugadort(id_hjugador);
         torneojugador in= new torneojugador();
         boolean r;
         r=in.Eliminar(user);
         if(r==false){
             limite=nfinal;
            
             
             while(ctrn<limite){
                 i=ctrn+1;
                 try{
         String sql="Select hj.id_hjugador,j.cedula from jugador j, h_jugador hj where hj.cedula=j.cedula and hj.id_torneo='"+id_torneo+"' and hj.id_hequipo='"+equipo+"' and hj.n_nomina='"+i+"';";
         Conexion parametros= new Conexion();
         Class.forName(parametros.getDriver());
         Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
         Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs=st.executeQuery(sql);
         while(rs.last()){
             id_hjugador=rs.getString("hj.id_hjugador");
             cedulaj=rs.getString("j.cedula");
             break;
         }
     }catch(     SQLException | ClassNotFoundException ex){
         Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE,null,ex);
     }
                 n_nomina=ctrn;
                 try{
         actualizarnomina user1= new actualizarnomina(id_hjugador,n_nomina);
         torneojugador in1= new torneojugador();
         boolean re;
         re=in1.Modificar(user1);
     }catch(SQLException ex2){
           JOptionPane.showMessageDialog(null,"Error "+ex2.getMessage(),"Informacion",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException e2){
           Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE,null,e2);
       }
                 ctrn=ctrn+1;
             }
             cargarjugadorestorneo();
         }
     }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Error "+ex.getMessage(),"Informacion",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException e){
           Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE,null,e);
       }
     
     
 }
 public static void cargarlistaException(){
     String categoria= Equipostorneo.combocategorias.getSelectedItem().toString();
     String identificador= (String) Equipostorneo.equipostorneo.getValueAt(Equipostorneo.equipostorneo.getSelectedRow(),1);
     String nombre=(String) Equipostorneo.equipostorneo.getValueAt(Equipostorneo.equipostorneo.getSelectedRow(),0);
     String lsexo=Principal.labelsexo.getText();
     
     
     try{
         String sql="Select year_ini from categoria where nombre_cat='"+categoria+"' and sexo='"+lsexo+"';";
         Conexion parametros= new Conexion();
         Class.forName(parametros.getDriver());
         Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
         Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs=st.executeQuery(sql);
         while(rs.first()){
             year_final=rs.getString("year_ini");
             break;
         }
     }catch(SQLException | ClassNotFoundException ex){
         Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE,null,ex);
     }
      try{
         String sql="Select MIN(id_categoria) from categoria where year_ini>'"+year_final+"';";
         Conexion parametros= new Conexion();
         Class.forName(parametros.getDriver());
         Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
         Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs=st.executeQuery(sql);
         while(rs.first()){
             idcategoria=rs.getString("MIN(id_categoria)");
             break;
         }
     }catch(SQLException | ClassNotFoundException ex){
         Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE,null,ex);
     }
      try{
         String sql="Select id_club from club where nombre_club='"+nombre+"';";
         Conexion parametros= new Conexion();
         Class.forName(parametros.getDriver());
         Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
         Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs=st.executeQuery(sql);
         while(rs.first()){
             idclub=rs.getString("id_club");
             break;
         }
     }catch(SQLException | ClassNotFoundException ex){
         Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE,null,ex);
     }
            try{
         String sql="Select id_equipo from equipo where id_club='"+idclub+"' and id_categoria='"+idcategoria+"' and identificador='"+identificador+"';";
         Conexion parametros= new Conexion();
         Class.forName(parametros.getDriver());
         Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
         Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs=st.executeQuery(sql);
         while(rs.first()){
             id_equipo=rs.getString("id_equipo");
             break;
         }
     }catch(SQLException | ClassNotFoundException ex){
         Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE,null,ex);
     }
     jugadoresequipot.labelserialexce.setText(id_equipo);
     cargarjugadorequipoException();
 }
 public static void cargarjugadorequipoException(){
     
        String equipoc=jugadoresequipot.labelserialexce.getText();
        try{
            String[] titulos={"Cedula","Nombre","Apellido"};
            String[] registro= new String[3];
            String sql="Select j.cedula, j.nombre_j, j.apellido_j from jugador j where j.id_equipo='"+equipoc+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("j.cedula");
               registro [1]=rs.getString("j.nombre_j");
               registro [2]=rs.getString("j.apellido_j");
               modelo.addRow(registro);
            }
            jugadores.setModel(modelo);
            jugadores.getColumnModel().getColumn(0).setPreferredWidth(144);
            jugadores.getColumnModel().getColumn(1).setPreferredWidth(144);
            jugadores.getColumnModel().getColumn(2).setPreferredWidth(144);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            jugadores.setRowSorter(modeloordenado);
            modeloordenado.setRowFilter(RowFilter.regexFilter(filtro.getText()));
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE, null, ex);
                }
 }
 
 
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jugadorestorneo = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jScrollPane2 = new javax.swing.JScrollPane();
        jugadores = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        bagregar = new javax.swing.JButton();
        beliminar = new javax.swing.JButton();
        bsalir = new javax.swing.JButton();
        labelnombreeq = new javax.swing.JLabel();
        filtro = new javax.swing.JTextField();
        filtro2 = new javax.swing.JTextField();
        bacceder = new javax.swing.JButton();
        labelserial = new javax.swing.JLabel();
        labelcategoria = new javax.swing.JLabel();
        radioBException = new javax.swing.JRadioButton();
        labelserialexce = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1000, 412));

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel1.setLayout(null);

        jPanel2.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 412));

        jugadorestorneo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jugadorestorneo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jugadorestorneo);

        jugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jugadores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(jugadores);

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

        labelnombreeq.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelnombreeq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtroKeyReleased(evt);
            }
        });

        filtro2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtro2KeyReleased(evt);
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

        radioBException.setText("Excepción");
        radioBException.setContentAreaFilled(false);
        radioBException.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBExceptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelserialexce, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelserial, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124)
                .addComponent(labelnombreeq, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(bsalir))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bacceder)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bagregar)
                            .addComponent(beliminar))))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioBException)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filtro2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelserial, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelnombreeq, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelserialexce))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filtro2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioBException)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(bsalir)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(bagregar)
                        .addGap(18, 18, 18)
                        .addComponent(beliminar)
                        .addGap(18, 18, 18)
                        .addComponent(bacceder))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyReleased

        cargarjugadorequipo();
    }//GEN-LAST:event_filtroKeyReleased

    private void filtro2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtro2KeyReleased

        cargarjugadorestorneo();
    }//GEN-LAST:event_filtro2KeyReleased

    private void bagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagregarActionPerformed
         try{
             agregarjugador();
         }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Debe seleccionar algun jugador de la tabla ubicada a la izquierda de la pantalla","Informacion", JOptionPane.INFORMATION_MESSAGE);
         }
    }//GEN-LAST:event_bagregarActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        Principal.panelprincipal.remove(this);
        Equipostorneo.habilitar();
    }//GEN-LAST:event_bsalirActionPerformed

    private void beliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliminarActionPerformed
       try{
           eliminarjugador();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Debe seleccionar algun jugador de la tabla que aparece\n a la derecha de la pantalla"
                   + " para poder eliminar","Informacion",JOptionPane.INFORMATION_MESSAGE);
       }
    }//GEN-LAST:event_beliminarActionPerformed

    private void radioBExceptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBExceptionActionPerformed
        seleccionException=radioBException.isSelected();

        if(seleccionException==true){
            cargarlistaException();
        }else{
            cargar();
        }
    }//GEN-LAST:event_radioBExceptionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bacceder;
    public static javax.swing.JButton bagregar;
    public static javax.swing.JButton beliminar;
    public static javax.swing.JButton bsalir;
    public static javax.swing.JTextField filtro;
    public static javax.swing.JTextField filtro2;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jugadores;
    public static javax.swing.JTable jugadorestorneo;
    public static javax.swing.JLabel labelcategoria;
    public static javax.swing.JLabel labelnombreeq;
    public static javax.swing.JLabel labelserial;
    public static javax.swing.JLabel labelserialexce;
    public static javax.swing.JRadioButton radioBException;
    // End of variables declaration//GEN-END:variables
}
