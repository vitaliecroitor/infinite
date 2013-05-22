package md.vcroitor.licenta.client.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.activity.PagerSlidingActivity;
import md.vcroitor.licenta.client.adapter.CategoryListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Vitalie Croitor
 * Date: 5/3/13
 * Time: 11:47 AM
 */
public class CategoryFragment extends ListFragment {

    private CategoryListAdapter adapter;
    private PagerSlidingActivity parent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<String> categories = new ArrayList<String>();
        categories.add("Food");
        categories.add("Fun");
        categories.add("Bla");
        categories.add("Bobo");
        categories.add("Run");
        categories.add("Guns");
        categories.add("Hits");
        categories.add("Shocks");
        categories.add("Mocks");
        categories.add("Tourism");
        categories.add("Home");

        parent = (PagerSlidingActivity) getActivity();
        adapter = new CategoryListAdapter(getActivity(), categories);
        setListAdapter(adapter);
        parent.getSearchField().addTextChangedListener(watcher);

    }

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            doSearchCategories(s.toString().trim());

        }
    };

    private void doSearchCategories(String key) {
        adapter.getFilter().filter(key);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        return inflater.inflate(R.layout.category_list_fragment, container, false);
    }
}
