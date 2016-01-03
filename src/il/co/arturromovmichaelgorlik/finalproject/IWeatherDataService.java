package il.co.arturromovmichaelgorlik.finalproject;

public interface IWeatherDataService
{
	public WeatherData getWeatherData(Location location) throws WeatherDataServiceException;
}
