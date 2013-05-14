package md.vcroitor.licenta.client.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.adapter.ScreenSlidePagerAdapter;
import md.vcroitor.licenta.client.enums.FragmentEnum;
import md.vcroitor.licenta.client.library.PagerSlidingTabStrip;

/**
 * Created with IntelliJ IDEA.
 * User: Wasileok
 * Date: 5/14/13
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class PagerSlidingActivity extends FragmentActivity {

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private ScreenSlidePagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_sliding);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new ScreenSlidePagerAdapter(getApplicationContext(),getSupportFragmentManager(), FragmentEnum.values().length);

        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
    }
}
