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
public class BThuCung extends Bussiness {
    public BThuCung() {
        DB = new Data();
        Table = "THUCUNG";
        ID = "MATC";
    }
    public boolean updateByProperties(String MATC, String MAGIONG, String DONGIA){
        SQL="UPDATE "+Table+" SET "
                +" MAGIONG = '"+MAGIONG+"'"
                +" DONGIA = '"+DONGIA+"'"
                +" WHERE MATC = '"+MATC+"'";
        return super.updateBySQLString(SQL);
    }
    public boolean insertByProperties(String MATC, String MAGIONG, String DONGIA){
        SQL="INSERT INTO "+Table+" values('"+MATC+"','"+MAGIONG+"','"+DONGIA+"')";
        return super.insertBySQLString(SQL);
    }
}
