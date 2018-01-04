/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Data.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author voanh
 */
public class BKhachHang extends Bussiness {
    public BKhachHang(){
        DB= new Data();
        Table="KHACHHANG";
        ID="MAKH";
    }
    public ArrayList<CKhachHang> getAllKhachHang(){
        ArrayList<CKhachHang> arr = new ArrayList();
        ResultSet rs = super.getAll();
        try {
            //ResultSetMetaData metaData = rs.getMetaData();
            //int columns = metaData.getColumnCount();
            while(rs.next()){
                CKhachHang temp = new CKhachHang();
                temp.setHoTen(rs.getString("HOTEN"));
                temp.setMaKH(rs.getString("MAKH"));
                temp.setGioiTinh(rs.getString("GIOITINH"));
                temp.setNgaySinh(rs.getDate("NGAYSINH"));
                temp.setDiaChi(rs.getString("DIACHI"));
                temp.setSdt(rs.getString("SDT"));
                temp.setCmnd(rs.getString("CMND"));
                arr.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean updateByProperties(String MAKH, String TENKH, String DIACHI, String SDT, String CMND){
        SQL="UPDATE KHACHHANG SET "
                +" TENKH = N'"+TENKH+"',"
                +" DIACHI = N'"+DIACHI+"',"
                +" SDT = '"+SDT+"',"
                +" CMND = '"+CMND+"',"
                +" where MAKH = '"+MAKH+"'";
        return super.updateBySQLString(SQL);
    }
    public boolean insertByProperties(String MAKH, String TENKH, String DIACHI, String SDT, String CMND){
        SQL="INSERT INTO KHACHHANG VALUES( "
                +"'"+MAKH+"',"
                +"N'"+TENKH+"',"
                +"N'"+DIACHI+"',"
                +"'"+SDT+"',"
                +"'"+CMND+"')";
        return super.insertBySQLString(SQL);
    }
    public ResultSet searchAll(String s){
        SQL="SELECT *FROM "+Table+" WHERE "
            +" MAKH like '%"+s+"%' or "
            +" TENKH like N'%"+s+"%' or "
            +" DIACHI like N'%"+s+"%' or "
            +" SDT like '%"+s+"%' or "              
            +" CMND like '%"+s+"%'";
        return super.searchAll(SQL);
    }
}
