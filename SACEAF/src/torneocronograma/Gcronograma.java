
package torneocronograma;

import saceaf.Principal;


public class Gcronograma extends javax.swing.JPanel {

    public Gcronograma() {
        initComponents();
   
    }

    public void crearcronograma(){
       panelcrear pc= new panelcrear();
       String titulo= "Crear Cronograma";
       int index= panelcronograma.indexOfTab(titulo);
       
       if (index== -1){
           panelcronograma.addTab(titulo, pc);
           int i=panelcronograma.indexOfTab(titulo);
           panelcronograma.setSelectedIndex(i);
       }else{
           panelcronograma.remove(index);
           panelcronograma.addTab(titulo, pc);
           int i=panelcronograma.indexOfTab(titulo);
           panelcronograma.setSelectedIndex(i);
       }

   }
    public void vercronograma(){
       vercalendario vc= new vercalendario();
       String titulo= "Ver Cronograma";
       int index= panelcronograma.indexOfTab(titulo);
       
       if (index== -1){
           panelcronograma.addTab(titulo, vc);
           int i=panelcronograma.indexOfTab(titulo);
           panelcronograma.setSelectedIndex(i);
       }else{
           panelcronograma.remove(index);
           panelcronograma.addTab(titulo, vc);
           int i=panelcronograma.indexOfTab(titulo);
           panelcronograma.setSelectedIndex(i);
       }

   }
    public void modificarcalendario(){
       modificarcalendario mc= new modificarcalendario();
       String titulo= "Modificar Cronograma";
       int index= panelcronograma.indexOfTab(titulo);
       
       if (index== -1){
           panelcronograma.addTab(titulo, mc);
           int i=panelcronograma.indexOfTab(titulo);
           panelcronograma.setSelectedIndex(i);
       }else{
           panelcronograma.remove(index);
           panelcronograma.addTab(titulo, mc);
           int i=panelcronograma.indexOfTab(titulo);
           panelcronograma.setSelectedIndex(i);
       }

   }
    public void resultados(){
       panelresultados pr= new panelresultados();
       String titulo= "Resultados";
       int index= panelcronograma.indexOfTab(titulo);
       
       if (index== -1){
           panelcronograma.addTab(titulo, pr);
           int i=panelcronograma.indexOfTab(titulo);
           panelcronograma.setSelectedIndex(i);
       }else{
           panelcronograma.remove(index);
           panelcronograma.addTab(titulo, pr);
           int i=panelcronograma.indexOfTab(titulo);
           panelcronograma.setSelectedIndex(i);
       }

   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelcronograma = new javax.swing.JTabbedPane();
        bcrear = new javax.swing.JButton();
        bmodificar = new javax.swing.JButton();
        bver = new javax.swing.JButton();
        bsalir = new javax.swing.JButton();
        bresultados = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1000, 412));

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel1.setLayout(null);

        jPanel2.setOpaque(false);

        panelcronograma.setMinimumSize(new java.awt.Dimension(880, 335));
        panelcronograma.setPreferredSize(new java.awt.Dimension(880, 335));

        bcrear.setForeground(new java.awt.Color(255, 255, 255));
        bcrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoscronograma/Agregar Resultado30x30.png"))); // NOI18N
        bcrear.setText("Crear");
        bcrear.setContentAreaFilled(false);
        bcrear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bcrear.setIconTextGap(2);
        bcrear.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoscronograma/Agregar Resultado40x40.png"))); // NOI18N
        bcrear.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bcrear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bcrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcrearActionPerformed(evt);
            }
        });

        bmodificar.setForeground(new java.awt.Color(255, 255, 255));
        bmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoscronograma/Edit Calendar30x30.png"))); // NOI18N
        bmodificar.setText("Modificar");
        bmodificar.setContentAreaFilled(false);
        bmodificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bmodificar.setIconTextGap(-2);
        bmodificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoscronograma/Edit Calendar40x40.png"))); // NOI18N
        bmodificar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bmodificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmodificarActionPerformed(evt);
            }
        });

        bver.setForeground(new java.awt.Color(255, 255, 255));
        bver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoscronograma/Ver Calendario30x30.png"))); // NOI18N
        bver.setText("Ver");
        bver.setContentAreaFilled(false);
        bver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bver.setIconTextGap(-2);
        bver.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoscronograma/Ver Calendario40x40.png"))); // NOI18N
        bver.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bver.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bverActionPerformed(evt);
            }
        });

        bsalir.setForeground(new java.awt.Color(255, 255, 255));
        bsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 30x30.png"))); // NOI18N
        bsalir.setText("Salir");
        bsalir.setContentAreaFilled(false);
        bsalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bsalir.setIconTextGap(-2);
        bsalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/exit6 40x40.png"))); // NOI18N
        bsalir.setVerifyInputWhenFocusTarget(false);
        bsalir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bsalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsalirActionPerformed(evt);
            }
        });

        bresultados.setForeground(new java.awt.Color(255, 255, 255));
        bresultados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoscronograma/Modificar Resultado30x30.png"))); // NOI18N
        bresultados.setText("Resultados");
        bresultados.setContentAreaFilled(false);
        bresultados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bresultados.setIconTextGap(-2);
        bresultados.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoscronograma/Modificar Resultado40x40.png"))); // NOI18N
        bresultados.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bresultados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bresultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bresultadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bresultados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(bsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bcrear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bmodificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(panelcronograma, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(panelcronograma, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bsalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bcrear, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bver, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bresultados, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))))
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

    private void bcrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcrearActionPerformed
       crearcronograma();
    }//GEN-LAST:event_bcrearActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        Principal.panelprincipal.remove(this);
    }//GEN-LAST:event_bsalirActionPerformed

    private void bmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmodificarActionPerformed
        modificarcalendario();
    }//GEN-LAST:event_bmodificarActionPerformed

    private void bverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bverActionPerformed
        vercronograma();
    }//GEN-LAST:event_bverActionPerformed

    private void bresultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bresultadosActionPerformed
        resultados();
    }//GEN-LAST:event_bresultadosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bcrear;
    public static javax.swing.JButton bmodificar;
    public static javax.swing.JButton bresultados;
    public static javax.swing.JButton bsalir;
    public static javax.swing.JButton bver;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JTabbedPane panelcronograma;
    // End of variables declaration//GEN-END:variables
}
