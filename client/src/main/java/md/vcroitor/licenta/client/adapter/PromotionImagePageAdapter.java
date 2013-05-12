package md.vcroitor.licenta.client.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * User: Vitalie Croitor
 * Date: 5/10/13
 * Time: 1:43 PM
 */
public class PromotionImagePageAdapter extends PagerAdapter {



    @Override
    public int getCount() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
