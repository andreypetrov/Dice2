package com.petrodevelopment.dice.shuffle.model;

import android.content.Context;

/**
 * A united access to the model classes
 * Created by andrey on 30/05/2015.
 */
public class ModelFacade {
    public static final String CARDS = "cards";
    public static final String DICE = "dice";
    public static final String ROULETTE = "roulette";
    private Context context;

    //All model data is stored here
    private RandomList<Card> cards;
    private CollectionRandomLists<DieSide> dice;
    private RandomList<RouletteNumber> roulette;


    public ModelFacade(Context context) {
        this.context = context;
        loadModel();
    }



    public void loadModel() {
        initCards();
        initDice();
        initRoulette();
    }

    private void initRoulette() {
        roulette = RandomList.createFromJsonFile("cards", context);
    }

    private void initDice() {
        RandomList<DieSide> die1 = RandomList.createFromJsonFile("dice", context);
        RandomList<DieSide> die2 = RandomList.createFromJsonFile("dice", context);
        dice = new CollectionRandomLists<DieSide>(die1, die2);

    }

    private void initCards() {
        cards = RandomList.createFromJsonFile("cards", context);
    }

    public void saveModel() {
        //no saving for now
    }
}
