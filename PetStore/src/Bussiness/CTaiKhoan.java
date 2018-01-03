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
public class CTaiKhoan {

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setTenTk(String tenTk) {
        this.tenTk = tenTk;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getTenTk() {
        return tenTk;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public CTaiKhoan(String maNV, String tenTk, String matKhau) {
        this.maNV = maNV;
        this.tenTk = tenTk;
        this.matKhau = matKhau;
    }
    private String maNV;
    private String tenTk;
    private String matKhau;
    
}
