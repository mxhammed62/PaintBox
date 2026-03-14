import javax.swing.*;
import java.awt.*;

public class ButtonBreite extends JButton {

    public final static int WIDTH = 60;
    public final static int HEIGHT = 30;
    public final static int PADDING = 8;

    public int breite;

    public ButtonBreite(int breite) {

        this.breite = breite;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2D.setColor(new Color(0xcccccc));
        g2D.fillRect(0, 0, WIDTH, HEIGHT);

        g2D.setColor(new Color(0x000000));
        g2D.fillRect(PADDING, HEIGHT / 2 - breite / 2, WIDTH - PADDING * 2, breite);

    }

}
