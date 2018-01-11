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
public class BLoai extends Bussiness{
    public String MaLoai;
    public String TenLoai;
    
    public BLoai() {
        DB = new Data();
        Table = "LOAI";
        ID = "MALOAI";
    }
    public boolean updateByProperties(String MALOAI, String TENLOAI){
        SQL="UPDATE "+Table+" SET "
                +" TENLOAI = N'"+TENLOAI+"'"
                +" WHERE MALOAI = '"+MALOAI+"'";
        return super.updateBySQLString(SQL);
    }
    public boolean insertByProperties(String MALOAI, String TENLOAI){
        SQL="INSERT INTO "+Table+" values('"+MALOAI+"',N'"+TENLOAI+"')";
        return super.insertBySQLString(SQL);
    }
    
    public ArrayList<BLoai> GetDanhSachLoaiVatNuoi() throws SQLException{
        ArrayList<BLoai> arrList = new ArrayList<BLoai>();
        SQL = "lay_danh_sach_vat_nuoi";
        ResultSet rs = DB.getData(SQL);
        while(rs.next()){
            BLoai Loai = new BLoai();
            Loai.MaLoai = rs.getString("MALOAI");
            Loai.TenLoai = rs.getString("TENLOAI");
            arrList.add(Loai);
        }
        return arrList;
    }
}
