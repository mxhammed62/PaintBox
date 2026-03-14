import javax.swing.*;
import java.awt.*;

public class ButtonFarbe extends JButton {

    public final static int SIZE = 30;
    public final static int PADDING = 8;

    public int farbe;

    public ButtonFarbe(int farbe) {

        this.farbe = farbe;
        System.out.println(farbe);
        setPreferredSize(new Dimension(SIZE, SIZE));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2D.setColor(new Color(0xcccccc));
        g2D.fillRect(0, 0, SIZE, SIZE);

        g2D.setColor(new Color(farbe));
        g2D.fillOval(PADDING, PADDING, SIZE - PADDING * 2, SIZE - PADDING * 2);

    }

}
