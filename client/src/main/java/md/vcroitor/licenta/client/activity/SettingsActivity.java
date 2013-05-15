package md.vcroitor.licenta.client.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.library.SlidingLayer;

/**
 * User: vcroitor
 * Date: 5/15/13
 * Time: 9:42 AM
 */
public class SettingsActivity extends Activity {
    private SlidingLayer mSlidingLayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_view);

        bindViews();
        initState();
    }

    /**
     * View binding
     */
    private void bindViews() {
        mSlidingLayer = (SlidingLayer) findViewById(R.id.slidingLayer1);
    }

    /**
     * Initializes the origin state of the layer
     */
    private void initState() {

        // Sticks container to right or left
        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) mSlidingLayer.getLayoutParams();
        Drawable d;

        d = getResources().getDrawable(R.drawable.img);
        rlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        mSlidingLayer.setLayoutParams(rlp);

        // Sets the shadow of the container
        if (false) {
            mSlidingLayer.setShadowWidthRes(R.dimen.shadow_width);
            mSlidingLayer.setShadowDrawable(R.drawable.sidebar_shadow);
        } else {
            mSlidingLayer.setShadowWidth(0);
            mSlidingLayer.setShadowDrawable(null);
        }
    }

    public void buttonClicked(View v) {
        switch (v.getId()) {
            case R.id.buttonOpen:
                if (!mSlidingLayer.isOpened()) {
                    mSlidingLayer.openLayer(true);
                }
                break;
            case R.id.buttonClose:
                if (mSlidingLayer.isOpened()) {
                    mSlidingLayer.closeLayer(true);
                }
                break;
        }
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