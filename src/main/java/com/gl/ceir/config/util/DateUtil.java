package com.gl.ceir.config.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {

	private final static String NUMERIC_STRING = "0123456789";

	public static String newDate(int nextdateDay, String format) {
		if(Objects.isNull(format)) {
			format = "yyyy-MM-dd";
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DAY_OF_MONTH, nextdateDay);  
		String newDate = sdf.format(cal.getTime());  

		return newDate;

	}

	public Date formatChanger(LocalDateTime localDateTime ) throws ParseException {

		/*SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy");
		java.util.Date date = format.parse(dateString);
		 */
		String dmyFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(localDateTime);
		java.util.Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dmyFormat);

		return date;
	}
	
	public LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}
	
	public void compareDateWithToday() {
		
	}

 

}
