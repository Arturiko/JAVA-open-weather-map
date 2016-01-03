package il.co.arturromovmichaelgorlik.finalproject.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import il.co.arturromovmichaelgorlik.finalproject.Location;

public class LocationTest
{
private static Location location;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		location = new Location("holon", "IL");
		location.setUnit("metric");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		location = null;	
	}

	@Before
	public void setUp() throws Exception
	{
		
	}

	@After
	public void tearDown() throws Exception
	{
		
	}

	@Test
	public void testGetUnit()
	{
		String expected = "metric";
		String actual = Location.getUnit();
		assertEquals(expected, actual);
		
	}

	@Test
	public void testGetCity()
	{
		String expected = "holon";
		String actual = location.getCity();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetCountry()
	{
		String expected = "IL";
		String actual = location.getCountry();
		assertEquals(expected, actual);
	}

}
