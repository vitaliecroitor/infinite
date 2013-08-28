package md.vcroitor.licenta.client.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.adapter.PromotionImagePageAdapter;
import md.vcroitor.licenta.client.domain.Promotion;
import md.vcroitor.licenta.client.helper.AnimationManager;
import md.vcroitor.licenta.client.helper.JsonSkipper;
import md.vcroitor.licenta.client.helper.Logger;
import md.vcroitor.licenta.client.http.AsyncHttpRequest;
import md.vcroitor.licenta.client.http.AsyncHttpResponseListener;
import md.vcroitor.licenta.client.library.PagerContainer;
import md.vcroitor.licenta.common.dto.PromotionDTO;
import md.vcroitor.licenta.common.dto.Request;
import md.vcroitor.licenta.common.dto.Response;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.util.*;

/**
 * User: Vitalie Croitor
 * Date: 5/10/13
 * Time: 1:31 PM
 */
public class PromotionActivity extends Activity {

    private static final Logger log = new Logger(PromotionActivity.class);

    private PagerContainer mContainer;
    private ViewPager pager;
    private LinearLayout descriptionLayout;
    private LinearLayout termsLayout;
    private LinearLayout shopDetailsLayout;
    private RatingBar ratingBar;
    private TextView title;
    private TextView discount;
    private TextView oldPrice;
    private TextView newPrice;
    private TextView discountCurrency;
    private TextView details;
    private TextView terms;
    private List<Promotion> promotions;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.promotion_activity);

        mContainer = (PagerContainer) findViewById(R.id.pager_container);
        descriptionLayout = (LinearLayout) findViewById(R.id.desc_view);
        termsLayout = (LinearLayout) findViewById(R.id.terms_view);
        //shopDetailsLayout = (LinearLayout) findViewById(R.id.shop_details_view);
        ratingBar = (RatingBar) findViewById(R.id.rating_bar);
        title = (TextView) findViewById(R.id.prom_title);
        discount = (TextView) findViewById(R.id.discount_value);
        oldPrice = (TextView) findViewById(R.id.old_price);
        newPrice = (TextView) findViewById(R.id.new_price);
        discountCurrency = (TextView) findViewById(R.id.discount_value_curr);
        details = (TextView) findViewById(R.id.desc_text);
        terms = (TextView) findViewById(R.id.condition_text);
        pager = mContainer.getViewPager();

        List<String> imageUrls = new ArrayList<String>();
        imageUrls.add("http://s.zumzi.com/zp/b/a/babeb54877986785c4527fac839557ec_1_large.jpg");
        imageUrls.add("http://s.zumzi.com/zp/7/5/7525f41dafb8572f75002f2daa96baaf_1_large.jpg");
        imageUrls.add("http://s.zumzi.com/zp/5/0/5061a81fbfdc5a12da3be76e69e87f11_1_large.jpg");
        imageUrls.add("http://s.zumzi.com/zp/a/c/ac1c9039ec6e193ad41a33c5a083e5c3_1_large.jpg");
        imageUrls.add("http://s.zumzi.com/zp/6/3/636946dee9fbea7e1b1bbd03f402a13f_1_large.jpg");
        dummy();

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

    private void dummy() {
        ratingBar.setRating(5);
        title.setText("-50% pn un abonament de o luna la Sala de forta Gladiator");
        discount.setText("35");
        oldPrice.setText("270");
        newPrice.setText("135");
        discountCurrency.setText("280");
        details.setText("Mentine-ti corpul intr-o forma de invidiat frecventand antrenamentele la sala de forta a Clubului Sportiv Gladiator");
        terms.setText("Poti beneficia personal doar de 1 voucher, fie ca l-ai cumparat sau l-ai primit cadou. Mai poti cumpara 1 voucher pentru a-l face cadou.");
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

    public void goBack(View view) {
        startActivity(new Intent(PromotionActivity.this, PagerSlidingActivity.class));
    }

    public void facebook(View view) {
        Toast.makeText(getApplication(), "Facebook is not accessible at the moment", Toast.LENGTH_SHORT).show();
    }

    public void twitter(View view) {
        Toast.makeText(getApplication(), "Twitter is not accessible at the moment", Toast.LENGTH_SHORT).show();
    }
}
