package il.co.arturromovmichaelgorlik.finalproject.xmlclasses;

public class Visibility
{
	private String value;

	
	
	public Visibility(String value)
	{
		super();
		this.value = value;
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
		return "Visibility [value=" + value + "]";
	}

}
