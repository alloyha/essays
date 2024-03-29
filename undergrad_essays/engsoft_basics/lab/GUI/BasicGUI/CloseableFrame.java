import java.awt.*;
import java.awt.event.*;

// Class that implements a Window that closes on a window-close event

public class CloseableFrame extends Frame implements WindowListener
{
    public CloseableFrame( )
      { addWindowListener( this ); }

    public void windowClosing( WindowEvent event ) 
      { System.exit( 0 ); }          
          
    public void windowClosed( WindowEvent event )
      { }

    public void windowDeiconified( WindowEvent event )
      { }

    public void windowIconified( WindowEvent event )
      { }

    public void windowActivated( WindowEvent event )
      { }

    public void windowDeactivated( WindowEvent event )
      { }

    public void windowOpened( WindowEvent event )
      { }
}
