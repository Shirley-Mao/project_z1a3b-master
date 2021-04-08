package ui.window;

import exceptions.AnimalNotFoundException;
import model.Animal;
import model.AnimalRecord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FindSickness extends Window {
    private JFrame jf = new JFrame();
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;

    protected AnimalRecord record;
    protected Animal animal;

    //EFFECTS: show sickness of an animal
    public FindSickness(AnimalRecord animalRecord, String name) {
        super(animalRecord);
        record = animalRecord;
        try {
            animal = animalRecord.getAnimal(name);
        } catch (AnimalNotFoundException e) {
            Window window = new AnimalNotFound(record);
            window.open();
        }
    }

    @Override
    public void open() {
        jf.setBounds(600, 300, 200, 150);
        jf.setResizable(false);//no change frame size
        Container ctn = jf.getContentPane();
        ctn.setLayout(new FlowLayout());

        l1 = new JLabel("Sickness : " + animal.getSicknessCase().getSickness());
        l2 = new JLabel("Is it treated? : " + animal.getSicknessCase().isTreated());
        l3 = new JLabel("Medication : " + animal.getSicknessCase().getMedication());
        l4 = new JLabel("Veterinarian name : " + animal.getSicknessCase().getVet());


        ctn.add(l1);
        ctn.add(l2);
        ctn.add(l3);
        ctn.add(l4);
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}