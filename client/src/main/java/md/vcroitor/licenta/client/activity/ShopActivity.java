package md.vcroitor.licenta.client.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import md.vcroitor.licenta.client.DummyData;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.helper.AnimationManager;


/**
 * User: vcroitor
 * Date: 5/21/13
 * Time: 4:27 PM
 */
public class ShopActivity extends Activity {

    private GoogleMap map;
    private LinearLayout shopInfoLayout;
    private TextView shopName;
    private TextView shopCategory;
    private TextView rating;
    private TextView nrOfPromotions;
    private TextView shopInformation;
    private TextView shopAddress;
    private ImageView shopLogo;

    private DisplayImageOptions options;
    private ImageLoader imageLoader = ImageLoader.getInstance();

    // fist promotion
    private TextView promFirstTitle;
    private TextView promFirstNewPrice;
    private TextView promFirstOldPrice;
    private ImageView fistImage;

    // second promotion
    private TextView promSecondTitle;
    private TextView promSecondNewPrice;
    private TextView promSecondOldPrice;
    private ImageView secondImage;

    // third promotion
    private TextView promThirdTitle;
    private TextView promThirdNewPrice;
    private TextView promThirdOldPrice;
    private ImageView thirdImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity);
        initAdapter();
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        shopInfoLayout = (LinearLayout) findViewById(R.id.shop_info_view);

        Bundle bundle = getIntent().getExtras();
        bundle.getString(DummyData.IdEnum.Shop.name());
        shopName = (TextView) findViewById(R.id.shop_name);
        shopCategory = (TextView) findViewById(R.id.shop_category);
        rating = (TextView) findViewById(R.id.rating);
        nrOfPromotions = (TextView) findViewById(R.id.nr_of_prom);
        shopInformation = (TextView) findViewById(R.id.shop_info);
        shopAddress = (TextView) findViewById(R.id.shop_address);
        shopLogo = (ImageView) findViewById(R.id.shop_logo);
        imageLoader.displayImage("http://s.zumzi.com/md/place/9/6/9629e98a88819ee5b3ad72f4b81ecefd_1_square.jpg", shopLogo, options);


        // first
        promFirstTitle = (TextView) findViewById(R.id.prom_first_title);
        promFirstNewPrice = (TextView) findViewById(R.id.prom_first_new_price);
        promFirstOldPrice = (TextView) findViewById(R.id.prom_first_old_price);
        fistImage = (ImageView) findViewById(R.id.prom_first_logo);
        imageLoader.displayImage("http://s.zumzi.com/zp/9/1/9138df94861f46afb4e3c9e227de32a6_1_large.jpg", fistImage, options);

        // second
        promSecondTitle = (TextView) findViewById(R.id.prom_second_title);
        promSecondNewPrice = (TextView) findViewById(R.id.prom_second_new_price);
        promSecondOldPrice = (TextView) findViewById(R.id.prom_second_old_price);
        secondImage = (ImageView) findViewById(R.id.prom_second_logo);
        imageLoader.displayImage("http://s.zumzi.com/zp/1/9/19b6e1ea227dd28a4ade672e631c860b_1_large.jpg", secondImage, options);

        // third
        promThirdTitle = (TextView) findViewById(R.id.prom_third_title);
        promThirdNewPrice = (TextView) findViewById(R.id.prom_third_new_price);
        promThirdOldPrice = (TextView) findViewById(R.id.prom_third_old_price);
        thirdImage = (ImageView) findViewById(R.id.prom_third_logo);
        imageLoader.displayImage("http://s.zumzi.com/zp/9/1/9138df94861f46afb4e3c9e227de32a6_1_large.jpg", thirdImage, options);

        initData();
        initMap();
    }

    public void goBack(View view) {
        startActivity(new Intent(ShopActivity.this, PagerSlidingActivity.class));
    }

    public void initAdapter() {
        options = new DisplayImageOptions.Builder()
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                .cacheInMemory()
                .cacheOnDisc()
                .resetViewBeforeLoading()
                .showImageForEmptyUri(R.drawable.icon)
                .showImageOnFail(R.drawable.icon)
                .build();
    }

    public void favorite(View view) {
        ImageView image = (ImageView) view;
        image.setImageResource(R.drawable.ic_favorite_enabled);

        // logic to server
    }

    public void showShopInformation(View view) {
        ImageView image = (ImageView) view;

        // expand
        if (shopInfoLayout.getVisibility() == View.GONE) {
            AnimationManager.expand(shopInfoLayout);
            image.setImageResource(R.drawable.ic_navigation_collapse_dark);
            return;
        }

        // collapse
        if (shopInfoLayout.getVisibility() == View.VISIBLE) {
            AnimationManager.collapse(shopInfoLayout);
            image.setImageResource(R.drawable.ic_navigation_expand_dark);
        }
    }


    private void initMap() {
        LatLng position = new LatLng(47.025542, 28.840238);
        map.addMarker(new MarkerOptions().position(position).snippet("snippet").title("bla").icon(BitmapDescriptorFactory
                .fromResource(R.drawable.ic_favorite_enabled)));

        //Move the camera instantly to hamburg with a zoom of 15.
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 15));
    }

    private void initData() {
        shopName.setText("Lounge Cafe Nefertiti");
        shopCategory.setText("Food & Drinks");
        rating.setText("" + 5);
        nrOfPromotions.setText("20");
        shopInformation.setText("Magazin online");
        shopAddress.setText("str. Alexandrul cel Bun 23/1");

        // first
        promFirstTitle.setText("Mici + cartofi fri + bere/suc = 59 Lei");
        promFirstOldPrice.setText("130");
        promFirstNewPrice.setText("59");

        // second
        promSecondTitle.setText("Frigarui de porc & Salata + Mojito");
        promSecondOldPrice.setText("143");
        promSecondNewPrice.setText("63");

        // third
        promThirdTitle.setText("59 Lei pentru o tocanita de porc + garnitura la alegere");
        promThirdOldPrice.setText("122");
        promThirdNewPrice.setText("59");
    }
}
