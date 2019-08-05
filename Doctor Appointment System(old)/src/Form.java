import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Form extends JFrame {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	private JPanel contentPane;
	public static JTextArea textArea;
	private JButton btnHome;
	private JButton btnExit;
	private JButton btnPrint;
	private JButton btnPay;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
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
	public Form() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Form.class.getResource("/Image/staarresize - Copy.png")));
		setResizable(false);
		setTitle("Form Page");
		conn = DAPSConnection.ConnecrDb();
		design();
		Selection sc = new Selection();
		textArea.append("                                                                                   Staar\n"
				+ "                                                       ........................................................................\n"
				+ "                                                       ^^^^^^^^^^^^^^^^^^^^^^^^^^\n"
				+ "                          Sobhanbagh (Near Daffodil Tower), West Shukrabad, Dhanmondi, Dhaka.\n\n\n"
				+ "                                                        Patient Name          :      "+sc.pname+"\n"
						+ "                                                          Patient Age           :      "+sc.page+"\n"
								+ "                                                      Doctor Category        :      "+sc.category+"\n"
										+ "                                                   Doctor Department      :      "+sc.dept+"\n"
												+ "                                                         Doctor Name          :      "+sc.doc+"\n"
														+ "                                                    Doctor availability       :      "+sc.avail+"\n"
																+ "                                                                Visit                 :      "+sc.fprice+"\n\n"
																		+ "                             If you want to change your appointment, then contact 01636456927\n"+"                                                         Any imerjency, contact 01515220309\n\n"+"                                                             Thank you for staying with us :)");
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
	
	private void design() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 89, 1036, 492);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(255, 153, 0));
		textArea.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
		scrollPane.setViewportView(textArea);
		
		btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(Form.class.getResource("/Image/home-icon (1).png")));
		btnHome.setBackground(new Color(204, 204, 204));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home fd = new Home();
				fd.setVisible(true);
				dispose();
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHome.setBounds(315, 607, 114, 40);
		contentPane.add(btnHome);
		
		btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon(Form.class.getResource("/Image/delete-icon.png")));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExit.setBounds(427, 607, 114, 40);
		contentPane.add(btnExit);
		
		btnPrint = new JButton("Print");
		btnPrint.setIcon(new ImageIcon(Form.class.getResource("/Image/printer-icon.png")));
		btnPrint.setBackground(new Color(204, 204, 204));
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPrint.setBounds(539, 607, 114, 40);
		contentPane.add(btnPrint);
		
		btnPay = new JButton("Pay");
		btnPay.setIcon(new ImageIcon(Form.class.getResource("/Image/Finance-Card-In-Use-icon.png")));
		btnPay.setBackground(new Color(204, 204, 204));
		btnPay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPay.setBounds(651, 607, 107, 40);
		contentPane.add(btnPay);
		
		JLabel lblFormPortal = new JLabel("Form portal");
		lblFormPortal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblFormPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormPortal.setBounds(899, 13, 119, 22);
		contentPane.add(lblFormPortal);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Form.class.getResource("/Image/staarresize - Copy.png")));
		lblNewLabel.setBounds(0, 0, 107, 83);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Form.class.getResource("/Image/form1.png")));
		lblNewLabel_1.setBounds(0, 0, 1036, 673);
		contentPane.add(lblNewLabel_1);
		
	}
}
