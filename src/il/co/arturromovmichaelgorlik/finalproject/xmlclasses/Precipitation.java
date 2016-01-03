package il.co.arturromovmichaelgorlik.finalproject.xmlclasses;

public class Precipitation
{
	private String value;
	private String mode;

	public Precipitation(String value,String mode)
	{
		// TODO Auto-generated constructor stub
		this.value = value;
		this.mode = mode;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getMode()
	{
		return mode;
	}

	public void setMode(String mode)
	{
		this.mode = mode;
	}

	@Override
	public String toString()
	{
		return "Precipitation [value=" + value + ", mode=" + mode + "]";
	}

}
