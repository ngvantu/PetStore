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
public class BSanPham extends Bussiness {
    public BSanPham() {
        DB = new Data();
        Table = "SANPHAM";
        ID = "MASP";
    }
    public boolean updateByProperties(String MASP,String LOAI, String TENSP, String DONGIA){
        SQL="UPDATE "+Table+" SET "
                +" LOAI = '"+LOAI+"'"
                +" TENSP = N'"+TENSP +"'"
                +" DONGIA = '"+DONGIA+"'"
                +" WHERE MASP = '"+MASP+"'";
        return super.updateBySQLString(SQL);
    }
    public boolean insertByProperties(String MASP,String LOAI, String TENSP, String DONGIA){
        SQL="INSERT INTO "+Table+" values('"+MASP+"','"+LOAI+"',N'"+TENSP+"','"+DONGIA+"')";
        return super.insertBySQLString(SQL);
    }
}
