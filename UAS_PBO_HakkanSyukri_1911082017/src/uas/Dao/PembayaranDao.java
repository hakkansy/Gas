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
import uas.Model.PembayaranModel;
import uas_pbo_hakkansyukri_1911082017.Koneksi;

/**
 *
 * @author User
 */
public class PembayaranDao {
    Connection con;
    
    public PembayaranDao(){
        Koneksi k = new Koneksi();
        con = k.getConnection();
    }
    
    public void create(PembayaranModel pembayaran) throws SQLException{
        String sql = "insert into pembayaran values(?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pembayaran.getKdPembayaran());
        ps.setString(2, pembayaran.getNoBP());
        ps.setString(3, pembayaran.getKdProdi());
        ps.setString(4, pembayaran.getGol());
        ps.setString(5, pembayaran.getSemester());
        ps.setDouble(6, pembayaran.getTotal());
        ps.setString(7, pembayaran.getTglPembayaran());        
        ps.executeUpdate();
    }
    
    public void update(PembayaranModel pembayaran) throws SQLException{
        String sql ="update pembayaran set gol=?, semester=?, total=?,"
                + "tglPembayaran=? where kdPembayaran=? and noBP=? and "
                + "kdProdi=? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pembayaran.getGol());
        ps.setString(2, pembayaran.getSemester());
        ps.setDouble(3, pembayaran.getTotal());
        ps.setString(4, pembayaran.getTglPembayaran());
        ps.setString(5, pembayaran.getKdPembayaran());
        ps.setString(6, pembayaran.getNoBP());
        ps.setString(7, pembayaran.getKdProdi());
        ps.executeUpdate();
    }
    
    public void delete(String kdPembayaran, String noBP, String kdProdi) throws SQLException{
        String sql = "delete from pembayaran where kdPembayaran=?"
                + "and noBP=? and kdProdi=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kdPembayaran);
        ps.setString(2, noBP);
        ps.setString(3, kdProdi);
        ps.executeUpdate();
    }
    
    public PembayaranModel getPembayaran(String kdPembayaran, String noBP, String kdProdi) throws SQLException{
        String sql = "select*from pembayaran where kdPembayaran=?"
                + "and noBP=? and kdProdi=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kdPembayaran);
        ps.setString(2, noBP);
        ps.setString(3, kdProdi);
        PembayaranModel pembayaran = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            pembayaran = new PembayaranModel();
            pembayaran.setKdPembayaran(rs.getString(1));
            pembayaran.setNoBP(rs.getString(2));
            pembayaran.setKdProdi(rs.getString(3));
            pembayaran.setGol(rs.getString(4));
            pembayaran.setSemester(rs.getString(5));
            pembayaran.setTglPembayaran(rs.getString(6));
            pembayaran.setTotal(rs.getDouble(7));
        }
        return pembayaran;
    }
}
