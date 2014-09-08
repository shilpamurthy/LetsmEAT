package shilpa.servlet.test;


public class NameLinkPair {
	
	private String name; 
	private String link;
	public NameLinkPair(String name, String link)
	{
		this.name = name;
		this.link = link;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getLink()
	{
		return this.link;
	}
	
	public void setName(String x)
	{
		this.name = x;
	}
	
	public void setLink(String l)
	{
		this.link = l;
	}

}
