
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
import torneodatoscronograma.datomodificarrondas;


public class ungrupo extends javax.swing.JPanel {

    static DefaultTableModel modelo= new DefaultTableModel();
    DefaultComboBoxModel combo= new DefaultComboBoxModel();
    String nombrecat,id_categoria,id_torneo,idcompetencia,idmodalidad,datopostfase,nombre_juego,equipo_local,equipo_visitante,id_juego,jornada,sexo;
    int rondas,nrondas,cont,numero_local,numero_visitante,grupos,ctrl,i;
    static String categoria, idtorneo,grupo,hequipo,idcategoria,lsexo;
    
    public ungrupo() {
        initComponents();
        verificarronda();
        cargarequipos();
    }

    
    public static void cargarequipos(){
        categoria= panelcrear.combocategoria.getSelectedItem().toString();
        idtorneo= Principal.labelserialtorneo.getText();
        lsexo=Principal.labelsexo.getText();
        try{ 
            String sql="Select id_categoria from categoria where nombre_cat= '"+categoria+"' and sexo='"+lsexo+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            idcategoria=rs.getString("id_categoria");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(ungrupo.class.getName()).log(Level.SEVERE, null, ex);
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
            grupoa.setModel(modelo);
            grupoa.getColumnModel().getColumn(0).setPreferredWidth(50);
            grupoa.getColumnModel().getColumn(1).setPreferredWidth(140);
            grupoa.getColumnModel().getColumn(2).setPreferredWidth(140);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            grupoa.setRowSorter(modeloordenado);
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(ungrupo.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public void abrircopa(){
       equiposcopa cc= new equiposcopa();
       String titulo= "Copa";
       int index= panelcrear.panelmodalidades.indexOfTab(titulo);
       
       if (index== -1){
           panelcrear.panelmodalidades.addTab(titulo, cc);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }else{
           panelcrear.panelmodalidades.remove(index);
           panelcrear.panelmodalidades.addTab(titulo, cc);
           int i=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(i);
       }

   } 
    public void guardarronda(){
        if(ungrupo.comborondas.isEnabled()==true){
        nombrecat=panelcrear.combocategoria.getSelectedItem().toString();
        try{ 
            String sql="Select id_categoria from categoria where nombre_cat= '"+nombrecat+"' and sexo='Masculino';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            id_categoria=rs.getString("id_categoria");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(ungrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        id_torneo=Principal.labelserialtorneo.getText();
        idmodalidad=id_torneo+id_categoria+"2";
        try{ 
            String sql="Select postfase from modalidad where id_modalidad= '"+idmodalidad+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            datopostfase=rs.getString("postfase");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(ungrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        idcompetencia=idmodalidad+datopostfase;
        try{ 
            String sql="Select grupos, rondas from competencia where id_competencia='"+idcompetencia+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            grupos=rs.getInt("grupos");
            rondas=rs.getInt("rondas");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(ungrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(grupos!=0){
        if(rondas==0){
            int opc=JOptionPane.showConfirmDialog(null,"Desea guardar esa cantidad de jornadas?","Informacion", JOptionPane.YES_NO_OPTION);
            if(opc==0){
                nrondas= Integer.parseInt(comborondas.getSelectedItem().toString());
                try{
                    datomodificarrondas user= new datomodificarrondas(nrondas,idcompetencia);
                    competencia in= new competencia();
                    boolean r;
                    r=in.Modificar(user);
                    if(r==false){
                        JOptionPane.showMessageDialog(null,"Cantidad de jornadas guardadas","Informacion",JOptionPane.INFORMATION_MESSAGE);
                        guardarjuegos();
                    }
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,"Error "+ex.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
                }catch(ClassNotFoundException e){
                    Logger.getLogger(ungrupo.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }
        }else{
            guardarjuegos();
        }
    }
    public final void verificarronda(){
        nombrecat=panelcrear.combocategoria.getSelectedItem().toString();
        try{ 
            String sql="Select id_categoria from categoria where nombre_cat= '"+nombrecat+"' and sexo='Masculino';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            id_categoria=rs.getString("id_categoria");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(ungrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        id_torneo=Principal.labelserialtorneo.getText();
       idmodalidad=id_torneo+id_categoria+"2";
        try{ 
            String sql="Select postfase from modalidad where id_modalidad= '"+idmodalidad+"';";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.first()){
            datopostfase=rs.getString("postfase");
            break;
            }            
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(ungrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        idcompetencia=idmodalidad+datopostfase;
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
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(ungrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(rondas==0){
            comborondas.setEnabled(true);
        }else{
            comborondas.setEnabled(false);
            comborondas.removeAllItems();
            combo.addElement(rondas);
            comborondas.setModel(combo);
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
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(dosgrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
        id_torneo=Principal.labelserialtorneo.getText();
        rondas=Integer.parseInt(comborondas.getSelectedItem().toString());
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
            }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(Gcronograma.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(ctrl!=2){
            rondas=Integer.parseInt(comborondas.getSelectedItem().toString());
        if(cont==3){
            if(rondas==1){
                torneocronograma.tresequipos.tresequiposA tuno= new torneocronograma.tresequipos.tresequiposA();
                tuno.tresequiposa1();
            }else
            if(rondas==2){
                 torneocronograma.tresequipos.tresequiposA tuno= new torneocronograma.tresequipos.tresequiposA();
                 tuno.tresequiposa1();
                 tuno.tresequiposa2();
            }else
            if(rondas==3){
                 torneocronograma.tresequipos.tresequiposA tuno= new torneocronograma.tresequipos.tresequiposA();
                 tuno.tresequiposa1();
                 tuno.tresequiposa2();
                 tuno.tresequiposa3();
            }if(rondas==4){
                 torneocronograma.tresequipos.tresequiposA tuno= new torneocronograma.tresequipos.tresequiposA();
                 tuno.tresequiposa1();
                 tuno.tresequiposa2();
                 tuno.tresequiposa3();
                 tuno.tresequiposa4();
            }
        }else
        if(cont==4){
            if(rondas==1){
                torneocronograma.cuatroequipos.cuatroequiposA funo= new torneocronograma.cuatroequipos.cuatroequiposA();
                funo.cuatroequiposa1();
            }else
            if(rondas==2){
                torneocronograma.cuatroequipos.cuatroequiposA funo= new torneocronograma.cuatroequipos.cuatroequiposA();
                funo.cuatroequiposa1();
                funo.cuatroequiposa2();
            }else
            if(rondas==3){
                torneocronograma.cuatroequipos.cuatroequiposA funo= new torneocronograma.cuatroequipos.cuatroequiposA();
                funo.cuatroequiposa1();
                funo.cuatroequiposa2();
                funo.cuatroequiposa3();
            }if(rondas==4){
                torneocronograma.cuatroequipos.cuatroequiposA funo= new torneocronograma.cuatroequipos.cuatroequiposA();
                funo.cuatroequiposa1();
                funo.cuatroequiposa2();
                funo.cuatroequiposa3();
                funo.cuatroequiposa4();
            }
            
        }else
        if(cont==5){
            if(rondas==1){
                torneocronograma.cincoequipos.cincoequiposA cuno= new torneocronograma.cincoequipos.cincoequiposA();
                cuno.cincoequiposa1();
            }else
            if(rondas==2){
                torneocronograma.cincoequipos.cincoequiposA cuno= new torneocronograma.cincoequipos.cincoequiposA();
                cuno.cincoequiposa1();
                cuno.cincoequiposa2();
            }else
            if(rondas==3){
                torneocronograma.cincoequipos.cincoequiposA cuno= new torneocronograma.cincoequipos.cincoequiposA();
                cuno.cincoequiposa1();
                cuno.cincoequiposa2();
                cuno.cincoequiposa3();
            }if(rondas==4){
                torneocronograma.cincoequipos.cincoequiposA cuno= new torneocronograma.cincoequipos.cincoequiposA();
                cuno.cincoequiposa1();
                cuno.cincoequiposa2();
                cuno.cincoequiposa3();
                cuno.cincoequiposa4();
            }
        }else
        if(cont==6){
            if(rondas==1){
                torneocronograma.seisequipos.seisequiposA suno= new torneocronograma.seisequipos.seisequiposA();
                suno.seisequiposa1();
            }else
            if(rondas==2){
                torneocronograma.seisequipos.seisequiposA suno= new torneocronograma.seisequipos.seisequiposA();
                suno.seisequiposa1();
                suno.seisequiposa2();
            }else
            if(rondas==3){
                torneocronograma.seisequipos.seisequiposA suno= new torneocronograma.seisequipos.seisequiposA();
                suno.seisequiposa1();
                suno.seisequiposa2();
                suno.seisequiposa3();
            }if(rondas==4){
                torneocronograma.seisequipos.seisequiposA suno= new torneocronograma.seisequipos.seisequiposA();
                suno.seisequiposa1();
                suno.seisequiposa2();
                suno.seisequiposa3();
                suno.seisequiposa4();
            }
        }else
        if(cont==7){
            if(rondas==1){
                torneocronograma.sieteequipos.sieteequiposA siuno= new torneocronograma.sieteequipos.sieteequiposA();
                siuno.sieteequiposa1();
            }else
            if(rondas==2){
                torneocronograma.sieteequipos.sieteequiposA siuno= new torneocronograma.sieteequipos.sieteequiposA();
                siuno.sieteequiposa1();
                siuno.sieteequiposa2();
            }else
            if(rondas==3){
                torneocronograma.sieteequipos.sieteequiposA siuno= new torneocronograma.sieteequipos.sieteequiposA();
                siuno.sieteequiposa1();
                siuno.sieteequiposa2();
                siuno.sieteequiposa3();
            }if(rondas==4){
                torneocronograma.sieteequipos.sieteequiposA siuno= new torneocronograma.sieteequipos.sieteequiposA();
                siuno.sieteequiposa1();
                siuno.sieteequiposa2();
                siuno.sieteequiposa3();
                siuno.sieteequiposa4();
            }
        }else
        if(cont==8){
            if(rondas==1){
                torneocronograma.ochoequipos.ochoequiposA ochuno= new torneocronograma.ochoequipos.ochoequiposA();
                ochuno.ochoequiposa1();
            }else
            if(rondas==2){
                torneocronograma.ochoequipos.ochoequiposA ochuno= new torneocronograma.ochoequipos.ochoequiposA();
                ochuno.ochoequiposa1();
                ochuno.ochoequiposa2();
            }else
            if(rondas==3){
                torneocronograma.ochoequipos.ochoequiposA ochuno= new torneocronograma.ochoequipos.ochoequiposA();
                ochuno.ochoequiposa1();
                ochuno.ochoequiposa2();
                ochuno.ochoequiposa3();
            }if(rondas==4){
                torneocronograma.ochoequipos.ochoequiposA ochuno= new torneocronograma.ochoequipos.ochoequiposA();
                ochuno.ochoequiposa1();
                ochuno.ochoequiposa2();
                ochuno.ochoequiposa3();
                ochuno.ochoequiposa4();
            }
        }else
        if(cont==9){
           if(rondas==1){
                torneocronograma.nueveequipos.nueveequiposA nueveuno= new torneocronograma.nueveequipos.nueveequiposA();
                nueveuno.nueveequiposa1();
            }else
            if(rondas==2){
                torneocronograma.nueveequipos.nueveequiposA nueveuno= new torneocronograma.nueveequipos.nueveequiposA();
                nueveuno.nueveequiposa1();
                nueveuno.nueveequiposa2();
            }else
            if(rondas==3){
                torneocronograma.nueveequipos.nueveequiposA nueveuno= new torneocronograma.nueveequipos.nueveequiposA();
                nueveuno.nueveequiposa1();
                nueveuno.nueveequiposa2();
                nueveuno.nueveequiposa3();
            }if(rondas==4){
                torneocronograma.nueveequipos.nueveequiposA nueveuno= new torneocronograma.nueveequipos.nueveequiposA();
                nueveuno.nueveequiposa1();
                nueveuno.nueveequiposa2();
                nueveuno.nueveequiposa3();
                nueveuno.nueveequiposa4();
            }
            
        }else
        if(cont==10){
             if(rondas==1){
                torneocronograma.diezequipos.diezequiposA diezuno= new torneocronograma.diezequipos.diezequiposA();
                diezuno.diezequiposa1();
            }else
            if(rondas==2){
                torneocronograma.diezequipos.diezequiposA diezuno= new torneocronograma.diezequipos.diezequiposA();
                diezuno.diezequiposa1();
                diezuno.diezequiposa2();
            }else
            if(rondas==3){
                torneocronograma.diezequipos.diezequiposA diezuno= new torneocronograma.diezequipos.diezequiposA();
                diezuno.diezequiposa1();
                diezuno.diezequiposa2();
                diezuno.diezequiposa3();
            }if(rondas==4){
                torneocronograma.diezequipos.diezequiposA diezuno= new torneocronograma.diezequipos.diezequiposA();
                diezuno.diezequiposa1();
                diezuno.diezequiposa2();
                diezuno.diezequiposa3();
                diezuno.diezequiposa4();
            }
        }else
        if(cont==11){
            if(rondas==1){
                torneocronograma.onceequipos.onceequiposA onceuno= new torneocronograma.onceequipos.onceequiposA();
                onceuno.onceequiposa1();
            }else
            if(rondas==2){
                torneocronograma.onceequipos.onceequiposA onceuno= new torneocronograma.onceequipos.onceequiposA();
                onceuno.onceequiposa1();
                onceuno.onceequiposa2();
            }else
            if(rondas==3){
                torneocronograma.onceequipos.onceequiposA onceuno= new torneocronograma.onceequipos.onceequiposA();
                onceuno.onceequiposa1();
                onceuno.onceequiposa2();
                onceuno.onceequiposa3();
            }if(rondas==4){
                torneocronograma.onceequipos.onceequiposA onceuno= new torneocronograma.onceequipos.onceequiposA();
                onceuno.onceequiposa1();
                onceuno.onceequiposa2();
                onceuno.onceequiposa3();
                onceuno.onceequiposa4();
            }
            
        }else
        if(cont==12){
            if(rondas==1){
                torneocronograma.doceequipos.doceequiposA doceuno= new torneocronograma.doceequipos.doceequiposA();
                doceuno.doceequiposa1();
            }else
            if(rondas==2){
                torneocronograma.doceequipos.doceequiposA doceuno= new torneocronograma.doceequipos.doceequiposA();
                doceuno.doceequiposa1();
                doceuno.doceequiposa2();
            }else
            if(rondas==3){
                torneocronograma.doceequipos.doceequiposA doceuno= new torneocronograma.doceequipos.doceequiposA();
                doceuno.doceequiposa1();
                doceuno.doceequiposa2();
                doceuno.doceequiposa3();
            }if(rondas==4){
                torneocronograma.doceequipos.doceequiposA doceuno= new torneocronograma.doceequipos.doceequiposA();
                doceuno.doceequiposa1();
                doceuno.doceequiposa2();
                doceuno.doceequiposa3();
                doceuno.doceequiposa4();
            }
        }else
        if(cont==13){
            JOptionPane.showMessageDialog(this,"No se poseen cruces para esa cantidad de equipos","Informacion",JOptionPane.INFORMATION_MESSAGE);
        }else
        if(cont==14){
            
        }
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        batras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grupoa = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        bsiguiente = new javax.swing.JButton();
        comborondas = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(860, 270));
        setOpaque(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(860, 270));
        jPanel1.setOpaque(false);

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

        grupoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        grupoa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        grupoa.setEnabled(false);
        grupoa.setOpaque(false);
        jScrollPane1.setViewportView(grupoa);

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

        comborondas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rondas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("A");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(batras, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(comborondas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(bsiguiente)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comborondas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bsiguiente))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(batras))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
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
         abrircopa();
       }catch(Exception e){
           
       }
      
    }//GEN-LAST:event_batrasActionPerformed

    private void bsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsiguienteActionPerformed
        guardarronda();
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
    public static javax.swing.JComboBox comborondas;
    public static javax.swing.JTable grupoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
