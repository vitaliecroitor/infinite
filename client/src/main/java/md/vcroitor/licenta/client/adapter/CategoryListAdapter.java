package md.vcroitor.licenta.client.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.domain.Shop;

import java.util.ArrayList;
import java.util.List;

/**
 * User: vcroitor
 * Date: 5/22/13
 * Time: 8:09 PM
 */
public class CategoryListAdapter extends ArrayAdapter<String> {

    private List<String> categories = new ArrayList<String>();
    private Context context;
    private Filter filter;

    public CategoryListAdapter(Context context, List<String> objects) {
        super(context, R.layout.category_list_item, R.id.category_name, objects);
        categories.addAll(objects);
        this.context = context;
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
                ArrayList<String> filteredItems = new ArrayList<String>();

                for (String category : categories) {
                    if (category.toLowerCase().contains(constraint)) {
                        filteredItems.add(category);
                    }

                    result.count = filteredItems.size();
                    result.values = filteredItems;
                }
            } else {
                synchronized (this) {
                    result.values = categories;
                    result.count = categories.size();
                }
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            List<String> filtered = (ArrayList<String>) results.values;
            clear();
            for (String category : filtered) {
                add(category);
            }
            notifyDataSetChanged();
            notifyDataSetInvalidated();
        }
    }
}
