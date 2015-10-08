
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


public final class tresgrupos extends javax.swing.JPanel {

    static DefaultTableModel modelo= new DefaultTableModel();
    static DefaultTableModel modelo2= new DefaultTableModel();
    DefaultComboBoxModel combo= new DefaultComboBoxModel();
    String nombrecat,id_categoria,id_torneo,idcompetencia,idmodalidad,datopostfase;
    int rondas,nrondas,grupos;
    static String categoria, idtorneo,grupo,hequipo,idcategoria;

    public tresgrupos() {
        initComponents();
        verificarronda();
        cargarequiposa();
        cargarequiposb();
    }

    
    
    public static void cargarequiposa(){
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
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(tresgrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
     try{
            String[] titulos={"N°","Nombre","Identificador"};
            String[] registro= new String[3];
            String sql="Select he.posicion, c.nombre_club, e.identificador from club c, equipo e, h_equipo he where c.id_club=e.id_club and e.id_categoria='"+idcategoria+"' and he.id_equipo=e.id_equipo and he.id_torneo='"+idtorneo+"' and he.grupo_equipo='A' order by he.posicion;";
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
            grupoa.setModel(modelo);
            grupoa.getColumnModel().getColumn(0).setPreferredWidth(45);
            grupoa.getColumnModel().getColumn(1).setPreferredWidth(120);
            grupoa.getColumnModel().getColumn(2).setPreferredWidth(120);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            grupoa.setRowSorter(modeloordenado);
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(tresgrupos.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public static void cargarequiposb(){
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
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(tresgrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
     try{
            String[] titulos={"N°","Nombre","Identificador"};
            String[] registro= new String[3];
            String sql="Select he.posicion, c.nombre_club, e.identificador from club c, equipo e, h_equipo he where c.id_club=e.id_club and e.id_categoria='"+idcategoria+"' and he.id_equipo=e.id_equipo and he.id_torneo='"+idtorneo+"' and he.grupo_equipo='B' order by he.posicion;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo2= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("he.posicion");
               registro [1]=rs.getString("c.nombre_club");
               registro [2]=rs.getString("e.identificador");
               modelo2.addRow(registro);
            }
            grupob.setModel(modelo2);
            grupob.getColumnModel().getColumn(0).setPreferredWidth(45);
            grupob.getColumnModel().getColumn(1).setPreferredWidth(120);
            grupob.getColumnModel().getColumn(2).setPreferredWidth(120);
            TableRowSorter modeloordenado= new TableRowSorter(modelo2);
            grupob.setRowSorter(modeloordenado);
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(tresgrupos.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public void abrircopa(){
       equiposcopa cc= new equiposcopa();
       String titulo= "Copa";
       int index= panelcrear.panelmodalidades.indexOfTab(titulo);
       
       if (index== -1){
           panelcrear.panelmodalidades.addTab(titulo, cc);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }else{
           panelcrear.panelmodalidades.remove(index);
           panelcrear.panelmodalidades.addTab(titulo, cc);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }

   } 
    public void abrirtresgrupos(){
       tresgrupos2 tg2= new tresgrupos2();
       String titulo= "Copa";
       int index= panelcrear.panelmodalidades.indexOfTab(titulo);
       
       if (index== -1){
           panelcrear.panelmodalidades.addTab(titulo, tg2);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }else{
           panelcrear.panelmodalidades.remove(index);
           panelcrear.panelmodalidades.addTab(titulo, tg2);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }

   } 
    public void guardarronda(){
        nombrecat=panelcrear.combocategoria.getSelectedItem().toString();
        try{ 
            String sql="Select id_categoria from categoria where nombre_cat= '"+nombrecat+"' and sexo='Masculino';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            id_categoria=rs.getNString("id_categoria");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(tresgrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
        id_torneo=Principal.labelserialtorneo.getText();
        idmodalidad=id_torneo+id_categoria+"2";
        try{ 
            String sql="Select postfase from modalidad where id_modalidad= '"+idmodalidad+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            datopostfase=rs.getNString("postfase");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(tresgrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
        idcompetencia=idmodalidad+datopostfase;
        try{ 
            String sql="Select grupos, rondas from competencia where id_competencia='"+idcompetencia+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            grupos=rs.getInt("grupos");
            rondas=rs.getInt("rondas");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(tresgrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(grupos!=0){
        if(rondas==0){
            int opc=JOptionPane.showConfirmDialog(null,"Desea guardar esa cantidad de jornadas?","Informacion", JOptionPane.YES_NO_OPTION);
            if(opc==0){
                nrondas= Integer.parseInt(comboronda.getSelectedItem().toString());
                try{
                    datomodificarrondas user= new datomodificarrondas(nrondas,idcompetencia);
                    competencia in= new competencia();
                    boolean r;
                    r=in.Modificar(user);
                    if(r==false){
                        JOptionPane.showMessageDialog(this,"Cantidad de rondas guardadas","Informacion",JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(this,"Error "+ex.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
                }catch(ClassNotFoundException e){
                    Logger.getLogger(tresgrupos.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }
    }
    public void verificarronda(){
        nombrecat=panelcrear.combocategoria.getSelectedItem().toString();
        try{ 
            String sql="Select id_categoria from categoria where nombre_cat= '"+nombrecat+"' and sexo='Masculino';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            id_categoria=rs.getNString("id_categoria");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(tresgrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
        id_torneo=Principal.labelserialtorneo.getText();
       idmodalidad=id_torneo+id_categoria+"2";
        try{ 
            String sql="Select postfase from modalidad where id_modalidad= '"+idmodalidad+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            datopostfase=rs.getNString("postfase");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(tresgrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
        idcompetencia=idmodalidad+datopostfase;
        try{ 
            String sql="Select rondas from competencia where id_competencia='"+idcompetencia+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            rondas=rs.getInt("rondas");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(tresgrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(rondas==0){
            comboronda.setEnabled(true);
        }else{
            comboronda.setEnabled(false);
            comboronda.removeAllItems();
            combo.addElement(rondas);
            comboronda.setModel(combo);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        batras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grupoa = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        bsiguiente = new javax.swing.JButton();
        comborondas = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        grupob = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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

        grupoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        grupoa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        grupoa.setOpaque(false);
        jScrollPane1.setViewportView(grupoa);

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

        comborondas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rondas");

        grupob.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        grupob.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        grupob.setOpaque(false);
        jScrollPane2.setViewportView(grupob);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("A");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("B");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(batras, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addComponent(comborondas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bsiguiente)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(batras))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comborondas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bsiguiente)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
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
        guardarronda();
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
         abrircopa();
       }catch(Exception e){
           
       }
      
    }//GEN-LAST:event_batrasActionPerformed

    private void bsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsiguienteActionPerformed
        guardarronda();
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
    }//GEN-LAST:event_bsiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton batras;
    public static javax.swing.JButton bsiguiente;
    public static javax.swing.JComboBox comborondas;
    public static javax.swing.JTable grupoa;
    public static javax.swing.JTable grupob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
