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
public class CGiong {

    public void setMaGiong(String maGiong) {
        this.maGiong = maGiong;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public void setTenGiong(String tenGiong) {
        this.tenGiong = tenGiong;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getMaGiong() {
        return maGiong;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getTenGiong() {
        return tenGiong;
    }

    public String getMoTa() {
        return moTa;
    }

    public CGiong(String maGiong, String maLoai, String tenGiong, String moTa) {
        this.maGiong = maGiong;
        this.maLoai = maLoai;
        this.tenGiong = tenGiong;
        this.moTa = moTa;
    }
    private String maGiong;
    private String maLoai;
    private String tenGiong;
    private String moTa;
}
