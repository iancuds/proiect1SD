package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import businessLayer.model.User;
import businessLayer.service.IUserService;
import businessLayer.service.UserService;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class TheaterApplication {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheaterApplication window = new TheaterApplication();
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
	public TheaterApplication() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogIn = new JLabel("Log in");
		lblLogIn.setBounds(10, 9, 56, 14);
		frame.getContentPane().add(lblLogIn);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(101, 118, 86, 22);
		frame.getContentPane().add(textArea);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(101, 6, 86, 20);
		txtUsername.setText("username");
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(101, 84, 86, 23);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username, password;
				username=txtUsername.getText();
				
				char[] passwd = passwordField.getPassword();
				password = "";
				for(int i=0; i<passwd.length;i++)
				{
					password = password+passwd[i];
				}
				System.out.println(password);
				User user=null;
				IUserService userServ=new UserService();
				user = userServ.logIn(user, username, password);
				if(user != null)
				{
					textArea.setText("");
					textArea.setText("Logging in...");
					
					if(user.isAdmin()) { 
						
						System.out.println("IS ADMIN");
						AdminWindow adminApp = new AdminWindow();}
					else {CashierWindow cashierApp = new CashierWindow(user);}
					
					
				}
				else {textArea.setText("Wrong username or password");}
	//			System.out.println(user.toString());	
			}
		});
		frame.getContentPane().add(btnLogIn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(101, 37, 86, 20);
		frame.getContentPane().add(passwordField);
		
		
	}
}
