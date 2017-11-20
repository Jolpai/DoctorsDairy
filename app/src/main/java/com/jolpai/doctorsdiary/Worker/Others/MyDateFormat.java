package com.jolpai.doctorsdiary.Worker.Others;

import android.util.Log;

import com.jolpai.doctorsdiary.App;
import com.jolpai.doctorsdiary.Worker.Parse.LongParser;

import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by User on 11/30/2016.
 */

public class MyDateFormat {


    /*
    * @param year : selected year by user
     * @param month : selected month of @year
     * @param day : selected day of @month
     * @return date :dd/MM/yyyy formatted date.
    * */
    public static String getDateDDMMYY(int year,int month,int day){
        String date="NA";
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
          date= df.format(df.parse(day + "/" + month + "/" + year));
            //date= df.format(df.parse("4/11/2016"));
        }catch (Exception ex){
           // Log.e(App.EXCEPTION,ex.getMessage());
        }
        return date;
    }

    public static String getMonthName(int year,int month){
        String date="Date";
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month]+"- "+year;
    }

    public static int getCurrentMonth(){
        int month=0;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, c.get(Calendar.YEAR));
        c.set(Calendar.MONTH, c.get(Calendar.MONTH));

        //int year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH)+1;
        //int dd = c.get(Calendar.DAY_OF_MONTH);
        //int numDays = c.getActualMaximum(Calendar.DATE);

        return month;
    }

    public static int getCurrentYear(){
        int year=0;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, c.get(Calendar.YEAR));
        c.set(Calendar.MONTH, c.get(Calendar.MONTH));
        year = c.get(Calendar.YEAR);
        return year;
    }

    public static int getCurrentDay(){
        int day=0;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, c.get(Calendar.YEAR));
        c.set(Calendar.MONTH, c.get(Calendar.MONTH));

        day = c.get(Calendar.DAY_OF_MONTH);
       // int numDays = c.getActualMaximum(Calendar.DATE);
        return day;
    }

    public static String getDateTimeNow(){

        Calendar c = Calendar.getInstance();
        return Long.toString(c.getTimeInMillis());

    }

    public static int getNumOfDayOfMonth(int year, int month){
        int numOfDays=0;
        Calendar mycal = new GregorianCalendar(year, month, 1);

        numOfDays = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return numOfDays;

    }

    public static String getDDMMYYTT(String timeStamp){

        Timestamp stamp = new Timestamp(LongParser.parseStrToLong(timeStamp));
        Date date = new Date(stamp.getTime());
        Format formatter = new SimpleDateFormat("EEE, dd MMM yyyy, hh:mm a");
        return formatter.format(date);
    }

    public static String getDDMMMYY(String timeStamp){

        Timestamp stamp = new Timestamp(LongParser.parseStrToLong(timeStamp));
        Date date = new Date(stamp.getTime());
        Format formatter = new SimpleDateFormat("dd MMMM yyyy");
        return formatter.format(date);
    }
}
