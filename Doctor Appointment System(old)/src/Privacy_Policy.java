import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Privacy_Policy extends JFrame {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Privacy_Policy frame = new Privacy_Policy();
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
	public Privacy_Policy() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Privacy_Policy.class.getResource("/Image/staarresize - Copy.png")));
		setTitle("Privacy Policy Page");
		conn = DAPSConnection.ConnecrDb();
		setResizable(false);
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
	
	private void design(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1031, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 135, 1022, 468);
		contentPane.add(scrollPane);
		
		JTextPane txtpnPrivacyAndSecurity = new JTextPane();
		txtpnPrivacyAndSecurity.setForeground(new Color(0, 0, 0));
		txtpnPrivacyAndSecurity.setBackground(new Color(255, 153, 0));
		scrollPane.setViewportView(txtpnPrivacyAndSecurity);
		txtpnPrivacyAndSecurity.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
		txtpnPrivacyAndSecurity.setText("                                                                     Privacy and Security\r\n----------------------------------------------------------------------------------------------------------------------------\r\n\r\nUsing the Internet-The Choice is Yours\r\nUsing the Internet to communicate with CMC Vellore through www.cmch-vellore.edu is completely voluntary. This statement summarizes our position on various aspects of communicating over the internet .You should read this statement to understand the benefits and risks of using the internet to communicate with CMC Vellore. If you do not choose to communicate with us over the Internet, you may browse our web site anonymously.\r\n\r\nUsing Email\r\nThere are a number of risks you should consider before using email to communicate with us: email can be circulated, forwarded and stored in numerous paper and electronic files; email can be intercepted, altered, forwarded or used without authorization or detection; email senders can easily misaddress an email; backup copies of email may exist even after the sender deletes the email; employers and online services have the right to inspect email transmitted through their systems; email is easier to falsify than handwritten or signed documents; and email can be used to introduce viruses into computer systems. Confidentiality of Internet communications cannot be guaranteed by CMC Vellore. Use of the Internet is solely at your own risk.\r\n\r\nInformation We Collect When you Visit\r\ncmch-vellore.edu Our web server automatically recognizes your domain name. Our web server does not recognize your e-mail address. We may use \"cookies\" to personalize our site for you and to collect aggregate information about site usage by all of our users. A cookie is a text file that our web site transfers to your computer's hard drive for record keeping purposes. We use this information to evaluate and improve our web site. The cookie assigns a random, unique number to your computer. We do not collect any information that can be used to personally identify you unless you voluntarily register as a patient, subscribe to a newsletter, request information, order a product or service, or send an email to us. IF YOU USE OUR ONLINE PATIENT REGISTRATION PROCESS, SUBSCRIBE TO A NEWSLETTER, REQUEST INFORMATION, REQUEST A PRODUCT OR SERVICE, OR SEND US AN E-MAIL, WE WILL HAVE YOUR E-MAIL ADDRESS AT OUR SITE.\r\n\r\nInformation We Collect When You Communicate with Us Over the Internet\r\nCMC Vellore is committed to protecting the privacy of the personal information you provide to us over the Internet. All information is protected by our privacy policies, which we periodically review and update. If you choose to communicate with us over the Internet, we may request personally identifiable information from you necessary for us to process your request for information, respond to your questions or deliver a product or service. Personally identifiable information is any information that can be used to identify you, such as your name, address, web address or medical record number or date of birth. When you send information to us, the information may be shared with our employees and contractors who need to know the information to respond to your request and as permitted by law. We keep some of this information for a period of time as determined necessary by us. Information collected when you respond to surveys and promotions on our web site will be used for internal purposes, including developing web site information and services. We may inform you of new products and services from CMC Vellore based on the information you provide us.\r\n\r\nSecurity\r\nCMC Vellore takes steps to make all information received from our online visitors secure against unauthorized access and use. All information is protected by our security measures, which we periodically review and update. We use security technology to protect you during your Internet communications with us. This security includes server authentication, encryption and data integrity. Your personal information is protected from unauthorized access by a secure firewall and security infrastructure. During transmission of information using Online Patient Registration form, your privacy is protected by Secure Socket Layer (SSL) 128-bit encrypting software. We employ physical, electronic and procedural safeguards to maintain the security of your information.\r\n\r\nLinks To Other Web Sites\r\nWe have links from our web site to a number of different health care related web sites. When you click on one of these links, you leave www.cmch-vellore.edu and link to another web site not controlled by CMC Vellore. We do not control the privacy policies or security measures of any these health care related sites. You should read the privacy statements on the other sites you visit to understand their privacy practices.\r\n\r\nHere's What You Can Do To Protect Your Internet Communications\r\nThere are things you can do to improve the privacy and security of your Internet communications. Do not communicate sensitive or confidential information to us over the Internet from work or Internet cafes. Your employer has the right to inspect your email, co-workers may see the information on a computer screen and you can inadvertently forward the email to co-workers or others. After you submit or receive information online, end your browser session before leaving your computer. This helps preserve the confidentiality of your data by ensuring that you are not leaving personally identifiable information on the computer for those who use the computer after you. This is especially important if you are using a computer in a public area. If you communicate with us over the Internet, tell us when your email address changes.\r\n\r\nChanges to This Statement\r\nWe periodically review and update our privacy policies and security measures. When we do so we may need to change or update this statement and reserve the right to do so. All updates and changes automatically apply to you without notice. If you do not believe that this policy gives you the Internet privacy and security protection you need, you have the ability and right to stop interacting with CMC Vellore over the Internet by exiting this web site now.\r\n\r\nLegal Requirements\r\nAll transactions and information collected in electronic format is governed by the IT Act of 2000 and all its subsequent amendments. The government may time to time amend and modify these laws and CMC Vellore is bound to comply with them for all legal purposes. CMC is legally bound to submit any information requested by the government (National, State or local) in the course of its normal functioning. CMC will report all notifiable diseases to the appropriate designated Authorities.\r\n\r\nData Access\r\nAccess to electronic data in CMC is permitted in a role based controlled manner. Access is password protected and password changes are forced by the system periodically. Breach of confidentiality and sharing of data is strictly prohibited and actionable under CMC\u00E2\u20AC\u2122s own policies and procedures.\r\n\r\nAll permission for access to clinical data is vetted by the Office of the Medical Superintendent and permitted only if they are allowable within the set policies.");
		
		JButton btnNewButton = new JButton("Home\r\n");
		btnNewButton.setIcon(new ImageIcon(Privacy_Policy.class.getResource("/Image/home-icon (1).png")));
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home fj = new Home();
				fj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		btnNewButton.setBounds(377, 616, 146, 37);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon(Privacy_Policy.class.getResource("/Image/delete-icon.png")));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		btnExit.setBounds(521, 616, 146, 37);
		contentPane.add(btnExit);
		
		JLabel lblPrivacyPolicyPortal = new JLabel("Privacy Policy Portal");
		lblPrivacyPolicyPortal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblPrivacyPolicyPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrivacyPolicyPortal.setBounds(856, 13, 166, 22);
		contentPane.add(lblPrivacyPolicyPortal);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Privacy_Policy.class.getResource("/Image/staarresize - Copy.png")));
		lblNewLabel.setBounds(0, 0, 107, 83);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Privacy_Policy.class.getResource("/Image/pri1.png")));
		lblNewLabel_1.setBounds(0, 0, 1025, 662);
		contentPane.add(lblNewLabel_1);
	}

}
