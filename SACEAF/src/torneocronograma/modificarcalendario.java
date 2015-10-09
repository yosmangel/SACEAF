
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




public final class modificarcalendario extends javax.swing.JPanel {

    DefaultComboBoxModel combo=new DefaultComboBoxModel();
    String categoria,idcategoria,nombre_modalidad;
   
    public modificarcalendario() {
        initComponents();
        cargarcategorias();
        bloquearcat();
        labelidjuego.setVisible(false);
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
          Logger.getLogger(modificarcalendario.class.getName()).log(Level.SEVERE,null,ex);
          }
  }
    public void abrirfechajornada(){
       fechajornada fj= new fechajornada();
       String titulo= "Fecha Jornada";
       int index= panelmodificar.indexOfTab(titulo);
       
       if (index== -1){
           panelmodificar.addTab(titulo, fj);
           int i=panelmodificar.indexOfTab(titulo);
           panelmodificar.setSelectedIndex(i);
       }else{
           panelmodificar.remove(index);
           panelmodificar.addTab(titulo, fj);
           int i=panelmodificar.indexOfTab(titulo);
           panelmodificar.setSelectedIndex(i);
       }

   }    
    public void abrirasignarcancha(){
       asignarcancha ac= new asignarcancha();
       String titulo= "Asignar cancha";
       int index= panelmodificar.indexOfTab(titulo);
       
       if (index== -1){
           panelmodificar.addTab(titulo, ac);
           int i=panelmodificar.indexOfTab(titulo);
           panelmodificar.setSelectedIndex(i);
       }else{
           panelmodificar.remove(index);
           panelmodificar.addTab(titulo, ac);
           int i=panelmodificar.indexOfTab(titulo);
           panelmodificar.setSelectedIndex(i);
       }

   }      
    public void bloquearcat(){
        categoria= combocategoria.getSelectedItem().toString();
        if("Seleccione la Categoria".equals(categoria)){
            rfechajornada.setEnabled(false);
            rasignarcancha.setEnabled(false);
        }else{
           rfechajornada.setEnabled(true);
           rasignarcancha.setEnabled(true);
        }
    }
    public void bloquearcombo(){
        if(rfechajornada.isSelected()==true || rasignarcancha.isSelected()==true ){
            combocategoria.setEnabled(false);
        }else{
            try{
         int tamano=panelmodificar.getTabCount();              
        for(int i=0;i<=tamano;i++){
                 panelmodificar.remove(i);
                 i--;
                 tamano=panelmodificar.getTabCount(); 
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
        rfechajornada = new javax.swing.JRadioButton();
        rasignarcancha = new javax.swing.JRadioButton();
        panelmodificar = new javax.swing.JTabbedPane();
        labelidjuego = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(880, 330));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(880, 330));
        jPanel1.setOpaque(false);

        combocategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocategoriaActionPerformed(evt);
            }
        });

        rfechajornada.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rfechajornada.setText("Fecha jornada");
        rfechajornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rfechajornadaActionPerformed(evt);
            }
        });

        rasignarcancha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rasignarcancha.setText("Asignar cancha");
        rasignarcancha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rasignarcanchaActionPerformed(evt);
            }
        });

        panelmodificar.setMinimumSize(new java.awt.Dimension(860, 273));
        panelmodificar.setPreferredSize(new java.awt.Dimension(860, 273));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(combocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rfechajornada, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rasignarcancha, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelidjuego, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rfechajornada)
                        .addComponent(rasignarcancha))
                    .addComponent(labelidjuego, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
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

    private void rfechajornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rfechajornadaActionPerformed
       rasignarcancha.setSelected(false);
       
        if(rfechajornada.isSelected()==true){
         bloquearcombo();
         abrirfechajornada(); 
        }else
        if(rfechajornada.isSelected()==false){
            
         combocategoria.setEnabled(true);
         try{
         int tamano=panelmodificar.getTabCount();              
         for(int i=0;i<=tamano;i++){
                 panelmodificar.remove(i);
                 i--;
                 tamano=panelmodificar.getTabCount(); 
                 if( tamano== -1){
                 break;
                 }
                 }

       }catch(Exception e){
           
       } 
        }
    }//GEN-LAST:event_rfechajornadaActionPerformed

    private void rasignarcanchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rasignarcanchaActionPerformed
        rfechajornada.setSelected(false);
         if(rasignarcancha.isSelected()==true){
         bloquearcombo();
         abrirasignarcancha(); 
        }else
        if(rasignarcancha.isSelected()==false){
         combocategoria.setEnabled(true);
         try{
         int tamano=panelmodificar.getTabCount();              
         for(int i=0;i<=tamano;i++){
                 panelmodificar.remove(i);
                 i--;
                 tamano=panelmodificar.getTabCount(); 
                 if( tamano== -1){
                 break;
                 }
                 }

       }catch(Exception e){
           
       } 
        }
       
    }//GEN-LAST:event_rasignarcanchaActionPerformed

    private void combocategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocategoriaActionPerformed

        bloquearcat();

    }//GEN-LAST:event_combocategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox combocategoria;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel labelidjuego;
    public static javax.swing.JTabbedPane panelmodificar;
    public static javax.swing.JRadioButton rasignarcancha;
    public static javax.swing.JRadioButton rfechajornada;
    // End of variables declaration//GEN-END:variables
}
