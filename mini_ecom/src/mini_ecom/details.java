package mini_ecom;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class details {

	private JFrame frame;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					details window = new details();
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
	public details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 711, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Details");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Gabriola", Font.BOLD, 40));
		lblNewLabel.setBounds(270, 27, 171, 57);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your Sno :");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBackground(Color.RED);
		lblNewLabel_1.setFont(new Font("Gabriola", Font.BOLD, 25));
		lblNewLabel_1.setBounds(44, 71, 151, 68);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lb1 = new JLabel("Name :");
		lb1.setForeground(Color.RED);
		lb1.setFont(new Font("Gabriola", Font.BOLD, 25));
		lb1.setBounds(44, 178, 271, 36);
		frame.getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("Marks :");
		lb2.setForeground(Color.RED);
		lb2.setFont(new Font("Gabriola", Font.BOLD, 25));
		lb2.setBounds(44, 225, 271, 36);
		frame.getContentPane().add(lb2);
		
		t1 = new JTextField();
		t1.setBounds(184, 87, 86, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JButton btnNewButton = new JButton("Click");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=t1.getText();
				int sno=Integer.parseInt(s);
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","mrec");
					String q="Select Name ,Marks from stud1 where Sno=?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setInt(1, sno);
					ResultSet rs=ps.executeQuery();
					rs.next();
					lb1.setText("Name : "+rs.getString(1));
					lb2.setText("Marks : "+rs.getInt(2));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(131, 144, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
