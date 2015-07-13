package com.petrodevelopment.dice.shuffle.model;

import java.util.Collection;
import java.util.List;

/**
 * A collection which can be shuffled and from which you can pick a random element
 * Created by andrey on 12/07/2015.
 */
public interface IRandomList<E> extends RandomPick<E>{
    int size();
    E get(int index);
    boolean add(E element);
    void add(int index, E element);
}
