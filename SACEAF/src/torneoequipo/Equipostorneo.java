
package torneoequipo;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import saceaf.Principal;
import torneodatoseq.borrarequipot;
import torneodatoseq.datosequipot;
import torneodatoseq.torneoequipo;


public class Equipostorneo extends javax.swing.JPanel {
    static DefaultTableModel modelo;
    static DefaultTableModel modelo1;
    static DefaultTableModel modelo2;
    static DefaultTableModel modelo3;
    static JOptionPane joption;
    DefaultComboBoxModel masculino= new DefaultComboBoxModel();
    DefaultComboBoxModel femenino= new DefaultComboBoxModel();
    public Equipostorneo() {
        initComponents();
        cargarcombo();
    }
 static String idcategoria, idclub,id_equipo, id_hequipo,id_serialb,bloqueo,disciplina,id_disciplina;
 static int ctrl;
 public static void habilitar(){
     bagregar.setEnabled(true);
     beliminar.setEnabled(true);
     bacceder.setEnabled(true);
     equipos.setEnabled(true);
     equipostorneo.setEnabled(true);
     filtro2.setEnabled(true);
     filtro.setEnabled(true);
     bsalir.setEnabled(true);
     combocategorias.setEnabled(true);

 }
 public static void inhabilitar(){
     bagregar.setEnabled(false);
     beliminar.setEnabled(false);
     bacceder.setEnabled(false);
     equipos.setEnabled(false);
     equipostorneo.setEnabled(false);
     filtro2.setEnabled(false);
     filtro.setEnabled(false);
     bsalir.setEnabled(false);
     combocategorias.setEnabled(false);

 }
 public static void cargartabla(){
     String categoria= combocategorias.getSelectedItem().toString();
     String sexo=Principal.labelsexo.getText();
     disciplina=Principal.labeldisciplina.getText();
                try{
         String sql="Select id_disciplina from disciplina where nombre_disciplina='"+disciplina+"';";
         Conexion parametros= new Conexion();
         Class.forName(parametros.getDriver());
         Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
         Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs=st.executeQuery(sql);
         while(rs.last()){
             id_disciplina=rs.getString("id_disciplina");
             break;
         }
     }catch(SQLException | ClassNotFoundException ex){
         Logger.getLogger(jugadoresequipot.class.getName()).log(Level.SEVERE,null,ex);
     }
     try{
            String[] titulos={"Nombre","Identificador"};
            String[] registro= new String[2];
            String sql="Select c.nombre_club, e.identificador from club c, equipo e where c.id_club=e.id_club and e.id_categoria=(Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+sexo+"') and e.id_disciplina='"+id_disciplina+"' ;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("c.nombre_club");
               registro [1]=rs.getString("e.identificador");
               
               modelo.addRow(registro);
            }
            equipos.setModel(modelo);
            equipos.getColumnModel().getColumn(0).setPreferredWidth(175);
            equipos.getColumnModel().getColumn(1).setPreferredWidth(175);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            equipos.setRowSorter(modeloordenado);
            modeloordenado.setRowFilter(RowFilter.regexFilter(filtro.getText()));
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(Equipostorneo.class.getName()).log(Level.SEVERE, null, ex);
                }
     }
 public void cargarcombo(){
     
        combocategorias.removeAllItems();
        String sexo=Principal.labelsexo.getText();
        String idtorneo=Principal.labelserialtorneo.getText();
        try{
            Conexion parametros =new Conexion();
            Class.forName(parametros.getDriver());
            Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
            Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery("Select c.nombre_cat from categoria c, categoria_torneo ct where c.id_categoria= ct.id_categoria and ct.id_torneo='"+idtorneo+"' and c.sexo='"+sexo+"';");
            femenino.addElement("Elige la categoria");
            combocategorias.setModel(femenino);                    
            while(rs.next()){
                femenino.addElement(rs.getObject("c.nombre_cat"));
                combocategorias.setModel(femenino);
            }
            st.close();
            
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(Equipostorneo.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
 public static void cargartablat(){
 String categoria= combocategorias.getSelectedItem().toString();
 String serialtorneo= Principal.labelserialtorneo.getText();
 String sexo=Principal.labelsexo.getText();
     try{
            String[] titulos={"Nombre","Identificador"};
            String[] registro= new String[2];
            String sql="Select c.nombre_club, e.identificador from club c, equipo e,h_equipo he where c.id_club=e.id_club and e.id_categoria=(Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+sexo+"') and he.id_torneo='"+serialtorneo+"' and he.id_equipo=e.id_equipo;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo2= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("c.nombre_club");
               registro [1]=rs.getString("e.identificador");
               
               modelo2.addRow(registro);
            }
            equipostorneo.setModel(modelo2);
            equipostorneo.getColumnModel().getColumn(0).setPreferredWidth(175);
            equipostorneo.getColumnModel().getColumn(1).setPreferredWidth(175);
            TableRowSorter modeloordenado= new TableRowSorter(modelo2);
            equipostorneo.setRowSorter(modeloordenado);
            modeloordenado.setRowFilter(RowFilter.regexFilter(filtro2.getText()));
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(Equipostorneo.class.getName()).log(Level.SEVERE, null, ex);
                }
     }
 public void agregarequipo(){
     idcategoria=null;
     idclub=null;
     id_equipo=null;
     id_hequipo=null;
     ctrl=0;
     String categoria= combocategorias.getSelectedItem().toString();
     String identificador= (String) equipos.getValueAt(equipos.getSelectedRow(),1);
     String nombre=(String) equipos.getValueAt(equipos.getSelectedRow(),0);
     String sexo=Principal.labelsexo.getText();
     try{
         String sql="Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+sexo+"';";
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
         Logger.getLogger(Equipostorneo.class.getName()).log(Level.SEVERE,null,ex);
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
         Logger.getLogger(Equipostorneo.class.getName()).log(Level.SEVERE,null,ex);
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
         Logger.getLogger(Equipostorneo.class.getName()).log(Level.SEVERE,null,ex);
     }
        
       String id_torneo= Principal.labelserialtorneo.getText();
       id_hequipo=id_torneo+id_equipo;
       try{
         String sql="Select bloqueo from equipo where id_equipo='"+id_equipo+"';";
         Conexion parametros= new Conexion();
         Class.forName(parametros.getDriver());
         Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(),parametros.getPass());
         Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rs=st.executeQuery(sql);
         while(rs.first()){
             bloqueo=rs.getString("bloqueo");
             break;
         }
     }catch(SQLException | ClassNotFoundException ex){
         Logger.getLogger(Equipostorneo.class.getName()).log(Level.SEVERE,null,ex);
     }
       if(bloqueo.equals("Si")){
         JOptionPane.showMessageDialog(this,"El equipo se encuentra bloqueado, por lo cual no puede agregarlo a ningun torneo","Informacion", JOptionPane.INFORMATION_MESSAGE);
       }else{
       try{
         String sql="Select id_hequipo from h_equipo where id_hequipo='"+id_hequipo+"';";
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
         Logger.getLogger(Equipostorneo.class.getName()).log(Level.SEVERE,null,ex);
     }
       if(ctrl==2){
        JOptionPane.showMessageDialog(null,"El equipo ya esta registrado en el torneo","Informacion", JOptionPane.INFORMATION_MESSAGE);
       }else{
       try{
           datosequipot user= new datosequipot(id_hequipo, id_equipo, id_torneo,idcategoria);
           torneoequipo in= new torneoequipo();
           boolean r;
           r=in.Insertar(user);
           if(r==false){
               JOptionPane.showMessageDialog(null,"Equipo agregado al torneo.", "Informacion",JOptionPane.INFORMATION_MESSAGE);
               cargartablat();
           }
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Error "+ex.getMessage(),"Informacion",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException e){
           Logger.getLogger(Equipostorneo.class.getName()).log(Level.SEVERE,null,e);
       }
       }
       }
 }
 public void eliminarequipo(){
     idcategoria=null;
     idclub=null;
     id_equipo=null;
     id_hequipo=null;
     ctrl=0;
     String categoria= combocategorias.getSelectedItem().toString();
     String identificador= (String) equipostorneo.getValueAt(equipostorneo.getSelectedRow(),1);
     String nombre=(String) equipostorneo.getValueAt(equipostorneo.getSelectedRow(),0);
     try{
         String sql="Select id_categoria from categoria where nombre_cat='"+categoria+"';";
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
         Logger.getLogger(Equipostorneo.class.getName()).log(Level.SEVERE,null,ex);
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
         Logger.getLogger(Equipostorneo.class.getName()).log(Level.SEVERE,null,ex);
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
         Logger.getLogger(Equipostorneo.class.getName()).log(Level.SEVERE,null,ex);
     }
        
       String id_torneo= Principal.labelserialtorneo.getText();
       id_serialb=id_torneo+id_equipo;
       try{
           borrarequipot user= new borrarequipot(id_serialb);
           torneoequipo in= new torneoequipo();
           boolean r;
           r=in.Eliminar(user);
           if(r==false){
               JOptionPane.showMessageDialog(null,"El equipo fue eliminado del torneo.", "Informacion",JOptionPane.INFORMATION_MESSAGE);
             cargartablat();
           }
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Error "+ex.getMessage(),"Informacion",JOptionPane.ERROR_MESSAGE);
       }catch(ClassNotFoundException e){
           Logger.getLogger(Equipostorneo.class.getName()).log(Level.SEVERE,null,e);
       }
 }
 public void accederequipo(){
     String nombre=(String) equipostorneo.getValueAt(equipostorneo.getSelectedRow(),0);
     String identificador= (String) equipostorneo.getValueAt(equipostorneo.getSelectedRow(),1);
     jugadoresequipot jet= new jugadoresequipot();
     String titulo=nombre+" "+identificador;
     int index= Principal.panelprincipal.indexOfTab(titulo);
     if(index==-1){
         Principal.panelprincipal.addTab(titulo, jet);
         int i=Principal.panelprincipal.indexOfTab(titulo);
         Principal.panelprincipal.setSelectedIndex(i);
     }else{
         Principal.panelprincipal.remove(index);
         Principal.panelprincipal.addTab(titulo, jet);
         int i=Principal.panelprincipal.indexOfTab(titulo);
         Principal.panelprincipal.setSelectedIndex(i);
     }
     
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        equipostorneo = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jScrollPane2 = new javax.swing.JScrollPane();
        equipos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        bagregar = new javax.swing.JButton();
        beliminar = new javax.swing.JButton();
        bsalir = new javax.swing.JButton();
        combocategorias = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        filtro = new javax.swing.JTextField();
        filtro2 = new javax.swing.JTextField();
        bacceder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1000, 412));

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel1.setLayout(null);

        jPanel2.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 412));

        equipostorneo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        equipostorneo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(equipostorneo);

        equipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        equipos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(equipos);

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

        combocategorias.setOpaque(false);
        combocategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocategoriasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Equipos en el Torneo");

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
        bacceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baccederActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bagregar)
                            .addComponent(beliminar)
                            .addComponent(bacceder)))
                    .addComponent(combocategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(278, 278, 278))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(151, 151, 151)
                                .addComponent(filtro2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(bsalir)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(combocategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bagregar)
                .addGap(18, 18, 18)
                .addComponent(beliminar)
                .addGap(18, 18, 18)
                .addComponent(bacceder)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filtro2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bsalir)
                        .addGap(33, 33, 33)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
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

    private void combocategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocategoriasActionPerformed
       try{
        cargartabla();
        cargartablat();
       }catch(Exception e){
           
       }
    }//GEN-LAST:event_combocategoriasActionPerformed

    private void filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyReleased
         cargartabla();
    }//GEN-LAST:event_filtroKeyReleased

    private void filtro2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtro2KeyReleased
       cargartablat();
    }//GEN-LAST:event_filtro2KeyReleased

    private void bagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagregarActionPerformed
         try{
             agregarequipo();
         }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Debe seleccionar algun equipo de la tabla ubicada a la izquierda de la pantalla","Informacion", JOptionPane.INFORMATION_MESSAGE);
         }
    }//GEN-LAST:event_bagregarActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        Principal.panelprincipal.remove(this);
    }//GEN-LAST:event_bsalirActionPerformed

    private void beliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliminarActionPerformed
       try{
           eliminarequipo();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Debe seleccionar algun equipo de la tabla que aparece\n a la derecha de la pantalla"
                   + " para poder eliminar","Informacion",JOptionPane.INFORMATION_MESSAGE);
       }
    }//GEN-LAST:event_beliminarActionPerformed

    private void baccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baccederActionPerformed
         try{
           accederequipo();
           inhabilitar();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Debe seleccionar algun equipo de la tabla que aparece\n a la derecha de la pantalla"
                   + " para poder acceder","Informacion",JOptionPane.INFORMATION_MESSAGE);
       }
    }//GEN-LAST:event_baccederActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bacceder;
    public static javax.swing.JButton bagregar;
    public static javax.swing.JButton beliminar;
    public static javax.swing.JButton bsalir;
    public static javax.swing.JComboBox combocategorias;
    public static javax.swing.JTable equipos;
    public static javax.swing.JTable equipostorneo;
    public static javax.swing.JTextField filtro;
    public static javax.swing.JTextField filtro2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
