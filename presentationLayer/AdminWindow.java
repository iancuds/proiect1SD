package presentationLayer;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import businessLayer.model.Admin;

import businessLayer.model.Cashier;
import businessLayer.model.Show;
import businessLayer.model.Ticket;
import businessLayer.model.User;
import businessLayer.service.AdminService;
import businessLayer.service.CashierService;
import businessLayer.service.IAdminService;
import businessLayer.service.ICashierService;
import businessLayer.service.IShowService;
import businessLayer.service.ITicketService;
import businessLayer.service.IUserService;
import businessLayer.service.ShowService;
import businessLayer.service.TicketService;
import businessLayer.service.UserService;
import dataAccessLayer.dbModel.UserDto;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdminWindow {

	private JFrame frame;
	private Admin admin;
	private IUserService us = new UserService();
	private IShowService ss = new ShowService();
	private IAdminService as = new AdminService();
	private ICashierService cs = new CashierService() ;
	private ITicketService ts = new TicketService();
	private List<User> users = new ArrayList<User>();
	private List<Ticket> tickets = new ArrayList<Ticket>();
	private List<Show> shows = new ArrayList<Show>();
	
	private JRadioButton rdbtnReservations = new JRadioButton("Reservations");
	private JRadioButton rdbtnShows = new JRadioButton("Shows");
	private JRadioButton rdbtnCashiers = new JRadioButton("Cashiers");

	private JTextField txtUsername;
	private JTable table;
	 DefaultTableModel tableModel = new DefaultTableModel();
	



	private void buildModelCashier()
	{
		users = us.findAll();
		tableModel = new DefaultTableModel( new Object[]{ "Id","User", "First Name", "Last Name", "Address", "Phone", "Birth Date" }, 0 );
		String[] data = new String[7];
		for(User u : users)
		{
			 data[0]=String.valueOf(u.getIduser());
			 data[1]=String.valueOf(u.getUsername());
			 data[2]=String.valueOf(u.getFirstname());
			 data[3]=String.valueOf(u.getLastname());
			 data[4]=String.valueOf(u.getAddress());
			 data[5]=String.valueOf(u.getPhone());
			 data[6]=String.valueOf(u.getDob()); 
			 
			 tableModel.addRow(data);
			 
		}
		
		table.setModel(tableModel);
		table.setVisible(true);
	}
		
	private void buildModelShow()
		{
			shows = ss.findAll();
			tableModel = new DefaultTableModel( new Object[]{ "Id","Title", "Distribution", "Genre", "No of Tickets", "Date"}, 0 );
			String[] data = new String[6];
			for(Show s: shows)
			{
				 data[0]=String.valueOf(s.getIdshow());
				 data[1]=String.valueOf(s.getTitle());
				 data[2]=String.valueOf(s.getDistribution());
				 data[3]=String.valueOf(s.getGenre());
				 data[4]=String.valueOf(s.getNotickets());
				 data[5]=String.valueOf(s.getDate());
				 
				 tableModel.addRow(data);
				 
			}
			
			table.setModel(tableModel);
			table.setVisible(true);
		
		
	}
	
	
	
	private void buildModelTicket()
	{
		tickets = ts.findAll();
		tableModel = new DefaultTableModel( new Object[]{ "Id", "Id show", "Row", "Seat" }, 0 );
		for(Ticket t:tickets)
		{
			// System.out.println(t.toString());
			 String[] data = new String[4];
			 data[0]=String.valueOf(t.getIdticket());
			 data[1]=String.valueOf(t.getIdshow());
			 data[2]=String.valueOf(t.getRow());
			 data[3]=String.valueOf(t.getCol());
			 
			tableModel.addRow(data);
			 
		}
		
		table.setModel(tableModel);
		table.setVisible(true);
	
	
}
	
	private void populateTable()
	{
		if(rdbtnReservations.isSelected())
		{
			buildModelTicket();
			
		}
		
		if(rdbtnCashiers.isSelected())
		{
			buildModelCashier();
		}
		
		if(rdbtnShows.isSelected())
		{
			buildModelShow();
		}
	}
	
    
	
			
	
	public AdminWindow() {
		
		initialize();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 990, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(214, 145, 654, 180);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 190, 98);
		frame.getContentPane().add(textArea);
		
		JLabel lblContent = new JLabel("Content");
		lblContent.setBounds(343, 95, 46, 14);
		frame.getContentPane().add(lblContent);
		/*
		shows = showserv.findAll();
		users = adminserv.findAll();
		JList list = new JList(showserv.allToString(shows).toArray());
		
	    JScrollPane scroll = new JScrollPane(list);
		frame.getContentPane().add(scroll);
		*/
		
		rdbtnCashiers.setBounds(221, 65, 109, 23);
		frame.getContentPane().add(rdbtnCashiers);
		
		
		rdbtnShows.setBounds(358, 65, 109, 23);
		frame.getContentPane().add(rdbtnShows);
		
		
		rdbtnReservations.setBounds(469, 65, 109, 23);
		frame.getContentPane().add(rdbtnReservations);
		
		JButton btnNewCashier = new JButton("New Cashier");
		btnNewCashier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 NewCashier nc = new NewCashier();
				 
				 
			}
		});
		btnNewCashier.setBounds(10, 120, 160, 23);
		frame.getContentPane().add(btnNewCashier);
		
		JButton btnNewShow = new JButton("New Show");
		btnNewShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewShow newshow = new NewShow();
			}
		});
		btnNewShow.setBounds(10, 154, 160, 23);
		frame.getContentPane().add(btnNewShow);
		
		JButton btnUpdateCashierInfo = new JButton("Update Cashier Info");
		btnUpdateCashierInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateWindow update =  new UpdateWindow();
			}
		});
		btnUpdateCashierInfo.setBounds(10, 188, 160, 23);
		frame.getContentPane().add(btnUpdateCashierInfo);
		
		JButton btnUpdateShowInfo = new JButton("Update Show Info");
		btnUpdateShowInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateWindow update =  new UpdateWindow();
				
			}
		});
		btnUpdateShowInfo.setBounds(10, 220, 160, 23);
		frame.getContentPane().add(btnUpdateShowInfo);
		
		JButton btnDeleteCashier = new JButton("Delete Cashier");
		btnDeleteCashier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteApp delete  = new DeleteApp(true);
				
			}
		});
		btnDeleteCashier.setBounds(10, 254, 160, 23);
		frame.getContentPane().add(btnDeleteCashier);
		
		JButton btnDeleteShow = new JButton("Delete Show");
		btnDeleteShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteApp delete = new DeleteApp(false);
			}
		});
		btnDeleteShow.setBounds(10, 288, 160, 23);
		frame.getContentPane().add(btnDeleteShow);
		
		JButton btnExportSellingReport = new JButton("Export To CSV");
		btnExportSellingReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				us.exportToCSV();
				
			}
		});
		btnExportSellingReport.setBounds(10, 327, 160, 23);
		frame.getContentPane().add(btnExportSellingReport);
		
		txtUsername = new JTextField();
		txtUsername.setText("username");
		txtUsername.setBounds(241, 24, 86, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateTable();
			}
		});
		btnRefresh.setBounds(878, 167, 86, 41);
		frame.getContentPane().add(btnRefresh);
		
		
	}
}
