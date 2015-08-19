
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
import static torneocronograma.verliga.comboronda;
import torneodatoscronograma.competencia;
import torneodatoscronograma.datomodificarrondas;


public class tresgrupos2 extends javax.swing.JPanel {

    static DefaultTableModel modelo= new DefaultTableModel();
    DefaultComboBoxModel combo= new DefaultComboBoxModel();
    
    public tresgrupos2() {
        initComponents();
        cargarequiposc();
    }

    String nombrecat,id_categoria,id_torneo,idcompetencia,idmodalidad,datopostfase;
    int rondas,nrondas,grupos;
    static String categoria, idtorneo,grupo,hequipo,idcategoria;

    public static void cargarequiposc(){
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
            idcategoria=rs.getNString("id_categoria");
            break;
            }            
            }catch(SQLException ex){
            Logger.getLogger(tresgrupos2.class.getName()).log(Level.SEVERE, null, ex);
            }catch(ClassNotFoundException e){
            Logger.getLogger(tresgrupos2.class.getName()).log(Level.SEVERE,null,e);
            }
     try{
            String[] titulos={"N°","Nombre","Identificador"};
            String[] registro= new String[3];
            String sql="Select he.posicion, c.nombre_club, e.identificador from club c, equipo e, h_equipo he where c.id_club=e.id_club and e.id_categoria='"+idcategoria+"' and he.id_equipo=e.id_equipo and he.id_torneo='"+idtorneo+"' and he.grupo_equipo='C' order by he.posicion;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("he.posicion");
               registro [1]=rs.getString("c.nombre_club");
               registro [2]=rs.getString("e.identificador");
               modelo.addRow(registro);
            }
            grupoc.setModel(modelo);
            grupoc.getColumnModel().getColumn(0).setPreferredWidth(50);
            grupoc.getColumnModel().getColumn(1).setPreferredWidth(140);
            grupoc.getColumnModel().getColumn(2).setPreferredWidth(140);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            grupoc.setRowSorter(modeloordenado);
            
        }catch(SQLException ex){
                Logger.getLogger(tresgrupos2.class.getName()).log(Level.SEVERE, null, ex);
                }catch(ClassNotFoundException e){
                Logger.getLogger(tresgrupos2.class.getName()).log(Level.SEVERE,null,e);
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
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        batras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grupoc = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        bsiguiente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(860, 270));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(860, 270));
        jPanel1.setOpaque(false);

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

        grupoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        grupoc.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        grupoc.setEnabled(false);
        grupoc.setOpaque(false);
        jScrollPane1.setViewportView(grupoc);

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("C");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(batras, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                .addComponent(bsiguiente)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(bsiguiente)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(batras))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
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
         abrirtresgrupos();
       }catch(Exception e){
           
       }
      
    }//GEN-LAST:event_batrasActionPerformed

    private void bsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsiguienteActionPerformed
     
        try{
       int tamano=Gcronograma.panelcronograma.getTabCount();
        for(int i=0;i<=tamano;i++){
                 Gcronograma.panelcronograma.remove(i);
                 i--;
                 tamano=Gcronograma.panelcronograma.getTabCount(); 
                 if( tamano== 0){
                     break;
                 }
                 
                 }
       }catch(Exception e){
           
       }
    }//GEN-LAST:event_bsiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton batras;
    public static javax.swing.JButton bsiguiente;
    public static javax.swing.JTable grupoc;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
