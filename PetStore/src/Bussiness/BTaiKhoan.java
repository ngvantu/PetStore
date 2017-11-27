/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Data.Data;

/**
 *
 * @author voanh
 */
public class BTaiKhoan extends Bussiness{

    public BTaiKhoan() {
        DB = new Data();
        Table = "TAIKHOAN";
        ID = "MANV";
    }
    
    public boolean updateByProperties(String MANV, String TENTK, String MATKHAU){
        SQL="UPDATE "+Table+" SET "
                +" TENTK = '"+TENTK+"'"
                +" MATKHAU = '"+MATKHAU+"'"
                +" WHERE MANV = '"+MANV+"'";
        return super.updateBySQLString(SQL);
    }
    public boolean insertByProperties(String MANV, String TENTK, String MATKHAU){
        SQL="INSERT INTO "+Table+" values('"+MANV+"','"+TENTK+"',N'"+MATKHAU+"')";
        return super.insertBySQLString(SQL);
    }
}
