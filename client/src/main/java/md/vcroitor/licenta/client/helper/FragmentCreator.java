package md.vcroitor.licenta.client.helper;

import android.content.Context;
import android.support.v4.app.Fragment;
import md.vcroitor.licenta.client.R;
import md.vcroitor.licenta.client.enums.FragmentEnum;
import md.vcroitor.licenta.client.fragment.FavoriteFragment;
import md.vcroitor.licenta.client.fragment.LastActivityFragment;
import md.vcroitor.licenta.client.fragment.PromotionListFragment;
import md.vcroitor.licenta.client.fragment.ShopListFragment;

import static md.vcroitor.licenta.client.enums.FragmentEnum.getByPosition;

/**
 * User: Vitalie Croitor
 * Date: 5/1/13
 * Time: 2:44 PM
 */
public class FragmentCreator {

    public static Fragment create(int position) {
        FragmentEnum fragmentEnum = getByPosition(position);
        switch (fragmentEnum) {
            case FAVORITE_FRAGMENT: {
                return new FavoriteFragment();
            }

            case CATEGORY_FRAGMENT: {
                return new LastActivityFragment();
            }

            case PROMOTION_LIST_FRAGMENT: {
                return new PromotionListFragment();
            }

            case SHOP_LIST_FRAGMENT: {
                return new ShopListFragment();
            }
        }
        return new PromotionListFragment();
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