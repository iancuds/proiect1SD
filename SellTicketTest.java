import static org.junit.Assert.*;

import org.junit.Test;

import businessLayer.model.Show;
import businessLayer.model.Ticket;
import presentationLayer.CashierWindow;

public class SellTicketTest {

	@Test
	public void SellTickettest() {
		
		Show show = new Show();
		show.setNotickets(0);
		Ticket ticket = new Ticket();
		CashierWindow cashier = new CashierWindow();
		cashier.sellTicket(ticket, show);
		assertEquals(show.getNotickets(), 0);
		
		
	}

}
