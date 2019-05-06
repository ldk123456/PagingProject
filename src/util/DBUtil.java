package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    /**
     * 1.初始化常量 url：连接的数据库的路径，username：数据库用户账户，password：数据库用户密码
     */
    private static String username = "root";
    private static String password = "123456";
    private static String url = "jdbc:mysql://localhost:3306/student";

    /**
     * 2.连接数据库的方法
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() {
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 3.关闭数据库连接的方法
     *
     * @param st
     * @param rs
     * @param conn
     * @throws SQLException
     */
    public static void close(Statement st, ResultSet rs, Connection conn) {
        // 若不为空则关闭，不关闭会造成内存垃圾，浪费等，也会引起异常
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
