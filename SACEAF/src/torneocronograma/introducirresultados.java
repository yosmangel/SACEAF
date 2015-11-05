
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


public class introducirresultados extends javax.swing.JPanel {

    static DefaultTableModel modelo= new DefaultTableModel();
    static DefaultComboBoxModel combo= new DefaultComboBoxModel();
    static int datogrupos;
    String id_torneo, id_competencia,grupo,id_juego, id_categoria,equipo_local,equipo_visitante,datopostfase,
           nombre_modalidad,sexo,clublocal,clubvisitante,hlocal,hvisitante,idequipolocal,idequipovisitante,
           idequipob,idbuscar,idtorneo,categoria,jornada,letrag,id_club,idcategoria,nombre_local,identificador_local,
           nombre_visitante,identificador_visitante;
    int idnumero,numeroeq,ctrl,ronda;
    static String ncategoria, lsexo,serialtorneo,cidcategoria,letragrupo,id_modalidad; 
    
    public introducirresultados() {
        initComponents();
        cargarcombo();
        cargarequipos();
    }


    public static void cargarequipos(){
        ncategoria= panelresultados.combocategoria.getSelectedItem().toString();
        serialtorneo= Principal.labelserialtorneo.getText();
        lsexo=Principal.labelsexo.getText();
        letragrupo=combogrupo.getSelectedItem().toString();
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
            Logger.getLogger(introducirresultados.class.getName()).log(Level.SEVERE, null, ex);
            }
     try{
            String[] titulos={"Fecha juego","Jor.","Nombre cancha","Hora","Equipo local"," ","Equipo visitante"," ","ID"};
            String[] registro= new String[9];
            String sql="Select ju.jornada,fe.fecha_juego,ca.nombre_cancha,ca.hora_juego,c.nombre_club,e.identificador,cc.nombre_club,"
                    + "ee.identificador, ju.id_juego from juego ju, fecha_juego fe,cancha ca,club c,equipo e, club cc, equipo ee,h_equipo he,"
                    + " h_equipo hh, formulario f where"
                    + " f.club_local=he.id_hequipo and he.id_equipo=e.id_equipo and e.id_club=c.id_club and "
                    + " f.club_visitante=hh.id_hequipo and hh.id_equipo=ee.id_equipo and ee.id_club=cc.id_club and "
                    + " f.id_cancha=ca.id_cancha and f.id_juego=fe.id_juego and f.id_juego=ju.id_juego and f.id_categoria='"+cidcategoria+"' and"
                    + " f.id_torneo='"+serialtorneo+"' and ju.grupo='"+letragrupo+"' order by fe.fecha_juego;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("ju.jornada");
               registro [1]=rs.getString("fe.fecha_juego");
               registro [2]=rs.getString("ca.nombre_cancha");
               registro [3]=rs.getString("ca.hora_juego");
               registro [4]=rs.getString("c.nombre_club");
               registro [5]=rs.getString("e.identificador");
               registro [6]=rs.getString("cc.nombre_club");
               registro [7]=rs.getString("ee.identificador");
               registro [8]=rs.getString("ju.id_juego");
               modelo.addRow(registro);
            }
            tablacruces.setModel(modelo);
            tablacruces.getColumnModel().getColumn(0).setPreferredWidth(77);
            tablacruces.getColumnModel().getColumn(1).setPreferredWidth(100);
            tablacruces.getColumnModel().getColumn(2).setPreferredWidth(160);
            tablacruces.getColumnModel().getColumn(3).setPreferredWidth(70);
            tablacruces.getColumnModel().getColumn(4).setPreferredWidth(160);
            tablacruces.getColumnModel().getColumn(5).setPreferredWidth(70);
            tablacruces.getColumnModel().getColumn(6).setPreferredWidth(160);
            tablacruces.getColumnModel().getColumn(7).setPreferredWidth(70);
            tablacruces.getColumnModel().getColumn(8).setPreferredWidth(70);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            tablacruces.setRowSorter(modeloordenado);
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(introducirresultados.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public static void cargarcombo(){
         ncategoria=panelresultados.combocategoria.getSelectedItem().toString();
         serialtorneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
         combogrupo.removeAllItems();
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
          Logger.getLogger(introducirresultados.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(introducirresultados.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(introducirresultados.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(introducirresultados.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void abriragregartitulares(){
        agregarequipolocal af= new agregarequipolocal();
       String titulo= "Equipo Local";
       int index= panelresultados.panelresultado.indexOfTab(titulo);
       
       if (index== -1){
           panelresultados.panelresultado.addTab(titulo, af);
           int i=panelresultados.panelresultado.indexOfTab(titulo);
           panelresultados.panelresultado.setSelectedIndex(i);
       }else{
           panelresultados.panelresultado.remove(index);
           panelresultados.panelresultado.addTab(titulo, af);
           int i=panelresultados.panelresultado.indexOfTab(titulo);
           panelresultados.panelresultado.setSelectedIndex(i);
       }

    }
    public void cargar(){
        id_juego=(String)tablacruces.getValueAt(tablacruces.getSelectedRow(), 8);
        try{ 
            String sql="Select equipo_local, equipo_visitante from juego where id_juego='"+id_juego+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            equipo_local=rs.getString("equipo_local");
            equipo_visitante=rs.getString("equipo_visitante");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(introducirresultados.class.getName()).log(Level.SEVERE, null, ex);
            }
        panelresultados.labelequipolocal.setText(equipo_local);
        panelresultados.labelequipovisitante.setText(equipo_visitante);
        panelresultados.labelserialformulario.setText(id_juego);
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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bsiguiente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(combogrupo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(combogrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
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
        cargar();
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
         abriragregartitulares();
       }catch(Exception e){
            
       }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,"Debe seleccionar un juego para poder presionar siguiente","Informacion",JOptionPane.INFORMATION_MESSAGE);
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
