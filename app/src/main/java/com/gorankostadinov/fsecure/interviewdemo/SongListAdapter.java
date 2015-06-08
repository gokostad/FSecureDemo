package com.gorankostadinov.fsecure.interviewdemo;

import android.app.Activity;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ListView;
import android.R.layout.*;

import com.gorankostadinov.fsecure.interviewdemo.datasource.StaticDataSource;
import com.gorankostadinov.fsecure.interviewdemo.datasource.StaticDataSource.Song;

/**
 * Adapter, enabling us to show title, picture and band name
 */
public class SongListAdapter extends ArrayAdapter<Song> {

    private final Activity context;

    public SongListAdapter(Activity context) {
        super(context, R.layout.activity_song_list, StaticDataSource.SONGS);

        this.context = context;
    }

    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_song_list_item, null, true);

        TextView txtSongTitle = (TextView)rowView.findViewById(R.id.songTitle);
        ImageView imgSongPicture = (ImageView)rowView.findViewById(R.id.songPicture);
        TextView txtBandName = (TextView)rowView.findViewById(R.id.bandName);

        Song song = StaticDataSource.SONGS.get(position);
        txtSongTitle.setText(song.getName());
        imgSongPicture.setImageResource(song.getImgid());
        txtBandName.setText(song.getBand());
        return rowView;
    };
}
