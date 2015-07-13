package com.petrodevelopment.dice.shuffle.model;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.petrodevelopment.dice.model.Model;
import com.petrodevelopment.dice.util.Util;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by andrey on 12/07/2015.
 */
public class RandomList<E> extends Model implements IRandomList<E> {
    private String imageUrl;
    private List<E> data;
    private E currentPickedElement;
    private int currentPickedIndex;

    public RandomList () {
    }

    public RandomList (List<E> data) {
        this.data = data;
    }

    public static <E> RandomList<E> createFromJsonFile (String fileName, Context context) {
        return createFromJson(Util.jsonFromAsset(fileName, context));
    }

    public static <E> RandomList<E> createFromJson(String json) {
        GsonBuilder gson = new GsonBuilder();
        Type randomListType = new TypeToken<RandomList<E>>() {}.getType();
        RandomList<E> result = gson.create().fromJson(json, randomListType);
        return result;
    }

    public static RandomList createRandomList(String json) {
        RandomList randomList = new Gson().fromJson(json, RandomList.class);
        return randomList;
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public E get(int index) {
        return data.get(index);
    }

    @Override
    public boolean add(E element) {
        return data.add(element);
    }

    @Override
    public void add(int index, E element) {
        data.add(index, element);
    }

    /**
     * Every time will return different index between 0 and size-1
     * @return
     */
    @Override
    public int pickRandomIndex() {
        currentPickedIndex = Util.randInt(0, size() - 1);
        currentPickedElement = get(currentPickedIndex);
        return currentPickedIndex;
    }

    /**
     * Every time will return different element from the list
     * @return
     */
    @Override
    public E pickRandom() {
        return get(pickRandomIndex());
    }


    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public E getCurrentPickedElement() {
        return currentPickedElement;
    }

    public void setCurrentPickedElement(E currentPickedElement) {
        this.currentPickedElement = currentPickedElement;
    }

    public int getCurrentPickedIndex() {
        return currentPickedIndex;
    }

    public void setCurrentPickedIndex(int currentPickedIndex) {
        this.currentPickedIndex = currentPickedIndex;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
