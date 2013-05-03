package md.vcroitor.licenta.client.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import md.vcroitor.licenta.client.enums.FragmentEnum;
import md.vcroitor.licenta.client.helper.FragmentCreator;

import static md.vcroitor.licenta.client.helper.FragmentCreator.*;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private int numberOfPages;

    public ScreenSlidePagerAdapter(FragmentManager fm, int numberOfPages) {
        super(fm);
        this.numberOfPages = numberOfPages;
    }

    @Override
    public Fragment getItem(int position) {
        return create(position);
    }

    @Override
    public int getCount() {
        return numberOfPages;
    }
}
