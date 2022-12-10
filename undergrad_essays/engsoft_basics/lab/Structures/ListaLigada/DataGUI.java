/**
 * DataGUI - PMR2300
 * Departamento de Engenharia Mecatronica e de Sistemas Mecanicos
 * Escola Politecnica, Universidade de Sao Paulo
 * Autor: Fabio Gagliardi Cozman
 */

import java.awt.*;
import java.awt.event.*;

public class DataGUI extends Frame implements WindowListener {
    private LinkedList l;
    
    public static void main( String [ ] args ) {
        DataGUI f = new DataGUI( );

        f.setLayout( new FlowLayout( ) );
        f.add( new GUI(f) );

        f.pack( );
        f.show( );
    }

    public DataGUI( ) {
      addWindowListener( this );
      l = new LinkedList();
    }
    
    public void insert(String s) {
        l.insert(s);
    }
    
    public void removeTop() {
        l.removeTop();
    }
    
    public void removeBottom() {
        l.removeBottom();
    }
    
    public String getText() {
        return(l.toString());
    }
    
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
