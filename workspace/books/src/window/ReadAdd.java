package window;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import db.BaseDao;

public class ReadAdd {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;

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
	public ReadAdd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("添加读者");
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8BFB\u8005\u7F16\u53F7\uFF1A");
		label.setBounds(27, 21, 65, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u8BFB\u8005\u7C7B\u522B\uFF1A");
		label_1.setBounds(27, 60, 65, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u53EF\u501F\u6570\u91CF\uFF1A");
		label_2.setBounds(27, 95, 65, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u8BFB\u8005\u59D3\u540D\uFF1A");
		label_3.setBounds(274, 21, 65, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u6027\u522B\uFF1A");
		label_4.setBounds(298, 60, 44, 15);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u53EF\u501F\u5929\u6570\uFF1A");
		label_5.setBounds(274, 95, 65, 15);
		frame.getContentPane().add(label_5);
		
		textField = new JTextField();
		textField.setBounds(93, 18, 108, 18);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(93, 95, 108, 18);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(337, 19, 108, 18);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(337, 93, 108, 18);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6559\u5E08", "\u5B66\u751F"}));
		comboBox.setBounds(93, 57, 108, 20);
		frame.getContentPane().add(comboBox);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		comboBox_1.setBounds(337, 55, 108, 20);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.setBounds(227, 141, 93, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnNewButton_tianjiaduzhe();
			}

			private void btnNewButton_tianjiaduzhe() {
				String id = textField.getText();
				String name = textField_3.getText();
				String type = comboBox.getSelectedItem().toString();
				String sex = comboBox_1.getSelectedItem().toString();
				int max_num = Integer.parseInt(textField_2.getText());
				int days_num = Integer.parseInt(textField_5.getText());
				String sql = "insert into reader values('"+id+"','"+name+"','"+type+"','"+sex+"',"+max_num+","+days_num+")";
				int i = BaseDao.executeUpdate(sql);
				if(i == 1){
					JOptionPane.showMessageDialog(null, "添加成功");
				}
			}
		});
		
		JButton button = new JButton("\u5173\u95ED");
		button.setBounds(352, 141, 93, 23);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
			}
		});
		
		
		frame.setVisible(true);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenwidth = (int) screensize.getWidth();
		int screenheight = (int) screensize.getHeight();
		frame.setBounds(screenwidth/2-503/2, screenheight/2-276/2, 502, 240);
		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
