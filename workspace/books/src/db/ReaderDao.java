package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Book;
import entity.Reader;

public class ReaderDao {
	/**
	 * 返回Reader类的实体
	 * @param id
	 * @return reader
	 */
	public static Reader selectReader(String id){
		String sql = "select * from reader where id='"+id+"'";
		ResultSet rs = BaseDao.executeQuery(sql);
		Reader reader = null;
		try {
			if(rs.next()){
				reader = new Reader();
				reader.setId(rs.getString("id"));
				reader.setName(rs.getString("name"));
				reader.setType(rs.getString("type"));
				reader.setSex(rs.getString("sex"));
				reader.setMax_num(rs.getInt("max_num"));
				reader.setDays_num(rs.getInt("days_num"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reader;
	}
	
	public static ArrayList selectReaderList(String sql){
		ArrayList list = new ArrayList();
		ResultSet rs = BaseDao.executeQuery(sql);
		Reader reader = new Reader();
		try {
			while (rs.next()) {
			    reader = new Reader();
			    reader.setId(rs.getString("id"));
				reader.setName(rs.getString("name"));
				reader.setType(rs.getString("type"));
				reader.setSex(rs.getString("sex"));
				reader.setMax_num(rs.getInt("max_num"));
				reader.setDays_num(rs.getInt("days_num"));
				list.add(reader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
}
