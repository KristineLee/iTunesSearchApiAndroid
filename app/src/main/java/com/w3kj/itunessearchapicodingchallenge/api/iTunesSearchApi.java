package com.w3kj.itunessearchapicodingchallenge.api;

import com.w3kj.itunessearchapicodingchallenge.model.SongResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/***************************************************************************
 *  Created by : Kristine Carol A. Lee
 *  Date Created : January 15, 2020
 **************************************************************************/

public interface iTunesSearchApi {

    /***************************************************************************
     * BASE_URL - contains the root URL of the iTunesSearch Api.
     ***************************************************************************/
    String BASE_URL = "https://itunes.apple.com/";

    /****************************************************************************
     * A http GET request
     * @return type is Call. Type of Call is a List. Type of the List is Song.
     ***************************************************************************/
    @GET("search?term=star&amp;country=au&amp;media=movie&amp;all")
    Call<SongResponse> getSongList();
}
