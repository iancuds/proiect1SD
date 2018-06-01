package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import businessLayer.model.Show;
import businessLayer.service.IShowService;
import businessLayer.service.ShowService;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewShow {

	private JFrame frame;
	private JTextField txtTitle;
	private JTextField txtDistribution;
	private JTextField txtNumberTickets;
	private JTextField txtDate;
	private JTextField txtGenre;

	


	public NewShow() {
		initialize();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtTitle = new JTextField();
		txtTitle.setText("title");
		txtTitle.setBounds(10, 11, 86, 20);
		frame.getContentPane().add(txtTitle);
		txtTitle.setColumns(10);
		
		txtDistribution = new JTextField();
		txtDistribution.setText("distribution");
		txtDistribution.setBounds(117, 11, 86, 20);
		frame.getContentPane().add(txtDistribution);
		txtDistribution.setColumns(10);
		
		txtNumberTickets = new JTextField();
		txtNumberTickets.setText("number Tickets");
		txtNumberTickets.setBounds(10, 69, 86, 20);
		frame.getContentPane().add(txtNumberTickets);
		txtNumberTickets.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setText("date");
		txtDate.setBounds(224, 11, 86, 20);
		frame.getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		txtGenre = new JTextField();
		txtGenre.setText("genre");
		txtGenre.setBounds(10, 42, 86, 20);
		frame.getContentPane().add(txtGenre);
		txtGenre.setColumns(10);
		
		JButton btnAddShow = new JButton("Add show");
		btnAddShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Show show = new Show();
				IShowService ss = new ShowService();
				
				show.setDate(txtDate.getText());
				show.setDistribution(txtDistribution.getText());
				show.setGenre(txtGenre.getText());
				show.setTitle(txtTitle.getText());
				show.setNotickets(Integer.parseInt(txtNumberTickets.getText()));
				ss.create(show);
				
			}
		});
		btnAddShow.setBounds(7, 115, 89, 23);
		frame.getContentPane().add(btnAddShow);
	}
}
