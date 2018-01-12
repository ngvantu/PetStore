/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;
import Data.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author voanh
 */
public class BNhanVien extends Bussiness{
    public BNhanVien(){
        DB= new Data();
        Table="NHANVIEN";
        ID="MANV";
    }
    
    public ArrayList<CNhanVien> getAllNhanVien(){
        ArrayList<CNhanVien> arr = new ArrayList();
        ResultSet rs = super.getAll();
        try {
            //ResultSetMetaData metaData = rs.getMetaData();
            //int columns = metaData.getColumnCount();
            while(rs.next()){
                CNhanVien temp = new CNhanVien();
                temp.setHoTen(rs.getString("HOTEN"));
                temp.setMaNV(rs.getString("MANV"));
                temp.setGioiTinh(rs.getString("GIOITINH"));
                temp.setNgaySinh(rs.getDate("NGAYSINH"));
                temp.setDiaChi(rs.getString("DIACHI"));
                temp.setSdt(rs.getString("SDT"));
                temp.setChucVu(rs.getString("CHUCVU"));
                temp.setLuong(rs.getInt("LUONG"));
                temp.setCmnd(rs.getString("CMND"));
                arr.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    
    public ArrayList<CNhanVienMoRong> getAllNhanVienMoRong(){
        ArrayList<CNhanVienMoRong> arr = new ArrayList();
        SQL = "getExtendedNhanVien";
        ResultSet rs = DB.getData(SQL);
        try {
            //ResultSetMetaData metaData = rs.getMetaData();
            //int columns = metaData.getColumnCount();
            while(rs.next()){
                CNhanVienMoRong temp = new CNhanVienMoRong();
                temp.setHoTen(rs.getNString("HOTEN"));
                temp.setMaNV(rs.getString("MANV"));
                temp.setGioiTinh(rs.getNString("GIOITINH"));
                temp.setNgaySinh(rs.getDate("NGAYSINH"));
                temp.setDiaChi(rs.getNString("DIACHI"));
                temp.setSdt(rs.getString("SDT"));
                temp.setChucVu(rs.getString("CHUCVU"));
                temp.setLuong(rs.getInt("LUONG"));
                temp.setCmnd(rs.getString("CMND"));
                temp.setTenTK(rs.getString("TENTK"));
                temp.setMatKhau(rs.getString("MATKHAU"));
                arr.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public ArrayList<CNhanVienMoRong> getAllNhanVienMoRongByHoTen(String s){
        ArrayList<CNhanVienMoRong> arr = new ArrayList();
        SQL = "TimKiemNhanVienTheoHoTen "+" N'"+s+"'";
        ResultSet rs = DB.getData(SQL);
        try {
            //ResultSetMetaData metaData = rs.getMetaData();
            //int columns = metaData.getColumnCount();
            while(rs.next()){
                CNhanVienMoRong temp = new CNhanVienMoRong();
                temp.setHoTen(rs.getNString("HOTEN"));
                temp.setMaNV(rs.getString("MANV"));
                temp.setGioiTinh(rs.getNString("GIOITINH"));
                temp.setNgaySinh(rs.getDate("NGAYSINH"));
                temp.setDiaChi(rs.getNString("DIACHI"));
                temp.setSdt(rs.getString("SDT"));
                temp.setChucVu(rs.getString("CHUCVU"));
                temp.setLuong(rs.getInt("LUONG"));
                temp.setCmnd(rs.getString("CMND"));
                temp.setTenTK(rs.getString("TENTK"));
                temp.setMatKhau(rs.getString("MATKHAU"));
                arr.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    public ArrayList<CNhanVienMoRong> getAllNhanVienMoRongByMANV(String s){
        ArrayList<CNhanVienMoRong> arr = new ArrayList();
        SQL = "TimKiemNhanVienTheoMaNV "+" N'"+s+"'";
        ResultSet rs = DB.getData(SQL);
        try {
            //ResultSetMetaData metaData = rs.getMetaData();
            //int columns = metaData.getColumnCount();
            while(rs.next()){
                CNhanVienMoRong temp = new CNhanVienMoRong();
                temp.setHoTen(rs.getNString("HOTEN"));
                temp.setMaNV(rs.getString("MANV"));
                temp.setGioiTinh(rs.getNString("GIOITINH"));
                temp.setNgaySinh(rs.getDate("NGAYSINH"));
                temp.setDiaChi(rs.getNString("DIACHI"));
                temp.setSdt(rs.getString("SDT"));
                temp.setChucVu(rs.getString("CHUCVU"));
                temp.setLuong(rs.getInt("LUONG"));
                temp.setCmnd(rs.getString("CMND"));
                temp.setTenTK(rs.getString("TENTK"));
                temp.setMatKhau(rs.getString("MATKHAU"));
                arr.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public ArrayList<CNhanVienMoRong> getAllNhanVienMoRongByCMND(String s){
        ArrayList<CNhanVienMoRong> arr = new ArrayList();
        SQL = "TimKiemNhanVienTheoCMND "+" N'"+s+"'";
        ResultSet rs = DB.getData(SQL);
        try {
            //ResultSetMetaData metaData = rs.getMetaData();
            //int columns = metaData.getColumnCount();
            while(rs.next()){
                CNhanVienMoRong temp = new CNhanVienMoRong();
                temp.setHoTen(rs.getNString("HOTEN"));
                temp.setMaNV(rs.getString("MANV"));
                temp.setGioiTinh(rs.getNString("GIOITINH"));
                temp.setNgaySinh(rs.getDate("NGAYSINH"));
                temp.setDiaChi(rs.getNString("DIACHI"));
                temp.setSdt(rs.getString("SDT"));
                temp.setChucVu(rs.getString("CHUCVU"));
                temp.setLuong(rs.getInt("LUONG"));
                temp.setCmnd(rs.getString("CMND"));
                temp.setTenTK(rs.getString("TENTK"));
                temp.setMatKhau(rs.getString("MATKHAU"));
                arr.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public ArrayList<CNhanVienMoRong> getAllNhanVienMoRongByTenTk (String s){
        ArrayList<CNhanVienMoRong> arr = new ArrayList();
        SQL = "TimKiemNhanVienTheoTenTK "+"'"+s+"'";
        ResultSet rs = DB.getData(SQL);
        try {
            //ResultSetMetaData metaData = rs.getMetaData();
            //int columns = metaData.getColumnCount();
            while(rs.next()){
                CNhanVienMoRong temp = new CNhanVienMoRong();
                temp.setHoTen(rs.getNString("HOTEN"));
                temp.setMaNV(rs.getString("MANV"));
                temp.setGioiTinh(rs.getNString("GIOITINH"));
                temp.setNgaySinh(rs.getDate("NGAYSINH"));
                temp.setDiaChi(rs.getNString("DIACHI"));
                temp.setSdt(rs.getString("SDT"));
                temp.setChucVu(rs.getString("CHUCVU"));
                temp.setLuong(rs.getInt("LUONG"));
                temp.setCmnd(rs.getString("CMND"));
                temp.setTenTK(rs.getString("TENTK"));
                temp.setMatKhau(rs.getString("MATKHAU"));
                arr.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public boolean Insert(CNhanVien c){
        String dateString;
        SimpleDateFormat sdfr = new SimpleDateFormat("MM/dd/yyyy");
        dateString = sdfr.format( c.getNgaySinh() );
        SQL = String.format("insertNhanVien '%s', N'%s', N'%s', '%s', N'%s', '%s', '%s','%s','%s' ",c.getMaNV(),
                c.getHoTen(), c.getGioiTinh(), dateString,c.getDiaChi(),c.getSdt(),c.getChucVu(),
                Integer.toString(c.getLuong()), c.getCmnd());
        return super.updateBySQLString(SQL);
    }
    
    public boolean updateByProperties(CNhanVien c){
        String dateString;
        SimpleDateFormat sdfr = new SimpleDateFormat("MM/dd/yyyy");
        dateString = sdfr.format( c.getNgaySinh() );
        SQL = String.format("updateUserInfo '%s', N'%s', N'%s', '%s', N'%s', '%s', '%s'",c.getMaNV(),
                c.getHoTen(), c.getGioiTinh(), dateString,c.getDiaChi(),c.getSdt(), c.getCmnd());
        return super.updateBySQLString(SQL);
    }
    
    
    public boolean updateByProperties(String MANV, String HOTEN, String GIOITINH,
            String NGAYSINH,String DIACHI, String SDT,String CHUCVU, String LUONG, String CMND){
        SQL="UPDATE ThanhVien SET "
                +" HOTEN = N'"+HOTEN+"',"
                +" GIOITINH = N'"+GIOITINH+"',"
                +" NGAYSINH = '"+NGAYSINH+"',"
                +" DIACHI = N'"+DIACHI+"',"
                +" SDT = '"+SDT+"',"
                +" CHUCVU = '"+CHUCVU+"',"
                +" LUONG = N'"+LUONG+"'"
                +" CMND = '"+CMND+"',"
                +" where MANV = '"+MANV+"'";
        return super.updateBySQLString(SQL);
    }
    public boolean insertByProperties(String MANV, String HOTEN, String GIOITINH,
            String NGAYSINH,String DIACHI, String SDT,String CHUCVU, String LUONG, String CMND){
        SQL="INSERT INTO NHANVIEN VALUES( "
                +"'"+MANV+"',"
                +"N'"+HOTEN+"',"
                +"N'"+GIOITINH+"',"
                +"N'"+NGAYSINH+"',"
                +"N'"+DIACHI+"',"
                +"N'"+SDT+"',"
                +"'"+CHUCVU+"',"
                +"'"+LUONG+"',"
                +"N'"+CMND+"')";
        return super.insertBySQLString(SQL);
    }
    public ResultSet searchAll(String s){
        SQL="SELECT *FROM "+Table+" WHERE "
            +" MANV like N'%"+s+"%' or "
            +" HOTEN like N'%"+s+"%' or "
            +" GIOITINH like N'%"+s+"%' or "
            +" NGAYSINH like N'%"+s+"%' or "
            +" DIACHI like N'%"+s+"%' or "
            +" SDT like '%"+s+"%' or "
            +" CHUCVU like N'%"+s+"%' or "                
            +" CMND like N'%"+s+"%'";
        return super.searchAll(SQL);
    }
    public boolean deleteByID(String id){
        BTaiKhoan TKTV = new BTaiKhoan();
        if( TKTV.deleteByID(id)){
            return super.deleteByID(id);
        }
        return false;
    }
    
    public int getChucVu(String id) throws SQLException{
        String res = "";
        int ans = 0;
        SQL = "tim_nhan_vien_theo_manv "+id;
        ResultSet rs = DB.getData(SQL);
        while(rs.next()){
            String ma_nv;
            ma_nv = rs.getString("MANV");
            if(ma_nv.equals(id)){
                res = rs.getString("CHUCVU");
                if(res.equals("CHCH"))
                    ans = 1; 
                else if(res.equals("NVBH"))
                    ans = 2;
                else if(res.equals("NVKH"))
                    ans = 3;
                break;
            }
        }
        return ans;
    } 
    
    public CNhanVien getNhanVien(String manv) throws SQLException{
        SQL = "findNhanVienByMANV '"+manv+"'";
        ResultSet rs = DB.getData(SQL);
        while(rs.next()){
            String ma_nv;
            ma_nv = rs.getString("MANV");
            if(ma_nv.equals(manv)){
                return new CNhanVien(ma_nv, rs.getString("HOTEN"), rs.getString("GIOITINH"),
                        rs.getDate("NGAYSINH"), rs.getString("DIACHI"), rs.getString("SDT"), rs.getString("CHUCVU"),
                        rs.getInt("LUONG"), rs.getString("CMND"));
            }
        }
        return null;
    }
}
