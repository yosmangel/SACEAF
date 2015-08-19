
package saceaf;

import javax.swing.JOptionPane;

public class torneoprincipal extends javax.swing.JPanel {

    public torneoprincipal() {
        initComponents();
    }

    public void abririnicio(){
        Inicio ini= new Inicio();
        String titulo= "Inicio";
        int index= Principal.panelprincipal.indexOfTab(titulo);
        if(index == -1){
            Principal.panelprincipal.addTab(titulo, ini);
            int i= Principal.panelprincipal.indexOfTab(titulo);
            Principal.panelprincipal.setSelectedIndex(i);
        }else{
            Principal.panelprincipal.remove(index);
            Principal.panelprincipal.indexOfTab(titulo);
            int i= Principal.panelprincipal.indexOfTab(titulo);
            Principal.panelprincipal.setSelectedIndex(i);
        }
    }
    public void salirtorneo(){
        int opc=JOptionPane.showConfirmDialog(null,"Desea salir del Torneo?","Informacion",JOptionPane.YES_NO_OPTION);
        if(opc==0){
            try{
        int tamano=Principal.panelprincipal.getTabCount();              
        for(int i=0;i<=tamano;i++){
                 Principal.panelprincipal.remove(i);
                 i--;
                 tamano=Principal.panelprincipal.getTabCount(); 
                 if( tamano== 0){
                     break;
                 }
                 }
          abririnicio();
          Principal.cerrartorneo();
          
        }catch(Exception e){
            
        }
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bsalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1000, 412));

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel1.setLayout(null);

        jPanel2.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 412));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(927, Short.MAX_VALUE)
                .addComponent(bsalir)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bsalir)
                .addContainerGap(350, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1000, 410);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondos/FondoMedioDifuminado.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 410);

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

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        salirtorneo();
    }//GEN-LAST:event_bsalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bsalir;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
