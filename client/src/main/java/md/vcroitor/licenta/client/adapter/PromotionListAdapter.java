package md.vcroitor.licenta.client.adapter;

import java.util.List;

import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.domain.Promotion;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PromotionListAdapter extends ArrayAdapter<Promotion> {
	
	private final Context context;
	private List<Promotion> promotions;
	
	public PromotionListAdapter(Context context, List<Promotion> objects) {
		super(context, R.layout.promotion_list_item, objects);
		this.context = context;
		this.promotions = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View rowView = inflater.inflate(R.layout.promotion_list_item, parent, false);
			ImageView image = (ImageView)rowView.findViewById(R.id.id_prom_image);
			TextView nrOfOrders = (TextView)rowView.findViewById(R.id.id_nr_of_orders);
			TextView title = (TextView)rowView.findViewById(R.id.id_title);
			TextView oldPrice = (TextView) rowView.findViewById(R.id.id_prom_price_old);
			TextView newPrice = (TextView) rowView.findViewById(R.id.id_prom_price_new);
			TextView description = (TextView) rowView.findViewById(R.id.id_prom_description);
			
			Promotion promotion = promotions.get(position);
			image.setImageResource(promotion.getImage());
			nrOfOrders.setText("20");
			title.setText(promotion.getTitle());
			oldPrice.setText(promotion.getOldPrice());
			newPrice.setText(promotion.getNewPrice());
			description.setText(promotion.getDescription());
			
			return rowView;
	}

}
