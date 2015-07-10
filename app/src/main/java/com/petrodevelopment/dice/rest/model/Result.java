package com.petrodevelopment.dice.rest.model;

/**
 * Created by andrey on 09/07/2015.
 */
public class Result {
    private Movie[] Search;

    public Movie[] getSearch ()
    {
        return Search;
    }

    public void setSearch (Movie[] Search)
    {
        this.Search = Search;
    }

    @Override
    public String toString()
    {
        return "ClassResult [Result = "+Search+"]";
    }
}
