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
public class BChiTietLoai extends Bussiness{
    public BChiTietLoai() {
        DB = new Data();
        Table = "CHITIETLOAI";
        ID = "MAGIONG";
    }
    public boolean updateByProperties(String MAGIONG,String MALOAI, String TENGIONG,String MOTA){
        SQL="UPDATE "+Table+" SET "
                +" MALOAI = '"+MALOAI+"'"
                +" TENGIONG = N'"+TENGIONG+"'"
                +" MOTA = N'"+MOTA+"'"
                +" WHERE MAGIONG = '"+MAGIONG+"'";
        return super.updateBySQLString(SQL);
    }
    public boolean insertByProperties(String MAGIONG,String MALOAI, String TENGIONG,String MOTA){
        SQL="INSERT INTO "+Table+" values('"+MAGIONG+"','"+MALOAI+"',N'"+TENGIONG+"',N'"+MOTA+"')";
        return super.insertBySQLString(SQL);
    }
}
