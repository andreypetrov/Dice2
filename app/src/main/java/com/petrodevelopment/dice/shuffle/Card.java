package com.petrodevelopment.dice.shuffle;

import com.petrodevelopment.dice.model.Model;

/**
 * Created by andrey on 12/07/2015.
 */
public class Card  extends Model {
    public int value; //1 to 13, where 1 is Ace and 13 is King
    public String suit;

    public String imageUrl;
    public String name; //for example K♦ Q♣ J♠ 10♥
}
