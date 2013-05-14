package md.vcroitor.licenta.client.enums;

/**
 * User: Vitalie Croitor
 * Date: 5/3/13
 * Time: 9:38 AM
 */
public enum FragmentEnum {
    PROMOTION_LIST_FRAGMENT(0),
    SHOP_LIST_FRAGMENT(1),
    FAVORITE_FRAGMENT(2),
    LAST_ACTIVITY_FRAGMENT(3);

    private int position;

    private FragmentEnum(int pos) {
        this.position = pos;
    }

    public int getPosition() {
        return position;
    }

    public static FragmentEnum getByPosition(int position) {
        for (FragmentEnum fragmentEnum : values()) {
            if (fragmentEnum.getPosition() == position) {
                return fragmentEnum;
            }
        }

        return PROMOTION_LIST_FRAGMENT;
    }
}