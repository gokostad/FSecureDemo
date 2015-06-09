package com.gorankostadinov.fsecure.interviewdemo.tests;

import com.gorankostadinov.fsecure.interviewdemo.SongListActivity;
import com.gorankostadinov.fsecure.interviewdemo.SongListFragment;
import com.gorankostadinov.fsecure.interviewdemo.datasource.StaticDataSource.Song;
import com.gorankostadinov.fsecure.interviewdemo.R;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.content.Intent;


import com.gorankostadinov.fsecure.interviewdemo.datasource.StaticDataSource;

/**
 * <p>To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.example.android.activityinstrumentation.MasterActivityTest \
 * quux.tests/android.test.InstrumentationTestRunner
 *
 * <p>Individual tests are defined as any method beginning with 'test'.
 *
 * <p>ActivityInstrumentationTestCase2 allows these tests to run alongside a running
 * copy of the application under inspection. Calling getActivity() will return a
 * handle to this activity (launching it if needed).
 */
public class MasterActivityTest extends ActivityInstrumentationTestCase2<SongListActivity> {

    static final int TEST_SONGLIST_POSITION_CLICK = 3;

    SongListActivity activity;

    public MasterActivityTest() {
        super("com.gorankostadinov.fsecure.interviewdemo", SongListActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        // BEGIN_INCLUDE (launch_activity)
        // Launch the activity
        activity = getActivity();
        // END_INCLUDE (launch_activity)
    }

    @SmallTest
    /**
     * Test to make sure that data are loaded correctly in list.
     */
    // BEGIN_INCLUDE (test_name)
    public void testListItemsNumber() {
        // END_INCLUDE (test_name)
        getInstrumentation().waitForIdleSync();

        // BEGIN_INCLUDE (get fragment, adapter and items count)
        SongListFragment listFragment = (SongListFragment)
                activity.getSupportFragmentManager().findFragmentById(R.id.song_list);
        assertNotNull("The list was not loaded", listFragment);

        ListAdapter adapter = listFragment.getListAdapter();
        assertNotNull("The null adapter", adapter);

        assertEquals(StaticDataSource.MAX_SONGS, adapter.getCount());
        // END_INCLUDE (get fragment, adapter and items count)
    }

    @SmallTest
    public void testListItemSelection() {
        getInstrumentation().waitForIdleSync();

        final SongListFragment listFragment = (SongListFragment)
                activity.getSupportFragmentManager().findFragmentById(R.id.song_list);
        assertNotNull("The list was not loaded", listFragment);

        assertTrue(TEST_SONGLIST_POSITION_CLICK < listFragment.getListAdapter().getCount());

        Song songMaster = (Song) listFragment.getListAdapter().getItem(TEST_SONGLIST_POSITION_CLICK);

        // BEGIN_INCLUDE (launch_detail_activity)
        // Launch the activity
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {

                listFragment.getListView().performItemClick(
                        listFragment.getListAdapter().getView(TEST_SONGLIST_POSITION_CLICK, null, null),
                        TEST_SONGLIST_POSITION_CLICK, listFragment.getListAdapter().getItemId(TEST_SONGLIST_POSITION_CLICK));
            }

        });
        // END_INCLUDE (launch_detail_activity)

        getInstrumentation().waitForIdleSync();

        // BEGIN_INCLUDE (compare_detail_text)
        // END_INCLUDE (compare_detail_text)

    }

    @Override
    protected void tearDown()
    {
        // BEGIN_INCLUDE (close_activity)
        if (activity != null) {
            activity.finish();
            setActivity(null);
        }
        //  END_INCLUDE (close_activity)
    }
}
