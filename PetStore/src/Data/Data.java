package Data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author voanh
 */
public class Data {

    private Connection conDB = null; // Tạo kết nối đến CSDL
    private Statement stmDB = null;
    private PreparedStatement pre_stmDB = null; 
    
    private ResultSet rsDB = null; // Result Set trả về kết quả truy vấn
    private CallableStatement cstmDB = null;// Tạo một Callable statement kết 
    // nối đến csdl
    
    // Tên sever name
    private String serverName = "localhost"; //127.0.0.1
    // Số hiệu port
    private String port ="1433";
    // Tên instance
    private String instanceName = "";
    // Tên CSDL
    private String databaseName = "QuanLyCuaHangThuCung";
    // Tên đăng nhập
    private String username = "sa";
    // Mật khẩu
    private String password = "sa";
    // Đường link
    private String url = "";

    public Data() {
    }
    
    // Trả về true nếu tạo kết nối thành công
    public boolean connectDB() {
        boolean res = true;

        try {
            if ((conDB != null) && (!conDB.isClosed()) ) {
                conDB.close();
            }            
            System.out.println("Connecting to database...");
            //String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyDeAn;user=sa;password=sa";
            url = "jdbc:sqlserver://" + serverName
                        + ":"+port
                        + ";databaseName=" + databaseName +";user="+username+";password="+password;
            
            // thử tạo kết nối
            conDB = DriverManager.getConnection(url);
            if (conDB == null) {
                res = false;
            }
            else{
                System.out.println("Kết Nối Thanh Cong");
            }
        } catch (SQLException ex) {
            System.out.println("Ngoại lệ tại classData.connectDB: !" +ex.getMessage());
            res = false;
        }
        finally{        
        }
        return res;
    }
    // Đóng kết nối đến CSDL
    public boolean closeDB() {
        boolean res = true;
        try {
            if (!conDB.isClosed()) {
                conDB.close();
            }
        } catch (Exception ex) {
            res = false;
        }
        System.out.println("Closed database ");
        return res;
    }
    // Thực hiện truy vấn trả về 1 result set
    public ResultSet getData(String _query) {
        ResultSet res = null;
        try {
            if (connectDB()) {
                cstmDB = conDB.prepareCall(_query);
                res = cstmDB.executeQuery();                
            }
        } catch (Exception ex) {
            res = null;
            System.out.println("Ngoại lệ tại classData.getData: "+ex.getMessage());
        } finally {
            //closeDB();
        }

        return res;
    }
    
    
    // Update dữ liệu lên data
    public boolean updateData(String _query) throws SQLException{
        boolean res = true;

        try {
            if (connectDB()) {
                stmDB = conDB.createStatement();
                stmDB.executeUpdate(_query);
            }

        } catch (SQLException ex) {
            res = false;
            System.out.println("Lỗi khi update DB classData: "+ex.getMessage());
        } finally {
            closeDB();
        }

        return res;
    }
}
