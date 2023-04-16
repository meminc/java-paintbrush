import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import Drawing.*;

public class DrawPanel extends JPanel {
    public ArrayList<Drawing> drawings = new ArrayList<Drawing>();
    public ArrayList<Point> points = new ArrayList<Point>();
    int x, y, x1, y1;
    boolean first = true;
    private Ellipse2D.Float shapeEllipse;
    private Rectangle shapeRect;
    private Line2D.Float shapeLine;

    enum ACTION {
        DRAW_RECTANGLE,
        DRAW_ELLIPSE,
        DRAW_FREE,
        DRAG
    }

    private ACTION action = ACTION.DRAW_RECTANGLE;

    public void ActivateRectangleDraw() {
        action = ACTION.DRAW_RECTANGLE;
    }

    public void ActivateEllipseDraw() {
        action = ACTION.DRAW_ELLIPSE;
    }

    public void ActivateFreeDraw() {
        action = ACTION.DRAW_FREE;
    }
    public void ChangeColor(Color c) {
        setForeground(c);
    }

    public void ResetDrawings() {
        drawings = new ArrayList<Drawing>();
        points = new ArrayList<Point>();
        repaint();
    }

    public DrawPanel() {
        setPreferredSize(new Dimension(720, 480));
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setBorder(new EmptyBorder(10, 10, 10, 10));

        DrawMouseListener listener = new DrawMouseListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);

    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Color foreground = g.getColor();

        g.setColor( Color.BLACK  );

        for (Drawing dw : drawings) {
            g.setColor(dw.getForeground());
            if (dw.getType() == 'r') {
                Rectangle r = dw.getDrawingRectangle();
                g.fillRect(r.x, r.y, r.width, r.height);
            } else if (dw.getType() == 'e') {
                Ellipse2D.Float e = dw.getDrawingEllipse();
                g.fillOval((int)e.x, (int)e.y, (int)e.width, (int)e.height);
            } else if (dw.getType() == 'l') {
                for(int i = 0; i < dw.getPoints().size()-1; i++) {
                    Point p1 = dw.getPoints().get(i);
                    Point p2 = dw.getPoints().get(i + 1);
                    g.drawLine(p1.x, p1.y, p2.x, p2.y);
                }
            }
        }

        if (shapeEllipse != null)
        {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor( foreground );
            g2d.draw( shapeEllipse );
        }

        if (shapeRect != null)
        {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor( foreground );
            g2d.draw( shapeRect );
        }

        if (points != null && points.size() > 0)
        {
            for(int i = 0; i < points.size()-1; i++) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setColor( foreground );
                Point p1 = points.get(i);
                Point p2 = points.get(i + 1);
                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }

    public void addRectangle(Rectangle rectangle, Color color)
    {
        Drawing dw = new Drawing(color, rectangle, null, null, 'r');
        drawings.add(dw);
        repaint();
    }

    public void addEllipse(Ellipse2D.Float ellipse, Color color) {
        Drawing dw = new Drawing(color, null, ellipse, null, 'e');
        drawings.add(dw);
        repaint();
    }
    public void addLine(ArrayList<Point> points, Color color) {
        Drawing dw = new Drawing(color, null, null, points, 'l');
        drawings.add(dw);
        repaint();
    }

    class DrawMouseListener extends MouseInputAdapter
    {
        private Point startPoint;

        public void mousePressed(MouseEvent e)
        {
            startPoint = e.getPoint();
            x = e.getX();
            y = e.getY();
            switch (action) {
                case DRAW_RECTANGLE -> shapeRect = new Rectangle();
                case DRAW_ELLIPSE -> shapeEllipse = new Ellipse2D.Float();
                case DRAW_FREE -> points = new ArrayList<Point>();
            }
        }

        public void mouseDragged(MouseEvent e)
        {
            int x = Math.min(startPoint.x, e.getX());
            int y = Math.min(startPoint.y, e.getY());
            int width = Math.abs(startPoint.x - e.getX());
            int height = Math.abs(startPoint.y - e.getY());

            switch (action) {
                case DRAW_RECTANGLE:
                    shapeRect.setFrame(x, y, width, height);
                    break;
                case DRAW_ELLIPSE:
                    shapeEllipse.setFrame(x, y, width, height);
                    break;
                case DRAW_FREE:
                    points.add(e.getPoint());
                    break;
            }
            //shape.setFrame(x, y, width, height);
            repaint();
        }

        public void mouseReleased(MouseEvent e)
        {
            if ((shapeRect != null && (shapeRect.width != 0 || shapeRect.height != 0)) ||
                    (shapeEllipse != null && (shapeEllipse.width != 0 || shapeEllipse.width != 0)) ||
                    (points != null && points.size() > 0))
            {
                switch (action) {
                    case DRAW_RECTANGLE -> addRectangle(shapeRect, e.getComponent().getForeground());
                    case DRAW_ELLIPSE -> addEllipse(shapeEllipse, e.getComponent().getForeground());
                    case DRAW_FREE -> addLine(points, e.getComponent().getForeground());
                }
            }

            points.clear();
            shapeRect = null;
            shapeEllipse = null;
        }
    }
}
