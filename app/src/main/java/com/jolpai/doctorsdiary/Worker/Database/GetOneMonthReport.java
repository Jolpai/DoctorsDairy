package com.jolpai.doctorsdiary.Worker.Database;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Tanim reja on 11/21/2017.
 */

public class GetOneMonthReport implements Get {
    @Override
    public RealmResults GetRealmResults(Context context, final Class<RealmObject> clazz) {

        Realm.init(context);
        Realm realm =Realm.getDefaultInstance();
        RealmQuery<RealmObject> query = realm.where(clazz);
       // query.equalTo("year",year);
       // query.equalTo("month",month);
        RealmResults<RealmObject> result = query.findAll();
        return result;
    }

   // public RealmResults getR
}
