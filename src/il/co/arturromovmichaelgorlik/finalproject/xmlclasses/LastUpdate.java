package il.co.arturromovmichaelgorlik.finalproject.xmlclasses;

public class LastUpdate
{
	private String value;
	
	public LastUpdate(String value)
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
		return "LastUpdate [value=" + value + "]";
	}

}
