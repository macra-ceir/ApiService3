package com.gl.ceir.config.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;


import org.springframework.stereotype.Component;

@Component
public class Utility {

    private final static String NUMERIC_STRING = "0123456789";

    public String newDate(int nextdateDay) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DAY_OF_MONTH, nextdateDay);
        String newDate = sdf.format(cal.getTime());

        return newDate;

    }

    public static String getTxnId() {

        DateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
        Date date = new Date();
        String transactionId = dateFormat.format(date) + randomNumericString(3);
        return transactionId;
    }

    public static String randomNumericString(int length) {
        StringBuilder builder = new StringBuilder();
        while (length-- != 0) {
            int character = (int) (Math.random() * NUMERIC_STRING.length());
            builder.append(NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public Date formatChanger(LocalDateTime localDateTime) throws ParseException {

        /*SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy");
		java.util.Date date = format.parse(dateString);
         */
        String dmyFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(localDateTime);
        java.util.Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dmyFormat);

        return date;

    }

    public static void main123(String[] args) {
        String str = "org.hibernate.dialect.MySQL5InnoDBDialect";

        System.out.println(str.toLowerCase().contains("mysql"));

        try {
            String string = "{\"name\": \"Sam Smith\", \"technology\": \"Python\"}";
             JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(string);

         //   JSONObject json = new JSONObject(string);
            System.out.println(json.toString());
            String technology;
            technology = json.get("technology").toString();
            System.out.println(technology);
            
            

            String stringToParse = "\"{\\\"option_a\\\": \\\"Option A\\\", \\\"find_imei\\\": \\\"Find IMEI\\\", \\\"enter_imei\\\": \\\"enter_imei\\\", \\\"imei_details\\\": \\\"imei details\\\", \\\"get_imie_information\\\": \\\"Get IMEI Information\\\", \\\"IMEI_also_written_in_the_box_as_shown_in_Image_below\\\": \\\"IMEI also written in the box as shown in Image below\\\"}\"";
            JSONParser parser1 = new JSONParser();
            JSONObject json1 = (JSONObject) parser1.parse(stringToParse);

            System.out.println("result " + json1);
        } catch (Exception e) {
            System.out.println("errr " + e + "::" + e.getLocalizedMessage());

        }
    }

}
