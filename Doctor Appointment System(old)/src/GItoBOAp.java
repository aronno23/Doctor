import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class GItoBOAp extends JFrame {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	private JPanel contentPane;
	private JCheckBox checkBox;
	private JLabel lblName, lblAge_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GItoBOAp frame = new GItoBOAp();
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
	public GItoBOAp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GItoBOAp.class.getResource("/Image/staarresize - Copy.png")));
		setResizable(false);
		setTitle("General Instructions for booking an appointment");
		design();
		conn = DAPSConnection.ConnecrDb();
		getUserInfo();
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
	
	private void proceed() {
		Selection fj = new Selection();
		fj.setVisible(true);
		dispose();
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
		setBounds(100, 100, 999, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 158, 989, 379);
		contentPane.add(scrollPane);
		
		JTextPane txtpnGeneralInstructionsTo = new JTextPane();
		txtpnGeneralInstructionsTo.setForeground(new Color(0, 0, 0));
		txtpnGeneralInstructionsTo.setBackground(new Color(255, 153, 0));
		scrollPane.setViewportView(txtpnGeneralInstructionsTo);
		txtpnGeneralInstructionsTo.setFont(new Font("Segoe UI Historic", Font.PLAIN, 17));
		txtpnGeneralInstructionsTo.setText("                                                               General instructions to book online appointments\r\n-----------------------------------------------------------------------------------------------------------------------------------------\r\n\r\n1. Appointment booked online will not be refunded.\r\n\r\n2. Change of Department/Unit not allowed.\r\n\r\n3. Change in appointment date will be allowed only once, upto one day prior to the appointment date.\r\n\r\n4. Please provide atleast Government Related ID proof when you present yourself at the Entrance / MRO counter.\r\n\r\n5. Request for appointments via post / phone will not be accepted.\r\n\r\n6. Demand Drafts will only be accepted at cash counters, not via post.\r\n\r\n7. Please note, that as per Income tax regulation (U/s 269ST & 271DA), we cannot receive Rs 2 Lakhs and above in cash per day. Hence any amount above this remitted for your treatment will have to be paid by DD/Net Banking/Debit card/Credit card.");
		
		checkBox = new JCheckBox(" I HAVE READ AND AGREED TO THE TERMS AND CONDITIONS");
		checkBox.setFont(new Font("Tahoma", Font.BOLD, 17));
		checkBox.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox.setBounds(225, 546, 564, 32);
		contentPane.add(checkBox);
		
		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.setIcon(new ImageIcon(GItoBOAp.class.getResource("/Image/Very-Basic-Ok-icon.png")));
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox.isSelected())
				{
					proceed();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Agree with our Terms & Conditions");
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnNewButton.setBounds(438, 585, 137, 46);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon(GItoBOAp.class.getResource("/Image/delete-icon.png")));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnExit.setBounds(573, 585, 137, 46);
		contentPane.add(btnExit);
		
		JLabel lblPatient = new JLabel("Patient :");
		lblPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatient.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPatient.setBounds(212, 119, 82, 22);
		contentPane.add(lblPatient);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setBounds(641, 123, 69, 22);
		contentPane.add(lblAge);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Segoe UI Historic", Font.BOLD, 24));
		lblName.setBounds(306, 109, 323, 36);
		contentPane.add(lblName);
		
		lblAge_1 = new JLabel("Age");
		lblAge_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 24));
		lblAge_1.setBounds(722, 113, 118, 36);
		contentPane.add(lblAge_1);
		
		JButton btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(GItoBOAp.class.getResource("/Image/home-icon (1).png")));
		btnHome.setBackground(new Color(204, 204, 204));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home fg = new Home();
				fg.setVisible(true);
				dispose();
			}
		});
		btnHome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnHome.setBounds(303, 585, 137, 46);
		contentPane.add(btnHome);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GItoBOAp.class.getResource("/Image/staarresize - Copy.png")));
		lblNewLabel.setBounds(0, 0, 107, 83);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(GItoBOAp.class.getResource("/Image/gi1.png")));
		lblNewLabel_1.setBounds(0, 0, 993, 668);
		contentPane.add(lblNewLabel_1);
	}
}
