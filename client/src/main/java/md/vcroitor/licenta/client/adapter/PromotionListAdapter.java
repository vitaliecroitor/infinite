package md.vcroitor.licenta.client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.domain.Promotion;

import java.util.ArrayList;
import java.util.List;

public class PromotionListAdapter extends ArrayAdapter<Promotion> {

    private final Context context;
    private List<Promotion> promotions = new ArrayList<Promotion>();
    private DisplayImageOptions options;
    private ImageLoader imageLoader = ImageLoader.getInstance();
    private Tag tag;
    private LayoutInflater layoutInflater;
    private PromotionFilter filter;

    public PromotionListAdapter(Context context, List<Promotion> objects) {
        super(context, R.layout.promotion_list_item, objects);
        this.context = context;
        this.promotions.addAll(objects);

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
        public TextView nrOfOrders;
        public ImageView promotionImage;
        public TextView title;
        public TextView oldPrice;
        public TextView newPrice;
        public TextView saveMoney;
        public TextView discount;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            tag = new Tag();
            convertView = layoutInflater.inflate(R.layout.promotion_list_item, parent, false);
            tag.promotionImage = (ImageView) convertView.findViewById(R.id.prom_image);
            tag.nrOfOrders = (TextView) convertView.findViewById(R.id.nr_of_orders_value);
            tag.title = (TextView) convertView.findViewById(R.id.prom_title);
            tag.oldPrice = (TextView) convertView.findViewById(R.id.prom_old_price);
            tag.newPrice = (TextView) convertView.findViewById(R.id.prom_price);
            tag.saveMoney = (TextView) convertView.findViewById(R.id.save_money_value);
            tag.discount = (TextView) convertView.findViewById(R.id.prom_discount_value);
            convertView.setTag(tag);
        } else {
            tag = (Tag) convertView.getTag();
        }

        final Promotion promotion = promotions.get(position);

        if (promotion != null) {
            tag.title.setText(promotion.getTitle());
            tag.oldPrice.setText(promotion.getOldPrice());
            tag.newPrice.setText(promotion.getNewPrice());
            tag.nrOfOrders.setText(promotion.getNrOfOrders());
            tag.discount.setText(promotion.getDiscount());
            tag.saveMoney.setText(promotion.getSaveMoney());
            imageLoader.displayImage(promotion.getImageUrl(), tag.promotionImage, options);
        }

        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new PromotionFilter();
        }
        return filter;
    }

    private class PromotionFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            constraint = constraint.toString().toLowerCase();
            FilterResults result = new FilterResults();
            if (constraint != null && constraint.toString().length() > 0) {
                ArrayList<Promotion> filteredItems = new ArrayList<Promotion>();

                for (Promotion promotion : promotions) {
                    if (promotion.getTitle().toLowerCase().contains(constraint)) {
                        filteredItems.add(promotion);
                    }

                    result.count = filteredItems.size();
                    result.values = filteredItems;
                }
            } else {
                synchronized (this) {
                    result.values = promotions;
                    result.count = promotions.size();
                }
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            List<Promotion> filteredPromotions = (ArrayList<Promotion>) results.values;
            clear();
            for (Promotion promotion : filteredPromotions) {
                add(promotion);
            }
            notifyDataSetChanged();
            notifyDataSetInvalidated();
        }
    }
}
