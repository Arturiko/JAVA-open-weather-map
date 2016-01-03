package il.co.arturromovmichaelgorlik.finalproject.xmlclasses;

public class Weather
{
	private String value;
	private String icon;
	private String number;

	public Weather(String value, String icon, String number)
	{
		super();
		this.value = value;
		this.icon = icon;
		this.number = number;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getIcon()
	{
		return icon;
	}

	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	@Override
	public String toString()
	{
		return "Weather [value=" + value + ", icon=" + icon + ", number=" + number + "]";
	}

}
