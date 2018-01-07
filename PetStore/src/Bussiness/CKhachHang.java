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
public class CKhachHang {

    static BKhachHang b = new BKhachHang();
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    
    public void Update(){
        b.updateByProperties(this);
    }
    
    static public boolean CheckExist(String s){
        return b.Check(s);
    }
    
    public void Insert(){
        b.insertKhachHang(this);
    }
    public static void DeleteRecord(String S){
        b.Delete(S);
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

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public CKhachHang(String maKH, String hoTen, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String cmnd) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.cmnd = cmnd;
    }

    public CKhachHang() {
    }

    public String getMaKH() {
        return maKH;
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

    public String getCmnd() {
        return cmnd;
    }



    private String maKH;
    private String hoTen;   
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String cmnd;
    
}
