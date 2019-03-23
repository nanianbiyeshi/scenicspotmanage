package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DataStructure.Graph;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 * @param  
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("\u767B\u5F55");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8D26\u6237\u540D");
		label.setBounds(42, 64, 54, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(42, 137, 54, 15);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(106, 57, 255, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 123, 255, 36);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s="张三";
				String s1="123456";
				if(s.equals(textField.getText())&&s1.equals(textField_1.getText())) {
					Graph g=new Graph();
					g.GreatGraph("新建文本文档.txt");
					new AdministerGui(g);}
				else
					textField.setText("用户名或密码不正确请重新输入");
				    textField_1.setText("");
			}
		});
		button.setBounds(115, 201, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.setBounds(250, 201, 111, 23);
		frame.getContentPane().add(button_1);
	}
}
