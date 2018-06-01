package businessLayer.service;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.List;
import businessLayer.model.Ticket;

public class FileFactory implements IFileFactory {
	
//	private File f;
	private ITicketService ts = new TicketService();
	private List<Ticket>tickets;

public 	FileFactory()
{
	
}




	String name = "SoldTickets";
	
	
	
	public void makeFile(){
	PrintWriter pw = null;
	
	try {
		pw = new PrintWriter(new File(name+".csv"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    StringBuilder sb = new StringBuilder();
    sb.append("id");
    sb.append(',');
    sb.append("row");
    sb.append(',');
    sb.append("column");
    sb.append(',');
    sb.append("show id");
    sb.append(',');
    sb.append("price");
    sb.append('\n');

    tickets = ts.findAll();
    
    for (Ticket t: tickets)
    {
    	 sb.append(t.getIdticket());
         sb.append(',');
         sb.append(t.getRow());
         sb.append(',');
         sb.append(t.getCol());
         sb.append(',');
         sb.append(t.getIdshow());
         sb.append(',');
         sb.append(t.getPrice());
         sb.append('\n');
    }
   

    pw.write(sb.toString());
    pw.close();



}
	
}
