package ui.window;

import model.AnimalRecord;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Window extends JFrame implements ActionListener {
    protected AnimalRecord record;

    public Window(AnimalRecord animalRecord) {
    }

    //EFFECTS: open the pop up window
    public void open(){}


    //MODIFIES: animal record
    //EFFECTS: add animal to record
    @Override
    public void actionPerformed(ActionEvent e) { }
}
