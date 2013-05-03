package md.vcroitor.licenta.client.helper;

import android.support.v4.app.Fragment;
import md.vcroitor.licenta.client.enums.FragmentEnum;
import md.vcroitor.licenta.client.fragment.PromotionFragment;
import md.vcroitor.licenta.client.fragment.ShopFragment;

/**
 * User: Vitalie Croitor
 * Date: 5/1/13
 * Time: 2:44 PM
 */
public class FragmentCreator {

    public static Fragment create(int position) {
        FragmentEnum fragmentEnum = FragmentEnum.values()[position];

        switch (fragmentEnum) {
            case PROMOTION_FRAGMENT: {
                return new PromotionFragment();
            }
            case SHOP_FRAGMENT: {
                return new ShopFragment();
            }

        }
        return new PromotionFragment();
    }
}