/**
 * @author RenYali
 * Ϊÿһ��ע���û�����������ϵ��
 */
package MS;

import java.sql.*;

public class CreatTable {

	String mysqlDriver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost/managersystem?user=root&password=root";// �ͻ����ݿ�
	Connection conn = null;
	Statement smt = null;
	boolean ty = false;

	public boolean ct(String tbname) {////////////////////////��ȷ
		try {
			Class.forName(mysqlDriver);
			String tableSql = "create table " + tbname
					+ " (name varchar(50) not null primary key, "
					+ "hp varchar(20), " + "email varchar(30), "
					+ "wp varchar(20), " + "position varchar(30));";

			conn = DriverManager.getConnection(url);
			smt = conn.createStatement();
			if (conn != null) {
				ty= smt.execute(tableSql);
				ty = !ty;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally{
			try{
				if(smt != null){
					smt.close();
					smt = null;
				}
				if(conn != null){
					conn.close();
					conn = null;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ty;
	}
}
