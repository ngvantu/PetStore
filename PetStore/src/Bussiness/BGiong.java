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
    public String MoTa;
    public int SL;
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
            Giong.MoTa = rs.getString("MOTA");
            arrList.add(Giong);
        }
        return arrList;
    }
    
    public boolean updateByProperties(String MALOAI, String MAGIONG, String TENGIONG, String MOTA){
        SQL="UPDATE "+Table+" SET "
                +" TENGIONG = N'"+TENGIONG+"', MOTA = N'"+MOTA+"'"
                +" WHERE MALOAI = '"+MALOAI+"' and MAGIONG = '" + MAGIONG + "'";
        return super.updateBySQLString(SQL);
    }
    
    public boolean insertByProperties(String MALOAI, String MAGIONG, String TENGIONG, String MOTA){
        SQL="INSERT INTO "+Table+" values('"+MAGIONG+"','"+MALOAI+"',N'"+TENGIONG+"',N'"+MOTA+"')";
        return super.insertBySQLString(SQL);
    }
    
    public ArrayList<BGiong> GetDanhSachThuCungDaBan(String NgayBD, String NgayKT) throws SQLException{
        ArrayList<BGiong> arrList = new ArrayList<BGiong>();
        SQL = "XuatDanhSachThuCungDaBan " + "'" + NgayBD + "', '" + NgayKT + "'";
        ResultSet rs = DB.getData(SQL);
        while(rs.next()){
           BGiong SanPham = new BGiong();
           SanPham.TenGiong = rs.getString("TENGIONG");
           SanPham.SL = rs.getInt("SOLUONG");
           arrList.add(SanPham);
        }
        return arrList;
    }
}
