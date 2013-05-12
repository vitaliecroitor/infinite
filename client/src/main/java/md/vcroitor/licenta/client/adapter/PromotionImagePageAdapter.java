package md.vcroitor.licenta.client.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
                .showImageForEmptyUri(md.vcroitor.licenta.client.R.drawable.icon)
                .showImageOnFail(md.vcroitor.licenta.client.R.drawable.icon)
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
        View view = layoutInflater.inflate(R.layout.item_pager_image, null);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        imageLoader.displayImage("https://lh3.googleusercontent.com/-n-xcJmiI0pg/T3R4mkSchHI/AAAAAAAAAFU/EoiNNb7kk3A/s1024/sample_image_05.jpg", image, options);
        return view;
    }
}
