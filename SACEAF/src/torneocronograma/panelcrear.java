
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




public final class panelcrear extends javax.swing.JPanel {

    DefaultComboBoxModel combo=new DefaultComboBoxModel();
    String categoria,idcategoria,nombre_modalidad,sexo,id_torneo;
    
    public panelcrear() {
        initComponents();
        cargarcategorias();
        bloquearcat();
    }

    public void cargarcategorias(){
        combocategoria.removeAllItems();
        sexo=Principal.labelsexo.getText();
        String idtorneo=Principal.labelserialtorneo.getText();
        try{
            Conexion parametros =new Conexion();
            Class.forName(parametros.getDriver());
            Connection con=DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
            Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery("Select c.nombre_cat from categoria c, categoria_torneo ct where c.id_categoria= ct.id_categoria and ct.id_torneo='"+idtorneo+"' and c.sexo='"+sexo+"';");
            combo.addElement("Seleccione la categoria");
            combocategoria.setModel(combo);                    
            while(rs.next()){
                combo.addElement(rs.getObject("c.nombre_cat"));
                combocategoria.setModel(combo);
            }
            st.close();
            
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(panelcrear.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void abrirliga(){
       crearliga cl= new crearliga();
       String titulo= "Liga";
       int index= panelmodalidades.indexOfTab(titulo);
       
       if (index== -1){
           panelmodalidades.addTab(titulo, cl);
           int i=panelmodalidades.indexOfTab(titulo);
           panelmodalidades.setSelectedIndex(i);
       }else{
           panelmodalidades.remove(index);
           panelmodalidades.addTab(titulo, cl);
           int i=panelmodalidades.indexOfTab(titulo);
           panelmodalidades.setSelectedIndex(i);
       }

   }    
    public void abrircopa(){
       crearcopa cc= new crearcopa();
       String titulo= "Copa";
       int index= panelmodalidades.indexOfTab(titulo);
       
       if (index== -1){
           panelmodalidades.addTab(titulo, cc);
           int i=panelmodalidades.indexOfTab(titulo);
           panelmodalidades.setSelectedIndex(i);
       }else{
           panelmodalidades.remove(index);
           panelmodalidades.addTab(titulo, cc);
           int i=panelmodalidades.indexOfTab(titulo);
           panelmodalidades.setSelectedIndex(i);
       }

   }      
    public void abrirrecopa(){
       crearrecopa cr= new crearrecopa();
       String titulo= "Recopa";
       int index= panelmodalidades.indexOfTab(titulo);
       
       if (index== -1){
           panelmodalidades.addTab(titulo, cr);
           int i=panelmodalidades.indexOfTab(titulo);
           panelmodalidades.setSelectedIndex(i);
       }else{
           panelmodalidades.remove(index);
           panelmodalidades.addTab(titulo, cr);
           int i=panelmodalidades.indexOfTab(titulo);
           panelmodalidades.setSelectedIndex(i);
       }

   }    
    public void bloquearcat(){
        categoria= combocategoria.getSelectedItem().toString();
        if("Seleccione la categoria".equals(categoria)){
            rliga.setEnabled(false);
            rcopa.setEnabled(false);
            rrecopa.setEnabled(false);
        }else{
           rliga.setEnabled(true);
           rcopa.setEnabled(true);
           rrecopa.setEnabled(true); 
        }
    }
    public void bloquearcombo(){
        if(rliga.isSelected()==true || rcopa.isSelected()==true || rrecopa.isSelected()==true){
            combocategoria.setEnabled(false);
        }else{
            try{
         int tamano=panelmodalidades.getTabCount();              
        for(int i=0;i<=tamano;i++){
                 panelmodalidades.remove(i);
                 i--;
                 tamano=panelmodalidades.getTabCount(); 
                 if( tamano== -1){
                 combocategoria.setEnabled(true);
                 break;
                 }
                 }

       }catch(Exception e){
           
       }

        }
    }
    public void accioncombo(){
        categoria=combocategoria.getSelectedItem().toString();
        nombre_modalidad=null;
        sexo=Principal.labelsexo.getText();
        id_torneo=Principal.labelserialtorneo.getText();
        try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select id_categoria from categoria where nombre_cat='"+categoria+"' and sexo='"+sexo+"';");
          while(rs.first()){
              idcategoria=rs.getString("id_categoria");
              break;
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(panelcrear.class.getName()).log(Level.SEVERE,null,ex);
          }
        try{
          Conexion parametros= new Conexion();
          Class.forName(parametros.getDriver());
          Connection con= DriverManager.getConnection(parametros.getURL(), parametros.getUsuario(), parametros.getPass());
          Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          ResultSet rs=st.executeQuery("Select nombre_modalidad from modalidad where id_categoria='"+idcategoria+"' and id_torneo='"+id_torneo+"';");
          while(rs.first()){
              nombre_modalidad=rs.getString("nombre_modalidad");
              break;
          }
          st.close();
          }catch(SQLException | ClassNotFoundException ex){
          Logger.getLogger(panelcrear.class.getName()).log(Level.SEVERE,null,ex);
          }
        if(null != nombre_modalidad)switch (nombre_modalidad) {
            case "Liga":
                abrirliga();
                rliga.setEnabled(false);
                rcopa.setEnabled(false);
                rrecopa.setEnabled(false);
                break;
            case "Copa":
                abrircopa();
                rliga.setEnabled(false);
                rcopa.setEnabled(false);
                rrecopa.setEnabled(false);
                break;
            case "Recopa":
                abrirrecopa();
                rliga.setEnabled(false);
                rcopa.setEnabled(false);
                rrecopa.setEnabled(false);
                break;
            default:
                bloquearcat();
                break;
        }
       
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        combocategoria = new javax.swing.JComboBox();
        rliga = new javax.swing.JRadioButton();
        rcopa = new javax.swing.JRadioButton();
        rrecopa = new javax.swing.JRadioButton();
        panelmodalidades = new javax.swing.JTabbedPane();

        setMinimumSize(new java.awt.Dimension(880, 330));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(880, 330));
        jPanel1.setOpaque(false);

        combocategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocategoriaActionPerformed(evt);
                combocategoria2ActionPerformed(evt);
            }
        });

