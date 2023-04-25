package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.Font;
import java.awt.Label;
import javax.swing.SwingConstants;

public class user extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user frame = new user();
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
	public user() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1003, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(183, 52, 270, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 204, 148, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User_Name :");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(65, 55, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Phone _no :");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(65, 94, 86, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity  :");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(65, 207, 71, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(183, 97, 270, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("User Address  :");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_4.setBounds(65, 130, 108, 17);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("\" max count is  10 \"");
		lblNewLabel_3.setBounds(364, 207, 180, 14);
		contentPane.add(lblNewLabel_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setLineWrap(true);
		textArea.setBounds(183, 130, 270, 53);
		contentPane.add(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ROSE", "JASMIN ", "LOTUS ", "TULIP","GOLDEN SHOWER","SUNFLOWER"}));
		comboBox.setBounds(183, 245, 148, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_5 = new JLabel("Items in list ");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_5.setBounds(65, 249, 86, 14);
		contentPane.add(lblNewLabel_5);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("cash on Delivery ");
		chckbxNewCheckBox.setBounds(49, 302, 172, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("wait for the call to conform the oder ");
		chckbxNewCheckBox_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
		});
		chckbxNewCheckBox_1.setBounds(370, 303, 216, 20);
		contentPane.add(chckbxNewCheckBox_1);
		
		JLabel lblNewLabel_6 = new JLabel("ITEM Ordering ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_6.setBounds(339, 11, 324, 30);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("SUBMIT ");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton.addMouseListener(new MouseAdapter() {
			private AbstractButton textField_1;

			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");

					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement stmt=con.createStatement();

					String USERNAME=textField.getText();
					String PHONENO=textField_3.getText();
					String ADDRESS=textArea.getText();
					String QUANTITY=textField_2.getText();
		
					String ITEMIN=comboBox.getSelectedItem().toString();
					
					


					String qc="insert into ORDERS values('"+USERNAME +"','"+PHONENO+"','"+ADDRESS+"','"+QUANTITY+"','"+ITEMIN+"')";
					stmt.executeUpdate(qc);

					System.out.println("value inserted");
					JOptionPane.showMessageDialog(null, "values inserted");

					}
					catch(Exception q) {
					System.out.println(q);}
				
			
			    JOptionPane.showMessageDialog(null, " Your oder placed ");
			}
		});
		btnNewButton.setBounds(183, 358, 108, 41);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("New label");
		label.setBounds(489, 135, 46, 14);
		contentPane.add(label);
		
		JButton btnNewButton_1 = new JButton("Back To login ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new loginuser().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(467, 358, 119, 41);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\jovit\\Downloads\\userlog.jpg"));
		lblNewLabel_7.setBounds(0, 0, 987, 410);
		contentPane.add(lblNewLabel_7);
	}
}
