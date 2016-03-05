/**
 * @author RenYali
 */
package MS;

import java.sql.*;

public class JudgeSecret {
	private String sec = null;
	private boolean ty = false;
	String mysqlDriver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/managersystem?user=root&password=root";// 客户数据库
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public boolean JudgeGP(String signal, String secret) {
		
		try {
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from customer where customer.signal = '"+signal+"'");
			rs.next();
			sec = rs.getString("secret");
			if(sec.equals(secret)){
				ty = true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			System.out.println(e1);
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ty;
	}

	public boolean JudgeIP(String signal, String secret) {
		try {
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from customer where customer.signal = '"+signal+"'");
			rs.next();
			sec = rs.getString("secret");
			if(sec.equals(secret)){
				ty = true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			System.out.println(e1);
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ty;
	}

}
