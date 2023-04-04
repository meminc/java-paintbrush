package Drawing;

import java.awt.*;

public class ColoredRectangle {
    private Color foreground;
    private java.awt.Rectangle rectangle;

    public ColoredRectangle(Color foreground, java.awt.Rectangle rectangle)
    {
        this.foreground = foreground;
        this.rectangle = rectangle;
    }

    public Color getForeground()
    {
        return foreground;
    }

    public void setForeground(Color foreground)
    {
        this.foreground = foreground;
    }

    public java.awt.Rectangle getDrawing()
    {
        return rectangle;
    }
}
