import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColorSelectionPanel extends JPanel {

    Color[] colors = new Color[]{Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.MAGENTA, Color.BLACK};

    JPanel blue, red, green, yellow, orange, magenta, black;

    private class ColorSelectionButton extends JButton {
        public ColorSelectionButton(Color color) {
            super();
            setBackground(color);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }
    public ColorSelectionPanel() {

        setPreferredSize(new Dimension(720, 70));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        //setBorder(BorderFactory.createEmptyBorder());

        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        setLayout(fl);


        blue = colorPanel(Color.BLUE);
        red = colorPanel(Color.RED);
        green = colorPanel(Color.GREEN);
        yellow = colorPanel(Color.YELLOW);
        orange = colorPanel(Color.ORANGE);
        magenta = colorPanel(Color.MAGENTA);
        black = colorPanel(Color.BLACK);

        add(blue);
        add(red);
        add(green);
        add(yellow);
        add(orange);
        add(magenta);
        add(black);

    }

    private JPanel colorPanel(Color c) {
        JPanel jp = new JPanel();
        jp.setPreferredSize(new Dimension(80, 40));
        jp.setBackground(c);
        jp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return jp;
    }

    public JPanel getBlack() {
        return black;
    }

    public JPanel getBlue() {
        return blue;
    }

    public JPanel getGreen() {
        return green;
    }

    public JPanel getMagenta() {
        return magenta;
    }

    public JPanel getOrange() {
        return orange;
    }

    public JPanel getRed() {
        return red;
    }

    public JPanel getYellow() {
        return yellow;
    }
}
