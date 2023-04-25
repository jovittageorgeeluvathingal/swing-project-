package project;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addflower extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	protected Object DbUtils;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addflower frame = new addflower();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addflower() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setForeground(new Color(255, 128, 255));
		panel.setBounds(0, 0, 989, 416);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("view");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new add().setVisible(true);
				dispose();
			}
		});

		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(609, 305, 120, 23);
		panel.add(btnNewButton);
		
		
		
		textField = new JTextField();
		textField.setBounds(221, 105, 161, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(221, 139, 161, 23);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(221, 180, 161, 23);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("FLOWER NAME ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(79, 105, 89, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PRICE ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(79, 140, 89, 18);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("FLOWER_ID ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(79, 181, 89, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("QTY");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(79, 230, 89, 23);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(221, 230, 161, 23);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(Color.PINK);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");

					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement stmt=con.createStatement();

					String FLOWERNAME=textField.getText();
					String PRICE=textField_1.getText();
					String PRODUCT_ID=textField_2.getText();
					String QTY=textField_3.getText();
					


					String qc="insert into Flower values('"+FLOWERNAME+"','"+PRICE+"','"+PRODUCT_ID+"','"+QTY+"')";
					stmt.executeUpdate(qc);

					System.out.println("value inserted");
					JOptionPane.showMessageDialog(null, "values inserted");

					}
					catch(Exception q) {
					System.out.println(q);}
				
				
				//new add().setVisible(true);
			}
			
		});
		btnNewButton_2.setBounds(151, 305, 113, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Delete ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");

					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement stmt=con.createStatement();

					String FLOWERNAME = textField.getText();
					
					String qry="delete from FLOWER where FLOWERNAME='"+FLOWERNAME+"'";
					System.out.println(qry);
					stmt.executeQuery(qry);
					JOptionPane.showMessageDialog(null,"values deleted");


					}
					catch(Exception q) {
					System.out.println(q);
					}
				//new delete().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(376, 305, 113, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("ADMIN work space ");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_5.setBounds(270, 31, 311, 32);
		panel.add(lblNewLabel_5);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new loginpage().setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_3.setBackground(Color.PINK);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(629, 370, 100, 23);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\jovit\\Downloads\\userlog.jpg"));
		lblNewLabel_4.setBounds(0, 0, 979, 416);
		panel.add(lblNewLabel_4);
	}
}
