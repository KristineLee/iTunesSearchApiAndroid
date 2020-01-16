package com.w3kj.itunessearchapicodingchallenge.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*******************************************************************************
 * Created by   : Kristine Carol A. Lee
 * Date Created : January 16, 2019.
 ******************************************************************************/

public final class Utils {

    private static final String prefName = "iTunesSearchApi";

    /*******************************************************************************
     * A set method that put the value of date into the SharedPreferences where in
     * the key is prevDateVisiited which is the name of the preference to modify.
     *
     * @param context The context of the preferences whose values are wanted.
     * @param date  The value for the preference.
     ******************************************************************************/
    public void setPrevDateVisited(Context context, String date) {
        SharedPreferences pref = context.getSharedPreferences( prefName, /* MODE_PRIVATE */0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("prevDateVisiited", date);
        editor.commit();
    }

    /*******************************************************************************
     * A get method that get the value from the key (prevDateVisiited) and return
     * the said value.
     *
     * prevDateVisiited is the name of the preference to modify.
     *
     * @param context The context of the preferences whose values are wanted.
     * @return result The value from the prevDateVisiited.
     ******************************************************************************/
    public String getPrevDateVisited(Context context) {
        String result = null;
        SharedPreferences settings = context.getSharedPreferences(prefName, /* MODE_PRIVATE */0);
        result = settings.getString("prevDateVisiited", "");
        return result;
    }

    /*******************************************************************************
     * A method that format the value of dateString into the pattern "dd-MM-yyyy"
     * @param dateString
     * @return The formatted dateString.
     ******************************************************************************/
    public static String dateFormat(String dateString){

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            Date date = fmt.parse(dateString);
            SimpleDateFormat fmtOut = new SimpleDateFormat("dd-MM-yyyy");
            return fmtOut.format(date);
        } catch(ParseException e){
            e.printStackTrace();
        }
        return null;
    }

}
