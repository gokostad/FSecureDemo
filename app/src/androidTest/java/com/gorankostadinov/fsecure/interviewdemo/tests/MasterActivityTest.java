package com.gorankostadinov.fsecure.interviewdemo.tests;

import com.gorankostadinov.fsecure.interviewdemo.SongListActivity;
import com.gorankostadinov.fsecure.interviewdemo.SongListFragment;
import com.gorankostadinov.fsecure.interviewdemo.R;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.ListView;
import android.widget.ListAdapter;

import com.gorankostadinov.fsecure.interviewdemo.datasource.StaticDataSource;

public class MasterActivityTest extends ActivityInstrumentationTestCase2<SongListActivity> {

    SongListActivity activity;

    ListView list;

    public MasterActivityTest() {
        super("com.gorankostadinov.fsecure.interviewdemo", SongListActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        activity = getActivity();
    }

    @SmallTest
    public void testListItemsNumber()
    {
        getInstrumentation().waitForIdleSync();
        SongListFragment listFragment = (SongListFragment) activity.getSupportFragmentManager().findFragmentById(R.id.song_list);
        assertNotNull("The list was not loaded", listFragment);

        ListAdapter adapter = listFragment.getListAdapter();
        assertNotNull("The null adapter", adapter);

        assertEquals(StaticDataSource.MAX_SONGS, adapter.getCount());
    }
}
