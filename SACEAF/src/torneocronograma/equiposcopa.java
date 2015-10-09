
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
import torneodatoscronograma.datosnumeroeq;
import torneodatoscronograma.equiponumero;


public final class equiposcopa extends javax.swing.JPanel {

    static DefaultTableModel modelo= new DefaultTableModel();
    DefaultComboBoxModel combo=new DefaultComboBoxModel();
    int datogrupos,datoclasificaxgrupo,datosequiposgrupos,datomejor,datopasanmejor,cont,
        idnumero,numeroeq,ctrl,ronda,exg, grupos;
    String id_torneo, id_competencia, id_categoria,datopostfase,id_modalidad,nombre_modalidad,idhequipo,
           idequipob,idbuscar,idtorneo,categoria,letrag,id_club,idcategoria,grupo,idcompetencia,
            idmodalidad,postfase,sexo;

    
    
    public equiposcopa() {
        initComponents();
        cargarequipos();
        labelserial.setVisible(false);
        cargarcombo();
        bsiguiente.setEnabled(false);
        activarsiguiente();
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
            modelo= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("c.nombre_club");
               registro [1]=rs.getString("e.identificador");
               
               modelo.addRow(registro);
            }
            tablaequipos.setModel(modelo);
            tablaequipos.getColumnModel().getColumn(0).setPreferredWidth(120);
            tablaequipos.getColumnModel().getColumn(1).setPreferredWidth(120);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            tablaequipos.setRowSorter(modeloordenado);
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE, null, ex);
                }
     }
    public void agregarequipo(){
        String nombre=(String)tablaequipos.getValueAt(tablaequipos.getSelectedRow(),0);
        String identificador=(String)tablaequipos.getValueAt(tablaequipos.getSelectedRow(),1);
        categoria= panelcrear.combocategoria.getSelectedItem().toString();
        labelserial.setText("");
        id_torneo=Principal.labelserialtorneo.getText();
        ctrl=0;
        idequipob=null;
        letrag=null;
        id_club=null;


        try{ 
            String sql="Select id_categoria from categoria where nombre_cat= '"+categoria+"' and sexo='Masculino';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            idcategoria=rs.getString("id_categoria");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE, null, ex);
            }
        try{ 
            String sql="Select id_club from club where nombre_club= '"+nombre+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            id_club=rs.getString("id_club");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE, null, ex);
            }
     try{ 
            String sql="Select e.id_equipo from club c, equipo e where e.id_club='"+id_club+"' and e.id_categoria='"+idcategoria+"' and e.identificador='"+identificador+"';";
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
            Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE, null, ex);
            }
     String agarra=labelserial.getText();
     try{
            String sql="Select numero_eq, grupo_equipo from h_equipo where id_equipo='"+agarra+"' and id_torneo='"+id_torneo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
                idnumero=rs.getInt("numero_eq");
                letrag=rs.getString("grupo_equipo");
                break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE,null,ex);
            }
     if(idnumero==0){
       campoequipo.setText(nombre+" "+identificador);
        }else{
         labelserial.setText("");
            JOptionPane.showMessageDialog(null,"El equipo ya posee el grupo y su numero asignado.\n"
                    + "Se encuentra en el grupo:"+letrag+" y su numero es el "+idnumero+". Por favor seleccione otro." ,"Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
     
    }
    public void activarsiguiente(){
        categoria= panelcrear.combocategoria.getSelectedItem().toString();
        idtorneo= Principal.labelserialtorneo.getText();
        try{ 
            String sql="Select id_categoria from categoria where nombre_cat= '"+categoria+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            idcategoria=rs.getString("id_categoria");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE, null, ex);
            }
        try{ 
            String sql="Select he.posicion, c.nombre_club, e.identificador from club c, equipo e, h_equipo he where c.id_club=e.id_club and e.id_categoria='"+idcategoria+"' and he.id_equipo=e.id_equipo and he.id_torneo='"+idtorneo+"' and he.grupo_equipo='A' order by he.posicion;";
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
            Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(ctrl==2){
            bsiguiente.setEnabled(true);
        }
    }
    public void guardarN(){
        idbuscar=null;
        idtorneo=null;
        idnumero=0;
        ctrl=0;
        idbuscar=labelserial.getText();
        idtorneo= Principal.labelserialtorneo.getText();
        categoria=panelcrear.combocategoria.getSelectedItem().toString();
        numeroeq=Integer.parseInt(camponumeroeq.getText());
        idhequipo=idtorneo+idbuscar;
        grupo=combo1.getSelectedItem().toString();
        
        try{
            String sql="Select he.numero_eq from equipo e, h_equipo he where he.id_torneo='"+idtorneo+"' and e.id_categoria=(Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='Masculino') and he.grupo_equipo='"+grupo+"' and he.numero_eq='"+numeroeq+"' and e.id_equipo=he.id_equipo;";
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
                Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE, null, ex);
                }
        categoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
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
          Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
          idmodalidad=id_torneo+id_categoria+"2";
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select postfase from modalidad where id_modalidad='"+idmodalidad+"';");
          while(rs.first()){
          postfase=rs.getString("postfase");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
          idcompetencia=idmodalidad+postfase;
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select equiposxgrupo from competencia where id_competencia='"+idcompetencia+"';");
          while(rs.first()){
          exg=rs.getInt("equiposxgrupo");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
        if(ctrl==2){
            JOptionPane.showMessageDialog(this,"El numero que quiere asignar ya lo asigno a otro equipo.\n"
                    + "Por favor agregue otro numero para identificar al equipo", "Informacion",JOptionPane.INFORMATION_MESSAGE);
            camponumeroeq.setText("");
            campoequipo.setText("");
            labelserial.setText("");
        }else
        if(numeroeq>exg){
            JOptionPane.showMessageDialog(this,"El numero que quiere asignar es mayor que el numero de equipos permitido por grupo.\n"
                    + "Por favor agregue otro numero para identificar al equipo", "Informacion",JOptionPane.INFORMATION_MESSAGE);
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
            bsiguiente.setEnabled(true);
            }

            }catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
            }catch(ClassNotFoundException ex){
                Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        
            
        
    }
    public void abrirungrupo(){
       ungrupo ug= new ungrupo();
       String titulo= "Copa";
       int index= panelcrear.panelmodalidades.indexOfTab(titulo);
       
       if (index== -1){
           panelcrear.panelmodalidades.addTab(titulo, ug);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }else{
           panelcrear.panelmodalidades.remove(index);
           panelcrear.panelmodalidades.addTab(titulo, ug);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }

   }
    public void abrirdosgrupos(){
       dosgrupos dg= new dosgrupos();
       String titulo= "Copa";
       int index= panelcrear.panelmodalidades.indexOfTab(titulo);
       
       if (index== -1){
           panelcrear.panelmodalidades.addTab(titulo, dg);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }else{
           panelcrear.panelmodalidades.remove(index);
           panelcrear.panelmodalidades.addTab(titulo, dg);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }

   }
    public void abrirtresgrupos(){
       tresgrupos tg= new tresgrupos();
       String titulo= "Copa";
       int index= panelcrear.panelmodalidades.indexOfTab(titulo);
       
       if (index== -1){
           panelcrear.panelmodalidades.addTab(titulo, tg);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }else{
           panelcrear.panelmodalidades.remove(index);
           panelcrear.panelmodalidades.addTab(titulo, tg);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }

   }
    public void abrircuatrogrupos(){
       cuatrogrupos cg= new cuatrogrupos();
       String titulo= "Copa";
       int index= panelcrear.panelmodalidades.indexOfTab(titulo);
       
       if (index== -1){
           panelcrear.panelmodalidades.addTab(titulo, cg);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }else{
           panelcrear.panelmodalidades.remove(index);
           panelcrear.panelmodalidades.addTab(titulo, cg);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }

   }
    public void abrircrearcopa(){
       crearcopa dg= new crearcopa();
       String titulo= "Copa";
       int index= panelcrear.panelmodalidades.indexOfTab(titulo);
       
       if (index== -1){
           panelcrear.panelmodalidades.addTab(titulo, dg);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }else{
           panelcrear.panelmodalidades.remove(index);
           panelcrear.panelmodalidades.addTab(titulo, dg);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }

   }
    public void cargarcombo(){
          categoria=panelcrear.combocategoria.getSelectedItem().toString();
         idtorneo=Principal.labelserialtorneo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"';");
          while(rs.first()){
          idcategoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
          idmodalidad=idtorneo+idcategoria+"2";
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select postfase from modalidad where id_modalidad='"+idmodalidad+"';");
          while(rs.first()){
          postfase=rs.getString("postfase");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
          idcompetencia=idmodalidad+postfase;
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select grupos from competencia where id_competencia='"+idcompetencia+"';");
          while(rs.first()){
          grupos=rs.getInt("grupos");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(grupos!=0){
          combo1.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_variable from variables"+grupos+";");
          while(rs.next()){
              combo.addElement(rs.getObject("id_variable"));
              combo1.setModel(combo);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void abrirpanel(){
        categoria=panelcrear.combocategoria.getSelectedItem().toString();
         idtorneo=Principal.labelserialtorneo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"';");
          while(rs.first()){
          idcategoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
          idmodalidad=idtorneo+idcategoria+"2";
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select postfase from modalidad where id_modalidad='"+idmodalidad+"';");
          while(rs.first()){
          postfase=rs.getString("postfase");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
          idcompetencia=idmodalidad+postfase;
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select grupos from competencia where id_competencia='"+idcompetencia+"';");
          while(rs.first()){
          grupos=rs.getInt("grupos");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(equiposcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(grupos==1){
          abrirungrupo();
          }else
              if(grupos==2){
                  abrirdosgrupos();
              }else
                  if(grupos==3){
                      abrirtresgrupos();
                  }else
                      if(grupos==4){
                          abrircuatrogrupos();
                      }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaequipos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        campoequipo = new javax.swing.JTextField();
        bagregar = new javax.swing.JButton();
        camponumeroeq = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bguardar = new javax.swing.JButton();
        labelserial = new javax.swing.JLabel();
        bsiguiente = new javax.swing.JButton();
        combo1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        batras = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(860, 270));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(860, 270));
        jPanel1.setOpaque(false);

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
        tablaequipos.setOpaque(false);
        jScrollPane1.setViewportView(tablaequipos);

        campoequipo.setEnabled(false);

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("N° equipo");

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

        labelserial.setEnabled(false);

        bsiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/flecha 2 30x30.png"))); // NOI18N
        bsiguiente.setText("Siguiente");
        bsiguiente.setContentAreaFilled(false);
        bsiguiente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bsiguiente.setIconTextGap(-2);
        bsiguiente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/flecha 2 40x40.png"))); // NOI18N
        bsiguiente.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bsiguiente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsiguienteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Grupo");

        batras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/flechaIzquierda 30x30.png"))); // NOI18N
        batras.setText("Atras");
        batras.setContentAreaFilled(false);
        batras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        batras.setIconTextGap(-2);
        batras.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/flechaIzquierda 40x40.png"))); // NOI18N
        batras.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        batras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        batras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(batras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bagregar)
                .addGap(18, 18, 18)
                .addComponent(campoequipo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelserial, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(camponumeroeq, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bguardar)
                    .addComponent(bsiguiente))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bsiguiente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bagregar)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(camponumeroeq, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoequipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(labelserial, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(54, 54, 54)
                                    .addComponent(bguardar))))))
                .addGap(0, 28, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(batras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        try{
            guardarN();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Debe seleccionar un equipo de la tabla\n"
                    + "para poder agregarle el numero identificador","Informacion",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bguardarActionPerformed

    private void bagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagregarActionPerformed
        try{
            agregarequipo();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Debe seleccionar un equipo de la tabla\n"
                    + "para poder agregarle el numero identificador","Informacion",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bagregarActionPerformed

    private void bsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsiguienteActionPerformed
    abrirpanel();
    }//GEN-LAST:event_bsiguienteActionPerformed

    private void batrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batrasActionPerformed
        try{
       int tamano=panelcrear.panelmodalidades.getTabCount();
        for(int i=0;i<=tamano;i++){
                 panelcrear.panelmodalidades.remove(i);
                 i--;
                 tamano=panelcrear.panelmodalidades.getTabCount(); 
                 if( tamano== 0){
                     break;
                 } 
                 }
         abrircrearcopa();
       }catch(Exception e){
           
       }
    }//GEN-LAST:event_batrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bagregar;
    public static javax.swing.JButton batras;
    public static javax.swing.JButton bguardar;
    public static javax.swing.JButton bsiguiente;
    public static javax.swing.JTextField campoequipo;
    public static javax.swing.JTextField camponumeroeq;
    public static javax.swing.JComboBox combo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel labelserial;
    public static javax.swing.JTable tablaequipos;
    // End of variables declaration//GEN-END:variables
}
