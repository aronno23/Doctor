import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class LogIn extends JFrame {
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JPanel contentPane;
	private JTextField userTF;
	private JPasswordField passTF;
	
	public static String welcomeName = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogIn.class.getResource("/Image/staarresize - Copy.png")));
		setTitle("LogIn Page");
		setResizable(false);
		conn = DAPSConnection.ConnecrDb();
		design();
		centerize();
	}
	
	public void centerize() {
		Dimension screenSize,frameSize;
		int x,y;
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameSize = getSize();
		x = (screenSize.width - frameSize.width) / 2;
		y = (screenSize.height - frameSize.height)/2;
		setLocation(x,y);
	}
	
	private void login() {
		try {
			String query = "SELECT * FROM patient WHERE User_ID = ? And Birth_Year = ?";
			
			pst = conn.prepareStatement(query);
			pst.setString(1, userTF.getText());
			pst.setString(2, passTF.getText());
			
			rs = pst.executeQuery();
						
				if(rs.next())
				{
					welcomeName = rs.getString("Patient_Name");
					Data.User_ID = userTF.getText().toString();
					JOptionPane.showMessageDialog(null, "Successfully Loged in");
					Appointment fj = new Appointment();
					fj.setVisible(true);
					dispose();
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong username or password");
				}
				
				pst.close();
				rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void design() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatientLoginPortal = new JLabel("Patient LogIn Portal");
		lblPatientLoginPortal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblPatientLoginPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientLoginPortal.setBounds(402, 13, 159, 22);
		contentPane.add(lblPatientLoginPortal);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setIcon(new ImageIcon(LogIn.class.getResource("/Image/Users-Group-icon.png")));
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(37, 93, 146, 51);
		contentPane.add(lblUserName);
		
		userTF = new JTextField();
		userTF.setBackground(new Color(204, 204, 153));
		userTF.setToolTipText("Your User Name\r\n");
		userTF.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 22));
		userTF.setHorizontalAlignment(SwingConstants.CENTER);
		userTF.setBounds(202, 93, 308, 51);
		contentPane.add(userTF);
		userTF.setColumns(10);
		
		JLabel lblBirthYear = new JLabel("Birth Year:");
		lblBirthYear.setIcon(new ImageIcon(LogIn.class.getResource("/Image/calendar-icon.png")));
		lblBirthYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthYear.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBirthYear.setBounds(37, 177, 146, 51);
		contentPane.add(lblBirthYear);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setIcon(new ImageIcon(LogIn.class.getResource("/Image/Very-Basic-Ok-icon.png")));
		btnEnter.setBackground(new Color(204, 204, 204));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userTF.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter Username");
				}
				else if(passTF.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Enter Password");
					}
				else {
				login();
				}
			}
		});
		btnEnter.setToolTipText("Log In");
		btnEnter.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
		btnEnter.setBounds(223, 262, 178, 52);
		contentPane.add(btnEnter);
		
		passTF = new JPasswordField();
		passTF.setBackground(new Color(204, 204, 153));
		passTF.setToolTipText("Your Birth Year");
		passTF.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 23));
		passTF.setHorizontalAlignment(SwingConstants.CENTER);
		passTF.setBounds(202, 177, 308, 51);
		contentPane.add(passTF);
		
		JLabel lblNewPatientFirst = new JLabel("New Patient? First time to Staar? Sign Up");
		lblNewPatientFirst.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPatientFirst.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewPatientFirst.setBounds(110, 337, 321, 22);
		contentPane.add(lblNewPatientFirst);
		
		JButton btnHere = new JButton("Here");
		btnHere.setBackground(new Color(204, 204, 204));
		btnHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp su = new SignUp();
				su.setVisible(true);
				dispose();
			}
		});
		btnHere.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnHere.setToolTipText("Sign Up");
		btnHere.setHorizontalAlignment(SwingConstants.LEADING);
		btnHere.setBounds(432, 337, 78, 23);
		contentPane.add(btnHere);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon(LogIn.class.getResource("/Image/delete-icon.png")));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnExit.setToolTipText("Exit");
		btnExit.setBounds(313, 392, 99, 42);
		contentPane.add(btnExit);
		
		JButton btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(LogIn.class.getResource("/Image/home-icon (1).png")));
		btnHome.setBackground(new Color(204, 204, 204));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home fj = new Home();
				fj.setVisible(true);
				dispose();
			}
		});
		btnHome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnHome.setBounds(208, 392, 107, 42);
		contentPane.add(btnHome);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LogIn.class.getResource("/Image/staarresize - Copy.png")));
		label.setBounds(0, 0, 107, 83);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LogIn.class.getResource("/Image/login.png")));
		lblNewLabel.setBounds(0, 0, 573, 447);
		contentPane.add(lblNewLabel);
	}
}
