import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;



public class SignUp extends JFrame {

	private JPanel contentPane;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	private JTextField nameTF;
	private JTextField birthTF;
	private JTextField nationTF;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField reliTF;
	private JTextField attenTF;
	private JTextField userTF;
	private JTextField passTF;
	private JTextField contactTF;
	private JTextField emailTF;
	private JTextField areaTF;
	private JRadioButton rdbtnFemale, rdbtnMale;
	private JComboBox comboBox_1 , comboBox_2 , comboBox_3;
	private JCheckBox chckbxIEnteredAll;
	
	String v = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/Image/staarresize - Copy.png")));
		design();
		centerize();
		conn = DAPSConnection.ConnecrDb();
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
	
	private void register()
	{
		try {
			String query = "INSERT INTO patient (Patient_Name,Date_of_Birth,Nationality,Gender,Marital_Status,Religion,Attendent_Name,Relation_with_attendent,User_ID,Birth_Year,Mobile_No,Email_ID,Country,Division_Area_Street) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pst = conn.prepareStatement(query);
			pst.setString(1, nameTF.getText());
			pst.setString(2, birthTF.getText());
			pst.setString(3, nationTF.getText());
			if(rdbtnMale.isSelected()) {
				v = rdbtnMale.getText().toString();
			}
			else if(rdbtnFemale.isSelected()) {
				v = rdbtnFemale.getText().toString();
			}
			else {
				JOptionPane.showMessageDialog(null, "Select Gender");
			}
			pst.setString(4, String.valueOf(v));
			pst.setString(5, comboBox_1.getSelectedItem().toString());
			pst.setString(6, reliTF.getText());
			pst.setString(7, attenTF.getText());
			pst.setString(8, comboBox_2.getSelectedItem().toString());
			pst.setString(9, userTF.getText());
			pst.setString(10, passTF.getText());
			pst.setString(11, contactTF.getText());
			pst.setString(12, emailTF.getText());
			pst.setString(13, comboBox_3.getSelectedItem().toString());
			pst.setString(14, areaTF.getText());
			
			pst.execute();
			pst.close();
			
			JOptionPane.showMessageDialog(null, "SignUp Succesful");
			
			LogIn fj = new LogIn();
			fj.setVisible(true);
			dispose();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void design() {
		setTitle("SignUp Page");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1036, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSignupPortal = new JLabel("Patient SignUp Portal");
		lblSignupPortal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblSignupPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignupPortal.setBounds(862, 13, 156, 28);
		contentPane.add(lblSignupPortal);
		
		JLabel lblPatientName = new JLabel("Patient Name:");
		lblPatientName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPatientName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientName.setBounds(209, 124, 107, 17);
		contentPane.add(lblPatientName);
		
		nameTF = new JTextField();
		nameTF.setBackground(new Color(204, 204, 153));
		nameTF.setToolTipText("Name");
		nameTF.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 17));
		nameTF.setHorizontalAlignment(SwingConstants.CENTER);
		nameTF.setBounds(319, 119, 177, 28);
		contentPane.add(nameTF);
		nameTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Date of Birth:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(547, 125, 107, 17);
		contentPane.add(lblNewLabel);
		
		birthTF = new JTextField();
		birthTF.setBackground(new Color(204, 204, 153));
		birthTF.setToolTipText("Patient's Date of Birth");
		birthTF.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 17));
		birthTF.setHorizontalAlignment(SwingConstants.CENTER);
		birthTF.setBounds(655, 119, 177, 28);
		contentPane.add(birthTF);
		birthTF.setColumns(10);
		
		JLabel lblNationality = new JLabel("Nationality:");
		lblNationality.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNationality.setHorizontalAlignment(SwingConstants.CENTER);
		lblNationality.setBounds(111, 182, 91, 17);
		contentPane.add(lblNationality);
		
		nationTF = new JTextField();
		nationTF.setBackground(new Color(204, 204, 153));
		nationTF.setToolTipText("Patient's Nationality");
		nationTF.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 17));
		nationTF.setHorizontalAlignment(SwingConstants.CENTER);
		nationTF.setBounds(209, 177, 177, 28);
		contentPane.add(nationTF);
		nationTF.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setBounds(388, 183, 83, 17);
		contentPane.add(lblGender);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(255, 102, 0));
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnMale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMale.setBounds(466, 182, 71, 21);
		contentPane.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(255, 102, 0));
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnFemale.setBounds(537, 182, 91, 21);
		contentPane.add(rdbtnFemale);
		
		JLabel lblMaritalStatus = new JLabel("Marital Status:");
		lblMaritalStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaritalStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaritalStatus.setBounds(636, 182, 113, 17);
		contentPane.add(lblMaritalStatus);
		
		JLabel lblReligion = new JLabel("Religion:");
		lblReligion.setHorizontalAlignment(SwingConstants.CENTER);
		lblReligion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReligion.setBounds(98, 243, 76, 17);
		contentPane.add(lblReligion);
		
		reliTF = new JTextField();
		reliTF.setBackground(new Color(204, 204, 153));
		reliTF.setToolTipText("Patient's Religion");
		reliTF.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 17));
		reliTF.setHorizontalAlignment(SwingConstants.CENTER);
		reliTF.setBounds(175, 240, 177, 28);
		contentPane.add(reliTF);
		reliTF.setColumns(10);
		
		JLabel lblAttendentNameifAny = new JLabel("Attendent Name(if any):\r\n");
		lblAttendentNameifAny.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttendentNameifAny.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAttendentNameifAny.setBounds(354, 243, 189, 17);
		contentPane.add(lblAttendentNameifAny);
		
		attenTF = new JTextField();
		attenTF.setBackground(new Color(204, 204, 153));
		attenTF.setToolTipText("Patient's any attendent");
		attenTF.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 17));
		attenTF.setHorizontalAlignment(SwingConstants.CENTER);
		attenTF.setBounds(547, 240, 177, 28);
		contentPane.add(attenTF);
		attenTF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Relation:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(729, 243, 69, 17);
		contentPane.add(lblNewLabel_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBackground(new Color(204, 204, 204));
		comboBox_2.setToolTipText("Attendent relation with Patient");
		comboBox_2.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 17));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"--Select Relation--", "Father", "Mother", "Husband", "Wife", "Brother", "Sister", "Son", "Daughter"}));
		comboBox_2.setBounds(810, 240, 156, 28);
		contentPane.add(comboBox_2);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(98, 299, 91, 17);
		contentPane.add(lblUserName);
		
		userTF = new JTextField();
		userTF.setBackground(new Color(204, 204, 153));
		userTF.setToolTipText("Any username for Log In");
		userTF.setHorizontalAlignment(SwingConstants.CENTER);
		userTF.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 17));
		userTF.setBounds(192, 296, 177, 28);
		contentPane.add(userTF);
		userTF.setColumns(10);
		
		JLabel lblBirthYear = new JLabel("Birth Year:");
		lblBirthYear.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBirthYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthYear.setBounds(388, 299, 91, 17);
		contentPane.add(lblBirthYear);
		
		passTF = new JTextField();
		passTF.setBackground(new Color(204, 204, 153));
		passTF.setToolTipText("Birth Year as password");
		passTF.setHorizontalAlignment(SwingConstants.CENTER);
		passTF.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 17));
		passTF.setBounds(481, 296, 177, 28);
		contentPane.add(passTF);
		passTF.setColumns(10);
		
		JLabel lblContactNo = new JLabel("Contact No:");
		lblContactNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContactNo.setBounds(668, 299, 91, 17);
		contentPane.add(lblContactNo);
		
		contactTF = new JTextField();
		contactTF.setBackground(new Color(204, 204, 153));
		contactTF.setToolTipText("Any phone no for contacting ");
		contactTF.setHorizontalAlignment(SwingConstants.CENTER);
		contactTF.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 17));
		contactTF.setBounds(759, 296, 177, 28);
		contentPane.add(contactTF);
		contactTF.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Email ID:");
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmailId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailId.setBounds(282, 355, 83, 17);
		contentPane.add(lblEmailId);
		
		emailTF = new JTextField();
		emailTF.setBackground(new Color(204, 204, 153));
		emailTF.setToolTipText("Email ID");
		emailTF.setHorizontalAlignment(SwingConstants.CENTER);
		emailTF.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 17));
		emailTF.setBounds(375, 352, 363, 28);
		contentPane.add(emailTF);
		emailTF.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setHorizontalAlignment(SwingConstants.CENTER);
		lblCountry.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCountry.setBounds(282, 404, 83, 17);
		contentPane.add(lblCountry);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBackground(new Color(204, 204, 204));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"--Select Country--", "Bangladesh", "India", "Pakistan", "SriLanka", "Nepal", "Bhutan", "Afghanistan", "Myanmar", "Japan", "North Korea", "South Korea", "China", "Singa Pore", "Malayasia"}));
		comboBox_3.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 17));
		comboBox_3.setBounds(375, 400, 363, 28);
		contentPane.add(comboBox_3);
		
		JLabel lblAreastreet = new JLabel("Area/Street:");
		lblAreastreet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAreastreet.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreastreet.setBounds(258, 454, 107, 17);
		contentPane.add(lblAreastreet);
		
		areaTF = new JTextField();
		areaTF.setBackground(new Color(204, 204, 153));
		areaTF.setToolTipText("Address");
		areaTF.setHorizontalAlignment(SwingConstants.CENTER);
		areaTF.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 17));
		areaTF.setBounds(375, 451, 363, 28);
		contentPane.add(areaTF);
		areaTF.setColumns(10);
		
		chckbxIEnteredAll = new JCheckBox("I entered all the information correctly & I agreed to");
		chckbxIEnteredAll.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxIEnteredAll.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxIEnteredAll.setBounds(190, 508, 413, 17);
		contentPane.add(chckbxIEnteredAll);
		
		JButton btnAllTerms = new JButton("all terms & conditions");
		btnAllTerms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Terms_Condition fg = new Terms_Condition();
				fg.setVisible(true);
				dispose();
			}
		});
		btnAllTerms.setBackground(new Color(204, 204, 204));
		btnAllTerms.setToolTipText("Terms & Conditions");
		btnAllTerms.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnAllTerms.setHorizontalAlignment(SwingConstants.LEADING);
		btnAllTerms.setBounds(603, 507, 196, 22);
		contentPane.add(btnAllTerms);
		
		JButton btnResgister = new JButton("Register");
		btnResgister.setIcon(new ImageIcon(SignUp.class.getResource("/Image/Very-Basic-Ok-icon.png")));
		btnResgister.setBackground(new Color(204, 204, 204));
		btnResgister.setToolTipText("Go to Log In page by clicking register button");
		btnResgister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxIEnteredAll.isSelected())
				{
					register();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "To REGISTER you have to agree with our Terms & Conditions");
				}
			}
		});
		btnResgister.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnResgister.setBounds(464, 559, 134, 50);
		contentPane.add(btnResgister);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon(SignUp.class.getResource("/Image/delete-icon.png")));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnExit.setBounds(596, 559, 143, 50);
		contentPane.add(btnExit);
		
		JLabel lblAlreadyHaveAn = new JLabel("Already have an account?? Log In");
		lblAlreadyHaveAn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAlreadyHaveAn.setBounds(364, 622, 251, 17);
		contentPane.add(lblAlreadyHaveAn);
		
		JButton btnHere = new JButton("Here");
		btnHere.setBackground(new Color(204, 204, 204));
		btnHere.setToolTipText("Log In Page");
		btnHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn su = new LogIn();
				su.setVisible(true);
				dispose();
			}
		});
		btnHere.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnHere.setBounds(620, 620, 87, 23);
		contentPane.add(btnHere);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(204, 204, 204));
		comboBox_1.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 17));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Married", "Unmarried"}));
		comboBox_1.setBounds(746, 177, 177, 28);
		contentPane.add(comboBox_1);
		
		JButton btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(SignUp.class.getResource("/Image/home-icon (1).png")));
		btnHome.setBackground(new Color(204, 204, 204));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home fj = new Home();
				fj.setVisible(true);
				dispose();

			}
		});
		btnHome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnHome.setBounds(338, 559, 128, 50);
		contentPane.add(btnHome);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SignUp.class.getResource("/Image/staarresize - Copy.png")));
		lblNewLabel_2.setBounds(0, 0, 107, 83);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(SignUp.class.getResource("/Image/sign.png")));
		lblNewLabel_3.setBounds(0, 0, 1030, 656);
		contentPane.add(lblNewLabel_3);
	}
}
