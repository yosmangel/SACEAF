
package torneoadministracion;

import saceaf.Principal;


public class torneogadministracion extends javax.swing.JPanel {


    public torneogadministracion() {
        initComponents();
        abrirpresentacion();
    }

    public static void habilitar(){
        bcategorias.setEnabled(true);
        bsalir.setEnabled(true);
    }
    public static void deshabilitar(){
        bcategorias.setEnabled(false);
        bsalir.setEnabled(false);
    }
    public void abrircategoria(){
       
       torneopcategoria tpc=new torneopcategoria();
       String titulo="Categoria";
       int index= paneltadministracion.indexOfTab(titulo);
       if(index == -1){
           paneltadministracion.add(titulo,tpc);
           int i= paneltadministracion.indexOfTab(titulo);
           paneltadministracion.setSelectedIndex(i);
       }else{
           paneltadministracion.remove(index);
           paneltadministracion.add(titulo,tpc);
           int i=paneltadministracion.indexOfTab(titulo);
           paneltadministracion.setSelectedIndex(i);
       }
   }
    public void abrirpresentacion(){
       
       torneoadmpresentacion tap=new torneoadmpresentacion();
       String titulo="";
       int index= paneltadministracion.indexOfTab(titulo);
       if(index == -1){
           paneltadministracion.add(titulo,tap);
           int i= paneltadministracion.indexOfTab(titulo);
           paneltadministracion.setSelectedIndex(i);
       }else{
           paneltadministracion.remove(index);
           paneltadministracion.add(titulo,tap);
           int i=paneltadministracion.indexOfTab(titulo);
           paneltadministracion.setSelectedIndex(i);
       }
   }
    public void abrircanchas(){
       
       torneopcancha tpc=new torneopcancha();
       String titulo="Canchas";
       int index= paneltadministracion.indexOfTab(titulo);
       if(index == -1){
           paneltadministracion.add(titulo,tpc);
           int i= paneltadministracion.indexOfTab(titulo);
           paneltadministracion.setSelectedIndex(i);
       }else{
           paneltadministracion.remove(index);
           paneltadministracion.add(titulo,tpc);
           int i=paneltadministracion.indexOfTab(titulo);
           paneltadministracion.setSelectedIndex(i);
       }
   }
    public void abrirarbitros(){
       
       torneoparbitros tpa=new torneoparbitros();
       String titulo="Arbitros";
       int index= paneltadministracion.indexOfTab(titulo);
       if(index == -1){
           paneltadministracion.add(titulo,tpa);
           int i= paneltadministracion.indexOfTab(titulo);
           paneltadministracion.setSelectedIndex(i);
       }else{
           paneltadministracion.remove(index);
           paneltadministracion.add(titulo,tpa);
           int i=paneltadministracion.indexOfTab(titulo);
           paneltadministracion.setSelectedIndex(i);
       }
   }
     public void abrirnjugadores(){
       
       torneopjugadoresNomina tjn=new torneopjugadoresNomina();
       String titulo="Configuracion Nomina";
       int index= paneltadministracion.indexOfTab(titulo);
       if(index == -1){
           paneltadministracion.add(titulo,tjn);
           int i= paneltadministracion.indexOfTab(titulo);
           paneltadministracion.setSelectedIndex(i);
       }else{
           paneltadministracion.remove(index);
           paneltadministracion.add(titulo,tjn);
           int i=paneltadministracion.indexOfTab(titulo);
           paneltadministracion.setSelectedIndex(i);
       }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bcategorias = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        paneltadministracion = new javax.swing.JTabbedPane();
        bsalir = new javax.swing.JButton();
        bnjugadores = new javax.swing.JButton();
        barbitro = new javax.swing.JButton();
        bcanchas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1000, 412));

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel1.setLayout(null);

        jPanel2.setMinimumSize(new java.awt.Dimension(1000, 412));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 412));

        bcategorias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bcategorias.setForeground(new java.awt.Color(255, 255, 255));
        bcategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconosadministracion/categoria60x60.png"))); // NOI18N
        bcategorias.setText("Categorias");
        bcategorias.setContentAreaFilled(false);
        bcategorias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bcategorias.setIconTextGap(-2);
        bcategorias.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconosadministracion/categoria80x80.png"))); // NOI18N
        bcategorias.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bcategorias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bcategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcategoriasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Administración del Torneo");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Seleccione el área a administrar");

        paneltadministracion.setMinimumSize(new java.awt.Dimension(630, 309));

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

        bnjugadores.setText("N° jugadores");
        bnjugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnjugadoresActionPerformed(evt);
            }
        });

        barbitro.setForeground(new java.awt.Color(255, 255, 255));
        barbitro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconosadministracion/Arbitro60x60.png"))); // NOI18N
        barbitro.setText("Arbitros");
        barbitro.setContentAreaFilled(false);
        barbitro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        barbitro.setIconTextGap(-2);
        barbitro.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconosadministracion/Arbitro80x80.png"))); // NOI18N
        barbitro.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        barbitro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barbitroActionPerformed(evt);
            }
        });

        bcanchas.setForeground(new java.awt.Color(255, 255, 255));
        bcanchas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconosadministracion/Cancha60x60.png"))); // NOI18N
        bcanchas.setText("Canchas");
        bcanchas.setContentAreaFilled(false);
        bcanchas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bcanchas.setIconTextGap(-2);
        bcanchas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconosadministracion/Cancha80x80.png"))); // NOI18N
        bcanchas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bcanchas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bcanchas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcanchasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bsalir)
                .addGap(28, 28, 28))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bcategorias)
                        .addGap(18, 18, 18)
                        .addComponent(barbitro, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bnjugadores)
                        .addGap(18, 18, 18)
                        .addComponent(bcanchas)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(paneltadministracion, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(bsalir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bcategorias)
                            .addComponent(barbitro))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bnjugadores)
                            .addComponent(bcanchas)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paneltadministracion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
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

    private void bcategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcategoriasActionPerformed
        abrircategoria();
        deshabilitar();
    }//GEN-LAST:event_bcategoriasActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        Principal.panelprincipal.remove(this);
    }//GEN-LAST:event_bsalirActionPerformed

    private void bnjugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnjugadoresActionPerformed
        abrirnjugadores();
        deshabilitar();
    }//GEN-LAST:event_bnjugadoresActionPerformed

    private void barbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barbitroActionPerformed
        abrirarbitros();
        deshabilitar();
    }//GEN-LAST:event_barbitroActionPerformed

    private void bcanchasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcanchasActionPerformed
        abrircanchas();
        deshabilitar();
    }//GEN-LAST:event_bcanchasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton barbitro;
    public static javax.swing.JButton bcanchas;
    public static javax.swing.JButton bcategorias;
    public static javax.swing.JButton bnjugadores;
    public static javax.swing.JButton bsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JTabbedPane paneltadministracion;
    // End of variables declaration//GEN-END:variables
}
