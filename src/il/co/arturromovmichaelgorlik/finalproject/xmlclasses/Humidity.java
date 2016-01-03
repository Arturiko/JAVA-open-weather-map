package il.co.arturromovmichaelgorlik.finalproject.xmlclasses;

public class Humidity
{
	private String value;
	private String unit;

	public Humidity(String value, String unit)
	{
		// TODO Auto-generated constructor stub
		this.value = value;
		this.unit = unit;

	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getUnit()
	{
		return unit;
	}

	public void setUnit(String unit)
	{
		this.unit = unit;
	}

	@Override
	public String toString()
	{
		return value +" "+ unit ;
	}

}
