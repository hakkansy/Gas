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
import uas.Model.ProdiModel;
import uas_pbo_hakkansyukri_1911082017.Koneksi;

/**
 *
 * @author User
 */
public class ProdiDao {
    Connection con;
    
    public ProdiDao(){
        Koneksi k = new Koneksi();
        con = k.getConnection();
    }
    
    public void create(ProdiModel prodi) throws SQLException{
        String sql = "insert into prodi values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, prodi.getKdProdi());
        ps.setString(2, prodi.getProdi());
        ps.setString(3, prodi.getJurusan());
        ps.executeUpdate();
    }
    
    public void update(ProdiModel prodi) throws SQLException{
        String sql = "update into prodi set prodi=?, jurusan=?"
                + "where kdProdi=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(3, prodi.getKdProdi());
        ps.setString(1, prodi.getProdi());
        ps.setString(2, prodi.getJurusan());
        ps.executeUpdate();
    }
    
    public void delete(String kdProdi) throws SQLException{
        String sql = "delete from prodi where kdProdi=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kdProdi);
        ps.executeUpdate();
    }
    
    public ProdiModel getProdi(String kdProdi) throws SQLException{
        String sql = "select*from prodi where kdProdi=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kdProdi);
        ProdiModel prodi = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            prodi = new ProdiModel();
            prodi.setKdProdi(rs.getString(1));
            prodi.setProdi(rs.getString(2));
            prodi.setJurusan(rs.getString(3));
        }
        return prodi;
    }
    
    public String[] getJurusanProdi(String kdProdi) throws SQLException{
        String sql = "select prodi, jurusan from prodi where kdProdi=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kdProdi);
        String prodi = null;
        String jurusan = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            prodi = rs.getString(1);
            jurusan = rs.getString(2);
        }
        return null;
    }
}
