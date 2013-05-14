package md.vcroitor.licenta.client.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import md.vcroitor.licenta.client.enums.FragmentEnum;

import static md.vcroitor.licenta.client.helper.FragmentCreator.createOrGet;

public class ScreenSlidePagerAdapter extends FragmentPagerAdapter {

    private int numberOfPages;
    private FragmentManager fragmentManager;

    public ScreenSlidePagerAdapter(FragmentManager fm, int numberOfPages) {
        super(fm);
        this.numberOfPages = numberOfPages;
        this.fragmentManager = fm;
    }

    @Override
    public Fragment getItem(int position) {
        return createOrGet(fragmentManager, position);
    }

    @Override
    public int getCount() {
        return numberOfPages;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentEnum.getByPosition(position).toString();
    }
}
