package ui.window;

import exceptions.AnimalNotFoundException;
import model.Animal;
import model.AnimalRecord;
import model.SicknessCase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSickness extends Window {
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;

    private JTextField jt1;
    private JTextField jt2;
    private JTextField jt3;
    private JTextField jt4;

    private JButton btn;
    protected AnimalRecord record;
    private JFrame jf = new JFrame();


    public AddSickness(AnimalRecord animalRecord) {
        super(animalRecord);
        l1 = new JLabel("Animal name: ");
        l2 = new JLabel("     Sickness:  ");
        l3 = new JLabel("  Medication:  ");
        l4 = new JLabel(" Veterinarian:  ");

        jt1 = new JTextField("");
        jt2 = new JTextField("");
        jt3 = new JTextField("");
        jt4 = new JTextField("");

        btn = new JButton("Enter");
        record = animalRecord;

    }

    @Override
    public void open() {
        jf.setBounds(520, 300, 350, 230);
        jf.setResizable(false);//no change frame size
        Container ctn = jf.getContentPane();
        ctn.setLayout(new FlowLayout());

        jt1.setColumns(15);//length of letter
        jt2.setColumns(15);//length of letter
        jt3.setColumns(15);//length of letter
        jt4.setColumns(15);//length of letter

        btn.setActionCommand("myButton");
        btn.addActionListener(this);

        ctn.add(l1);
        ctn.add(jt1);
        ctn.add(l2);
        ctn.add(jt2);
        ctn.add(l3);
        ctn.add(jt3);
        ctn.add(l4);
        ctn.add(jt4);
        ctn.add(btn);

        jf.setVisible(true);
    }


    //MODIFIES: animal, animal record
    //EFFECTS: add sickness case to animal
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("myButton")) {
            String name = jt1.getText();
            String sickness = jt2.getText();
            String medication = jt3.getText();
            String veterinarian = jt4.getText();
            SicknessCase sick = new SicknessCase(sickness, false, medication, veterinarian);
            try {
                Animal animal = record.getAnimal(name);
                animal.getSicknessCase().addSicknessCase(sick);
                jf.setVisible(false);
            } catch (AnimalNotFoundException ex) {
                Window window = new AnimalNotFound(record);
                window.open();
            }
        }
    }
}







