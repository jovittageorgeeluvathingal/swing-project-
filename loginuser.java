package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class loginuser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginuser frame = new loginuser();
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
	public loginuser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 585);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Sign in");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(388, 141, 101, 31);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User name  : ");
		lblNewLabel_2.setBackground(Color.PINK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(294, 206, 90, 17);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(423, 203, 151, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(294, 260, 77, 20);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(423, 260, 151, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login ");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				//new user().setVisible(true);

			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
					Class.forName("oracle.jdbc.driver.OracleDriver");

					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");

					Statement st=con.createStatement();

					//JLabel textField = null;
					String name = textField.getText();
					ResultSet rs=st.executeQuery("select * from  customers where username='"+ name +"'");

					if(rs.next()) {

					new user().setVisible(true);

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
		btnNewButton.setFont(new Font("Garamond", Font.BOLD, 11));
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setBounds(379, 337, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel ll = new JLabel("");
		ll.setOpaque(true);
		ll.setBackground(new Color(255, 232, 243));
		ll.setBounds(259, 95, 391, 388);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBounds(219, 83, 444, 373);
		lblNewLabel_3.setBackground(new Color(255, 232, 243));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\jovit\\Downloads\\loginbg (1).jpg"));
		lblNewLabel_4.setBounds(0, -1, 833, 546);
		contentPane.add(lblNewLabel_4);
		
		
	}
}
