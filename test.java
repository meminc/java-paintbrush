import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class test extends JFrame implements MouseMotionListener, MouseListener {
    int x1,y1,x,y;
    private boolean first = true;
    public test() {
        super("Top Level Demo");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(Color.white);
        addMouseMotionListener(this);
        addMouseListener(this);
    }

/*    @Override
    public boolean mouseDown(Event evt, int x, int y) {
        return super.mouseDown(evt, x, y);
    }*/

    @Override
    public void mouseDragged(MouseEvent e) {
        x =x1; y = y1;
        x1 = e.getX();
        y1 = e.getY();
        if(first){
            x = x1;
            y = y1;
            first  = false;
        }
        repaint();
    }




    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void paint(Graphics graphics){
        graphics.drawLine(x, y, x1, y1);
    }

    public static void main(String[] args) {
        new test();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("hello");
        first = true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}