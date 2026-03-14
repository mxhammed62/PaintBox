import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ToolsFarbe extends JPanel implements ActionListener {

    private final int[] FARBEN = {0xff0000, 0x0000ff, 0x00ff00, 0xffff00, 0x00ffff, 0xff00ff, 0x000000};
    private final int MARGIN = 10;
    private final int INSETS = 4;

    private ButtonFill buttonFill;

    ToolsFarbe() {

        setLayout(new FlowLayout(FlowLayout.CENTER, INSETS, INSETS));

        setPreferredSize(new Dimension((ButtonFarbe.SIZE + INSETS) * (FARBEN.length + 1), ButtonFarbe.SIZE + MARGIN * 2));

        buttonFill = new ButtonFill();
        buttonFill.addActionListener(this);
        add(buttonFill);

        for (int i = 0; i < FARBEN.length; i++) {
            ButtonFarbe farbButton = new ButtonFarbe(FARBEN[i]);
            farbButton.addActionListener(this);
            add(farbButton);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==buttonFill) {
            R.fillActive = true;
        }
        else {
            ButtonFarbe buttonFarbe = (ButtonFarbe) e.getSource();
            R.stiftFarbe = buttonFarbe.farbe;
        }


    }

}
