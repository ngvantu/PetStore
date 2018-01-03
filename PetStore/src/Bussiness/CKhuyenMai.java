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
public class CKhuyenMai {

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public void setGiaTriKM(int giaTriKM) {
        this.giaTriKM = giaTriKM;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public String getMaKM() {
        return maKM;
    }

    public int getGiaTriKM() {
        return giaTriKM;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public CKhuyenMai(String maKM, int giaTriKM, Date ngayBD, Date ngayKT) {
        this.maKM = maKM;
        this.giaTriKM = giaTriKM;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
    }
    String maKM;
    int giaTriKM;
    Date ngayBD;
    Date ngayKT;
    
}
