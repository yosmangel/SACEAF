
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




public final class vercalendario extends javax.swing.JPanel {

    DefaultComboBoxModel combo=new DefaultComboBoxModel();
    String categoria,idcategoria,nombre_modalidad;
    
    public vercalendario() {
        initComponents();
        cargarcategorias();
        bloquearcat();
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
          Logger.getLogger(vercalendario.class.getName()).log(Level.SEVERE,null,ex);
          }
  }
    public void abrircruces(){
       cruces c= new cruces();
       String titulo= "Cruces";
       int index= panelvercalendario.indexOfTab(titulo);
       
       if (index== -1){
           panelvercalendario.addTab(titulo, c);
           int i=panelvercalendario.indexOfTab(titulo);
           panelvercalendario.setSelectedIndex(i);
       }else{
           panelvercalendario.remove(index);
           panelvercalendario.addTab(titulo, c);
           int i=panelvercalendario.indexOfTab(titulo);
           panelvercalendario.setSelectedIndex(i);
       }

   }          
    public void abrirverjornada(){
       verjornada vj= new verjornada();
       String titulo= "Jornada";
       int index= panelvercalendario.indexOfTab(titulo);
       
       if (index== -1){
           panelvercalendario.addTab(titulo, vj);
           int i=panelvercalendario.indexOfTab(titulo);
           panelvercalendario.setSelectedIndex(i);
       }else{
           panelvercalendario.remove(index);
           panelvercalendario.addTab(titulo, vj);
           int i=panelvercalendario.indexOfTab(titulo);
           panelvercalendario.setSelectedIndex(i);
       }

   }    
    public void bloquearcat(){
        categoria= combocategoria.getSelectedItem().toString();
        if("Seleccione la Categoria".equals(categoria)){
            rcruces.setEnabled(false);
            rjornadas.setEnabled(false);
        }else{
           rcruces.setEnabled(true);
           rjornadas.setEnabled(true); 
        }
    }
    public void bloquearcombo(){
        if(rcruces.isSelected()==true ||  rjornadas.isSelected()==true){
            combocategoria.setEnabled(false);
        }else{
            try{
         int tamano=panelvercalendario.getTabCount();              
        for(int i=0;i<=tamano;i++){
                 panelvercalendario.remove(i);
                 i--;
                 tamano=panelvercalendario.getTabCount(); 
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
        rcruces = new javax.swing.JRadioButton();
        rjornadas = new javax.swing.JRadioButton();
        panelvercalendario = new javax.swing.JTabbedPane();

        setMinimumSize(new java.awt.Dimension(880, 330));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(880, 330));
        jPanel1.setOpaque(false);

        combocategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocategoriaActionPerformed(evt);
            }
        });

        rcruces.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rcruces.setText("Cruces");
        rcruces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcrucesActionPerformed(evt);
            }
        });

        rjornadas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rjornadas.setText("Jornadas");
        rjornadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rjornadasActionPerformed(evt);
            }
        });

        panelvercalendario.setMinimumSize(new java.awt.Dimension(860, 273));
        panelvercalendario.setPreferredSize(new java.awt.Dimension(860, 273));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelvercalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(combocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(rcruces, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rjornadas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rcruces)
                    .addComponent(rjornadas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelvercalendario, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
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

    private void rcrucesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcrucesActionPerformed
       rjornadas.setSelected(false);
       
        if(rcruces.isSelected()==true){
         bloquearcombo();
         abrircruces(); 
        }else
        if(rcruces.isSelected()==false){
            
         combocategoria.setEnabled(true);
         try{
         int tamano=panelvercalendario.getTabCount();              
         for(int i=0;i<=tamano;i++){
                 panelvercalendario.remove(i);
                 i--;
                 tamano=panelvercalendario.getTabCount(); 
                 if( tamano== -1){
                 break;
                 }
                 }

       }catch(Exception e){
           
       } 
        }
    }//GEN-LAST:event_rcrucesActionPerformed

    private void rjornadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rjornadasActionPerformed
        rcruces.setSelected(false);
        if(rjornadas.isSelected()==true){
         bloquearcombo();
         abrirverjornada(); 
        }else
        if(rjornadas.isSelected()==false){
         combocategoria.setEnabled(true);
         try{
         int tamano=panelvercalendario.getTabCount();              
         for(int i=0;i<=tamano;i++){
                 panelvercalendario.remove(i);
                 i--;
                 tamano=panelvercalendario.getTabCount(); 
                 if( tamano== -1){
                 break;
                 }
                 }

       }catch(Exception e){
           
       } 
        }
        
           
  
    }//GEN-LAST:event_rjornadasActionPerformed

    private void combocategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocategoriaActionPerformed
       bloquearcat();
    }//GEN-LAST:event_combocategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox combocategoria;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JTabbedPane panelvercalendario;
    public static javax.swing.JRadioButton rcruces;
    public static javax.swing.JRadioButton rjornadas;
    // End of variables declaration//GEN-END:variables
}
