package il.co.arturromovmichaelgorlik.GUI;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.*;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;

import javax.imageio.ImageIO;
import il.co.arturromovmichaelgorlik.finalproject.*;

import java.awt.event.*;
import java.net.URL;
import java.awt.event.ActionEvent;

public class GUI
{
	private WeatherData weatherData;
	private JFrame frmWeather;
	private JTable table;

	private JTextField textFieldByCity;
	private JTextField textFieldByCountry;

	private DialTextAnnotation dialtextannotation;
	private Object[][] tableData;
	private JLabel lblTemperture;
	private JLabel lblCity_1;
	private JLabel labelForTheImageByTemperature;
	private DefaultValueDataset dataset1;
	private StandardDialScale standarddialscale;
	private StandardDialRange standarddialrangeRED;
	private StandardDialRange standarddialrangeORANGE;
	private StandardDialRange standarddialrangeGREEN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					GUI window = new GUI();
					window.frmWeather.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmWeather = new JFrame();
		frmWeather.setTitle("weather");
		frmWeather.setResizable(false);
		frmWeather.getContentPane().setFont(new Font("Arial", Font.BOLD, 11));
		//frmWeather.getContentPane().setBackground(new Color(255, 250, 250));
		frmWeather.setBounds(100, 100, 820, 360);
		frmWeather.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWeather.getContentPane().setLayout(null);

