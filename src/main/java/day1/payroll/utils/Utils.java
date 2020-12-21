package day1.payroll.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static Date parseStringToDate(String date) {
        try {
            Date dateRes =new SimpleDateFormat("yyyy-MM-dd").parse(date);
            return dateRes;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Date getDateNow() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            return dateFormat.parse(dateFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
