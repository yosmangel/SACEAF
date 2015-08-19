

package torneoadministracion;

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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import saceaf.Principal;
import torneodatosadm.cancha;
import torneodatosadm.datoborrart;
import torneodatosadm.datocancha;
import torneodatosadm.torneocategoria;

public class torneopcancha extends javax.swing.JPanel {

    static DefaultTableModel modelo;
    static DefaultTableModel modelo1;
    DefaultComboBoxModel masculino= new DefaultComboBoxModel();
    DefaultComboBoxModel femenino= new DefaultComboBoxModel();
    String idcategoria, idtorneo, idcategoriatorneo;
    static String id_torneo;
    String serialtorneo,serialcategoria, serialborrart;
    int ctr;
    public torneopcancha() {
        initComponents();
        cargartabla();
       campoidentificador.setEnabled(false);
       camponombre.setEnabled(false);
       bguardar.setEnabled(false);
       campohora.setEnabled(false);
       campominutos.setEnabled(false);
    }

 public void habilitar(){
     campoidentificador.setEnabled(true);
     camponombre.setEnabled(true);
     bguardar.setEnabled(true);
     bagregar.setEnabled(false);
     beliminar.setEnabled(false);
     bsalir.setEnabled(true);
     campohora.setEnabled(true);
     campominutos.setEnabled(true);
 }
 public static void deshabilitar(){
     campoidentificador.setEnabled(false);
     camponombre.setEnabled(false);
     bguardar.setEnabled(false);
     bagregar.setEnabled(true);
     beliminar.setEnabled(true);
     bsalir.setEnabled(true);
     campohora.setEnabled(false);
     campominutos.setEnabled(false);
 }
 public static void cargartabla(){
     id_torneo=Principal.labelserialtorneo.getText();
     try{
            String[] titulos={"Nombre","Identificador","Hora"};
            String[] registro= new String[3];
            String sql="Select nombre_cancha, numero_identificador, hora_juego from cancha where id_torneo='"+id_torneo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("nombre_cancha");
               registro [1]=rs.getString("numero_identificador");
               registro [2]=rs.getString("hora_juego");
               modelo.addRow(registro);
            }
            tablacanchas.setModel(modelo);
            tablacanchas.getColumnModel().getColumn(0).setPreferredWidth(162);
            tablacanchas.getColumnModel().getColumn(1).setPreferredWidth(50);
            tablacanchas.getColumnModel().getColumn(2).setPreferredWidth(50);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            tablacanchas.setRowSorter(modeloordenado);
            modeloordenado.setRowFilter(RowFilter.regexFilter(filtro.getText()));
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(torneopcancha.class.getName()).log(Level.SEVERE, null, ex);
                }
     }
 public void guardarcancha(){
    String nombre=camponombre.getText();
    String numero_identificador=campoidentificador.getText();
    String torneo=Principal.labelserialtorneo.getText();
    String hora=campohora.getText()+":"+campominutos.getText();
    String id_cancha=torneo+numero_identificador;
       try{
           String sql="Select id_cancha from cancha where id_cancha='"+id_cancha+"' and id_toneo='"+torneo+"';";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
               ctr=2;
               break;
          } 
       }catch(SQLException | ClassNotFoundException ex){
           Logger.getLogger(torneopcancha.class.getName()).log(Level.SEVERE,null,ex);
       }
       
             if(ctr==2){
                 JOptionPane.showMessageDialog(this,"La cancha ya esta agregada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
              campoidentificador.setText("");
              camponombre.setText("");
              campohora.setText("");
              campominutos.setText("");
              deshabilitar();
             }else{
      try{
      datocancha user= new datocancha(id_cancha,nombre,numero_identificador,hora);
      cancha in = new cancha();
      boolean r;
      r=in.Insertar(user);
      if(r==false){
         cargartabla();
         campoidentificador.setText("");
         camponombre.setText("");
         campohora.setText("");
         campominutos.setText("");
         deshabilitar();
      }
      
       }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error "+ e.getMessage(),"Error!!",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(torneopcancha.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
 }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablacanchas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }

        };
        bagregar = new javax.swing.JButton();
        beliminar = new javax.swing.JButton();
        bsalir = new javax.swing.JButton();
        filtro = new javax.swing.JTextField();
        campoidentificador = new javax.swing.JTextField();
        camponombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bguardar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        campohora = new javax.swing.JTextField();
        campominutos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(630, 290));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(630, 290));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Canchas en el Torneo");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(208, 11, 231, 29);

        tablacanchas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablacanchas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablacanchas.setOpaque(false);
        jScrollPane1.setViewportView(tablacanchas);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 88, 262, 177);

        bagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Add 30x30.png"))); // NOI18N
        bagregar.setText("Agregar");
        bagregar.setContentAreaFilled(false);
        bagregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bagregar.setIconTextGap(-2);
        bagregar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Add 40x40.png"))); // NOI18N
        bagregar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bagregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bagregarActionPerformed(evt);
            }
        });
        jPanel1.add(bagregar);
        bagregar.setBounds(549, 88, 71, 51);

        beliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Delete 30x30.png"))); // NOI18N
        beliminar.setText("Eliminar");
        beliminar.setContentAreaFilled(false);
        beliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        beliminar.setIconTextGap(-2);
        beliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/Delete 40x40.png"))); // NOI18N
        beliminar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        beliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        beliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beliminarActionPerformed(evt);
            }
        });
        jPanel1.add(beliminar);
        beliminar.setBounds(551, 157, 69, 51);

        bsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 30x30.png"))); // NOI18N
        bsalir.setText("Salir");
        bsalir.setContentAreaFilled(false);
        bsalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bsalir.setIconTextGap(-2);
        bsalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 40x40.png"))); // NOI18N
        bsalir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bsalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsalirActionPerformed(evt);
            }
        });
        jPanel1.add(bsalir);
        bsalir.setBounds(551, 214, 69, 51);

        filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtroKeyReleased(evt);
            }
        });
        jPanel1.add(filtro);
        filtro.setBounds(10, 57, 144, 25);

        campoidentificador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(campoidentificador);
        campoidentificador.setBounds(300, 110, 73, 28);
        jPanel1.add(camponombre);
        camponombre.setBounds(334, 180, 159, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Numero Identificador");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(282, 88, 128, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(334, 157, 159, 17);

        bguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/guardar30x30.png"))); // NOI18N
        bguardar.setText("Guardar");
        bguardar.setContentAreaFilled(false);
        bguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bguardar.setIconTextGap(-2);
        bguardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosformulario/guardar40x40.png"))); // NOI18N
        bguardar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bguardarActionPerformed(evt);
            }
        });
        jPanel1.add(bguardar);
        bguardar.setBounds(370, 210, 90, 51);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Hora");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(460, 90, 40, 20);
        jPanel1.add(campohora);
        campohora.setBounds(440, 110, 30, 30);
        jPanel1.add(campominutos);
        campominutos.setBounds(480, 110, 50, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText(":");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(470, 110, 10, 30);

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

    private void bagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagregarActionPerformed
        habilitar();
    }//GEN-LAST:event_bagregarActionPerformed

    private void beliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliminarActionPerformed
      
        try{
        String nombre= (String) tablacanchas.getValueAt(tablacanchas.getSelectedRow(),1);
        if( nombre != null){
        int opc=JOptionPane.showConfirmDialog(null,"Desea eliminar al arbitro "+nombre+"?", "Informacion",JOptionPane.YES_NO_OPTION);
        if(opc==0){
            
            try{
           String sql="Select  from categoria where nombre_cat='"+nombre+"'";
           Conexion parametros = new Conexion();
           Class.forName(parametros.getDriver());
           Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet rs=st.executeQuery(sql);
           while(rs.first()){
               serialcategoria=rs.getString("id_categoria");
               break;
          } 
       }catch(SQLException ex){
           Logger.getLogger(torneopcancha.class.getName()).log(Level.SEVERE,null,ex);
       }catch(ClassNotFoundException e){
           Logger.getLogger(torneopcancha.class.getName()).log(Level.SEVERE,null,e);
       }
            serialtorneo=Principal.labelserialtorneo.getText();
            serialborrart=serialtorneo+serialcategoria;
            
            try{
                
                datoborrart user=new datoborrart(serialborrart);
                torneocategoria in= new torneocategoria();
                boolean r;
                r=in.Eliminar(user);
                if(r==false){
                 cargartabla();
          }
                
                
            }catch(SQLException ex){
                Logger.getLogger(torneopcancha.class.getName()).log(Level.SEVERE,null, ex);
            }catch(ClassNotFoundException e){
                Logger.getLogger(torneopcancha.class.getName()).log(Level.SEVERE, null,e);
            }
        }
        }
        }catch(Exception e){
       JOptionPane.showMessageDialog(null,"Debe seleccionar una categoria para poder Eliminarla","Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_beliminarActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
     torneogadministracion.paneltadministracion.remove(this);
     torneogadministracion.habilitar();
    }//GEN-LAST:event_bsalirActionPerformed

    private void filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroKeyReleased
        cargartabla();
        
    }//GEN-LAST:event_filtroKeyReleased

    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        guardarcancha();
    }//GEN-LAST:event_bguardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bagregar;
    public static javax.swing.JButton beliminar;
    public static javax.swing.JButton bguardar;
    public static javax.swing.JButton bsalir;
    public static javax.swing.JTextField campohora;
    public static javax.swing.JTextField campoidentificador;
    public static javax.swing.JTextField campominutos;
    public static javax.swing.JTextField camponombre;
    public static javax.swing.JTextField filtro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablacanchas;
    // End of variables declaration//GEN-END:variables
}
