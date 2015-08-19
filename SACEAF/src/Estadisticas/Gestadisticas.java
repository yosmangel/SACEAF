
package Estadisticas;

import saceaf.Principal;


public class Gestadisticas extends javax.swing.JPanel {

    public Gestadisticas() {
        initComponents();
        abrirpresentacion();
    }

    public void abrirgraficas(){
       
       pgraficas pca=new pgraficas();
       String titulo="Graficas";
       int index= panelestadisticas.indexOfTab(titulo);
       if(index == -1){
           panelestadisticas.add(titulo,pca);
           int i= panelestadisticas.indexOfTab(titulo);
           panelestadisticas.setSelectedIndex(i);
       }else{
           panelestadisticas.remove(index);
           panelestadisticas.add(titulo,pca);
           int i=panelestadisticas.indexOfTab(titulo);
           panelestadisticas.setSelectedIndex(i);
       }
    }
    
    public void abrirreportes(){
        
        preportes pca=new preportes();
        String titulo="Reportes";
        int index= panelestadisticas.indexOfTab(titulo);
        if(index == -1){
            panelestadisticas.add(titulo,pca);
            int i= panelestadisticas.indexOfTab(titulo);
            panelestadisticas.setSelectedIndex(i);
        }else{
            panelestadisticas.remove(index);
            panelestadisticas.add(titulo,pca);
            int i=panelestadisticas.indexOfTab(titulo);
            panelestadisticas.setSelectedIndex(i);
        }
    }
    
    public void abrirpresentacion(){
      
       presentacionestadistica p=new presentacionestadistica();
       String titulo="";
       int index= panelestadisticas.indexOfTab(titulo);
       if(index == -1){
           panelestadisticas.add(titulo,p);
           int i= panelestadisticas.indexOfTab(titulo);
           panelestadisticas.setSelectedIndex(i);
       }else{
           panelestadisticas.remove(index);
           panelestadisticas.add(titulo,p);
           int i=panelestadisticas.indexOfTab(titulo);
           panelestadisticas.setSelectedIndex(i);
       }
   }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BReportes = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelestadisticas = new javax.swing.JTabbedPane();
        bsalir = new javax.swing.JButton();
        BGraficas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1000, 412));

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel1.setLayout(null);

        jPanel2.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 412));

        BReportes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/pdf 60x60.png"))); // NOI18N
        BReportes.setText("Reportes");
        BReportes.setContentAreaFilled(false);
        BReportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BReportes.setIconTextGap(-2);
        BReportes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/pdf 80x80.png"))); // NOI18N
        BReportes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BReportes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BReportesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Estadisticas");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Seleccione");

        panelestadisticas.setMaximumSize(new java.awt.Dimension(630, 309));
        panelestadisticas.setMinimumSize(new java.awt.Dimension(630, 309));
        panelestadisticas.setPreferredSize(new java.awt.Dimension(630, 309));

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

        BGraficas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BGraficas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Estadisticas60x60.png"))); // NOI18N
        BGraficas.setText("Graficas");
        BGraficas.setContentAreaFilled(false);
        BGraficas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BGraficas.setIconTextGap(-2);
        BGraficas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Estadisticas80x80.png"))); // NOI18N
        BGraficas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BGraficas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BGraficas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGraficasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(BGraficas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelestadisticas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bsalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelestadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(BReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(BGraficas, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jLabel4)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1000, 412);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondos/FondoMedioDifuminado.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-2, -5, 1000, 420);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BReportesActionPerformed
        abrirreportes();
    }//GEN-LAST:event_BReportesActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        Principal.panelprincipal.remove(this);
    }//GEN-LAST:event_bsalirActionPerformed

    private void BGraficasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGraficasActionPerformed
        abrirgraficas();
    }//GEN-LAST:event_BGraficasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton BGraficas;
    public static javax.swing.JButton BReportes;
    public static javax.swing.JButton bsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JTabbedPane panelestadisticas;
    // End of variables declaration//GEN-END:variables
}
