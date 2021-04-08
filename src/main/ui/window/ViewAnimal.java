package ui.window;

import model.AnimalRecord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ViewAnimal extends Window {
    private JFrame jf = new JFrame();
    private JButton btn;
    private JTextField jt1;
    private JLabel la;

    protected AnimalRecord record;

    public ViewAnimal(AnimalRecord animalRecord) {
        super(animalRecord);
        record = animalRecord;
        btn = new JButton("Enter");
        jt1 = new JTextField("");
        la = new JLabel("Animal name: ");

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
        if (e.getActionCommand().equals("myButton")) {
            String name = jt1.getText();
            Window window = new FindAnimal(record,name);
            window.open();
        }
    }
}
