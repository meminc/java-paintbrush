import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {
        setSize(720, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());
        //setBounds(10, 10, 10, 10);

        MenuPanel menu = new MenuPanel();
        ColorSelectionPanel colorSelectionPanel = new ColorSelectionPanel();
        ActionSelectionPanel actionSelectionPanel = new ActionSelectionPanel();
        DrawPanel drawPanel = new DrawPanel();

        setJMenuBar(menu);
        add(colorSelectionPanel);
        add(actionSelectionPanel);
        add(drawPanel);

        setVisible(true);
    }
}