		createComboBoxUnitsChoice();
		createTable();
		sumbitButton();
		new thermostat(0);
		setBigWeatherInYourCiryLabel();
		setTwoBlackSeparators();
		setLabelsCityAndCountry();
		setTextFieldCityAndCountry();
		setUnVisibleLabelsCityAndCountryAndCurrentTempeture();

	}

	private void setUnVisibleLabelsCityAndCountryAndCurrentTempeture()
	{
		lblCity_1 = new JLabel("City, Country");
		lblCity_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCity_1.setBounds(20, 74, 119, 36);
		lblCity_1.setVisible(false);
		frmWeather.getContentPane().add(lblCity_1);

		lblTemperture = new JLabel("Tempeture");
		lblTemperture.setVisible(false);
		lblTemperture.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTemperture.setBounds(285, 70, 89, 29);
		frmWeather.getContentPane().add(lblTemperture);
	}

	private void setBigWeatherInYourCiryLabel()
	{
		JLabel lblNewLabel = new JLabel("Weather in your city");
		lblNewLabel.setBounds(10, 11, 194, 52);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(160, 82, 45));
		frmWeather.getContentPane().add(lblNewLabel);
	}

	private void setTextFieldCityAndCountry()
	{
		textFieldByCity = new JTextField();
		textFieldByCity.setBounds(402, 110, 150, 20);
		frmWeather.getContentPane().add(textFieldByCity);
		textFieldByCity.setColumns(10);

		textFieldByCountry = new JTextField();
		textFieldByCountry.setColumns(10);
		textFieldByCountry.setBounds(402, 177, 150, 20);
		frmWeather.getContentPane().add(textFieldByCountry);

	}

	/**
	 * Create the table.
	 */
	private void createTable()
	{
		table = new JTable();
		table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		table.setRowSelectionAllowed(false);
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(Color.WHITE);

		tableData = new Object[][] { { "   Wind", null }, { "   Cloudiness", null }, { "   Pressure", null },
				{ "   Humidity", null }, { "   Sunrise", null }, { "   Sunset", null }, { "   Geo coords", null }, };
		String[] test = new String[] { "param", "val" };

		DefaultTableModel defaultTableModel = new DefaultTableModel(tableData, test);
		table.setModel(new DefaultTableModel(new Object[][] { { "   Wind", null }, { "   Cloudiness", null },
				{ "   Pressure", null }, { "   Humidity", null }, { "   Sunrise", null }, { "   Sunset", null },
				{ "   Geo coords", null }, }, new String[] { "param", "val" }));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(1).setMinWidth(30);
		table.setBounds(10, 146, 364, 175);
		table.setRowHeight(25);

		frmWeather.getContentPane().add(table);
	}

	/**
	 * Create the comboBox For unit choice.
	 */
	private void createComboBoxUnitsChoice()
	{
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Metric", "Imperial", "Kelvin" }));
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setToolTipText("UNITS");
		comboBox.setBounds(402, 43, 150, 20);
		comboBox.setSelectedItem("Metric");
		comboBox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String chosenUnit = (String) comboBox.getSelectedItem();
				switch (chosenUnit)
				{
				case "Metric":
				{
					System.out.println(chosenUnit);
					Location.setUnit("metric");
					break;

				}
				case "Imperial":
				{
					System.out.println(chosenUnit);
					Location.setUnit("imperial");
					break;
				}
				case "Kelvin":
				{
					System.out.println(chosenUnit);
					Location.setUnit("Kelvin");
					break;
				}
				default:
					break;
				}
			}
		});

		frmWeather.getContentPane().add(comboBox);
	}

	/**
	 * Create the sumbit button and all his actions.
	 */
	private void sumbitButton()
	{
		JButton btnSumbit = new JButton("Sumbit");
		btnSumbit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String cityname = null;
				String countryName = null;
				try
				{
					IWeatherDataService service = WeatherDataServiceFactory
							.getOrCreateWeatherDataService("openweathermpas");

					String regex = "[0-9]+";
					cityname = textFieldByCity.getText();
					countryName = textFieldByCountry.getText();
					if (cityname.length() == 0 || cityname.matches(regex))
					{
						JOptionPane.showMessageDialog(frmWeather, "Wrong Input");
					}
					else
					{
						weatherData = service.getWeatherData(new Location(cityname, countryName));
						try
						{
							if (labelForTheImageByTemperature != null)
							{
								frmWeather.getContentPane().remove(labelForTheImageByTemperature);
							}
							URL url = new URL(
									"http://openweathermap.org/img/w/" + weatherData.getWeather().getIcon() + ".png");
							Image imageByTemperature = ImageIO.read(url);

							labelForTheImageByTemperature = new JLabel(new ImageIcon(imageByTemperature));
							frmWeather.getContentPane().setLayout(null);
							frmWeather.getContentPane().add(labelForTheImageByTemperature);
							labelForTheImageByTemperature.setBounds(220, 27, 80, 120);
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
						if (cityname.length() != 0)
						{
							lblCity_1.setVisible(true);
							lblCity_1.setText(weatherData.getCity().getName());
							lblCity_1.setSize(lblCity_1.getPreferredSize());
						}
						if (countryName.length() != 0)
						{
							lblCity_1.setVisible(true);
							lblCity_1.setText(
									weatherData.getCity().getName() + ", " + weatherData.getCity().getCountry());
							lblCity_1.setSize(lblCity_1.getPreferredSize());
						}

						String unit = null;
						System.out.println(weatherData.getTemperature().getUnit().toLowerCase());

						if (weatherData.getTemperature().getUnit().toLowerCase().equals("metric"))
						{
							unit = "\u00B0C";
							dialtextannotation.setLabel(unit);
							// standarddialscale.setUpperBound(60);

							standarddialrangeGREEN.setBounds(-40, 10);
							standarddialrangeORANGE.setBounds(10, 40);
							standarddialrangeRED.setBounds(40, 60);
							// standarddialrangeRED;
							// standarddialrangeORANGE;
							// standarddialrangeGREEN;

							standarddialscale.setUpperBound(60D);
							standarddialscale.setLowerBound(-60);
						}
						else if (weatherData.getTemperature().getUnit().toLowerCase().equals("fahrenheit"))
						{
							unit = "\u00B0F";
							dialtextannotation.setLabel(unit);

							standarddialrangeGREEN.setBounds(-56, 14);
							standarddialrangeORANGE.setBounds(14, 64);
							standarddialrangeRED.setBounds(64, 134);

							standarddialscale.setUpperBound(140);
							standarddialscale.setLowerBound(-76);
						}
						else
						{
							unit = "\u00B0K";
							dialtextannotation.setLabel(unit);
							standarddialrangeGREEN.setBounds(200, 270);
							standarddialrangeORANGE.setBounds(270, 300);
							standarddialrangeRED.setBounds(300, 333);
							standarddialscale.setUpperBound(333);
							standarddialscale.setLowerBound(200);
						}
						lblTemperture.setVisible(true);
						lblTemperture.setText(weatherData.getTemperature().getValue() + unit);

						// dialdemo2 = new DemoPanel(100);0
						dataset1.setValue(Double.parseDouble((weatherData.getTemperature().getValue().toString())));

						table.getModel().setValueAt(weatherData.getWind(), 0, 1);
						table.getModel().setValueAt(weatherData.getClouds(), 1, 1);
						table.getModel().setValueAt(weatherData.getPressure(), 2, 1);
						table.getModel().setValueAt(weatherData.getHumidity(), 3, 1);
						table.getModel().setValueAt(weatherData.getCity().getSun().getRise(), 4, 1);
						table.getModel().setValueAt(weatherData.getCity().getSun().getSet(), 5, 1);
						table.getModel().setValueAt(weatherData.getCity().getCoord(), 6, 1);

						// table.setRowHeight(0, 60);
					}
				}
				catch (WeatherDataServiceException e)
				{
					e.printStackTrace();
					JOptionPane.showMessageDialog(frmWeather, "Please enter only letters !!");
				}
			}
		});
		btnSumbit.setBounds(430, 244, 89, 23);
		frmWeather.getContentPane().add(btnSumbit);
	}

	private void setTwoBlackSeparators()
	{
		/* Left sep */
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(384, 11, 17, 310);
		frmWeather.getContentPane().add(separator);
		/* right sep */
		JSeparator separator2 = new JSeparator();
		separator2.setOrientation(SwingConstants.VERTICAL);
		separator2.setForeground(Color.BLACK);
		separator2.setBackground(Color.BLACK);
		separator2.setBounds(565, 11, 9, 310);
		frmWeather.getContentPane().add(separator2);
	}

	private void setLabelsCityAndCountry()
	{
		JLabel lblCity = new JLabel("City :");
		lblCity.setBounds(402, 85, 46, 14);
		frmWeather.getContentPane().add(lblCity);

		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(402, 152, 67, 14);
		frmWeather.getContentPane().add(lblCountry);
	}

	private class thermostat extends JFrame
	{
		private static final long serialVersionUID = 1L;

		public JFreeChart createStandardDialChart(String s, String s1, ValueDataset valuedataset, double d, double d1,
				double d2, int i)
		{
			DialPlot dialplot = new DialPlot();
			dialplot.setDataset(valuedataset);
			dialplot.setDialFrame(new StandardDialFrame());
			dialplot.setBackground(new DialBackground());
			dialtextannotation = new DialTextAnnotation(s1);
			dialtextannotation.setFont(new Font("Dialog", 1, 14));
			dialtextannotation.setRadius(0.69999999999999996D);
			dialplot.addLayer(dialtextannotation);
			DialValueIndicator dialvalueindicator = new DialValueIndicator(0);
			dialplot.addLayer(dialvalueindicator);
			standarddialscale = new StandardDialScale(d, d1, -120D, -300D, 10D, 4);
			standarddialscale.setMajorTickIncrement(d2);
			standarddialscale.setMinorTickCount(i);
			standarddialscale.setTickRadius(0.88D);
			standarddialscale.setTickLabelOffset(0.14999999999999999D);
			standarddialscale.setTickLabelFont(new Font("Dialog", 0, 14));

			dialplot.addScale(0, standarddialscale);
			dialplot.addPointer(new org.jfree.chart.plot.dial.DialPointer.Pin());
			DialCap dialcap = new DialCap();
			dialplot.setCap(dialcap);
			return new JFreeChart(s, dialplot);
		}

		public thermostat(int number)
		{

			dataset1 = new DefaultValueDataset(number);
			JFreeChart jfreechart = createStandardDialChart(null, "Temperature", dataset1, -60D, 60D, 10D, 4);
			DialPlot dialplot = (DialPlot) jfreechart.getPlot();

			standarddialrangeRED = new StandardDialRange(40D, 60D, Color.red);
			standarddialrangeRED.setInnerRadius(0.52000000000000002D);
			standarddialrangeRED.setOuterRadius(0.55000000000000004D);
			dialplot.addLayer(standarddialrangeRED);

			standarddialrangeORANGE = new StandardDialRange(10D, 40D, Color.orange);
			standarddialrangeORANGE.setInnerRadius(0.52000000000000002D);
			standarddialrangeORANGE.setOuterRadius(0.55000000000000004D);
			dialplot.addLayer(standarddialrangeORANGE);

			standarddialrangeGREEN = new StandardDialRange(-40D, 10D, Color.green);
			standarddialrangeGREEN.setInnerRadius(0.52000000000000002D);
			standarddialrangeGREEN.setOuterRadius(0.55000000000000004D);
			dialplot.addLayer(standarddialrangeGREEN);

			GradientPaint gradientpaint = new GradientPaint(new Point(), new Color(255, 255, 255), new Point(),
					new Color(170, 170, 220));
			DialBackground dialbackground = new DialBackground(gradientpaint);

			dialbackground.setGradientPaintTransformer(
					new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
			dialplot.setBackground(dialbackground);

			dialplot.removePointer(0);
			org.jfree.chart.plot.dial.DialPointer.Pointer pointer = new org.jfree.chart.plot.dial.DialPointer.Pointer();
			pointer.setFillPaint(Color.yellow);
			dialplot.addPointer(pointer);
			ChartPanel chartpanel = new ChartPanel(jfreechart);
			chartpanel.setPreferredSize(new Dimension(238, 400));
			/// add(chartpanel);

			// Point p = new Point(0, 0);
			// chartpanel.setLocation(p);
             chartpanel.setBounds(577, 11, 238, 310);
			frmWeather.getContentPane().setLayout(null);
			frmWeather.getContentPane().add(chartpanel);
		}
	}
}