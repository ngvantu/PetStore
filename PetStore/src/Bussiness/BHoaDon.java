/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Data.Data;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author voanh
 */
public class BHoaDon extends Bussiness {
    public String MAHD;
    public String NguoiLapHD;
    public String NgayLap;
    public String MaKH;
    public String Tong;
    public String MaKM;
    public BHoaDon() {
        DB = new Data();
        Table = "HOADON";
        ID = "MAHD";
    }
    public boolean updateByProperties(String MAHD,String NGAYLAP, String NGUOILAPHD, String MAKH, String MAKM){
        SQL="UPDATE "+Table+" SET "
                +" NGAYLAP = '"+NGAYLAP+"'"
                +" NGUOILAPHD = '"+NGUOILAPHD+"'"
                +" MAKH = '"+MAKH+"'"
                +" MAKM = '"+MAKM+"'"
                +" WHERE MAHD = '"+MAHD+"'";
        return super.updateBySQLString(SQL);
    }
    public boolean insertByProperties(String MAHD,String NGAYLAP, String NGUOILAPHD, String MAKH, String MAKM){
        SQL="INSERT INTO "+Table+" values('"+MAHD+"','"+NGAYLAP+"','"+NGUOILAPHD+"','"+MAKH+"','"+MAKM+"')";
        return super.insertBySQLString(SQL);
    }
    
    public ArrayList<CHoaDon> getAllHoaDon() throws SQLException{
        ArrayList<CHoaDon> arrList = new ArrayList<CHoaDon>();
        SQL = "getAllHoaDon";
        ResultSet rs = DB.getData(SQL);
        while(rs.next()){
            CHoaDon temp = new CHoaDon();
            temp.setMaHD(rs.getString("MAHD"));
            temp.setNgayLap(rs.getDate("NGAYLAP"));
            temp.setNguoiLapHD(rs.getString("NGUOILAPHD"));
            temp.setMaKH(rs.getString("MAKH"));
            temp.setMaKM(rs.getString("MAKM"));
            arrList.add(temp);
        }
        return arrList;
    }
    
    public ArrayList<CHoaDon> getHoaDon(String NgayBD, String NgayKT) throws SQLException{
        ArrayList<CHoaDon> arrList = new ArrayList<CHoaDon>();
        SQL = "getHoaDon " + NgayBD + " " + NgayKT;
        ResultSet rs = DB.getData(SQL);
        while(rs.next()){
            CHoaDon temp = new CHoaDon();
            temp.setMaHD(rs.getString("MAHD"));
            temp.setNgayLap(rs.getDate("NGAYLAP"));
            temp.setNguoiLapHD(rs.getString("NGUOILAPHD"));
            temp.setMaKH(rs.getString("MAKH"));
            temp.setMaKM(rs.getString("MAKM"));
            arrList.add(temp);
        }
        return arrList;
    }
    
    public int getTongTienHDSP(String maHD) throws SQLException{
        SQL = "getTongTienHDSP " + maHD;
        ResultSet rs = DB.getData(SQL);
        int temp = 0;
        if (rs.next())
            temp = rs.getInt("TONG");
        return temp;
    }   
    public int getTongTienHDTC(String maHD) throws SQLException{
        SQL = "getTongTienHDTC " + maHD;
        ResultSet rs = DB.getData(SQL);
        int temp = 0;
        if (rs.next())
            temp = rs.getInt("TONG");
        return temp;
    }
     public ArrayList<BHoaDon> XuatHoaDonTheoNgayThangNam(String NgayBD, String NgayKT) throws SQLException{
        ArrayList<BHoaDon> arrList = new ArrayList<BHoaDon>();
         SQL = "XuatHoaDon " + "'" + NgayBD + "', '" + NgayKT + "'";
        ResultSet rs = DB.getData(SQL);
        while (rs.next()){
            BHoaDon temp = new BHoaDon();
            temp.MAHD=(rs.getString("MAHD"));
            temp.NgayLap=Integer.toString((rs.getDate("NGAYLAP")).getDate())+"-"+Integer.toString((rs.getDate("NGAYLAP")).getMonth()+1)+"-"+Integer.toString((rs.getDate("NGAYLAP")).getYear()+1900);
            temp.MaKM = (rs.getString("MAKM"));
            temp.MaKH = (rs.getString("MAKH"));
            temp.NguoiLapHD=(rs.getString("NGUOILAPHD"));
            temp.Tong = (rs.getString("TONG"));
            arrList.add(temp);
        }
        return arrList;
    }
}
