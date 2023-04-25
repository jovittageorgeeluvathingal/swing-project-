package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class Reg extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reg frame = new Reg();
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
	public Reg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1037, 442);
		contentPane = new JPanel();
		contentPane.setForeground(Color.PINK);
		contentPane.setBackground(new Color(102, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User_Name ");
		lblNewLabel.setForeground(new Color(255, 51, 255));
		lblNewLabel.setBounds(57, 71, 86, 20);
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(186, 63, 168, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last name ");
		lblNewLabel_1.setForeground(new Color(255, 51, 255));
		lblNewLabel_1.setBounds(63, 129, 68, 17);
		lblNewLabel_1.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 119, 168, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("phone_ no ");
		lblNewLabel_2.setForeground(new Color(255, 51, 255));
		lblNewLabel_2.setBounds(57, 185, 86, 14);
		lblNewLabel_2.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 14));
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(186, 174, 168, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("address ");
		lblNewLabel_3.setForeground(new Color(255, 51, 255));
		lblNewLabel_3.setBounds(63, 230, 86, 20);
		lblNewLabel_3.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 14));
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(186, 222, 168, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(741, 339, 89, 20);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//new loginpage().setVisible(true);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new loginuser().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("To the Sign_in page ....");
		lblNewLabel_4.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBounds(592, 343, 119, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("USER REGESTRATION ");
		lblNewLabel_5.setForeground(new Color(51, 0, 255));
		lblNewLabel_5.setBounds(390, 11, 244, 42);
		lblNewLabel_5.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton(" Submit ");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"value submited ");
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");

					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement stmt=con.createStatement();

					String USERNAME=textField.getText();
					String LASTNAME=textField_1.getText();
					String PHONENO=textField_2.getText();
					String ADDRESS=textField_3.getText();
					String PASSWORD=passwordField.getText();

					String qc="insert into CUSTOMERS values('"+USERNAME+"','"+LASTNAME+"','"+PHONENO+"','"+ADDRESS+"','" +PASSWORD+"')";
					stmt.executeUpdate(qc);

					System.out.println("value inserted");
					JOptionPane.showMessageDialog(null, "values inserted");

					}
					catch(Exception q) {
					System.out.println(q);}
				
			}
		});
		btnNewButton_1.setBounds(314, 343, 114, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("Password ");
		lblNewLabel_7.setForeground(new Color(255, 51, 255));
		lblNewLabel_7.setBackground(Color.PINK);
		lblNewLabel_7.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_7.setBounds(64, 272, 79, 28);
		contentPane.add(lblNewLabel_7);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(186, 272, 168, 28);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\jovit\\Downloads\\userlog.jpg"));
		lblNewLabel_6.setBounds(0, 0, 1021, 403);
		contentPane.add(lblNewLabel_6);
	}
}
