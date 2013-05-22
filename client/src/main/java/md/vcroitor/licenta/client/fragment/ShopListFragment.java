package md.vcroitor.licenta.client.fragment;

import java.util.ArrayList;
import java.util.List;

import android.text.Editable;
import android.text.TextWatcher;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.activity.PagerSlidingActivity;
import md.vcroitor.licenta.client.adapter.ShopListAdapter;
import md.vcroitor.licenta.client.domain.Shop;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * User: Vitalie Croitor
 * Date: 5/3/13
 * Time: 11:48 AM
 */
public class ShopListFragment extends ListFragment {

    private ShopListAdapter adapter;
    private PagerSlidingActivity parentActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Shop> shops = new ArrayList<Shop>();
        Shop shop = new Shop();
        shop.setImage("https://ssl.gstatic.com/android/market/com.rovio.angrybirdsseasons/hi-256-9-347dae230614238a639d21508ae492302340b2ba");
        shop.setName("Other shop and this is bla bla bla");
        shop.setRating(6);

        shops.add(shop);
        shops.add(shop);
        shops.add(shop);
        shops.add(shop);
        shops.add(shop);
        shops.add(shop);
        parentActivity = (PagerSlidingActivity) getActivity();
        adapter = new ShopListAdapter(getActivity(), shops);
        setListAdapter(adapter);
        parentActivity.getSearchField().addTextChangedListener(textWatcher);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        return inflater.inflate(R.layout.shop_list_fragment, container, false);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            doSearchShops(s.toString().trim());
        }
    };

    private void doSearchShops(String text) {
        adapter.getFilter().filter(text);
    }
}
