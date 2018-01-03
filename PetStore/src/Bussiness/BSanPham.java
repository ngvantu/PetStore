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

/**
 *
 * @author voanh
 */
public class BSanPham extends Bussiness {
    public String MaSP;
    public String TenSP;
    public int DonGia;
    public int SL;
    
    public BSanPham() {
        DB = new Data();
        Table = "SANPHAM";
        ID = "MASP";
    }
    public boolean updateByProperties(String MASP,String LOAI, String TENSP, String DONGIA){
        SQL="UPDATE "+Table+" SET "
                +" LOAI = '"+LOAI+"',"
                +" TENSP = N'"+TENSP +"',"
                +" DONGIA = '"+DONGIA+"'"
                +" WHERE MASP = '"+MASP+"'";
        return super.updateBySQLString(SQL);
    }
    // đăng nhập rồi thì ẩn nó đi?? cái màn hình đăng nhập, nó cứ hiện kìa hoi idol á t s bết
    public boolean insertByProperties(String MASP,String LOAI, String TENSP, String DONGIA){
        SQL="INSERT INTO "+Table+" values('"+MASP+"','"+LOAI+"',N'"+TENSP+"','"+DONGIA+"', 0)"; 
        return super.insertBySQLString(SQL);
    }
    
    public ArrayList GetDanhSachSanPham(String MaLoai) throws SQLException{
        ArrayList<BSanPham> arrList = new ArrayList<BSanPham>();
        SQL = "lay_danh_sach_san_pham_theo_loai " + MaLoai;
        ResultSet rs = DB.getData(SQL);
        while(rs.next()){
           BSanPham SanPham = new BSanPham();
           SanPham.MaSP = rs.getString("MASP");
           SanPham.TenSP = rs.getString("TENSP");
           SanPham.DonGia = rs.getInt("DONGIA");
           SanPham.SL = rs.getInt("SL");
           arrList.add(SanPham);
        }
        return arrList;
    }
    
    public boolean editSanPham(String MASP, String TENSP, String DONGIA){
        SQL = "sua_san_pham " + MASP + ", " + TENSP + ", " + DONGIA;
        return super.updateBySQLString(SQL);
    }
    public boolean updateAmountSanPham(String MASP, String SoLuongThem){
        SQL = "them_san_pham " + MASP + ", " + SoLuongThem;
        return super.updateBySQLString(SQL);
    }// 
    public boolean deleteSanPham(String MASP){
        SQL = "xoa_san_pham " + MASP;
        return super.updateBySQLString(SQL);
    }
}
