import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Drawing {
    private Color foreground;
    private java.awt.Rectangle rectangle;
    private Ellipse2D.Float ellipse;
    private ArrayList<Point> points;
    char type;

    public Drawing(Color foreground, java.awt.Rectangle rectangle, Ellipse2D.Float ellipse, ArrayList<Point> points, char type)
    {
        this.foreground = foreground;
        this.rectangle = rectangle;
        this.ellipse = ellipse;
        this.type = type;
        if (points != null)
            this.points = (ArrayList<Point>) points.clone();
    }

    public Color getForeground()
    {
        return foreground;
    }

    public void setForeground(Color foreground)
    {
        this.foreground = foreground;
    }

    public char getType() {
        return type;
    }

    public java.awt.Rectangle getDrawingRectangle()
    {
        return rectangle;
    }
    public Ellipse2D.Float getDrawingEllipse()
    {
        return ellipse;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

}
