package Drawing;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ColoredEllipse {
    private Color foreground;
    private Ellipse2D.Float ellipse;

    public ColoredEllipse(Color foreground, Ellipse2D.Float rectangle)
    {
        this.foreground = foreground;
        this.ellipse = rectangle;
    }

    public Color getForeground()
    {
        return foreground;
    }

    public void setForeground(Color foreground)
    {
        this.foreground = foreground;
    }

    public Ellipse2D.Float getDrawing()
    {
        return ellipse;
    }

}

