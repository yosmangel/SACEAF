
package Estadisticas;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


public class Graficas extends javax.swing.JPanel {
     
    static DefaultTableModel modelo;
    
    public Graficas() {
        initComponents();
        

        //this.setLocationRelativeTo(null);
        this.PanelBarras.setVisible(false);
        this.PanelCirculo.setVisible(false);
        
        this.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTextFieldArbitros = new javax.swing.JTextField();
        JTextFieldCanchas = new javax.swing.JTextField();
        JTextFieldCategorias = new javax.swing.JTextField();
        JTextFieldClub = new javax.swing.JTextField();
        JTextFieldDisciplinas = new javax.swing.JTextField();
        JTextFieldJugadores = new javax.swing.JTextField();
        JTextFieldUsuarios = new javax.swing.JTextField();
        PanelCapa = new javax.swing.JLayeredPane();
        PanelCirculo = new javax.swing.JPanel();
        PanelBarras = new javax.swing.JPanel();
        RadioButtonBarras = new javax.swing.JRadioButton();
        RadioButtonCircular = new javax.swing.JRadioButton();
        JButtonGraficar = new javax.swing.JButton();

        JTextFieldArbitros.setEnabled(false);

        JTextFieldCanchas.setEnabled(false);

        JTextFieldCategorias.setEnabled(false);

        JTextFieldClub.setEnabled(false);

        JTextFieldDisciplinas.setEnabled(false);

        JTextFieldJugadores.setEnabled(false);

        JTextFieldUsuarios.setEnabled(false);

        setMaximumSize(new java.awt.Dimension(640, 310));
        setMinimumSize(new java.awt.Dimension(640, 310));
        setPreferredSize(new java.awt.Dimension(640, 310));

        PanelCapa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelCapa.setMaximumSize(new java.awt.Dimension(620, 223));
        PanelCapa.setMinimumSize(new java.awt.Dimension(620, 223));

        PanelCirculo.setMaximumSize(new java.awt.Dimension(600, 200));
        PanelCirculo.setMinimumSize(new java.awt.Dimension(600, 200));
        PanelCirculo.setPreferredSize(new java.awt.Dimension(600, 200));

        PanelBarras.setMaximumSize(new java.awt.Dimension(600, 200));
        PanelBarras.setMinimumSize(new java.awt.Dimension(600, 200));
        PanelBarras.setPreferredSize(new java.awt.Dimension(600, 200));

        javax.swing.GroupLayout PanelBarrasLayout = new javax.swing.GroupLayout(PanelBarras);
        PanelBarras.setLayout(PanelBarrasLayout);
        PanelBarrasLayout.setHorizontalGroup(
            PanelBarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelBarrasLayout.setVerticalGroup(
            PanelBarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelCirculoLayout = new javax.swing.GroupLayout(PanelCirculo);
        PanelCirculo.setLayout(PanelCirculoLayout);
        PanelCirculoLayout.setHorizontalGroup(
            PanelCirculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBarras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelCirculoLayout.setVerticalGroup(
            PanelCirculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCirculoLayout.createSequentialGroup()
                .addComponent(PanelBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelCapa.add(PanelCirculo);
        PanelCirculo.setBounds(10, 10, 600, 210);

        RadioButtonBarras.setForeground(new java.awt.Color(255, 255, 255));
        RadioButtonBarras.setText("Barras");
        RadioButtonBarras.setContentAreaFilled(false);
        RadioButtonBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonBarrasActionPerformed(evt);
            }
        });

        RadioButtonCircular.setForeground(new java.awt.Color(255, 255, 255));
        RadioButtonCircular.setText("Circular");
        RadioButtonCircular.setContentAreaFilled(false);
        RadioButtonCircular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonCircularActionPerformed(evt);
            }
        });

