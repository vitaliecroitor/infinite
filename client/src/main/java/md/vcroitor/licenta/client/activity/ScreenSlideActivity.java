package md.vcroitor.licenta.client.activity;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.adapter.ScreenSlidePagerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class ScreenSlideActivity extends SherlockFragmentActivity implements ActionBar.OnNavigationListener{

	private static final int NUM_PAGES = 5;

	private ViewPager mPager;

	private PagerAdapter mPagerAdapter;

	private ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen_slide);
		actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		actionBar.setListNavigationCallbacks(
		// Specify a SpinnerAdapter to populate the dropdown list.
				new ArrayAdapter<String>(ScreenSlideActivity.this, android.R.layout.simple_list_item_1,
						android.R.id.text1, new String[] { "Item1", "Item2", "Item3", }), listener);
		// Instantiate a ViewPager and a PagerAdapter.
		mPager = (ViewPager) findViewById(R.id.pager);
		mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), NUM_PAGES);
		mPager.setAdapter(mPagerAdapter);
	}

	private ActionBar.OnNavigationListener listener = new ActionBar.OnNavigationListener() {

		@Override
		public boolean onNavigationItemSelected(int itemPosition, long itemId) {
			Log.i("mesaj super serios: ", itemId + "  " + itemPosition);
			switch (itemPosition) {
			case 0:
				Toast.makeText(ScreenSlideActivity.this, "Item: 1", Toast.LENGTH_SHORT).show();
				break;
			case 1:
				Toast.makeText(ScreenSlideActivity.this, "Item: 2", Toast.LENGTH_SHORT).show();
				break;
			case 2:
				Toast.makeText(ScreenSlideActivity.this, "Item: 3", Toast.LENGTH_SHORT).show();
				break;

			default:
				break;
			}
			return false;
		}
	};
	
	@Override
	public boolean onNavigationItemSelected(int arg0, long arg1) {
		// TODO Auto-generated method stub
		return false;
	}
}
