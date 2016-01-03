package il.co.arturromovmichaelgorlik.finalproject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import il.co.arturromovmichaelgorlik.finalproject.xmlclasses.*;

public class WeatherData
{

	public WeatherData()
	{

	}

	private City city;

	public City getCity()
	{
		return city;
	}

	private Clouds clouds;
	private Wind wind;
	private LastUpdate lastUpdate;
	private Humidity humidity;
	private Pressure pressure;
	private Visibility visibility;
	private Precipitation precipitation;
	private Weather weather;
	private Temperature temperature;

	private void setAttribute(String cuurentTagName, Element rootElement)
	{
		NodeList currentList = rootElement.getElementsByTagName(cuurentTagName);
		Node currentNode = currentList.item(0);
		Element currentElement = (Element) currentNode;

		switch (cuurentTagName)
		{
		case "city":
		{
			city = new City(currentElement.getAttribute("id"), currentElement.getAttribute("name"));
			break;
		}
		case "coord":
		{
			Coord coord = new Coord(currentElement.getAttribute("lon"), currentElement.getAttribute("lat"));
			city.setCoord(coord);
			break;
		}
		case "country":
		{
			city.setCountry(currentElement.getTextContent());
			break;
		}
		case "sun":
		{
			Sun sun = new Sun(currentElement.getAttribute("rise"), currentElement.getAttribute("set"));
			city.setSun(sun);
			System.out.println(city);
			break;
		}
		case "temperature":
		{
			temperature = new Temperature(currentElement.getAttribute("value"), currentElement.getAttribute("min"),
					currentElement.getAttribute("max"), currentElement.getAttribute("unit"));
			System.out.println(temperature);
			break;
		}
		case "humidity":
		{
			System.out.println("humidity");
			humidity = new Humidity(currentElement.getAttribute("value"), currentElement.getAttribute("unit"));
			break;
		}
		case "pressure":
		{
			pressure = new Pressure(currentElement.getAttribute("value"), currentElement.getAttribute("unit"));
			break;
		}
		case "wind":
		{
			wind = new Wind();

			break;
		}
		case "speed":
		{
			Speed speed = new Speed(currentElement.getAttribute("value"), currentElement.getAttribute("name"));
			wind.setSpeed(speed);
			break;
		}
		case "direction":
		{
			Direction direction = new Direction(currentElement.getAttribute("value"),
					currentElement.getAttribute("code"), currentElement.getAttribute("name"));
			wind.setDirection(direction);
			System.out.println(wind);
			break;
		}
		case "clouds":
		{
			clouds = new Clouds(currentElement.getAttribute("value"), currentElement.getAttribute("name"));
			break;
		}
		case "visibility":
		{
			visibility = new Visibility(currentElement.getAttribute("value"));
			break;
		}
		case "precipitation":
		{
			precipitation = new Precipitation(currentElement.getAttribute("value"),
					currentElement.getAttribute("mode"));
			break;
		}
		case "weather":
		{
			weather = new Weather(currentElement.getAttribute("value"), currentElement.getAttribute("icon"),
					currentElement.getAttribute("number"));
			System.out.println(getWeather().getIcon() + ".png");
			break;
		}
		case "lastupdate":
		{
			lastUpdate = new LastUpdate(currentElement.getAttribute("value"));
			break;
		}
		}
	}

	public void setAllWeatherDataByTagNames(Document doc)
	{
		NodeList list = doc.getElementsByTagName("current");
		Node rootNode = list.item(0);
		Element rootElement = (Element) rootNode;

		setAttribute("city", rootElement);
		setAttribute("coord", rootElement);
		setAttribute("country", rootElement);
		setAttribute("sun", rootElement);
		setAttribute("temperature", rootElement);
		setAttribute("humidity", rootElement);
		setAttribute("pressure", rootElement);
		setAttribute("wind", rootElement);
		setAttribute("speed", rootElement);
		setAttribute("direction", rootElement);
		setAttribute("clouds", rootElement);
		setAttribute("visibility", rootElement);
		setAttribute("precipitation", rootElement);
		setAttribute("weather", rootElement);
		setAttribute("lastupdate", rootElement);

	}

	public Clouds getClouds()
	{
		return clouds;
	}

	public Wind getWind()
	{
		return wind;
	}

	public LastUpdate getLastUpdate()
	{
		return lastUpdate;
	}

	public Humidity getHumidity()
	{
		return humidity;
	}

	public Pressure getPressure()
	{
		return pressure;
	}

	public Visibility getVisibility()
	{
		return visibility;
	}

	public Precipitation getPrecipitation()
	{
		return precipitation;
	}

	public Weather getWeather()
	{
		return weather;
	}

	public Temperature getTemperature()
	{
		return temperature;
	}

	@Override
	public String toString()
	{
		return "WeatherData [clouds=" + clouds + ", wind=" + wind + ", lastUpdate=" + lastUpdate + ", humidity="
				+ humidity + ", pressure=" + pressure + ", visibility=" + visibility + ", precipitation="
				+ precipitation + ", weather=" + weather + ", temperature=" + temperature + "]";
	}

}
