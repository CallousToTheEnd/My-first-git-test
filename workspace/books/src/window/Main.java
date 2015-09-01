package window;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main extends Frame{
	
		  void init(){
			  
//初始化界面
			  	final Frame f = new Frame("图书管理系统");
			  	JMenuBar mmenu = new JMenuBar();
			  	JMenu jichuweihu= new JMenu("基础维护");
			  	JMenu jieyueguanli = new JMenu("借阅管理");
			  	JMenu chaxunguanli = new JMenu("查询管理");
			  	JMenu xitongguanli = new JMenu("系统管理");
			  	
			  	JMenu tushuweihu = new JMenu("图书维护");
			  	JMenu duzheweihu = new JMenu("读者维护");
			  	JMenuItem jieshu1 = new JMenuItem("借书");
			  	JMenuItem huanshu = new JMenuItem("还书");
			  	JMenuItem tushuchaxun = new JMenuItem("图书查询");
			  	JMenuItem duzhechaxun = new JMenuItem("读者查询");
			  	JMenuItem genggaimima = new JMenuItem("更改密码");
			  	JMenuItem tuichuxitong = new JMenuItem("退出系统");
			  	
			  	JMenuItem tushuweihutianjia = new JMenuItem("添加");
			  	JMenuItem tushuweihuxiugai = new JMenuItem("修改");
			  	JMenuItem tushuweihushanchu = new JMenuItem("删除");
			  	JMenuItem duzheweihutianjia = new JMenuItem("添加");
			  	JMenuItem duzheweihuxiugai = new JMenuItem("修改");
			  	JMenuItem duzheweihushanchu = new JMenuItem("删除");
			  	
			  	tushuweihu.add(tushuweihutianjia);
			  	tushuweihu.add(tushuweihuxiugai);
			  	tushuweihu.add(tushuweihushanchu);
			  	duzheweihu.add(duzheweihutianjia);
			  	duzheweihu.add(duzheweihuxiugai);
			  	duzheweihu.add(duzheweihushanchu);
			  	jichuweihu.add(tushuweihu);
			  	jichuweihu.add(duzheweihu);
			  	jieyueguanli.add(jieshu1);
			  	jieyueguanli.add(huanshu);
			  	chaxunguanli.add(tushuchaxun);
			  	chaxunguanli.add(duzhechaxun);
			  	xitongguanli.add(genggaimima);
			  	xitongguanli.add(tuichuxitong);
			  	mmenu.add(jichuweihu);
			  	mmenu.add(jieyueguanli);
			  	mmenu.add(chaxunguanli);
			  	mmenu.add(xitongguanli);
			  	f.add(mmenu,BorderLayout.NORTH);
			  	
			  		
//			 	f.setLayout(null);
			 	f.setSize(640, 480);
			 	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
			 	int width = (int) screensize.getWidth();
			 	int height = (int) screensize.getHeight();
				f.setLocation(width/2-640/2,height/2-480/2); 
				f.setVisible(true);
				f.setResizable(false);
				f.addWindowListener(new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						System.exit(1);
					}
				});
				
//为菜单添加事件
				tushuweihutianjia.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						BookAdd bookadd = new BookAdd();
						
					}
				});
			  	tushuweihuxiugai.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						BookUpdate bookupdate = new BookUpdate();
					}
				});
			  	tushuweihushanchu.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						BookDelete bookdelete = new BookDelete();
					}
				});
			  	duzheweihutianjia.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						ReadAdd readadd = new ReadAdd();
					}
				});
			  	duzheweihuxiugai.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						ReadUpdate readupdate = new ReadUpdate();
					}
				});
			  	duzheweihushanchu.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						ReadDelete readdelete = new ReadDelete();
					}
				});

		}
	
}
