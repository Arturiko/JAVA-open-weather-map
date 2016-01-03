package il.co.arturromovmichaelgorlik.finalproject.xmlclasses;

public class Sun
{
	private String rise;
	private String set;

	public Sun(String rise, String set)
	{
		super();
		this.rise = rise;
		this.set = set;
	}

	public String getRise()
	{
		return rise;
	}

	public void setRise(String rise)
	{
		this.rise = rise;
	}

	public String getSet()
	{
		return set;
	}

	public void setSet(String set)
	{
		this.set = set;
	}

	@Override
	public String toString()
	{
		return "Sun [rise=" + rise + ", set=" + set + "]";
	}

}
