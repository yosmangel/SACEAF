
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
import saceaf.Principal;
import torneodatoscronograma.datofechajuego;
import torneodatoscronograma.fecha_juego;


public final class agregarfecha extends javax.swing.JPanel {

    String jornada,nombre_juego,hlocal,idjuego,categoria,idcategoria,idtorneo, hvisitante, sexo,nombrelocal,nombrevisitante,identificadorlocal,identificadorvisitante;
    String dia,mes,year,fecha_juego;
    public agregarfecha() {
        initComponents();
        cargardatos();

    }

    public void cargardatos(){
        idjuego=modificarcalendario.labelidjuego.getText();
        categoria=modificarcalendario.combocategoria.getSelectedItem().toString();
        sexo=Principal.labelsexo.getText();
        idtorneo=Principal.labelserialtorneo.getText();
        try{ 
            String sql="Select id_categoria from categoria where nombre_cat= '"+categoria+"' and sexo='"+sexo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            idcategoria=rs.getString("id_categoria");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(agregarfecha.class.getName()).log(Level.SEVERE, null, ex);
            }
        try{ 
            String sql="Select jornada,nombre_juego,equipo_local, equipo_visitante from juego where id_juego='"+idjuego+"' and id_categoria='"+idcategoria+"' and id_torneo='"+idtorneo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            jornada=rs.getString("jornada");
            nombre_juego=rs.getString("nombre_juego");
            hlocal=rs.getString("equipo_local");
            hvisitante=rs.getString("equipo_visitante");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(agregarfecha.class.getName()).log(Level.SEVERE, null, ex);
            }
        campojornada.setText(jornada);
        labelnombrejuego.setText(nombre_juego);
        try{ 
            String sql="Select c.nombre_club, e.identificador from club c, equipo e, h_equipo he where he.id_hequipo='"+hlocal+"' and he.id_equipo=e.id_equipo and e.id_club=c.id_club;";
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
            Logger.getLogger(agregarfecha.class.getName()).log(Level.SEVERE, null, ex);
            }
        equipo_local.setText(nombrelocal+" "+identificadorlocal);
        try{ 
            String sql="Select c.nombre_club, e.identificador from club c, equipo e, h_equipo he where he.id_hequipo='"+hvisitante+"' and he.id_equipo=e.id_equipo and e.id_club=c.id_club;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            nombrevisitante=rs.getString("c.nombre_club");
            identificadorvisitante=rs.getString("e.identificador");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(agregarfecha.class.getName()).log(Level.SEVERE, null, ex);
            }
        equipo_visitante.setText(nombrevisitante+" "+identificadorvisitante);
    }
    public void abrirverfecha(){
        verfechajornada vfj= new verfechajornada();
       String titulo= "Ver Fecha";
       int index= modificarcalendario.panelmodificar.indexOfTab(titulo);
       
       if (index== -1){
           modificarcalendario.panelmodificar.addTab(titulo, vfj);
           int i=modificarcalendario.panelmodificar.indexOfTab(titulo);
           modificarcalendario.panelmodificar.setSelectedIndex(i);
       }else{
           modificarcalendario.panelmodificar.remove(index);
           modificarcalendario.panelmodificar.addTab(titulo, vfj);
           int i=modificarcalendario.panelmodificar.indexOfTab(titulo);
           modificarcalendario.panelmodificar.setSelectedIndex(i);
       }

    }
    public void guardar(){
        idjuego=modificarcalendario.labelidjuego.getText();
        dia=campodia.getText();
        mes=campomes.getText();
        year=campoyear.getText();
        fecha_juego=year+"/"+mes+"/"+dia;
        try{
            datofechajuego user= new datofechajuego(idjuego,fecha_juego);
            fecha_juego in=new fecha_juego();
            boolean r;
            r=in.Insertar(user);
            if(r==false){
                JOptionPane.showMessageDialog(this,"Guardado","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(agregarfecha.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bsiguiente = new javax.swing.JButton();
        campojornada = new javax.swing.JTextField();
        labelnombrejuego = new javax.swing.JLabel();
        equipo_local = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        equipo_visitante = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campodia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campomes = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoyear = new javax.swing.JTextField();
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

        campojornada.setEditable(false);

        labelnombrejuego.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelnombrejuego.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        equipo_local.setEditable(false);
        equipo_local.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("VS");

        equipo_visitante.setEditable(false);
        equipo_visitante.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Fecha del Juego");

        campodia.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("/");

        campomes.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("/");

        campoyear.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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
                .addGap(254, 254, 254)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(equipo_local, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(equipo_visitante, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campodia, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campomes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(bguardar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoyear, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addComponent(bsiguiente)
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(labelnombrejuego, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campojornada, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campojornada, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelnombrejuego, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bsiguiente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1)
                            .addComponent(equipo_local, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(equipo_visitante))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campodia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(campomes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(campoyear, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(bguardar)
                .addContainerGap(47, Short.MAX_VALUE))
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

    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        guardar();
         try{
       int tamano=modificarcalendario.panelmodificar.getTabCount();
        for(int i=0;i<=tamano;i++){
                 modificarcalendario.panelmodificar.remove(i);
                 i--;
                 tamano=modificarcalendario.panelmodificar.getTabCount(); 
                 if( tamano== 0){
                     break;
                 } 
                 }
         abrirverfecha();
       }catch(Exception e){
            
       }
    }//GEN-LAST:event_bguardarActionPerformed

    private void bsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsiguienteActionPerformed
        int opc=JOptionPane.showConfirmDialog(null,"Desea seguir sin guardar los datos","Informacion",JOptionPane.YES_NO_OPTION);
        if(opc==0){
        try{
       int tamano=modificarcalendario.panelmodificar.getTabCount();
        for(int i=0;i<=tamano;i++){
                 modificarcalendario.panelmodificar.remove(i);
                 i--;
                 tamano=modificarcalendario.panelmodificar.getTabCount(); 
                 if( tamano== 0){
                     break;
                 } 
                 }
         abrirverfecha();
       }catch(Exception e){
           
       }
        }
    }//GEN-LAST:event_bsiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bguardar;
    public static javax.swing.JButton bsiguiente;
    public static javax.swing.JTextField campodia;
    public static javax.swing.JTextField campojornada;
    public static javax.swing.JTextField campomes;
    public static javax.swing.JTextField campoyear;
    public static javax.swing.JTextField equipo_local;
    public static javax.swing.JTextField equipo_visitante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel labelnombrejuego;
    // End of variables declaration//GEN-END:variables
}
