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
		mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				//invalidateOptionsMenu();
			}
		});
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
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getSupportMenuInflater().inflate(R.menu.activity_screen_slide, menu);

		menu.findItem(R.id.action_previous).setEnabled(mPager.getCurrentItem() > 0);

		// Add either a "next" or "finish" button to the action bar, depending
		// on which page
		// is currently selected.
		MenuItem item = menu.add(Menu.NONE, R.id.action_next, Menu.NONE, (mPager.getCurrentItem() == mPagerAdapter
				.getCount() - 1) ? R.string.action_finish : R.string.action_next);
		item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
//		case android.R.id.home:
//			// Navigate "up" the demo structure to the launchpad activity.
//			// See http://developer.android.com/design/patterns/navigation.html
//			// for more.
//			NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
//			return true;

		case R.id.action_previous:
			// Go to the previous step in the wizard. If there is no previous
			// step,
			// setCurrentItem will do nothing.
			mPager.setCurrentItem(mPager.getCurrentItem() - 1);
			return true;

		case R.id.action_next:
			// Advance to the next step in the wizard. If there is no next step,
			// setCurrentItem
			// will do nothing.
			mPager.setCurrentItem(mPager.getCurrentItem() + 1);
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onNavigationItemSelected(int arg0, long arg1) {
		// TODO Auto-generated method stub
		return false;
	}
}
