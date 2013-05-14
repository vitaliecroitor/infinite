package md.vcroitor.licenta.client.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static md.vcroitor.licenta.client.helper.FragmentCreator.create;
import static md.vcroitor.licenta.client.helper.FragmentCreator.getName;

public class ScreenSlidePagerAdapter extends FragmentPagerAdapter {

    private int numberOfPages;
    private FragmentManager fragmentManager;
    private Context context;

    public ScreenSlidePagerAdapter(Context context, FragmentManager fm, int numberOfPages) {
        super(fm);
        this.numberOfPages = numberOfPages;
        this.fragmentManager = fm;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return create(position);
    }

    @Override
    public int getCount() {
        return numberOfPages;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return getName(context, position);
    }
}
