
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
import torneodatosadm.datoformulariogoles;
import torneodatosadm.formulariogoles;
import torneodatoscronograma.datofechajuego;
import torneodatoscronograma.datoformulario2;
import torneodatoscronograma.fecha_juego;
import torneodatoscronograma.formulario2;


public class pformulariogoles extends javax.swing.JPanel {

    DefaultComboBoxModel combo= new DefaultComboBoxModel();
    DefaultComboBoxModel combo2= new DefaultComboBoxModel();
    DefaultTableModel modelo;
    DefaultTableModel modelo1;
    String jornada,nombre_juego,hlocal,idjuego,categoria,idcategoria,idtorneo, hvisitante, sexo,nombrelocal,nombrevisitante,identificadorlocal,identificadorvisitante;
    String dia,mes,year,fecha_juego;
    String nombre, apellido,cedula,idhjugador,idformulario,formulariotitular,id_fgoles,id_hequipo;
    int numero,minuto,marcador_local,marcador_visitante,golesj,golese;
    int pstl,dgl,goleslc,goleslf,perdl,empl,ganal,pjl;
    int pstv,dgv,golesvc,golesvf,perdv,empv,ganav,pjv;
    public pformulariogoles() {
        initComponents();
        cargardatos();
        labelserial.setVisible(false);

    }

   
    public void cargarlocal(){
        idjuego= panelresultados.labelserialformulario.getText();
        hlocal=panelresultados.labelequipolocal.getText();
          combonumero.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select ft.numero_jugador ,j.cedula, j.nombre_j, j.apellido_j from formulariotitular ft, formulario f,jugador j, h_jugador hj where hj.cedula=j.cedula and ft.id_formulario='"+idjuego+"' and hj.id_hequipo='"+hlocal+"' and f.id_formulario='"+idjuego+"' and f.id_formulario=ft.id_formulario and ft.id_hjugador=hj.id_hjugador order by ft.numero_jugador;");
          while(rs.next()){
              combo.addElement(rs.getObject("ft.numero_jugador"));
              combonumero.setModel(combo);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(panelresultados.class.getName()).log(Level.SEVERE,null,ex);
          }
  }
    public void cargarvisitante(){
        idjuego= panelresultados.labelserialformulario.getText();
        hlocal=panelresultados.labelequipovisitante.getText();
          combonumero.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select ft.numero_jugador ,j.cedula, j.nombre_j, j.apellido_j from formulariotitular ft, formulario f,jugador j, h_jugador hj where hj.cedula=j.cedula and ft.id_formulario='"+idjuego+"' and hj.id_hequipo='"+hlocal+"' and f.id_formulario='"+idjuego+"' and f.id_formulario=ft.id_formulario and ft.id_hjugador=hj.id_hjugador order by ft.numero_jugador;");
          while(rs.next()){
              combo.addElement(rs.getObject("ft.numero_jugador"));
              combonumero.setModel(combo);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(panelresultados.class.getName()).log(Level.SEVERE,null,ex);
          }
  }
    public void cargardatos(){
        hlocal=panelresultados.labelequipolocal.getText();
        try{ 
            String sql="Select c.nombre_club, e.identificador from club c,equipo e, h_equipo he where he.id_hequipo= '"+hlocal+"' and he.id_equipo=e.id_equipo and e.id_club=c.id_club;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            nombrelocal=rs.getNString("c.nombre_club");
            identificadorlocal=rs.getNString("e.identificador");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE, null, ex);
            }
       rnombrelocal.setText(nombrelocal+" "+identificadorlocal);
       hvisitante=panelresultados.labelequipovisitante.getText();
        try{ 
            String sql="Select c.nombre_club, e.identificador from club c,equipo e, h_equipo he where he.id_hequipo= '"+hvisitante+"' and he.id_equipo=e.id_equipo and e.id_club=c.id_club;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            nombrevisitante=rs.getNString("c.nombre_club");
            identificadorvisitante=rs.getNString("e.identificador");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE, null, ex);
            }
        rnombrevisitante.setText(nombrevisitante+" "+identificadorvisitante);
    }
    public void cargarjugadorvisitante(){
    idjuego= panelresultados.labelserialformulario.getText();
    hvisitante=panelresultados.labelequipovisitante.getText();
    numero=Integer.parseInt(combonumero.getSelectedItem().toString());
     try{ 
            String sql="Select ft.numero_jugador ,hj.id_hjugador, j.nombre_j, j.apellido_j from formulariotitular ft, formulario f,jugador j, h_jugador hj where hj.cedula=j.cedula and ft.id_formulario='"+idjuego+"' and hj.id_hequipo='"+hvisitante+"' and f.id_formulario='"+idjuego+"' and f.id_formulario=ft.id_formulario and ft.id_hjugador=hj.id_hjugador and ft.numero_jugador='"+numero+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            nombre=rs.getNString("j.nombre_j");
            apellido=rs.getNString("j.apellido_j");
            cedula=rs.getNString("hj.id_hjugador");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE, null, ex);
            }
     camponombre.setText(nombre+" "+apellido);
     labelserial.setText(cedula);
    }
    public void cargarjugadorlocal(){
        idjuego= panelresultados.labelserialformulario.getText();
    hlocal=panelresultados.labelequipolocal.getText();
    numero=Integer.parseInt(combonumero.getSelectedItem().toString());
     try{ 
            String sql="Select ft.numero_jugador ,hj.id_hjugador, j.nombre_j, j.apellido_j from formulariotitular ft, formulario f,jugador j, h_jugador hj where hj.cedula=j.cedula and ft.id_formulario='"+idjuego+"' and hj.id_hequipo='"+hlocal+"' and f.id_formulario='"+idjuego+"' and f.id_formulario=ft.id_formulario and ft.id_hjugador=hj.id_hjugador and ft.numero_jugador='"+numero+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            nombre=rs.getNString("j.nombre_j");
            apellido=rs.getNString("j.apellido_j");
            cedula=rs.getNString("hj.id_hjugador");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE, null, ex);
            }
     camponombre.setText(nombre+" "+apellido);
     labelserial.setText(cedula);
    }
    public void guardar(){
        
        if(rnombrelocal.isSelected()==true){
          id_hequipo=panelresultados.labelequipolocal.getText();  
        }else{
          id_hequipo=panelresultados.labelequipovisitante.getText();
        }
        idhjugador=labelserial.getText();
        numero=Integer.parseInt(combonumero.getSelectedItem().toString());
        minuto=Integer.parseInt(campominuto.getText());
        marcador_local=Integer.parseInt(marcadorlocal.getText());
        marcador_visitante=Integer.parseInt(marcadorvisitante.getText());
        idformulario=panelresultados.labelserialformulario.getText();
        if(rnombrelocal.isSelected()==true){
            id_fgoles=idformulario+id_hequipo+idhjugador+marcador_local;
        }else{
         id_fgoles=idformulario+id_hequipo+idhjugador+marcador_visitante;
        }
        
        try{ 
            String sql="Select goles from h_jugador where id_hjugador='"+idhjugador+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            golesj=rs.getInt("goles");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE, null, ex);
            }
        try{ 
            String sql="Select equipo_goles from h_equipo where id_hequipo='"+id_hequipo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            golese=rs.getInt("equipo_goles");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE, null, ex);
            }
        golesj=golesj+1;
        golese=golese+1;
        try{
            datoformulariogoles user=new datoformulariogoles(id_hequipo,idhjugador,numero,minuto,marcador_local,marcador_visitante,idformulario,id_fgoles,golesj,golese);
            formulariogoles in =new formulariogoles();
            boolean r;
            r=in.Insertar(user);
            if(r==false){
                JOptionPane.showMessageDialog(this,"Guardado","Informacion",JOptionPane.INFORMATION_MESSAGE);
                int opc=JOptionPane.showConfirmDialog(null,"Desea registrar otro gol?","Informacion", JOptionPane.YES_NO_OPTION);
                if(opc==0){
                    
                    rnombrelocal.setSelected(true);
                    campominuto.setText("");
                    camponombre.setText("");
                    marcadorlocal.setText("");
                    marcadorvisitante.setText("");
                    labelserial.setText("");
                    cargarlocal();
                }else{
                     try{
       int tamano=panelresultados.panelresultado.getTabCount();
        for(int i=0;i<=tamano;i++){
                 panelresultados.panelresultado.remove(i);
                 i--;
                 tamano=panelresultados.panelresultado.getTabCount(); 
                 if( tamano== 0){
                     break;
                 } 
                 }
       
       }catch(Exception e){
           
       }
        
                }
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(pformulariogoles.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void guardarfinal(){
        idformulario=panelresultados.labelserialformulario.getText();
        try{ 
            String sql="Select marcador_local,marcador_visitante from formulariogoles where id_formulario='"+idformulario+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            marcador_local=rs.getInt("marcador_local");
            marcador_visitante=rs.getInt("marcador_visitante");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(marcador_local>marcador_visitante){
            hlocal=panelresultados.labelequipolocal.getText();
            try{ 
            String sql="Select partidos_jugados,partidos_ganados,partidos_empatados,partidos_perdidos,goles_favor,goles_contra,diferencia_goles, puntos from posiciones where id_hequipo='"+hlocal+"' and;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            marcador_local=rs.getInt("marcador_local");
            marcador_visitante=rs.getInt("marcador_visitante");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
        if(marcador_visitante>marcador_local){
            
        }else
        if(marcador_visitante==marcador_local){
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bsiguiente = new javax.swing.JButton();
        rnombrelocal = new javax.swing.JRadioButton();
        rnombrevisitante = new javax.swing.JRadioButton();
        combonumero = new javax.swing.JComboBox();
        camponombre = new javax.swing.JTextField();
        campominuto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        marcadorlocal = new javax.swing.JTextField();
        marcadorvisitante = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelserial = new javax.swing.JLabel();
        bguardar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(860, 270));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(860, 270));
        jPanel1.setOpaque(false);

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

        rnombrelocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rnombrelocalActionPerformed(evt);
            }
        });

        rnombrevisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rnombrevisitanteActionPerformed(evt);
            }
        });

        combonumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combonumeroActionPerformed(evt);
            }
        });

        camponombre.setEditable(false);
        camponombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        camponombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camponombreActionPerformed(evt);
            }
        });

        campominuto.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Minuto");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Identificacion del jugador");

        marcadorlocal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Resultado");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("x");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rnombrelocal)
                    .addComponent(rnombrevisitante))
                .addGap(120, 120, 120)
                .addComponent(combonumero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(camponombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(campominuto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(marcadorlocal, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(25, 25, 25)
                        .addComponent(marcadorvisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(jLabel3)
                        .addGap(71, 71, 71)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bsiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(bguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelserial, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(407, 407, 407))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rnombrelocal)
                                .addGap(27, 27, 27)
                                .addComponent(rnombrevisitante))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(combonumero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(camponombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campominuto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(17, 17, 17)
                        .addComponent(labelserial, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(marcadorlocal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(marcadorvisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bsiguiente))))
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

    private void bsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsiguienteActionPerformed
        
        try{
       int tamano=panelresultados.panelresultado.getTabCount();
        for(int i=0;i<=tamano;i++){
                 panelresultados.panelresultado.remove(i);
                 i--;
                 tamano=panelresultados.panelresultado.getTabCount(); 
                 if( tamano== 0){
                     break;
                 } 
                 }
       
       }catch(Exception e){
           
       }
        
    }//GEN-LAST:event_bsiguienteActionPerformed

    private void combonumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combonumeroActionPerformed
       if(rnombrelocal.isSelected()==true){
           cargarjugadorlocal();
       }else{
           cargarjugadorvisitante();
       }
    }//GEN-LAST:event_combonumeroActionPerformed

    private void camponombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camponombreActionPerformed
       
    }//GEN-LAST:event_camponombreActionPerformed

    private void rnombrelocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rnombrelocalActionPerformed
      rnombrevisitante.setSelected(false);

        if(rnombrelocal.isSelected()==true){
           cargarlocal();
       }else{
           cargarvisitante();
       }
    }//GEN-LAST:event_rnombrelocalActionPerformed

    private void rnombrevisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rnombrevisitanteActionPerformed
        rnombrelocal.setSelected(false);

        if(rnombrelocal.isSelected()==true){
           cargarlocal();
       }else{
           cargarvisitante();
       }
    }//GEN-LAST:event_rnombrevisitanteActionPerformed

    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        guardar();
    }//GEN-LAST:event_bguardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bguardar;
    public static javax.swing.JButton bsiguiente;
    public static javax.swing.JTextField campominuto;
    public static javax.swing.JTextField camponombre;
    public static javax.swing.JComboBox combonumero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JPanel jPanel1;
    private static javax.swing.JLabel labelserial;
    public static javax.swing.JTextField marcadorlocal;
    public static javax.swing.JTextField marcadorvisitante;
    public static javax.swing.JRadioButton rnombrelocal;
    public static javax.swing.JRadioButton rnombrevisitante;
    // End of variables declaration//GEN-END:variables
}
