package com.jolpai.doctorsdiary.Worker;

import android.content.Context;
import android.util.Log;

import com.jolpai.doctorsdiary.App;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by User on 11/13/2016.
 */

public class SaveData {
   // static Realm realm=null;
    public static void saveDataToRealm(Context context, final RealmObject obj, final Class<RealmObject> clazz){

        Realm.init(context);

        Realm realm =Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //RealmObject planForMonth = realm.createObject(clazz);
               // realm.copyToRealm(obj);
                realm.copyToRealmOrUpdate(obj);
            }
        },new Realm.Transaction.OnSuccess(){
            @Override
            public void onSuccess() {
                // Transaction was a success.
                Log.e(App.ACTION_MSG,"Data Save Successfully");
                //returnType =true;
            }
        },new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
                Log.e(App.ACTION_MSG,"Data Save Failed !!");
            }
        });

    }
}
