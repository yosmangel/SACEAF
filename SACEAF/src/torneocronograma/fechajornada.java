
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


public class fechajornada extends javax.swing.JPanel {

    static DefaultTableModel modelo= new DefaultTableModel();
    static DefaultComboBoxModel combo= new DefaultComboBoxModel();
    static int datogrupos;
    String id_torneo, id_competencia,grupo,id_juego, id_categoria,datopostfase,nombre_modalidad,sexo,
            clublocal,clubvisitante,hlocal,hvisitante,idequipolocal,idequipovisitante, idequipob,idbuscar,
            idtorneo,categoria,jornada,letrag,id_club,idcategoria,nombre_local,identificador_local,nombre_visitante,
            identificador_visitante;
    int idnumero,numeroeq,ctrl,ronda;
    static String ncategoria, lsexo,serialtorneo,cidcategoria,letragrupo,id_modalidad; 
    
    public fechajornada() {
        initComponents();
        cargarcombo();
        cargarequipos();

    }


    public static void cargarequipos(){
       
        ncategoria= modificarcalendario.combocategoria.getSelectedItem().toString();
        serialtorneo= Principal.labelserialtorneo.getText();
        lsexo=Principal.labelsexo.getText();
        letragrupo=fechajornada.combogrupo.getSelectedItem().toString();
        try{ 
            String sql="Select id_categoria from categoria where nombre_cat= '"+ncategoria+"' and sexo='"+lsexo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            cidcategoria=rs.getString("id_categoria");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE, null, ex);
            }
     try{
            String[] titulos={"Jornada","Equipo local"," ","Equipo visitante"," "};
            String[] registro= new String[5];
            String sql="Select j.jornada , c.nombre_club, e.identificador ,cc.nombre_club, ee.identificador from club c, equipo e, h_equipo he,juego j,club cc, equipo ee, h_equipo hee,juego jj where j.equipo_local=he.id_hequipo and he.id_equipo=e.id_equipo and e.id_club=c.id_club and jj.equipo_visitante=hee.id_hequipo and hee.id_equipo=ee.id_equipo and ee.id_club=cc.id_club and j.id_torneo='"+serialtorneo+"' and jj.id_torneo='"+serialtorneo+"' and j.grupo='"+letragrupo+"' and jj.id_juego=j.id_juego and j.id_categoria='"+cidcategoria+"' order by j.jornada;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("j.jornada");
               registro [1]=rs.getString("c.nombre_club");
               registro [2]=rs.getString("e.identificador");
               registro [3]=rs.getString("cc.nombre_club");
               registro [4]=rs.getString("ee.identificador");
               modelo.addRow(registro);
            }
            tablacruces.setModel(modelo);
            tablacruces.getColumnModel().getColumn(0).setPreferredWidth(77);
            tablacruces.getColumnModel().getColumn(1).setPreferredWidth(160);
            tablacruces.getColumnModel().getColumn(2).setPreferredWidth(70);
            tablacruces.getColumnModel().getColumn(3).setPreferredWidth(160);
            tablacruces.getColumnModel().getColumn(4).setPreferredWidth(70);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            tablacruces.setRowSorter(modeloordenado);
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public static void cargarcombo(){
          
          fechajornada.combogrupo.removeAll();
          ncategoria=modificarcalendario.combocategoria.getSelectedItem().toString();
          serialtorneo=Principal.labelserialtorneo.getText();
          lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+ncategoria+"' and sexo='"+lsexo+"';");
          while(rs.first()){
          cidcategoria=rs.getString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE,null,ex);
          }
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_modalidad from modalidad where id_categoria='"+cidcategoria+"' and id_torneo='"+serialtorneo+"';");
          while(rs.first()){
          id_modalidad=rs.getString("id_modalidad");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE,null,ex);
          }
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select grupos from competencia where id_modalidad='"+id_modalidad+"';");
          while(rs.first()){
          datogrupos=rs.getInt("grupos");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(datogrupos!=0){
          combogrupo.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_variable from variables"+datogrupos+";");
          while(rs.next()){
              combo.addElement(rs.getObject("id_variable"));
              combogrupo.setModel(combo);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void buscarid(){
        jornada="";
        nombre_local="";
        identificador_local="";
        nombre_visitante="";
        identificador_visitante="";
        categoria="";
        sexo="";
        grupo="";
        ctrl=0;
        jornada=(String) fechajornada.tablacruces.getValueAt(fechajornada.tablacruces.getSelectedRow(),0);
        nombre_local=(String) fechajornada.tablacruces.getValueAt(fechajornada.tablacruces.getSelectedRow(),1);
        identificador_local=(String) fechajornada.tablacruces.getValueAt(fechajornada.tablacruces.getSelectedRow(),2);
        nombre_visitante=(String) fechajornada.tablacruces.getValueAt(fechajornada.tablacruces.getSelectedRow(),3);
        identificador_visitante=(String) fechajornada.tablacruces.getValueAt(fechajornada.tablacruces.getSelectedRow(),4);
        categoria=modificarcalendario.combocategoria.getSelectedItem().toString();
        sexo=Principal.labelsexo.getText();
        grupo=combogrupo.getSelectedItem().toString();
        System.out.println(ctrl+" "+jornada+" "+nombre_local+identificador_local+" "+nombre_visitante+identificador_visitante+" "+categoria+" "+sexo+" "+grupo);
        try{ 
            String sql="Select id_categoria from categoria where nombre_cat= '"+categoria+"' and sexo='"+sexo+"';";
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
            Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE, null, ex);
            }
        try{ 
            String sql="Select id_club from club where nombre_club='"+nombre_local+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            clublocal=rs.getString("id_club");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE, null, ex);
            }
        try{ 
            String sql="Select id_equipo from equipo where id_club='"+clublocal+"' and id_categoria='"+idcategoria+"' and identificador='"+identificador_local+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            idequipolocal=rs.getString("id_equipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE, null, ex);
            }
        idtorneo=Principal.labelserialtorneo.getText();
        hlocal=idtorneo+idequipolocal;
        try{ 
            String sql="Select id_club from club where nombre_club='"+nombre_visitante+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            clubvisitante=rs.getString("id_club");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE, null, ex);
            }
        try{ 
            String sql="Select id_equipo from equipo where id_club='"+clubvisitante+"' and id_categoria='"+idcategoria+"' and identificador='"+identificador_visitante+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            idequipovisitante=rs.getString("id_equipo");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE, null, ex);
            }
        idtorneo=Principal.labelserialtorneo.getText();
        hvisitante=idtorneo+idequipovisitante;
        try{ 
            String sql="Select id_juego from juego where jornada='"+jornada+"' and equipo_local='"+hlocal+"' and equipo_visitante='"+hvisitante+"' and grupo='"+grupo+"' and id_categoria='"+idcategoria+"' and id_torneo='"+idtorneo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            id_juego=rs.getString("id_juego");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println(id_juego);
        modificarcalendario.labelidjuego.setText(id_juego);
        try{ 
            String sql="Select id_fechajuego from fecha_juego where id_fechajuego='"+id_juego+"';";
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
            Logger.getLogger(fechajornada.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(ctrl!=2){
            try{
                int tamano=modificarcalendario.panelmodificar.getTabCount();
        for(int i=0;i<=tamano;i++){
                 modificarcalendario.panelmodificar.remove(i);
                 i--;
                 tamano=modificarcalendario.panelmodificar.getTabCount(); 
                 if( tamano== 0){
                     break;
                 } 
                 }
         abriragregarfecha();
            
        }catch(Exception e){
        
        }    
       }else{
            JOptionPane.showMessageDialog(null,"Al juego ya se le asigno fecha","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
     
    }
    public void abriragregarfecha(){
        agregarfecha af= new agregarfecha();
       String titulo= "Agregar fecha";
       int index= modificarcalendario.panelmodificar.indexOfTab(titulo);
       
       if (index== -1){
           modificarcalendario.panelmodificar.addTab(titulo, af);
           int i=modificarcalendario.panelmodificar.indexOfTab(titulo);
           modificarcalendario.panelmodificar.setSelectedIndex(i);
       }else{
           modificarcalendario.panelmodificar.remove(index);
           modificarcalendario.panelmodificar.addTab(titulo, af);
           int i=modificarcalendario.panelmodificar.indexOfTab(titulo);
           modificarcalendario.panelmodificar.setSelectedIndex(i);
       }

    }
    public void abrirverfecha(){
        verfechajornada vfj= new verfechajornada();
       String titulo= "Ver Fecha";
       int index= modificarcalendario.panelmodificar.indexOfTab(titulo);
       
       if (index== -1){
           modificarcalendario.panelmodificar.addTab(titulo, vfj);
           int i=modificarcalendario.panelmodificar.indexOfTab(titulo);
           modificarcalendario.panelmodificar.setSelectedIndex(i);
       }else{
           modificarcalendario.panelmodificar.remove(index);
           modificarcalendario.panelmodificar.addTab(titulo, vfj);
           int i=modificarcalendario.panelmodificar.indexOfTab(titulo);
           modificarcalendario.panelmodificar.setSelectedIndex(i);
       }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablacruces = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }

        };
        combogrupo = new javax.swing.JComboBox();
        bsiguiente = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(860, 270));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(860, 270));
        jPanel1.setOpaque(false);

        tablacruces.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablacruces.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablacruces.setOpaque(false);
        jScrollPane1.setViewportView(tablacruces);

        combogrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combogrupoActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combogrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(98, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bsiguiente)
                        .addGap(32, 32, 32))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(combogrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(bsiguiente)))
                .addContainerGap(28, Short.MAX_VALUE))
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
            buscarid();
       
       }catch(Exception e){
           try{
                int tamano=modificarcalendario.panelmodificar.getTabCount();
        for(int i=0;i<=tamano;i++){
                 modificarcalendario.panelmodificar.remove(i);
                 i--;
                 tamano=modificarcalendario.panelmodificar.getTabCount(); 
                 if( tamano== 0){
                     break;
                 } 
                 }
        try{
            abrirverfecha();
        }catch(Exception ea){
            JOptionPane.showMessageDialog(null,"No posee fecha en los juegos para esta categoria","Información", JOptionPane.INFORMATION_MESSAGE);
             
        } 
        
            
        }catch(Exception em){
        
        }     
           
       }
    }//GEN-LAST:event_bsiguienteActionPerformed

    private void combogrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combogrupoActionPerformed
        cargarequipos();
    }//GEN-LAST:event_combogrupoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bsiguiente;
    public static javax.swing.JComboBox combogrupo;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablacruces;
    // End of variables declaration//GEN-END:variables
}
