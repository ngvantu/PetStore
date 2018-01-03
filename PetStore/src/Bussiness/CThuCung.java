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
public class CThuCung {

    public void setMaTC(String maTC) {
        this.maTC = maTC;
    }

    public void setMaGiong(String maGiong) {
        this.maGiong = maGiong;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getMaTC() {
        return maTC;
    }

    public String getMaGiong() {
        return maGiong;
    }

    public int getDonGia() {
        return donGia;
    }

    public CThuCung(String maTC, String maGiong, int donGia) {
        this.maTC = maTC;
        this.maGiong = maGiong;
        this.donGia = donGia;
    }
    private String maTC;
    private String maGiong;
    private int donGia;
}
