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
public class CCTHDSanPham {

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setSTT(String STT) {
        this.STT = STT;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getMaHD() {
        return maHD;
    }

    public String getSTT() {
        return STT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public CCTHDSanPham(String maHD, String STT, int soLuong, int donGia) {
        this.maHD = maHD;
        this.STT = STT;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    String maHD;
    String STT;
    int soLuong;
    int donGia;
}
