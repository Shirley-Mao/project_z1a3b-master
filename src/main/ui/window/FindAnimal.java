package ui.window;


import exceptions.AnimalNotFoundException;
import model.Animal;
import model.AnimalRecord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FindAnimal extends Window {
    private JFrame jf = new JFrame();

    private JLabel li1 = new JLabel();
    private Icon icon1 = new ImageIcon(new ImageIcon("data/cat.JPG").getImage()
            .getScaledInstance(80, 80, Image.SCALE_DEFAULT));
    private JLabel li2 = new JLabel();
    private Icon icon2 = new ImageIcon(new ImageIcon("data/dog.jpg").getImage()
            .getScaledInstance(80, 80, Image.SCALE_DEFAULT));
    private JLabel li3 = new JLabel();
    private Icon icon3 = new ImageIcon(new ImageIcon("data/bird.jpg").getImage()
            .getScaledInstance(80, 80, Image.SCALE_DEFAULT));

    private JLabel l1;
    private JLabel l2;
    private JLabel l3;

    protected AnimalRecord record;
    protected Animal animal;


    //EFFECTS: show animal information with a profile picture
    public FindAnimal(AnimalRecord animalRecord, String name) {
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
        jf.setBounds(600, 300, 180, 200);
        jf.setResizable(false);//no change frame size
        Container ctn = jf.getContentPane();
        ctn.setLayout(new FlowLayout());

        if (animal.getType().equals("cat")) {
            li1.setIcon(icon1);
            ctn.add(li1);
        } else {
            if (animal.getType().equals("dog")) {
                li2.setIcon(icon2);
                ctn.add(li2);
            } else {
                li3.setIcon(icon3);
                ctn.add(li3);
            }
        }
        l1 = new JLabel("Animal Name : " + animal.getName());
        l2 = new JLabel("Animal Type : " + animal.getType());
        l3 = new JLabel("Animal Age : " + animal.getAge());

        ctn.add(l1);
        ctn.add(l2);
        ctn.add(l3);
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}