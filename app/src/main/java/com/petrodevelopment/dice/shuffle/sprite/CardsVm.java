package com.petrodevelopment.dice.shuffle.sprite;

import android.view.View;

import com.petrodevelopment.dice.shuffle.model.Card;
import com.petrodevelopment.dice.shuffle.model.RandomList;

/**
 * Created by andrey on 12/07/2015.
 */
public class CardsVm implements  PickRandomVm {
    RandomList<Card> cards;

    @Override
    public void pickRandom() {
        cards.pickRandom();
    }

    @Override
    public String getCommonViewUrl() {
        return cards.getImageUrl();
    }

    @Override
    public String getPickedUrl() {
        return cards.getCurrentPickedElement().imageUrl;
    }


}
