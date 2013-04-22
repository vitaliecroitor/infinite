package md.vcroitor.licenta.common.enums;

/**
 * User: Vitalie Croitor
 * Date: 4/22/13
 * Time: 10:07 AM
 */
public enum ImageType {
    /**
     * -1, -1 means that image will be in full size
     */
    FULL_SIZE(-1, -1),
    MEDIUM(500,500),
    THUMB(150,150);

    private int width;
    private int height;

    private ImageType(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}