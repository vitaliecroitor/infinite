package md.vcroitor.licenta.client.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.adapter.ScreenSlidePagerAdapter;

public class ScreenSlideActivity extends SherlockFragmentActivity implements ActionBar.OnNavigationListener {

    private static final int NUM_PAGES = 5;

    private ViewPager mPager;

    private PagerAdapter mPagerAdapter;

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        // disable home and title
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
       /* actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        actionBar.setListNavigationCallbacks(
                // Specify a SpinnerAdapter to populate the dropdown list.
                new ArrayAdapter<String>(ScreenSlideActivity.this, android.R.layout.simple_list_item_1,
                        android.R.id.text1, new String[]{"Item1", "Item2", "Item3",}), this);
                        */
        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), NUM_PAGES);
        mPager.setAdapter(mPagerAdapter);
    }


    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        Log.i("mesaj super serios: ", itemId + "  " + itemPosition);
        switch (itemPosition) {
            case 0:
                Toast.makeText(ScreenSlideActivity.this, "Item: 1", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(ScreenSlideActivity.this, "Item: 2", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(ScreenSlideActivity.this, "Item: 3", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
        return false;
    }
}
