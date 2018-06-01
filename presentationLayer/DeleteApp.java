package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import businessLayer.model.Cashier;
import businessLayer.model.Show;
import businessLayer.model.User;
import businessLayer.service.AdminService;
import businessLayer.service.CashierService;
import businessLayer.service.IAdminService;
import businessLayer.service.ICashierService;
import businessLayer.service.IShowService;
import businessLayer.service.IUserService;
import businessLayer.service.ShowService;
import businessLayer.service.UserService;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteApp {

	private JFrame frame;
	private User user = new Cashier();
	private Show show = new Show();
	private IAdminService cs = new AdminService();
	private IShowService ss=new ShowService();

	private boolean cashier;
	private JTextField txtId;
					
	public DeleteApp(boolean cashier) {
		this.cashier=cashier;
		initialize();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtId = new JTextField();
		txtId.setText("Id");
		txtId.setBounds(25, 60, 50, 20);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cashier)
				{
					cs.delete(user);
				}
				else{
					ss.delete(show);
				}
				
			}
		});
		btnDelete.setBounds(30, 149, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(236, 64, 500, 152);
		frame.getContentPane().add(textArea);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cashier)
				{
					
					
					int id = Integer.parseInt(txtId.getText());
				    user = cs.findById(id);
				    textArea.setText(user.toString());
					
				}
				else
				{
					
				    int id = Integer.parseInt(txtId.getText());
					show = ss.findById(id);
					textArea.setText(show.toString());
				}
			}
		});
		btnFind.setBounds(30, 104, 89, 23);
		frame.getContentPane().add(btnFind);
	}
}
