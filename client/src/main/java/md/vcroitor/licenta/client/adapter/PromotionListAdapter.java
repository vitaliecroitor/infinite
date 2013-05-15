package md.vcroitor.licenta.client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.domain.Promotion;

import java.util.List;

public class PromotionListAdapter extends ArrayAdapter<Promotion> {

    private final Context context;
    private List<Promotion> promotions;
    private DisplayImageOptions options;
    private ImageLoader imageLoader = ImageLoader.getInstance();
    private Tag tag;
    private LayoutInflater layoutInflater;

    public PromotionListAdapter(Context context, List<Promotion> objects) {
        super(context, R.layout.promotion_list_item, objects);
        this.context = context;
        this.promotions = objects;

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
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            tag = new Tag();
            convertView = layoutInflater.inflate(R.layout.promotion_list_item, parent, false);
            tag.promotionImage = (ImageView) convertView.findViewById(R.id.prom_image);
           // tag.nrOfOrders = (TextView) convertView.findViewById(R.id.id_nr_of_orders);
            tag.title = (TextView) convertView.findViewById(R.id.prom_title);
            tag.oldPrice = (TextView) convertView.findViewById(R.id.prom_old_price);
            tag.newPrice = (TextView) convertView.findViewById(R.id.prom_price);
            convertView.setTag(tag);
        } else {
            tag = (Tag) convertView.getTag();
        }

        final Promotion promotion = promotions.get(position);

        if (promotion != null) {
//            tag.nrOfOrders.setText("20");
            tag.title.setText(promotion.getTitle());
            tag.oldPrice.setText(promotion.getOldPrice());
            tag.newPrice.setText(promotion.getNewPrice());
            imageLoader.displayImage("https://lh3.googleusercontent.com/-n-xcJmiI0pg/T3R4mkSchHI/AAAAAAAAAFU/EoiNNb7kk3A/s1024/sample_image_05.jpg", tag.promotionImage, options);
        }

        return convertView;
    }

}
