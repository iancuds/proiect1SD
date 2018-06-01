package presentationLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import businessLayer.model.Admin;
import businessLayer.model.Cashier;
import businessLayer.model.Show;
import businessLayer.model.User;
import businessLayer.service.AdminService;
import businessLayer.service.IAdminService;
import businessLayer.service.IShowService;
import businessLayer.service.IUserService;
import businessLayer.service.ShowService;
import businessLayer.service.UserService;

import java.awt.BorderLayout;
import javax.swing.JLabel;

public class UpdateWindow {

	private JFrame frame;
	
	

	public UpdateWindow() {
		
		
		initialize();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		 JTextField txtUsername;
		JTextField txtPassword;
		JTextField txtDateOfBirth;
		JTextField txtAddress;
		JTextField txtPhoneNumber;
		JTextField txtLastName;
		JTextField txtFirstName;
		JTextField txtIdUser;
		
		JTextField txtTitle;
		JTextField txtDistribution;
		JTextField txtNumberTickets;
		JTextField txtDate;
		JTextField txtGenre;
		JTextField txtIdShow;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		txtIdUser = new JTextField();
		txtIdUser.setText("...");
		txtIdUser.setBounds(25, 118, 86, 20);
		frame.getContentPane().add(txtIdUser);
		txtIdUser.setColumns(10);

		txtUsername = new JTextField();
		txtUsername.setText("...");
		txtUsername.setBounds(25, 36, 86, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("...");
		txtPassword.setBounds(121, 87, 86, 20);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtDateOfBirth = new JTextField();
		txtDateOfBirth.setText("...");
		txtDateOfBirth.setBounds(217, 87, 86, 20);
		frame.getContentPane().add(txtDateOfBirth);
		txtDateOfBirth.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setText("...");
		txtAddress.setBounds(316, 36, 86, 20);
		frame.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setText("...");
		txtPhoneNumber.setBounds(25, 87, 86, 20);
		frame.getContentPane().add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setText("...");
		txtLastName.setBounds(217, 36, 86, 20);
		frame.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("...");
		txtFirstName.setBounds(121, 36, 86, 20);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JButton btnCreate = new JButton("Update Cashier");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				User user = new Cashier();
				IUserService us= new UserService();
				IAdminService as = new AdminService();
				
				
				int id = Integer.parseInt(txtIdUser.getText());
				
				
				
				
				user = as.findById(id);
				
				
				if(!(txtFirstName.getText().equals("...")))
				user.setFirstname(txtFirstName.getText());
				
				if(!(txtLastName.getText().equals("...")))
				user.setLastname(txtLastName.getText());
				
				//user.setAdmin(false);
				
				if(!(txtUsername.getText().equals("...")))
				user.setUsername(txtUsername.getText());
				
				if(!(txtDateOfBirth.getText().equals("...")))
				user.setDob(txtDateOfBirth.getText());
				
				if(!(txtAddress.getText().equals("...")))
				user.setAddress(txtAddress.getText());
				
				if(!(txtPhoneNumber.getText().equals("...")))
				user.setPhone(txtPhoneNumber.getText());
			
			
				if(!(txtPassword.getText().equals("..."))){
				String password = us.encryptPassword(txtPassword.getText());
				user.setPasswd(password);}
				
				
				as.update(user, id);
				
				
				
			}
		});
		btnCreate.setBounds(22, 149, 128, 23);
		frame.getContentPane().add(btnCreate);
		
	
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(25, 11, 86, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblFirstName = new JLabel("first name");
		lblFirstName.setBounds(121, 11, 86, 14);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("last name");
		lblLastName.setBounds(217, 11, 46, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblAddress = new JLabel("address");
		lblAddress.setBounds(316, 11, 46, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(25, 67, 86, 14);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(121, 67, 46, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth");
		lblDateOfBirth.setBounds(217, 67, 86, 14);
		frame.getContentPane().add(lblDateOfBirth);
		
	
		
		txtTitle = new JTextField();
		txtTitle.setText("-");
		txtTitle.setBounds(25, 227, 86, 20);
		frame.getContentPane().add(txtTitle);
		txtTitle.setColumns(10);
		
		txtDistribution = new JTextField();
		txtDistribution.setText("-");
		txtDistribution.setBounds(121, 227, 86, 20);
		frame.getContentPane().add(txtDistribution);
		txtDistribution.setColumns(10);
		
		txtNumberTickets = new JTextField();
		txtNumberTickets.setText("-");
		txtNumberTickets.setBounds(217, 227, 89, 20);
		frame.getContentPane().add(txtNumberTickets);
		txtNumberTickets.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setText("-");
		txtDate.setBounds(316, 227, 86, 20);
		frame.getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		txtGenre = new JTextField();
		txtGenre.setText("-");
		txtGenre.setBounds(25, 273, 86, 20);
		frame.getContentPane().add(txtGenre);
		txtGenre.setColumns(10);
		
		txtIdShow = new JTextField();
		txtIdShow.setText("Id show");
		txtIdShow.setBounds(25, 299, 86, 20);
		frame.getContentPane().add(txtIdShow);
		txtIdShow.setColumns(10);
		
		JButton btnUpdateShow = new JButton("Update Show");
		btnUpdateShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(txtIdShow.getText());
				
				Show show = new Show();
				IShowService ss = new ShowService();
				show = ss.findById(id);
				System.out.println(show);
				
				if(!(txtDate.getText().equals("-")))
				show.setDate(txtDate.getText());
				
				if(!(txtDistribution.getText().equals("-")))
				show.setDistribution(txtDistribution.getText());
				
				if(!(txtGenre.getText().equals("-")))
				show.setGenre(txtGenre.getText());
				
				if(!(txtTitle.getText().equals("-")))
				show.setTitle(txtTitle.getText());
				
				if(!(txtNumberTickets.getText().equals("-")))
				show.setNotickets(Integer.parseInt(txtNumberTickets.getText()));
				
				ss.update(show, id);
				
			}
		});
		btnUpdateShow.setBounds(25, 330, 130, 23);
		frame.getContentPane().add(btnUpdateShow);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(25, 207, 46, 14);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblDistribution = new JLabel("Distribution");
		lblDistribution.setBounds(121, 207, 86, 14);
		frame.getContentPane().add(lblDistribution);
		
		JLabel lblNumberOfTickets = new JLabel("Number of Tickets");
		lblNumberOfTickets.setBounds(217, 207, 86, 14);
		frame.getContentPane().add(lblNumberOfTickets);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(25, 258, 46, 14);
		frame.getContentPane().add(lblGenre);
		
		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setBounds(316, 207, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
	
	}
}
