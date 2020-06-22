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
import uas.Dao.PembayaranDao;
import uas.Dao.ProdiDao;
import uas.Model.MahasiswaModel;
import uas.Model.PembayaranModel;
import uas.Model.ProdiModel;
import uas.View.FormPembayaran;
import uas_pbo_hakkansyukri_1911082017.Koneksi;

/**
 *
 * @author User
 */
public class PembayaranController {
    FormPembayaran view;
    PembayaranModel pembayaran;
    PembayaranDao pembayaranDao;
    ProdiDao prodiDao;
    ProdiModel prodi;
    MahasiswaDao mahasiswaDao;
    MahasiswaModel mahasiswa;
    Connection con;
    Koneksi k;
    
    public PembayaranController(FormPembayaran view){
        this.view = view;
        pembayaranDao = new PembayaranDao();
        prodiDao = new ProdiDao();
        mahasiswaDao = new MahasiswaDao();
        pembayaran = new PembayaranModel();
        prodi = new ProdiModel();
        mahasiswa = new MahasiswaModel();
        k = new Koneksi();
        try{
            con = k.getConnection();            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }     
    }
    
    public void insert(){
        String kdPembayaran = view.getTxtKdPembayaran().getText();
        String noBP = view.getTxtnoBP().getText();
        String kdProdi = view.getTxtkdProdi().getText();
        
        pembayaran = new PembayaranModel();
        pembayaran.setKdPembayaran(view.getTxtKdPembayaran().getText());
        pembayaran.setNoBP(view.getTxtnama().getText());
        pembayaran.setKdProdi(view.getTxtprodi().getText());
        pembayaran.setSemester((String) view.getComsemester().getSelectedItem());
        pembayaran.setGol((String) view.getComgolongan().getSelectedItem());
        pembayaran.setTotal(Double.parseDouble(view.getTxttotal().getText()));
        pembayaran.setTglPembayaran(view.getTxttglPembayaran().getText());
        
        try{
            pembayaranDao.create(pembayaran);
            pembayaranDao.delete(kdPembayaran, noBP, kdProdi);
        } catch (SQLException ex) {
            Logger.getLogger(PembayaranController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        String kdPembayaran = view.getTxtKdPembayaran().getText();
        String noBP = view.getTxtnoBP().getText();
        String kdProdi = view.getTxtkdProdi().getText();
        try{
            pembayaranDao.delete(kdPembayaran, noBP, kdProdi);
            DefaultTableModel model = (DefaultTableModel) view.getTabelPembayaran().getModel();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex);
        }
    }
    
    public void clear(){
        view.getTxtKdPembayaran().setText("");
        view.getTxtnoBP().setText("");
        view.getTxtnama().setText("");
        view.getTxtkdProdi().setText("");
        view.getTxtprodi().setText("");
        view.getTxtjurusan().setText("");        
        view.getTxttotal().setText("");
        view.getTxttglPembayaran().setText("");                        
    }
    
    public void isiTable(){
       try{
            DefaultTableModel model = (DefaultTableModel) view.getTabelPembayaran().getModel();
            model.setRowCount(0);
            ResultSet rs = k.getQuery(con, "select*from pembayaran"); 
            while(rs.next()){
                Object data[] = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getDouble(7),
                    rs.getString(8),
                };
                model.addRow(data);
            }    
        }catch (SQLException ex) {
            Logger.getLogger(PembayaranController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onKeyPressedNoBP(){
        try{
            MahasiswaDao mahasiswaDao = new MahasiswaDao();
            MahasiswaModel mahasiswa = mahasiswaDao.getMahasiswa(view.getTxtnoBP().getText());
            if(mahasiswa!=null){
                view.getTxtnama().setText(mahasiswa.getNama());
                view.getTxtkdProdi().requestFocus();
            }
            else{
                JOptionPane.showMessageDialog(view, "Data Tidak Ada");
            }            
        }
        catch(SQLException ex){
            Logger.getLogger(PembayaranController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onKeyPressedKdProdi(){
        try{
            ProdiDao prodiDao = new ProdiDao();
            ProdiModel prodi = prodiDao.getpProdi(view.getTxtkdProdi().getText());
            if(prodi != null){
                view.getTxtprodi().setText(prodi.getProdi());
                view.getTxtjurusan().setText(prodi.getJurusan());
                view.getComsemester().requestFocus();
            }
            else{
                JOptionPane.showMessageDialog(view, "Data Tidak Ada");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(PembayaranController.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void getTotal(){
        int indexGol = view.getComgolongan().getSelectedIndex();
        switch(indexGol){
            case 0:
                view.getTxttotal().setText("Rp.500.000");
                break;
            case 1:
                view.getTxttotal().setText("Rp.1.500.000");
                break;
            case 2:
                view.getTxttotal().setText("Rp.2.500.000");
                break;
            case 3:
                view.getTxttotal().setText("Rp.3.500.000");
                break;
            case 4:
                view.getTxttotal().setText("Rp.4.500.000");
                break;    
            case 5:
                view.getTxttotal().setText("Rp.5.500.000");
                break;    
            default :
                JOptionPane.showMessageDialog(view, "Input Salah");
                break;
        }
    }
        
}    