package window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class Login extends Frame
{
	public static void main(String[] args)
	{
		//Frame���
		final Frame lf = new Frame("��½");
		lf.setLayout(null);
		lf.setSize(400, 150);
		lf.setLocation(470, 270);
		lf.setVisible(true);
		lf.setResizable(false);
		lf.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1);
			}
		});
		
		//��ǩ
		Label lbname = new Label("�û�����");
		Label lbpass = new Label("���룺");
		lbname.setBounds(80,50,45,15);
		lbpass.setBounds(92,70,45,15);
		lf.add(lbname);
		lf.add(lbpass);
		
		//�ı���
		final TextField tfname = new TextField("likang");
		final TextField tfpass = new TextField("12345678");
		tfname.setBounds(140, 50, 100, 18);
		tfpass.setBounds(140, 70, 100, 18);
		lf.add(tfname);
		lf.add(tfpass);
		
		//��ť
		Button btn_ok = new Button("��½");
		Button btn_quxiao = new Button("ȡ��");
		btn_ok.setBounds(90, 110, 60, 25);
		btn_quxiao.setBounds(170, 110, 60, 25);
		lf.add(btn_ok);
		lf.add(btn_quxiao);
		btn_ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btn_okActionPerformed btn_ok = new btn_okActionPerformed(e,lf,tfname,tfpass);
				//btn_okActionPerformed(e);
			}
		});
		btn_quxiao.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		
		
		
		
	}
}
