/**
 * DataGUI - PMR2300
 * Departamento de Engenharia Mecatronica e de Sistemas Mecanicos
 * Escola Politecnica, Universidade de Sao Paulo
 * Autor: Fabio Gagliardi Cozman
 */

import java.awt.*;
import java.awt.event.*;

public class GUI extends Panel implements ActionListener {
    private DataGUI dataGUI;
    private Button inButton, topOutButton, bottomOutButton;
    private Label titleLabel;
    private TextField inTextField;
    private TextArea outTextArea;
    
    public GUI(DataGUI d)  {
        dataGUI = d;
        
        titleLabel = new Label("PMR2300 - Lista Ligada");
        inTextField = new TextField(25);
        inButton = new Button( "Insira" );
        inButton.setForeground(Color.yellow);
        topOutButton = new Button( "Remova primeiro" );
        topOutButton.setForeground(Color.green);
        bottomOutButton = new Button( "Remova ultimo" );
        bottomOutButton.setForeground(Color.green);
        outTextArea = new TextArea(10, 25);

        Panel inPanel = new Panel();
        inPanel.setLayout(new BorderLayout());
        inPanel.add(inTextField, "North");
        inPanel.add(inButton, "West");
        inButton.addActionListener( this );
        inPanel.add(topOutButton, "Center");
        topOutButton.addActionListener( this );
        inPanel.add(bottomOutButton, "East");
        bottomOutButton.addActionListener( this );

        setLayout(new BorderLayout());
        add(titleLabel, "North");
        add(inPanel, "Center");
        add(outTextArea, "South"); 
    }

    public void actionPerformed( ActionEvent evt ) {
        if (evt.getSource() == inButton)
            dataGUI.insert( inTextField.getText() );
        else if (evt.getSource() == topOutButton)
            dataGUI.removeTop();
        else if (evt.getSource() == bottomOutButton)
            dataGUI.removeBottom();
        outTextArea.setText(dataGUI.getText());
    }
}
