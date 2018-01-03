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
public class CChucVu {

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public void setDienGiai(String DienGiai) {
        this.DienGiai = DienGiai;
    }

    public String getMaCV() {
        return maCV;
    }

    public String getDienGiai() {
        return DienGiai;
    }

    public CChucVu(String maCV, String DienGiai) {
        this.maCV = maCV;
        this.DienGiai = DienGiai;
    }
    private String maCV;
    private String DienGiai;
    
}
