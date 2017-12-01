/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;
import Bussiness.*;
import Data.*;
import JFrameMain.*;
import java.awt.EventQueue;
import ChuCuaHang.*;
import NhanVienBanHang.JNhanVienBanHang;
import NhanVienKho.JNhanVienKho;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author voanh
 */
public class PetStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //       Data d = new Data();
//       d.connectDB();
//       d.closeDB();
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                JChuCuaHang a = new JChuCuaHang();
                a.setVisible(true);


//jFMain main = new jFMain();
//jFChangeInformation b = new jFChangeInformation();
// TODO code application logic here

/// Testing

/*
BLoai b = new BLoai();
b.insertByProperties("DOG", "Chó");




BChucVu cv = new BChucVu();        
cv.insertByProperties("QL", "Quản Lý");
cv.insertByProperties("NV", "Nhân Viên");



BKhuyenMai km = new BKhuyenMai();
km.insertByProperties("11/12","10000", "12/11/2017", "12/12/2017");



BKhachHang kh = new BKhachHang();        
kh.insertByProperties("KH001", "Võ Văn Chuối", "Cầu Sài Gòn", "0190893784", "0123456789");



BSanPham sp = new BSanPham();
sp.insertByProperties("SP001", "DOG", "Cám", "1234");



BChiTietLoai ctl = new BChiTietLoai();
ctl.insertByProperties("Husky", "DOG", "Chó Husky", "Chó Chảnh :v");



BThuCung tc = new BThuCung();
tc.insertByProperties("TC001", "Husky", "123456");



BNhanVien nv = new BNhanVien();
nv.insertByProperties("NV001", "Võ Anh Tuấn", "Nam", "12/11/1997", "Củ Chi", "01672038391", "QL", "1111110", "12324234");



BTaiKhoan tk = new BTaiKhoan();
tk.insertByProperties("NV001", "anhyeuem", "emyeunguoikhacroi");



BHoaDon hd = new BHoaDon();
hd.insertByProperties("HD001", "1/1/2010", "NV001", "KH001", "11/12");
*/

//BCTHoaDonSanPham hdsp = new BCTHoaDonSanPham();
//BCTHoaDonThuCung hdtc = new BCTHoaDonThuCung();
//hdsp.insertByProperties("HD001", "1", "SP001", "1", "200");
//hdtc.insertByProperties("HD001", "1", "TC001", "1", "1234");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PetStore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(PetStore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PetStore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PetStore.class.getName()).log(Level.SEVERE, null, ex);
        }
 

    }
}