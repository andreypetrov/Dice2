package com.petrodevelopment.dice;

import android.app.Fragment;

import com.petrodevelopment.dice.shuffle.model.ModelFacade;

/**
 * Created by andrey on 28/05/2015.
 */
public class BaseFragment extends Fragment {

    public MainApplication getApp() {
        return (MainApplication) getActivity().getApplication();
    }
    public Preferences getPreferences (){
        return getApp().getPreferences();
    }
    public ModelFacade getModelFacade() {
        return  getApp().getModelFacade();
    }
}
