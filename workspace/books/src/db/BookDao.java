package db;


import java.awt.List;
//import java.awt.print.Book;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Book;
//import java.util.*;
//import java.util.List;
public class BookDao {
	public static Book selectBook(String id){
		String str = "select * from book where id='"+id+"'";
		ResultSet rs = BaseDao.executeQuery(str);
		Book book = null;
		try {
			if(rs.next()){
				book = new Book();
				book.setId(rs.getString("id"));
				book.setType(rs.getString("type"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getDouble("price"));
				book.setStock(rs.getInt("stock"));
				book.setTranslator(rs.getString("translator"));
				book.setPublish_time(rs.getString("publish_time"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
		
	}
	
	public static ArrayList selectBookList(String sql){
		ArrayList list = new ArrayList();
		ResultSet rs = BaseDao.executeQuery(sql);
		try {
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getString("id"));
				book.setType(rs.getString("type"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getDouble("price"));
				book.setStock(rs.getInt("stock"));
				book.setTranslator(rs.getString("translator"));
				book.setPublish_time(rs.getString("publish_time"));
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
}
