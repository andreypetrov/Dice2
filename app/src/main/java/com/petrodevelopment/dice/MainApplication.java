package com.petrodevelopment.dice;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.petrodevelopment.dice.shuffle.model.ModelFacade;

/**
 * Created by andrey on 10/07/2015.
 */
public class MainApplication extends Application {
    private ModelFacade modelFacade;
    private Preferences preferences;


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

    public ModelFacade getModelFacade() {
        if (modelFacade == null) modelFacade = new ModelFacade(this);
        return modelFacade;
    }

    public Preferences getPreferences() {
        if (preferences == null) preferences = new Preferences(this);
        return preferences;
    }
}
