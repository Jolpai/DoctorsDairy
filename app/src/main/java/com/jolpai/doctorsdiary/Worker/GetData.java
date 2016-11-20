package com.jolpai.doctorsdiary.Worker;

import android.content.Context;
import android.util.Log;

import com.jolpai.doctorsdiary.Realm_Model.DailyReport;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by User on 11/17/2016.
 */

public class GetData {

    public static RealmResults getDataFromRealm(Context context,final Class<RealmObject> clazz){
        Realm.init(context);
        Realm realm =Realm.getDefaultInstance();
        RealmResults<RealmObject> result = realm.where(clazz).findAll();


       // DailyReport pfm= (DailyReport) result.get(0);

       // Log.e("realm",pfm.getDate()+"   "+result.size());
        return result;
    }
}
