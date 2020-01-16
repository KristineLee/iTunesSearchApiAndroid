package com.w3kj.itunessearchapicodingchallenge.model;

import com.google.gson.annotations.SerializedName;

/***********************************************************************
 *  Created by   : Kristine Carol A. Lee
 *  Date Created : January 16, 2020
 **********************************************************************/

public class Song {

    @SerializedName("artistName")
    private String artistName;

    @SerializedName("collectionName")
    private String collectionName;

    @SerializedName("trackName")
    private String trackName;

    @SerializedName("artworkUrl100")
    private String artworkUrl100;

    @SerializedName("collectionPrice")
    private String collectionPrice;

    @SerializedName("trackPrice")
    private String trackPrice;

    @SerializedName("releaseDate")
    private String releaseDate;

    @SerializedName("primaryGenreName")
    private String primaryGenreName;

    @SerializedName("longDescription")
    private String longDescription;


    /***********************************************************************
     * Constructor for the java class Song
     * @param artistName contains the artist name of the song
     * @param collectionName contains the collection name of the song
     * @param trackName contains the track name of the song
     * @param artworkUrl100 contains the song image of the song
     * @param collectionPrice contains the collection price of the song
     * @param trackPrice contains the track price of the song
     * @param releaseDate contains the release date of the song
     * @param primaryGenreName contains the genre of the song
     * @param longDescription contains the long description of the song
     **********************************************************************/

    public Song( String artistName,
                 String collectionName,
                 String trackName,
                 String artworkUrl100,
                 String collectionPrice,
                 String trackPrice,
                 String releaseDate,
                 String primaryGenreName,
                 String longDescription) {

        this.artistName = artistName;
        this.collectionName = collectionName;
        this.trackName = trackName;
        this.artworkUrl100 = artworkUrl100;
        this.collectionPrice = collectionPrice;
        this.trackPrice = trackPrice;
        this.releaseDate = releaseDate;
        this.primaryGenreName = primaryGenreName;
        this.longDescription = longDescription;
    }

    /**********************************************************************
     * Setter method for the artistName variable
     * @param artistName - contains the artist name of the song
     *********************************************************************/
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    /***********************************************************************
     * Setter method for the collectionName variable
     * @param collectionName - contains the collection name of the song
     **********************************************************************/
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    /***********************************************************************
     * Setter method for the trackName variable
     * @param trackName - contains the track name of the song
     **********************************************************************/
    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    /***********************************************************************
     * Setter method for the artworkUrl100 variable
     * @param artworkUrl100 - contains the artworkUrl100 of the song
     **********************************************************************/
    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    /***********************************************************************
     * Setter method for the collectionPrice variable
     * @param collectionPrice - contains the collection price of the song
     **********************************************************************/
    public void setCollectionPrice(String collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    /***********************************************************************
     * Setter method for the trackPrice variable
     * @param trackPrice - contains the track price of the song
     **********************************************************************/
    public void setTrackPrice(String trackPrice) {
        this.trackPrice = trackPrice;
    }

    /***********************************************************************
     * Setter method for the releaseDate variable
     * @param releaseDate - contains the release date of the song
     **********************************************************************/
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /***********************************************************************
     * Setter method for the primaryGenreName variable
     * @param primaryGenreName - contains the primary genre name of the song
     **********************************************************************/
    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    /***********************************************************************
     * Setter method for the longDescription variable
     * @param longDescription - contains the long description of the song
     **********************************************************************/
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    /***********************************************************************
     * getter for the artistName variable
     * @return artistName - return the value of the artistName variable
     **********************************************************************/
    public String getArtistName() {
        return artistName;
    }

    /***********************************************************************
     * getter method for the collectionName variable
     * @return collectionName - return the value of the collectionName
     *                          variable
     **********************************************************************/
    public String getCollectionName() {
        return collectionName;
    }

    /***********************************************************************
     * getter method for the trackName variable
     * @return trackName - return the value of the trackName variable
     **********************************************************************/
    public String getTrackName() {
        return trackName;
    }

    /***********************************************************************
     * getter method for the artworkUrl100 variable
     * @return artworkUrl100 - return the value of the artworkUrl100
     *                         variable
     **********************************************************************/
    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    /***********************************************************************
     * getter method for the collectionPrice variable
     * @return collectionPrice - return the value of the collectionPrice
     *                           variable
     **********************************************************************/
    public String getCollectionPrice() {
        return collectionPrice;
    }

    /***********************************************************************
     * getter method for the trackPrice variable
     * @return trackPrice - return the value of the trackPrice variable
     **********************************************************************/
    public String getTrackPrice() { return trackPrice; }

    /***********************************************************************
     * getter method for the releaseDate variable
     * @return releaseDate - return the value of the releaseDate variable
     **********************************************************************/
    public String getReleaseDate() {
        return releaseDate;
    }

    /***********************************************************************
     * getter method for the primaryGenreName variable
     * @return primaryGenreName - return the value of the primaryGenreName
     *                            variable
     **********************************************************************/
    public String getPrimaryGenreName() { return primaryGenreName; }

    /***********************************************************************
     * getter method for the longDescription variable
     * @return longDescription - return the value of the longDescription
     *                           variable
     **********************************************************************/
    public String getLongDescription() {
        return longDescription;
    }

}
