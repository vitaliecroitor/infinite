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
import md.vcroitor.licenta.client.domain.Favorite;

import java.util.ArrayList;
import java.util.List;

/**
 * User: vcroitor
 * Date: 5/22/13
 * Time: 8:53 PM
 */
public class FavoriteListAdapter extends ArrayAdapter<Favorite> {

    private Context context;
    private List<Favorite> favorites = new ArrayList<Favorite>();

    private DisplayImageOptions options;
    private ImageLoader imageLoader = ImageLoader.getInstance();
    private Tag tag;
    private LayoutInflater layoutInflater;
    private FavoriteFilter filter;

    public FavoriteListAdapter(Context context, List<Favorite> objects) {
        super(context, R.layout.favorite_list_item, objects);
        this.context = context;
        favorites.addAll(objects);

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
        TextView name;
        ImageView logo;
        ImageView remove;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            tag = new Tag();
            convertView = layoutInflater.inflate(R.layout.favorite_list_item, parent, false);
            tag.logo = (ImageView) convertView.findViewById(R.id.item_logo);
            tag.name = (TextView) convertView.findViewById(R.id.item_name);
            tag.remove = (ImageView) convertView.findViewById(R.id.remove_icon);
            convertView.setTag(tag);
        } else {
            tag = (Tag) convertView.getTag();
        }

        final Favorite favorite = favorites.get(position);

        if (favorite != null) {
            tag.name.setText(favorite.getName());
            imageLoader.displayImage(favorite.getUri(), tag.logo, options);
        }

        // remove item from list
        tag.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Favorite item = favorites.get(position);
                // remove from my set
                favorites.remove(item);

                // remove from adapter set
                remove(item);
                notifyDataSetChanged();
                notifyDataSetInvalidated();
            }
        });

        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new FavoriteFilter();
        }
        return filter;
    }

    private class FavoriteFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            constraint = constraint.toString().toLowerCase();
            FilterResults result = new FilterResults();
            if (constraint != null && constraint.toString().length() > 0) {
                ArrayList<Favorite> filteredItems = new ArrayList<Favorite>();

                for (Favorite favorite : favorites) {
                    if (favorite.getName().toLowerCase().contains(constraint)) {
                        filteredItems.add(favorite);
                    }

                    result.count = filteredItems.size();
                    result.values = filteredItems;
                }
            } else {
                synchronized (this) {
                    result.values = favorites;
                    result.count = favorites.size();
                }
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            List<Favorite> filtered = (ArrayList<Favorite>) results.values;
            clear();
            for (Favorite favorite : filtered) {
                add(favorite);
            }
            notifyDataSetChanged();
            notifyDataSetInvalidated();
        }
    }
}
