import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ButtonFill extends JButton {

    private final static int SIZE = 30;

    ButtonFill() {
        setPreferredSize(new Dimension(SIZE, SIZE));
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(new Color(0xcccccc));
        g.fillRect(0, 0, SIZE, SIZE);

        try {
            BufferedImage icon = ImageIO.read(new File("pics/fill.png"));
            g.drawImage(icon,2,2,null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
