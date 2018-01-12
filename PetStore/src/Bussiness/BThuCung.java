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
public class BThuCung extends Bussiness {
    public String MaThuCung;
    public int DonGia;

    public BThuCung() {
        DB = new Data();
        Table = "THUCUNG";
        ID = "MATC";
    }
    public boolean updateByProperties(String MATC, String MAGIONG, String DONGIA){
        SQL="UPDATE "+Table+" SET "
                +" MAGIONG = '"+MAGIONG+"',"
                +" DONGIA = '"+DONGIA+"'"
                +" WHERE MATC = '"+MATC+"'";
        return super.updateBySQLString(SQL);
    }
    public boolean insertByProperties(String MATC, String MAGIONG, String DONGIA){
        SQL="INSERT INTO " + Table + " values('"+MATC+"','"+MAGIONG+"','"+DONGIA+"')";
        return super.insertBySQLString(SQL);
    }
    public ArrayList GetDanhSachLoaiThuCung(String MaGiong) throws SQLException{
        ArrayList<BThuCung> arrList = new ArrayList<BThuCung>();
        SQL = "lay_danh_sach_vat_nuoi_theo_ma_giong " + MaGiong;
        ResultSet rs = DB.getData(SQL);
        while(rs.next()){
           BThuCung ThuCung = new BThuCung();
            ThuCung.MaThuCung = rs.getString("MATC");
            ThuCung.DonGia = rs.getInt("DONGIA");
            arrList.add(ThuCung);
        }
        return arrList;
    }
    public boolean editThuCung(String MATC, String DONGIA){
        SQL = "sua_thu_cung " + MATC + ", " + DONGIA;
        return super.updateBySQLString(SQL);
    }
    public boolean deleteThuCung(String MATC){
        SQL = "xoa_thu_cung " + MATC;
        return super.updateBySQLString(SQL);
    }
    
    
}
