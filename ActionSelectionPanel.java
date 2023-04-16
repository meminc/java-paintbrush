import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionSelectionPanel extends JPanel{

    JButton btnRectangle;
    JButton btnEllipse;
    JButton btnPencil;
    JButton btnDrag;

    public JButton getBtnDrag() {
        return btnDrag;
    }

    public JButton getBtnEllipse() {
        return btnEllipse;
    }

    public JButton getBtnPencil() {
        return btnPencil;
    }

    public JButton getBtnRectangle() {
        return btnRectangle;
    }

    public ActionSelectionPanel() {

        setPreferredSize(new Dimension(720, 70));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        //setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        setLayout(fl);

        String[] btnStrs = new String[]{"Dikdortgen Ciz", "Oval Ciz", "Kalemle Ciz", "Tasi"};

        btnRectangle = new JButton("Dikdortgen Ciz");
        btnEllipse = new JButton("Oval Ciz");
        btnPencil = new JButton("Kalemle Ciz");
        btnDrag = new JButton("Tasi - calismiyor");

        btnRectangle.setPreferredSize(new Dimension(120, 50));
        btnEllipse.setPreferredSize(new Dimension(120, 50));
        btnPencil.setPreferredSize(new Dimension(120, 50));
        btnDrag.setPreferredSize(new Dimension(120, 50));

        add(btnRectangle);
        add(btnEllipse);
        add(btnPencil);
        add(btnDrag);
    }
}
