package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import businessLayer.model.Admin;
import businessLayer.model.User;
import businessLayer.service.AdminService;
import businessLayer.service.CashierService;
import businessLayer.service.IAdminService;
import businessLayer.service.ICashierService;
import businessLayer.service.IUserService;
import businessLayer.service.UserService;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewCashier {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtDateOfBirth;
	private JTextField txtAddress;
	private JTextField txtPhoneNumber;
	private JTextField txtLastName;
	private JTextField txtFirstName;



	public NewCashier() {
		
		initialize();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("New Cashier");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setText("username");
		txtUsername.setBounds(25, 22, 86, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("password");
		txtPassword.setBounds(121, 53, 86, 20);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtDateOfBirth = new JTextField();
		txtDateOfBirth.setText("date of birth");
		txtDateOfBirth.setBounds(217, 53, 86, 20);
		frame.getContentPane().add(txtDateOfBirth);
		txtDateOfBirth.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setText("address");
		txtAddress.setBounds(316, 22, 86, 20);
		frame.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setText("phone number");
		txtPhoneNumber.setBounds(25, 53, 86, 20);
		frame.getContentPane().add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setText("last name");
		txtLastName.setBounds(217, 22, 86, 20);
		frame.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("first name");
		txtFirstName.setBounds(121, 22, 86, 20);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				User user = new Admin();
				IUserService us= new UserService();
				IAdminService as = new AdminService();
				user.setFirstname(txtFirstName.getText());
				user.setLastname(txtLastName.getText());
				user.setAdmin(false);
				user.setUsername(txtUsername.getText());
				user.setDob(txtDateOfBirth.getText());
				user.setAddress(txtAddress.getText());
				user.setPhone(txtPhoneNumber.getText());
			
				
			
				
				String password = us.encryptPassword(txtPassword.getText());
				user.setPasswd(password);
				as.create(user, 0);
				
				
				
			}
		});
		btnCreate.setBounds(22, 118, 89, 23);
		frame.getContentPane().add(btnCreate);
		
		
	}

}
 
