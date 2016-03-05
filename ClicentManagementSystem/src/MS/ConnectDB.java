/**
 * @author RenYali
 */
package MS;

import java.sql.*;

public class ConnectDB {

	String mysqlDriver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/managersystem?user=root&password=root";// �ͻ����ݿ�
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	boolean ty = false;
	String s = null;
	//private CreatTable cta = new CreatTable();

	// ��Ӽ��ſͻ���ϵ��
	public boolean addGPL(String name, String home_phone, String email,///////////////////////////��ȷ
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

	// ɾ������ͻ���ϵ��
	public boolean deleteGPL(String name, String signal) {/////////////////////////��ȷ
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

	// ɾ��������ͬsignal�ļ��ſͻ���ϵ��
	public boolean deleteGPL(String signal) {/////////////////////////////��ȷ
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
		System.out.println("���ty            =  " + ty);		
		
		
		
		return ty;
	}

	// ��Ӽ��ſͻ�
	public boolean addGP(String name, String secret, String home_phone,
			String email, String signal) {// ///////////////////////////////////////////////////////////��ȷ
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

	// ɾ�����ſͻ�
	public boolean deleteGP(String signal) {// ///////////////��ȷ
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

	// �������ſͻ�
	public boolean seekGP(String signal) {// //////////////////��ȷ
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

	// ��Ӹ��˿ͻ�
	public boolean addIP(String name, String secret, String home_phone,
			String email, String signal) {////////////////////////////////////////��ȷ
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

	// ɾ�����˿ͻ�
	public boolean deleteIP(String signal) {// ////////////��ȷ
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

	// �������˿ͻ�
	public boolean seekIP(String signal) {// /////��ȷ
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
