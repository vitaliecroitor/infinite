package md.vcroitor.licenta.client.fragment;

import java.util.ArrayList;
import java.util.List;

import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.adapter.PromotionListAdapter;
import md.vcroitor.licenta.client.domain.Promotion;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * User: Vitalie Croitor Date: 5/3/13 Time: 11:48 AM
 */
public class PromotionListFragment extends ListFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Promotion promotion = new Promotion();
		promotion.setDescription("this is a dummy description dasdklfk dkjasdfka;ls fsldkf skdfsaljf ls askjflskd fklasd fasdf jklsad jfas;dkf as;kdf as;dfasjd kf;as dfas");
		promotion.setId("id");
		promotion.setImage(R.drawable.img);
		promotion.setNewPrice("220 lei");
		promotion.setOldPrice("290 lei");
		promotion.setTitle("Chiloti");
		List<Promotion> promotions = new ArrayList<Promotion>();
		promotions.add(promotion);
        promotions.add(promotion);
        promotions.add(promotion);
		setListAdapter(new PromotionListAdapter(getActivity(), promotions));
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout containing a title and body text.
		return inflater.inflate(R.layout.promotion_list_fragment, container,
				false);
	}

}
