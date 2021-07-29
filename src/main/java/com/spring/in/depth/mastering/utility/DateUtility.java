package com.spring.in.depth.mastering.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtility {


    public static String getDate(String date, String format, int minutes, int hours) {
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(format);
        Date date1 = null;
        try {
            date1 = simpleDateFormat2.parse(date);
        Calendar cal9 = Calendar.getInstance();
        cal9.setTime(date1);
        cal9.add(Calendar.MINUTE, minutes);
        cal9.add(Calendar.HOUR_OF_DAY, hours);
        date1 = cal9.getTime();
        return simpleDateFormat2.format(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getDropDate(String dateFromApi,int minutes, int hours) {
        dateFromApi = dateFromApi.substring(0, dateFromApi.length() - Math.abs(19 - dateFromApi.length())).replace("T", " ");
        return getDate(dateFromApi, "yyyy-MM-dd HH:mm:ss", minutes, hours);
    }
}
