/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas.Model;

/**
 *
 * @author User
 */
public class PembayaranModel {
    public String kdPembayaran;
    public String noBP;
    public String kdProdi;
    public String gol;
    public String semester;
    public double total;
    public String tglPembayaran;

    public String getKdPembayaran() {
        return kdPembayaran;
    }

    public void setKdPembayaran(String kdPembayaran) {
        this.kdPembayaran = kdPembayaran;
    }

    public String getNoBP() {
        return noBP;
    }

    public void setNoBP(String noBP) {
        this.noBP = noBP;
    }

    public String getKdProdi() {
        return kdProdi;
    }

    public void setKdProdi(String kdProdi) {
        this.kdProdi = kdProdi;
    }

    public String getGol() {
        return gol;
    }

    public void setGol(String gol) {
        this.gol = gol;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTglPembayaran() {
        return tglPembayaran;
    }

    public void setTglPembayaran(String tglPembayaran) {
        this.tglPembayaran = tglPembayaran;
    }
    
    
}
