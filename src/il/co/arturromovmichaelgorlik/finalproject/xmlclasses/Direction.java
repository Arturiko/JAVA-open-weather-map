package il.co.arturromovmichaelgorlik.finalproject.xmlclasses;

public class Direction
{
	private String value;
	private String code;
	private String name;

	public Direction(String value, String code, String name)
	{
		super();
		this.value = value;
		this.code = code;
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

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
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
