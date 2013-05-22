package md.vcroitor.licenta.client.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.activity.PagerSlidingActivity;
import md.vcroitor.licenta.client.activity.PromotionActivity;
import md.vcroitor.licenta.client.adapter.PromotionListAdapter;
import md.vcroitor.licenta.client.domain.Promotion;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Vitalie Croitor Date: 5/3/13 Time: 11:48 AM
 */
public class PromotionListFragment extends ListFragment {

    private PromotionListAdapter adapter;
    private PagerSlidingActivity parentActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Promotion promotion = new Promotion();
        promotion.setDescription("this is a dummy description dasdklfk dkjasdfka;ls fsldkf skdfsaljf ls askjflskd fklasd fasdf jklsad jfas;dkf as;kdf as;dfasjd kf;as dfas");
        promotion.setId("id");
        promotion.setImage(R.drawable.img);
        promotion.setNewPrice("220");
        promotion.setOldPrice("290");
        promotion.setTitle("Egypt");
        List<Promotion> promotions = new ArrayList<Promotion>();
        promotions.add(promotion);
        promotions.add(promotion);
        promotions.add(promotion);
        adapter = new PromotionListAdapter(getActivity(), promotions);
        setListAdapter(adapter);
        parentActivity = (PagerSlidingActivity) getActivity();
        parentActivity.getSearchField().addTextChangedListener(textWatcher);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        View view = inflater.inflate(R.layout.promotion_list_fragment, container, false);

        return view;
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
            doSearchPromotions(s.toString().trim());
        }
    };

    private void doSearchPromotions(String text) {
        adapter.getFilter().filter(text);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        startActivity(new Intent(getActivity().getApplicationContext(), PromotionActivity.class));
    }
}
