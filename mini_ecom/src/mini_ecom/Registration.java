package mini_ecom;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Registration {

	private JFrame frame;
	private JTextField s1;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 204, 204));
		frame.setBounds(100, 100, 713, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lab = new JLabel("Registration");
		lab.setFont(new Font("Gabriola", Font.BOLD, 50));
		lab.setBounds(218, 11, 289, 48);
		frame.getContentPane().add(lab);
		
		JLabel lblName = new JLabel("Username :");
		lblName.setFont(new Font("Gabriola", Font.BOLD, 35));
		lblName.setBounds(31, 117, 152, 60);
		frame.getContentPane().add(lblName);
		
		JLabel lblSno = new JLabel("SNO :");
		lblSno.setFont(new Font("Gabriola", Font.BOLD, 35));
		lblSno.setBounds(64, 70, 119, 52);
		frame.getContentPane().add(lblSno);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Gabriola", Font.BOLD, 35));
		lblEmail.setBounds(64, 159, 119, 60);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblMarks = new JLabel("Marks :");
		lblMarks.setFont(new Font("Gabriola", Font.BOLD, 35));
		lblMarks.setBounds(64, 213, 110, 52);
		frame.getContentPane().add(lblMarks);
		
		s1 = new JTextField();
		s1.setBounds(200, 70, 152, 20);
		frame.getContentPane().add(s1);
		s1.setColumns(10);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(200, 127, 152, 20);
		frame.getContentPane().add(t1);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(200, 169, 152, 20);
		frame.getContentPane().add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(200, 219, 152, 20);
		frame.getContentPane().add(t3);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s= s1.getText();
				int sno=Integer.parseInt(s);
				String Name =t1.getText();
				String Email=t2.getText();
				String m=t3.getText();
				float Marks=Float.parseFloat(m);
			
				
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","mrec");
					String q="Insert into stud1 values('"+sno+"','"+Name+"','"+Email+"','"+Marks+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton, "Done!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(158, 260, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
