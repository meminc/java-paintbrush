import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ActionSelectionPanel extends JPanel{

    private class ActionSelectionButton extends JButton {
        public ActionSelectionButton(String btnName) {
            super(btnName);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }

    public ActionSelectionPanel() {

        setPreferredSize(new Dimension(720, 70));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        //setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        setLayout(fl);

        String[] btnStrs = new String[]{"Dikdortgen Ciz", "Oval Ciz", "Kalemle Ciz", "Tasi"};

        for (String str: btnStrs) {
            add(createButton(str));
        }
    }

    private ActionSelectionButton createButton(String str) {
        ActionSelectionButton asc = new ActionSelectionButton(str);
        asc.setPreferredSize(new Dimension(120, 50));
        // asc.setBounds(20, 20, 50, 20);
        return asc;
    }
}
