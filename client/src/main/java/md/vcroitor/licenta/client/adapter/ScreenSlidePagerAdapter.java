package md.vcroitor.licenta.client.adapter;

import md.vcroitor.licenta.client.fragment.ScreenSlidePageFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
	
	private int numberOfPages;

	public ScreenSlidePagerAdapter(FragmentManager fm, int numberOfPages) {
		super(fm);
		this.numberOfPages = numberOfPages;
	}

	@Override
	public Fragment getItem(int position) {
		return ScreenSlidePageFragment.create(position);
	}

	@Override
	public int getCount() {
		return numberOfPages;
	}
}
