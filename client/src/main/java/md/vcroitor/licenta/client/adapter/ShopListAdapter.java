package md.vcroitor.licenta.client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.domain.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopListAdapter extends ArrayAdapter<Shop> {

    private Context context;
    private List<Shop> shops = new ArrayList<Shop>();
    private DisplayImageOptions options;
    private ImageLoader imageLoader = ImageLoader.getInstance();
    private Tag tag;
    private LayoutInflater layoutInflater;
    private Filter filter;

    public ShopListAdapter(Context context, List<Shop> objects) {
        super(context, R.layout.shop_list_item, objects);
        this.context = context;
        this.shops.addAll(objects);

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
        public TextView shopCategory;
        public TextView nrOfPromotions;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            tag = new Tag();
            convertView = layoutInflater.inflate(R.layout.shop_list_item, parent, false);
            tag.shopName = (TextView) convertView.findViewById(R.id.id_shop_name);
            tag.rating = (RatingBar) convertView.findViewById(R.id.id_shop_rating);
            tag.shopImage = (ImageView) convertView.findViewById(R.id.id_shop_image);
            tag.shopCategory = (TextView) convertView.findViewById(R.id.id_shop_category);
            tag.nrOfPromotions = (TextView) convertView.findViewById(R.id.id_nr_of_prom);
            convertView.setTag(tag);
        } else {
            tag = (Tag) convertView.getTag();
        }

        final Shop shop = shops.get(position);

        if (shop != null) {
            tag.shopName.setText(shop.getName());
            tag.rating.setRating(shop.getRating());
            tag.shopCategory.setText(shop.getCategory().toString());
            tag.nrOfPromotions.setText(shop.getNrOfPromotions());
            imageLoader.displayImage(shop.getImage(), tag.shopImage, options);
        }

        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new ShopFilter();
        }
        return filter;
    }

    private class ShopFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            constraint = constraint.toString().toLowerCase();
            FilterResults result = new FilterResults();
            if (constraint != null && constraint.toString().length() > 0) {
                ArrayList<Shop> filteredItems = new ArrayList<Shop>();

                for (Shop shop : shops) {
                    if (shop.getName().toLowerCase().contains(constraint)) {
                        filteredItems.add(shop);
                    }

                    result.count = filteredItems.size();
                    result.values = filteredItems;
                }
            } else {
                synchronized (this) {
                    result.values = shops;
                    result.count = shops.size();
                }
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            List<Shop> filtered = (ArrayList<Shop>) results.values;
            clear();
            for (Shop shop : filtered) {
                add(shop);
            }
            notifyDataSetChanged();
            notifyDataSetInvalidated();
        }
    }
}
