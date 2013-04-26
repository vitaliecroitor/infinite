package md.vcroitor.licenta.common.dto.request;

/**
 * User: Vitalie Croitor
 * Date: 4/26/13
 * Time: 10:28 AM
 */
public class PagerRequest {

    private int offset;
    private int limit;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}