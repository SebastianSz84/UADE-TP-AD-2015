package Helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversorFechas
{
	public static Date parsearFecha(String input)
	{
		try
		{
			return new SimpleDateFormat("yyyyMMdd").parse(input);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static String convertirFechaString(Date fecha)
	{
		String DATE_FORMAT = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		Date todayDate = new Date();
		return sdf.format(todayDate);
	}
}