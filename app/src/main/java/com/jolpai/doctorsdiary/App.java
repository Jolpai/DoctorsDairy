package com.jolpai.doctorsdiary;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.facebook.stetho.Stetho;

import javax.annotation.Nonnull;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by User on 10/11/2016.
 */

public class App extends Application {

    public static Context context;
    private Application application;


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        initStetho();
        initRealmConfigutation();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    protected void initRealmConfigutation() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    protected void initStetho() {
        Stetho.initializeWithDefaults(this);
    }

    protected void initApplicationGraph(){
        //applicationGraph = ObjectGraph.create(new ApplicationModule());
    }


    public static void injectModules(@Nonnull final Object object,final Object... modules){
       // context.applicationGraph.Plus(modules).inject(object);
    }
}