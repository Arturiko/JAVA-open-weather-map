package il.co.arturromovmichaelgorlik.finalproject.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import il.co.arturromovmichaelgorlik.finalproject.Location;
import il.co.arturromovmichaelgorlik.finalproject.OpenWeatherMap;
import il.co.arturromovmichaelgorlik.finalproject.WeatherData;
import il.co.arturromovmichaelgorlik.finalproject.WeatherDataServiceException;

public class OpenWeatherMapTest
{
	static OpenWeatherMap openWeatherMap;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		openWeatherMap = new OpenWeatherMap();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		  openWeatherMap = null;
		
	}

	@Test
	public void testGetWeatherData() throws WeatherDataServiceException
	{
		WeatherData excpected = openWeatherMap.getWeatherData(new Location("holon", "IL"));
		assertNotNull(excpected);
		
	}

}
