
package torneocronograma;

import Basededatos.Conexion;
import Basededatos.ConexionReportes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import saceaf.Principal;
import static torneocronograma.vercalendario.combocategoria;
import static torneocronograma.vercalendario.panelvercalendario;


public class cruces extends javax.swing.JPanel {

    static DefaultTableModel modelo= new DefaultTableModel();
    static DefaultComboBoxModel combo= new DefaultComboBoxModel();
    static int datogrupos;
    String id_torneo, id_competencia, id_categoria,datopostfase,nombre_modalidad,sexo,
           idequipob,idbuscar,idtorneo,categoria,letrag,id_club,idcategoria;
    int idnumero,numeroeq,ctrl,ronda;
    static String ncategoria, lsexo,serialtorneo,cidcategoria,nombre_local,identificador_local,nombre_visitante,
                  letragrupo,id_modalidad,identificador_visitante; 
   
    public cruces() {
        initComponents();
        cargarcombo();
        cargarequipos();
    }


    public static void cargarequipos(){
        
        ncategoria= vercalendario.combocategoria.getSelectedItem().toString();
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
            Logger.getLogger(cruces.class.getName()).log(Level.SEVERE, null, ex);
            }
     try{
            String[] titulos={"Jornada","Equipo local","Equipo visitante"};
            String[] registro= new String[3];
            String sql="Select j.jornada , c.nombre_club, e.identificador ,cc.nombre_club, ee.identificador from club c, equipo e, h_equipo he,juego j,club cc, equipo ee, h_equipo hee,juego jj where j.equipo_local=he.id_hequipo and he.id_equipo=e.id_equipo and e.id_club=c.id_club and jj.equipo_visitante=hee.id_hequipo and hee.id_equipo=ee.id_equipo and ee.id_club=cc.id_club and j.id_torneo='"+serialtorneo+"' and jj.id_torneo='"+serialtorneo+"' and j.grupo='"+letragrupo+"' and jj.id_juego=j.id_juego and j.id_categoria='"+cidcategoria+"' order by j.jornada ;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("j.jornada");
               nombre_local=rs.getString("c.nombre_club");
               identificador_local=rs.getString("e.identificador");
               registro [1]=nombre_local+" "+identificador_local;
               nombre_visitante=rs.getString("cc.nombre_club");
               identificador_visitante=rs.getString("ee.identificador");
               registro [2]=nombre_visitante+" "+identificador_visitante;
               modelo.addRow(registro);
            }
            tablacruces.setModel(modelo);
            tablacruces.getColumnModel().getColumn(0).setPreferredWidth(77);
            tablacruces.getColumnModel().getColumn(1).setPreferredWidth(230);
            tablacruces.getColumnModel().getColumn(2).setPreferredWidth(230);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            tablacruces.setRowSorter(modeloordenado);
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(cruces.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public static void cargarcombo(){
        combogrupo.removeAllItems(); 
        ncategoria=vercalendario.combocategoria.getSelectedItem().toString();
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
          Logger.getLogger(cruces.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(cruces.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(cruces.class.getName()).log(Level.SEVERE,null,ex);
          }
          if(datogrupos!=0){
          combogrupo.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
              try (Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
                  ResultSet rs=st.executeQuery("Select id_variable from variables"+datogrupos+";");
                  while(rs.next()){
                      combo.addElement(rs.getObject("id_variable"));
                      combogrupo.setModel(combo);
                  }   }
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(cruces.class.getName()).log(Level.SEVERE,null,ex);
          }
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
        MostrarReporte = new javax.swing.JButton();

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

        MostrarReporte.setText("Mostrar Reporte");
        MostrarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MostrarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(combogrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combogrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MostrarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
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

    private void MostrarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarReporteActionPerformed

        ncategoria= vercalendario.combocategoria.getSelectedItem().toString();
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
            Logger.getLogger(cruces.class.getName()).log(Level.SEVERE, null, ex);
            }
        //int i=ComboReporte.getSelectedIndex();
        
        //if (i==0){
            Connection miconexion=ConexionReportes.GetConnection();
            try{
                String UbicacionReporte=System.getProperty("user.dir")+"/src/Basededatos/Crucescategoria.jasper";
                JasperReport jasperReport=(JasperReport) JRLoader.loadObject(UbicacionReporte);
                Map  parametro= new HashMap();
                //parametro.put("serialtorneo", serialtorneo);
                //parametro.put("letragrupo", letragrupo);
                //parametro.put("categoria", cidcategoria);
                //parametro.put("Nombrecategoria",ncategoria);
                JasperPrint print;
            print = JasperFillManager.fillReport(jasperReport, null, miconexion);
                JasperViewer view=new JasperViewer(print, false);
                view.setVisible(true);
              
            }

            catch (Exception ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        //}
    }//GEN-LAST:event_MostrarReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton MostrarReporte;
    public static javax.swing.JComboBox combogrupo;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablacruces;
    // End of variables declaration//GEN-END:variables
}
