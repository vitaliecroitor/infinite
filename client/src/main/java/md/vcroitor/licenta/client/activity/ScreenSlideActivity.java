package md.vcroitor.licenta.client.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TabHost;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.adapter.ScreenSlidePagerAdapter;

public class ScreenSlideActivity extends SherlockFragmentActivity implements ActionBar.OnNavigationListener, ActionBar.TabListener{

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

        // add tabs
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (int i = 1; i <= NUM_PAGES; i++) {
            ActionBar.Tab tab = actionBar.newTab();
            tab.setText("Tab " + i);
            tab.setTabListener(this);
            actionBar.addTab(tab);
        }

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

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        Toast.makeText(ScreenSlideActivity.this,"tab selected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        Toast.makeText(ScreenSlideActivity.this,"tab UNselected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        Toast.makeText(ScreenSlideActivity.this,"tab REselected", Toast.LENGTH_SHORT).show();
    }
}
