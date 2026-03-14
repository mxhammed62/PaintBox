
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class Canvas extends JPanel implements MouseListener, MouseMotionListener {

    private int xAlt = -1;
    private int yAlt = -1;

    private BufferedImage offScreen;
    private Graphics2D gOffScreen;

    // private Stack<Point> stack = new Stack<>();  stack for fillAreaIterative Tool

    public Canvas(int width, int height) {

        setPreferredSize(new Dimension(width, height));

        offScreen = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        gOffScreen = offScreen.createGraphics();

        gOffScreen.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gOffScreen.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));

        gOffScreen.setColor(new Color(0xffffff));
        gOffScreen.fillRect(0, 0, width, height);

        gOffScreen.setColor(new Color(0x000000));

        addMouseListener(this);
        addMouseMotionListener(this);

    }

    private void fillAreaRecursive(int oldColor, int newColor, Point p) {

        if (offScreen.getRGB(p.x, p.y) == oldColor) {

            offScreen.setRGB(p.x, p.y, newColor);

            if (p.y + 1 < this.getHeight()) {
                fillAreaRecursive(oldColor, newColor, new Point(p.x, p.y + 1));
            }
            if (p.y - 1 >= 0) {
                fillAreaRecursive(oldColor, newColor, new Point(p.x, p.y - 1));
            }
            if (p.x + 1 < this.getWidth()) {
                fillAreaRecursive(oldColor, newColor, new Point(p.x + 1, p.y));
            }
            if (p.x - 1 >= 0) {
                fillAreaRecursive(oldColor, newColor, new Point(p.x - 1, p.y));
            }

        }
    }

    /*
    private void fillAreaIterative(int oldColor, int newColor, Point p) {

        stack.push(new Point(p));

        while (!stack.isEmpty()) {
            Point point = stack.pop();
            int px=point.x;
            int py=point.y;

            if (offScreen.getRGB(p.x, p.y) == oldColor) {
                offScreen.setRGB(p.x, p.y, newColor);

                if (p.y + 1 < this.getHeight()) {

                    stack.push(p.x);  // stack.push (px)   so geht es auch nicht
                    stack.push(p.y + 1);
                    //fillAreaRecursive(oldColor, newColor, new Point(p.x, p.y + 1));
                }
                if (p.y - 1 >= 0) {
                    stack.push(p.x);
                    stack.push(p.y - 1);
                    //  fillAreaRecursive(oldColor, newColor, new Point(p.x, p.y - 1));
                }
                if (p.x + 1 < this.getWidth()) {
                    stack.push(p.x + 1);
                    stack.push(p.y);
                    //   fillAreaRecursive(oldColor, newColor, new Point(p.x + 1, p.y));
                }
                if (p.x - 1 >= 0) {
                    stack.push(p.x - 1);
                    stack.push(p.y);
                    //fillAreaRecursive(oldColor, newColor, new Point(p.x - 1, p.y));
                }
            }

        }
    }

     */

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(offScreen, 0, 0, null);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (R.fillActive) {
            System.out.println(offScreen.getRGB(e.getX(), e.getY())+","+ R.stiftFarbe);
            int oldColor = offScreen.getRGB(e.getX(), e.getY());
            Point p = new Point(e.getX(), e.getY());

            //fillAreaIterative(oldColor, R.stiftFarbe, p);
            fillAreaRecursive(oldColor, R.stiftFarbe, p);

            R.fillActive = false;

        } else {

            gOffScreen.setColor(new Color(R.stiftFarbe));
            gOffScreen.setStroke(new BasicStroke(R.stiftBreite, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
            gOffScreen.drawLine(e.getX(), e.getY(), e.getX(), e.getY());

        }

        repaint();

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        if (!R.fillActive) {
            gOffScreen.drawLine(xAlt, yAlt, e.getX(), e.getY());
            xAlt = e.getX();
            yAlt = e.getY();
            repaint();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        xAlt = e.getX();
        yAlt = e.getY();
        gOffScreen.setColor(new Color(R.stiftFarbe));
        gOffScreen.setStroke(new BasicStroke(R.stiftBreite, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}



