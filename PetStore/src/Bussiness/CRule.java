/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author voanh
 */
public class CRule {
    public static boolean checkHoTen(String hoten){
        Pattern p = Pattern.compile("[\\\\!\"#$%&()*+,./:;-<=>?@\\[\\]^_{|}~]+", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(hoten);
        boolean b = m.find();
        return !b;
    }
    public static boolean checkSDT(String sdt){
        Pattern p = Pattern.compile("[^0-9]+", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(sdt);
        boolean b = m.find();
        return !b && sdt.length()>=10;
    }
    
    public static boolean checkCMND(String cmnd){
        Pattern p = Pattern.compile("[^0-9]+", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(cmnd);
        boolean b = m.find();
        return !b && cmnd.length()>0;
    }
}
