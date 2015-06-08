package com.gorankostadinov.fsecure.interviewdemo.datasource;

import com.gorankostadinov.fsecure.interviewdemo.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticDataSource {

    public static final int MAX_SONGS = 100;

    public static List<Song> SONGS = new ArrayList<Song>();
    /**
     * A map of sample songs.
     */
    public static Map<Integer, Song> SONG_MAP = new HashMap<Integer, Song>();

    static {
        // add songs to MAX_SONGS in steps of 10
        for (int i = 0; i < MAX_SONGS;) {
            addSong(new Song(i++, "I Bet", "Ciara",
                    "I bet you start loving me\n" +
                            "As soon as I start loving someone else\n" +
                            "Somebody better than you\n" +
                            "I bet you start needing me\n" +
                            "As soon as you see me with someone else\n" +
                            "Somebody other than you...",
                    R.mipmap.ciara));

            addSong(new Song(i++, "Here Comes The Sun", "Beatles",
                    "Here comes the sun\n" +
                            "Here comes the sun, and I say\n" +
                            "It's all right\n" +
                            "Little darling, it's been a long cold lonely winter\n" +
                            "Little darling, it feels like years since it's been here\n" +
                            "Here comes the sun\n" +
                            "Here comes the sun, and I say\n" +
                            "It's all right...",
                    R.mipmap.beatles));

            addSong(new Song(i++, "Without You", "Mariah Carey",
                    "No I can't forget this evening\n" +
                            "Or your face as you were leaving\n" +
                            "But I guess that's just the way\n" +
                            "The story goes\n" +
                            "You always smile but in your eyes\n" +
                            "Your sorrow shows\n" +
                            "Yes it shows..",
                    R.mipmap.carey));

            addSong(new Song(i++, "I Am In Love", "Ella Fitzgerald",
                    "I am dejected. I am depressed.\n" +
                            "Yet resurrected and sailing the crest.\n" +
                            "Why this elation, mixed with deflation?\n" +
                            "What explanation? I am in love...",
                    R.mipmap.fitzgerald));

            addSong(new Song(i++, "Give Me Power", "The Itals",
                    "Give me power every hour - I need it so\n" +
                            "Give me power every hour\n" +
                            "Give me power every hour\n" +
                            "Jah wonderful feeling\n" +
                            "I just can't resist Jah wonderful feeling\n" +
                            "I just can't resist...",
                    R.mipmap.itals));

            addSong(new Song(i++, "Papa Don't Preach", "Madonna",
                    "Papa I know you're going to be upset\n" +
                            "'Cause I was always your little girl\n" +
                            "But you should know by now\n" +
                            "I'm not a baby...",
                    R.mipmap.madona));

            addSong(new Song(i++, "Valentine", "Martina McBride",
                    "if there were no words\n" +
                            "no way to speak\n" +
                            "i would still hear you\n" +
                            "if there were no tears\n" +
                            "no way to feel inside\n" +
                            "i'd still feel for you...",
                    R.mipmap.mcbride));

            addSong(new Song(i++, "Call me", "Blondie",
                    "Colour me your colour, baby\n" +
                            "Colour me your car\n" +
                            "Colour me your colour, darling\n" +
                            "I know who you are\n" +
                            "Come up off your colour chart\n" +
                            "I know where you're comin' from...",
                    R.mipmap.blondie));

            addSong(new Song(i++, "The Magic Flute", "Mozart",
                    "An opera in two acts by Wolfgang Amadeus Mozart " +
                            "to a German libretto by Emanuel Schikaneder. " +
                            "The work is in the form of a Singspiel, " +
                            "a popular form that included both " +
                            "singing and spoken dialogue...",
                    R.mipmap.mozart));

            addSong(new Song(i++, "Imperial march", "Star Wars",
                    "a musical theme present in the Star Wars " +
                            "franchise. It was composed by John Williams " +
                            "for the film Star Wars: The Empire Strikes Back...",
                    R.mipmap.starwars));
        }

        // remove all songs more than MAX_SONGS
        try {
            while (true) {
                SONGS.remove(MAX_SONGS);
            }
        }
        catch (Exception e)
        {}
    }

    private static void addSong(Song song) {
        SONGS.add(song);
        SONG_MAP.put(song.getId(), song);
    }

    public static class Song {

        public static final String TOSTRING_SEPARATOR = "-";

        private Integer id;
        private String name;
        private String band;
        private String descriptor;
        private Integer imgid;

        public Song(Integer id, String name, String band, String descriptor, Integer imgid) {
            this.id = id;
            this.name = name;
            this.band = band;
            this.descriptor = descriptor;
            this.imgid = imgid;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getBand() {
            return band;
        }

        public String getDescriptor() {
            return descriptor;
        }

        public Integer getImgid() {
            return imgid;
        }

        @Override
        public String toString() {
            return band + TOSTRING_SEPARATOR + name;
        }
    }
}