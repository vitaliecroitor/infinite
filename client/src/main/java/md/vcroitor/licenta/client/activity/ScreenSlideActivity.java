package md.vcroitor.licenta.client.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.adapter.ScreenSlidePagerAdapter;
import md.vcroitor.licenta.client.enums.FragmentEnum;

public class ScreenSlideActivity extends SherlockFragmentActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {

    private static final int NUM_PAGES = FragmentEnum.values().length;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private ActionBar actionBar;
    private ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        // disable home and title
        actionBar = getSupportActionBar();

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), NUM_PAGES);
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnPageChangeListener(this);

        // add tabs
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        createTabs();
//        for (int i = 1; i <= NUM_PAGES; i++) {
//            ActionBar.Tab tab = actionBar.newTab();
//            tab.setText("Tab " + i);
//            tab.setTabListener(this);
//            actionBar.addTab(tab);
//        }
    }

    private void createTabs() {

        // create promotion
        ActionBar.Tab promotions = actionBar.newTab();
        promotions.setTabListener(this);
        promotions.setText("Promotions");
        actionBar.addTab(promotions);

        // create shop
        ActionBar.Tab shop = actionBar.newTab();
        shop.setTabListener(this);
        shop.setText("Shops");
        actionBar.addTab(shop);

        // create favorite
        ActionBar.Tab favorite = actionBar.newTab();
        favorite.setTabListener(this);
        favorite.setText("Favorite");
        actionBar.addTab(favorite);

        // create categories
        ActionBar.Tab categories = actionBar.newTab();
        categories.setText("Categories");
        categories.setTabListener(this);
        actionBar.addTab(categories);

    }

    public void onSettingsClick(View view) {
        Toast.makeText(getApplicationContext(), "THis is settings", Toast.LENGTH_SHORT).show();
    }

    public void onSearchClick(View view) {
        Toast.makeText(getApplicationContext(), "THis is settings", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.removeItem(android.R.id.home);
        menu.add("Test").setIcon(R.drawable.icon);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        actionBar.getTabAt(position).select();
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
