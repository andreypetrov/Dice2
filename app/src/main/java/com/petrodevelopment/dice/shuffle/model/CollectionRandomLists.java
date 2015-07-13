package com.petrodevelopment.dice.shuffle.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrey on 12/07/2015.
 */
public class CollectionRandomLists<E> {
    private List<RandomList<E>> randomLists;
    private List<Integer> currentlyPickedIndices;
    private List<E> currentlyPickedElements;



    public CollectionRandomLists(RandomList<E>... elements) {
        randomLists = new ArrayList<>();
        for (RandomList<E> element : elements) {
            randomLists.add(element);
        }
    }


    List<Integer> getCurrentPickedIndices() {
        List<Integer> result = new ArrayList<>();
        for (RandomList<E> randomList : randomLists) {
            result.add(randomList.getCurrentPickedIndex());
        }
        return result;
    }

    List<E> getCurrentPickedElements() {
        List<E> result = new ArrayList<>();
        for (RandomList<E> randomList : randomLists) {
            result.add(randomList.getCurrentPickedElement());
        }
        return result;
    }


    List<Integer> pickRandomIndices() {  //pick a random combination of one index per list
        List<Integer> randomIndices = new ArrayList<>();
        for (RandomList<E> randomList : randomLists) {
            randomIndices.add(randomList.pickRandomIndex());
        }
        return randomIndices;
    }

    List<E> pickRandom() { //pick a random combination of one element per list
        List<E> randomElements = new ArrayList<>();
        for (RandomList<E> randomList : randomLists) {
            randomElements.add(randomList.pickRandom());
        }
        return randomElements;
    }

    public List<RandomList<E>> getRandomLists() {
        return randomLists;
    }

    public void setRandomLists(List<RandomList<E>> randomLists) {
        this.randomLists = randomLists;
    }
}
