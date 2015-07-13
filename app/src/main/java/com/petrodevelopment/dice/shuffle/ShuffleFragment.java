package com.petrodevelopment.dice.shuffle;

import android.app.Fragment;
import android.os.Bundle;

import com.petrodevelopment.dice.BaseFragment;
import com.petrodevelopment.dice.SectionFragment;

/**
 * Created by andrey on 12/07/2015.
 */
public class ShuffleFragment extends SectionFragment {

    public static ShuffleFragment newInstance(int sectionNumber, String sectionTitle) {
        ShuffleFragment fragment = new ShuffleFragment();
        SectionFragment.addSectionAndTitleToFragment(fragment, sectionNumber, sectionTitle);
        //TODO add custom stuff
        return fragment;
    }

}
