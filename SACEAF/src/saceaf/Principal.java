
package saceaf;

import Administracion.Gadministracion;
import Equipo.Gclubes;
import Estadisticas.Gestadisticas;
import GestionPagos.GestionPagos;
import Sanciones.Gsanciones;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import torneo.principaltorneo;
import torneoadministracion.torneogadministracion;
import torneocronograma.Gcronograma;
import torneoequipo.Equipostorneo;


public final class Principal extends javax.swing.JFrame {

 
    public Principal() {
       initComponents();
       abrirbienvenido();
       inhabilitar();
       this.getContentPane().add(panelinferior, BorderLayout.SOUTH);
     // Calendar c1 = Calendar.getInstance();
      Calendar cal = new GregorianCalendar();
      String dia=Integer.toString(cal.get(Calendar.DATE));
      String mes=Integer.toString(cal.get(Calendar.MONTH)+1);
      String ano=Integer.toString(cal.get(Calendar.YEAR));

      String fecha=ano+ "/" +mes+ "/" +dia;
      labelfecha.setText(fecha);
      System.gc();
      flushMemory();
    }

    public static void flushMemory(){
// Usamos un vector para almacenar la memoria.
Vector v = new Vector();
int count = 0;
// inicialmente incrementamos en bloques de 1 megabyte
int size = 1048576;
// Continuaremos hasta que pediremos bloques de
// 1 byte
while(size > 1)
{
try
{
for (; true ; count++)
{
// pedir y almacenar más memoria
v.addElement( new byte[size] );
}
}
// Si encontramos un OutOfMemoryError, seguimos
// intentando obtener más memoria, pero en bloques de
// la mitad de tamaño.
catch (OutOfMemoryError bounded){size = size/2;}
}
// Ahora liberamos todo para el GC
v = null;
// y pedimos un nuevo Vector como un pequeño objeto
// para asegurarnos que se lanza la recolección de basura
// antes de salir del método.
v = new Vector();
}
    public static void inhabilitar(){
        BTorneo.setEnabled(false);
        bclubes.setEnabled(false);
        bpagos.setEnabled(false);
        badministracion.setEnabled(false);
        btequipos.setEnabled(false);
        btequipos.setVisible(false);
        btcronograma.setEnabled(false);
        btcronograma.setVisible(false);
        btestadisticas.setEnabled(false);
        btestadisticas.setVisible(false);
        btsanciones.setEnabled(false);
        btsanciones.setVisible(false);
        btadministracion.setEnabled(false);
        btadministracion.setVisible(false);
        bprettyolap.setEnabled(false);
        bprettyolap.setVisible(false);
                       
    }
    public static void habilitar(){
        BTorneo.setEnabled(true);
        bclubes.setEnabled(true);
        bpagos.setEnabled(true);
        badministracion.setEnabled(true);
    }
    public static void inhabilitar2(){
        BTorneo.setEnabled(false);
        bclubes.setEnabled(false);
        bpagos.setEnabled(false);
        badministracion.setEnabled(false);
        BTorneo.setVisible(false);
        bclubes.setVisible(false);
        bpagos.setVisible(false);
        badministracion.setVisible(false);               
    }
    public static void habilitar2(){
        btequipos.setEnabled(true);
        btequipos.setVisible(true);
        btcronograma.setEnabled(true);
        btcronograma.setVisible(true);
        btestadisticas.setEnabled(true);
        btestadisticas.setVisible(true);
        btsanciones.setEnabled(true);
        btsanciones.setVisible(true);
        btadministracion.setEnabled(true);
        btadministracion.setVisible(true);
        bprettyolap.setEnabled(true);
        bprettyolap.setVisible(true);
    }
    public static void cerrartorneo(){
        BTorneo.setEnabled(true);
        bclubes.setEnabled(true);
        bpagos.setEnabled(true);
        badministracion.setEnabled(true);
        BTorneo.setVisible(true);
        bclubes.setVisible(true);
        bpagos.setVisible(true);
        badministracion.setVisible(true);
        btequipos.setEnabled(false);
        btequipos.setVisible(false);
        btcronograma.setEnabled(false);
        btcronograma.setVisible(false);
        btestadisticas.setEnabled(false);
        btestadisticas.setVisible(false);
        btsanciones.setEnabled(false);
        btsanciones.setVisible(false);
        btadministracion.setEnabled(false);
        btadministracion.setVisible(false);
        bprettyolap.setEnabled(false);
        bprettyolap.setVisible(false);
        labeldisciplina.setText("");
        labelnombretorneo.setText("");
        labelserialtorneo.setText("");
        labelsexo.setText("");
    }
    public void abrirbienvenido(){
              
       Pprincipal p1= new Pprincipal();
       String titulo= "Bienvenidos!";
       int index= panelprincipal.indexOfTab(titulo);
       
       if (index== -1){
           panelprincipal.addTab(titulo, p1);
           int i=panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }else{
           panelprincipal.remove(index);
           panelprincipal.addTab(titulo, p1);
           int i=panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }

   }    
    public void abrirclubes(){
       Gclubes gc = new Gclubes();
       String titulo= "Gestionar Clubes";
       int index= panelprincipal.indexOfTab(titulo);
       if (index== -1){
           panelprincipal.addTab(titulo,gc);
           int i= panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }else{
           panelprincipal.remove(index);
           panelprincipal.addTab(titulo, gc);
           int i=panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }
   }
    public void abriradministracion(){
       Gadministracion ga= new Gadministracion();
       String titulo="Administracion";
       int index= panelprincipal.indexOfTab(titulo);
       if(index==-1){
           panelprincipal.add(titulo,ga);
           int i= panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }else{
           panelprincipal.remove(index);
           panelprincipal.add(titulo,ga);
           int i= panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }
   }
    public void abrirtorneo(){
       principaltorneo pt= new principaltorneo();
       String titulo="Gestionar Torneo";
       int index= panelprincipal.indexOfTab(titulo);
       if(index==-1){
           panelprincipal.add(titulo,pt);
           int i= panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }else{
           panelprincipal.remove(index);
           panelprincipal.add(titulo,pt);
           int i= panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }
   }
    public void abriradministraciontorneo(){
       torneogadministracion tga= new torneogadministracion();
       String titulo="Administracion";
       int index= panelprincipal.indexOfTab(titulo);
       if(index==-1){
           panelprincipal.add(titulo,tga);
           int i= panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }else{
           panelprincipal.remove(index);
           panelprincipal.add(titulo,tga);
           int i= panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }
   }
    public void equipostorneo(){
       Equipostorneo et = new Equipostorneo();
       String titulo= "Equipos en torneo";
       int index= panelprincipal.indexOfTab(titulo);
       if (index== -1){
           panelprincipal.addTab(titulo,et);
           int i= panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }else{
           panelprincipal.remove(index);
           panelprincipal.addTab(titulo, et);
           int i=panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }
   }
    public void gcronograma(){
       Gcronograma gc= new Gcronograma();
       String titulo= "Gestionar Cronograma";
       int index= panelprincipal.indexOfTab(titulo);
       if (index== -1){
           panelprincipal.addTab(titulo,gc);
           int i= panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }else{
           panelprincipal.remove(index);
           panelprincipal.addTab(titulo, gc);
           int i=panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }
   }
    public void abrirGestionPagos(){
GestionPagos Pagos= new GestionPagos();

String titulo= "Gestionar Pagos";
       int index= panelprincipal.indexOfTab(titulo);
       
       if (index== -1){
           panelprincipal.addTab(titulo, Pagos);
           int i=panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }else{
           panelprincipal.remove(index);
           panelprincipal.addTab(titulo, Pagos);
           int i=panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }
}
    public void abrirsanciones(){
       Gsanciones gs = new Gsanciones();
       String titulo= " Gestionar Sanciones";
       int index= panelprincipal.indexOfTab(titulo);
       if (index== -1){
           panelprincipal.addTab(titulo,gs);
           int i= panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }else{
           panelprincipal.remove(index);
           panelprincipal.addTab(titulo, gs);
           int i=panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }
   }
    public void abrirestadisticas(){
       Gestadisticas ge= new Gestadisticas();
       String titulo="Estadisticas";
       int index= panelprincipal.indexOfTab(titulo);
       if(index==-1){
           panelprincipal.add(titulo,ge);
           int i= panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }else{
           panelprincipal.remove(index);
           panelprincipal.add(titulo,ge);
           int i= panelprincipal.indexOfTab(titulo);
           panelprincipal.setSelectedIndex(i);
       }
   }      
    public void Salir(){
        int opc = JOptionPane.showConfirmDialog(this, "¿Seguro que desea salir?","Salir",JOptionPane.YES_NO_OPTION);
        if (opc ==0){
            System.exit(0);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelinferior = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelnombretorneo = new javax.swing.JLabel();
        labelserialtorneo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labeldisciplina = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelsexo = new javax.swing.JLabel();
        labelfecha = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Supremo = new javax.swing.JPanel();
        panelsuperior = new javax.swing.JPanel();
        BTorneo = new javax.swing.JButton();
        bprettyolap = new javax.swing.JButton();
        badministracion = new javax.swing.JButton();
        bclubes = new javax.swing.JButton();
        bpagos = new javax.swing.JButton();
        bsalir = new javax.swing.JButton();
        btequipos = new javax.swing.JButton();
        btestadisticas = new javax.swing.JButton();
        btcronograma = new javax.swing.JButton();
        btsanciones = new javax.swing.JButton();
        btadministracion = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        panelprincipal = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Barra = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        panelinferior.setMinimumSize(new java.awt.Dimension(1000, 100));
        panelinferior.setPreferredSize(new java.awt.Dimension(1000, 100));

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 100));
        jPanel1.setLayout(null);

