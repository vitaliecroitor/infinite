package md.vcroitor.licenta.client.adapter;

import java.util.List;

import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.domain.Shop;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ShopListAdapter extends ArrayAdapter<Shop>{
	
	private Context context;
	private List<Shop> shops;

	public ShopListAdapter(Context context, List<Shop> objects) {
		super(context, R.layout.shop_list_item, objects);
		this.context = context;
		this.shops = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.shop_list_item, parent, false);
		
		Shop shop = shops.get(position);
		
		TextView textView = (TextView)rowView.findViewById(R.id.id_shop_name);
		RatingBar ratingBar = (RatingBar) rowView.findViewById(R.id.id_shop_rating);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.id_shop_image);
		
		textView.setText(shop.getName());
		ratingBar.setRating(shop.getRating());
		imageView.setImageResource(shop.getImage());
		return rowView;
	}
}
