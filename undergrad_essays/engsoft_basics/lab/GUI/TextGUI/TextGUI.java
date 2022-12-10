import java.awt.*;
import java.awt.event.*;

public class TextGUI extends CloseableFrame
{
    public static void main( String [ ] args )
    {
        Frame f = new TextGUI( );

        f.setLayout( new FlowLayout( ) );
        f.add( new GUI( ) );

        f.pack( );
        f.show( );
    }
}
