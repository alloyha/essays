import java.awt.*;
import java.awt.event.*;

public class BasicGUI extends CloseableFrame
{
    public static void main( String [ ] args )
    {
        Frame f = new BasicGUI( );

        f.setLayout( new FlowLayout( ) );
        f.add( new GUI( ) );

        f.pack( );
        f.show( );
    }
}
