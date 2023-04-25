package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class add extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add frame = new add();
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
	public add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 45, 708, 241);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		
		JButton btnNewButton = new JButton("Click Here to View ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");

					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");

					Statement st=con.createStatement();
					 ResultSet rs=st.executeQuery("select FLOWERNAME,PRICE,PRODUCT_ID,QTY from flower");
                     table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e1) {

					System.out.println(e1);

					}
				
			}
		});
		btnNewButton.setBounds(10, 11, 166, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addflower().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setBounds(671, 336, 110, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("orders");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");

					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");

					Statement st=con.createStatement();
					 ResultSet rs=st.executeQuery("select USER_NAME,PHONE_NO,ADDRESS,QUANTITY,ITEMIN from orders");
                     table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e1) {

					System.out.println(e1);

					}
				
				
			}
		});
		btnNewButton_2.setBounds(41, 336, 124, 25);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jovit\\Downloads\\userlog.jpg"));
		lblNewLabel.setBounds(0, 0, 820, 382);
		contentPane.add(lblNewLabel);
	}
}
