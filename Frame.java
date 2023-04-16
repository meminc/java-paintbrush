import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Frame extends JFrame {

    MenuPanel menu;
    ColorSelectionPanel colorSelectionPanel;
    ActionSelectionPanel actionSelectionPanel;
    DrawPanel drawPanel;

    public Frame() {
        setSize(720, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.GRAY);

        setLayout(new FlowLayout());
        //setBounds(10, 10, 10, 10);

        menu = new MenuPanel();
        colorSelectionPanel = new ColorSelectionPanel();
        actionSelectionPanel = new ActionSelectionPanel();
        drawPanel = new DrawPanel();

        actionSelectionPanel.getBtnRectangle().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.ActivateRectangleDraw();
            }
        });

        actionSelectionPanel.getBtnEllipse().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.ActivateEllipseDraw();
            }
        });

        actionSelectionPanel.getBtnPencil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.ActivateFreeDraw();
            }
        });

        ColorPanelMethod(drawPanel, colorSelectionPanel.getBlue(), Color.BLUE);
        ColorPanelMethod(drawPanel, colorSelectionPanel.getBlack(), Color.BLACK);
        ColorPanelMethod(drawPanel, colorSelectionPanel.getGreen(), Color.GREEN);
        ColorPanelMethod(drawPanel, colorSelectionPanel.getRed(), Color.RED);
        ColorPanelMethod(drawPanel, colorSelectionPanel.getOrange(), Color.ORANGE);
        ColorPanelMethod(drawPanel, colorSelectionPanel.getYellow(), Color.YELLOW);
        ColorPanelMethod(drawPanel, colorSelectionPanel.getMagenta(), Color.MAGENTA);

        setJMenuBar(menu);
        AddMenuFunctionality(menu);


        add(colorSelectionPanel);
        add(actionSelectionPanel);
        add(drawPanel);

        setVisible(true);
    }


    void ColorPanelMethod(DrawPanel dP, JPanel jp, Color c) {
        jp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                dP.ChangeColor(c);
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }

    void AddMenuFunctionality(MenuPanel menu) {
        menu.getExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.getNewDrawing().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.ResetDrawings();
            }
        });
    }
}
