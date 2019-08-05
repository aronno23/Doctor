import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Home extends JFrame {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private Timer tm;
	
	int x = 0;
    //Images Path In Array
    String[] list = {
                      "C:/Users/LENOVO/Desktop/sli1.png",//0
                      "C:/Users/LENOVO/Desktop/sli2.png",//1
                      "C:/Users/LENOVO/Desktop/sli3.png"//2
                      
    };
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
        super("Java SlideShow");
        lblNewLabel = new JLabel();
        lblNewLabel.setBounds(40, 30, 700, 300);

        //Call The Function SetImageSize
        SetImageSize(2);
               //set a timer
        tm = new Timer(2000,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if(x >= list.length )
                    x = 0; 
            }
        });
        getContentPane().add(lblNewLabel);
        tm.start();
        getContentPane().setLayout(null);
        setSize(800, 400);
        getContentPane().setBackground(Color.decode("#bdb67b"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/Image/staarresize - Copy.png")));
		setResizable(false);
		conn = DAPSConnection.ConnecrDb();
		design();
		centerize();
	}
	
	   //create a function to resize the image 
    public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        lblNewLabel.setIcon(newImc);
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
		setTitle("Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1037, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHome = new JLabel("Staar Portal");
		lblHome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setBounds(902, 13, 105, 20);
		contentPane.add(lblHome);
		
		lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setToolTipText("Staar members photos");
		lblNewLabel.setBounds(37, 96, 938, 334);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("LogIn Portal\r\n");
		btnNewButton.setIcon(new ImageIcon(Home.class.getResource("/Image/Users-Enter-2-icon.png")));
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn fj = new LogIn();
				fj.setVisible(true);
				dispose();

			}
		});
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnNewButton.setBounds(37, 443, 150, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SignUp Portal");
		btnNewButton_1.setIcon(new ImageIcon(Home.class.getResource("/Image/Login-in-icon.png")));
		btnNewButton_1.setBackground(new Color(204, 204, 204));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp fj = new SignUp();
				fj.setVisible(true);
				dispose();

			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnNewButton_1.setBounds(185, 443, 159, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Appointment");
		btnNewButton_2.setIcon(new ImageIcon(Home.class.getResource("/Image/Healthcare-Clinic-icon.png")));
		btnNewButton_2.setBackground(new Color(204, 204, 204));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn fj = new LogIn();
				fj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnNewButton_2.setBounds(342, 443, 159, 50);
		contentPane.add(btnNewButton_2);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon(Home.class.getResource("/Image/delete-icon.png")));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnExit.setBounds(825, 443, 150, 50);
		contentPane.add(btnExit);
		
		JTextArea txtrStaar = new JTextArea();
		txtrStaar.setForeground(new Color(0, 0, 0));
		txtrStaar.setBackground(new Color(255, 255, 255));
		txtrStaar.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrStaar.setText("               \r\n             STAAR Founders\r\n-----------------------------------------\r\n    Avijit Roy (CSE DIU 49)\r\n    Mohammad Shoaib (CSE DIU 50)\r\n    Kishoar Jahan Tithee (CSE DIU 50)\r\n    Soumic Ahamed Aronno (CSE DIU 50)\r\n");
		txtrStaar.setBounds(0, 506, 330, 155);
		contentPane.add(txtrStaar);
		
		JTextArea txtrPhoneNo = new JTextArea();
		txtrPhoneNo.setForeground(new Color(0, 0, 0));
		txtrPhoneNo.setBackground(new Color(255, 255, 255));
		txtrPhoneNo.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrPhoneNo.setText("                  \r\n                  Contact\r\n----------------------------------------\r\n                01636456927\r\n                01515220309\r\n                01869232915\r\n                01716760880");
		txtrPhoneNo.setBounds(326, 506, 318, 155);
		contentPane.add(txtrPhoneNo);
		
		JTextArea txtrService = new JTextArea();
		txtrService.setForeground(new Color(0, 0, 0));
		txtrService.setBackground(new Color(255, 255, 255));
		txtrService.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrService.setText("                   \r\n                     Services\r\n-----------------------------------------------\r\n       We Provide 24/7 medical services.\r\n       Our online Appointment System is\r\n    accessed from anywhere in our country.");
		txtrService.setBounds(634, 506, 397, 155);
		contentPane.add(txtrService);
		
		JButton btnTermsConditions = new JButton("Terms & Conditions");
		btnTermsConditions.setIcon(new ImageIcon(Home.class.getResource("/Image/Finance-Purchase-Order-icon (1).png")));
		btnTermsConditions.setBackground(new Color(204, 204, 204));
		btnTermsConditions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Terms_Condition fj = new Terms_Condition();
				fj.setVisible(true);
				dispose();
			}
		});
		btnTermsConditions.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnTermsConditions.setBounds(499, 443, 166, 50);
		contentPane.add(btnTermsConditions);
		
		JButton btnPrivacyPolicy = new JButton("Privacy Policy");
		btnPrivacyPolicy.setIcon(new ImageIcon(Home.class.getResource("/Image/Finance-Purchase-Order-icon.png")));
		btnPrivacyPolicy.setBackground(new Color(204, 204, 204));
		btnPrivacyPolicy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Privacy_Policy fj = new Privacy_Policy();
				fj.setVisible(true);
				dispose();
			}
		});
		btnPrivacyPolicy.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnPrivacyPolicy.setBounds(662, 443, 166, 50);
		contentPane.add(btnPrivacyPolicy);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Home.class.getResource("/Image/staarresize - Copy.png")));
		label.setBounds(0, 0, 107, 83);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/Image/home.png")));
		lblNewLabel_1.setBounds(0, 0, 1031, 661);
		contentPane.add(lblNewLabel_1);
	}
}
