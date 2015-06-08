Title:  Interview demo project for F-Secure.
Author: Goran Kostadinov
Installation path: app-debug.apk in the project root

Description:
Project is started as Master/Detail Flow template using Android Studio as simplest way to
fulfil requirements. 

Ordered by time and visible by commits, short history of project:
1. Dummy content replaced with StaticDataSource class (hard coded all songs data)
2. Master activity changed to show song picture, title and band name (by adding
   activity_song_list_item.xml, SongListAdapter class and changing a little SongListFragment class)
3. Detail activity changed to accept new parameter (Song id), layout changed to present
   song picture, title, band name and for the most of the song lyric or small description of song.
4. Band name orientation changed to vertical using new class VerticalTextView in custom styles package.
5. Scroll view added in detail activity
6. Added simple menu and title in Master activity.
6. Unit test added (not fully functioning, problems with getting item count in list view)
7. Documenting a little code.
8. Finalising this Readme file.




