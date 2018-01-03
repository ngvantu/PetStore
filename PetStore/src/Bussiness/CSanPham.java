/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

/**
 *
 * @author voanh
 */
public class CSanPham {

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getLoai() {
        return loai;
    }

    public String getTenSP() {
        return tenSP;
    }

    public String getDonGia() {
        return donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public CSanPham(String maSP, String loai, String tenSP, String donGia, int soLuong) {
        this.maSP = maSP;
        this.loai = loai;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }
    private String maSP;
    private String loai;
    private String tenSP;
    private String donGia;
    private int soLuong;
}
