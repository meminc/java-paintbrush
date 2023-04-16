import javax.swing.*;

public class MenuPanel extends JMenuBar {
    JMenuItem newDrawing;
    JMenuItem exit;
    public MenuPanel() {
        super();

        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");

        newDrawing = new JMenuItem("New");
        exit = new JMenuItem("Exit");

        file.add(newDrawing);
        file.add(exit);


        add(file);
        add(help);
    }


    public JMenuItem getExit() {
        return exit;
    }


    public JMenuItem getNewDrawing() {
        return newDrawing;
    }
}
