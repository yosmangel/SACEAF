
package Sanciones;

import Basededatos.Conexion;
import static Sanciones.Gsanciones.PanelSanciones;
import SancionesEquipoBdD.DatosDeudaEquipo;
import SancionesEquipoBdD.DatosSancionesEquipo;
import SancionesEquipoBdD.InsertarDeudaEquipo;
import SancionesEquipoBdD.InsertarSancionesEquipo;
import SancionesJugadorBdD.DatosSancionesJugador;
import SancionesJugadorBdD.InsertarSancionesJugador;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static saceaf.Principal.panelprincipal;


public class AgregarSancionJugador extends javax.swing.JPanel {
 

    DefaultComboBoxModel combo= new DefaultComboBoxModel();
    private MenuComponent VerSanciones;
   
   
    public AgregarSancionJugador() {
        initComponents();
       
        
    }
public void HabilitarGuardar(){
        
        String id_equipo=this.CampoID_Jugador.getText();
        String Suspension=this.CampoFechas.getText();
        String MotivoPago=this.CampoMotivo.getText();

        
        if(id_equipo.isEmpty() || Suspension.isEmpty() || MotivoPago.isEmpty()){
            
            AgregarSancionJugador.BotonGuardar.setEnabled(false);
        }
        
        else{
            AgregarSancionJugador.BotonGuardar.setEnabled(true);
        }
    }
  public void AbrirSanciones(){
    VerSanciones AbrirSanciones= new VerSanciones();
    String titulo="Sanciones";
        int index=PanelSanciones.indexOfTab(titulo);
        if(index==-1){
            PanelSanciones.addTab(titulo, AbrirSanciones);
            int i=PanelSanciones.indexOfTab(titulo);
            PanelSanciones.setSelectedIndex(i);
        }else{
            PanelSanciones.remove(index);
            PanelSanciones.addTab(titulo, AbrirSanciones);
            int i=PanelSanciones.indexOfTab(titulo);
            PanelSanciones.setSelectedIndex(i);
        }
    
}
 void limpiar(){
       this.CampoMotivo.setText("");
       this.CampoFechas.setText("");
       this.CampoID_Jugador.setText("");
       
      
 }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BotonLimpiar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        CampoFechas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        CampoMotivo = new javax.swing.JTextArea();
        CampoID_Jugador = new javax.swing.JTextField();
        BotonSalir = new javax.swing.JButton();
        BotonGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        CampoMontoSancion = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(1, 1));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(870, 300));

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 300));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 300));

        BotonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/limpiar30x30.png"))); // NOI18N
        BotonLimpiar.setText("Limpiar");
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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Agregar Sanción a Jugador");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Cédula del Jugador:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Motivo");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Fechas de Suspension:");

        CampoFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoFechasActionPerformed(evt);
            }
        });
        CampoFechas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CampoFechasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoFechasKeyTyped(evt);
            }
        });

        CampoMotivo.setColumns(20);
        CampoMotivo.setRows(5);
        CampoMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CampoMotivoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(CampoMotivo);

        CampoID_Jugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoID_JugadorActionPerformed(evt);
            }
        });
        CampoID_Jugador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CampoID_JugadorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoID_JugadorKeyTyped(evt);
            }
        });

        BotonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 30x30.png"))); // NOI18N
        BotonSalir.setText("Salir");
        BotonSalir.setContentAreaFilled(false);
        BotonSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonSalir.setIconTextGap(-2);
        BotonSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 40x40.png"))); // NOI18N
        BotonSalir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });

        BotonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Add 30x30.png"))); // NOI18N
        BotonGuardar.setText("Agregar Sanción");
        BotonGuardar.setContentAreaFilled(false);
        BotonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonGuardar.setIconTextGap(-2);
        BotonGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Add 40x40.png"))); // NOI18N
        BotonGuardar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Monto de la Sanción:");

        CampoMontoSancion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoMontoSancionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel10)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CampoFechas)
                    .addComponent(CampoID_Jugador)
                    .addComponent(CampoMontoSancion, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(150, 150, 150))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(189, 189, 189)))
                        .addComponent(BotonSalir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BotonGuardar)
                        .addGap(53, 53, 53)
                        .addComponent(BotonLimpiar)
                        .addGap(285, 285, 285))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CampoID_Jugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CampoFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(CampoMontoSancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonLimpiar)))
                    .addComponent(BotonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
        
//Busqueda del ID del Equipo del Jugador
  String ID_Equipo="";   
    try{
        
        String Cedula=this.CampoID_Jugador.getText();
        String Query="SELECT id_equipo FROM Jugador WHERE Cedula='"+Cedula+"';";
        Conexion Parametros= new Conexion();
        Class.forName(Parametros.getDriver());
        Connection Con=DriverManager.getConnection(Parametros.getURL(), Parametros.getUsuario(), Parametros.getPass());
        Statement ST=Con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet RS=ST.executeQuery(Query);
        if(RS.next()){
         ID_Equipo=RS.getString(1);  
    }
    }catch(SQLException ex){
            Logger.getLogger(AgregarSancionJugador.class.getName()).log(Level.SEVERE,null,ex);
        }catch(ClassNotFoundException e){
            Logger.getLogger(AgregarSancionJugador.class.getName()).log(Level.SEVERE,null,e);
        }
    



//Busqueda del ID del Club del Equipo del Jugador
     String ID_Club="";   
    try{
        
        String Query="SELECT id_club FROM Equipo WHERE id_equipo='"+ID_Equipo+"';";
        Conexion Parametros= new Conexion();
        Class.forName(Parametros.getDriver());
        Connection Con=DriverManager.getConnection(Parametros.getURL(), Parametros.getUsuario(), Parametros.getPass());
        Statement ST=Con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet RS=ST.executeQuery(Query);
        if(RS.next()){
         ID_Club=RS.getString(1);  
    }
    }catch(SQLException ex){
            Logger.getLogger(AgregarSancionEquipo.class.getName()).log(Level.SEVERE,null,ex);
        }catch(ClassNotFoundException e){
            Logger.getLogger(AgregarSancionEquipo.class.getName()).log(Level.SEVERE,null,e);
        }
    



    //Fecha y Hora del Sistema para insertar la deuda
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
    String FechaDeuda=año+"/"+(mes+1)+"/"+dia;
    String Hora=sdf.format(fecha.getTime()); 
    String HoraDeuda=Hora+" "+AmPm;
        
    //Aquí empieza el control de los datos del formulario    
        int Opcion=JOptionPane.showConfirmDialog(null,"¿Está seguro que desea agregar la sancion al jugador con los datos introducidos?","Información",JOptionPane.YES_NO_OPTION);
        
        if(Opcion==0){
        
        try{
            String ID_Jugador=this.CampoID_Jugador.getText();
            int ID=0;
            String query="SELECT Cedula from jugador where Cedula='"+ID_Jugador+"';";
            Conexion parametros= new Conexion();
            Class.forName(parametros.getDriver());
            Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(query);
             if(rs.first()){
                ID=2;
            }
             if(ID!=2){
                 JOptionPane.showMessageDialog(this,"El Jugador no se Encuentra en la Base de Datos","Información",JOptionPane.INFORMATION_MESSAGE);
             }
             else{
                 try{
                    String ID_Sancion_Jugador="";
                    String query2="SELECT MAX(CAST(id_sancion_jugador AS SIGNED)) FROM sancion_jugador";
                    Conexion parametros2 = new Conexion();
                    Class.forName(parametros.getDriver());
                    Connection con2=DriverManager.getConnection(parametros2.getURL(), parametros2.getUsuario(), parametros2.getPass());
                    Statement st2=con2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs2=st2.executeQuery(query2);
                    if(rs2.next()){
                        ID_Sancion_Jugador=rs2.getString(1);
                    }
                    if(ID_Sancion_Jugador==null){
                        ID_Sancion_Jugador="1";
                        int ID_SJ=Integer.parseInt(ID_Sancion_Jugador);
                        try{
                            String CedulaJugador=this.CampoID_Jugador.getText();
                            int Fechas_Suspension=Integer.parseInt(this.CampoFechas.getText());
                            String Motivo_Sancion=this.CampoMotivo.getText();
                           
                            

                            DatosSancionesJugador user = new DatosSancionesJugador(ID_SJ, Motivo_Sancion, Fechas_Suspension, CedulaJugador);

                            InsertarSancionesJugador in = new InsertarSancionesJugador();

                            boolean r;
                            r=in.Insertar(user);
                            if(r==false){
                                
                                try{
                                   String ID_Deuda="";
                                   String query3="SELECT MAX(CAST(id_deuda AS SIGNED)) FROM Deuda";
                                   Conexion parametros3 = new Conexion();
                                   Class.forName(parametros3.getDriver());
                                   Connection con3=DriverManager.getConnection(parametros3.getURL(), parametros3.getUsuario(), parametros3.getPass());
                                   Statement st3=con3.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                                   ResultSet rs3=st3.executeQuery(query3);
                                   if(rs3.next()){
                                      ID_Deuda=rs3.getString(1);  
                                    }
                                   if(ID_Deuda==null){
                                       ID_Deuda="1";
                                       int Codigo_Deuda=Integer.parseInt(ID_Deuda);
                                       try{
                                           int Monto_Sancion=Integer.parseInt(this.CampoMontoSancion.getText());
                                           int Monto_Sancion2= Monto_Sancion;
                                           
                                           DatosDeudaEquipo User = new DatosDeudaEquipo(Codigo_Deuda, FechaDeuda, HoraDeuda, Motivo_Sancion, Monto_Sancion, Monto_Sancion2, ID_Club, ID_Equipo);
                                           
                                           InsertarDeudaEquipo IN = new InsertarDeudaEquipo();
                                           
                                           boolean R;
                                           R=IN.InsertarBdD(User);
                                           
                                           if(R==false){
                                               JOptionPane.showMessageDialog(this,"Sanción de Jugador Guardada Exitosamente","Guardado",JOptionPane.INFORMATION_MESSAGE);
                                                Gsanciones.PanelSanciones.remove(VerSanciones);
                                                Gsanciones.PanelSanciones.remove(this);
                                                AbrirSanciones();
                                                Gsanciones.habilitar();
                                           }
                                                   
                                       }catch(SQLException ex){
                                         JOptionPane.showMessageDialog(null,"Error "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                                       }catch(ClassNotFoundException e){
                                         Logger.getLogger(AgregarSancionJugador.class.getName()).log(Level.SEVERE,null,e);
                                        }
                                   
                                   }
                                   
                         
                                }catch(SQLException ex){
                                   JOptionPane.showMessageDialog(null,"Error "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                                }catch(ClassNotFoundException e){
                                   Logger.getLogger(AgregarSancionJugador.class.getName()).log(Level.SEVERE,null,e);
                                } 
                            }
                        }catch(SQLException ex){
                            JOptionPane.showMessageDialog(null,"Error "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        }catch(ClassNotFoundException e){
                            Logger.getLogger(AgregarSancionJugador.class.getName()).log(Level.SEVERE,null,e);
                        }
                    }
                    else{
                        int ID_SJ=Integer.parseInt(ID_Sancion_Jugador);
                        ID_SJ=ID_SJ+1;
                        
                        try{
                            String CedulaJugador=this.CampoID_Jugador.getText();
                            int Fechas_Suspension=Integer.parseInt(this.CampoFechas.getText());
                            String Motivo_Sancion=this.CampoMotivo.getText();
                           
                            

                            DatosSancionesJugador user = new DatosSancionesJugador(ID_SJ, Motivo_Sancion, Fechas_Suspension, CedulaJugador);

                            InsertarSancionesJugador in = new InsertarSancionesJugador();

                            boolean r;
                            r=in.Insertar(user);
                            if(r==false){
                                
                                try{
                                   String ID_Deuda="";
                                   String query3="SELECT MAX(CAST(id_deuda AS SIGNED)) FROM Deuda";
                                   Conexion parametros3 = new Conexion();
                                   Class.forName(parametros3.getDriver());
                                   Connection con3=DriverManager.getConnection(parametros3.getURL(), parametros3.getUsuario(), parametros3.getPass());
                                   Statement st3=con3.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                                   ResultSet rs3=st3.executeQuery(query3);
                                   if(rs3.next()){
                                      ID_Deuda=rs3.getString(1);  
                                    }
                                   if(ID_Deuda==null){
                                       ID_Deuda="1";
                                       int Codigo_Deuda=Integer.parseInt(ID_Deuda);
                                       try{
                                           int Monto_Sancion=Integer.parseInt(this.CampoMontoSancion.getText());
                                           int Monto_Sancion2= Monto_Sancion;
                                           
                                           DatosDeudaEquipo User = new DatosDeudaEquipo(Codigo_Deuda, FechaDeuda, HoraDeuda, Motivo_Sancion, Monto_Sancion, Monto_Sancion2, ID_Club, ID_Equipo);
                                           
                                           InsertarDeudaEquipo IN = new InsertarDeudaEquipo();
                                           
                                           boolean R;
                                           R=IN.InsertarBdD(User);
                                           
                                           if(R==false){
                                               JOptionPane.showMessageDialog(this,"Sanción de Jugador Guardada Exitosamente","Guardado",JOptionPane.INFORMATION_MESSAGE);
                                                Gsanciones.PanelSanciones.remove(VerSanciones);
                                                Gsanciones.PanelSanciones.remove(this);
                                                AbrirSanciones();
                                                Gsanciones.habilitar();
                                           }
                                                   
                                       }catch(SQLException ex){
                                         JOptionPane.showMessageDialog(null,"Error "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                                       }catch(ClassNotFoundException e){
                                         Logger.getLogger(AgregarSancionJugador.class.getName()).log(Level.SEVERE,null,e);
                                        }
                                   
                                   }
                                   else{
                                       int Codigo_Deuda=Integer.parseInt(ID_Deuda);
                                       Codigo_Deuda=Codigo_Deuda+1;
                                       try{
                                           int Monto_Sancion=Integer.parseInt(this.CampoMontoSancion.getText());
                                           int Monto_Sancion2= Monto_Sancion;
                                           
                                           DatosDeudaEquipo User = new DatosDeudaEquipo(Codigo_Deuda, FechaDeuda, HoraDeuda, Motivo_Sancion, Monto_Sancion, Monto_Sancion2, ID_Club, ID_Equipo);
                                           
                                           InsertarDeudaEquipo IN = new InsertarDeudaEquipo();
                                           
                                           boolean R;
                                           R=IN.InsertarBdD(User);
                                           
                                           if(R==false){
                                               JOptionPane.showMessageDialog(this,"Sanción de Jugador Guardada Exitosamente","Guardado",JOptionPane.INFORMATION_MESSAGE);
                                                Gsanciones.PanelSanciones.remove(VerSanciones);
                                                Gsanciones.PanelSanciones.remove(this);
                                                AbrirSanciones();
                                                Gsanciones.habilitar();
                                           }
                                                   
                                       }catch(SQLException ex){
                                         JOptionPane.showMessageDialog(null,"Error "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                                       }catch(ClassNotFoundException e){
                                         Logger.getLogger(AgregarSancionJugador.class.getName()).log(Level.SEVERE,null,e);
                                        }
                                   }
                                   
                         
                                }catch(SQLException ex){
                                   JOptionPane.showMessageDialog(null,"Error "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                                }catch(ClassNotFoundException e){
                                   Logger.getLogger(AgregarSancionJugador.class.getName()).log(Level.SEVERE,null,e);
                                } 
                            }
                        }catch(SQLException ex){
                            JOptionPane.showMessageDialog(null,"Error "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        }catch(ClassNotFoundException e){
                            Logger.getLogger(AgregarSancionJugador.class.getName()).log(Level.SEVERE,null,e);
                        }
                        
                        
                        
                    }
                 }catch(SQLException ex){
                            JOptionPane.showMessageDialog(null,"Error "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        }catch(ClassNotFoundException e){
                            Logger.getLogger(AgregarSancionEquipo.class.getName()).log(Level.SEVERE,null,e);
                        }
             }
        }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,"Error "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }catch(ClassNotFoundException e){
                    Logger.getLogger(AgregarSancionEquipo.class.getName()).log(Level.SEVERE,null,e);
        }
        }
    }//GEN-LAST:event_BotonGuardarActionPerformed

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
    Gsanciones.PanelSanciones.remove(this);
    Gsanciones.PanelSanciones.remove(VerSanciones);
    AbrirSanciones();
        Gsanciones.habilitar();
    }//GEN-LAST:event_BotonSalirActionPerformed

    private void CampoID_JugadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoID_JugadorKeyReleased
        HabilitarGuardar();
    }//GEN-LAST:event_CampoID_JugadorKeyReleased

    private void CampoID_JugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoID_JugadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoID_JugadorActionPerformed

    private void CampoMotivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoMotivoKeyReleased
        HabilitarGuardar();
    }//GEN-LAST:event_CampoMotivoKeyReleased

    private void CampoFechasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoFechasKeyReleased
        HabilitarGuardar();
    }//GEN-LAST:event_CampoFechasKeyReleased

    private void CampoFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoFechasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoFechasActionPerformed

    private void BotonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_BotonLimpiarActionPerformed

    private void CampoID_JugadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoID_JugadorKeyTyped
                   int Limite=8;
    char K;
    K=evt.getKeyChar();
    if (CampoID_Jugador.getText().length()== Limite){
     evt.consume();
    }
    if(K<'0'|| K>'9'){
     evt.consume();
    }
    }//GEN-LAST:event_CampoID_JugadorKeyTyped

    private void CampoFechasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoFechasKeyTyped
                   int Limite=50;
    char K;
    K=evt.getKeyChar();
    if (CampoFechas.getText().length()== Limite){
     evt.consume();
    }
    if(K<'0'|| K>'9'){
     evt.consume();
    }
    }//GEN-LAST:event_CampoFechasKeyTyped

    private void CampoMontoSancionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoMontoSancionKeyTyped
                   int Limite=50;
    char K;
    K=evt.getKeyChar();
    if (CampoMontoSancion.getText().length()== Limite){
     evt.consume();
    }
    if(K<'0'|| K>'9'){
     evt.consume();
    }
    }//GEN-LAST:event_CampoMontoSancionKeyTyped
 int ctrserial,ctrnombre,ctrpre;   String sancion;
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton BotonGuardar;
    public static javax.swing.JButton BotonLimpiar;
    public static javax.swing.JButton BotonSalir;
    private javax.swing.JTextField CampoFechas;
    private javax.swing.JTextField CampoID_Jugador;
    private javax.swing.JTextField CampoMontoSancion;
    private javax.swing.JTextArea CampoMotivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
