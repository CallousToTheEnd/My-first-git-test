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
			  
//��ʼ������
			  	final Frame f = new Frame("ͼ�����ϵͳ");
			  	JMenuBar mmenu = new JMenuBar();
			  	JMenu jichuweihu= new JMenu("����ά��");
			  	JMenu jieyueguanli = new JMenu("���Ĺ���");
			  	JMenu chaxunguanli = new JMenu("��ѯ����");
			  	JMenu xitongguanli = new JMenu("ϵͳ����");
			  	
			  	JMenu tushuweihu = new JMenu("ͼ��ά��");
			  	JMenu duzheweihu = new JMenu("����ά��");
			  	JMenuItem jieshu1 = new JMenuItem("����");
			  	JMenuItem huanshu = new JMenuItem("����");
			  	JMenuItem tushuchaxun = new JMenuItem("ͼ���ѯ");
			  	JMenuItem duzhechaxun = new JMenuItem("���߲�ѯ");
			  	JMenuItem genggaimima = new JMenuItem("��������");
			  	JMenuItem tuichuxitong = new JMenuItem("�˳�ϵͳ");
			  	
			  	JMenuItem tushuweihutianjia = new JMenuItem("���");
			  	JMenuItem tushuweihuxiugai = new JMenuItem("�޸�");
			  	JMenuItem tushuweihushanchu = new JMenuItem("ɾ��");
			  	JMenuItem duzheweihutianjia = new JMenuItem("���");
			  	JMenuItem duzheweihuxiugai = new JMenuItem("�޸�");
			  	JMenuItem duzheweihushanchu = new JMenuItem("ɾ��");
			  	
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
				
//Ϊ�˵�����¼�
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
