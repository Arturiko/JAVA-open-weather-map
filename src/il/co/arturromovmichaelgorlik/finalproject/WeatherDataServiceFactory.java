package il.co.arturromovmichaelgorlik.finalproject;

public class WeatherDataServiceFactory
{
	private static WeatherDataServiceFactory weatherDataServiceFactory;
	private WeatherDataServiceFactory()
	{
		
	}

	public static IWeatherDataService getOrCreateWeatherDataService(final String weatherDataService) throws WeatherDataServiceException
	{
		if (weatherDataService == "openweathermpas")
		{
			return new OpenWeatherMap();
		}
		else
		{
			return null;
		}

	}

}
