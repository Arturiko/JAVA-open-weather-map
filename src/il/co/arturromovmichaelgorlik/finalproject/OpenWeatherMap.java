package il.co.arturromovmichaelgorlik.finalproject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class OpenWeatherMap implements IWeatherDataService {
	WeatherData weatherdata = new WeatherData();

	@Override
	public WeatherData getWeatherData(Location location) throws WeatherDataServiceException {
		String city = location.getCity();
		String country = location.getCountry();

		try {
			URL url;
			String appID = "5fa7571c03889c663963c41593c4124d";
			url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country + "&units="
					+ location.getUnit() + "&mode=xml&APPID="+appID );
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			//con.setRequestMethod("GET");
			con.connect();
			InputStream in = con.getInputStream();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(in);
			weatherdata.setAllWeatherDataByTagNames(doc);
			

		 
         
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return weatherdata;
	}

}
