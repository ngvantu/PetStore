/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import java.sql.Date;

/**
 *
 * @author voanh
 */
public class CNhanVienMoRong {

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenTK() {
        return tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public CNhanVienMoRong(String maNV, String hoTen, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String chucVu, int luong, String cmnd, String tenTK, String matKhau) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.chucVu = chucVu;
        this.luong = luong;
        this.cmnd = cmnd;
        this.tenTK = tenTK;
        this.matKhau = matKhau;
    }
    static BNhanVien b = new BNhanVien();
    
    public CNhanVienMoRong() {
    }
    

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public String getChucVu() {
        return chucVu;
    }

    public int getLuong() {
        return luong;
    }

    public String getCmnd() {
        return cmnd;
    }
    private String maNV;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String chucVu;
    private int luong;
    private String cmnd;
    private String tenTK;
    private String matKhau;

}
