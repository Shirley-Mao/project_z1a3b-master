package ui.window;

import exceptions.AnimalNotFoundException;
import model.Animal;
import model.AnimalRecord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ViewSickness extends Window {
    private JFrame jf = new JFrame();
    private JLabel la;
    private JTextField jt1;
    private JButton btn;
    protected AnimalRecord record;


    public ViewSickness(AnimalRecord animalRecord) {
        super(animalRecord);
        record = animalRecord;
        la = new JLabel("Animal name: ");
        jt1 = new JTextField("");
        btn = new JButton("Enter");
    }

    @Override
    public void open() {
        jf.setBounds(520, 300, 350, 100);
        jf.setResizable(false);//no change frame size
        Container ctn = jf.getContentPane();
        ctn.setLayout(new FlowLayout());

        ctn.add(la);
        jt1.setColumns(15);//length of letter
        ctn.add(jt1);
        btn.setActionCommand("myButton");
        btn.addActionListener(this);
        ctn.add(btn);
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = jt1.getText();
        Window window = new FindSickness(record, name);
        window.open();
    }
}