
package torneocronograma;

import Basededatos.Conexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import saceaf.Principal;
import torneodatoscronograma.competencia;
import torneodatoscronograma.datomodalidad;
import torneodatoscronograma.datoscompetencia;
import torneodatoscronograma.modalidad;


public final class crearcopa extends javax.swing.JPanel {
    DefaultComboBoxModel combo = new DefaultComboBoxModel();
    DefaultComboBoxModel combo2 = new DefaultComboBoxModel();
    DefaultComboBoxModel combo3 = new DefaultComboBoxModel();
    DefaultComboBoxModel combo4 = new DefaultComboBoxModel();
    DefaultComboBoxModel combo5 = new DefaultComboBoxModel();
   public crearcopa() {
        initComponents();
        activamejor();
        verificar();
        
    }
    int clasifica, grupos, mejor,total,rondas,ctrl,equiposxgrupo, clasificadosxgrupo, pasanmejor;
    int datogrupos,datoclasificaxgrupo,datosequiposgrupos,datomejor,datopasanmejor;
    String id_torneo, id_competencia, id_categoria,datopostfase,id_modalidad,nombre_modalidad,fase,idcruce,dcategoria,lsexo;
    public void activamejor(){
        if(rmejor.isSelected()==false){
            campomejor.setEnabled(false);
            numeromejor.setEnabled(false);
        }else{
            campomejor.setEnabled(true);
            numeromejor.setEnabled(true);
        }
    }
    public void activapostfase(){
        if(activafasefinal.isSelected()==true){
            combopostfase.setEnabled(true);
            rmejor.setEnabled(false);
            numeromejor.setEnabled(false);
            campomejor.setEnabled(false);
            dclasificaxgrupo.setEnabled(false);
            dequiposg.setEnabled(false);
            dgrupos.setEnabled(false);
            cargarpostfase();
            
        }else{
            combopostfase.setEnabled(false);
            combopostfase.removeAllItems();
            rmejor.setEnabled(false);
            dclasificaxgrupo.setEnabled(true);
            dequiposg.setEnabled(true);
            dgrupos.setEnabled(true);
            activamejor();
        }
    }
    public void cargarpostfase(){
        combopostfase.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select nombre_postfase from postfase;");
          combo.addElement("Seleccione la fase a jugar");
          combopostfase.setModel(combo);
          while(rs.next()){
              combo.addElement(rs.getObject("nombre_postfase"));
              combopostfase.setModel(combo);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(crearcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
    }
    public void contar(){
        clasifica=Integer.parseInt(dclasificaxgrupo.getSelectedItem().toString());
        grupos= Integer.parseInt(dgrupos.getSelectedItem().toString());
        if(rmejor.isSelected()==true){
        mejor=Integer.parseInt(numeromejor.getSelectedItem().toString());
        }else{
           mejor=0; 
        }
        total=(clasifica*grupos)+mejor;
        if(total==2){
        int opc=JOptionPane.showConfirmDialog(null,"Esta seguro que desea configurar la competencia de esa forma?","Informacion",JOptionPane.YES_NO_OPTION );
        if(opc==0){
        combo.addElement("Final");
        combopostfase.setModel(combo);
        guardardatos();
        abrirfinal();
        }
        }else
        if(total==4){
        int opc=JOptionPane.showConfirmDialog(null,"Esta seguro que desea configurar la competencia de esa forma?","Informacion",JOptionPane.YES_NO_OPTION );
        if(opc==0){
        combo.addElement("Semifinal");
        combopostfase.setModel(combo);
        guardardatos();
        abrirsemifinal();
        }
        }else
        if(total==8){
        int opc=JOptionPane.showConfirmDialog(null,"Esta seguro que desea configurar la competencia de esa forma?","Informacion",JOptionPane.YES_NO_OPTION );
        if(opc==0){
        combo.addElement("Cuartos de final");
        combopostfase.setModel(combo);
        guardardatos();    
        abrircuartos();
        }
        }else
        if(total==16){
        int opc=JOptionPane.showConfirmDialog(null,"Esta seguro que desea configurar la competencia de esa forma?","Informacion",JOptionPane.YES_NO_OPTION );
        if(opc==0){
        combo.addElement("Octavos de final");
        combopostfase.setModel(combo);
        guardardatos();
        abriroctavos();
        }    
        
        }else{
        JOptionPane.showMessageDialog(this,"El numero de clasificados a la siguiente fase\n"
        + "no corresponde a las fase establecidas.","Informacion",JOptionPane.INFORMATION_MESSAGE);
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
        String postfase=combopostfase.getSelectedItem().toString();
        if(null != postfase)switch (postfase) {
            case "Final":
                datopostfase="2";
                break;
            case "Semifinal":
                datopostfase="4";
                break;
            case "Cuartos de Final":
                datopostfase="8";
                break;
            case "Octavos de final":
                datopostfase="16";
                break;
        }
        try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(crearcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
        id_modalidad=id_torneo+id_categoria+"2";
        nombre_modalidad="Copa";
        id_competencia=id_modalidad+datopostfase;
        rondas=0;
        if(activafasefinal.isSelected()==true){
        try{
          datomodalidad user =new datomodalidad(id_modalidad,nombre_modalidad,id_categoria,datopostfase,id_torneo);
          modalidad in= new modalidad();
          boolean r;
          r=in.Insertar(user);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(crearcopa.class.getName()).log(Level.SEVERE,null,ex);
        }
            try{
          datoscompetencia user=new datoscompetencia(id_competencia,datogrupos,datoclasificaxgrupo,datosequiposgrupos,datomejor,datopasanmejor,id_modalidad,rondas);
          competencia in= new competencia();
          boolean r;
          r=in.Insertar(user);
          if(r==false){
              JOptionPane.showMessageDialog(this,"Guardado","Informacion",JOptionPane.INFORMATION_MESSAGE);
           dgrupos.setEnabled(false);
           dequiposg.setEnabled(false);
           dclasificaxgrupo.setEnabled(false);
           numeromejor.setEnabled(false);
           campomejor.setEnabled(false);
           rmejor.setEnabled(false);
           activafasefinal.setEnabled(false);
           combopostfase.setEnabled(false);
           bsiguientepostfase.setEnabled(false);
          }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(crearcopa.class.getName()).log(Level.SEVERE,null,ex);
        } 
        }else{
        datogrupos=Integer.parseInt(dgrupos.getSelectedItem().toString());
        datoclasificaxgrupo=Integer.parseInt(dclasificaxgrupo.getSelectedItem().toString());
        datosequiposgrupos=Integer.parseInt(dequiposg.getSelectedItem().toString());
        if(rmejor.isSelected()==true){
        datomejor=Integer.parseInt(campomejor.getText());
        datopasanmejor=Integer.parseInt(numeromejor.getSelectedItem().toString());  
        }else{
        datomejor=0;
        datopasanmejor=0;
        
        }
        try{
          datomodalidad user =new datomodalidad(id_modalidad,nombre_modalidad,id_categoria,datopostfase,id_torneo);
          modalidad in= new modalidad();
          boolean r;
          r=in.Insertar(user);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(crearcopa.class.getName()).log(Level.SEVERE,null,ex);
        }
            try{
          datoscompetencia user=new datoscompetencia(id_competencia,datogrupos,datoclasificaxgrupo,datosequiposgrupos,datomejor,datopasanmejor,id_modalidad,rondas);
          competencia in= new competencia();
          boolean r;
          r=in.Insertar(user);
          if(r==false){
              JOptionPane.showMessageDialog(this,"Guardado","Informacion",JOptionPane.INFORMATION_MESSAGE);
           dgrupos.setEnabled(false);
           dequiposg.setEnabled(false);
           dclasificaxgrupo.setEnabled(false);
           numeromejor.setEnabled(false);
           campomejor.setEnabled(false);
           rmejor.setEnabled(false);
           activafasefinal.setEnabled(false);
           combopostfase.setEnabled(false);
           bsiguientepostfase.setEnabled(false);
          }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(crearcopa.class.getName()).log(Level.SEVERE,null,ex);
        } 
        }
        
        
        
    }
    public void abrirfinal(){
       Final f= new Final();
       String titulo= "Final";
       int index= panelpostfase.indexOfTab(titulo);
       
       if (index== -1){
           panelpostfase.addTab(titulo, f);
           int i=panelpostfase.indexOfTab(titulo);
           panelpostfase.setSelectedIndex(i);
       }else{
           panelpostfase.remove(index);
           panelpostfase.addTab(titulo, f);
           int i=panelpostfase.indexOfTab(titulo);
           panelpostfase.setSelectedIndex(i);
       }

   } 
    public void abrirsemifinal(){
       Semifinal sf= new Semifinal();
       String titulo= "Semifinal";
       int index= panelpostfase.indexOfTab(titulo);
       
       if (index== -1){
           panelpostfase.addTab(titulo, sf);
           int i=panelpostfase.indexOfTab(titulo);
           panelpostfase.setSelectedIndex(i);
       }else{
           panelpostfase.remove(index);
           panelpostfase.addTab(titulo, sf);
           int i=panelpostfase.indexOfTab(titulo);
           panelpostfase.setSelectedIndex(i);
       }

   } 
    public void abrircuartos(){
       Cuartosdefinal cf= new Cuartosdefinal();
       String titulo= "Cuartos de Final";
       int index= panelpostfase.indexOfTab(titulo);
       
       if (index== -1){
           panelpostfase.addTab(titulo, cf);
           int i=panelpostfase.indexOfTab(titulo);
           panelpostfase.setSelectedIndex(i);
       }else{
           panelpostfase.remove(index);
           panelpostfase.addTab(titulo, cf);
           int i=panelpostfase.indexOfTab(titulo);
           panelpostfase.setSelectedIndex(i);
       }

   } 
    public void abriroctavos(){
       Octavosdefinal of= new Octavosdefinal();
       String titulo= "Octavos de Final";
       int index= panelpostfase.indexOfTab(titulo);
       
       if (index== -1){
           panelpostfase.addTab(titulo, of);
           int i=panelpostfase.indexOfTab(titulo);
           panelpostfase.setSelectedIndex(i);
       }else{
           panelpostfase.remove(index);
           panelpostfase.addTab(titulo, of);
           int i=panelpostfase.indexOfTab(titulo);
           panelpostfase.setSelectedIndex(i);
       }

   } 
    public void verificar(){
        String categoria=panelcrear.combocategoria.getSelectedItem().toString();
        lsexo=Principal.labelsexo.getText();
        try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+lsexo+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(crearcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
        id_torneo=Principal.labelserialtorneo.getText();
        id_modalidad=id_torneo+id_categoria+"2";
        try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select postfase from modalidad where id_modalidad='"+id_modalidad+"';");
          while(rs.first()){
          ctrl=2;
          datopostfase=rs.getString("postfase");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(crearcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
        if(ctrl==2){
            id_competencia=id_modalidad+datopostfase;
            try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select grupos, equiposxgrupo, clasificadosxgrupo,mejor, pasanmejor from competencia where id_competencia='"+id_competencia+"';");
          while(rs.first()){
          grupos=rs.getInt("grupos");
          equiposxgrupo=rs.getInt("equiposxgrupo");
          clasificadosxgrupo=rs.getInt("clasificadosxgrupo");
          mejor=rs.getInt("mejor");
          pasanmejor=rs.getInt("pasanmejor");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(crearcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
            dgrupos.setEnabled(false);
       dgrupos.removeAllItems();
       combo2.addElement(grupos);
       dgrupos.setModel(combo2); 
       dequiposg.setEnabled(false);
       dequiposg.removeAllItems();
       combo3.addElement(equiposxgrupo);
       dequiposg.setModel(combo3);
       dclasificaxgrupo.setEnabled(false);
       dclasificaxgrupo.removeAllItems();
       combo4.addElement(clasificadosxgrupo);
       dclasificaxgrupo.setModel(combo4);
       numeromejor.setEnabled(false);
       numeromejor.removeAllItems();
       combo5.addElement(pasanmejor);
       numeromejor.setModel(combo5);
       campomejor.setText(Integer.toString(mejor));
       campomejor.setEnabled(false);
       rmejor.setEnabled(false);
       activafasefinal.setEnabled(false);
       if(  null != datopostfase)switch (datopostfase) {
                case "2":
                    fase="Final";
                    combopostfase.removeAllItems();
                    combo.addElement(fase);
                    combopostfase.setModel(combo);
                    abrirfinal();
                    break;
                case "4":
                    fase="Semifinal";
                    combopostfase.removeAllItems();
                    combo.addElement(fase);
                    combopostfase.setModel(combo);
                    abrirsemifinal();
                    break;
                case "8":
                    fase="Cuartos de final";
                    combopostfase.removeAllItems();
                    combo.addElement(fase);
                    combopostfase.setModel(combo);
                    abrircuartos();
                    break;
                case "16":
                    fase="Octavos de final";
                    combopostfase.removeAllItems();
                    combo.addElement(fase);
                    combopostfase.setModel(combo);
                    abriroctavos(); 
                    break;
            } 
       crearcopa.combopostfase.setEnabled(false);
        }
       
       
    }
    public void verificarmejor(){
        try{
        grupos=Integer.parseInt(dgrupos.getSelectedItem().toString());
        pasanmejor=Integer.parseInt(numeromejor.getSelectedItem().toString());
        
        if(pasanmejor<=grupos){
            bsiguientepostfase.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(this,"La cantidad opcional de mejores clasificados es mayor que la de los grupos, por favor rectifique","Informacion",JOptionPane.INFORMATION_MESSAGE);
            bsiguientepostfase.setEnabled(false);
        }
        }catch(Exception e ){
            
        }
    }
    public void abrirpanel(){
        ctrl=0;
         dcategoria=panelcrear.combocategoria.getSelectedItem().toString();
         id_torneo=Principal.labelserialtorneo.getText();
         datopostfase=combopostfase.getSelectedItem().toString();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+dcategoria+"';");
          while(rs.first()){
          id_categoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(crearcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
          idcruce=id_torneo+id_categoria+"2"+"1";
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select letra_grupo1,numero_clasificado1,letra_grupo2,numero_clasificado2"
                  + " from crucepostfase where id_crucepostfase='"+idcruce+"';");
          while(rs.first()){
          ctrl=2;
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(crearcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(ctrl==2){
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
         abrirequiposcopa();
       }catch(Exception e){
           
       }
          }else{
        if("Final".equals(datopostfase)){
           Final.guardardatos();
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
          abrirequiposcopa();
        }catch(Exception e){
           
        }
        }else
        if("Semifinal".equals(datopostfase)){
          Semifinal.guardardatos();
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
          abrirequiposcopa();
        }catch(Exception e){
           
        }
        }else
        if("Cuartos de final".equals(datopostfase)){
           Cuartosdefinal.guardardatos();
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
           abrirequiposcopa();
        }catch(Exception e){
           
        }
        }else
        if("Octavos de final".equals(datopostfase)){
           Octavosdefinal.guardardatos();
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
           abrirequiposcopa();
        }catch(Exception e){
           
        }
        }
        }
    }
    public void abrirequiposcopa(){
       equiposcopa ec= new equiposcopa();
       String titulo= "Copa";
       int index= panelcrear.panelmodalidades.indexOfTab(titulo);
       
       if (index== -1){
           panelcrear.panelmodalidades.addTab(titulo, ec);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }else{
           panelcrear.panelmodalidades.remove(index);
           panelcrear.panelmodalidades.addTab(titulo, ec);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }

   } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dequiposg = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        rmejor = new javax.swing.JRadioButton();
        panelpostfase = new javax.swing.JTabbedPane();
        bsiguienteeq = new javax.swing.JButton();
        dclasificaxgrupo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        campomejor = new javax.swing.JTextField();
        combopostfase = new javax.swing.JComboBox();
        activafasefinal = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        bsiguientepostfase = new javax.swing.JButton();
        dgrupos = new javax.swing.JComboBox();
        numeromejor = new javax.swing.JComboBox();

        setMinimumSize(new java.awt.Dimension(860, 270));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(860, 270));
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Grupos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Equipos por Grupo");

        dequiposg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "4", "5", "6", "7", "8", "9", "10", "11", "14", "16", "18", "20" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Clasifica por grupo");

        rmejor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmejorActionPerformed(evt);
            }
        });

        panelpostfase.setMinimumSize(new java.awt.Dimension(561, 248));
        panelpostfase.setPreferredSize(new java.awt.Dimension(561, 248));

        bsiguienteeq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/flecha 2 30x30.png"))); // NOI18N
        bsiguienteeq.setContentAreaFilled(false);
        bsiguienteeq.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/flecha 2 40x40.png"))); // NOI18N
        bsiguienteeq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsiguienteeqActionPerformed(evt);
            }
        });

        dclasificaxgrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Mejor");

        activafasefinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activafasefinalActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Postfase de Grupo");

        bsiguientepostfase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/flecha 2 30x30.png"))); // NOI18N
        bsiguientepostfase.setContentAreaFilled(false);
        bsiguientepostfase.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/flecha 2 40x40.png"))); // NOI18N
        bsiguientepostfase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsiguientepostfaseActionPerformed(evt);
            }
        });

        dgrupos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));

        numeromejor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
        numeromejor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeromejorActionPerformed(evt);
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
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(dgrupos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(rmejor)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(numeromejor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(dclasificaxgrupo, 0, 40, Short.MAX_VALUE)
                                            .addComponent(campomejor, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                            .addComponent(dequiposg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(activafasefinal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(combopostfase, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(bsiguientepostfase)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(panelpostfase, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bsiguienteeq))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dgrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dequiposg, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dclasificaxgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campomejor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numeromejor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rmejor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(activafasefinal)
                    .addComponent(combopostfase, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bsiguientepostfase)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bsiguienteeq)
                .addGap(200, 200, 200))
            .addComponent(panelpostfase, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
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

    private void rmejorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmejorActionPerformed
       activamejor();
    }//GEN-LAST:event_rmejorActionPerformed

    private void activafasefinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activafasefinalActionPerformed
        activapostfase();
    }//GEN-LAST:event_activafasefinalActionPerformed

    private void bsiguientepostfaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsiguientepostfaseActionPerformed
        contar();
    }//GEN-LAST:event_bsiguientepostfaseActionPerformed

    private void bsiguienteeqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsiguienteeqActionPerformed
        abrirpanel();
    }//GEN-LAST:event_bsiguienteeqActionPerformed

    private void numeromejorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeromejorActionPerformed
        verificarmejor();
    }//GEN-LAST:event_numeromejorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JRadioButton activafasefinal;
    public static javax.swing.JButton bsiguienteeq;
    public static javax.swing.JButton bsiguientepostfase;
    public static javax.swing.JTextField campomejor;
    public static javax.swing.JComboBox combopostfase;
    public static javax.swing.JComboBox dclasificaxgrupo;
    public static javax.swing.JComboBox dequiposg;
    public static javax.swing.JComboBox dgrupos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JComboBox numeromejor;
    public static javax.swing.JTabbedPane panelpostfase;
    public static javax.swing.JRadioButton rmejor;
    // End of variables declaration//GEN-END:variables
}
