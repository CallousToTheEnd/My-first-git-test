package db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class BaseDao {
	protected static String driver = "com.mysql.jdbc.Driver";
	protected static String url = "jdbc:mysql://127.0.0.1:3306/books";
	protected static String dbUser = "root";
	protected static String dbPwd = "";
	private static Connection conn = null;
	/**
	 * ���췽�����������ݿ�����
	 */
	private BaseDao () {
		try {
			if(conn == null){
				Class.forName(driver);
				conn = (Connection) DriverManager.getConnection(url, dbUser, dbPwd);
			}else
				return;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * ִ�����ݿ��ѯ
	 * @param sql
	 * @return ResultSet
	 */
	public static ResultSet executeQuery(String sql) {
		try {
			if(conn == null)
				new BaseDao();
			return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ִ�����ݿ����
	 * @param sql
	 */
	public static int executeUpdate(String sql){
		try {
			if(conn == null)
				new BaseDao();
			return conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			return -1;
		}finally{
			
		}
	}
}
