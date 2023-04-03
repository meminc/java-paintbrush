import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.concurrent.Flow;

public class ColorSelectionPanel extends JPanel {

    Color[] colors = new Color[]{Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.MAGENTA, Color.BLACK};

    private class ColorSelectionButton extends JButton {
        public ColorSelectionButton(Color color) {
            super();
            setBackground(color);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }
    public ColorSelectionPanel() {

        setPreferredSize(new Dimension(720, 50));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        //setBorder(BorderFactory.createEmptyBorder());

        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        setLayout(fl);

        for (Color c: colors) {
            add(createButton(c));
        }
    }

    private ColorSelectionButton createButton(Color color) {
        ColorSelectionButton csb = new ColorSelectionButton(color);
        csb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        csb.setPreferredSize(new Dimension(80, 40));
        return csb;
    }
}
