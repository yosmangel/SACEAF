
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


public final class dosgrupos extends javax.swing.JPanel {

    static DefaultTableModel modelo= new DefaultTableModel();
    static DefaultTableModel modelo2= new DefaultTableModel();
    DefaultComboBoxModel combo= new DefaultComboBoxModel();
    String nombrecat,id_categoria,id_torneo,idcompetencia,idmodalidad,datopostfase,nombre_juego,equipo_local,
           equipo_visitante,id_juego,jornada,sexo;
    int rondas,nrondas,cont,numero_local,numero_visitante,grupos,ctrl,i;
    static String categoria, idtorneo,grupo,hequipo,idcategoria,lsexo;
    
    public dosgrupos() {
        initComponents();
        verificarronda();
        cargarequiposa();
        cargarequiposb();
    }

    

    public static void cargarequiposa(){
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
            Logger.getLogger(dosgrupos.class.getName()).log(Level.SEVERE, null, ex);
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
            grupoa.getColumnModel().getColumn(0).setPreferredWidth(45);
            grupoa.getColumnModel().getColumn(1).setPreferredWidth(120);
            grupoa.getColumnModel().getColumn(2).setPreferredWidth(120);
            TableRowSorter modeloordenado= new TableRowSorter(modelo);
            grupoa.setRowSorter(modeloordenado);
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(dosgrupos.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public static void cargarequiposb(){
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
            Logger.getLogger(dosgrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
     try{
            String[] titulos={"N°","Nombre","Identificador"};
            String[] registro= new String[3];
            String sql="Select he.posicion, c.nombre_club, e.identificador from club c, equipo e, h_equipo he where c.id_club=e.id_club and e.id_categoria='"+idcategoria+"' and he.id_equipo=e.id_equipo and he.id_torneo='"+idtorneo+"' and he.grupo_equipo='B' order by he.posicion;";
            Conexion parametro= new Conexion();
            Class.forName(parametro.getDriver());
            Connection con=DriverManager.getConnection(parametro.getURL(), parametro.getUsuario(), parametro.getPass());
            modelo2= new DefaultTableModel(null,titulos);
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
               registro [0]=rs.getString("he.posicion");
               registro [1]=rs.getString("c.nombre_club");
               registro [2]=rs.getString("e.identificador");
               modelo2.addRow(registro);
            }
            grupob.setModel(modelo2);
            grupob.getColumnModel().getColumn(0).setPreferredWidth(45);
            grupob.getColumnModel().getColumn(1).setPreferredWidth(120);
            grupob.getColumnModel().getColumn(2).setPreferredWidth(120);
            TableRowSorter modeloordenado= new TableRowSorter(modelo2);
            grupob.setRowSorter(modeloordenado);
            
        }catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(dosgrupos.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public void abrircopa(){
       equiposcopa cc= new equiposcopa();
       String titulo= "Copa";
       int index= panelcrear.panelmodalidades.indexOfTab(titulo);
       
       if (index== -1){
           panelcrear.panelmodalidades.addTab(titulo, cc);
           int h=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(h);
       }else{
           panelcrear.panelmodalidades.remove(index);
           panelcrear.panelmodalidades.addTab(titulo, cc);
           int h=panelcrear.panelmodalidades.indexOfTab(titulo);
           panelcrear.panelmodalidades.setSelectedIndex(h);
       }

   } 
    public void guardarronda(){
        if(dosgrupos.comborondas.isEnabled()==true){
        nrondas=0;
        nombrecat=panelcrear.combocategoria.getSelectedItem().toString();
        nrondas=Integer.parseInt(comborondas.getSelectedItem().toString());
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
            Logger.getLogger(dosgrupos.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(dosgrupos.class.getName()).log(Level.SEVERE, null, ex);
            }

        if(grupos!=0){
        if(rondas==0){
            int opc=JOptionPane.showConfirmDialog(null,"Desea guardar esa cantidad de jornadas?","Informacion", JOptionPane.YES_NO_OPTION);
            if(opc==0){
                try{
                    datomodificarrondas user= new datomodificarrondas(nrondas,idcompetencia);
                    competencia in= new competencia();
                    boolean r;
                    r=in.Modificar(user);
                    if(r==false){
                        JOptionPane.showMessageDialog(this,"Cantidad de jornadas guardadas","Informacion",JOptionPane.INFORMATION_MESSAGE);
                        guardarjuegos();
                    }
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(this,"Error "+ex.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
                }catch(ClassNotFoundException e){
                    Logger.getLogger(dosgrupos.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }
        }else{
            
            guardarjuegos();
        }
    }
    public void verificarronda(){
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
            Logger.getLogger(dosgrupos.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(dosgrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
        try{
        if(rondas==0){
            comborondas.setEnabled(true);
        }else{
            comborondas.setEnabled(false);
            comborondas.removeAllItems();
            combo.addElement(rondas);
            comborondas.setModel(combo);
        }
        }catch(Exception e){
            
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
            Logger.getLogger(dosgrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
        nombrecat=panelcrear.combocategoria.getSelectedItem().toString();
        
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
        id_juego=id_torneo+id_categoria+"1"+"1"+"A"+"1";
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
            Logger.getLogger(dosgrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(ctrl!=2){
            rondas=Integer.parseInt(comborondas.getSelectedItem().toString());
       if(cont==3){
           torneocronograma.tresequipos.tresequiposA tuno= new torneocronograma.tresequipos.tresequiposA();
           torneocronograma.tresequipos.tresequiposB teb= new torneocronograma.tresequipos.tresequiposB(); 
           if(rondas==1){
               
                tuno.tresequiposa1();
                teb.tresequiposB();
            }else
            if(rondas==2){
                 tuno.tresequiposa1();
                 tuno.tresequiposa2();
                 teb.tresequiposB();
                 teb.tresequiposB2();
            }else
            if(rondas==3){
                 tuno.tresequiposa1();
                 tuno.tresequiposa2();
                 tuno.tresequiposa3();
                 teb.tresequiposB();
                 teb.tresequiposB2();
                 teb.tresequiposB3();
            }if(rondas==4){
                 tuno.tresequiposa1();
                 tuno.tresequiposa2();
                 tuno.tresequiposa3();
                 tuno.tresequiposa4();
                 teb.tresequiposB();
                 teb.tresequiposB2();
                 teb.tresequiposB3();
                 teb.tresequiposB4();
            }
        }else
        if(cont==4){
           torneocronograma.cuatroequipos.cuatroequiposA funo= new torneocronograma.cuatroequipos.cuatroequiposA();
           torneocronograma.cuatroequipos.cuatroequiposB ceb= new torneocronograma.cuatroequipos.cuatroequiposB();
           if(rondas==1){
                funo.cuatroequiposa1();
                ceb.cuatroequiposb1();
            }else
            if(rondas==2){
                funo.cuatroequiposa1();
                funo.cuatroequiposa2();
                ceb.cuatroequiposb1();
                ceb.cuatroequiposb2();
            }else
            if(rondas==3){
                funo.cuatroequiposa1();
                funo.cuatroequiposa2();
                funo.cuatroequiposa3();
                ceb.cuatroequiposb1();
                ceb.cuatroequiposb2();
                ceb.cuatroequiposb3();
            }if(rondas==4){
                funo.cuatroequiposa1();
                funo.cuatroequiposa2();
                funo.cuatroequiposa3();
                funo.cuatroequiposa4();
                ceb.cuatroequiposb1();
                ceb.cuatroequiposb2();
                ceb.cuatroequiposb3();
                ceb.cuatroequiposb4();
            }
            
        }else
        if(cont==5){
            torneocronograma.cincoequipos.cincoequiposA cuno= new torneocronograma.cincoequipos.cincoequiposA();
            torneocronograma.cincoequipos.cincoequiposB ceqb= new torneocronograma.cincoequipos.cincoequiposB();
            if(rondas==1){
                cuno.cincoequiposa1();
                ceqb.cincoequiposb1();
            }else
            if(rondas==2){
                cuno.cincoequiposa1();
                cuno.cincoequiposa2();
                ceqb.cincoequiposb1();
                ceqb.cincoequiposb2();
            }else
            if(rondas==3){
                cuno.cincoequiposa1();
                cuno.cincoequiposa2();
                cuno.cincoequiposa3();
                ceqb.cincoequiposb1();
                ceqb.cincoequiposb2();
                ceqb.cincoequiposb3();
            }if(rondas==4){
                cuno.cincoequiposa1();
                cuno.cincoequiposa2();
                cuno.cincoequiposa3();
                cuno.cincoequiposa4();
                ceqb.cincoequiposb1();
                ceqb.cincoequiposb2();
                ceqb.cincoequiposb3();
                ceqb.cincoequiposb4();
            }
        }else
        if(cont==6){
            torneocronograma.seisequipos.seisequiposA suno= new torneocronograma.seisequipos.seisequiposA();
            torneocronograma.seisequipos.seisequiposB seb= new torneocronograma.seisequipos.seisequiposB();
            if(rondas==1){
                suno.seisequiposa1();
                seb.seisequiposb1();
            }else
            if(rondas==2){
                suno.seisequiposa1();
                suno.seisequiposa2();
                seb.seisequiposb1();
                seb.seisequiposb2();
            }else
            if(rondas==3){
                suno.seisequiposa1();
                suno.seisequiposa2();
                suno.seisequiposa3();
                seb.seisequiposb1();
                seb.seisequiposb2();
                seb.seisequiposb3();
            }if(rondas==4){
                suno.seisequiposa1();
                suno.seisequiposa2();
                suno.seisequiposa3();
                suno.seisequiposa4();
                seb.seisequiposb1();
                seb.seisequiposb2();
                seb.seisequiposb3();
                seb.seisequiposb4();
            }
        }else
        if(cont==7){
           torneocronograma.sieteequipos.sieteequiposA siuno= new torneocronograma.sieteequipos.sieteequiposA();
           torneocronograma.sieteequipos.sieteequiposB sieb= new torneocronograma.sieteequipos.sieteequiposB();
           if(rondas==1){
                siuno.sieteequiposa1();
                sieb.sieteequiposb1();
            }else
            if(rondas==2){
                siuno.sieteequiposa1();
                siuno.sieteequiposa2();
                sieb.sieteequiposb1();
                sieb.sieteequiposb2();
            }else
            if(rondas==3){
                siuno.sieteequiposa1();
                siuno.sieteequiposa2();
                siuno.sieteequiposa3();
                sieb.sieteequiposb1();
                sieb.sieteequiposb2();
                sieb.sieteequiposb3();
            }if(rondas==4){
                siuno.sieteequiposa1();
                siuno.sieteequiposa2();
                siuno.sieteequiposa3();
                siuno.sieteequiposa4();
                sieb.sieteequiposb1();
                sieb.sieteequiposb2();
                sieb.sieteequiposb3();
                sieb.sieteequiposb4();
            }
        }else
        if(cont==8){
            torneocronograma.ochoequipos.ochoequiposA ochuno= new torneocronograma.ochoequipos.ochoequiposA();
            torneocronograma.ochoequipos.ochoequiposB oeb= new torneocronograma.ochoequipos.ochoequiposB();
            if(rondas==1){
                ochuno.ochoequiposa1();
                oeb.ochoequiposb1();
            }else
            if(rondas==2){
                ochuno.ochoequiposa1();
                ochuno.ochoequiposa2();
                oeb.ochoequiposb1();
                oeb.ochoequiposb2();
            }else
            if(rondas==3){
                ochuno.ochoequiposa1();
                ochuno.ochoequiposa2();
                ochuno.ochoequiposa3();
                oeb.ochoequiposb1();
                oeb.ochoequiposb2();
                oeb.ochoequiposb3();
            }if(rondas==4){
                ochuno.ochoequiposa1();
                ochuno.ochoequiposa2();
                ochuno.ochoequiposa3();
                ochuno.ochoequiposa4();
                oeb.ochoequiposb1();
                oeb.ochoequiposb2();
                oeb.ochoequiposb3();
                oeb.ochoequiposb4();
            }
        }else
        if(cont==9){
            torneocronograma.nueveequipos.nueveequiposA nueveuno= new torneocronograma.nueveequipos.nueveequiposA();
            torneocronograma.nueveequipos.nueveequiposB nueveb= new torneocronograma.nueveequipos.nueveequiposB();
            if(rondas==1){
                nueveuno.nueveequiposa1();
                nueveb.nueveequiposb1();
            }else
            if(rondas==2){
                nueveuno.nueveequiposa1();
                nueveuno.nueveequiposa2();
                nueveb.nueveequiposb1();
                nueveb.nueveequiposb2();
            }else
            if(rondas==3){
                nueveuno.nueveequiposa1();
                nueveuno.nueveequiposa2();
                nueveuno.nueveequiposa3();
                nueveb.nueveequiposb1();
                nueveb.nueveequiposb2();
                nueveb.nueveequiposb3();
            }if(rondas==4){
                nueveuno.nueveequiposa1();
                nueveuno.nueveequiposa2();
                nueveuno.nueveequiposa3();
                nueveuno.nueveequiposa4();
                nueveb.nueveequiposb1();
                nueveb.nueveequiposb2();
                nueveb.nueveequiposb3();
                nueveb.nueveequiposb4();
            }
            
        }else
        if(cont==10){
            torneocronograma.diezequipos.diezequiposA diezuno= new torneocronograma.diezequipos.diezequiposA();
            torneocronograma.diezequipos.diezequiposB dieb = new torneocronograma.diezequipos.diezequiposB();
            if(rondas==1){
                diezuno.diezequiposa1();
                dieb.diezequiposb1();
            }else
            if(rondas==2){
                diezuno.diezequiposa1();
                diezuno.diezequiposa2();
                dieb.diezequiposb1();
                dieb.diezequiposb2();
            }else
            if(rondas==3){
                diezuno.diezequiposa1();
                diezuno.diezequiposa2();
                diezuno.diezequiposa3();
                dieb.diezequiposb1();
                dieb.diezequiposb2();
                dieb.diezequiposb3();
            }if(rondas==4){
                diezuno.diezequiposa1();
                diezuno.diezequiposa2();
                diezuno.diezequiposa3();
                diezuno.diezequiposa4();
                dieb.diezequiposb1();
                dieb.diezequiposb2();
                dieb.diezequiposb3();
                dieb.diezequiposb4();
            }
        }else
        if(cont==11){
            torneocronograma.onceequipos.onceequiposA onceuno= new torneocronograma.onceequipos.onceequiposA();
            torneocronograma.onceequipos.onceequiposB onceb= new torneocronograma.onceequipos.onceequiposB();
            if(rondas==1){
                onceuno.onceequiposa1();
                onceb.onceequiposb1();
            }else
            if(rondas==2){
                onceuno.onceequiposa1();
                onceuno.onceequiposa2();
                onceb.onceequiposb1();
                onceb.onceequiposb2();
            }else
            if(rondas==3){
                onceuno.onceequiposa1();
                onceuno.onceequiposa2();
                onceuno.onceequiposa3();
                onceb.onceequiposb1();
                onceb.onceequiposb2();
                onceb.onceequiposb3();
            }if(rondas==4){
                onceuno.onceequiposa1();
                onceuno.onceequiposa2();
                onceuno.onceequiposa3();
                onceuno.onceequiposa4();
                onceb.onceequiposb1();
                onceb.onceequiposb2();
                onceb.onceequiposb3();
                onceb.onceequiposb4();
            }
            
        }else
        if(cont==12){
            torneocronograma.doceequipos.doceequiposA doceuno= new torneocronograma.doceequipos.doceequiposA();
            torneocronograma.doceequipos.doceequiposB doceb= new torneocronograma.doceequipos.doceequiposB();
            if(rondas==1){
                doceuno.doceequiposa1();
                doceb.doceequiposb1();
            }else
            if(rondas==2){
                doceuno.doceequiposa1();
                doceuno.doceequiposa2();
                doceb.doceequiposb1();
                doceb.doceequiposb2();
            }else
            if(rondas==3){
                doceuno.doceequiposa1();
                doceuno.doceequiposa2();
                doceuno.doceequiposa3();
                doceb.doceequiposb1();
                doceb.doceequiposb2();
                doceb.doceequiposb3();
            }if(rondas==4){
                doceuno.doceequiposa1();
                doceuno.doceequiposa2();
                doceuno.doceequiposa3();
                doceuno.doceequiposa4();
                doceb.doceequiposb1();
                doceb.doceequiposb2();
                doceb.doceequiposb3();
                doceb.doceequiposb4();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        grupob = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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

        grupob.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        grupob.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        grupob.setOpaque(false);
        jScrollPane2.setViewportView(grupob);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("A");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("B");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(batras, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addComponent(comborondas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bsiguiente)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(batras))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comborondas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bsiguiente)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
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
    public static javax.swing.JTable grupob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
