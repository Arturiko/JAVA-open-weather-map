package il.co.arturromovmichaelgorlik.finalproject.xmlclasses;

public class Temperature
{
	private String value;
	private String min;
	private String max;
	private String unit;

	public Temperature(String value, String min, String max, String unit)
	{
		// TODO Auto-generated constructor stub
		this.value = value;
		this.min = min;
		this.max = max;
		this.unit = unit;
	}

	public String getMin()
	{
		return min;
	}

	public void setMin(String min)
	{
		this.min = min;
	}

	public String getMax()
	{
		return max;
	}

	public void setMax(String max)
	{
		this.max = max;
	}

	public String getUnit()
	{
		return unit;
	}

	public void setUnit(String unit)
	{
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

	@Override
	public String toString()
	{
		return "Temperature [value=" + value + ", min=" + min + ", max=" + max + ", unit=" + unit + "]";
	}

}
