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
public class BKhuyenMai extends Bussiness{
    public BKhuyenMai() {
        DB = new Data();
        Table = "KHUYENMAI";
        ID = "MAKM";
    }
    public boolean updateByProperties(String MAKM,String GIATRIKM, String NGAYBD, String NGAYKT){
        SQL="UPDATE "+Table+" SET "
                +" GIATRIKM = '"+GIATRIKM+"'"
                +" NGAYBD = '"+NGAYBD+"'"
                +" NGAYKT = '"+NGAYKT+"'"
                +" WHERE MAKM = '"+MAKM+"'";
        return super.updateBySQLString(SQL);
    }
    public boolean insertByProperties(String MAKM,String GIATRIKM, String NGAYBD, String NGAYKT){
        SQL="INSERT INTO "+Table+" values('"+MAKM+"','"+GIATRIKM+"','"+NGAYBD+"','"+NGAYKT+"')";
        return super.insertBySQLString(SQL);
    }
}
