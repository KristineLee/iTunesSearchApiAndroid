package com.w3kj.itunessearchapicodingchallenge.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.w3kj.itunessearchapicodingchallenge.activity.SongDetailsActivity;
import com.w3kj.itunessearchapicodingchallenge.model.Song;
import com.w3kj.itunessearchapicodingchallenge.R;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.SongViewHolder> {

    private List<Song> songList;
    private int rowLayout;
    private Context context;

    public SongListAdapter( List<Song> songs, int rowLayout, Context context ) {
        this.songList = songs;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public SongListAdapter.SongViewHolder onCreateViewHolder( ViewGroup parent,
                                                              int viewType ) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                rowLayout, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, final int position) {

        Picasso.with(holder.songImage.getContext())
                .load(songList.get(position).getArtworkUrl100())
                .placeholder(R.mipmap.ic_launcher) // optional
                .error(R.mipmap.ic_launcher) // if there is an error that occurs
                .into(holder.songImage);

        if( TextUtils.isEmpty( songList.get(position).getTrackName() ) ){
            holder.songTrackName.setText( songList.get(position).getCollectionName() );
        }
        else {
            holder.songTrackName.setText( songList.get(position).getTrackName() );
        }
        holder.songArtistName.setText( songList.get(position).getArtistName() );

        if( TextUtils.isEmpty( songList.get(position).getTrackPrice() ) ) {
            holder.songTrackPrice.setText( "$" + songList.get(position).getCollectionPrice() );
        }
        else{
            holder.songTrackPrice.setText( "$" + songList.get(position).getTrackPrice() );
        }

        holder.songTrackGenre.setText( songList.get(position).getPrimaryGenreName() );

        holder.songLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, SongDetailsActivity.class);

                /*****************************************************************************
                 * If song has no trackName. The value of the trackName will be the
                 * collectionName.
                 ****************************************************************************/
                if( TextUtils.isEmpty(songList.get(position).getTrackName()) ) {
                    intent.putExtra("trackName", songList.get(position).getCollectionName());
                }
                else {
                    intent.putExtra("trackName", songList.get(position).getTrackName());
                }

                intent.putExtra("artistName", songList.get(position).getArtistName());
                intent.putExtra("releaseDate", songList.get(position).getReleaseDate());
                intent.putExtra("artworkUrl100", songList.get(position).getArtworkUrl100());

                /*****************************************************************************
                 * If song has no trackPrice. The value of the trackPrice will be the
                 * collectionPrice.
                 ****************************************************************************/
                if( TextUtils.isEmpty(songList.get(position).getTrackPrice()) ) {
                    intent.putExtra("trackPrice", songList.get(position).getCollectionPrice());
                }
                else {
                    intent.putExtra("trackPrice", songList.get(position).getTrackPrice());
                }

                /*****************************************************************************
                 * If song has no longDescription. The value of the longDescription will be
                 * the "This song has no description."
                 ****************************************************************************/
                if( TextUtils.isEmpty(songList.get(position).getLongDescription()) ) {
                    intent.putExtra("longDescription", "This song has no description.");
                }
                else {
                    intent.putExtra("longDescription", songList.get(position).getLongDescription());
                }

                intent.putExtra("primaryGenreName", songList.get(position).getPrimaryGenreName());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public static class SongViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.song_layout)
        RelativeLayout songLayout;

        @BindView(R.id.song_image)
        ImageView songImage;

        @BindView(R.id.song_track_name)
        TextView songTrackName;

        @BindView(R.id.song_artist_name)
        TextView songArtistName;

        @BindView(R.id.song_track_price)
        TextView songTrackPrice;

        @BindView(R.id.song_track_genre)
        TextView songTrackGenre;

        public SongViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
