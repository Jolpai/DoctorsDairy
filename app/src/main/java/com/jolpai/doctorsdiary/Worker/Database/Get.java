package com.jolpai.doctorsdiary.Worker.Database;

import android.content.Context;

import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Tanim reja on 11/21/2017.
 */

public interface Get {

    RealmResults GetRealmResults (Context context, final Class<RealmObject> clazz);
}
