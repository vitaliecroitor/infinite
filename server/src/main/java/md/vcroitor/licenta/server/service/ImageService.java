package md.vcroitor.licenta.server.service;

import com.google.common.io.Files;

import javax.annotation.PostConstruct;
import java.io.*;

import static md.vcroitor.licenta.server.util.ImageUtil.compressImage;

/**
 * User: Vitalie Croitor
 * Date: 4/17/13
 * Time: 1:18 PM
 */
public class ImageService {

    private String rootPath;
    private String format;

    @PostConstruct
    public void setUp(){
        makeRoot();
    }

    public void makeRoot(){
        File file = new File(rootPath);

        if(!file.exists()){
            file.mkdirs();
        }
    }

    public byte[] getFileBytes(File file) throws IOException {
        return file.exists() ? Files.toByteArray(file) : null;
    }

    public void writeImage(byte[] image, File file) throws IOException {
        compressImage(new ByteArrayInputStream(image), new FileOutputStream(file), format);
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