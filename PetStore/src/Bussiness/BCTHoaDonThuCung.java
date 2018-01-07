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
public class BCTHoaDonThuCung extends Bussiness {
    static String ID2 = "STT";
    public BCTHoaDonThuCung() {
        DB = new Data();
        Table = "CTHOADONTHUCUNG";
        ID = "MAHD";
    }
    public boolean updateByProperties(String MAHD,String STT, String MATC, String SOLUONG, String DONGIA){
        SQL="UPDATE "+Table+" SET "
                +" MATC = '"+MATC+"'"
                +" SOLUONG = '"+SOLUONG+"'"
                +" DONGIA = '"+DONGIA+"'"
                +" WHERE MAHD = '"+MAHD+"'" + " and STT = '"+STT+"'";
        return super.updateBySQLString(SQL);
    }
    public boolean insertByProperties(String MAHD,String STT, String MATC, String SOLUONG, String DONGIA){
        SQL="INSERT INTO "+Table+" values('"+MAHD+"','"+STT+"','"+MATC+"','"+SOLUONG+"','"+DONGIA+"')";
        return super.insertBySQLString(SQL);
    }
    
    public ArrayList<CCTHDThuCung> getCTHDTC(String maHD) throws SQLException{
        ArrayList<CCTHDThuCung> arrList = new ArrayList<CCTHDThuCung>();
        SQL = "getCTHDTC " + maHD;
        ResultSet rs = DB.getData(SQL);
        while (rs.next()){
            CCTHDThuCung temp = new CCTHDThuCung();
            temp.maHD = rs.getString("MAHD");
            temp.STT = rs.getString("STT");
            temp.maTC = rs.getString("MATC");
            temp.soLuong = rs.getInt("SOLUONG");
            temp.donGia = rs.getInt("DONGIA");
            arrList.add(temp);
        }
        return arrList;
    }
}
