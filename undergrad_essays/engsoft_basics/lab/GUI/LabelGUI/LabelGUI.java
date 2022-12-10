import java.awt.*;
import java.awt.event.*;

public class LabelGUI extends CloseableFrame
{
    public static void main( String [ ] args )
    {
        Frame f = new LabelGUI( );

        f.setLayout( new FlowLayout( ) );
        f.add( new GUI( ) );

        f.pack( );
        f.show( );
    }
}
