package com.gorankostadinov.fsecure.interviewdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gorankostadinov.fsecure.interviewdemo.datasource.StaticDataSource;

/**
 * A fragment representing a single Song detail screen.
 * This fragment is either contained in a {@link SongListActivity}
 * in two-pane mode (on tablets) or a {@link SongDetailActivity}
 * on handsets.
 */
public class SongDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    public static final int DESCRIPTION_MAX_LENGTH = 200;

    /**
     * The content this fragment is presenting.
     */
    private StaticDataSource.Song mSong;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SongDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mSong = StaticDataSource.SONG_MAP.get(Integer.parseInt(
                    getArguments().get(ARG_ITEM_ID).toString()));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_song_detail, container, false);

        // Show the content.
        if (mSong != null) {
            TextView txtSongTitle = (TextView)rootView.findViewById(R.id.songTitle);
            ImageView imgSongPicture = (ImageView)rootView.findViewById(R.id.songPicture);
            TextView txtBandName = (TextView)rootView.findViewById(R.id.bandName);
            TextView txtDesc = (TextView)rootView.findViewById(R.id.songDescription);

            txtSongTitle.setText(mSong.getName());
            imgSongPicture.setImageResource(mSong.getImgid());
            txtBandName.setText(mSong.getBand());
            txtDesc.setText(mSong.getDescriptor().substring(0,
                                mSong.getDescriptor().length() > DESCRIPTION_MAX_LENGTH ?
                                DESCRIPTION_MAX_LENGTH : mSong.getDescriptor().length()));
        }

        return rootView;
    }
}
