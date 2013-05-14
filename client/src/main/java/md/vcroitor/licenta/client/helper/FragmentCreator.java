package md.vcroitor.licenta.client.helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import md.vcroitor.licenta.client.enums.FragmentEnum;
import md.vcroitor.licenta.client.fragment.*;

import static md.vcroitor.licenta.client.enums.FragmentEnum.*;

/**
 * User: Vitalie Croitor
 * Date: 5/1/13
 * Time: 2:44 PM
 */
public class FragmentCreator {

    public static Fragment createOrGet(FragmentManager fragmentManager, int position) {
        FragmentEnum fragmentEnum = getByPosition(position);
        Fragment fragment = null;
        switch (fragmentEnum) {
            case FAVORITE_FRAGMENT: {
                //fragment = fragmentManager.findFragmentByTag(FAVORITE_FRAGMENT.toString());
                fragment = new FavoriteFragment();
                /*if (fragment == null){
                    fragmentManager.beginTransaction().add(fragment, FAVORITE_FRAGMENT.toString()).commit();
            	}   */
                break;
            }
            case LAST_ACTIVITY_FRAGMENT: {
                fragment = new LastActivityFragment();
                /*
                fragment = fragmentManager.findFragmentByTag(LAST_ACTIVITY_FRAGMENT.toString());
                if (fragment == null) {
                    fragmentManager.beginTransaction().add(fragment, LAST_ACTIVITY_FRAGMENT.toString()).commit();
                }   */
                break;
            }
            case PROMOTION_LIST_FRAGMENT: {
                fragment = new PromotionListFragment();
                /*
                fragment = fragmentManager.findFragmentByTag(PROMOTION_LIST_FRAGMENT.toString());
                if (fragment == null) {
                    fragmentManager.beginTransaction().add(fragment, PROMOTION_LIST_FRAGMENT.toString()).commit();
                } */
                break;
            }
            case SHOP_LIST_FRAGMENT: {
                fragment = new ShopListFragment();
                /*
                fragment = fragmentManager.findFragmentByTag(SHOP_LIST_FRAGMENT.toString());
                if (fragment == null) {
                    fragmentManager.beginTransaction().add(fragment, SHOP_LIST_FRAGMENT.toString()).commit();
                } */
                break;
            }
        }
        return fragment;
    }
}