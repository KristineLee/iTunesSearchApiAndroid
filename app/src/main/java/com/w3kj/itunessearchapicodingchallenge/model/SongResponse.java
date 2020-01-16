package com.w3kj.itunessearchapicodingchallenge.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/***********************************************************************
 *  Created by : Kristine Carol A. Lee
 *  Date Created : January 16, 2020
 **********************************************************************/

public class SongResponse {

    @SerializedName("resultCount")
    private int resultCount;

    @SerializedName("results")
    private List<Song> results;

    /***********************************************************************
     * getter method for the resultCount variable
     * @return resultCount - return the value of the resultCount variable
     **********************************************************************/
    public int getResultCount() {
        return resultCount;
    }

    /***********************************************************************
     * Setter method for the resultCount variable
     * @param resultCount - contains the resultCount
     **********************************************************************/
    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    /***********************************************************************
     * getter method for the results variable
     * @return results - return the value of the results variable
     **********************************************************************/
    public List<Song> getResults() {
        return results;
    }

    /***********************************************************************
     * Setter method for the results variable
     * @param results - contains the results
     **********************************************************************/
    public void setResults(List<Song> results) {
        this.results = results;
    }
}
