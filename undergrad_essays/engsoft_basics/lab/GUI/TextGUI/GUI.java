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
        theText = new TextField(25);
        theButton = new Button( "X" );
    }

    private void doTheLayout( )
    {
        setLayout( new BorderLayout( ) );
        add( theLabel, "North" );
        add( theText, "Center" );
        add( theButton, "South" );
    }

    public void actionPerformed( ActionEvent evt )
    {
        System.out.println("Button pressed: " + theText.getText());
    }

    private Button    theButton;
    private Label theLabel;
    private TextField theText;
}
