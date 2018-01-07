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
public class CHoaDon {

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public void setNguoiLapHD(String nguoiLapHD) {
        this.nguoiLapHD = nguoiLapHD;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getMaHD() {
        return maHD;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public String getNguoiLapHD() {
        return nguoiLapHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getMaKM() {
        return maKM;
    }
    
    public CHoaDon(){
        
    }
    public CHoaDon(String maHD, Date ngayLap, String nguoiLapHD, String maKH, String maKM) {
        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.nguoiLapHD = nguoiLapHD;
        this.maKH = maKH;
        this.maKM = maKM;
    }
    private String maHD;
    private Date ngayLap;
    private String nguoiLapHD;
    private String maKH;
    private String maKM;
}
