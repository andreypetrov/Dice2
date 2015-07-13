package com.petrodevelopment.dice.shuffle.model;

/**
 * Created by andrey on 12/07/2015.
 */
public interface RandomPick<E> {
    int pickRandomIndex(); //pick the index of a random element
    E pickRandom(); //pick a random element
}
