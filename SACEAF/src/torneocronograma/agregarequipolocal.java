
package torneocronograma;

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
import javax.swing.table.TableRowSorter;
import saceaf.Principal;
import torneodatoscronograma.datoformulario2;
import torneodatoscronograma.formulario2;


public final class agregarequipolocal extends javax.swing.JPanel {

    DefaultTableModel modelo;
    DefaultTableModel modelo1;
    String jornada,nombre_juego,hlocal,idjuego,categoria,idcategoria,idtorneo, hvisitante, sexo,nombrelocal,nombrevisitante,identificadorlocal,identificadorvisitante;
    String dia,mes,year,fecha_juego;
    String nombre, apellido,cedula,idhjugador,idformulario,formulariotitular;
    int numero;
    public agregarequipolocal() {
        initComponents();
        cargardatos();
        cargarjugadorese();
        cargartitulares();
        labelserialj.setVisible(false);
    }

    public void cargarjugadorese(){
        idtorneo= Principal.labelserialtorneo.getText();
        hlocal=panelresultados.labelequipolocal.getText();
             try{
            String[] titulos={"N°","Cedula","Nombre","Apellido"};
            String[] registro= new String[4];
            String sql="Select hj.n_nomina ,j.cedula, j.nombre_j, j.apellido_j from jugador j, h_jugador hj where hj.cedula=j.cedula and hj.id_torneo='"+idtorneo+"' and hj.id_hequipo='"+hlocal+"' order by hj.n_nomina;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo1= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("hj.n_nomina"); 
               registro [1]=rs.getString("j.cedula");
               registro [2]=rs.getString("j.nombre_j");
               registro [3]=rs.getString("j.apellido_j");
               modelo1.addRow(registro);
            }
            tablajugadores.setModel(modelo1);
            tablajugadores.getColumnModel().getColumn(0).setPreferredWidth(27);
            tablajugadores.getColumnModel().getColumn(1).setPreferredWidth(80);
            tablajugadores.getColumnModel().getColumn(2).setPreferredWidth(80);
            tablajugadores.getColumnModel().getColumn(3).setPreferredWidth(80);
            TableRowSorter modeloordenado= new TableRowSorter(modelo1);
            tablajugadores.setRowSorter(modeloordenado);
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(agregarequipolocal.class.getName()).log(Level.SEVERE, null, ex);
                }
        
       
    }
    public void cargartitulares(){
        idjuego= panelresultados.labelserialformulario.getText();
        hlocal=panelresultados.labelequipolocal.getText();
        
             try{
            String[] titulos={"N°","Cedula","Nombre","Apellido"};
            String[] registro= new String[4];
            String sql="Select ft.numero_jugador ,j.cedula, j.nombre_j, j.apellido_j from formulariotitular ft, formulario f,jugador j, h_jugador hj where hj.cedula=j.cedula and ft.id_formulario='"+idjuego+"' and hj.id_hequipo='"+hlocal+"' and f.id_formulario='"+idjuego+"' and f.id_formulario=ft.id_formulario and ft.id_hjugador=hj.id_hjugador order by ft.numero_jugador;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("ft.numero_jugador"); 
               registro [1]=rs.getString("j.cedula");
               registro [2]=rs.getString("j.nombre_j");
               registro [3]=rs.getString("j.apellido_j");
               modelo.addRow(registro);
            }
            titulareslocal.setModel(modelo);
            titulareslocal.getColumnModel().getColumn(0).setPreferredWidth(30);
            titulareslocal.getColumnModel().getColumn(1).setPreferredWidth(90);
            titulareslocal.getColumnModel().getColumn(2).setPreferredWidth(90);
            titulareslocal.getColumnModel().getColumn(3).setPreferredWidth(90);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            titulareslocal.setRowSorter(modeloordenado);
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(agregarequipolocal.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public void cargardatos(){
        hlocal=panelresultados.labelequipolocal.getText();
        try{ 
            String sql="Select c.nombre_club, e.identificador from club c,equipo e, h_equipo he where he.id_hequipo= '"+hlocal+"' and he.id_equipo=e.id_equipo and e.id_club=c.id_club;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            nombrelocal=rs.getString("c.nombre_club");
            identificadorlocal=rs.getString("e.identificador");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(agregarequipolocal.class.getName()).log(Level.SEVERE, null, ex);
            }
       labelnombreeq.setText(nombrelocal+" "+identificadorlocal);
    }
    public void abriragregarequipovisitante(){
        agregarequipovisitante vfj= new agregarequipovisitante();
       String titulo= "Equipo Visitante";
       int index= panelresultados.panelresultado.indexOfTab(titulo);
       
       if (index== -1){
           panelresultados.panelresultado.addTab(titulo, vfj);
           int i=panelresultados.panelresultado.indexOfTab(titulo);
           panelresultados.panelresultado.setSelectedIndex(i);
       }else{
           panelresultados.panelresultado.remove(index);
           panelresultados.panelresultado.addTab(titulo, vfj);
           int i=panelresultados.panelresultado.indexOfTab(titulo);
           panelresultados.panelresultado.setSelectedIndex(i);
       }

    }
    public void agregar(){
        cedula=(String)tablajugadores.getValueAt(tablajugadores.getSelectedRow(),1);
        nombre=(String)tablajugadores.getValueAt(tablajugadores.getSelectedRow(),2);
        apellido=(String)tablajugadores.getValueAt(tablajugadores.getSelectedRow(),3);
        
        labelserialj.setText(cedula);
        camponombre.setText(nombre+" "+apellido);
    }
    public void guardar(){
        idtorneo=Principal.labelserialtorneo.getText();
        cedula=labelserialj.getText();
        hlocal=panelresultados.labelequipolocal.getText();
        idformulario=panelresultados.labelserialformulario.getText();
        idhjugador=idtorneo+cedula;
        numero=Integer.parseInt(camponumero.getText());
        formulariotitular=idformulario+cedula;
        try{
            datoformulario2 user=new datoformulario2(idtorneo,hlocal,idformulario,idhjugador,numero,formulariotitular);
            formulario2 in=new formulario2();
            boolean r;
            r=in.Insertar(user);
            if(r==false){
                JOptionPane.showMessageDialog(this,"Guardado","Informacion",JOptionPane.INFORMATION_MESSAGE);
                camponombre.setText("");
                camponumero.setText("");
                labelserialj.setText("");
                cargartitulares();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error "+e.getMessage(),"Error!", JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(agregarequipolocal.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bsiguiente = new javax.swing.JButton();
        bagregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablajugadores = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        titulareslocal = new javax.swing.JTable();
        camponombre = new javax.swing.JTextField();
        camponumero = new javax.swing.JTextField();
        labelserialj = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelnombreeq = new javax.swing.JLabel();
        bguardar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(860, 270));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(860, 270));
        jPanel1.setOpaque(false);

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

        tablajugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablajugadores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tablajugadores);

        titulareslocal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        titulareslocal.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(titulareslocal);

        camponombre.setEditable(false);
        camponombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        camponumero.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("N°");

        bguardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(camponumero, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(camponombre, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(bagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labelnombreeq, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bsiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(labelserialj, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labelnombreeq, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bguardar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel1)))
                        .addGap(3, 3, 3)
                        .addComponent(camponumero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(camponombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(bagregar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(labelserialj, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(bsiguiente)))
                .addContainerGap())
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

    private void bsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsiguienteActionPerformed
       
        try{
       int tamano=panelresultados.panelresultado.getTabCount();
        for(int i=0;i<=tamano;i++){
                 panelresultados.panelresultado.remove(i);
                 i--;
                 tamano=panelresultados.panelresultado.getTabCount(); 
                 if( tamano== 0){
                     break;
                 } 
                 }
         abriragregarequipovisitante();
       }catch(Exception e){
           
       }
        
    }//GEN-LAST:event_bsiguienteActionPerformed

    private void bagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagregarActionPerformed
       try{
           agregar();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,"Seleccione algun jugador de la tabla a la izquierda de la pantalla","Informacion",JOptionPane.INFORMATION_MESSAGE);
       }
    }//GEN-LAST:event_bagregarActionPerformed

    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        guardar();
    }//GEN-LAST:event_bguardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bagregar;
    public static javax.swing.JButton bguardar;
    public static javax.swing.JButton bsiguiente;
    public static javax.swing.JTextField camponombre;
    public static javax.swing.JTextField camponumero;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel labelnombreeq;
    public static javax.swing.JLabel labelserialj;
    public static javax.swing.JTable tablajugadores;
    public static javax.swing.JTable titulareslocal;
    // End of variables declaration//GEN-END:variables
}
