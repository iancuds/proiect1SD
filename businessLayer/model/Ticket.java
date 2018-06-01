package businessLayer.model;

public class Ticket {

	

	private int idticket;
	private float price;
	private int row;
	private int col;
	private int idshow;
	
	
	public Ticket()
	{
		
	}
	
	public int getIdticket() {
		return idticket;
	}
	public void setIdticket(int idticket) {
		this.idticket = idticket;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getIdshow() {
		return idshow;
	}
	public void setIdshow(int idshow) {
		this.idshow = idshow;
	}
	
	public String toString()
	{
		String s="";
		s=s+"Price: " + this.price + " Row:" + this.row + " Column: " + this.col + " Show ID: " + this.idshow;
		return s;
	}
	
}
