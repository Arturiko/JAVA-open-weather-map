package il.co.arturromovmichaelgorlik.finalproject;

public class Location
{
	private String city;
	private String country;
	private static String unit = "Metric";

	public static String getUnit()
	{
		return unit;
	}

	public static void setUnit(String unit)
	{
		Location.unit = unit;
	}

	public Location(String city, String country) throws WeatherDataServiceException
	{
		//super();
		setCity(city);
		setCountry(country);
	}

	public String getCity()
	{
		return city;
	}

	private void setCity(String city) throws WeatherDataServiceException
	{
		if (!checkIfNumber(city))
		{
			this.city = city;
		}
	}

	private boolean checkIfNumber(String str) throws WeatherDataServiceException
	{

		if (str.matches(".*\\d+.*"))
		{
			throw new WeatherDataServiceException("Please Enter only letterts ! !");
		}

		return false;

	}

	public String getCountry()
	{
		return country;
	}

	private void setCountry(String country)
	{
		this.country = country;
	}
}
