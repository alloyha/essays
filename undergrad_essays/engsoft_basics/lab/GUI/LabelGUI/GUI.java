import java.awt.*;
import java.awt.event.*;

public class GUI extends Panel implements ActionListener
{
    public GUI( )
    {
        makeTheObjects( );
        doTheLayout( );
        theButton.addActionListener( this );
    }

    private void makeTheObjects( )
    {
        theLabel = new Label("PMR2300");
        theButton = new Button( "X" );
    }

    private void doTheLayout( )
    {
        setLayout( new BorderLayout( ) );
        add( theLabel, "North" );
        add( theButton, "South" );
    }

    public void actionPerformed( ActionEvent evt )
    {
        System.out.println("Button pressed!");
    }

    private Button    theButton;
    private Label theLabel;
}
