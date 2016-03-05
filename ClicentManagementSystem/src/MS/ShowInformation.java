/**
 * @author RenYali
 */
package MS;

import java.sql.*;

public class ShowInformation {
	
	private boolean ty = false;
	String mysqlDriver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/managersystem?user=root&password=root";// 客户数据库
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	private int count;
	private String s = null;
	private String[][]  info;
	
	public String[][] ShowGPL(String signal){
		count = 0;
		s = "select * from "+signal;
		try {
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(s);
			while(rs.next()){
				count ++;
			}
			info = new String[count][5];
			count = 0;
			rs = stmt.executeQuery(s);
			while(rs.next()){
				info[count][0] = rs.getString("name");
				info[count][1] = rs.getString("hp");
				info[count][2] = rs.getString("email");
				info[count][3] = rs.getString("wp");
				info[count][4] = rs.getString("position");
				count ++;
				
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
		
		return info;
	}
	
	public String[][] ShowGP(String signal){
		s = "select * from customer where customer.signal = '"+signal+"'";
		try {
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(s);
			info = new String[1][4];
			rs.next();
			
			info[0][0] = rs.getString("name");
			info[0][1] = rs.getString("hp");
			info[0][2] = rs.getString("email");
			info[0][3] = rs.getString("signal");
				
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
		
		return info;
		
	}
	
	public String[][] ShowIP(String signal){
		s = "select * from customer where customer.signal = '"+signal+"'";
		try {
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(s);
			info = new String[1][4];
			rs.next();
			
				info[0][0] = rs.getString("name");
				info[0][1] = rs.getString("hp");
				info[0][2] = rs.getString("email");
				info[0][3] = rs.getString("signal");
				
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
		return info;
	}
	
	public String[][] ShowSGPL(String signal,String name){
		s = "select * from "+signal+" where "+signal+".name = '"+name+"'";
		try {
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(s);
			info = new String[1][5];
			rs.next();
			
				info[0][0] = rs.getString("name");
				info[0][1] = rs.getString("hp");
				info[0][2] = rs.getString("email");
				info[0][3] = rs.getString("wp");
				info[0][4] = rs.getString("position");
				
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
		return info;
	}
}
