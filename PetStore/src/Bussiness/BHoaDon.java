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
public class BHoaDon extends Bussiness {
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
}
