package com.petrodevelopment.dice.model;

import com.google.gson.Gson;

/**
 * Created by andrey on 12/07/2015.
 */
public class Model {


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
