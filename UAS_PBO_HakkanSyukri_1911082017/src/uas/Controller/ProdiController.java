/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import uas.Dao.ProdiDao;
import uas.Model.ProdiModel;
import uas.View.FormProdi;
import uas_pbo_hakkansyukri_1911082017.Koneksi;

/**
 *
 * @author User
 */
public class ProdiController {
    FormProdi view;
    ProdiModel prodi;
    ProdiDao prodiDao;
    Connection con;
    Koneksi k;
    
    public ProdiController(FormProdi view){
        this.view = view;
        prodiDao = new ProdiDao();
        k = new Koneksi();
        try{
            con = k.getConnection();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    
   public void insert() {
       prodi = new ProdiModel();
       prodi.setKdProdi(view.getTxtkdProdi().getText());
       prodi.setProdi((String) view.getComprodi().getSelectedItem());
       prodi.setJurusan((String) view.getComJurusan().getSelectedItem());
       
       try{
           prodiDao.create(prodi);
           javax.swing.JOptionPane.showMessageDialog(null, "Insert OK");
        }
        catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error" +ex.getMessage());
        }       
   }
   
   public void update(){
       prodi = new ProdiModel();
       prodi.setKdProdi(view.getTxtkdProdi().getText());
       prodi.setProdi((String) view.getComprodi().getSelectedItem());
       prodi.setJurusan((String) view.getComJurusan().getSelectedItem());
       
       try{
           prodiDao.update(prodi);
           javax.swing.JOptionPane.showMessageDialog(null, "Update OK");
        }
        catch(SQLException ex){
             java.util.logging.Logger.getLogger(ProdiController.class.getName()).log(Level.SEVERE,null,ex);  
        }
   }
   
   public void delete(){
       String kdProdi = view.getTxtkdProdi().getText();
       try{
           prodiDao.delete(kdProdi);
           JOptionPane.showMessageDialog(null, "Delete Success");
       }
       catch(SQLException ex){
           Logger.getLogger(ProdiController.class.getName()).log(Level.SEVERE, null, ex);
       }
       this.clear();
   }
   
   public void clear(){
       view.getTxtkdProdi().setText("");       
   }
   
   public void onMouseClickTabelProdi(){
       prodiDao = new ProdiDao();
       String kdProdi = view.getTabelProdi().getValueAt(view.getTabelProdi().getSelectedRow(), 0).toString();
       try{
           prodi = prodiDao.getpProdi(kdProdi);
           view.getTxtkdProdi().setText(prodi.getKdProdi());          
       }
       catch(SQLException ex){
            Logger.getLogger(ProdiController.class.getName()).log(Level.SEVERE, null, ex);
        }       
   }
   
   public void isiTabelProdi(){
       try{
           DefaultTableModel model = (DefaultTableModel) view.getTabelProdi().getModel();
           model.setRowCount(0);
           ResultSet rs = k.getQuery(con, "select*from prodi");
           while(rs.next()){
                Object data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)
           };
           model.addRow(data);
       }
    }
       catch (SQLException ex) {
            Logger.getLogger(ProdiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
} 
