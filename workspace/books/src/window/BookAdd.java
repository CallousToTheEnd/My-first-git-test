package window;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DataFormatException;

import javax.lang.model.type.PrimitiveType;
import javax.swing.ComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.plaf.ComboBoxUI;

import db.BaseDao;

public class BookAdd {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtXxxxxx;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JComboBox comboBox;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookAdd window = new BookAdd();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public BookAdd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame. 初始化界面
	 */
	private void initialize() {
		frame = new JFrame("添加读者");
		frame.setTitle("\u6DFB\u52A0\u56FE\u4E66");
		frame.getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		label_1.setBounds(36, 12, 65, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		label_2.setBounds(36, 37, 65, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u8BD1\u8005\uFF1A");
		label_3.setBounds(60, 62, 43, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u51FA\u7248\u65F6\u95F4\uFF1A");
		label_4.setBounds(36, 87, 65, 15);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u5E93\u5B58\u6570\u91CF\uFF1A");
		label_5.setBounds(36, 112, 65, 15);
		frame.getContentPane().add(label_5);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(123, 12, 108, 18);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(123, 62, 108, 18);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(123, 112, 108, 18);
		frame.getContentPane().add(textField_3);
		
		txtXxxxxx = new JTextField();
		txtXxxxxx.setColumns(10);
		txtXxxxxx.setBounds(123, 87, 43, 18);
		frame.getContentPane().add(txtXxxxxx);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u79D1\u6280\u7C7B", "\u65B0\u897F\u5170"}));
		comboBox.setBounds(123, 37, 108, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel label_6 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		label_6.setBounds(288, 12, 65, 15);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("\u4F5C\u8005\uFF1A");
		label_7.setHorizontalTextPosition(SwingConstants.RIGHT);
		label_7.setBounds(311, 37, 43, 15);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("\u51FA\u7248\u793E\uFF1A");
		label_8.setBounds(299, 62, 54, 15);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("\u4EF7\u683C\uFF1A");
		label_9.setBounds(310, 87, 43, 15);
		frame.getContentPane().add(label_9);
		
		textField_5 = new JTextField();
		textField_5.setBounds(363, 10, 93, 18);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(364, 34, 92, 18);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(364, 59, 92, 18);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(364, 84, 92, 18);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JButton button_1 = new JButton("\u6DFB\u52A0");
		button_1.setBounds(275, 162, 93, 23);
		frame.getContentPane().add(button_1);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					button_1_tianjiatushu(e);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton button_2 = new JButton("\u53D6\u6D88");
		button_2.setBounds(378, 162, 93, 23);
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(button_2);
		
		JLabel label = new JLabel("\u5E74");
		label.setBounds(169, 87, 18, 15);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(188, 87, 25, 18);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_10 = new JLabel("\u65E5");
		label_10.setBounds(219, 87, 18, 15);
		frame.getContentPane().add(label_10);
		frame.setResizable(false);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenwidht = (int) screensize.getWidth();
		int screenhight = (int) screensize.getHeight();
		frame.setBounds(screenwidht/2-502/2, screenhight/2-275/2, 502, 243);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	//添加图书方法
	private void button_1_tianjiatushu(ActionEvent e) throws ParseException {
		String id = textField_1.getText();
		String name = textField_5.getText();
		String type = comboBox.getSelectedItem().toString();
		String author = textField_6.getText();
		String translator = textField_2.getText();
		String publisher = textField_7.getText();
		String publish_time = txtXxxxxx.getText() + textField.getText();
		int stock = Integer.parseInt(textField_3.getText());
		double price =Double.parseDouble(textField_8.getText());
		String sqlStr = "insert into book values('"+id+"','"+name+"','"+type+"','"+author+"','"
					+translator+"','"+publisher+"','"+publish_time+"',"+stock+","+price+")";
		int i= BaseDao.executeUpdate(sqlStr);
		if(i == 1){
			JOptionPane.showMessageDialog(null, "添加成功");
		}
	}
}
