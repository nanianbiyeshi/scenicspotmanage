package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import entity.massage;
import utils.Utils;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ibm.icu.text.SimpleDateFormat;

import DataStructure.Graph;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;

public class AdministerGui {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
    private DataStructure.Graph g;
    private  ArrayList<Object> mgg;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public AdministerGui(Graph g ) {
		initialize();
		this.g=g;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mgg= new ArrayList<Object>();
		frame = new JFrame();
		frame.setBounds(100, 100, 842, 473);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 826, 426);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("插入景点或边", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u666F\u70B91");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(86, 30, 153, 24);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("\u4E0E\u5B83\u76F8\u8FDE\u7684\u666F\u70B9");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(85, 101, 118, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u8DDD\u79BB");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(86, 179, 94, 35);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(286, 27, 300, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(286, 91, 300, 35);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(286, 179, 300, 35);
		panel.add(textField_2);
		textField_2.setColumns(10);
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g.InsertEdge1(textField.getText(),textField_1.getText() ,Integer.parseInt(textField_2 .getText()) );
				g.InsertEdge1(textField_1.getText(),textField.getText() ,Integer.parseInt(textField_2 .getText()) );
			}
		});
		button.setBounds(322, 254, 199, 44);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("景点删除", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label_2 = new JLabel("\u666F\u70B9\u540D");
		label_2.setBounds(136, 32, 54, 15);
		panel_1.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(235, 21, 252, 38);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g.remove(textField_3.getName());
			}
		});
		button_1.setBounds(235, 172, 252, 23);
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("通知发布", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_3 = new JLabel("\u901A\u77E5\u4FE1\u606F");
		label_3.setBounds(339, 27, 54, 22);
		panel_2.add(label_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 60, 714, 217);
		panel_2.add(textArea);
		
		JButton button_2 = new JButton("\u53D1\u5E03");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    Utils.writeObject(mgg);
			}
		});
		button_2.setBounds(566, 287, 118, 39);
		panel_2.add(button_2);
		
		JButton button_3 = new JButton("\u6536\u5F55");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date date=new Date();
			    SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd  hh:mm:ss");
				massage s=new  massage (ft.format(date),textArea.getText());
				mgg.add(s);
				textArea.setText(" ");
			}
		});
		button_3.setBounds(78, 287, 118, 39);
		panel_2.add(button_3);
		frame.setVisible(true);
		
	}
}
