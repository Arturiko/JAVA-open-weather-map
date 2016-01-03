package il.co.arturromovmichaelgorlik.finalproject.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import il.co.arturromovmichaelgorlik.finalproject.Location;
import il.co.arturromovmichaelgorlik.finalproject.OpenWeatherMap;
import il.co.arturromovmichaelgorlik.finalproject.WeatherData;
import il.co.arturromovmichaelgorlik.finalproject.xmlclasses.*;


public class WeatherDataTest
{
	private WeatherData weatherData;
	private OpenWeatherMap openWeatherMap;

	@Before
	public void setUp() throws Exception
	{

		openWeatherMap = new OpenWeatherMap();
		weatherData = openWeatherMap.getWeatherData(new Location("holon", "IL"));
	}

	@After
	public void tearDown() throws Exception
	{
		openWeatherMap = null;
		weatherData = null;
	}

	@Test
	public void testGetCity()
	{
		City expected = weatherData.getCity();
		assertNotNull(expected);
	}

	@Test
	public void testGetClouds()
	{
		Clouds expected = weatherData.getClouds();
		assertNotNull(expected);
	}

	@Test
	public void testGetWind()
	{
		
			Wind expected = weatherData.getWind();
			assertNotNull(expected);
	}

	@Test
	public void testGetLastUpdate()
	{
		LastUpdate expected = weatherData.getLastUpdate();
		assertNotNull(expected);
	}

	@Test
	public void testGetHumidity()
	{
		Humidity expected = weatherData.getHumidity();
		assertNotNull(expected);
	}

	@Test
	public void testGetPressure()
	{
		Pressure expected = weatherData.getPressure();
		assertNotNull(expected);
	}

	@Test
	public void testGetVisibility()
	{
		Visibility expected = weatherData.getVisibility();
		assertNotNull(expected);
	}

	@Test
	public void testGetPrecipitation()
	{
		Precipitation expected = weatherData.getPrecipitation();
		assertNotNull(expected);
	}

	@Test
	public void testGetWeather()
	{
		Weather expected = weatherData.getWeather();
		assertNotNull(expected);
	}

	@Test
	public void testGetTemperature()
	{
		Temperature expected = weatherData.getTemperature();
		assertNotNull(expected);
	}


}
