package md.vcroitor.licenta.client.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import md.vcroitor.licenta.client.R;

import java.util.List;

/**
 * User: Vitalie Croitor
 * Date: 5/10/13
 * Time: 1:43 PM
 */
public class PromotionImagePageAdapter extends PagerAdapter {

    private final Context context;
    private List<String> imageUrl;
    private DisplayImageOptions options;
    private ImageLoader imageLoader = ImageLoader.getInstance();
    private LayoutInflater layoutInflater;

    public PromotionImagePageAdapter(Context context, List<String> urls) {
        this.context = context;
        this.imageUrl = urls;

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

    @Override
    public int getCount() {
        return imageUrl.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.item_pager_image, container, false);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        container.addView(view);
        imageLoader.displayImage(imageUrl.get(position), image, options);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item clicked", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
