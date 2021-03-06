
package torneocronograma;

import Basededatos.Conexion;
import Basededatos.ConexionReportes;
import static Estadisticas.preportes.ComboReporte;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import saceaf.Principal;
import static torneocronograma.vercalendario.combocategoria;
import static torneocronograma.vercalendario.panelvercalendario;


public class verjornada extends javax.swing.JPanel {

    static DefaultTableModel modelo= new DefaultTableModel();
    static DefaultComboBoxModel combo= new DefaultComboBoxModel();
    static int datogrupos;
    String id_torneo, id_competencia,grupo,id_juego, id_categoria,datopostfase,nombre_modalidad,sexo,clublocal,
           clubvisitante,hlocal,hvisitante,idequipolocal,idequipovisitante, idequipob,idbuscar,idtorneo,categoria,
            jornada,letrag,id_club,idcategoria,nombre_local,identificador_local,nombre_visitante,
            identificador_visitante;
    int idnumero,numeroeq,ctrl,ronda;
    static String ncategoria, lsexo,serialtorneo,cidcategoria,letragrupo,id_modalidad; 
   
    public verjornada() {
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
            Logger.getLogger(verjornada.class.getName()).log(Level.SEVERE, null, ex);
            }
     try{
            String[] titulos={"Fecha juego","Jor.","Nombre cancha","Hora","Equipo local"," ","Equipo visitante"," "};
            String[] registro= new String[8];
            String sql="Select f.fecha_juego, j.jornada ,ca.nombre_cancha,ca.hora_juego, c.nombre_club, e.identificador ,cc.nombre_club, ee.identificador from club c, equipo e, h_equipo he,juego j,club cc, equipo ee, h_equipo hee,juego jj, fecha_juego f, formulario fo, cancha ca where j.equipo_local=he.id_hequipo and he.id_equipo=e.id_equipo and e.id_club=c.id_club and jj.equipo_visitante=hee.id_hequipo and hee.id_equipo=ee.id_equipo and ee.id_club=cc.id_club and j.id_torneo='"+serialtorneo+"' and jj.id_torneo='"+serialtorneo+"' and j.grupo='"+letragrupo+"' and jj.id_juego=j.id_juego and j.id_categoria='"+cidcategoria+"' and f.id_fechajuego=j.id_juego and f.id_juego=j.id_juego and fo.id_juego=j.id_juego and fo.id_juego=jj.id_juego and fo.id_cancha=ca.id_cancha and fo.id_juego=f.id_fechajuego order by f.fecha_juego asc;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("f.fecha_juego");
               registro [1]=rs.getString("j.jornada");
               registro [2]=rs.getString("ca.nombre_cancha");
               registro [3]=rs.getString("ca.hora_juego");
               registro [4]=rs.getString("c.nombre_club");
               registro [5]=rs.getString("e.identificador");
               registro [6]=rs.getString("cc.nombre_club");
               registro [7]=rs.getString("ee.identificador");
               modelo.addRow(registro);
            }
            tablacruces.setModel(modelo);
            tablacruces.getColumnModel().getColumn(0).setPreferredWidth(90);
            tablacruces.getColumnModel().getColumn(1).setPreferredWidth(41);
            tablacruces.getColumnModel().getColumn(2).setPreferredWidth(150);
            tablacruces.getColumnModel().getColumn(2).setPreferredWidth(80);
            tablacruces.getColumnModel().getColumn(2).setPreferredWidth(180);
            tablacruces.getColumnModel().getColumn(3).setPreferredWidth(40);
            tablacruces.getColumnModel().getColumn(4).setPreferredWidth(180);
            tablacruces.getColumnModel().getColumn(5).setPreferredWidth(40);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            tablacruces.setRowSorter(modeloordenado);
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(verjornada.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public static void cargarcombo(){
         ncategoria=vercalendario.combocategoria.getSelectedItem().toString();
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
          Logger.getLogger(verjornada.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(verjornada.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(verjornada.class.getName()).log(Level.SEVERE,null,ex);
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
          Logger.getLogger(verjornada.class.getName()).log(Level.SEVERE,null,ex);
          }
          }
  }
    public void abrirasignarcancha(){
        asignarcancha ac= new asignarcancha();
       String titulo= "Asignar cancha";
       int index= modificarcalendario.panelmodificar.indexOfTab(titulo);
       
       if (index== -1){
           modificarcalendario.panelmodificar.addTab(titulo, ac);
           int i=modificarcalendario.panelmodificar.indexOfTab(titulo);
           modificarcalendario.panelmodificar.setSelectedIndex(i);
       }else{
           modificarcalendario.panelmodificar.remove(index);
           modificarcalendario.panelmodificar.addTab(titulo, ac);
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
                .addGap(22, 22, 22)
                .addComponent(MostrarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combogrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combogrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(MostrarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void MostrarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarReporteActionPerformed
/*
        int i=ComboReporte.getSelectedIndex();

        if (i==0){
            Connection miconexion=ConexionReportes.GetConnection();
            try{
                String UbicacionReporte=System.getProperty("user.dir")+"/src/Basededatos/Reporte1.jasper";
                JasperReport jasperReport=(JasperReport) JRLoader.loadObject(UbicacionReporte);
                JasperPrint print=JasperFillManager.fillReport(jasperReport, null, miconexion);
                JasperViewer view=new JasperViewer(print, false);
                view.setVisible(true);
            }

            catch (Exception ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        */
         Connection miconexion=ConexionReportes.GetConnection();
            try{
                String UbicacionReporte=System.getProperty("user.dir")+"/src/Basededatos/Jornadas.jrxml";
                JasperReport jasperReport=JasperCompileManager.compileReport(UbicacionReporte);
                JasperPrint print=JasperFillManager.fillReport(jasperReport, null, miconexion);
                JasperViewer view=new JasperViewer(print, false);
                view.setVisible(true);
 
            } catch (JRException ex) {
            Logger.getLogger(verjornada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MostrarReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MostrarReporte;
    public static javax.swing.JComboBox combogrupo;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablacruces;
    // End of variables declaration//GEN-END:variables
}
