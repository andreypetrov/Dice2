package com.petrodevelopment.dice;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by andrey on 10/07/2015.
 */
public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        initStetho();
    }

    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}
