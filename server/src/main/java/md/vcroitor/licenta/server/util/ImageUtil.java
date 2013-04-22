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
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

import static java.awt.AlphaComposite.Src;
import static java.awt.RenderingHints.*;
import static javax.imageio.ImageIO.createImageOutputStream;
import static javax.imageio.ImageIO.read;
import static javax.imageio.ImageIO.write;

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

        BufferedImage image = read(input);

        // Get a ImageWriter for requested format.
        Iterator<ImageWriter> writers = ImageIO.getImageWritersBySuffix(format);
        if (!writers.hasNext()){
            throw new IllegalStateException("No writers found");
        }

        ImageWriter writer = writers.next();

        // Create the ImageWriteParam to compress the image.
        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(quality);

        // The output will be a ByteArrayOutputStream (in memory)
        ImageOutputStream ios = createImageOutputStream(output);
        writer.setOutput(ios);
        writer.write(null, new IIOImage(image, null, null), param);
        ios.flush();
    }

    public static void resizeImage(final InputStream input, final OutputStream output, int newWidth, int newHeight, String format) throws IOException {

        BufferedImage originalImage = read(input);
        BufferedImage resizeImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = resizeImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        graphics2D.dispose();
        graphics2D.setComposite(Src);

        graphics2D.setRenderingHint(KEY_INTERPOLATION, VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(KEY_RENDERING, VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);

        // get an input stream from recreated image
        ByteArrayOutputStream tempOutputStream = new ByteArrayOutputStream();
        write(resizeImage, format, tempOutputStream);
        InputStream tempInputStream = new ByteArrayInputStream(tempOutputStream.toByteArray());

        compressImage(tempInputStream, output, format);
    }
}