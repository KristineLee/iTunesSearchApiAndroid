package com.w3kj.itunessearchapicodingchallenge.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.w3kj.itunessearchapicodingchallenge.R;
import com.w3kj.itunessearchapicodingchallenge.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SongDetailsActivity extends AppCompatActivity {

    private static final String TAG = "SongDetailsActivity";

    @BindView(R.id.song_details_track_name)
    TextView songDetailsTrackName;

    @BindView(R.id.song_details_artist_name)
    TextView songDetailsArtistName;

    @BindView(R.id.song_details_release_date)
    TextView songDetailsReleaseDate;

    @BindView(R.id.song_details_image)
    ImageView songDetailsImaage;

    @BindView(R.id.song_details_track_Price)
    TextView songDetailsTrackPrice;

    @BindView(R.id.song_details_long_description)
    TextView songDetailsLongDescription;

    @BindView(R.id.song_details_track_genre)
    TextView songDetailsTrackGenre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("iTunes Search API Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getExtraIntent();
    }
    
    private void getExtraIntent(){
        Log.d(TAG, "getExtraIntent: ");

        if(     getIntent().hasExtra("trackName" ) &&
                getIntent().hasExtra("artistName" ) &&
                getIntent().hasExtra("releaseDate" ) &&
                getIntent().hasExtra("artworkUrl100" ) &&
                getIntent().hasExtra("trackPrice" ) &&
                getIntent().hasExtra("longDescription" ) &&
                getIntent().hasExtra("primaryGenreName") ){

            String trackNameIntent = getIntent().getStringExtra("trackName");
            String artistNameIntent = getIntent().getStringExtra("artistName");
            String releaseDateIntent = getIntent().getStringExtra("releaseDate");
            String artworkUrl100Intent = getIntent().getStringExtra("artworkUrl100");
            String trackPriceIntent = getIntent().getStringExtra("trackPrice");
            String longDescriptionIntent = getIntent().getStringExtra("longDescription");
            String primaryGenreNameIntent = getIntent().getStringExtra("primaryGenreName");

            setSongDetails( trackNameIntent, artistNameIntent, releaseDateIntent,
                            artworkUrl100Intent, trackPriceIntent, longDescriptionIntent,
                            primaryGenreNameIntent );
        }
    }

    private void setSongDetails( String trackName,
                                 String artistName,
                                 String releaseDate,
                                 String artworkUrl100,
                                 String trackPrice,
                                 String longDescription,
                                 String primaryGenreName ){

        songDetailsTrackName.setText(trackName);
        songDetailsArtistName.setText(artistName);
        songDetailsReleaseDate.setText(Utils.dateFormat(releaseDate));

        Picasso.with(getApplicationContext())
                .load(artworkUrl100)
                .placeholder(R.mipmap.ic_launcher) // optional
                .error(R.mipmap.ic_launcher) // if there is an error that occurs
                .into(songDetailsImaage);

        songDetailsTrackPrice.setText("$" + trackPrice);
        songDetailsLongDescription.setText("\n" + longDescription + "\n");
        songDetailsTrackGenre.setText(primaryGenreName);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
