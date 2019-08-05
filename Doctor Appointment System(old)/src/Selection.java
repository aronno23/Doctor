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

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Selection extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JPanel contentPane;
	private JComboBox deptCombo;
	private JComboBox docCombo;
	private JComboBox availability;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnGeneral;
	private JRadioButton rdbtnPrivate;
	private String v = "";
	private JLabel lblName;
	private JLabel lblAge_1;
	private JLabel lblPrice, lblPrice2, lblPrice1, lblCategory1;
	private JCheckBox chckbxAreYouContinue;

	public static String pname = "";
	public static String page = "";
	public static String fprice = "";
	public static String category = "";
	public static String dept = "";
	public static String doc = "";
	public static String avail = "";
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Selection frame = new Selection();
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
	public Selection() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Selection.class.getResource("/Image/staarresize - Copy.png")));
		design();
		conn = DAPSConnection.ConnecrDb();
		getUserInfo();
		centerize();
	}

	public void centerize() {
		Dimension screenSize, frameSize;
		int x, y;
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameSize = getSize();
		x = (screenSize.width - frameSize.width) / 2;
		y = (screenSize.height - frameSize.height) / 2;
		setLocation(x, y);
	}

	private void getDoctorAvaiability() {

		try {
			String query = "select 	Availability from doctor WHERE Doctor_Name = '"
					+ docCombo.getSelectedItem().toString() + "' ";

			// System.out.println(query);
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			availability.removeAllItems();
			while (rs.next()) {
				availability.addItem(rs.getString("Availability"));
			}
			pst.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getPrivateDocCategory() {
		try {
			String query = "select Distinct Department from doctor WHERE Category = 'PRIVATE' ";
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				deptCombo.addItem(rs.getString("Department"));
			}
			pst.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getUserInfo() {
		try {
			String query = "select Patient_Name,Date_of_Birth,Birth_Year from patient WHERE User_ID='" + Data.User_ID
					+ "'";

			// System.out.println(query);
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				lblName.setText(rs.getString("Patient_Name"));
				int age = 2019 - Integer.parseInt(rs.getString("Birth_Year"));
				lblAge_1.setText(String.valueOf(age));

			}
			pst.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getGeneralDocCategory() {
		try {
			String query = "select Distinct Department from doctor WHERE Category = 'GENERAL' ";
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				deptCombo.addItem(rs.getString("Department"));
			}
			pst.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getDocName() {
		try {

			docCombo.setModel(new DefaultComboBoxModel(new String[] { "-" }));
			String query = "select DISTINCT DOCTOR_NAME from Doctor where Department = '"
					+ deptCombo.getSelectedItem().toString() + "' and category = '" + v + "'";
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				docCombo.addItem(rs.getString("DOCTOR_NAME"));
			}
			pst.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getPrice600() {
		try {
			String query = "select Price FROM doctor WHERE Category='PRIVATE'";

			// System.out.println(query);
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				lblPrice.setText(rs.getString("Price"));
				lblPrice2.setText(rs.getString("Price"));

			}
			pst.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getPrice300() {
		try {
			String query = "select Price FROM doctor WHERE Category='GENERAL'";

			// System.out.println(query);
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				lblPrice.setText(rs.getString("Price"));
				lblPrice2.setText(rs.getString("Price"));

			}
			pst.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getCategory600() {
		try {
			String query = "select Category FROM doctor WHERE Price='600'";

			// System.out.println(query);
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				lblCategory1.setText(rs.getString("Category"));

			}
			pst.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getCategory300() {
		try {
			String query = "select Category FROM doctor WHERE Price='300'";

			// System.out.println(query);
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				lblCategory1.setText(rs.getString("Category"));

			}
			pst.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void book() {
		try {
			String query = "INSERT INTO doctor_patient_portal (Patient_name,Patient_age,Doctor_category,Doctor_dept,Doctor_name,Doctor_availability,Visit) VALUES (?,?,?,?,?,?,?)";

			pst = conn.prepareStatement(query);
			pst.setString(1, pname = lblName.getText());
			pst.setString(2, page = lblAge_1.getText());
			if (rdbtnGeneral.isSelected()) {
				v = rdbtnGeneral.getText().toString();
			} else if (rdbtnPrivate.isSelected()) {
				v = rdbtnPrivate.getText().toString();
			} else {
				JOptionPane.showMessageDialog(null, "Select Doctor Category");
			}
			pst.setString(3, category = String.valueOf(v));
			pst.setString(4, dept = deptCombo.getSelectedItem().toString());
			pst.setString(5, doc = docCombo.getSelectedItem().toString());
			pst.setString(6, avail = availability.getSelectedItem().toString());
			pst.setString(7, fprice = lblPrice.getText());

			pst.execute();
			pst.close();

			
			JOptionPane.showMessageDialog(null, "Booking Complete");
			Form f = new Form();
			f.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void design() {
		setTitle("Selection Page");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSelectionPortal = new JLabel("Doctor Selection Portal");
		lblSelectionPortal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblSelectionPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectionPortal.setBounds(838, 13, 184, 26);
		contentPane.add(lblSelectionPortal);

		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setBounds(270, 174, 117, 26);
		contentPane.add(lblCategory);

		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDepartment.setBounds(273, 252, 117, 26);
		contentPane.add(lblDepartment);

		deptCombo = new JComboBox();
		deptCombo.setBackground(new Color(204, 204, 204));
		deptCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getDocName();
			}
		});
		deptCombo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// getDocName();
			}
		});
		deptCombo.setModel(new DefaultComboBoxModel(new String[] { "--Select Department--" }));
		deptCombo.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 17));
		deptCombo.setBounds(476, 244, 295, 42);
		contentPane.add(deptCombo);

		JButton btnNewButton = new JButton("Book");
		btnNewButton.setIcon(new ImageIcon(Selection.class.getResource("/Image/Very-Basic-Ok-icon.png")));
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxAreYouContinue.isSelected()) {
					book();
				} else {
					JOptionPane.showMessageDialog(null, "Click checkmark to continue");
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		btnNewButton.setBounds(441, 606, 156, 42);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setIcon(new ImageIcon(Selection.class.getResource("/Image/home-icon (1).png")));
		btnNewButton_1.setBackground(new Color(204, 204, 204));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home fj = new Home();
				fj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		btnNewButton_1.setBounds(296, 606, 149, 42);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setIcon(new ImageIcon(Selection.class.getResource("/Image/delete-icon.png")));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		btnNewButton_2.setBounds(593, 606, 149, 42);
		contentPane.add(btnNewButton_2);

		JLabel lblDoctorName = new JLabel("Doctor Name:");
		lblDoctorName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDoctorName.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorName.setBounds(257, 338, 142, 26);
		contentPane.add(lblDoctorName);

		docCombo = new JComboBox();
		docCombo.setBackground(new Color(204, 204, 204));
		docCombo.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 17));
		docCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDoctorAvaiability();
			}
		});
		docCombo.setModel(new DefaultComboBoxModel(new String[] { "--Select Doctor--" }));
		docCombo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// getDoctorAvaiability();
			}
		});
		docCombo.setBounds(476, 330, 295, 42);
		contentPane.add(docCombo);

		JLabel lblAvailability = new JLabel("Availability:");
		lblAvailability.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAvailability.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailability.setBounds(273, 422, 117, 26);
		contentPane.add(lblAvailability);

		JLabel lblPatient = new JLabel("Patient :");
		lblPatient.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatient.setBounds(134, 107, 82, 22);
		contentPane.add(lblPatient);

		JLabel lblAge = new JLabel("Age :");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAge.setBounds(711, 107, 82, 22);
		contentPane.add(lblAge);

		rdbtnGeneral = new JRadioButton("General");
		rdbtnGeneral.setBackground(new Color(255, 153, 0));
		rdbtnGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v = rdbtnGeneral.getText().toString();
			}
		});
		rdbtnGeneral.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deptCombo.setModel(new DefaultComboBoxModel(new String[] { "-" }));

				getGeneralDocCategory();
				getPrice300();
				getCategory300();

				v = rdbtnGeneral.getText().toString();
			}
		});
		buttonGroup.add(rdbtnGeneral);
		rdbtnGeneral.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 24));
		rdbtnGeneral.setBounds(473, 177, 149, 25);
		contentPane.add(rdbtnGeneral);

		rdbtnPrivate = new JRadioButton("Private");
		rdbtnPrivate.setBackground(new Color(255, 153, 0));
		rdbtnPrivate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v = rdbtnPrivate.getText().toString();
			}
		});
		rdbtnPrivate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deptCombo.setModel(new DefaultComboBoxModel(new String[] { "-" }));

				getPrivateDocCategory();
				getPrice600();
				getCategory600();
				v = rdbtnPrivate.getText().toString();
			}
		});
		buttonGroup.add(rdbtnPrivate);
		rdbtnPrivate.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 24));
		rdbtnPrivate.setBounds(619, 177, 149, 25);
		contentPane.add(rdbtnPrivate);

		availability = new JComboBox();
		availability.setBackground(new Color(204, 204, 204));
		availability.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 17));
		availability.setModel(new DefaultComboBoxModel(new String[] { "--Select Availability--" }));
		availability.setBounds(476, 416, 295, 42);
		contentPane.add(availability);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Segoe UI Historic", Font.BOLD, 24));
		lblName.setBounds(241, 97, 319, 36);
		contentPane.add(lblName);

		lblAge_1 = new JLabel("Age");
		lblAge_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 24));
		lblAge_1.setBounds(793, 97, 156, 36);
		contentPane.add(lblAge_1);

		lblPrice1 = new JLabel("Visit:");
		lblPrice1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPrice1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice1.setBounds(268, 494, 117, 26);
		contentPane.add(lblPrice1);

		lblPrice = new JLabel("");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblPrice.setBounds(471, 494, 142, 26);
		contentPane.add(lblPrice);

		lblCategory1 = new JLabel("");
		lblCategory1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblCategory1.setBounds(253, 543, 98, 33);
		contentPane.add(lblCategory1);

		JLabel lblCategoryForIf = new JLabel("Category doctor for");
		lblCategoryForIf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCategoryForIf.setBounds(352, 547, 175, 26);
		contentPane.add(lblCategoryForIf);

		lblPrice2 = new JLabel("");
		lblPrice2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblPrice2.setBounds(529, 547, 60, 26);
		contentPane.add(lblPrice2);

		JLabel lblTakaIfNo = new JLabel("taka? If no, then change Category right now ^");
		lblTakaIfNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTakaIfNo.setBounds(578, 548, 422, 26);
		contentPane.add(lblTakaIfNo);

		JLabel lblTaka = new JLabel("Taka/-");
		lblTaka.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTaka.setBounds(625, 494, 117, 26);
		contentPane.add(lblTaka);

		chckbxAreYouContinue = new JCheckBox("Are you continue with");
		chckbxAreYouContinue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxAreYouContinue.setBounds(33, 546, 224, 26);
		contentPane.add(chckbxAreYouContinue);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Selection.class.getResource("/Image/staarresize - Copy.png")));
		lblNewLabel.setBounds(0, 0, 107, 83);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Selection.class.getResource("/Image/sele.png")));
		lblNewLabel_1.setBounds(0, 0, 1034, 662);
		contentPane.add(lblNewLabel_1);
	}
}
