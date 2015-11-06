package Estadisticas;

import Basededatos.ConexionReportes;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class preportes extends javax.swing.JPanel {
    
    static DefaultTableModel modelo;
    
    public preportes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBarras = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Bsalir2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ComboReporte = new javax.swing.JComboBox();
        MostrarReporte = new javax.swing.JButton();

        javax.swing.GroupLayout PanelBarrasLayout = new javax.swing.GroupLayout(PanelBarras);
        PanelBarras.setLayout(PanelBarrasLayout);
        PanelBarrasLayout.setHorizontalGroup(
            PanelBarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        PanelBarrasLayout.setVerticalGroup(
            PanelBarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        setMaximumSize(new java.awt.Dimension(630, 318));
        setMinimumSize(new java.awt.Dimension(630, 318));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(630, 318));

        jPanel1.setMaximumSize(new java.awt.Dimension(630, 318));
        jPanel1.setMinimumSize(new java.awt.Dimension(630, 318));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        Bsalir2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Bsalir2.setForeground(new java.awt.Color(255, 255, 255));
        Bsalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 30x30.png"))); // NOI18N
        Bsalir2.setText("Salir");
        Bsalir2.setBorder(null);
        Bsalir2.setContentAreaFilled(false);
        Bsalir2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Bsalir2.setIconTextGap(-3);
        Bsalir2.setMaximumSize(new java.awt.Dimension(630, 290));
        Bsalir2.setMinimumSize(new java.awt.Dimension(630, 290));
        Bsalir2.setPreferredSize(new java.awt.Dimension(630, 318));
        Bsalir2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 40x40.png"))); // NOI18N
        Bsalir2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Bsalir2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Bsalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bsalir2ActionPerformed(evt);
            }
        });
        jPanel1.add(Bsalir2);
        Bsalir2.setBounds(530, 210, 70, 60);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Seleccione el reporte a realizar");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(210, 100, 250, 22);

        ComboReporte.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ComboReporte.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nomina", "MasDeudaEquipo", "MasGolesEquipo", "MasTarjetasEquipo", "MasTarjetasJugador", "MenosGolesEquipo", "MenosTarjetasEquipo", "MenosTarjetasJugador", "PruebaKevin" }));
        ComboReporte.setToolTipText("");
        jPanel1.add(ComboReporte);
        ComboReporte.setBounds(240, 140, 190, 30);

        MostrarReporte.setText("Mostrar Reporte");
        MostrarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarReporteActionPerformed(evt);
            }
        });
        jPanel1.add(MostrarReporte);
        MostrarReporte.setBounds(270, 180, 120, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void Bsalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bsalir2ActionPerformed
        Gestadisticas.panelestadisticas.remove(this);
    }//GEN-LAST:event_Bsalir2ActionPerformed

    private void MostrarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarReporteActionPerformed

        int i=ComboReporte.getSelectedIndex();
        //Jugadores Nomina
        if (i==0){
            Connection miconexion=ConexionReportes.GetConnection();
            try{
                String UbicacionReporte=System.getProperty("user.dir")+"/src/Basededatos/Jugadores.jasper";
                JasperReport jasperReport=(JasperReport) JRLoader.loadObject(UbicacionReporte);
                JasperPrint print=JasperFillManager.fillReport(jasperReport, null, miconexion);
                JasperViewer view=new JasperViewer(print, false);
                view.setVisible(true);
            }

            catch (Exception ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }  
        }
        //MasDeudaEquipo
        if (i==1){
            Connection miconexion=ConexionReportes.GetConnection();
            try{
                String UbicacionReporte=System.getProperty("user.dir")+"/src/Basededatos/MasDeudaEquipo.jasper";
                JasperReport jasperReport=(JasperReport) JRLoader.loadObject(UbicacionReporte);
                JasperPrint print=JasperFillManager.fillReport(jasperReport, null, miconexion);
                JasperViewer view=new JasperViewer(print, false);
                view.setVisible(true);
            }

            catch (Exception ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }  
        }
        //MasGolesEquipo
         if (i==2){
            Connection miconexion=ConexionReportes.GetConnection();
            try{
                String UbicacionReporte=System.getProperty("user.dir")+"/src/Basededatos/MasGolesEquipo.jasper";
                JasperReport jasperReport=(JasperReport) JRLoader.loadObject(UbicacionReporte);
                JasperPrint print=JasperFillManager.fillReport(jasperReport, null, miconexion);
                JasperViewer view=new JasperViewer(print, false);
                view.setVisible(true);
            }

            catch (Exception ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }  
        }
         //MasTarjetasEquipos
         if (i==3){
            Connection miconexion=ConexionReportes.GetConnection();
            try{
                String UbicacionReporte=System.getProperty("user.dir")+"/src/Basededatos/MasTarjetasEquipo.jasper";
                JasperReport jasperReport=(JasperReport) JRLoader.loadObject(UbicacionReporte);
                JasperPrint print=JasperFillManager.fillReport(jasperReport, null, miconexion);
                JasperViewer view=new JasperViewer(print, false);
                view.setVisible(true);
            }

            catch (Exception ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }  
        }
         //MasTarjetasJugador
         if (i==4){
            Connection miconexion=ConexionReportes.GetConnection();
            try{
                String UbicacionReporte=System.getProperty("user.dir")+"/src/Basededatos/MasTarjetasJugador.jasper";
                JasperReport jasperReport=(JasperReport) JRLoader.loadObject(UbicacionReporte);
                JasperPrint print=JasperFillManager.fillReport(jasperReport, null, miconexion);
                JasperViewer view=new JasperViewer(print, false);
                view.setVisible(true);
            }

            catch (Exception ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }  
        }
          //MenosGolesEquipo
         if (i==5){
            Connection miconexion=ConexionReportes.GetConnection();
            try{
                String UbicacionReporte=System.getProperty("user.dir")+"/src/Basededatos/MenosGolesEquipo.jasper";
                JasperReport jasperReport=(JasperReport) JRLoader.loadObject(UbicacionReporte);
                JasperPrint print=JasperFillManager.fillReport(jasperReport, null, miconexion);
                JasperViewer view=new JasperViewer(print, false);
                view.setVisible(true);
            }

            catch (Exception ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }  
        }
           //MenosTarjetasEquipo
         if (i==6){
            Connection miconexion=ConexionReportes.GetConnection();
            try{
                String UbicacionReporte=System.getProperty("user.dir")+"/src/Basededatos/MenosTarjetasEquipo.jasper";
                JasperReport jasperReport=(JasperReport) JRLoader.loadObject(UbicacionReporte);
                JasperPrint print=JasperFillManager.fillReport(jasperReport, null, miconexion);
                JasperViewer view=new JasperViewer(print, false);
                view.setVisible(true);
            }

            catch (Exception ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }  
        }
            //MenosTarjetasjugador
         if (i==7){
            Connection miconexion=ConexionReportes.GetConnection();
            try{
                String UbicacionReporte=System.getProperty("user.dir")+"/src/Basededatos/MenosTarjetasJugador.jasper";
                JasperReport jasperReport=(JasperReport) JRLoader.loadObject(UbicacionReporte);
                JasperPrint print=JasperFillManager.fillReport(jasperReport, null, miconexion);
                JasperViewer view=new JasperViewer(print, false);
                view.setVisible(true);
            }

            catch (Exception ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }  
        }
            //PruebaKevin
         if (i==8){
            Connection miconexion=ConexionReportes.GetConnection();
            try{
                String UbicacionReporte=System.getProperty("user.dir")+"/src/Basededatos/FechasdeJuego.jrxml";
                JasperReport jasperReport=JasperCompileManager.compileReport(UbicacionReporte);
                JasperPrint print=JasperFillManager.fillReport(jasperReport, null, miconexion);
                JasperViewer view=new JasperViewer(print, false);
                view.setVisible(true);
 
            }

            catch (Exception ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }  
        }
    }//GEN-LAST:event_MostrarReporteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Bsalir2;
    public static javax.swing.JComboBox ComboReporte;
    private javax.swing.JButton MostrarReporte;
    private javax.swing.JPanel PanelBarras;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
