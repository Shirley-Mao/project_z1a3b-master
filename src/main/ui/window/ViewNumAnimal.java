package ui.window;

import model.AnimalRecord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class ViewNumAnimal extends Window {
    private JFrame jf = new JFrame();
    private String text;
    private JLabel l1;
    protected AnimalRecord record;

    public ViewNumAnimal(AnimalRecord animalRecord) {
        super(animalRecord);
        record = animalRecord;
        text = "Total number of animals in the animal record is ";
    }

    @Override
    public void open() {
        jf.setBounds(520, 300, 350, 100);
        jf.setResizable(false);//no change frame size
        Container ctn = jf.getContentPane();
        ctn.setLayout(new FlowLayout());

        l1 = new JLabel(text + record.getTotalNumberOfAnimal());
        ctn.add(l1);
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) { }
}
