package il.co.arturromovmichaelgorlik.finalproject.xmlclasses;

public class Speed
{
	private String value;
	private String name;

	public Speed(String value, String name)
	{
		super();
		this.value = value;
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return value + "," + name;
	}

}
