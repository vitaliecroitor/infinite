package md.vcroitor.licenta.client.fragment;

import java.util.ArrayList;
import java.util.List;

import md.vcroitor.licenta.client.R;
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

        setListAdapter(new ShopListAdapter(getActivity(), shops));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        return inflater.inflate(R.layout.shop_list_fragment, container, false);
    }
}
