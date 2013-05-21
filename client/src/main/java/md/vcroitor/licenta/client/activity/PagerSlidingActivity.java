package md.vcroitor.licenta.client.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.adapter.SlidePagerAdapter;
import md.vcroitor.licenta.client.enums.FragmentEnum;
import md.vcroitor.licenta.client.library.PagerSlidingTabStrip;
import md.vcroitor.licenta.client.library.SlidingLayer;

/**
 * User: Wasileok
 * Date: 5/14/13
 * Time: 1:30 PM
 */
public class PagerSlidingActivity extends FragmentActivity {

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private SlidePagerAdapter adapter;
    private SlidingLayer mSlidingLayer;
    private EditText searchField;
    private LinearLayout searchLayout;
    private LinearLayout actionBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_sliding);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);
        mSlidingLayer = (SlidingLayer) findViewById(R.id.sliding_layer);
        searchField = (EditText) findViewById(R.id.search_field);
        searchLayout = (LinearLayout) findViewById(R.id.actionBar_search);
        actionBarLayout = (LinearLayout) findViewById(R.id.action_bar_layout);
        initSlider();
        adapter = new SlidePagerAdapter(getApplicationContext(), getSupportFragmentManager(), FragmentEnum.values().length);

        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
    }

    private void initSlider() {
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
        searchLayout.setVisibility(View.VISIBLE);
        // set focus
        searchField.setFocusableInTouchMode(true);
        searchField.requestFocus();
        // show keyboard
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(searchField, InputMethodManager.SHOW_IMPLICIT);
    }

    public void hideSearchBar(View view) {
        searchField.setText(null);
        searchLayout.setVisibility(View.GONE);

        // hide keyboard
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(searchField.getWindowToken(), 0);
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

    public EditText getSearchField() {
        return searchField;
    }
}
