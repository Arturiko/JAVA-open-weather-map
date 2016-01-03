package il.co.arturromovmichaelgorlik.finalproject.xmlclasses;

public class Clouds
{
	private String name;
	private String value;

	public Clouds(String name, String value)
	{
		super();
		this.name = name;
		this.value = value;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	@Override
	public String toString()
	{
		return name + "," + value;
	}

}
