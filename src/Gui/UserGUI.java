package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Controller.GreatTourSortGraph;
import Controller.ParkinglotController;
import Controller.ShortestPath;
import Controller.Sort;
import DataStructure.Graph;
import entity.Car;
import entity.ScenicSpot;
import entity.massage;
import utils.Utils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UserGUI {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
    private DataStructure.Graph g;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private ParkinglotController  pc;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public UserGUI( ) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		pc=new ParkinglotController();
		frame = new JFrame();
		frame.setFont(new Font("华文宋体", Font.PLAIN, 14));
		frame.setTitle("\u6E38\u5BA2\u670D\u52A1");
		frame.setBounds(100, 100, 828, 462);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 802, 414);
		frame.getContentPane().add(tabbedPane);
	    this.g=new Graph();
	    g.GreatGraph("新建文本文档.txt");
		g.OutputtGraph();
		Object[][] s= g.getMatrix();
		String[] s1=new String[g.getSlist().size()+1];
		s1[0]=" ";
		for(int i=0;i<g.getSlist().size();i++) {
			s1[i+1]=g.getSlist().get(i).getName();
		}
		JPanel panel = new JPanel();
		tabbedPane.addTab("景区景点分布图", null, panel, null);
		panel.setLayout(null);
		
		table = new JTable(s,s1);
		table.setSurrendersFocusOnKeystroke(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setBounds(10, 36, 787, 339);
		panel.add(table);
		
		JButton button = new JButton("\u66F4\u65B0");
		button.setFont(new Font("华文宋体", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] s1=new String[g.getSlist().size()+1];
				s1[0]=" ";
				for(int i=0;i<g.getSlist().size();i++) {
					s1[i+1]=g.getSlist().get(i).getName();
				}
				JTable table1 = new JTable(s,s1);
				table1.setSurrendersFocusOnKeystroke(true);
				table1.setCellSelectionEnabled(true);
				table1.setColumnSelectionAllowed(true);
				table1.setBounds(10, 36, 777, 339);
                 table=table1;
			}
		});
		button.setBounds(323, 10, 113, 23);
		panel.add(button);
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("景点查询", null, panel_1, null);
		panel_1.setLayout(null);
		
		textField = new JTextField("输入景点名");
		textField.setBounds(22, 19, 213, 31);
		panel_1.add(textField);
		textField.setColumns(10);
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setColumns(8);
		textArea_4.setLineWrap(true);
		textArea_4.setWrapStyleWord(true);
		textArea_4.setBounds(10, 60, 712, 315);
		panel_1.add(textArea_4);
		JButton button_1 = new JButton("查询");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_4.setText("");
			ScenicSpot s=g.Finds(textField.getText());
				if(s!=null) {
					textArea_4.append(s.getName()+"\n");
					textArea_4.append("它与"+"\n");
					for(int i=0;i<s.getEhead().size();i++) {
						textArea_4.append(s.getEhead().get(i).getSfont()+"——"+"\n");
					}
					textArea_4.append("相邻"+"\n");
					
				}
				else {
					textArea_4.append("输入有误");
				}
			}
		});
		button_1.setBounds(277, 23, 93, 23);
		panel_1.add(button_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6B22\u8FCE\u5EA6", "\u5C94\u8DEF\u6570"}));
		comboBox.setToolTipText("\u4EBA\u6C14");
		comboBox.setBounds(582, 23, 93, 23);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_4.setText("");
				System.out.println(comboBox.getSelectedItem());
				comboBox.getSelectedItem();
				  ArrayList<ScenicSpot> s= Sort.sort(comboBox.getSelectedItem().toString(),g);
				  textArea_4.setText("按"+comboBox.getSelectedItem().toString()+"从大到小顺序为"+"\n");
				  for(int i=s.size()-1;i>=0;i--) {
					  if(comboBox.getSelectedItem().toString().equals("岔路数"))
					  textArea_4.append(s.get(i).getName()+ " "+s.get(i).getEhead().size()+"  ");
					  else {
						  textArea_4.append(s.get(i).getName()+" "+ s.get(i).getPopularity()+"  ");
					  }
				  }
			}
		});
		panel_1.add(comboBox);
		
		JLabel label_3 = new JLabel("\u6392\u5E8F");
		label_3.setBounds(518, 27, 54, 15);
		panel_1.add(label_3);
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("最短路径与距离查询", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("\u8D77\u70B9");
		label.setFont(new Font("华文宋体", Font.PLAIN, 13));
		label.setBounds(78, 10, 52, 37);
		panel_2.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(129, 17, 112, 21);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7EC8\u70B9");
		label_1.setBounds(392, 20, 54, 15);
		panel_2.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(456, 17, 137, 21);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setColumns(7);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(0, 89, 787, 286);
		JButton button_2 = new JButton("查询");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(null);
				ShortestPath  sh=new ShortestPath(g);
				if(sh.Shottes((String)textField_1.getText(),(String)textField_2.getText()).equals("success")){
					textArea.setText("从" +textField_1.getText()+"到"+textField_2.getText()+"\n");
					textArea.append("最短路径为："+sh.recover_route(textField_2.getText())+"\n");
					textArea.append("最短距离为："+sh.getShortestDistance()+"\n");	
				}
				else {
					textArea.setText("起点或终点输入有误");
					textField_1.setText("");
					textField_2.setText("");
				}
			}
		});
		button_2.setBounds(309, 45, 137, 34);
		panel_2.add(button_2);
		
		panel_2.add(textArea);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("导游路线图", null, panel_3, null);
		panel_3.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setBounds(179, 13, 142, 21);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		textField_4 = new JTextField();
		textField_4.setBounds(475, 13, 153, 21);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setColumns(8);
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setBounds(10, 88, 758, 297);
		panel_3.add(textArea_1);
		JButton button_3 = new JButton("\u67E5\u8BE2");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_1.setText("");
				GreatTourSortGraph gh=new GreatTourSortGraph(g);
				String flag=gh.GreatTourtSortGraph1(textField_3.getText(), textField_4.getText());
				if(flag.equals("success")) {
					textArea_1.append("导游路线图为"+"\n");
					int n=gh.getPath().size();
				for(int i=0;i<n-1;i++) {
					if(i==n-2)
						textArea_1.append(gh.getPath().get(i));
					else
					textArea_1.append(gh.getPath().get(i)+"——");
				}
				textArea_1.append("\n"+"最短距离为"+gh.getPath().getLast());
				}
				else
				{
					textArea_1.setText(flag);
				}
			}
		});
		button_3.setBounds(255, 44, 286, 34);
		panel_3.add(button_3);
		
		
		
		JLabel label_2 = new JLabel("\u5165\u53E3");
		label_2.setBounds(78, 14, 47, 18);
		panel_3.add(label_2);
		
		JLabel label_4 = new JLabel("\u51FA\u53E3");
		label_4.setBounds(411, 16, 54, 15);
		panel_3.add(label_4);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("停车场管理", null, panel_4, null);
		panel_4.setLayout(null);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setColumns(7);
		textArea_3.setLineWrap(true);
		textArea_3.setWrapStyleWord(true);
		textArea_3.setBounds(117, 164, 550, 191);
		panel_4.add(textArea_3);
		
		JLabel label_5 = new JLabel("\u8F66\u540D");
		label_5.setBounds(188, 39, 54, 15);
		panel_4.add(label_5);
		
		JLabel label_6 = new JLabel("\u8F66\u724C\u53F7");
		label_6.setBounds(188, 90, 54, 15);
		panel_4.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(299, 36, 212, 21);
		panel_4.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(299, 87, 212, 21);
		panel_4.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("进入停车场");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea_3.setText(" ");
				Car c=new Car(textField_5.getText(),textField_6.getText());
			   ArrayList<String> mas=pc.into(c);
			   if(mas.size()>1) {
				   textArea_3.append("车牌为："+mas.get(0)+"\n"); 
				   textArea_3.append("进场的时刻为："+mas.get(1)+"\n"); 
				   textArea_3.append("车道为："+mas.get(2)+"\n"); 
			   }
			   else {
				   textArea_3.append(mas.get(0));
			   }
			
			}
		});
		btnNewButton.setBounds(235, 134, 154, 23);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("退出停车场");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  textArea_3.setText(" ");
				try {
					 ArrayList<String> mas =pc.Leave(textField_6.getText());
					 if(mas.size()>1) {
						 textArea_3.append("车牌号为："+mas.get(0)+"\n");
						 textArea_3.append("离开时间为："+mas.get(1)+"\n");
						 String[] ms=mas.get(2).split(",");
						 textArea_3.append("停车时间为："+ms[0]+"\n");
						 textArea_3.append("停车费用为"+ms[1]+"\n");
						 if(pc.getMassag1().size()>1) {
						   textArea_3.append("下一辆进入停车场的车"+"\n");
						   textArea_3.append("车牌为："+pc.getMassag1().get(0)+"\n"); 
						   textArea_3.append("进场的时刻为："+pc.getMassag1().get(1)+"\n"); 
						   textArea_3.append("车道为："+pc.getMassag1().get(2)+"\n"); 
					       }
					       else {
					    	   if(pc.getMassag1().size()!=0)
						     textArea_3.append(pc.getMassag1().get(0));
					      } 
					 }else 
					 {
						 textArea_3.append(mas.get(0));
					 }
				  } catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 }
			}
		});
		btnNewButton_1.setBounds(427, 134, 163, 23);
		panel_4.add(btnNewButton_1);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("资讯通知", null, panel_5, null);
		panel_5.setLayout(null);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setColumns(50);
		textArea_2.setLineWrap(true);
		textArea_2.setWrapStyleWord(true);
		textArea_2.setBounds(40, 51, 724, 269);
		panel_5.add(textArea_2);
		
		JButton button_4 = new JButton("\u63A5\u6536");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Object> mgg=new ArrayList<Object>();
				  mgg=Utils.readObject();
				  System.out.println(mgg.size());
				for(int i=0;i<mgg.size();i++) {
					textArea_2.append(((massage) mgg.get(i)).getTime()+"\n");
					textArea_2.append(((massage)mgg.get(i)).getMas()+"\n");
				}
				
			}
		});
		button_4.setBounds(330, 10, 93, 23);
		panel_5.add(button_4);
		
		
		frame.setVisible(true);
	}
}
