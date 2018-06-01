package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;

import businessLayer.model.Cashier;
import businessLayer.model.Show;
import businessLayer.model.Ticket;
import businessLayer.model.User;
import businessLayer.service.IShowService;
import businessLayer.service.ITicketService;
import businessLayer.service.ShowService;
import businessLayer.service.TicketService;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CashierWindow {

	private JFrame frame;
	private Cashier cashier;
	private JTextField txtSearch;
	private IShowService ss = new ShowService();
	private ITicketService ts =  new TicketService();
	private Show show = new Show();
	private JTextField txtRow;
	private JTextField txtColumn;
	private JTable table;
	private List<Ticket> tickets;
	 DefaultTableModel tableModel = new DefaultTableModel();
	 private JTextField txtPrice;
	 String[] selected =  new String[4];

	
	private void refresh()
	{
		tickets = ts.findAllForShow(show.getIdshow());
		populateTable();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void  sellTicket(Ticket t, Show show)
	{
			if(show.getNotickets()> 0)
			 {
		
		    	 ts.create(t);
		    	 show.setNotickets(show.getNotickets() - 1);
			
			 }
			
		
	}
	
	private String sellMessage(){
		
		String result ="";
		if(show.getNotickets() != 0)
		 {
		
		
		 result = "Available";
		 }
		 else {
			 result = "Sold out!";
		
		    
		 }
		return result;
		}
	
	public CashierWindow() {
		
		initialize();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public CashierWindow(User cashier) {
		this.cashier=(Cashier)cashier;
		{
			
						initialize();
						frame.setVisible(true);
					
		}
		
	}

	
	
	
	
	
	private void populateTable()
	{
		ts.findAllForShow(show.getIdshow());
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
	
	
	
	private void initialize() {
		frame = new JFrame("Cashier Window");
		frame.setBounds(100, 100, 750, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 93, 229, 193);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtPrice = new JTextField();
		txtPrice.setText("price");
		txtPrice.setBounds(254, 48, 86, 20);
		frame.getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		
		txtSearch = new JTextField();
		txtSearch.setText("search");
		txtSearch.setBounds(20, 25, 210, 20);
		frame.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		

		txtRow = new JTextField();
		txtRow.setText("row");
		txtRow.setBounds(20, 140, 86, 20);
		frame.getContentPane().add(txtRow);
		txtRow.setColumns(10);
		
		txtColumn = new JTextField();
		txtColumn.setText("seat");
		txtColumn.setBounds(20, 170, 86, 20);
		frame.getContentPane().add(txtColumn);
		txtColumn.setColumns(10);
		
		JLabel lblSoldTickets = new JLabel("Sold Tickets/Bookings");
		lblSoldTickets.setBounds(290, 68, 200, 14);
		frame.getContentPane().add(lblSoldTickets);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(161, 110, 105, 22);
		frame.getContentPane().add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(254, 23, 470, 22);
		frame.getContentPane().add(textArea_2);
		
		JLabel lblShow = new JLabel("Show");
		lblShow.setBounds(254, 11, 46, 14);
		frame.getContentPane().add(lblShow);
		
		JButton btnFindShow = new JButton("Find show");
		btnFindShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String showName = txtSearch.getText();
				show = ss.findByTitle(showName);
				
				textArea_2.setText(show.toString());
				
				
			}
		});
		btnFindShow.setBounds(20, 65, 130, 20);
		frame.getContentPane().add(btnFindShow);
		
		JButton btnSellTicket = new JButton("Sell Ticket");
		btnSellTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ts.findAllForShow(show.getIdshow());
				
				Ticket ticket = new Ticket();
				ITicketService ts = new TicketService();
				ticket.setRow(Integer.parseInt(txtRow.getText()));
				ticket.setCol(Integer.parseInt(txtColumn.getText()));
				ticket.setIdshow(show.getIdshow());
				ticket.setPrice(Float.parseFloat(txtPrice.getText()));
				
				
				
				
				 textArea_1.setText(sellMessage());
		//		System.out.println(show.getNotickets());
				sellTicket(ticket, show);
				//System.out.println(show.getNotickets());
				/*
				System.out.println(tickets.size());
				System.out.println(show.getNotickets());
				*/
				
				 
				
				refresh();
				
			}
		});
		btnSellTicket.setBounds(20, 110, 130, 20);
		frame.getContentPane().add(btnSellTicket);
		
		JButton btnSeeSoldTickets = new JButton("See Sold Tickets");
		btnSeeSoldTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tickets = ts.findAllForShow(show.getIdshow());
			    
				populateTable();
				table.setVisible(true);
				
			}
		});
		btnSeeSoldTickets.setBounds(20, 215, 130, 20);
		frame.getContentPane().add(btnSeeSoldTickets);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				String id = (String)table.getValueAt(row, 0);
				int intid = Integer.valueOf(id);
				
				Ticket t = new Ticket();
				t = ts.findById(intid);
				
				System.out.println(t);
				
				ts.delete(t);
				
				refresh();
				
			}
		});
		btnCancel.setBounds(290, 300, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				int row = table.getSelectedRow();
				String id = (String)table.getValueAt(row, 0);
				int intid = Integer.valueOf(id);
				
				/*System.out.println(intid);
				System.out.println(Integer.valueOf((String)table.getValueAt(row, 1)));
				System.out.println(Integer.valueOf((String)table.getValueAt(row, 2)));
				System.out.println(Integer.valueOf((String)table.getValueAt(row, 3)));
				*/
				
				
				Ticket t = new Ticket();
				t = ts.findById(intid);
				t.setIdshow(Integer.valueOf((String)table.getValueAt(row, 1)));
				t.setRow(Integer.valueOf((String)table.getValueAt(row, 2)));
				t.setCol(Integer.valueOf((String)table.getValueAt(row, 3)));
				ts.update(t, intid);
				
				refresh();
			}
		});
		btnSaveChanges.setBounds(409, 300, 120, 23);
		frame.getContentPane().add(btnSaveChanges);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
				
			}
		});
		btnRefresh.setBounds(560, 124, 105, 66);
		frame.getContentPane().add(btnRefresh);
		
		
		
		
	
		
	}
}
