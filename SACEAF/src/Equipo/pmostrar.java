
package Equipo;

import Basededatos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public final class pmostrar extends javax.swing.JPanel {

   DefaultComboBoxModel masculino= new DefaultComboBoxModel();
   DefaultComboBoxModel femenino= new DefaultComboBoxModel();
   static DefaultTableModel tclubes= new DefaultTableModel();
   static DefaultTableModel tmasculino=new DefaultTableModel();
   static DefaultTableModel tfemenino=new DefaultTableModel();
   
    public pmostrar() {
        initComponents();
        accionclubes();
    }

    
    public void accionclubes(){
       pmostrar.rclubes.setSelected(true);
       pmostrar.rfemenino.setSelected(false);
       pmostrar.rmasculino.setSelected(false);
       pmostrar.combocategoria.setEnabled(false);
       Gclubes.bacceder.setEnabled(true);
       Gclubes.bmodificar.setEnabled(true);
       cargarclubes();
    }
    public void accionfemenino(){
       pmostrar.rfemenino.setSelected(true);
       pmostrar.combocategoria.setEnabled(true);
       Gclubes.bacceder.setEnabled(false);
       Gclubes.bmodificar.setEnabled(false);
       pmostrar.rmasculino.setSelected(false);
       pmostrar.rclubes.setSelected(false); 
       combofemenino();
       equiposfemenino();
             
    }
    public void accionmasculino(){
        pmostrar.rmasculino.setSelected(true);
        pmostrar.combocategoria.setEnabled(true);
        Gclubes.bacceder.setEnabled(false);
        Gclubes.bmodificar.setEnabled(false);
        pmostrar.rfemenino.setSelected(false);
        pmostrar.rclubes.setSelected(false);
        combomasculino();
        equiposmasculinos();
    }
    public void combofemenino(){
        pmostrar.combocategoria.removeAllItems();
        try{
            Conexion parametros =new Conexion();
            Class.forName(parametros.getDriver());
            Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
            Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery("Select nombre_cat from categoria where sexo='Femenino'");
            femenino.addElement("Elige la categoria");
            pmostrar.combocategoria.setModel(femenino);                    
            while(rs.next()){
                femenino.addElement(rs.getObject("nombre_cat"));
                pmostrar.combocategoria.setModel(femenino);
            }
            st.close();
            
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(pmostrar.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void combomasculino(){
        
        pmostrar.combocategoria.removeAllItems();
        try{
            Conexion parametros= new Conexion();
            Class.forName(parametros.getDriver());
            Connection con= DriverManager.getConnection(parametros.getURL(),parametros.getUsuario(), parametros.getPass());
            Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery("Select nombre_cat from categoria where sexo='Masculino'");
            masculino.addElement("Elige la categoria");
            pmostrar.combocategoria.setModel(masculino);
            while(rs.next()){
                masculino.addElement(rs.getObject("nombre_cat"));
                pmostrar.combocategoria.setModel(masculino);
            }
            st.close();
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(pmostrar.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public static void equiposfemenino(){
        String categoria= pmostrar.combocategoria.getSelectedItem().toString();
      
        try{
            String[] titulos= {"Serial del Equipo", "Club"," ","Categoria","Disciplina"," Delegado","Bloqueado"};
            String[] registros= new String[7];
            String sql="Select equipo.id_equipo, club.nombre_club, equipo.identificador, categoria.nombre_cat, disciplina.nombre_disciplina,equipo.delegadoeq, equipo.bloqueo from equipo INNER Join club ON equipo.id_club= club.id_club INNER Join categoria ON equipo.id_categoria=categoria.id_categoria INNER Join disciplina ON equipo.id_disciplina=disciplina.id_disciplina where categoria.sexo='Femenino' and categoria.nombre_cat='"+categoria+"';";
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
            pmostrar.tablaclub.setModel(tfemenino);
            pmostrar.tablaclub.getColumnModel().getColumn(0).setPreferredWidth(135);
            pmostrar.tablaclub.getColumnModel().getColumn(1).setPreferredWidth(135);
            pmostrar.tablaclub.getColumnModel().getColumn(2).setPreferredWidth(36);
            pmostrar.tablaclub.getColumnModel().getColumn(3).setPreferredWidth(135);
            pmostrar.tablaclub.getColumnModel().getColumn(4).setPreferredWidth(135);
            pmostrar.tablaclub.getColumnModel().getColumn(5).setPreferredWidth(135);
            pmostrar.tablaclub.getColumnModel().getColumn(6).setPreferredWidth(135);
            TableRowSorter modeloordenado= new TableRowSorter(tfemenino);
            pmostrar.tablaclub.setRowSorter(modeloordenado);
            modeloordenado.setRowFilter(RowFilter.regexFilter(filtro.getText()));
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(pmostrar.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    public static void equiposmasculinos(){
        String categoria= pmostrar.combocategoria.getSelectedItem().toString();
        try{
            String[] titulos= {"Serial del Equipo", "Club"," ","Categoria","Disciplina"," Delegado","Bloqueado"};
            String[] registros= new String[7];
            String sql="Select equipo.id_equipo, club.nombre_club, equipo.identificador ,categoria.nombre_cat, disciplina.nombre_disciplina,equipo.delegadoeq, equipo.bloqueo from equipo INNER Join club ON equipo.id_club= club.id_club INNER Join categoria ON equipo.id_categoria=categoria.id_categoria INNER Join disciplina ON equipo.id_disciplina=disciplina.id_disciplina where categoria.sexo='Masculino' and categoria.nombre_cat='"+categoria+"';";
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
            pmostrar.tablaclub.setModel(tmasculino);
            pmostrar.tablaclub.getColumnModel().getColumn(0).setPreferredWidth(135);
            pmostrar.tablaclub.getColumnModel().getColumn(1).setPreferredWidth(135);
            pmostrar.tablaclub.getColumnModel().getColumn(2).setPreferredWidth(36);
            pmostrar.tablaclub.getColumnModel().getColumn(3).setPreferredWidth(135);
            pmostrar.tablaclub.getColumnModel().getColumn(4).setPreferredWidth(135);
            pmostrar.tablaclub.getColumnModel().getColumn(5).setPreferredWidth(135);
            pmostrar.tablaclub.getColumnModel().getColumn(6).setPreferredWidth(135);
            TableRowSorter modeloordenado= new TableRowSorter(tmasculino);
            pmostrar.tablaclub.setRowSorter(modeloordenado);
            modeloordenado.setRowFilter(RowFilter.regexFilter(filtro.getText()));
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(pmostrar.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public static void cargarclubes(){
        try{
        String[] titulos={"Serial del Club","Nombre del Club","Municipio","Presidente Club","Bloqueado"};
        String[] registros= new String[5];
        String sql="Select club.id_club, club.nombre_club, municipio.nombre_municipio, club.presidenteclub, club.bloqueo from club Inner Join municipio ON club.id_municipio= municipio.id_municipio;";
        Conexion parametros= new Conexion();
        Class.forName(parametros.getDriver());
        Connection con= DriverManager.getConnection(parametros.getURL(),parametros.getUsuario(), parametros.getPass());
        tclubes= new DefaultTableModel(null,titulos);
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()){
            registros [0]= rs.getString("club.id_club");
            registros [1]= rs.getString("club.nombre_club");
            registros [2]= rs.getString("municipio.nombre_municipio");
            registros [3]= rs.getString("club.presidenteclub");
            registros [4]= rs.getString("club.bloqueo");
            tclubes.addRow(registros);
        }
        pmostrar.tablaclub.setModel(tclubes);
        pmostrar.tablaclub.getColumnModel().getColumn(0).setPreferredWidth(170);
        pmostrar.tablaclub.getColumnModel().getColumn(1).setPreferredWidth(170);
        pmostrar.tablaclub.getColumnModel().getColumn(2).setPreferredWidth(170);
        pmostrar.tablaclub.getColumnModel().getColumn(3).setPreferredWidth(170);
        pmostrar.tablaclub.getColumnModel().getColumn(4).setPreferredWidth(170);
        TableRowSorter modeloordenado= new TableRowSorter(tclubes);
        pmostrar.tablaclub.setRowSorter(modeloordenado);
        modeloordenado.setRowFilter(RowFilter.regexFilter(filtro.getText()));
      
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(pmostrar.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaclub = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        filtro = new javax.swing.JTextField();
        combocategoria = new javax.swing.JComboBox();
        rfemenino = new javax.swing.JRadioButton();
        rmasculino = new javax.swing.JRadioButton();
        rclubes = new javax.swing.JRadioButton();

        setMinimumSize(new java.awt.Dimension(870, 300));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(870, 300));
        jPanel1.setOpaque(false);

        tablaclub.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaclub.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaclub.setOpaque(false);
        jScrollPane1.setViewportView(tablaclub);

        filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtroKeyReleased(evt);
            }
        });

        combocategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocategoriaActionPerformed(evt);
            }
        });

        rfemenino.setText("Femenino");
        rfemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rfemeninoActionPerformed(evt);
            }
        });

        rmasculino.setText("Masculino");
        rmasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmasculinoActionPerformed(evt);
            }
        });

        rclubes.setText("Clubes");
        rclubes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rclubesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                        .addComponent(rclubes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rmasculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rfemenino)
                        .addGap(34, 34, 34)
                        .addComponent(combocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rfemenino)
                    .addComponent(rmasculino)
                    .addComponent(rclubes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
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

    private void filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyReleased
        if(pmostrar.rclubes.isSelected()== true){
            cargarclubes();
        }else
            if(pmostrar.rfemenino.isSelected()==true){
              
                equiposfemenino();
            
            }else
                if(pmostrar.rmasculino.isSelected()==true){
                    equiposmasculinos();
                }
    }//GEN-LAST:event_filtroKeyReleased

    private void rmasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmasculinoActionPerformed
        accionmasculino();
    }//GEN-LAST:event_rmasculinoActionPerformed

    private void rfemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rfemeninoActionPerformed
       accionfemenino();
    }//GEN-LAST:event_rfemeninoActionPerformed

    private void rclubesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rclubesActionPerformed
       accionclubes();
    }//GEN-LAST:event_rclubesActionPerformed

    private void combocategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocategoriaActionPerformed
       try{
        if(pmostrar.rfemenino.isSelected()== true){
            equiposfemenino();
        }else
            if(pmostrar.rmasculino.isSelected()== true){
                equiposmasculinos();
            }
       }catch(Exception e){
                
       }
    }//GEN-LAST:event_combocategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox combocategoria;
    public static javax.swing.JTextField filtro;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JRadioButton rclubes;
    public static javax.swing.JRadioButton rfemenino;
    public static javax.swing.JRadioButton rmasculino;
    public static javax.swing.JTable tablaclub;
    // End of variables declaration//GEN-END:variables
}
