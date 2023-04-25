package project;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;
public class loginpage extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField password;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpage frame = new loginpage();
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
	public loginpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setBounds(301, 215, 125, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(301, 268, 125, 26);
		contentPane.add(lblPassword);
		
		name = new JTextField();
		name.setBounds(410, 215, 178, 23);
		contentPane.add(name);
		name.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(410, 271, 178, 23);
		contentPane.add(password);
		
		JLabel lblNewLabel_1 = new JLabel("Sign in");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(410, 121, 89, 31);
		contentPane.add(lblNewLabel_1);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new addflower().setVisible(true);
			}
		});
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try
		        {
					Class.forName("oracle.jdbc.driver.OracleDriver");

					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");

					Statement st=con.createStatement();

					JLabel textField;
					ResultSet rs=st.executeQuery("select * from admin where username='"+name.getText()+"'");

					if(rs.next()) {

					new addflower().setVisible(true);
					dispose();

					setVisible(false);

					}

					else {

					JOptionPane.showMessageDialog(null, "login unsuccesfull");


					}

					}catch(Exception e1) {

					System.out.println(e1);

					}
				
			}
			});
		
		login.setForeground(Color.BLACK);
		login.setBackground(new Color(255, 128, 192));
		login.setBounds(307, 366, 89, 23);
		contentPane.add(login);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Reg().setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(255, 128, 192));
		btnNewButton_1.setBounds(499, 366, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(255, 232, 243));
		lblNewLabel_2.setBounds(259, 95, 391, 388);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(Color.RED);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\jovit\\Downloads\\loginbg (1).jpg"));
		lblNewLabel_3.setBounds(0, 0, 900, 600);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblSelectRole = new JLabel("SELECT ROLE");
		lblSelectRole.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 11));
		lblSelectRole.setBounds(301, 178, 125, 26);
		contentPane.add(lblSelectRole);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(301, 186, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(168, 26, 482, 47);
		contentPane.add(lblNewLabel_5);
	}
}
