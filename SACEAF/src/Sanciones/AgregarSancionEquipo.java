
package Sanciones;

import Basededatos.Conexion;
import static Sanciones.Gsanciones.PanelSanciones;
import SancionesEquipoBdD.DatosDeudaEquipo;
import SancionesEquipoBdD.DatosSancionesEquipo;
import SancionesEquipoBdD.InsertarDeudaEquipo;
import SancionesEquipoBdD.InsertarSancionesEquipo;
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




public class AgregarSancionEquipo extends javax.swing.JPanel {
 

    DefaultComboBoxModel combo= new DefaultComboBoxModel();
    private MenuComponent VerSanciones;
   
   
    public AgregarSancionEquipo() {
        initComponents();
       
        
    }
public void HabilitarGuardar(){
        
        String id_equipo=this.CampoEquipo.getText();
        String Suspension=this.CampoFechas.getText();
        String MotivoPago=this.CampoMotivo.getText();
        String MontoSancion=this.CampoMontoSancion.getText();

        
        if(id_equipo.isEmpty() || Suspension.isEmpty() || MotivoPago.isEmpty() || MontoSancion.isEmpty()){
            
            AgregarSancionEquipo.BotonAgregarSancion.setEnabled(false);
        }
        
        else{
            AgregarSancionEquipo.BotonAgregarSancion.setEnabled(true);
        }
    }

