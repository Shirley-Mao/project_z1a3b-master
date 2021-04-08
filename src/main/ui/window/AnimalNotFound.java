package ui.window;

import model.AnimalRecord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AnimalNotFound extends Window {
    private JFrame jf = new JFrame();
    private String text = "Animal does not exist in Record!";
    private JLabel l1;

    public AnimalNotFound(AnimalRecord animalRecord) {
        super(animalRecord);
    }

    @Override
    public void open() {
        jf.setBounds(520, 300, 350, 75);
        jf.setResizable(false);//no change frame size
        Container ctn = jf.getContentPane();
        ctn.setLayout(new FlowLayout());

        l1 = new JLabel(text);
        ctn.add(l1);
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

