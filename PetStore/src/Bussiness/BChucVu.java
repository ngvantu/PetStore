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
public class BChucVu extends Bussiness {
    public BChucVu() {
        DB = new Data();
        Table = "CHUCVU";
        ID = "MACV";
    }
    public boolean updateByProperties(String MACV,String DIENGIAI){
        SQL="UPDATE "+Table+" SET "
                +" DIENGIAI = N'"+DIENGIAI+"'"
                +" WHERE MACV = '"+MACV+"'";
        return super.updateBySQLString(SQL);
    }
    public boolean insertByProperties(String MACV,String DIENGIAI){
        SQL="INSERT INTO "+Table+" values('"+MACV+"',N'"+DIENGIAI+"')";
        return super.insertBySQLString(SQL);
    }
}
