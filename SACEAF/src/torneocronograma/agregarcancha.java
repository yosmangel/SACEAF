
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
import torneodatoscronograma.datoformulario1;
import torneodatoscronograma.formulario1;


public final class agregarcancha extends javax.swing.JPanel {

    String jornada,nombre_juego,hlocal,idjuego,categoria,idcategoria,idtorneo, hvisitante, sexo,nombrelocal,nombrevisitante,identificadorlocal,identificadorvisitante;
    String dia,mes,year,fecha_juego, id_formulario,idcancha,cancha,eequipo_local,eequipo_visitante;
    static DefaultTableModel modelo;
    
    
    public agregarcancha() {
        initComponents();
        cargardatos();
        cargartabla();

    }

    public static void cargartabla(){
     
     try{
            String[] titulos={"Nombre","Identificador","Hora"};
            String[] registro= new String[3];
            String sql="Select nombre_cancha, numero_identificador, hora_juego from cancha;";
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
            tablacanchas.getColumnModel().getColumn(1).setPreferredWidth(50);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(agregarcancha.class.getName()).log(Level.SEVERE, null, ex);
                }
     }
    public void cargardatos(){
        idjuego=modificarcalendario.labelidjuego.getText();
        categoria=modificarcalendario.combocategoria.getSelectedItem().toString();
        sexo=Principal.labelsexo.getText();
        idtorneo=Principal.labelserialtorneo.getText();
        fecha_juego=(String)asignarcancha.tablacruces.getValueAt(asignarcancha.tablacruces.getSelectedRow(),0);
        campofecha.setText(fecha_juego);
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
            Logger.getLogger(agregarcancha.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(agregarcancha.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(agregarcancha.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(agregarcancha.class.getName()).log(Level.SEVERE, null, ex);
            }
        equipo_visitante.setText(nombrevisitante+" "+identificadorvisitante);
    }
    public void abrirvercancha(){
        vercanchaasignada vca= new vercanchaasignada();
       String titulo= "Ver programacion";
       int index= modificarcalendario.panelmodificar.indexOfTab(titulo);
       
       if (index== -1){
           modificarcalendario.panelmodificar.addTab(titulo, vca);
           int i=modificarcalendario.panelmodificar.indexOfTab(titulo);
           modificarcalendario.panelmodificar.setSelectedIndex(i);
       }else{
           modificarcalendario.panelmodificar.remove(index);
           modificarcalendario.panelmodificar.addTab(titulo, vca);
           int i=modificarcalendario.panelmodificar.indexOfTab(titulo);
           modificarcalendario.panelmodificar.setSelectedIndex(i);
       }

    }
    public void guardar(){
        cancha=(String)tablacanchas.getValueAt(tablacanchas.getSelectedRow(),1);
        id_formulario=modificarcalendario.labelidjuego.getText();
        fecha_juego=campofecha.getText();
        idtorneo=Principal.labelserialtorneo.getText();
        idcancha=idtorneo+cancha;
        categoria=modificarcalendario.combocategoria.getSelectedItem().toString();
        sexo=Principal.labelsexo.getText();
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
            Logger.getLogger(agregarcancha.class.getName()).log(Level.SEVERE, null, ex);
            }
        try{ 
            String sql="Select equipo_local, equipo_visitante from juego where id_juego='"+id_formulario+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            eequipo_local=rs.getString("equipo_local");
            eequipo_visitante=rs.getString("equipo_visitante");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(agregarcancha.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        try{
            datoformulario1 user= new datoformulario1(id_formulario,idtorneo,idcategoria,idcancha,eequipo_local,eequipo_visitante);
            formulario1 in=new formulario1();
            boolean r;
            r=in.Insertar(user);
            if(r==false){
                JOptionPane.showMessageDialog(this,"Guardado","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error "+e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(agregarcancha.class.getName()).log(Level.SEVERE,null,ex);
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
        campofecha = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablacanchas = new javax.swing.JTable();

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

        campofecha.setEditable(false);
        campofecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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
        jScrollPane1.setViewportView(tablacanchas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campofecha, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(equipo_local, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelnombrejuego, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campojornada, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(equipo_visitante, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(bsiguiente)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelnombrejuego, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campojornada, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1)
                            .addComponent(equipo_local)
                            .addComponent(equipo_visitante, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campofecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(bsiguiente))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
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
        guardar();
        int tamano=modificarcalendario.panelmodificar.getTabCount();
        for(int i=0;i<=tamano;i++){
                 modificarcalendario.panelmodificar.remove(i);
                 i--;
                 tamano=modificarcalendario.panelmodificar.getTabCount(); 
                 if( tamano== 0){
                     break;
                 } 
                 }
         abrirvercancha();
        
        }catch(Exception e){
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
         abrirvercancha();
       }catch(Exception ex){
           
       }
        }    
        }
    }//GEN-LAST:event_bsiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bsiguiente;
    public static javax.swing.JTextField campofecha;
    public static javax.swing.JTextField campojornada;
    public static javax.swing.JTextField equipo_local;
    public static javax.swing.JTextField equipo_visitante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel labelnombrejuego;
    public static javax.swing.JTable tablacanchas;
    // End of variables declaration//GEN-END:variables
}
