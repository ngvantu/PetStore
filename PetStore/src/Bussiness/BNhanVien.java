/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;
import Data.*;
import java.sql.ResultSet;

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
}
