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
public class BCTHoaDonSanPham extends Bussiness{
    static String ID2 = "STT";
    public BCTHoaDonSanPham() {
        DB = new Data();
        Table = "CTHOADONSANPHAM";
        ID = "MAHD";
    }
    public boolean updateByProperties(String MAHD,String STT, String MASP, String SOLUONG, String DONGIA){
        SQL="UPDATE "+Table+" SET "
                +" MASP = '"+MASP+"'"
                +" SOLUONG = '"+SOLUONG+"'"
                +" DONGIA = '"+DONGIA+"'"
                +" WHERE MAHD = '"+MAHD+"'" + " and STT = '"+STT+"'";
        return super.updateBySQLString(SQL);
    }
    public boolean insertByProperties(String MAHD,String STT, String MASP, String SOLUONG, String DONGIA){
        SQL="INSERT INTO "+Table+" values('"+MAHD+"','"+STT+"','"+MASP+"','"+SOLUONG+"','"+DONGIA+"')";
        return super.insertBySQLString(SQL);
    }
    
    
    public ArrayList<CCTHDSanPham> getCTHDSP(String maHD)throws SQLException{
        ArrayList<CCTHDSanPham> arrList = new ArrayList<CCTHDSanPham>();
        SQL = "getCTHDSP " + maHD;
        ResultSet rs = DB.getData(SQL);
        while (rs.next()){
            CCTHDSanPham temp = new CCTHDSanPham();
            temp.maHD = rs.getString("MAHD");
            temp.STT = rs.getString("STT");
            temp.maSP = rs.getString("MASP");
            temp.soLuong = rs.getInt("SOLUONG");
            temp.donGia = rs.getInt("DONGIA");
            arrList.add(temp);
        }
        return arrList;
    }
}
