package com.jolpai.doctorsdiary.Worker.Database;

import android.content.Context;

import com.jolpai.doctorsdiary.Worker.Parse.StrParser;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by User on 11/17/2016.
 */

public class GetData {

    public static RealmResults getOneMonthReportFromRealm(Context context, final Class<RealmObject> clazz,int year, int month){
        Realm.init(context);
        Realm realm =Realm.getDefaultInstance();
        RealmQuery<RealmObject> query = realm.where(clazz);
        query.equalTo("year",year);
        query.equalTo("month",month);
        RealmResults<RealmObject> result = query.findAll();
        return result;
    }

    public static RealmResults getOneMonthCommentFromRealm(Context context, final Class<RealmObject> clazz, int year,int month,int day){
        Realm.init(context);
        Realm realm =Realm.getDefaultInstance();
        RealmQuery<RealmObject> query = realm.where(clazz);
        query.equalTo("year",year);
        query.equalTo("month",month);
        query.equalTo("day",day);
        RealmResults<RealmObject> result = query.findAll();
        return result;
    }

    public static RealmResults getOneDayReportFromRealm(Context context, final Class<RealmObject> clazz,String date){
        Realm.init(context);
        Realm realm =Realm.getDefaultInstance();
        RealmQuery<RealmObject> query = realm.where(clazz);
        query.equalTo("date",date);
        RealmResults<RealmObject> result = query.findAll();
        return result;
    }

    public static RealmResults getTotalOneMonthReport(Context context,final Class<RealmObject> clazz,int year, int month){

        Realm.init(context);
        Realm realm =Realm.getDefaultInstance();
        RealmQuery<RealmObject> query = realm.where(clazz);
        query.equalTo("year",year);
        query.equalTo("month",month);
        query.equalTo("hasReport",true);
        RealmResults<RealmObject> result = query.findAll();

        return result;
    }

    public static String getTotalQuranStudyDay(Context context, final Class<RealmObject> clazz, int year, int month){
        Realm.init(context);
        Realm realm =Realm.getDefaultInstance();
        RealmQuery<RealmObject> query = realm.where(clazz);
        query.equalTo("year",year);
        query.equalTo("month",month);
        query.equalTo("quranStudy",true);
        RealmResults<RealmObject> result = query.findAll();

        return result.size()+"";
    }

    public static String getTotalFamilyMeetingDay(Context context,final Class<RealmObject> clazz, int year,int month){
        Realm.init(context);
        Realm realm =Realm.getDefaultInstance();
        RealmQuery<RealmObject> query = realm.where(clazz);
        query.equalTo("year",year);
        query.equalTo("month",month);
        query.equalTo("familyMeeting",true);
        RealmResults<RealmObject> result = query.findAll();

        return StrParser.parseIntToString(result.size());
    }

    public static String getTotalVisitDay(Context context, final Class<RealmObject> clazz, int year, int month){
        Realm.init(context);
        Realm realm =Realm.getDefaultInstance();
        RealmQuery<RealmObject> query = realm.where(clazz);
        query.equalTo("year",year);
        query.equalTo("month",month);
        query.equalTo("visit",true);
        RealmResults<RealmObject> result = query.findAll();

        return StrParser.parseIntToString(result.size());
    }


    public static String getTotalReportKeepingDay(Context context, final Class<RealmObject> clazz, int year, int month){
        Realm.init(context);
        Realm realm =Realm.getDefaultInstance();
        RealmQuery<RealmObject> query = realm.where(clazz);
        query.equalTo("year",year);
        query.equalTo("month",month);
        query.equalTo("reportKeeping",true);
        RealmResults<RealmObject> result = query.findAll();

        return StrParser.parseIntToString(result.size());
    }

    public static String getTotalSelfAssessmentDay(Context context, final Class<RealmObject> clazz, int year, int month){
        Realm.init(context);
        Realm realm =Realm.getDefaultInstance();
        RealmQuery<RealmObject> query = realm.where(clazz);
        query.equalTo("year",year);
        query.equalTo("month",month);
        query.equalTo("selfAssessment",true);
        RealmResults<RealmObject> result = query.findAll();

        return StrParser.parseIntToString(result.size());
    }


    public void executeQuery(){


    }
}
