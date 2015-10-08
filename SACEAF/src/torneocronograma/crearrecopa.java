
package torneocronograma;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import saceaf.Principal;
import torneodatoscronograma.competencia;
import torneodatoscronograma.datomodalidad;
import torneodatoscronograma.datoscompetencia;
import torneodatoscronograma.datosnumeroeq;
import torneodatoscronograma.equiponumero;
import torneodatoscronograma.modalidad;


public class crearrecopa extends javax.swing.JPanel {

   DefaultComboBoxModel combo= new DefaultComboBoxModel();
   static DefaultTableModel tabla= new DefaultTableModel();
   int datogrupos,datoclasificaxgrupo,datosequiposgrupos,datomejor,datopasanmejor,ctrl,idnumero,numeroeq,rondas;
   String id_torneo, id_competencia, id_categoria,datopostfase,id_modalidad,nombre_modalidad,categoria,idequipob,
          sexo,idbuscar,idtorneo,grupo;
   
   
    public crearrecopa() {
        initComponents();
        labelserial.setVisible(false);
        tablaequipos.setEnabled(false);
        bagregar.setEnabled(false);
        bguardare.setEnabled(false);
        combogrupo.setEnabled(false);
        
    }

    public void cargarcombogrupo(){
          
          combogrupo.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
              try (Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
                  ResultSet rs=st.executeQuery("Select id_variable from variables2;");
                  while(rs.next()){
                      combo.addElement(rs.getObject("id_variable"));
                      combogrupo.setModel(combo);
                  }   }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(crearrecopa.class.getName()).log(Level.SEVERE,null,ex);
          }
  }
    public static void cargarequipos(){
    String categoria= panelcrear.combocategoria.getSelectedItem().toString();
    String serialtorneo= Principal.labelserialtorneo.getText();
    String lsexo=Principal.labelsexo.getText();
     try{
            String[] titulos={"Nombre","Identificador"};
            String[] registro= new String[2];
            String sql="Select c.nombre_club, e.identificador from club c, equipo e,h_equipo he where c.id_club=e.id_club and e.id_categoria=(Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+lsexo+"') and he.id_torneo='"+serialtorneo+"' and he.id_equipo=e.id_equipo;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            tabla= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("c.nombre_club");
               registro [1]=rs.getString("e.identificador");
               
               tabla.addRow(registro);
            }
            tablaequipos.setModel(tabla);
            tablaequipos.getColumnModel().getColumn(0).setPreferredWidth(120);
            tablaequipos.getColumnModel().getColumn(1).setPreferredWidth(120);
            TableRowSorter modeloordenado= new TableRowSorter(tabla);
            tablaequipos.setRowSorter(modeloordenado);
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(crearrecopa.class.getName()).log(Level.SEVERE, null, ex);
                }
     }
    public void guardardatos(){
        datogrupos=0;
        datoclasificaxgrupo=0;
        datosequiposgrupos=0;
        datomejor=0;
        datopasanmejor=0;
        id_torneo=Principal.labelserialtorneo.getText();
        String categoria=panelcrear.combocategoria.getSelectedItem().toString();
        datopostfase="4";
        rondas=0;
        sexo=Principal.labelsexo.getText();
        try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+sexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(crearrecopa.class.getName()).log(Level.SEVERE,null,ex);
          }
        id_modalidad=id_torneo+id_categoria;
        nombre_modalidad="Recopa";
        id_competencia=id_modalidad+"3"+datopostfase;
        datogrupos=2;
        datoclasificaxgrupo=2;
        datosequiposgrupos=Integer.parseInt(dequiposg.getSelectedItem().toString());
        datomejor=0;
        datopasanmejor=0;
        try{
          datomodalidad user =new datomodalidad(id_modalidad,nombre_modalidad,id_categoria,datopostfase,id_torneo);
          modalidad in= new modalidad();
          boolean r;
          r=in.Insertar(user);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(crearrecopa.class.getName()).log(Level.SEVERE,null,ex);
        }
            try{
          datoscompetencia user=new datoscompetencia(id_competencia,datogrupos,datoclasificaxgrupo,datosequiposgrupos,datomejor,datopasanmejor,id_modalidad,rondas);
          competencia in= new competencia();
          boolean r;
          r=in.Insertar(user);
          if(r==false){
              JOptionPane.showMessageDialog(this,"Guardado","Informacion",JOptionPane.INFORMATION_MESSAGE);
              cargarcombogrupo();
              cargarequipos();
              tablaequipos.setEnabled(true);
              bagregar.setEnabled(true);
              bguardare.setEnabled(true);
              combogrupo.setEnabled(true);
              dequiposg.setEnabled(false);
              bguardart.setEnabled(false);
          }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(crearrecopa.class.getName()).log(Level.SEVERE,null,ex);
        } 
    }
    public void agregarequipo(){
        String nombre=(String)tablaequipos.getValueAt(tablaequipos.getSelectedRow(),0);
        String identificador=(String)tablaequipos.getValueAt(tablaequipos.getSelectedRow(),1);
        categoria= panelcrear.combocategoria.getSelectedItem().toString();
        labelserial.setText("");
        id_torneo=Principal.labelserialtorneo.getText();
        ctrl=0;
sexo=Principal.labelsexo.getText();
        
     try{
            String sql="Select e.id_equipo from club c, equipo e where c.nombre_club='"+nombre+"' and e.id_categoria=(Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+sexo+"') and e.identificador='"+identificador+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            idequipob=rs.getString("e.id_equipo");
            break;
            }
            labelserial.setText(idequipob);            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(crearrecopa.class.getName()).log(Level.SEVERE, null, ex);
            }
     try{
            String sql="Select numero_eq from h_equipo where id_equipo='"+idequipob+"' and id_torneo='"+id_torneo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
                idnumero=Integer.parseInt(rs.getString("numero_eq"));
                break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(crearrecopa.class.getName()).log(Level.SEVERE, null, ex);
            }
     if(idnumero==0){
       campoequipo.setText(nombre+" "+identificador);
        }else{
            JOptionPane.showMessageDialog(this,"El equipo ya posee el grupo y su numero asignado.\n"
                    + "Por Favor elija otro equipo" ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void guardarequipo(){
        idbuscar=null;
        idtorneo=null;
        idnumero=0;
        ctrl=0;
        idbuscar=labelserial.getText();
        id_torneo= Principal.labelserialtorneo.getText();
        categoria=panelcrear.combocategoria.getSelectedItem().toString();
        numeroeq=Integer.parseInt(camponumeroeq.getText());
        String idhequipo=id_torneo+idbuscar;
        grupo=combogrupo.getSelectedItem().toString();
        sexo=Principal.labelsexo.getText();
        try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+sexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(crearrecopa.class.getName()).log(Level.SEVERE,null,ex);
          }
        try{
            String sql="Select he.numero_eq from equipo e, h_equipo he where he.id_torneo='"+id_torneo+"' and e.id_categoria='"+id_categoria+"' and he.grupo_equipo='"+grupo+"' and he.numero_eq='"+numeroeq+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
                ctrl=2;
                break;
            }
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(crearrecopa.class.getName()).log(Level.SEVERE, null, ex);
                }
        if(ctrl==2){
            JOptionPane.showMessageDialog(this,"El numero que quiere asignar ya lo asigno a otro equipo.\n"
                    + "Pro favor agregue otro numero para identificar al equipo", "Informacion",JOptionPane.INFORMATION_MESSAGE);
            camponumeroeq.setText("");
            campoequipo.setText("");
            labelserial.setText("");
        }else{
            try{
            datosnumeroeq user= new datosnumeroeq(idhequipo,numeroeq,grupo,id_categoria,id_torneo);
            equiponumero in= new equiponumero();
            boolean r;
            r=in.Guardar(user);
            if(r==false){
            JOptionPane.showMessageDialog(this,"Se le ha asignado el Numero y el grupo al equipo","Informacion",JOptionPane.INFORMATION_MESSAGE);
            camponumeroeq.setText("");
            campoequipo.setText("");
            labelserial.setText("");
            }

            }catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
            }catch(ClassNotFoundException ex){
                Logger.getLogger(crearrecopa.class.getName()).log(Level.SEVERE,null,ex);
            }
        } 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dequiposg = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaequipos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }

        };
        bagregar = new javax.swing.JButton();
        campoequipo = new javax.swing.JTextField();
        camponumeroeq = new javax.swing.JTextField();
        combogrupo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bguardare = new javax.swing.JButton();
        ngrupos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        clasificaxgrupo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bguardart = new javax.swing.JButton();
        labelserial = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(860, 270));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(860, 270));
        jPanel1.setOpaque(false);

        dequiposg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "4", "5", "6", "7", "8", "9", "10", "11", "14", "16", "18", "20" }));

        tablaequipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaequipos);

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

        campoequipo.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Grupo");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("N° equipo");

        bguardare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/guardar30x30.png"))); // NOI18N
        bguardare.setText("Guardar");
        bguardare.setContentAreaFilled(false);
        bguardare.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bguardare.setIconTextGap(-2);
        bguardare.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/guardar40x40.png"))); // NOI18N
        bguardare.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bguardare.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bguardare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bguardareActionPerformed(evt);
            }
        });

        ngrupos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ngrupos.setText("2");
        ngrupos.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Grupos");

        clasificaxgrupo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clasificaxgrupo.setText("2");
        clasificaxgrupo.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Clasifica por Grupo");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Equipos por Grupo");

        bguardart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/guardar30x30.png"))); // NOI18N
        bguardart.setText("Guardar");
        bguardart.setContentAreaFilled(false);
        bguardart.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bguardart.setIconTextGap(-2);
        bguardart.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/guardar40x40.png"))); // NOI18N
        bguardart.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bguardart.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bguardart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bguardartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel3)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ngrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(107, 107, 107)
                                        .addComponent(clasificaxgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(bguardart)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dequiposg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bagregar)
                                .addGap(18, 18, 18)
                                .addComponent(campoequipo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combogrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(camponumeroeq))
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(bguardare)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(labelserial, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ngrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clasificaxgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dequiposg, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(bguardart)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combogrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(camponumeroeq, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(labelserial, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(campoequipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(87, 87, 87)
                                        .addComponent(bagregar)))
                                .addGap(13, 13, 13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 14, Short.MAX_VALUE)
                                .addComponent(bguardare, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(39, 39, 39))
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

    private void bguardartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardartActionPerformed
        try{
           int opc=JOptionPane.showConfirmDialog(null,"Esta seguro de guardar los datos de la Recopa?","Informacion",JOptionPane.YES_NO_OPTION);
           if(opc==0){
               guardardatos();
           }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_bguardartActionPerformed

    private void bguardareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardareActionPerformed
      
    }//GEN-LAST:event_bguardareActionPerformed

    private void bagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagregarActionPerformed
        try{
            agregarequipo();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Debe seleccionar algun equipo de la tabla para poder agregarlo","Informacion",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bagregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bagregar;
    public static javax.swing.JButton bguardare;
    public static javax.swing.JButton bguardart;
    public static javax.swing.JTextField campoequipo;
    public static javax.swing.JTextField camponumeroeq;
    public static javax.swing.JTextField clasificaxgrupo;
    public static javax.swing.JComboBox combogrupo;
    public static javax.swing.JComboBox dequiposg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel labelserial;
    public static javax.swing.JTextField ngrupos;
    public static javax.swing.JTable tablaequipos;
    // End of variables declaration//GEN-END:variables
}
