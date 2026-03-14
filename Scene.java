import javax.swing.*;
import java.awt.*;

public class Scene extends JPanel {

    Scene() {
        setPreferredSize(new Dimension(600, 355));
        Canvas canvas = new Canvas (600,300);
        add(canvas);
        ToolsBreite toolsBreite = new ToolsBreite();
        ToolsFarbe toolsFarbe = new ToolsFarbe();
        add(toolsFarbe);
        add(toolsBreite);
    }

}
