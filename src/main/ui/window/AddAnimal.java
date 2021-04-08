package ui.window;

import model.Animal;
import model.AnimalRecord;
import model.SicknessCase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddAnimal extends Window {
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;

    private JTextField jt1;
    private JTextField jt2;
    private JTextField jt3;

    private JButton btn;
    private JFrame jf = new JFrame();
    protected AnimalRecord record;

    public AddAnimal(AnimalRecord animalRecord) {
        super(animalRecord);
        l1 = new JLabel("Animal name: ");
        l2 = new JLabel(" Animal type: ");
        l3 = new JLabel("  Animal age:  ");

        jt1 = new JTextField("");
        jt2 = new JTextField("");
        jt3 = new JTextField("");

        btn = new JButton("Enter");
        record = animalRecord;

    }

    @Override
    public void open() {
        jf.setBounds(520, 300, 350, 200);
        jf.setResizable(false);//no change frame size
        Container ctn = jf.getContentPane();
        ctn.setLayout(new FlowLayout());

        ctn.add(l1);
        jt1.setColumns(15);//length of letter
        ctn.add(jt1);

        ctn.add(l2);
        jt2.setColumns(15);//length of letter
        ctn.add(jt2);

        ctn.add(l3);
        jt3.setColumns(15);//length of letter
        ctn.add(jt3);

        btn.setActionCommand("myButton");
        btn.addActionListener(this);

        ctn.add(btn);
        jf.setVisible(true);
    }


    //MODIFIES: animal record
    //EFFECTS: add animal to record
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("myButton")) {
            String name = jt1.getText();
            String type = jt2.getText();
            int age = Integer.parseInt(jt3.getText());
            SicknessCase healthy = new SicknessCase("none", true, "none", "none");
            Animal animal = new Animal(name, type, age, healthy);
            record.addAnimal(animal);
            jf.setVisible(false);
        }
    }
}



