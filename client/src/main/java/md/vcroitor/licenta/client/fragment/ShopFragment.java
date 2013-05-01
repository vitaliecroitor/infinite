package md.vcroitor.licenta.client.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import md.vcroitor.licenta.client.R;

/**
 * User: Vitalie Croitor
 * Date: 5/1/13
 * Time: 2:51 PM
 */
public class ShopFragment extends Fragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        return inflater.inflate(R.layout.shop_fragment, container, false);
    }
}
