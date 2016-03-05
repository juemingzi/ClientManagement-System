/**
 * @author RenYali
 */
package MS;

import java.sql.*;

public class ConnectDB {

	String mysqlDriver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/managersystem?user=root&password=root";// 客户数据库
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	boolean ty = false;
	String s = null;
	//private CreatTable cta = new CreatTable();

	// 添加集团客户联系人
	public boolean addGPL(String name, String home_phone, String email,///////////////////////////正确
			String work_phone, String position, String signal) {
		try {
			
			System.out.println("name:"+ name );//+ home_phone + email + work_phone + position + signal);
			
			
			s = "INSERT INTO " + signal + " VALUES('" + name + "','"
					+ home_phone + "','" + email + "','" + work_phone + "','"
					+ position + "');";
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			ty = stmt.execute(s);
			ty = !ty;
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

	// 删除几天客户联系人
	public boolean deleteGPL(String name, String signal) {/////////////////////////正确
		try {
			s = "DELETE FROM " + signal + " WHERE "+signal+".name='" + name + "'";
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			ty = stmt.execute(s);
			ty = !ty;
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

	// 删除所有相同signal的集团客户联系人
	public boolean deleteGPL(String signal) {/////////////////////////////正确
		try {
			s = "drop table " + signal;
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			ty = stmt.execute(s);
			ty = !ty;
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
		System.out.println("输出ty            =  " + ty);		
		
		
		
		return ty;
	}

	// 添加集团客户
	public boolean addGP(String name, String secret, String home_phone,
			String email, String signal) {// ///////////////////////////////////////////////////////////正确
		int count = 0;
		try {
			s = "INSERT INTO customer VALUES('" + name + "','" + secret + "','"
					+ home_phone + "','" + email + "','" + signal + "');";
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			ty = stmt.execute(s);
			ty = !ty;
		} catch (ClassNotFoundException e) {
			System.out.println("e");
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
		if (ty) {
			new CreatTable().ct(signal);
		}
		return ty;
	}

	// 删除集团客户
	public boolean deleteGP(String signal) {// ///////////////正确
		if (deleteGPL(signal)) {
			try {
				s = "DELETE FROM customer WHERE customer.signal='" + signal
						+ "'";
				Class.forName(mysqlDriver);
				conn = DriverManager.getConnection(url);
				stmt = conn.createStatement();
				ty = stmt.execute(s);
				ty = !ty;
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
		return true;
	}

	// 搜索集团客户
	public boolean seekGP(String signal) {// //////////////////正确
		try {
			s = "SELECT * FROM customer WHERE customer.signal='" + signal + "'";
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(s);
			ty = rs.next();
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

	// 添加个人客户
	public boolean addIP(String name, String secret, String home_phone,
			String email, String signal) {////////////////////////////////////////正确
		try {
			s = "INSERT INTO customer VALUES('" + name + "','" + secret + "','"
					+ home_phone + "','" + email + "','" + signal + "')";
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			ty = stmt.execute(s);
			ty = !ty;
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

	// 删除个人客户
	public boolean deleteIP(String signal) {// ////////////正确
		try {

			s = "DELETE FROM customer WHERE customer.signal='" + signal + "'";
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			ty = stmt.execute(s);
			ty = !ty;
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

	// 搜索个人客户
	public boolean seekIP(String signal) {// /////正确
		try {
			s = "SELECT * FROM customer WHERE customer.signal='" + signal
					+ "';";
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(s);
			ty = rs.next();
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
	
	public boolean seekGPL(String signal,String name) {
		try {
			s = "select * from "+signal+" where "+signal+".name = '"+name+"'";
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(s);
			ty = rs.next();
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
