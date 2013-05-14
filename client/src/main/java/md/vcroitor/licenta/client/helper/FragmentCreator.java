package md.vcroitor.licenta.client.helper;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.enums.FragmentEnum;
import md.vcroitor.licenta.client.fragment.CategoryFragment;
import md.vcroitor.licenta.client.fragment.FavoriteFragment;
import md.vcroitor.licenta.client.fragment.PromotionListFragment;
import md.vcroitor.licenta.client.fragment.ShopListFragment;

import static md.vcroitor.licenta.client.enums.FragmentEnum.*;

/**
 * User: Vitalie Croitor
 * Date: 5/1/13
 * Time: 2:44 PM
 */
public class FragmentCreator {

    public static Fragment create(FragmentManager fragmentManager, int position) {
        FragmentEnum fragmentEnum = getByPosition(position);
        Fragment fragment = null;
        switch (fragmentEnum) {
            case FAVORITE_FRAGMENT: {
                fragment = fragmentManager.findFragmentByTag(FAVORITE_FRAGMENT.toString());
                if (fragment == null) {
                    fragment = new FavoriteFragment();
                    fragmentManager.beginTransaction().add(fragment, FAVORITE_FRAGMENT.toString()).commit();
                }
                break;
            }

            case CATEGORY_FRAGMENT: {
                fragment = fragmentManager.findFragmentByTag(CATEGORY_FRAGMENT.toString());
                if (fragment == null) {
                    fragment = new CategoryFragment();
                    fragmentManager.beginTransaction().add(fragment, CATEGORY_FRAGMENT.toString()).commit();
                }
                break;
            }

            case PROMOTION_LIST_FRAGMENT: {
                fragment = fragmentManager.findFragmentByTag(PROMOTION_LIST_FRAGMENT.toString());
                if (fragment == null) {
                    fragment = new PromotionListFragment();
                    fragmentManager.beginTransaction().add(fragment, PROMOTION_LIST_FRAGMENT.toString()).commit();
                }
                break;
            }

            case SHOP_LIST_FRAGMENT: {
                fragment = fragmentManager.findFragmentByTag(SHOP_LIST_FRAGMENT.toString());
                if (fragment == null) {
                    fragment = new ShopListFragment();
                    fragmentManager.beginTransaction().add(fragment, SHOP_LIST_FRAGMENT.toString()).commit();
                }
                break;
            }
        }
        return fragment;
    }

    public static String getName(Context context, int position) {

        FragmentEnum fragmentEnum = getByPosition(position);
        switch (fragmentEnum) {
            case FAVORITE_FRAGMENT: {
                return context.getResources().getString(R.string.tab_favorites);
            }

            case CATEGORY_FRAGMENT: {
                return context.getResources().getString(R.string.tab_categories);
            }

            case PROMOTION_LIST_FRAGMENT: {
                return context.getResources().getString(R.string.tab_promotions);
            }

            case SHOP_LIST_FRAGMENT: {
                return context.getResources().getString(R.string.tab_shops);
            }
        }
        return context.getResources().getString(R.string.tab_promotions);
    }
}