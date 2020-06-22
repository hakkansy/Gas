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
import uas.Dao.MahasiswaDao;
import uas.Model.MahasiswaModel;
import uas.View.FormMahasiswa;
import uas_pbo_hakkansyukri_1911082017.Koneksi;


/**
 *
 * @author User
 */
public class MahasiswaController {
    FormMahasiswa view;
    MahasiswaModel mahasiswa;
    MahasiswaDao mahasiswaDao;
    Connection con;
    Koneksi k;    
    
    public MahasiswaController(FormMahasiswa view){
        this.view = view;
        mahasiswaDao = new MahasiswaDao();
        k = new Koneksi();
        try{
            con = k.getConnection();            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    
    public void insert(){
        mahasiswa = new MahasiswaModel();
        mahasiswa.setNoBP(view.getTxtnoBP().getText());
        mahasiswa.setNama(view.getTxtnama().getText());
        mahasiswa.setTempatLahir(view.getTxttempatLahir().getText());
        mahasiswa.setTglLahir(view.getTxttglLahir().getText());
        mahasiswa.setNoTelp(view.getTxtnoTelp().getText());
        
        try{
            mahasiswaDao.create(mahasiswa);
            javax.swing.JOptionPane.showMessageDialog(null, "Insert OK");
        }
        catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error" +ex.getMessage());
        }
    }
    
    public void update(){
        mahasiswa = new MahasiswaModel();
        mahasiswa.setNoBP(view.getTxtnoBP().getText());
        mahasiswa.setNama(view.getTxtnama().getText());
        mahasiswa.setTempatLahir(view.getTxttempatLahir().getText());
        mahasiswa.setTglLahir(view.getTxttglLahir().getText());
        mahasiswa.setNoTelp(view.getTxtnoTelp().getText());
        
        try{
            mahasiswaDao.update(mahasiswa);
            javax.swing.JOptionPane.showMessageDialog(null, "Update OK");
        }
        catch(SQLException ex){
            java.util.logging.Logger.getLogger(MahasiswaController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void delete(){
        String noBP = view.getTxtnoBP().getText();
        try{
            mahasiswaDao.delete(noBP);
            JOptionPane.showMessageDialog(null, "Delete Success");
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.clear();
    }
    
    public void clear(){
        view.getTxtnoBP().setText("");
        view.getTxtnama().setText("");
        view.getTxttempatLahir().setText("");
        view.getTxttglLahir().setText("");
        view.getTxtnoTelp().setText("");
    }
    
    public void onMouseClickTabelMahasiswa(){
        mahasiswaDao = new MahasiswaDao();
        
        String noBP = view.getTabelMahasiswa().getValueAt(view.getTabelMahasiswa().getSelectedRow(), 0).toString();        
        
        try{
            mahasiswa = mahasiswaDao.getMahasiswa(noBP);
            view.getTxtnoBP().setText(mahasiswa.getNoBP());
            view.getTxtnama().setText(mahasiswa.getNama());
            view.getTxttempatLahir().setText(mahasiswa.getTempatLahir());
            view.getTxttglLahir().setText(mahasiswa.getTglLahir());
            view.getTxtnoTelp().setText(mahasiswa.getNoTelp());
        }
        catch(SQLException ex){
            Logger.getLogger(MahasiswaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void isiTabelMahasiswa(){
        try{
            DefaultTableModel model = (DefaultTableModel) view.getTabelMahasiswa().getModel();
            model.setRowCount(0);
            ResultSet rs = k.getQuery(con, "select*from mahasiswa");
            while(rs.next()){
                Object data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                };
                model.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
