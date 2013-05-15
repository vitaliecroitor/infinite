package md.vcroitor.licenta.client.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.adapter.SlidePagerAdapter;
import md.vcroitor.licenta.client.enums.FragmentEnum;
import md.vcroitor.licenta.client.library.PagerSlidingTabStrip;
import md.vcroitor.licenta.client.library.SlidingLayer;

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
    private SlidePagerAdapter adapter;
    private SlidingLayer mSlidingLayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_sliding);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);
        mSlidingLayer = (SlidingLayer) findViewById(R.id.sliding_layer);
        initSlider();
        adapter = new SlidePagerAdapter(getApplicationContext(),getSupportFragmentManager(), FragmentEnum.values().length);

        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
    }

    private void initSlider(){
        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) mSlidingLayer.getLayoutParams();
        rlp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        mSlidingLayer.setLayoutParams(rlp);
        mSlidingLayer.setShadowWidthRes(R.dimen.shadow_width);
        mSlidingLayer.setShadowDrawable(R.drawable.sidebar_shadow);

        // no shadow
        // mSlidingLayer.setShadowWidth(0);
        // mSlidingLayer.setShadowDrawable(null);
    }

    public void onSettingsClick(View view) {
        if (!mSlidingLayer.isOpened()) {
            mSlidingLayer.openLayer(true);
        }
    }

    public void onSearchClick(View view) {
        Toast.makeText(getApplicationContext(), "THis is search", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (mSlidingLayer.isOpened()) {
                    mSlidingLayer.closeLayer(true);
                    return true;
                }
            default:
                return super.onKeyDown(keyCode, event);
        }
    }
}
