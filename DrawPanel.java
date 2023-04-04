import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import Drawing.*;

public class DrawPanel extends JPanel {

    private ArrayList<ColoredRectangle> coloredRectangles = new ArrayList<ColoredRectangle>();
    private ArrayList<ColoredEllipse> coloredEllipses = new ArrayList<ColoredEllipse>();
    private Rectangle shape;

    public DrawPanel() {
        setPreferredSize(new Dimension(720, 480));
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(10, 10, 10, 10));

        MyMouseListener listener = new MyMouseListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);

    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        //  Custom code to paint all the Rectangles from the List

        Color foreground = g.getColor();

        g.setColor( Color.BLACK );

        for (ColoredRectangle cr : coloredRectangles)
        {
            g.setColor( cr.getForeground() );
            Rectangle r = cr.getDrawing();
            g.drawRect(r.x, r.y, r.width, r.height);
        }

        //  Paint the Rectangle as the mouse is being dragged

        if (shape != null)
        {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor( foreground );
            g2d.draw( shape );
        }
    }

    public void addRectangle(Rectangle rectangle, Color color)
    {
        ColoredRectangle cr = new ColoredRectangle(color, rectangle);
        coloredRectangles.add( cr );
        repaint();
    }

    public void clear()
    {
        coloredRectangles.clear();
        repaint();
    }

    class MyMouseListener extends MouseInputAdapter
    {
        private Point startPoint;

        public void mousePressed(MouseEvent e)
        {
            startPoint = e.getPoint();
            shape = new Rectangle();
        }

        public void mouseDragged(MouseEvent e)
        {
            int x = Math.min(startPoint.x, e.getX());
            int y = Math.min(startPoint.y, e.getY());
            int width = Math.abs(startPoint.x - e.getX());
            int height = Math.abs(startPoint.y - e.getY());

            shape.setBounds(x, y, width, height);
            repaint();
        }

        public void mouseReleased(MouseEvent e)
        {
            if (shape.width != 0 || shape.height != 0)
            {
                addRectangle(shape, e.getComponent().getForeground());
            }

            shape = null;
        }
    }
}
