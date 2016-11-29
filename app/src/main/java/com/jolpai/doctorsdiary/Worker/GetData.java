package com.jolpai.doctorsdiary.Worker;

import android.content.Context;
import android.util.Log;

import com.jolpai.doctorsdiary.Realm_Model.DailyReport;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by User on 11/17/2016.
 */

public class GetData {

    public static RealmResults getOneMonthReportFromRealm(Context context, final Class<RealmObject> clazz){
        Realm.init(context);
        Realm realm =Realm.getDefaultInstance();
        RealmResults<RealmObject> result = realm.where(clazz).findAll();
        return result;
    }

    public static RealmResults getOneDayReportFromRealm(Context context, final Class<RealmObject> clazz){
        Realm.init(context);
        Realm realm =Realm.getDefaultInstance();
        RealmQuery<RealmObject> query = realm.where(clazz);
        query.equalTo("toDay",3);
        RealmResults<RealmObject> result = query.findAll();



        return result;
    }
}
