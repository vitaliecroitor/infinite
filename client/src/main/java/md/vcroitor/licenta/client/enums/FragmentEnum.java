package md.vcroitor.licenta.client.enums;

/**
 * User: Vitalie Croitor
 * Date: 5/3/13
 * Time: 9:38 AM
 */
public enum FragmentEnum {
    SHOP_FRAGMENT(0),
    PROMOTION_FRAGMENT(1);

    private int position;

    private FragmentEnum(int pos){
        this.position = pos;
    }
    public int getPosition(){
        return position;
    }
}