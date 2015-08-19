
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
import saceaf.Principal;




public final class panelresultados extends javax.swing.JPanel {

    DefaultComboBoxModel combo=new DefaultComboBoxModel();
    String categoria,idcategoria,nombre_modalidad;
    public panelresultados() {
        initComponents();
        cargarcategorias();
        bloquearcat();
        labelserialformulario.setVisible(false);
        labelequipolocal.setVisible(false);
        labelequipovisitante.setVisible(false);
    }

    public void cargarcategorias(){
        String sexo=Principal.labelsexo.getText();
        String idtorneo=Principal.labelserialtorneo.getText();
          combocategoria.removeAllItems();
          try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select c.nombre_cat from categoria c, categoria_torneo ct where c.id_categoria= ct.id_categoria and ct.id_torneo='"+idtorneo+"' and c.sexo='"+sexo+"';");
          combo.addElement("Seleccione la Categoria");
          combocategoria.setModel(combo);
          while(rs.next()){
              combo.addElement(rs.getObject("c.nombre_cat"));
              combocategoria.setModel(combo);
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(panelresultados.class.getName()).log(Level.SEVERE,null,ex);
          }
  }
    public void abrirposiciones(){
       posiciones p= new posiciones();
       String titulo= "Tabla de posiciones";
       int index= panelresultado.indexOfTab(titulo);
       
       if (index== -1){
           panelresultado.addTab(titulo, p);
           int i=panelresultado.indexOfTab(titulo);
           panelresultado.setSelectedIndex(i);
       }else{
           panelresultado.remove(index);
           panelresultado.addTab(titulo, p);
           int i=panelresultado.indexOfTab(titulo);
           panelresultado.setSelectedIndex(i);
       }

   }    
    public void abririntroducirresultados(){
       introducirresultados ir= new introducirresultados();
       String titulo= "Introducir resultados";
       int index= panelresultado.indexOfTab(titulo);
       
       if (index== -1){
           panelresultado.addTab(titulo, ir);
           int i=panelresultado.indexOfTab(titulo);
           panelresultado.setSelectedIndex(i);
       }else{
           panelresultado.remove(index);
           panelresultado.addTab(titulo, ir);
           int i=panelresultado.indexOfTab(titulo);
           panelresultado.setSelectedIndex(i);
       }

   }      
    public void abrirrecopa(){
       crearrecopa cr= new crearrecopa();
       String titulo= "Recopa";
       int index= panelresultado.indexOfTab(titulo);
       
       if (index== -1){
           panelresultado.addTab(titulo, cr);
           int i=panelresultado.indexOfTab(titulo);
           panelresultado.setSelectedIndex(i);
       }else{
           panelresultado.remove(index);
           panelresultado.addTab(titulo, cr);
           int i=panelresultado.indexOfTab(titulo);
           panelresultado.setSelectedIndex(i);
       }

   }    
    public void bloquearcat(){
        categoria= combocategoria.getSelectedItem().toString();
        if("Seleccione la Categoria".equals(categoria)){
            rtablaposiciones.setEnabled(false);
            rpartidosjugados.setEnabled(false);
            rintroducirresultados.setEnabled(false);
        }else{
           rtablaposiciones.setEnabled(true);
           rpartidosjugados.setEnabled(true);
           rintroducirresultados.setEnabled(true); 
        }
    }
    public void bloquearcombo(){
        if(rtablaposiciones.isSelected()==true || rpartidosjugados.isSelected()==true || rintroducirresultados.isSelected()==true){
            combocategoria.setEnabled(false);
        }else{
            try{
         int tamano=panelresultado.getTabCount();              
        for(int i=0;i<=tamano;i++){
                 panelresultado.remove(i);
                 i--;
                 tamano=panelresultado.getTabCount(); 
                 if( tamano== -1){
                 combocategoria.setEnabled(true);
                 break;
                 }
                 }

       }catch(Exception e){
           
       }

        }
    }
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        combocategoria = new javax.swing.JComboBox();
        rtablaposiciones = new javax.swing.JRadioButton();
        rpartidosjugados = new javax.swing.JRadioButton();
        rintroducirresultados = new javax.swing.JRadioButton();
        panelresultado = new javax.swing.JTabbedPane();
        labelserialformulario = new javax.swing.JLabel();
        labelequipolocal = new javax.swing.JLabel();
        labelequipovisitante = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(880, 330));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(880, 330));
        jPanel1.setOpaque(false);

        combocategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocategoriaActionPerformed(evt);
            }
        });

        rtablaposiciones.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rtablaposiciones.setText("Tabla de posiciones");
        rtablaposiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rtablaposicionesActionPerformed(evt);
            }
        });

        rpartidosjugados.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rpartidosjugados.setText("Partidos jugados");
        rpartidosjugados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpartidosjugadosActionPerformed(evt);
            }
        });

        rintroducirresultados.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rintroducirresultados.setText("Introducir resultados");
        rintroducirresultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rintroducirresultadosActionPerformed(evt);
            }
        });

        panelresultado.setMinimumSize(new java.awt.Dimension(860, 273));
        panelresultado.setPreferredSize(new java.awt.Dimension(860, 273));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelresultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(combocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(rtablaposiciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rpartidosjugados, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rintroducirresultados)
                        .addGap(78, 78, 78)
                        .addComponent(labelserialformulario, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelequipolocal))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(labelequipovisitante)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelequipolocal)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelequipovisitante)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(combocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rtablaposiciones)
                                .addComponent(rpartidosjugados)
                                .addComponent(rintroducirresultados))
                            .addComponent(labelserialformulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelresultado, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
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

    private void rtablaposicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rtablaposicionesActionPerformed
       rpartidosjugados.setSelected(false);
       rintroducirresultados.setSelected(false);
       
        if(rtablaposiciones.isSelected()==true){
         bloquearcombo();
         abrirposiciones();
        }else
        if(rtablaposiciones.isSelected()==false){
            
         combocategoria.setEnabled(true);
         try{
         int tamano=panelresultado.getTabCount();              
         for(int i=0;i<=tamano;i++){
                 panelresultado.remove(i);
                 i--;
                 tamano=panelresultado.getTabCount(); 
                 if( tamano== -1){
                 break;
                 }
                 }

       }catch(Exception e){
           
       } 
        }
    }//GEN-LAST:event_rtablaposicionesActionPerformed

    private void rpartidosjugadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpartidosjugadosActionPerformed
        rtablaposiciones.setSelected(false);
        rintroducirresultados.setSelected(false);
         if(rpartidosjugados.isSelected()==true){
         bloquearcombo();
         
        }else
        if(rpartidosjugados.isSelected()==false){
         combocategoria.setEnabled(true);
         try{
         int tamano=panelresultado.getTabCount();              
         for(int i=0;i<=tamano;i++){
                 panelresultado.remove(i);
                 i--;
                 tamano=panelresultado.getTabCount(); 
                 if( tamano== -1){
                 break;
                 }
                 }

       }catch(Exception e){
           
       } 
        }
       
    }//GEN-LAST:event_rpartidosjugadosActionPerformed

    private void rintroducirresultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rintroducirresultadosActionPerformed
        rpartidosjugados.setSelected(false);
        rtablaposiciones.setSelected(false);
        if(rintroducirresultados.isSelected()==true){
         bloquearcombo();
         abririntroducirresultados(); 
        }else
        if(rintroducirresultados.isSelected()==false){
         combocategoria.setEnabled(true);
         try{
         int tamano=panelresultado.getTabCount();              
         for(int i=0;i<=tamano;i++){
                 panelresultado.remove(i);
                 i--;
                 tamano=panelresultado.getTabCount(); 
                 if( tamano== -1){
                 break;
                 }
                 }

       }catch(Exception e){
           
       } 
        }
        
           
  
    }//GEN-LAST:event_rintroducirresultadosActionPerformed

    private void combocategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocategoriaActionPerformed
     bloquearcat();
    }//GEN-LAST:event_combocategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox combocategoria;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel labelequipolocal;
    public static javax.swing.JLabel labelequipovisitante;
    public static javax.swing.JLabel labelserialformulario;
    public static javax.swing.JTabbedPane panelresultado;
    public static javax.swing.JRadioButton rintroducirresultados;
    public static javax.swing.JRadioButton rpartidosjugados;
    public static javax.swing.JRadioButton rtablaposiciones;
    // End of variables declaration//GEN-END:variables
}