        rliga.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rliga.setText("Liga");
        rliga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rligaActionPerformed(evt);
            }
        });

        rcopa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rcopa.setText("Copa");
        rcopa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcopaActionPerformed(evt);
            }
        });

        rrecopa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rrecopa.setText("Recopa");
        rrecopa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rrecopaActionPerformed(evt);
            }
        });

        panelmodalidades.setMinimumSize(new java.awt.Dimension(860, 273));
        panelmodalidades.setPreferredSize(new java.awt.Dimension(860, 273));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelmodalidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(combocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(rliga, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rcopa, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rrecopa, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rliga)
                    .addComponent(rcopa)
                    .addComponent(rrecopa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelmodalidades, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
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

    private void rligaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rligaActionPerformed
       rcopa.setSelected(false);
       rrecopa.setSelected(false);
       
        if(rliga.isSelected()==true){
         bloquearcombo();
         abrirliga(); 
        }else
        if(rliga.isSelected()==false){
            
         combocategoria.setEnabled(true);
         try{
         int tamano=panelmodalidades.getTabCount();              
         for(int i=0;i<=tamano;i++){
                 panelmodalidades.remove(i);
                 i--;
                 tamano=panelmodalidades.getTabCount(); 
                 if( tamano== -1){
                 break;
                 }
                 }

       }catch(Exception e){
           
       } 
        }
    }//GEN-LAST:event_rligaActionPerformed

    private void rcopaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcopaActionPerformed
        rliga.setSelected(false);
        rrecopa.setSelected(false);
         if(rcopa.isSelected()==true){
         bloquearcombo();
         abrircopa(); 
        }else
        if(rcopa.isSelected()==false){
         combocategoria.setEnabled(true);
         try{
         int tamano=panelmodalidades.getTabCount();              
         for(int i=0;i<=tamano;i++){
                 panelmodalidades.remove(i);
                 i--;
                 tamano=panelmodalidades.getTabCount(); 
                 if( tamano== -1){
                 break;
                 }
                 }

       }catch(Exception e){
           
       } 
        }
       
    }//GEN-LAST:event_rcopaActionPerformed

    private void rrecopaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rrecopaActionPerformed
        rcopa.setSelected(false);
        rliga.setSelected(false);
        if(rrecopa.isSelected()==true){
         bloquearcombo();
         abrirrecopa(); 
        }else
        if(rrecopa.isSelected()==false){
         combocategoria.setEnabled(true);
         try{
         int tamano=panelmodalidades.getTabCount();              
         for(int i=0;i<=tamano;i++){
                 panelmodalidades.remove(i);
                 i--;
                 tamano=panelmodalidades.getTabCount(); 
                 if( tamano== -1){
                 break;
                 }
                 }

       }catch(Exception e){
           
       } 
        }
        
           
  
    }//GEN-LAST:event_rrecopaActionPerformed

    private void combocategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocategoriaActionPerformed
        bloquearcat();
        
    }//GEN-LAST:event_combocategoriaActionPerformed

    private void combocategoria2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocategoria2ActionPerformed
       accioncombo();
    }//GEN-LAST:event_combocategoria2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox combocategoria;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JTabbedPane panelmodalidades;
    public static javax.swing.JRadioButton rcopa;
    public static javax.swing.JRadioButton rliga;
    public static javax.swing.JRadioButton rrecopa;
    // End of variables declaration//GEN-END:variables
}
