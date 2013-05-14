package md.vcroitor.licenta.client.adapter;

import java.util.List;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.domain.Shop;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ShopListAdapter extends ArrayAdapter<Shop> {

    private Context context;
    private List<Shop> shops;
    private DisplayImageOptions options;
    private ImageLoader imageLoader = ImageLoader.getInstance();
    private Tag tag;
    private LayoutInflater layoutInflater;

    public ShopListAdapter(Context context, List<Shop> objects) {
        super(context, R.layout.shop_list_item, objects);
        this.context = context;
        this.shops = objects;

        options = new DisplayImageOptions.Builder()
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                .cacheInMemory()
                .cacheOnDisc()
                .resetViewBeforeLoading()
                .showImageForEmptyUri(R.drawable.icon)
                .showImageOnFail(R.drawable.icon)
                .build();

        imageLoader.init(ImageLoaderConfiguration.createDefault(context));
        layoutInflater = LayoutInflater.from(context);
    }

    private static class Tag {
        public TextView shopName;
        public RatingBar rating;
        public ImageView shopImage;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            tag = new Tag();
            convertView = layoutInflater.inflate(R.layout.shop_list_item, parent, false);
            tag.shopName = (TextView) convertView.findViewById(R.id.id_shop_name);
            tag.rating = (RatingBar) convertView.findViewById(R.id.id_shop_rating);
            tag.shopImage = (ImageView) convertView.findViewById(R.id.id_shop_image);
            convertView.setTag(tag);
        } else {
            tag = (Tag) convertView.getTag();
        }

        final Shop shop = shops.get(position);

        if (shop != null) {
            tag.shopName.setText(shop.getName());
            tag.rating.setRating(shop.getRating());
            imageLoader.displayImage(shop.getImage(), tag.shopImage, options);
        }

        return convertView;
    }
}
