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
    public boolean updateByProperties(CKhachHang c){
        String dateString;
        SimpleDateFormat sdfr = new SimpleDateFormat("MM/dd/yyyy");
        dateString = sdfr.format( c.getNgaySinh() );
        SQL = String.format("updateKhachHangInfo '%s', N'%s', N'%s', '%s', N'%s', '%s', '%s'" ,c.getMaKH(),
                c.getHoTen(), c.getGioiTinh(), dateString,c.getDiaChi(),c.getSdt(), c.getCmnd());
        return super.updateBySQLString(SQL);
    }
    
    public boolean insertKhachHang(CKhachHang c){
        String dateString;
        SimpleDateFormat sdfr = new SimpleDateFormat("MM/dd/yyyy");
        dateString = sdfr.format( c.getNgaySinh() );
        SQL = String.format("insertKhachHang '%s', N'%s', N'%s', '%s', N'%s', '%s', '%s'" ,c.getMaKH(),
                c.getHoTen(), c.getGioiTinh(), dateString,c.getDiaChi(),c.getSdt(), c.getCmnd());
        return super.updateBySQLString(SQL);
    }
    
    public boolean Check(String S){
        SQL = String.format("checkKhachHangExist '%s'",S);
        ResultSet rs = DB.getData(SQL);
        try {
            while(rs.next()){
                int temp = rs.getInt("Result");
                if(temp==1){
                    return true;
                }
                else
                    return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean Delete(String s){
        SQL = String.format("deleteKhachHang '%s'", s);
        return super.updateBySQLString(SQL);
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
    
    public String getTenKhachHang(String MaKH) throws SQLException{
        SQL = "TimKhachHangbyMaKH "+MaKH;
        ResultSet rs = DB.getData(SQL);
        while(rs.next()){
            String TenKH = "";
            TenKH = rs.getString("HOTEN");
            return TenKH;
        }
        return "";
    }
}
