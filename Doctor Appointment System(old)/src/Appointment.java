import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Appointment extends JFrame {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	private JPanel contentPane;
	private JLabel lblName, lblAge_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointment frame = new Appointment();
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
	public Appointment() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Appointment.class.getResource("/Image/staarresize - Copy.png")));
		conn = DAPSConnection.ConnecrDb();
		setTitle("Appointment Page");
		LogIn lo = new LogIn();
		JOptionPane.showMessageDialog(null, "Welcome "+lo.welcomeName);
		design();
		getUserInfo();
		setResizable(false);
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
	
	private void getUserInfo() {
		try {
			String query = "select Patient_Name,Date_of_Birth,Birth_Year from patient WHERE User_ID='"+Data.User_ID+"'";
			System.out.println(query);
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				lblName.setText(rs.getString("Patient_Name"));
				int age = 2019-Integer.parseInt(rs.getString("Birth_Year"));
				lblAge_1.setText(String.valueOf(age));

			}
			pst.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void design(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1039, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Appointment Portal");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel.setBounds(876, 13, 145, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnBook = new JButton("");
		btnBook.setIcon(new ImageIcon(Appointment.class.getResource("/Image/Hand-Touch-2-icon (1).png")));
		btnBook.setBackground(new Color(204, 204, 204));
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GItoBOAp fj = new GItoBOAp();
				fj.setVisible(true);
				dispose();
			}
		});
		btnBook.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 30));
		btnBook.setBounds(383, 257, 254, 214);
		contentPane.add(btnBook);
		
		JLabel lblClickBookFor = new JLabel("Click this button for book an Appointment");
		lblClickBookFor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClickBookFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblClickBookFor.setBounds(354, 208, 317, 36);
		contentPane.add(lblClickBookFor);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon(Appointment.class.getResource("/Image/delete-icon.png")));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnExit.setBounds(509, 527, 128, 46);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("Patient :\r\n");
		lblNewLabel_1.setIcon(new ImageIcon(Appointment.class.getResource("/Image/Users-Group-icon.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(62, 129, 121, 46);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setIcon(new ImageIcon(Appointment.class.getResource("/Image/Users-Age-icon.png")));
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setBounds(571, 129, 121, 46);
		contentPane.add(lblAge);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Segoe UI Historic", Font.BOLD, 24));
		lblName.setBounds(195, 131, 317, 36);
		contentPane.add(lblName);
		
		lblAge_1 = new JLabel("Age");
		lblAge_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 24));
		lblAge_1.setBounds(704, 131, 145, 36);
		contentPane.add(lblAge_1);
		
		JButton btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(Appointment.class.getResource("/Image/home-icon (1).png")));
		btnHome.setBackground(new Color(204, 204, 204));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home fj = new Home();
				fj.setVisible(true);
				dispose();
			}
		});
		btnHome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnHome.setBounds(383, 527, 128, 46);
		contentPane.add(btnHome);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Appointment.class.getResource("/Image/staarresize - Copy.png")));
		lblNewLabel_2.setBounds(0, 0, 107, 83);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Appointment.class.getResource("/Image/appointment1.png")));
		lblNewLabel_3.setBounds(0, 0, 1033, 659);
		contentPane.add(lblNewLabel_3);
		
	}
}
