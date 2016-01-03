package il.co.arturromovmichaelgorlik.finalproject.xmlclasses;

public class City
{
	private String ID;
	private String name;
	private String countryCode;
	
	
	private Coord coord;
	private Sun sun;



	public City(String iD, String name)
	{
		ID = iD;
		this.name = name;
	}

	public String getID()
	{
		return ID;
	}

	public String getName()
	{
		return name;
	}

	public String getCountry()
	{
		return countryCode;
	}

	public void setCountry(String country)
	{
		this.countryCode = country;
	}

	public Coord getCoord()
	{
		return coord;
	}

	public void setCoord(Coord coord)
	{
		this.coord = coord;
	}

	public Sun getSun()
	{
		return sun;
	}

	public void setSun(Sun sun)
	{
		this.sun = sun;
	}

	@Override
	public String toString()
	{
		return "City [ID=" + ID + ", name=" + name + ", countryCode=" + countryCode + ", coord=" + coord + ", sun=" + sun + "]";
	}

}
