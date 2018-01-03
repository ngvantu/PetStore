/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;


import Data.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author MAIHUUTUAN
 */
public class BGiong extends Bussiness{
    public String TenGiong;
    public String MaGiong;
    
    public BGiong() {
        DB = new Data();
        Table = "GIONG";
        ID = "MAGIONG";
    }
    
    public ArrayList GetDanhSachGiongVatNuoi(String MaLoai) throws SQLException{
        ArrayList<BGiong> arrList = new ArrayList<BGiong>();
        SQL = "lay_danh_sach_giong_vat_nuoi " + MaLoai;
        ResultSet rs = DB.getData(SQL);
        while(rs.next()){
            BGiong Giong = new BGiong();
            Giong.MaGiong = rs.getString("MAGIONG");
            Giong.TenGiong = rs.getString("TENGIONG");
            arrList.add(Giong);
        }
        return arrList;
    }
}
