import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DrawPanel extends JPanel {
    public DrawPanel() {
        setPreferredSize(new Dimension(720, 480));
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(10, 10, 10, 10));
    }
}
