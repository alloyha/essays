import java.awt.*;

public class GUICanvas extends Canvas
{
    public void setParams( String aShape, String aColor, int x,
                           int y, int size, boolean fill )
    {
        this.theShape = aShape;
        this.theColor = aColor;
        xcoor = x;
        ycoor = y;
        theSize = size;
        fillOn = fill;
        repaint( );
    }

    public void paint( Graphics g )
    {
        if( theColor.equals( "red" ) )
            g.setColor( Color.red );
        else if( theColor.equals( "blue" ) )
            g.setColor( Color.blue );

        theWidth = 25 * ( theSize + 1 );

        if( theShape.equals( "Square" ) )
            if( fillOn )
                g.fillRect( xcoor, ycoor, theWidth, theWidth );
            else
                g.drawRect( xcoor, ycoor, theWidth, theWidth );
        else if( theShape.equals( "Circle" ) )
            if( fillOn )
                g.fillOval( xcoor, ycoor, theWidth, theWidth );
            else
                g.drawOval( xcoor, ycoor, theWidth, theWidth );
    }

    private String theShape = "";
    private String theColor = "";
    private int xcoor;
    private int ycoor;
    private int theSize;  // 0 = small, 1 = med, 2 = large
    private boolean fillOn;
    private int theWidth;
}
