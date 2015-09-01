package window;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import db.BaseDao;
import db.BookDao;
import entity.Book;

public class BookDelete {

	private JFrame frame;
	private JTextField txtA;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_1;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookUpdate window = new BookUpdate();
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
	public BookDelete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5220\u9664\u56FE\u4E66");
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		label.setBounds(38, 24, 65, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		label_1.setBounds(38, 49, 65, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		label_2.setBounds(38, 74, 65, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u8BD1\u8005\uFF1A");
		label_3.setBounds(59, 99, 44, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u51FA\u7248\u65F6\u95F4\uFF1A");
		label_4.setBounds(38, 124, 65, 15);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u5E93\u5B58\u6570\u91CF\uFF1A");
		label_5.setBounds(38, 149, 65, 15);
		frame.getContentPane().add(label_5);
		
		txtA = new JTextField();
		txtA.setBounds(113, 24, 108, 18);
		frame.getContentPane().add(txtA);
		txtA.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(113, 47, 108, 18);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(113, 97, 108, 18);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(113, 124, 43, 18);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setBounds(113, 147, 108, 18);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u79D1\u6280\u7C7B", "\u6587\u5316\u7C7B"}));
		comboBox.setEnabled(false);
		comboBox.setBounds(113, 72, 108, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel label_6 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		label_6.setBounds(284, 49, 65, 15);
		frame.getContentPane().add(label_6);
		
		JLabel lblNewLabel = new JLabel("\u4F5C\u8005\uFF1A");
		lblNewLabel.setBounds(308, 74, 44, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_7 = new JLabel("\u51FA\u7248\u793E\uFF1A");
		label_7.setBounds(296, 99, 54, 15);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("\u4EF7\u683C\uFF1A");
		label_8.setBounds(308, 124, 44, 15);
		frame.getContentPane().add(label_8);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(357, 47, 108, 18);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setBounds(357, 72, 108, 18);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		textField_7.setBounds(357, 97, 108, 18);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setColumns(10);
		textField_8.setBounds(357, 122, 108, 18);
		frame.getContentPane().add(textField_8);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setBounds(235, 20, 93, 23);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				button_chaxuntushu();
			}

			private void button_chaxuntushu() {
				Book book = BookDao.selectBook(txtA.getText());
				textField_2.setText(book.getId());
				comboBox.setSelectedItem(book.getType());
				textField_3.setText(book.getTranslator());
				textField_5.setText(Integer.toString(book.getStock()));
				textField_1.setText(book.getName());
				textField_6.setText(book.getAuthor());
				textField_7.setText(book.getPublisher());
				textField_8.setText(Double.toString(book.getPrice()));
				textField_4.setText((book.getPublish_time()).substring(0, 4));
				textField.setText((book.getPublish_time()).substring(4, 6));
			}
		});
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.setBounds(257, 194, 93, 23);
		frame.getContentPane().add(button_1);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = textField_2.getText();
				String sql = "delete from book where id='"+id+"'";
				int i = BaseDao.executeUpdate(sql);
				if(i == 1){
					JOptionPane.showMessageDialog(null, "É¾³ý³É¹¦");
					frame.setVisible(false);
				}
			}
		});
		
		JButton button_2 = new JButton("\u53D6\u6D88");
		button_2.setBounds(373, 194, 93, 23);
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(button_2);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(175, 124, 25, 18);
		frame.getContentPane().add(textField);
		
		JLabel label_9 = new JLabel("\u5E74");
		label_9.setBounds(160, 124, 18, 15);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("\u65E5");
		label_10.setBounds(203, 124, 18, 15);
		frame.getContentPane().add(label_10);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenwidth = (int) screensize.getWidth();
		int screenheight = (int) screensize.getHeight();
		frame.setBounds(screenwidth/2-503/2, screenheight/2-276/2, 503, 276);
		frame.setVisible(true);
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
