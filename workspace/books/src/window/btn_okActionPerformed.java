package window;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class btn_okActionPerformed {
	public btn_okActionPerformed(ActionEvent e,Frame lf,TextField tfname,TextField tfpass) {
		
		String user = tfname.getText();
		String pass = tfpass.getText();
		String username = "";
		int is_admin = 0 ;
		if(user.equals("")){
			JOptionPane.showMessageDialog(lf, "�û�������Ϊ��");
			return;
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/books";
			Connection con = DriverManager.getConnection(url,"root","");
			Statement st = con.createStatement();
			String sqlStr = "select * from user where name="+"'"+user+"' "+"and pass="+"'"+pass+"'";
			ResultSet result = st.executeQuery(sqlStr);
			//boolean a = result.next();
			//System.out.print(a); 12345678
			
			if(result.next()){
				username = result.getString("name");
				is_admin = result.getInt("is_admin");
				//System.out.println("�û�����"+result.getString("name")+"���룺"+result.getString("pass"));
				System.out.print(username+is_admin);
			}
			//}
			else{
				JOptionPane.showMessageDialog(lf, "�û��������벻��ȷ");
				return;
			}
			
			Main main = new Main();
			main.init();
			lf.dispose();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
