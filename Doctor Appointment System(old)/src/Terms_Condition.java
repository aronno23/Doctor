import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
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

public class Terms_Condition extends JFrame {

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
					Terms_Condition frame = new Terms_Condition();
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
	public Terms_Condition() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Terms_Condition.class.getResource("/Image/staarresize - Copy.png")));
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
	
	private void design(){
		setTitle("Terms & Condition");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1011, 739);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 120, 1003, 469);
		contentPane.add(scrollPane);
		
		JTextPane txtpnTermsAndConditions = new JTextPane();
		txtpnTermsAndConditions.setForeground(new Color(0, 0, 0));
		txtpnTermsAndConditions.setBackground(new Color(255, 153, 0));
		scrollPane.setViewportView(txtpnTermsAndConditions);
		txtpnTermsAndConditions.setFont(new Font("Segoe UI Historic", Font.BOLD, 17));
		txtpnTermsAndConditions.setText("                                                                     Terms and Conditions\r\n-----------------------------------------------------------------------------------------------------------------------\r\n\r\n1. Introduction\r\nUse of this website and the services provided via it are conditional upon you accepting the following terms and conditions. Unless otherwise specified, your acceptance of this User Agreement shall be indicated by your use of and/or registration with CMC Vellore website is provided by Company and its suppliers (\"we\"/\"our\"/\"us\").\r\n\r\n2. Availability of Website\r\nWe will endeavor to ensure that CMC Vellore website is available 24 hours per day without any interruptions. However, we reserve the right to make website unavailable at any time or to restrict access to parts or all of website without notice. CMC Vellore website is a general information service. We will endeavor not to make it misleading, but we cannot represent that the information accessible on or via website is accurate, not-misleading, complete or up to date.\r\n\r\n3. Use of Website\r\nCMC Vellore website is designed for your personal, non-commercial use and you must not use it in any other way without our consent. Except as permitted under applicable law, you must not use, copy, translate, publish, licence or sell or any materials or information in CMC Vellore website or the structure, overall style and program code without our consent. If you have any clarifications regarding this, please contact msoffice@cmcvellore.ac.in\r\n\r\n4. Use of contact details including mobile phone numbers\r\nCMC reserves the right to use any of the contact details provided by you in the processes linked to and encountered with in the discharge of total patient related services sought at in CMC by the patient through all communication modalities including telecommunications, electronic mail and ordinary correspondence.\r\n\r\n5. Your Contributions\r\nYou agree to only use CMC Vellore website for lawful purposes and that any information that you provide in connection with, or which forms part of, website will be, as far as you are aware, true and accurate and will not infringe any copyright or trade mark, or any right of privacy, publicity or personality or any other right, whether registered or unregistered, of any other nature or any person, or be obscene or libellous or blasphemous or defamatory and you agree to indemnify us against all claims, proceedings, damages, liabilities and costs, including legal costs arising out of your breach of this term. We cannot make any assurances about the information or contribution made by any other user and you should exercise caution before acting or otherwise relying upon any information you obtain via the website.\r\n\r\n6. Links\r\nCMC Vellore website includes links to other internet sites. Without limiting what we say elsewhere, we make no representations or warranties about those sites or their content, nor that do those links work.\r\n\r\n7. Data Protection\r\nIt is your responsibility to ensure that that you give us an accurate and valid e-mail address and other contact details and tell us of any changes to them, however we cannot make any assurances about any other user you may meet using the website. CMC will make all reasonable arrangements to ensure the security and protection of the data submitted. However, in the event of loss of information due to unlawful activity of known or unknown persons located in any country or on Indian territory, CMC Vellore is not liable to make any financial or other recompense to the user.\r\n\r\n8. Intellectual property\r\nCMC Vellore website, its style and design, and the materials and information on/of website are protected by copyright and other intellectual property rights, and may not be used by you except as expressly provided in this User Agreement.\r\n\r\n9. Our Liability\r\nSince a substantial part of CMC Vellore website is both free and available to all, it is a condition that your use of website is at your own risk. We shall not be liable to you or in breach of this User Agreement for any delay or failure to perform any obligation if the delay or failure is due to a cause beyond our reasonable control including, without limitation, the blocking or restricting of information to and/or from our network.\r\n\r\nExcept as expressly provided in this User agreement, we disclaim any further representations, warranties, conditions or other terms, express or implied, by statute, collaterally or otherwise, including but not limited to implied warranties, conditions or other terms of satisfactory quality, fitness for a particular purpose or reasonable care and skill.\r\n\r\nSave as provided below, we disclaim all and will not be liable in contract, tort (including, without limitation, negligence) or otherwise arising in connection with this User Agreement or the website for: \r\n(i) consequential, indirect or special loss or damage; or \r\n(ii) any loss of goodwill or reputation; or \r\n(iii) any economic losses (including loss of revenues, profits, contracts, business or anticipated savings), in each case, even if we have been advised of the possibility of such loss or damage and howsoever incurred.\r\n\r\n10. Complaints\r\nIf you believe that your intellectual property or other rights are being infringed by the website, or if you are dissatisfied with website or any aspect of our service, in the first instance please contact: msoffice@cmcvellore.ac.in");
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setIcon(new ImageIcon(Terms_Condition.class.getResource("/Image/home-icon (1).png")));
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home fj = new Home();
				fj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		btnNewButton.setBounds(351, 617, 153, 44);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon(Terms_Condition.class.getResource("/Image/delete-icon.png")));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		btnExit.setBounds(502, 617, 149, 44);
		contentPane.add(btnExit);
		
		JLabel lblTermsCondition = new JLabel("Terms & condition portal");
		lblTermsCondition.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblTermsCondition.setHorizontalAlignment(SwingConstants.CENTER);
		lblTermsCondition.setBounds(800, 13, 203, 22);
		contentPane.add(lblTermsCondition);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Terms_Condition.class.getResource("/Image/staarresize - Copy.png")));
		lblNewLabel.setBounds(0, 0, 107, 83);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Terms_Condition.class.getResource("/Image/ter.png")));
		lblNewLabel_1.setBounds(0, 0, 1005, 704);
		contentPane.add(lblNewLabel_1);
	}

}
