package window;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import db.BaseDao;
import db.ReaderDao;

import entity.Reader;

public class ReadDelete {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ReadAdd window = new ReadAdd();
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
	public ReadDelete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("删除读者信息");
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8BFB\u8005\u7F16\u53F7\uFF1A");
		label.setBounds(28, 50, 65, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u8BFB\u8005\u7C7B\u522B\uFF1A");
		label_1.setBounds(28, 75, 65, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u53EF\u501F\u6570\u91CF\uFF1A");
		label_2.setBounds(28, 100, 65, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u8BFB\u8005\u59D3\u540D\uFF1A");
		label_3.setBounds(275, 50, 65, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u6027\u522B\uFF1A");
		label_4.setBounds(299, 75, 44, 15);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u53EF\u501F\u5929\u6570\uFF1A");
		label_5.setBounds(275, 100, 65, 15);
		frame.getContentPane().add(label_5);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(94, 50, 108, 18);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(94, 100, 108, 18);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(338, 50, 108, 18);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setBounds(338, 100, 108, 18);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton button = new JButton("\u5173\u95ED");
		button.setBounds(353, 154, 93, 20);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
			}
		});
		
		JLabel label_6 = new JLabel("\u8BFB\u8005\u7F16\u53F7\uFF1A");
		label_6.setBounds(28, 25, 65, 15);
		frame.getContentPane().add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(94, 25, 108, 18);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setBounds(94, 75, 108, 20);
		frame.getContentPane().add(comboBox);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		comboBox_1.setBounds(338, 75, 108, 20);
		frame.getContentPane().add(comboBox_1);
		
		//查询读者信息
		JButton button_1 = new JButton("\u67E5\u8BE2");
		button_1.setBounds(228, 24, 93, 20);
		frame.getContentPane().add(button_1);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Reader reader = ReaderDao.selectReader(textField_6.getText());
				textField.setText(reader.getId());
				textField_3.setText(reader.getName());
				comboBox.setSelectedItem(reader.getType());
				comboBox_1.setSelectedItem(reader.getSex());
				textField_2.setText(Integer.toString(reader.getMax_num()));
				textField_5.setText(Integer.toString(reader.getDays_num()));
			}
		});
		
		//删除读者信息
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.setBounds(228, 154, 93, 20);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = textField_6.getText(); 
				String sql = "delete from reader where id='"+id+"'";
				int i = BaseDao.executeUpdate(sql);
				if(i == 1){
					JOptionPane.showMessageDialog(null, "删除成功");
					frame.setVisible(false);
				}
			}
		});
		
		frame.setVisible(true);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenwidht = (int) screensize.getWidth();
		int screenhight = (int) screensize.getHeight();
		frame.setBounds(screenwidht/2-503/2, screenhight/2-240/2, 503, 240);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