 public void Limpiar(){
       this.CampoMotivo.setText("");
       this.CampoFechas.setText("");
       this.CampoEquipo.setText("");
       this.CampoMontoSancion.setText("");
       
      
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
        CampoEquipo = new javax.swing.JTextField();
        bsalir = new javax.swing.JButton();
        BotonAgregarSancion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        CampoMontoSancion = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(1, 1));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(870, 300));

        jPanel1.setMinimumSize(new java.awt.Dimension(790, 228));
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
        jLabel8.setText("Agregar Sanción a Equipo");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Serial del Equipo");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Motivo");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Fechas de Suspensión:");

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

        CampoEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoEquipoActionPerformed(evt);
            }
        });
        CampoEquipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CampoEquipoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoEquipoKeyTyped(evt);
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

        BotonAgregarSancion.setEnabled(false);
        BotonAgregarSancion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Add 30x30.png"))); // NOI18N
        BotonAgregarSancion.setText("Agregar Sanción");
        BotonAgregarSancion.setContentAreaFilled(false);
        BotonAgregarSancion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonAgregarSancion.setIconTextGap(-2);
        BotonAgregarSancion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Add 40x40.png"))); // NOI18N
        BotonAgregarSancion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BotonAgregarSancion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonAgregarSancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarSancionActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel10)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CampoFechas)
                    .addComponent(CampoEquipo)
                    .addComponent(CampoMontoSancion, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(250, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(189, 189, 189))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(150, 150, 150)))
                        .addComponent(bsalir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BotonAgregarSancion)
                        .addGap(53, 53, 53)
                        .addComponent(BotonLimpiar)
                        .addGap(283, 283, 283))))
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
                                    .addComponent(CampoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(BotonAgregarSancion, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonLimpiar)))
                    .addComponent(bsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonAgregarSancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarSancionActionPerformed
    

//Busqueda del ID del Club del Equipo
     String ID_Club="";   
    try{
        
        String Codigo=this.CampoEquipo.getText();
        String Query="SELECT id_club FROM Equipo WHERE id_equipo='"+Codigo+"';";
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
        int Opcion=JOptionPane.showConfirmDialog(null,"¿Está seguro que desea agregar la sancion al equipo con los datos introducidos?","Información",JOptionPane.YES_NO_OPTION);
        
        if(Opcion==0){
        
        try{
            String ID_Equipo=this.CampoEquipo.getText();
            int ID=0;
            String query="SELECT id_equipo from equipo where id_equipo='"+ID_Equipo+"';";
            Conexion parametros= new Conexion();
            Class.forName(parametros.getDriver());
            Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(query);
             if(rs.first()){
                ID=2;
            }
             if(ID!=2){
                 JOptionPane.showMessageDialog(this,"El Equipo no se Encuentra en la Base de Datos","Información",JOptionPane.INFORMATION_MESSAGE);
             }
             else{
                 try{
                    String ID_Sancion_Equipo="";
                    String query2="SELECT MAX(CAST(id_sancion_equipo AS SIGNED)) FROM sancion_equipo";
                    Conexion parametros2 = new Conexion();
                    Class.forName(parametros.getDriver());
                    Connection con2=DriverManager.getConnection(parametros2.getURL(), parametros2.getUsuario(), parametros2.getPass());
                    Statement st2=con2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs2=st2.executeQuery(query2);
                    if(rs2.next()){
                        ID_Sancion_Equipo=rs2.getString(1);
                    }
                    if(ID_Sancion_Equipo==null){
                        ID_Sancion_Equipo="1";
                        int ID_SE=Integer.parseInt(ID_Sancion_Equipo);
                        try{
                            String Codigo_Equipo=this.CampoEquipo.getText();
                            int Fechas_Suspension=Integer.parseInt(this.CampoFechas.getText());
                            String Motivo_Sancion=this.CampoMotivo.getText();
                           
                            

                            DatosSancionesEquipo user = new DatosSancionesEquipo(ID_SE, Motivo_Sancion, Fechas_Suspension, Codigo_Equipo);

                            InsertarSancionesEquipo in = new InsertarSancionesEquipo();

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
                                           
                                           DatosDeudaEquipo User = new DatosDeudaEquipo(Codigo_Deuda, FechaDeuda, HoraDeuda, Motivo_Sancion, Monto_Sancion, Monto_Sancion2, ID_Club, Codigo_Equipo);
                                           
                                           InsertarDeudaEquipo IN = new InsertarDeudaEquipo();
                                           
                                           boolean R;
                                           R=IN.InsertarBdD(User);
                                           
                                           if(R==false){
                                               JOptionPane.showMessageDialog(this,"Sanción de Equipo Guardada Exitosamente","Guardado",JOptionPane.INFORMATION_MESSAGE);
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
                        int ID_SE=Integer.parseInt(ID_Sancion_Equipo);
                        ID_SE=ID_SE+1;
                        
                        try{
                            String Codigo_Equipo=this.CampoEquipo.getText();
                            int Fechas_Suspension=Integer.parseInt(this.CampoFechas.getText());
                            String Motivo_Sancion=this.CampoMotivo.getText();
                           
                            

                            DatosSancionesEquipo user = new DatosSancionesEquipo(ID_SE, Motivo_Sancion, Fechas_Suspension, Codigo_Equipo);

                            InsertarSancionesEquipo in = new InsertarSancionesEquipo();

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
                                           
                                           DatosDeudaEquipo User = new DatosDeudaEquipo(Codigo_Deuda, FechaDeuda, HoraDeuda, Motivo_Sancion, Monto_Sancion, Monto_Sancion2, ID_Club, Codigo_Equipo);
                                           
                                           InsertarDeudaEquipo IN = new InsertarDeudaEquipo();
                                           
                                           boolean R;
                                           R=IN.InsertarBdD(User);
                                           
                                           if(R==false){
                                               JOptionPane.showMessageDialog(this,"Sanción de Equipo Guardada Exitosamente","Guardado",JOptionPane.INFORMATION_MESSAGE);
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
                                           
                                           DatosDeudaEquipo User = new DatosDeudaEquipo(Codigo_Deuda, FechaDeuda, HoraDeuda, Motivo_Sancion, Monto_Sancion, Monto_Sancion2, ID_Club, Codigo_Equipo);
                                           
                                           InsertarDeudaEquipo IN = new InsertarDeudaEquipo();
                                           
                                           boolean R;
                                           R=IN.InsertarBdD(User);
                                           
                                           if(R==false){
                                               JOptionPane.showMessageDialog(this,"Sanción de Equipo Guardada Exitosamente","Guardado",JOptionPane.INFORMATION_MESSAGE);
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
    }//GEN-LAST:event_BotonAgregarSancionActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
    Gsanciones.PanelSanciones.remove(this);
    Gsanciones.PanelSanciones.remove(VerSanciones);
    AbrirSanciones();
    Gsanciones.habilitar();
    }//GEN-LAST:event_bsalirActionPerformed

    private void CampoEquipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoEquipoKeyReleased
        HabilitarGuardar();
    }//GEN-LAST:event_CampoEquipoKeyReleased

    private void CampoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoEquipoActionPerformed

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
        Limpiar();
    }//GEN-LAST:event_BotonLimpiarActionPerformed

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

    private void CampoEquipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoEquipoKeyTyped
               int Limite=50;
    char K;
    K=evt.getKeyChar();
    if (CampoEquipo.getText().length()== Limite){
     evt.consume();
    }
    if(K<'0'|| K>'9'){
     evt.consume();
    }
    }//GEN-LAST:event_CampoEquipoKeyTyped

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton BotonAgregarSancion;
    public static javax.swing.JButton BotonLimpiar;
    private javax.swing.JTextField CampoEquipo;
    private javax.swing.JTextField CampoFechas;
    private javax.swing.JTextField CampoMontoSancion;
    private javax.swing.JTextArea CampoMotivo;
    public static javax.swing.JButton bsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
