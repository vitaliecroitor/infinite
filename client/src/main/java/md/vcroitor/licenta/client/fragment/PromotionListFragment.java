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
        Promotion bulgaria = new Promotion();
        bulgaria.setDescription("description");
        bulgaria.setId("id");
        bulgaria.setImage(R.drawable.img);
        bulgaria.setImageUrl("https://lh3.googleusercontent.com/-n-xcJmiI0pg/T3R4mkSchHI/AAAAAAAAAFU/EoiNNb7kk3A/s1024/sample_image_05.jpg");
        bulgaria.setNewPrice("870");
        bulgaria.setOldPrice("990");
        bulgaria.setTitle("Bulgaria");
        bulgaria.setDiscount("14");
        bulgaria.setSaveMoney("120");
        bulgaria.setNrOfOrders("17");

        Promotion shusi = new Promotion();
        shusi.setTitle("SUSHI,SUSHI-platouri uriase & livrare gratuita in Chisinau");
        shusi.setImage(R.drawable.img);
        shusi.setImageUrl("http://s.zumzi.com/zp/c/5/c551a4d3aa1d6c9aef9bb8b3acfacbb8_1_large.jpg");
        shusi.setNewPrice("50");
        shusi.setOldPrice("80");
        shusi.setDiscount("38");
        shusi.setSaveMoney("30");
        shusi.setNrOfOrders("70");


        Promotion fitness = new Promotion();
        fitness.setTitle("Abonament de o luna la Sala de forta Gladiator");
        fitness.setImage(R.drawable.img);
        fitness.setImageUrl("http://s.zumzi.com/zp/b/a/babeb54877986785c4527fac839557ec_1_large.jpg");
        fitness.setNewPrice("135");
        fitness.setOldPrice("270");
        fitness.setDiscount("50");
        fitness.setSaveMoney("135");
        fitness.setNrOfOrders("17");

        Promotion forex = new Promotion();
        forex.setTitle("Carti de tranzactionare pe FOREX in limba romana");
        forex.setImage(R.drawable.img);
        forex.setImageUrl("http://s.zumzi.com/zp/e/9/e9b969d172f5d10252015700f472605c_1_large.jpg");
        forex.setNewPrice("25");
        forex.setOldPrice("140");
        forex.setDiscount("82");
        forex.setSaveMoney("115");
        forex.setNrOfOrders("19");

        Promotion pizza = new Promotion();
        pizza.setTitle("2 PIZZA gatite in cuptor cu lemne. Simte gustul adevarat!");
        pizza.setImage(R.drawable.img);
        pizza.setImageUrl("http://s.zumzi.com/zp/c/7/c765df16b8b0a48b1e4e27cd28e9660d_1_large.jpg");
        pizza.setNewPrice("59");
        pizza.setOldPrice("140");
        pizza.setDiscount("58");
        pizza.setSaveMoney("81");
        pizza.setNrOfOrders("353");

        List<Promotion> promotions = new ArrayList<Promotion>();
        promotions.add(shusi);
        promotions.add(pizza);
        promotions.add(fitness);
        promotions.add(bulgaria);
        promotions.add(forex);
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
