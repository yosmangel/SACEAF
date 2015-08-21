package Equipo;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class mostrarequipo extends javax.swing.JPanel {

    static DefaultTableModel tmasculino=new DefaultTableModel();
    static DefaultTableModel tfemenino=new DefaultTableModel();
    
    public mostrarequipo() {
        initComponents();
        equiposmasculinos();
        mostrarequipo.rmasculino.setSelected(true);
    }

    public static void equiposfemenino(){
        String serial=(String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),0);
        try{
            String[] titulos= {"Serial del Equipo", "Club"," ","Categoria","Disciplina"," Delegado","Bloqueado"};
            String[] registros= new String[7];
            String sql="Select equipo.id_equipo, club.nombre_club, equipo.identificador , categoria.nombre_cat, disciplina.nombre_disciplina,equipo.delegadoeq, equipo.bloqueo from equipo INNER Join club ON equipo.id_club= club.id_club INNER Join categoria ON equipo.id_categoria=categoria.id_categoria INNER Join disciplina ON equipo.id_disciplina=disciplina.id_disciplina where categoria.sexo='Femenino' and club.id_club='"+serial+"';";
            Conexion parametros=new Conexion();
            Class.forName(parametros.getDriver());
            Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
            tfemenino= new DefaultTableModel(null,titulos);
            Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                registros [0]=rs.getString("equipo.id_equipo");
                registros [1]=rs.getString("club.nombre_club");
                registros [2]=rs.getString("equipo.identificador");
                registros [3]=rs.getString("categoria.nombre_cat");
                registros [4]=rs.getString("disciplina.nombre_disciplina");
                registros [5]=rs.getString("equipo.delegadoeq");
                registros [6]=rs.getString("equipo.bloqueo");
                tfemenino.addRow(registros);
            }
            mostrarequipo.tablaequipos.setModel(tfemenino);
            mostrarequipo.tablaequipos.getColumnModel().getColumn(0).setPreferredWidth(126);
            mostrarequipo.tablaequipos.getColumnModel().getColumn(1).setPreferredWidth(126);
            mostrarequipo.tablaequipos.getColumnModel().getColumn(2).setPreferredWidth(30);
            mostrarequipo.tablaequipos.getColumnModel().getColumn(3).setPreferredWidth(126);
            mostrarequipo.tablaequipos.getColumnModel().getColumn(4).setPreferredWidth(126);
            mostrarequipo.tablaequipos.getColumnModel().getColumn(5).setPreferredWidth(126);
            mostrarequipo.tablaequipos.getColumnModel().getColumn(6).setPreferredWidth(126);
            TableRowSorter modeloordenado= new TableRowSorter(tfemenino);
            mostrarequipo.tablaequipos.setRowSorter(modeloordenado);
            modeloordenado.setRowFilter(RowFilter.regexFilter(filtro.getText()));
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(mostrarequipo.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    public static void equiposmasculinos(){
        String serial=(String) pmostrar.tablaclub.getValueAt(pmostrar.tablaclub.getSelectedRow(),0);
        try{
            String[] titulos= {"Serial del Equipo", "Club"," ","Categoria","Disciplina"," Delegado","Bloqueado"};
            String[] registros= new String[7];
            String sql="Select equipo.id_equipo, club.nombre_club,equipo.identificador, categoria.nombre_cat, disciplina.nombre_disciplina,equipo.delegadoeq, equipo.bloqueo from equipo INNER Join club ON equipo.id_club= club.id_club INNER Join categoria ON equipo.id_categoria=categoria.id_categoria INNER Join disciplina ON equipo.id_disciplina=disciplina.id_disciplina where categoria.sexo='Masculino' and club.id_club='"+serial+"';";
            Conexion parametros=new Conexion();
            Class.forName(parametros.getDriver());
            Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
            tmasculino= new DefaultTableModel(null,titulos);
            Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                registros [0]=rs.getString("equipo.id_equipo");
                registros [1]=rs.getString("club.nombre_club");
                registros [2]=rs.getString("equipo.identificador");
                registros [3]=rs.getString("categoria.nombre_cat");
                registros [4]=rs.getString("disciplina.nombre_disciplina");
                registros [5]=rs.getString("equipo.delegadoeq");
                registros [6]=rs.getString("equipo.bloqueo");
                tmasculino.addRow(registros);
            }
            mostrarequipo.tablaequipos.setModel(tmasculino);
            mostrarequipo.tablaequipos.getColumnModel().getColumn(0).setPreferredWidth(126);
            mostrarequipo.tablaequipos.getColumnModel().getColumn(1).setPreferredWidth(126);
            mostrarequipo.tablaequipos.getColumnModel().getColumn(2).setPreferredWidth(30);
            mostrarequipo.tablaequipos.getColumnModel().getColumn(3).setPreferredWidth(126);
            mostrarequipo.tablaequipos.getColumnModel().getColumn(4).setPreferredWidth(126);
            mostrarequipo.tablaequipos.getColumnModel().getColumn(5).setPreferredWidth(126);
            mostrarequipo.tablaequipos.getColumnModel().getColumn(6).setPreferredWidth(126);
            TableRowSorter modeloordenado= new TableRowSorter(tmasculino);
            mostrarequipo.tablaequipos.setRowSorter(modeloordenado);
            modeloordenado.setRowFilter(RowFilter.regexFilter(filtro.getText()));
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(mostrarequipo.class.getName()).log(Level.SEVERE,null,ex);
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
        }
        ;
        filtro = new javax.swing.JTextField();
        rmasculino = new javax.swing.JRadioButton();
        rfemenino = new javax.swing.JRadioButton();

        setMinimumSize(new java.awt.Dimension(800, 300));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 300));

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 300));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 300));

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

        filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtroKeyReleased(evt);
            }
        });

        rmasculino.setText("Masculino");
        rmasculino.setContentAreaFilled(false);
        rmasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmasculinoActionPerformed(evt);
            }
        });

        rfemenino.setText("Femenino");
        rfemenino.setContentAreaFilled(false);
        rfemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rfemeninoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rmasculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rfemenino)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rmasculino)
                    .addComponent(rfemenino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
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

    private void rmasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmasculinoActionPerformed
        mostrarequipo.rmasculino.setSelected(true);
        equiposmasculinos();
        if(mostrarequipo.rmasculino.isSelected()==true){
           mostrarequipo.rfemenino.setSelected(false);
        }
        
    }//GEN-LAST:event_rmasculinoActionPerformed

    private void rfemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rfemeninoActionPerformed
        mostrarequipo.rfemenino.setSelected(true);
        equiposfemenino();
        if(mostrarequipo.rfemenino.isSelected()==true){
            mostrarequipo.rmasculino.setSelected(false);
        }
    }//GEN-LAST:event_rfemeninoActionPerformed

    private void filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyReleased
        if(mostrarequipo.rmasculino.isSelected()==true){
            equiposmasculinos();
        }else
            if(mostrarequipo.rfemenino.isSelected()==true){
                equiposfemenino();
            }
    }//GEN-LAST:event_filtroKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField filtro;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JRadioButton rfemenino;
    public static javax.swing.JRadioButton rmasculino;
    public static javax.swing.JTable tablaequipos;
    // End of variables declaration//GEN-END:variables
}
