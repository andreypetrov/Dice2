package com.petrodevelopment.dice.shuffle;

import android.content.Context;

import com.google.gson.Gson;
import com.petrodevelopment.dice.util.U;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * Created by andrey on 12/07/2015.
 */
public class Util {
    public final static String JSON_EXTENSION = ".json";
    /**
     * http://stackoverflow.com/questions/363681/generating-random-integers-in-a-range-with-java
     * Returns a pseudo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     */
    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public static String jsonFromAsset(String fileName, Context context) {
        try {
            InputStream stream = context.getAssets().open(fileName + JSON_EXTENSION);
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            return new String(buffer);
        } catch (IOException e) {
            U.log(context, e.getMessage());
            return null;
        }
    }
}
