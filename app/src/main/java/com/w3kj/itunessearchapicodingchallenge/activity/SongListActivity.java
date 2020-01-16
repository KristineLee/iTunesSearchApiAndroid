package com.w3kj.itunessearchapicodingchallenge.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.Toolbar;

import com.w3kj.itunessearchapicodingchallenge.R;
import com.w3kj.itunessearchapicodingchallenge.adapter.SongListAdapter;
import com.w3kj.itunessearchapicodingchallenge.api.iTunesSearchApi;
import com.w3kj.itunessearchapicodingchallenge.model.Song;
import com.w3kj.itunessearchapicodingchallenge.model.SongResponse;
import com.w3kj.itunessearchapicodingchallenge.utils.Utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SongListActivity extends AppCompatActivity {

    @BindView(R.id.song_recycler_view)
    RecyclerView recyclerView;

    private Utils utilsSongList = new Utils();
    List<Song> songList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("iTunes Search API List");

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(iTunesSearchApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        recyclerView.setLayoutManager(new LinearLayoutManager(SongListActivity.this));

        iTunesSearchApi iTunesSearchApi = retrofit.create(iTunesSearchApi.class);

        Call<SongResponse> callSongResponse = iTunesSearchApi.getSongList();

        /*****************************************************************************************
         *  If there is an Internet Connection call the api and display the values from the api.
         *  else display an AlertDialog that display a message informing the user that there is
         *  no internet connection
         ****************************************************************************************/
        if(isNetworkAvailable()) {

            /************************************************************************************
             *  If getPrevDateVisited from the Utils Class has a value. An AlertDialog will
             *  be display informing the user when he/she last visited the Application.
             *
             *  Else if getPrevDateVisited from the Utils Class has no value. Then the
             *  setPrevDateVisited method will be called from the Utils Class and the current
             *  time will be the parameter of the said method.
             ***********************************************************************************/
            if( !utilsSongList.getPrevDateVisited(this).isEmpty()){
                String message = String.format( this.getResources().getString(R.string.lastVisitedMessage),
                        utilsSongList.getPrevDateVisited(this));

                new AlertDialog.Builder(SongListActivity.this)
                        .setTitle(getResources().getString(R.string.lastVisitedMessageTitle))
                        .setMessage(message)
                        .setPositiveButton("OK", null).show();
            }
            else if( utilsSongList.getPrevDateVisited(this).isEmpty()){
                utilsSongList.setPrevDateVisited( this, java.text.DateFormat.
                        getDateTimeInstance().format( Calendar.getInstance().getTime()) );
            }

            /**********************************************************************************
             *  Retrofit will download and parse the API data on a background thread, and
             *  then return the results back to the UI thread via the onResponse or onFailure
             *  method.
             *********************************************************************************/
            callSongResponse.enqueue(new Callback<SongResponse>() {
                @Override
                public void onResponse(Call<SongResponse> call, Response<SongResponse> response) {
                    songList = response.body().getResults();
                    recyclerView.setAdapter(new SongListAdapter(songList, R.layout.list_item_songs,
                            getApplicationContext()));
                }

                @Override
                public void onFailure(Call<SongResponse> call, Throwable t) {
                    Log.e("error", t.toString());
                }
            });

        } else{
            new AlertDialog.Builder(SongListActivity.this)
                    .setTitle(getResources().getString(R.string.app_name))
                    .setMessage(getResources().getString(R.string.internet_error))
                    .setPositiveButton("OK", null).show();
        }

    }

    /*****************************************************************************************
     *  A function that checks whether there is an Internet Connection or not.
     *  If there is an Internet Connection the return value is true
     *  else if there is No Internet Connection the return value is false.
     *
     *  @return a boolean value that
     ****************************************************************************************/
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
