package md.vcroitor.licenta.client.helper;

import android.support.v4.app.Fragment;
import md.vcroitor.licenta.client.enums.FragmentEnum;
import md.vcroitor.licenta.client.fragment.*;

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
            case PROMOTION_FRAGMENT: {
                return new PromotionFragment();
            }
            case SHOP_FRAGMENT: {
                return new ShopFragment();
            }
            case FAVORITE_FRAGMENT: {
                return new FavoriteFragment();
            }
            case LAST_ACTIVITY_FRAGMENT: {
                return new LastActivityFragment();
            }
            case PROMOTION_LIST_FRAGMENT: {
                return new PromotionListFragment();
            }
            case SHOP_LIST_FRAGMENT: {
                return new ShopListFragment();
            }
        }
        return new PromotionFragment();
    }
}