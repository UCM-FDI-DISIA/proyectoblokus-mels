package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;

public class TransparentTransformation {
    private BufferedImage img;
    public TransparentTransformation(BufferedImage img) {
        this.img = img;
    }
    public BufferedImage makeColorTransparent(final Color color) {
        BufferedImage imgDestination;
        ImageFilter filter = new RGBImageFilter() {
            public int markerRGB = color.getRGB() | 0xFF000000;
            @Override
            public final int filterRGB(int x, int y, int rgb) {
                if ((rgb | 0xFF000000) == markerRGB) {
                    return 0x00FFFFFF & rgb;
                } else {
                    return rgb;
                }
            }
        };
        ImageProducer ip = new FilteredImageSource(img.getSource(), filter);
        Image img = Toolkit.getDefaultToolkit().createImage(ip);
        imgDestination = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2dImg = imgDestination.createGraphics();
        g2dImg.drawImage(img, 0, 0, null);
        g2dImg.dispose();
        return imgDestination;
    }
}
