
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import saceaf.Principal;


public class posiciones extends javax.swing.JPanel {

    static DefaultTableModel modelo= new DefaultTableModel();
    static DefaultComboBoxModel combo= new DefaultComboBoxModel();
    static int datogrupos;
    String id_torneo, id_competencia, id_categoria,datopostfase,nombre_modalidad,sexo;
    String idequipob,idbuscar,idtorneo,categoria,letrag,id_club,idcategoria;
    int idnumero,numeroeq,ctrl,ronda;
    static String ncategoria, lsexo,serialtorneo,cidcategoria,id_modalidad,identificador,nombre_club,letragrupo; 
    public posiciones() {
        initComponents();
        cargarcombo();
        cargarequipos();
    }


    public static void cargarequipos(){
     ncategoria= panelresultados.combocategoria.getSelectedItem().toString();
     serialtorneo= Principal.labelserialtorneo.getText();
     lsexo=Principal.labelsexo.getText();
    letragrupo=posiciones.combogrupo.getSelectedItem().toString();
     
     try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+ncategoria+"' and sexo='"+lsexo+"';");
          while(rs.first()){
          cidcategoria=rs.getNString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(crearcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
     try{
            String[] titulos={"N°","Equipo","Pj","G","E","P","Gf","Gc","Dif","Pts"};
            String[] registro= new String[10];
            String sql="Select p.posicion, c.nombre_club, e.identificador, p.partidos_jugados, p.partidos_ganados,p.partidos_empatados,p.partidos_perdidos,p.goles_favor, p.goles_contra,p.diferencia_goles, p.puntos from posiciones p, h_equipo he, equipo e, club c where p.id_hequipo=he.id_hequipo and he.id_equipo=e.id_equipo and e.id_club=c.id_club and p.id_categoria='"+cidcategoria+"' and p.id_torneo='"+serialtorneo+"' and he.id_torneo='"+serialtorneo+"' and he.id_categoria='"+cidcategoria+"' and he.grupo_equipo='"+letragrupo+"' order by p.posicion;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("p.posicion");
               nombre_club=rs.getString("c.nombre_club");
               identificador=rs.getString("e.identificador");
               registro [1]=nombre_club+" "+identificador;
               registro [2]=rs.getString("p.partidos_jugados");
               registro [3]=rs.getString("p.partidos_ganados");
               registro [4]=rs.getString("p.partidos_empatados");
               registro [5]=rs.getString("p.partidos_perdidos");
               registro [6]=rs.getString("p.goles_favor");
               registro [7]=rs.getString("p.goles_contra");
               registro [8]=rs.getString("p.diferencia_goles");
               registro [9]=rs.getString("p.puntos");
               
               modelo.addRow(registro);
            }
            tablaequipos.setModel(modelo);
            tablaequipos.getColumnModel().getColumn(0).setPreferredWidth(60);
            tablaequipos.getColumnModel().getColumn(1).setPreferredWidth(150);
            tablaequipos.getColumnModel().getColumn(2).setPreferredWidth(70);
            tablaequipos.getColumnModel().getColumn(3).setPreferredWidth(60);
            tablaequipos.getColumnModel().getColumn(4).setPreferredWidth(60);
            tablaequipos.getColumnModel().getColumn(5).setPreferredWidth(60);
            tablaequipos.getColumnModel().getColumn(6).setPreferredWidth(60);
            tablaequipos.getColumnModel().getColumn(7).setPreferredWidth(60);
            tablaequipos.getColumnModel().getColumn(8).setPreferredWidth(60);
            tablaequipos.getColumnModel().getColumn(9).setPreferredWidth(70);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            tablaequipos.setRowSorter(modeloordenado);
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(posiciones.class.getName()).log(Level.SEVERE, null, ex);
                }
     }
    public static void cargarcombo(){
         ncategoria=panelresultados.combocategoria.getSelectedItem().toString();
         serialtorneo=Principal.labelserialtorneo.getText();
         lsexo=Principal.labelsexo.getText();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+ncategoria+"' and sexo='"+lsexo+"';");
          while(rs.first()){
          cidcategoria=rs.getNString("id_categoria");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(crearcopa.class.getName()).log(Level.SEVERE,null,ex);
          }
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_modalidad from modalidad where id_categoria='"+cidcategoria+"' and id_torneo='"+serialtorneo+"';");
          while(rs.first()){
          id_modalidad=rs.getNString("id_modalidad");
          break;
          }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(crearcopa.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(crearcopa.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(Semifinal.class.getName()).log(Level.SEVERE,null,ex);
          }
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
        combogrupo = new javax.swing.JComboBox();

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
        tablaequipos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaequipos.setOpaque(false);
        jScrollPane1.setViewportView(tablaequipos);

        combogrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combogrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combogrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combogrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void combogrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combogrupoActionPerformed
       cargarequipos();
    }//GEN-LAST:event_combogrupoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox combogrupo;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaequipos;
    // End of variables declaration//GEN-END:variables
}
