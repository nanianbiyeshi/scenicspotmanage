package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import DataStructure.Graph;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class index {

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index window = new index();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public index() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u666F\u533A\u7BA1\u7406");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("游客服务");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new UserGUI();
					
			}
		});
		btnNewButton.setBounds(113, 57, 178, 45);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("管理员服务");
		btnNewButton_2.addActionListener(new ActionListener() {
		     
			public void actionPerformed(ActionEvent arg0) {
				new Login();
			}
		});
		btnNewButton_2.setBounds(113, 132, 178, 45);
		frame.getContentPane().add(btnNewButton_2);
	}
}
