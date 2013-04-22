package md.vcroitor.licenta.server.service;

import md.vcroitor.licenta.common.enums.ImageType;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.google.common.io.Files.toByteArray;
import static md.vcroitor.licenta.common.enums.ImageType.*;
import static md.vcroitor.licenta.server.util.ImageUtil.compressImage;
import static md.vcroitor.licenta.server.util.ImageUtil.resizeImage;

/**
 * User: Vitalie Croitor
 * Date: 4/17/13
 * Time: 1:18 PM
 */
public class ImageService {

    private String rootPath;
    private String format;

    @PostConstruct
    public void setUp() {
        makeRoot();
    }

    private void makeRoot() {
        File file = new File(rootPath);

        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public byte[] getFileBytes(File file) throws IOException {
        return file.exists() ? toByteArray(file) : null;
    }

    public void writeAndCompress(byte[] image, File file) throws IOException {
        compressImage(new ByteArrayInputStream(image), new FileOutputStream(file), format);
    }

    public void writeAndResize(byte[] image, File file, int newWidth, int newHeight) throws IOException {
        resizeImage(new ByteArrayInputStream(image), new FileOutputStream(file), newWidth, newHeight, format);
    }

    public String getShopPath(String shopId) {
        return getRootPath() + "/shop_" + shopId;
    }

    public String getShopImagePath(String shopId, ImageType imageType){
        return getShopPath(shopId) + "/" + imageType + "." + getFormat();
    }

    public byte[] getShopImage(String shopId, ImageType imageType) throws Exception {
        return getFileBytes(new File(getShopImagePath(shopId, imageType)));
    }

    public void writeShopImage(byte [] image, String shopId, ImageType imageType)throws Exception{
        choseWriteType(image, new File(getShopImagePath(shopId, imageType)), imageType);
    }

    public String getPromotionPath(String shopId, String promotionId) {
        return getShopPath(shopId) + "/promotion_" + promotionId;
    }

    public String getPromotionImagePath(String shopId, String promotionId, ImageType imageType){
        return getPromotionPath(shopId, promotionId) + "/" + imageType + "." + getFormat();
    }

    public byte[] getPromotionImage(String shopId, String promotionId, ImageType imageType) throws IOException {
        return getFileBytes(new File(getPromotionImagePath(shopId, promotionId, imageType)));
    }

    public void writePromotionImage(byte [] image, String shopId, String promotionId, ImageType imageType)throws Exception{
        choseWriteType(image, new File(getPromotionImagePath(shopId, promotionId, imageType)), imageType);
    }

    private void choseWriteType(byte [] image, File file, ImageType imageType)throws Exception{
        if(imageType == FULL_SIZE){
            writeAndCompress(image,file);
        } else {
            writeAndResize(image, file, imageType.getWidth(), imageType.getHeight());
        }
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }
}