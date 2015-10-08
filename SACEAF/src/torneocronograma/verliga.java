
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
import torneodatoscronograma.competencia;
import torneodatoscronograma.datojuego;
import torneodatoscronograma.datomodificarrondas;
import torneodatoscronograma.juegos;


public class verliga extends javax.swing.JPanel {

    static DefaultTableModel modelo= new DefaultTableModel();
    DefaultComboBoxModel combo= new DefaultComboBoxModel();
    String nombrecat,id_categoria,id_torneo,idcompetencia,idmodalidad,datopostfase,
           nombre_juego,equipo_local,equipo_visitante,id_juego,jornada,sexo;
    int rondas,nrondas,cont,numero_local,numero_visitante,grupos,ctrl,i;
    static String categoria, idtorneo,grupo,hequipo,idcategoria,sexoc;
    
    public verliga() {
        initComponents();
        cargarequipos();
        comboronda.setEnabled(false);
        verificarronda();
    }
    
    public static void cargarequipos(){
        categoria= panelcrear.combocategoria.getSelectedItem().toString();
        idtorneo= Principal.labelserialtorneo.getText();
        sexoc=Principal.labelsexo.getText();
        try{ 
            String sql="Select id_categoria from categoria where nombre_cat= '"+categoria+"' and sexo='"+sexoc+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            idcategoria=rs.getString("id_categoria");
            break;
            }            
            }catch(SQLException ex){
            Logger.getLogger(verliga.class.getName()).log(Level.SEVERE, null, ex);
            }catch(ClassNotFoundException e){
            Logger.getLogger(verliga.class.getName()).log(Level.SEVERE,null,e);
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
            tablaeliga.setModel(modelo);
            tablaeliga.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaeliga.getColumnModel().getColumn(1).setPreferredWidth(140);
            tablaeliga.getColumnModel().getColumn(2).setPreferredWidth(140);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            tablaeliga.setRowSorter(modeloordenado);
            
        }catch(SQLException ex){
                Logger.getLogger(verliga.class.getName()).log(Level.SEVERE, null, ex);
                }catch(ClassNotFoundException e){
                Logger.getLogger(verliga.class.getName()).log(Level.SEVERE,null,e);
                        }
    }
    public void abrirliga(){
       crearliga cl= new crearliga();
       String titulo= "Liga";
       int index= panelcrear.panelmodalidades.indexOfTab(titulo);
       
       if (index== -1){
           panelcrear.panelmodalidades.addTab(titulo, cl);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }else{
           panelcrear.panelmodalidades.remove(index);
           panelcrear.panelmodalidades.addTab(titulo, cl);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }

   } 
    public void verificarronda(){
        nombrecat=panelcrear.combocategoria.getSelectedItem().toString();
        sexo=Principal.labelsexo.getText();
        try{ 
            String sql="Select id_categoria from categoria where nombre_cat= '"+nombrecat+"' and sexo='"+sexo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            id_categoria=rs.getString("id_categoria");
            break;
            }            
            }catch(SQLException ex){
            Logger.getLogger(verliga.class.getName()).log(Level.SEVERE, null, ex);
            }catch(ClassNotFoundException e){
            Logger.getLogger(verliga.class.getName()).log(Level.SEVERE,null,e);
            }
        id_torneo=Principal.labelserialtorneo.getText();
        idcompetencia=id_torneo+id_categoria+"1"+"0";
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
            }catch(SQLException ex){
            Logger.getLogger(verliga.class.getName()).log(Level.SEVERE, null, ex);
            }catch(ClassNotFoundException e){
            Logger.getLogger(verliga.class.getName()).log(Level.SEVERE,null,e);
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
    public void guardarronda(){
        nombrecat=panelcrear.combocategoria.getSelectedItem().toString();
        sexo=Principal.labelsexo.getText();
        try{ 
            String sql="Select id_categoria from categoria where nombre_cat= '"+nombrecat+"' and sexo='"+sexo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            id_categoria=rs.getString("id_categoria");
            break;
            }            
            }catch(SQLException ex){
            Logger.getLogger(verliga.class.getName()).log(Level.SEVERE, null, ex);
            }catch(ClassNotFoundException e){
            Logger.getLogger(verliga.class.getName()).log(Level.SEVERE,null,e);
            }
        id_torneo=Principal.labelserialtorneo.getText();
        idcompetencia=id_torneo+id_categoria+"1"+"0";
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
            }catch(SQLException ex){
            Logger.getLogger(verliga.class.getName()).log(Level.SEVERE, null, ex);
            }catch(ClassNotFoundException e){
            Logger.getLogger(verliga.class.getName()).log(Level.SEVERE,null,e);
            }
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
                    Logger.getLogger(verliga.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }
    public void guardarjuegos(){
        sexo=Principal.labelsexo.getText();
        try{
            String sql="Select c.nombre_club, e.identificador from club c, equipo e,h_equipo he where c.id_club=e.id_club and e.id_categoria=(Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+sexo+"') and he.id_torneo='"+id_torneo+"' and he.id_equipo=e.id_equipo and he.grupo_equipo='A';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                cont=cont+1;
            }
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(Gcronograma.class.getName()).log(Level.SEVERE, null, ex);
            }
        nombrecat=panelcrear.combocategoria.getSelectedItem().toString();
        sexo=Principal.labelsexo.getText();
        
        try{ 
            String sql="Select id_categoria from categoria where nombre_cat= '"+nombrecat+"' and sexo='"+sexo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            id_categoria=rs.getString("id_categoria");
            break;
            }            
            }catch(SQLException ex){
            Logger.getLogger(dosgrupos.class.getName()).log(Level.SEVERE, null, ex);
            }catch(ClassNotFoundException e){
            Logger.getLogger(dosgrupos.class.getName()).log(Level.SEVERE,null,e);
            }
        id_torneo=Principal.labelserialtorneo.getText();
        rondas=Integer.parseInt(comboronda.getSelectedItem().toString());
        id_juego=id_torneo+id_categoria+rondas+"1"+"A"+"1";
        try{
            String sql="Select id_juego from juego where id_juego='"+id_juego+"' and id_torneo='"+id_torneo+"' and id_categoria='"+id_categoria+"' and grupo='A';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
                ctrl=2;
                break;
                
            }
            }catch(SQLException ex){
            Logger.getLogger(Gcronograma.class.getName()).log(Level.SEVERE, null, ex);
            }catch(ClassNotFoundException e){
            Logger.getLogger(Gcronograma.class.getName()).log(Level.SEVERE,null,e);
            }
        if(ctrl!=2){
        if(cont==3){
            torneocronograma.tresequipos.tresequiposA tea=new torneocronograma.tresequipos.tresequiposA();
            if(rondas==1){
                tea.tresequiposa1();
            }else
                if(rondas==2){
                    tea.tresequiposa2();
                }else
                    if(rondas==3){
                        tea.tresequiposa3();
                    }else
                        if(rondas==4){
                            tea.tresequiposa4();
                        }
        }else
        if(cont==4){
            torneocronograma.cuatroequipos.cuatroequiposA cea= new torneocronograma.cuatroequipos.cuatroequiposA();
            if(rondas==1){
                cea.cuatroequiposa1();
            }else
                if(rondas==2){
                    cea.cuatroequiposa1();
                    cea.cuatroequiposa2();
                }else
                    if(rondas==3){
                        cea.cuatroequiposa1();
                        cea.cuatroequiposa2();
                        cea.cuatroequiposa3();
                    }else
                        if(rondas==4){
                            cea.cuatroequiposa1();
                            cea.cuatroequiposa2();
                            cea.cuatroequiposa3();
                            cea.cuatroequiposa4();
                        }
            
        }else
        if(cont==5){
            torneocronograma.cincoequipos.cincoequiposA ciea= new torneocronograma.cincoequipos.cincoequiposA();
             if(rondas==1){
                ciea.cincoequiposa1();
            }else
                if(rondas==2){
                    ciea.cincoequiposa1();
                    ciea.cincoequiposa2();
                }else
                    if(rondas==3){
                      ciea.cincoequiposa1();
                      ciea.cincoequiposa2();
                      ciea.cincoequiposa3();
                    }else
                        if(rondas==4){
                           ciea.cincoequiposa1();
                           ciea.cincoequiposa2();
                           ciea.cincoequiposa3();
                           ciea.cincoequiposa4();
                        }
        }else
        if(cont==6){
            torneocronograma.seisequipos.seisequiposA seea= new torneocronograma.seisequipos.seisequiposA();
            
            if(rondas==1){
                seea.seisequiposa1();
            }else
                if(rondas==2){
                    seea.seisequiposa1();
                    seea.seisequiposa2();
                }else
                    if(rondas==3){
                      seea.seisequiposa1();
                      seea.seisequiposa2();
                      seea.seisequiposa3();
                    }else
                        if(rondas==4){
                           seea.seisequiposa1();
                           seea.seisequiposa2();
                           seea.seisequiposa3();
                           seea.seisequiposa4();
                        }
        }else
        if(cont==7){
             torneocronograma.sieteequipos.sieteequiposA siea=new torneocronograma.sieteequipos.sieteequiposA();
             
            if(rondas==1){
                siea.sieteequiposa1();
            }else
                if(rondas==2){
                    siea.sieteequiposa1();
                    siea.sieteequiposa2();
                }else
                    if(rondas==3){
                      siea.sieteequiposa1();
                      siea.sieteequiposa2();
                      siea.sieteequiposa3();
                      
                    }else
                        if(rondas==4){
                           siea.sieteequiposa1();
                           siea.sieteequiposa2();
                           siea.sieteequiposa3();
                           siea.sieteequiposa4();
                        }
        }else
        if(cont==8){
            torneocronograma.ochoequipos.ochoequiposA oea= new torneocronograma.ochoequipos.ochoequiposA();
            if(rondas==1){
                oea.ochoequiposa1();
            }else
                if(rondas==2){
                    oea.ochoequiposa1();
                    oea.ochoequiposa2();
                }else
                    if(rondas==3){
                      oea.ochoequiposa1();
                      oea.ochoequiposa2();
                      oea.ochoequiposa3();
                    }else
                        if(rondas==4){
                           oea.ochoequiposa1();
                           oea.ochoequiposa2();
                           oea.ochoequiposa3();
                           oea.ochoequiposa4();
                        }
        }else
        if(cont==9){
             if(rondas==1){
                
            }else
                if(rondas==2){
                    
                }else
                    if(rondas==3){
                      
                    }else
                        if(rondas==4){
                           
                        }
        }else
        if(cont==10){
             if(rondas==1){
                
            }else
                if(rondas==2){
                    
                }else
                    if(rondas==3){
                      
                    }else
                        if(rondas==4){
                           
                        }
        }else
        if(cont==11){
             if(rondas==1){
                
            }else
                if(rondas==2){
                    
                }else
                    if(rondas==3){
                      
                    }else
                        if(rondas==4){
                           
                        }
        }else
        if(cont==12){
            if(rondas==1){
                
            }else
                if(rondas==2){
                    
                }else
                    if(rondas==3){
                      
                    }else
                        if(rondas==4){
                           
                        } 
        }else
        if(cont==13){
            JOptionPane.showMessageDialog(this,"No se poseen cruces para esa cantidad de equipos","Informacion",JOptionPane.INFORMATION_MESSAGE);
        }else
        if(cont==14){
             if(rondas==1){
                
            }else
                if(rondas==2){
                    
                }else
                    if(rondas==3){
                      
                    }else
                        if(rondas==4){
                           
                        }
        }
        }
    }
  
   
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaeliga = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        batras = new javax.swing.JButton();
        bsiguiente = new javax.swing.JButton();
        comboronda = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(860, 270));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(860, 270));
        jPanel1.setOpaque(false);

        tablaeliga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaeliga.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaeliga.setEnabled(false);
        tablaeliga.setOpaque(false);
        jScrollPane1.setViewportView(tablaeliga);

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

        comboronda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rondas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(batras)
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 312, Short.MAX_VALUE)
                        .addComponent(bsiguiente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboronda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboronda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bsiguiente))
                    .addComponent(batras))
                .addGap(0, 25, Short.MAX_VALUE))
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
       guardarjuegos();
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
         abrirliga();
       }catch(Exception e){
           
       }
       
    }//GEN-LAST:event_batrasActionPerformed

    private void bsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsiguienteActionPerformed
        guardarronda();
        guardarjuegos();
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
    public static javax.swing.JComboBox comboronda;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaeliga;
    // End of variables declaration//GEN-END:variables
}
