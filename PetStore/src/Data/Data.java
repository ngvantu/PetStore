/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author voanh
 */
public class Data {

    private Connection conDB = null;
    private Statement stmDB = null;
    private ResultSet rsDB = null;
    private CallableStatement cstmDB = null;
    
    private String serverName = "localhost"; //127.0.0.1
    private String port ="1433";
    private String instanceName = "";
    private String databaseName = "QuanLyCuaHangThuCung";
    private String username = "sa";
    private String password = "sa";
    private String url = "";
    private int sourceType = 0;
    public Data() {
    }
    
    public Data(int _sourceType) {
        sourceType = _sourceType;
    }
    
    public boolean connectDB() {
        boolean res = true;

        try {
            if ((conDB != null) && (!conDB.isClosed()) ) {
                conDB.close();
            }            
            System.out.println("Connecting to database...");
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               
            //instanceName = "MSSQLServer";
            url = "jdbc:sqlserver://" + serverName
                        + ":"+port
                        + ";databaseName=" + databaseName +";user="+username+";password="+password;
            //String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyDeAn;user=sa;password=sa";
            conDB = DriverManager.getConnection(url);
            if (conDB == null) {
                res = false;
            }
            else{
                System.out.println("Thanh Cong");
            }
        } catch (SQLException ex) {
            System.out.println("Ngoại lệ tại classData.connectDB: !" +ex.getMessage());
            res = false;
        }
        finally{        
        }
        return res;
    }
    
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
    
    public boolean closeDB() {
        boolean res = true;
        try {
            if (!conDB.isClosed()) {
                conDB.close();
            }
        } catch (Exception ex) {
            res = false;
        }
        System.out.println("Closed database");
        return res;
    }
    public boolean updateData(String _query) throws SQLException{
        boolean res = true;

        try {
            if (connectDB()) {
                stmDB = conDB.createStatement();
                stmDB.executeUpdate(_query);
            }

        } catch (Exception ex) {
            res = false;
            System.out.println("Lỗi khi update DB classData: "+ex.getMessage());
        } finally {
            closeDB();
        }

        return res;
    }
}
