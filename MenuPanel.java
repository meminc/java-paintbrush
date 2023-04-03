import javax.swing.*;

public class MenuPanel extends JMenuBar {
    public MenuPanel() {
        super();

        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");

        JMenuItem newDrawing = new JMenuItem("New");
        JMenuItem exit = new JMenuItem("Exit");

        JMenuItem info = new JMenuItem("Help");
        JMenuItem copyright = new JMenuItem("Copyright");

        file.add(newDrawing);
        file.add(exit);
        help.add(info);
        help.add(copyright);

        add(file);
        add(help);
    }
}
