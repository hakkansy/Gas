/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uas.Model.MahasiswaModel;
import uas_pbo_hakkansyukri_1911082017.Koneksi;


/**
 *
 * @author User
 */
public class MahasiswaDao {
    Connection con;
    
    public MahasiswaDao(){
        Koneksi k = new Koneksi();
        con = k.getConnection();
    }
    
    public void create(MahasiswaModel mahasiswa) throws SQLException{
        String sql = "insert into mahasiswa values(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, mahasiswa.getNoBP());
        ps.setString(2, mahasiswa.getNama());
        ps.setString(3, mahasiswa.getTempatLahir());
        ps.setString(4, mahasiswa.getTglLahir());
        ps.setString(5, mahasiswa.getNoTelp());
        ps.executeUpdate();
    }
    
    public void update(MahasiswaModel mahasiswa) throws SQLException{
        String sql = "update mahasiswa set nama=?, tempatLahir=?, "
                + "tglLahir=?, noTelp=? where noBP=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(5, mahasiswa.getNoBP());
        ps.setString(1, mahasiswa.getNama());
        ps.setString(2, mahasiswa.getTempatLahir());
        ps.setString(3, mahasiswa.getTglLahir());
        ps.setString(4, mahasiswa.getNoTelp());
        ps.executeUpdate();
    }
    
    public void delete(String noBP) throws SQLException{
        String sql = "delete from mahasiswa where noBP=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, noBP);
        ps.executeUpdate();
    }
    
    public MahasiswaModel getMahasiswa(String noBP) throws SQLException{
        String sql = "select*from mahasiswa where noBP=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, noBP);
        MahasiswaModel mahasiswa = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            mahasiswa = new MahasiswaModel();
            mahasiswa.setNoBP(rs.getString(1));
            mahasiswa.setNama(rs.getString(2));
            mahasiswa.setTempatLahir(rs.getString(3));
            mahasiswa.setTglLahir(rs.getString(4));
            mahasiswa.setNoTelp(rs.getString(5));                        
        }
        return mahasiswa;
    }
    
    
}
