package dataAccessLayer.dbModel;

public class ShowDto {

	private int idshow;
	private String title;
	private String distribution;
	private String date;
	private String genre;
	private int notickets;
	public int getIdshow() {
		return idshow;
	}
	public void setIdshow(int idshow) {
		this.idshow = idshow;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDistribution() {
		return distribution;
	}
	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getNotickets() {
		return notickets;
	}
	public void setNotickets(int notickets) {
		this.notickets = notickets;
	}
	
	public String niceDate()
	{
		String s ="";
		char[] c = date.toCharArray();
		
		for(int i=0;i<2;i++)
		{
			s=s+Character.toString(c[i]);
		}
		s=s+".";
		
		for( int i=2;i<4;i++)
		{
			s=s+Character.toString(c[i]);
		}
		s=s+"." ;
		
		for( int i=4;i<c.length;i++)
		{
			s=s+Character.toString(c[i]);
		}
		
		return s;
		
	}
	
	public String toString()
	{
		String s =  "Show: "+ this.title +" distribution: " + this.distribution + " date: " +this.niceDate() +" genre: " +this.genre + " No of tickets left: " + this.notickets;
		return s;
	}
}