        JButtonGraficar.setText("Graficar");
        JButtonGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonGraficarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(RadioButtonBarras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RadioButtonCircular)
                .addGap(18, 18, 18)
                .addComponent(JButtonGraficar)
                .addContainerGap(421, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelCapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelCapa, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioButtonBarras)
                    .addComponent(RadioButtonCircular)
                    .addComponent(JButtonGraficar))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RadioButtonBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonBarrasActionPerformed
        PanelBarras.setVisible(true);
        PanelCapa.setLayer(PanelBarras, 0,0);
        RadioButtonCircular.setSelected(false);
    }//GEN-LAST:event_RadioButtonBarrasActionPerformed

    private void RadioButtonCircularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonCircularActionPerformed
        PanelCirculo.setVisible(true);
        PanelCapa.setLayer(PanelCirculo, 0,0);
        RadioButtonBarras.setSelected(false);
    }//GEN-LAST:event_RadioButtonCircularActionPerformed

    private void JButtonGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonGraficarActionPerformed
        String  TotalArbitros; String TotalCanchas; String TotalCategorias; String TotalClub; String TotalDisciplinas; String TotalJugadores; String TotalUsuarios;
       
        try{
            String sql="SELECT * FROM totales";
            Conexion parametros = new Conexion();
            Class.forName(parametros.getDriver());
            Connection con = DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(sql);
          
           
            if (rs.next()){
               
                TotalArbitros=rs.getString("total_arbitros");
                this.JTextFieldArbitros.setText(TotalArbitros);
               
                TotalCanchas=rs.getString("total_canchas");
                this.JTextFieldCanchas.setText(TotalCanchas);
               
                TotalCategorias=rs.getString("total_categorias");
                this.JTextFieldCategorias.setText(TotalCategorias);
              
                TotalClub=rs.getString("total_club");
                this.JTextFieldClub.setText(TotalClub);
               
                TotalDisciplinas=rs.getString("total_disciplinas");
                this.JTextFieldDisciplinas.setText(TotalDisciplinas);
               
                TotalJugadores=rs.getString("total_jugadores");
                this.JTextFieldJugadores.setText(TotalJugadores);
               
                TotalUsuarios=rs.getString("total_usuarios");
                this.JTextFieldUsuarios.setText(TotalUsuarios);
            }
                  
        }
        catch(SQLException e){
           JOptionPane.showMessageDialog(this,"Error."+e.getMessage(),"Error...",JOptionPane.ERROR_MESSAGE);
        }
        catch(ClassNotFoundException ex){
           Logger.getLogger(coño.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        ChartPanel panel;
        JFreeChart chart=null;
        //Grafico de barras
        if (RadioButtonBarras.isSelected()){
            
            String Arbitros=JTextFieldArbitros.getText();
            String Canchas=JTextFieldCanchas.getText();
            String Categorias=JTextFieldCategorias.getText();
            String Club=JTextFieldClub.getText();     
            String Disciplinas=JTextFieldDisciplinas.getText();
            String Jugadores=JTextFieldJugadores.getText();
            String Usuarios=JTextFieldUsuarios.getText();
            
            DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
            
            dataset.setValue(new Double(Arbitros), "Arbitros", "Arbitros");
            dataset.setValue(new Double(Canchas), "Canchas", "Canchas");
            dataset.setValue(new Double(Categorias), "Categorias", "Categorias");
            dataset.setValue(new Double(Club), "Club", "Club");
            dataset.setValue(new Double(Disciplinas), "Disciplinas", "Disciplinas");
            dataset.setValue(new Double(Jugadores), "Jugadores", "Jugadores");
            dataset.setValue(new Double(Usuarios), "Usuarios", "Usuarios");
            
            chart = ChartFactory.createBarChart3D("Asociacion de Futbol del Estado Bolivariano de Miranda", "Estadisticas", "Cantidad", dataset, PlotOrientation.HORIZONTAL, true, true, true);
            
            CategoryPlot plot=(CategoryPlot) chart.getPlot();
            plot.setDomainGridlinesVisible(true);
        }
        
        //Grafico pastel
        else{
           
            String Arbitros=JTextFieldArbitros.getText();
            String Canchas=JTextFieldCanchas.getText();
            String Categorias=JTextFieldCategorias.getText();
            String Club=JTextFieldClub.getText();     
            String Disciplinas=JTextFieldDisciplinas.getText();
            String Jugadores=JTextFieldJugadores.getText();
            String Usuarios=JTextFieldUsuarios.getText();
            
            DefaultPieDataset pieDataset = new DefaultPieDataset(); 
            
            pieDataset.setValue("Arbitros",new Integer(Arbitros));
            pieDataset.setValue("Canchas",new Integer(Canchas));
            pieDataset.setValue("Categorias", new Integer(Categorias));
            pieDataset.setValue("Club",new Integer(Club));
            pieDataset.setValue("Disciplinas",new Integer(Disciplinas));
            pieDataset.setValue("Jugadores",new Integer(Jugadores));
            pieDataset.setValue("Usuarios",new Integer(Usuarios));
        
            chart = ChartFactory.createPieChart3D("Estadisticas", pieDataset, true, true, true);
        }
        
        panel=new ChartPanel(chart);
        panel.setBounds(5,10,610,200);
        
        if(RadioButtonBarras.isSelected()){
            PanelBarras.add(panel);
            PanelBarras.repaint();
        }
        if (RadioButtonCircular.isSelected()){
            PanelCirculo.add(panel);
            PanelCirculo.repaint();
        }
    }//GEN-LAST:event_JButtonGraficarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonGraficar;
    private javax.swing.JTextField JTextFieldArbitros;
    private javax.swing.JTextField JTextFieldCanchas;
    private javax.swing.JTextField JTextFieldCategorias;
    private javax.swing.JTextField JTextFieldClub;
    private javax.swing.JTextField JTextFieldDisciplinas;
    private javax.swing.JTextField JTextFieldJugadores;
    private javax.swing.JTextField JTextFieldUsuarios;
    private javax.swing.JPanel PanelBarras;
    private javax.swing.JLayeredPane PanelCapa;
    private javax.swing.JPanel PanelCirculo;
    private javax.swing.JRadioButton RadioButtonBarras;
    private javax.swing.JRadioButton RadioButtonCircular;
    // End of variables declaration//GEN-END:variables

}
