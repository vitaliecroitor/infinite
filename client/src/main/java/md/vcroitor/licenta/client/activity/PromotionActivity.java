package md.vcroitor.licenta.client.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.adapter.PromotionImagePageAdapter;
import md.vcroitor.licenta.client.helper.AnimationManager;
import md.vcroitor.licenta.client.library.PagerContainer;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Vitalie Croitor
 * Date: 5/10/13
 * Time: 1:31 PM
 */
public class PromotionActivity extends Activity {

    private PagerContainer mContainer;
    private ViewPager pager;
    private LinearLayout descriptionLayout;
    private LinearLayout termsLayout;
    private LinearLayout shopDetailsLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.promotion_activity);

        mContainer = (PagerContainer) findViewById(R.id.pager_container);
        descriptionLayout = (LinearLayout) findViewById(R.id.desc_view);
        termsLayout = (LinearLayout) findViewById(R.id.terms_view);
        shopDetailsLayout = (LinearLayout) findViewById(R.id.shop_details_view);
        pager = mContainer.getViewPager();

        List<String> imageUrls = new ArrayList<String>();
        imageUrls.add("http://tabletpcssource.com/wp-content/uploads/2011/05/android-logo.png");
        imageUrls.add("http://simpozia.com/pages/images/stories/windows-icon.png");
        imageUrls.add("https://si0.twimg.com/profile_images/1135218951/gmail_profile_icon3_normal.png");
        imageUrls.add("http://www.krify.net/wp-content/uploads/2011/09/Macromedia_Flash_dock_icon.png");
        imageUrls.add("http://radiotray.sourceforge.net/radio.png");

        PagerAdapter adapter = new PromotionImagePageAdapter(PromotionActivity.this, imageUrls);
        //PagerAdapter adapter = new MyPagerAdapter();
        pager.setAdapter(adapter);
        //Necessary or the pager will only have one extra page to show
        // make this at least however many pages you can see
        pager.setOffscreenPageLimit(adapter.getCount());
        //A little space between pages
        pager.setPageMargin(15);

        //If hardware acceleration is enabled, you should also remove
        // clipping on the pager for its children. This is done in xml
    }

    public void doDescriptionAction(View view) {
        ImageView image = (ImageView) view;

        // expand
        if (descriptionLayout.getVisibility() == View.GONE) {
            AnimationManager.expand(descriptionLayout);
            image.setImageResource(R.drawable.ic_navigation_collapse_dark);
            return;
        }

        // collapse
        if (descriptionLayout.getVisibility() == View.VISIBLE) {
            AnimationManager.collapse(descriptionLayout);
            image.setImageResource(R.drawable.ic_navigation_expand_dark);
        }
    }

    public void doTermsAction(View view) {
        ImageView image = (ImageView) view;

        // expand
        if (termsLayout.getVisibility() == View.GONE) {
            AnimationManager.expand(termsLayout);
            image.setImageResource(R.drawable.ic_navigation_collapse_dark);
            return;
        }

        // collapse
        if (termsLayout.getVisibility() == View.VISIBLE) {
            AnimationManager.collapse(termsLayout);
            image.setImageResource(R.drawable.ic_navigation_expand_dark);
        }
    }

    public void doShopDetailsAction(View view) {
        ImageView image = (ImageView) view;

        // expand
        if (shopDetailsLayout.getVisibility() == View.GONE) {
            AnimationManager.expand(shopDetailsLayout);
            image.setImageResource(R.drawable.ic_navigation_collapse_dark);
            return;
        }

        // collapse
        if (shopDetailsLayout.getVisibility() == View.VISIBLE) {
            AnimationManager.collapse(shopDetailsLayout);
            image.setImageResource(R.drawable.ic_navigation_expand_dark);
        }
    }

}
