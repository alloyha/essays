import java.awt.*;
import java.awt.event.*;

public class GUI extends Panel implements ActionListener
{
    public GUI( )
    {
        makeTheObjects( );
        doTheLayout( );
        theDrawButton.addActionListener( this );
    }

           // Make all the objects
    private void makeTheObjects( )
    {
        theCanvas = new GUICanvas( );
        theCanvas.setBackground( Color.white );
        theCanvas.setSize( 100, 100 );

        theShape = new Choice( );
        theShape.add( "Circle" );
        theShape.add( "Square" );

        theColor = new List( 2, false );
        theColor.add( "red" );
        theColor.add( "blue" );
        theColor.select( 0 ); // make red default

        theXCoor = new TextField( 5 );
        theYCoor = new TextField( 5 );

        CheckboxGroup theSize = new CheckboxGroup( );
        smallPic = new Checkbox( "Small", theSize, false );
        mediumPic = new Checkbox( "Medium", theSize, true );
        largePic = new Checkbox( "Large", theSize, false );

        theFillBox = new Checkbox( "Fill" );
        theFillBox.setState( false );

        theDrawButton = new Button( "Draw" );

        theMessage = new TextField( 25 );
        theMessage.setEditable( false );
    }

        // Layout all the objects
    private void doTheLayout( )
    {
        Panel topHalf    = new Panel( );
        Panel bottomHalf = new Panel( );

            // Layout the top half
        topHalf.setLayout( new FlowLayout( ) );
        topHalf.add( theCanvas );
        topHalf.add( new Label( "Shape" ) );
        topHalf.add( theShape );
        topHalf.add( theColor );
        topHalf.add( new Label( "X coor" ) );
        topHalf.add( theXCoor );
        topHalf.add( new Label( "Y coor" ) );
        topHalf.add( theYCoor );

            // Layout the bottom half
        bottomHalf.setLayout( new FlowLayout( ) );
        bottomHalf.add( smallPic );
        bottomHalf.add( mediumPic );
        bottomHalf.add( largePic );
        bottomHalf.add( theFillBox );
        bottomHalf.add( theDrawButton );
        bottomHalf.add( theMessage );

            // Now layout GUI
        setLayout( new BorderLayout( ) );
        add( topHalf, "North" );
        add( bottomHalf, "South" );
    }

    public void actionPerformed( ActionEvent evt )
    {
        try
        {
            theCanvas.setParams(
                theShape.getSelectedItem( ),
                theColor.getSelectedItem( ),
                Integer.parseInt( theXCoor.getText( ) ),
                Integer.parseInt( theYCoor.getText( ) ),
                smallPic.getState( ) ? 0 :
                         mediumPic.getState( ) ? 1 : 2,

                theFillBox.getState( ) );
            theMessage.setText( "" );
        }
        catch( Exception e )
             { theMessage.setText( "Incomplete input" ); }
    }

    private GUICanvas theCanvas;
    private Choice    theShape;
    private List      theColor;
    private TextField theXCoor;
    private TextField theYCoor;
    private Checkbox  smallPic;
    private Checkbox  mediumPic;
    private Checkbox  largePic;
    private Checkbox  theFillBox;
    private Button    theDrawButton;
    private TextField theMessage;
}