        jPanel2.setMinimumSize(new java.awt.Dimension(1000, 100));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 100));

        jLabel2.setText("Usuario");

        jLabel5.setText("Admin");

        jLabel6.setText("Torneo:");

        jLabel7.setText("Disciplina:");

        jLabel9.setText("Sexo:");

        labelfecha.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelserialtorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(137, 137, 137)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelsexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labeldisciplina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelnombretorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(606, 606, 606))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelnombretorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labeldisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelsexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelserialtorneo, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1000, 100);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondos/FondoPanelInferior.jpg"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 1000, 100);

        javax.swing.GroupLayout panelinferiorLayout = new javax.swing.GroupLayout(panelinferior);
        panelinferior.setLayout(panelinferiorLayout);
        panelinferiorLayout.setHorizontalGroup(
            panelinferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelinferiorLayout.setVerticalGroup(
            panelinferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelinferiorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SACEAF");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1000, 740));
        setMinimumSize(new java.awt.Dimension(1000, 735));

        Supremo.setLayout(null);

        panelsuperior.setOpaque(false);
        panelsuperior.setLayout(null);

        BTorneo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BTorneo.setForeground(new java.awt.Color(255, 255, 255));
        BTorneo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Torneo 60x60.png"))); // NOI18N
        BTorneo.setText("Torneo");
        BTorneo.setContentAreaFilled(false);
        BTorneo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTorneo.setIconTextGap(-2);
        BTorneo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Torneo 80x80.png"))); // NOI18N
        BTorneo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BTorneo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTorneoActionPerformed(evt);
            }
        });
        panelsuperior.add(BTorneo);
        BTorneo.setBounds(220, 11, 93, 100);

        bprettyolap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bprettyolap.setForeground(new java.awt.Color(255, 255, 255));
        bprettyolap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/prettyOlap60x60.png"))); // NOI18N
        bprettyolap.setText("Pretty Olap");
        bprettyolap.setToolTipText("");
        bprettyolap.setBorder(null);
        bprettyolap.setContentAreaFilled(false);
        bprettyolap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bprettyolap.setIconTextGap(-2);
        bprettyolap.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/prettyOlap80x80.png"))); // NOI18N
        bprettyolap.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bprettyolap.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bprettyolap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprettyolapActionPerformed(evt);
            }
        });
        panelsuperior.add(bprettyolap);
        bprettyolap.setBounds(470, 20, 120, 90);

        badministracion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        badministracion.setForeground(new java.awt.Color(255, 255, 255));
        badministracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Administracion 60x60.png"))); // NOI18N
        badministracion.setText("Administracion");
        badministracion.setContentAreaFilled(false);
        badministracion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        badministracion.setIconTextGap(-2);
        badministracion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Administracion 80x80.png"))); // NOI18N
        badministracion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        badministracion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        badministracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badministracionActionPerformed(evt);
            }
        });
        panelsuperior.add(badministracion);
        badministracion.setBounds(480, 10, 111, 100);

        bclubes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bclubes.setForeground(new java.awt.Color(255, 255, 255));
        bclubes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Equipo 60x60.png"))); // NOI18N
        bclubes.setText("Clubes");
        bclubes.setContentAreaFilled(false);
        bclubes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bclubes.setIconTextGap(-2);
        bclubes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Equipo 80x80.png"))); // NOI18N
        bclubes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bclubes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bclubes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bclubesActionPerformed(evt);
            }
        });
        panelsuperior.add(bclubes);
        bclubes.setBounds(70, 10, 93, 100);

        bpagos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bpagos.setForeground(new java.awt.Color(255, 255, 255));
        bpagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Pagos60x60.png"))); // NOI18N
        bpagos.setText("Pagos");
        bpagos.setContentAreaFilled(false);
        bpagos.setHideActionText(true);
        bpagos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bpagos.setIconTextGap(-2);
        bpagos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Pagos80x80.png"))); // NOI18N
        bpagos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bpagos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bpagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpagosActionPerformed(evt);
            }
        });
        panelsuperior.add(bpagos);
        bpagos.setBounds(360, 11, 93, 100);

        bsalir.setForeground(new java.awt.Color(255, 255, 255));
        bsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/logout30x30.png"))); // NOI18N
        bsalir.setText("Salir");
        bsalir.setContentAreaFilled(false);
        bsalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bsalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bsalir.setIconTextGap(-2);
        bsalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconossalir/logout40x40.png"))); // NOI18N
        bsalir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bsalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsalirActionPerformed(evt);
            }
        });
        panelsuperior.add(bsalir);
        bsalir.setBounds(770, 0, 70, 70);

        btequipos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btequipos.setForeground(new java.awt.Color(255, 255, 255));
        btequipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Jugador 60x60.png"))); // NOI18N
        btequipos.setText("Equipos");
        btequipos.setContentAreaFilled(false);
        btequipos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btequipos.setIconTextGap(-2);
        btequipos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Jugador 80x80.png"))); // NOI18N
        btequipos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btequipos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btequipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btequiposActionPerformed(evt);
            }
        });
        panelsuperior.add(btequipos);
        btequipos.setBounds(40, 10, 100, 100);

        btestadisticas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btestadisticas.setForeground(new java.awt.Color(255, 255, 255));
        btestadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Estadisticas60x60.png"))); // NOI18N
        btestadisticas.setText("Estadisticas");
        btestadisticas.setContentAreaFilled(false);
        btestadisticas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btestadisticas.setIconTextGap(-2);
        btestadisticas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Estadisticas80x80.png"))); // NOI18N
        btestadisticas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btestadisticas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btestadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btestadisticasActionPerformed(evt);
            }
        });
        panelsuperior.add(btestadisticas);
        btestadisticas.setBounds(270, 11, 110, 100);

        btcronograma.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btcronograma.setForeground(new java.awt.Color(255, 255, 255));
        btcronograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Cronograma60x60.png"))); // NOI18N
        btcronograma.setText("Cronograma");
        btcronograma.setContentAreaFilled(false);
        btcronograma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btcronograma.setIconTextGap(-2);
        btcronograma.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Cronograma80x80.png"))); // NOI18N
        btcronograma.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btcronograma.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btcronograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcronogramaActionPerformed(evt);
            }
        });
        panelsuperior.add(btcronograma);
        btcronograma.setBounds(160, 13, 100, 100);

        btsanciones.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btsanciones.setForeground(new java.awt.Color(255, 255, 255));
        btsanciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/sanciones60x60.png"))); // NOI18N
        btsanciones.setText("Sanciones");
        btsanciones.setContentAreaFilled(false);
        btsanciones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btsanciones.setIconTextGap(-2);
        btsanciones.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/sanciones80x80.png"))); // NOI18N
        btsanciones.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btsanciones.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btsanciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsancionesActionPerformed(evt);
            }
        });
        panelsuperior.add(btsanciones);
        btsanciones.setBounds(390, 10, 100, 100);

        btadministracion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btadministracion.setForeground(new java.awt.Color(255, 255, 255));
        btadministracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Administracion 60x60.png"))); // NOI18N
        btadministracion.setText("Administracion");
        btadministracion.setContentAreaFilled(false);
        btadministracion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btadministracion.setIconTextGap(-2);
        btadministracion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Administracion 80x80.png"))); // NOI18N
        btadministracion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btadministracion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btadministracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btadministracionActionPerformed(evt);
            }
        });
        panelsuperior.add(btadministracion);
        btadministracion.setBounds(570, 10, 120, 100);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Help30x30.png"))); // NOI18N
        jButton1.setText("Ayuda");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setIconTextGap(-2);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconosgenerales/Help40x40.png"))); // NOI18N
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelsuperior.add(jButton1);
        jButton1.setBounds(770, 70, 73, 60);

        Supremo.add(panelsuperior);
        panelsuperior.setBounds(158, 0, 840, 140);

        panelprincipal.setMinimumSize(new java.awt.Dimension(1000, 418));
        panelprincipal.setPreferredSize(new java.awt.Dimension(1000, 418));
        Supremo.add(panelprincipal);
        panelprincipal.setBounds(0, 140, 1000, 460);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondos/PNG (2).png"))); // NOI18N
        Supremo.add(jLabel1);
        jLabel1.setBounds(0, 0, 154, 140);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondos/FondoPanelSuperior.jpg"))); // NOI18N
        Supremo.add(jLabel3);
        jLabel3.setBounds(0, 0, 1000, 430);

        getContentPane().add(Supremo, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");
        Barra.add(jMenu1);

        jMenu2.setText("Edit");
        Barra.add(jMenu2);

        setJMenuBar(Barra);

        setSize(new java.awt.Dimension(1016, 657));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTorneoActionPerformed
       abrirtorneo(); 
    }//GEN-LAST:event_BTorneoActionPerformed

    private void badministracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badministracionActionPerformed
        abriradministracion();
    }//GEN-LAST:event_badministracionActionPerformed

    private void bclubesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bclubesActionPerformed
        abrirclubes();
    }//GEN-LAST:event_bclubesActionPerformed

    private void btadministracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btadministracionActionPerformed
        abriradministraciontorneo();
    }//GEN-LAST:event_btadministracionActionPerformed

    private void btequiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btequiposActionPerformed
        equipostorneo();
    }//GEN-LAST:event_btequiposActionPerformed

    private void btcronogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcronogramaActionPerformed
       gcronograma();
    }//GEN-LAST:event_btcronogramaActionPerformed

    private void bpagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpagosActionPerformed
        abrirGestionPagos();
    }//GEN-LAST:event_bpagosActionPerformed

    private void btsancionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsancionesActionPerformed
        abrirsanciones();
    }//GEN-LAST:event_btsancionesActionPerformed

    private void btestadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btestadisticasActionPerformed
        abrirestadisticas();
    }//GEN-LAST:event_btestadisticasActionPerformed

    private void bsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalirActionPerformed
        Salir();
    }//GEN-LAST:event_bsalirActionPerformed

    private void bprettyolapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprettyolapActionPerformed
              try {
            
          Runtime.getRuntime().exec("C:\\Program Files (x86)\\PrettyOlap\\PrettyOlapBuilder.exe");
        
      } catch (IOException ex) {
      
          System.out.println(ex);
        
      }
    }//GEN-LAST:event_bprettyolapActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "src\\Manual de Usuario SACEAF.pdf");
          //Runtime.getRuntime().exec("C:\\Users\\Kevin_000\\Desktop\\Manual de Usuario SACEAF.pdf");
        
      } catch (IOException ex) {
      
          System.out.println(ex);
        
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton BTorneo;
    public static javax.swing.JMenuBar Barra;
    public static javax.swing.JPanel Supremo;
    public static javax.swing.JButton badministracion;
    public static javax.swing.JButton bclubes;
    public static javax.swing.JButton bpagos;
    public static javax.swing.JButton bprettyolap;
    public static javax.swing.JButton bsalir;
    public static javax.swing.JButton btadministracion;
    public static javax.swing.JButton btcronograma;
    public static javax.swing.JButton btequipos;
    public static javax.swing.JButton btestadisticas;
    public static javax.swing.JButton btsanciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel labeldisciplina;
    public static javax.swing.JLabel labelfecha;
    public static javax.swing.JLabel labelnombretorneo;
    public static javax.swing.JLabel labelserialtorneo;
    public static javax.swing.JLabel labelsexo;
    public static javax.swing.JPanel panelinferior;
    public static javax.swing.JTabbedPane panelprincipal;
    public static javax.swing.JPanel panelsuperior;
    // End of variables declaration//GEN-END:variables
}
