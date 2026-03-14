import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ToolsBreite extends JPanel implements ActionListener {

    private final int[] BREITEN = {2, 5, 8, 12};
    private final int MARGIN = 10;
    private final int INSETS = 4;

    ToolsBreite() {

        setLayout(new FlowLayout(FlowLayout.CENTER, INSETS, INSETS));

        setPreferredSize(new Dimension((ButtonBreite.WIDTH + INSETS) * BREITEN.length, ButtonBreite.HEIGHT + MARGIN * 2));

        for (int i = 0; i < BREITEN.length; i++) {
            ButtonBreite breiteButton = new ButtonBreite(BREITEN[i]);
            breiteButton.addActionListener(this);
            add(breiteButton);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ButtonBreite buttonBreite = (ButtonBreite) e.getSource();
        R.stiftBreite = buttonBreite.breite;

    }

}
