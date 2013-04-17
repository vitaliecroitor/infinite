package md.vcroitor.licenta.server.util;

/**
 * User: Vitalie Croitor
 * Date: 4/17/13
 * Time: 1:13 PM
 */

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

/**
 * Image manipulation utilities
 */
public class ImageUtil {

    public static void compressImage(final InputStream input,
                                         final OutputStream output, final String format) throws IOException {
        compress(input, output, 0.5f, format);
    }

    /**
     * Compresses a image by providing decreasing its quality
     *
     * @param input   the input stream of the the source image
     * @param output  the output stream of the the compressed image
     * @param quality express the quality of compression
     * @param format  image format e.g. jpeg, png, etc.
     * @throws IOException
     */
    private static void compress(final InputStream input,
                                 final OutputStream output, float quality, String format)
            throws IOException {

        BufferedImage image = ImageIO.read(input);

        // Get a ImageWriter for requested format.
        Iterator<ImageWriter> writers = ImageIO.getImageWritersBySuffix(format);
        if (!writers.hasNext())
            throw new IllegalStateException("No writers found");
        ImageWriter writer = writers.next();

        // Create the ImageWriteParam to compress the image.
        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(quality);

        // The output will be a ByteArrayOutputStream (in memory)
        ImageOutputStream ios = ImageIO.createImageOutputStream(output);
        writer.setOutput(ios);
        writer.write(null, new IIOImage(image, null, null), param);
        ios.flush();
    }
}
