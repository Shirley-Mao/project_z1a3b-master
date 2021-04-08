package ui;

import model.Animal;
import model.AnimalRecord;
import persistence.Reader;
import persistence.Writer;
import ui.window.*;
import ui.window.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class AppLayout extends JFrame {
    JFrame jf = new JFrame();
    Container ctn;
    Window window;
    private static final String RECORDS_FILE = "./data/animals.txt";
    protected AnimalRecord animalRecord = new AnimalRecord();

    //EFFECTS: checks the animal record application
    public AppLayout() {
        runApp();
    }

    //EFFECTS: processes user input
    private void runApp() {
        createFrame();
        initButton1();
        initButton2();
        initButton3();
        initButton4();
        initButton5();
        initButton6();
        initLabel();
        loadRecords();
        jf.setVisible(true);
    }


    //EFFECTS: make App frame
    private void createFrame() {
        jf.setBounds(450, 200, 500, 500);
        jf.setResizable(false);//no change of frame size
        ctn = jf.getContentPane();
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ctn.setLayout(null);//set layout
    }

    // MODIFIES: this
    // EFFECTS: loads animal records from RECORDS_FILE, if that file exists;
    // otherwise return empty animal record
    private void loadRecords() {
        try {
            ArrayList<Animal> records = Reader.readRecords(new File(RECORDS_FILE));
            for (int i = 0; i < records.size(); i++) {
                Animal animal = records.get(i);
                animalRecord.addAnimal(animal);
            }

        } catch (IOException e) {
            init();
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes records
    private void init() {
        System.out.println("Nothing is on Record");
    }

    // EFFECTS: saves animal records to RECORDS_FILE
    private void saveRecords() {
        try {
            Writer writer = new Writer(new File(RECORDS_FILE));
            for (Animal animal : animalRecord.getData()) {
                writer.write(animal);
            }
            writer.close();
            System.out.println("animal saved to file " + RECORDS_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save animal to " + RECORDS_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    //MODIFIES: animalRecord
    //EFFECTS: add an animal to the record
    private void initButton1() {
        JButton b1 = new JButton("Add animal");
        b1.setBounds(150, 180, 200, 30);
        ctn.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window = new AddAnimal(animalRecord);
                window.open();
            }
        });
    }

    //MODIFIES: animalRecord
    //EFFECTS: add a sickness case to animal to the record
    private void initButton2() {
        JButton b2 = new JButton("Add sickness case");
        b2.setBounds(150, 210, 200, 30);
        ctn.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window = new AddSickness(animalRecord);
                window.open();
            }
        });
    }

    //EFFECTS: get total number of animals on record
    private void initButton3() {
        JButton b3 = new JButton("Total # of animals");
        b3.setBounds(150, 240, 200, 30);
        ctn.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window = new ViewNumAnimal(animalRecord);
                window.open();
            }
        });
    }

    //EFFECTS: view information of animal on record
    private void initButton4() {
        JButton b4 = new JButton("View animal");
        b4.setBounds(150, 270, 200, 30);
        ctn.add(b4);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window = new ViewAnimal(animalRecord);
                window.open();
            }
        });
    }

    //EFFECTS: view sickness case of an animal
    private void initButton5() {
        JButton b5 = new JButton("View sickness case");
        b5.setBounds(150, 300, 200, 30);
        ctn.add(b5);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window = new ViewSickness(animalRecord);
                window.open();
            }
        });
    }

    private void initButton6() {
        JButton b6 = new JButton("Save");
        b6.setBounds(200, 330, 100, 30);
        ctn.add(b6);
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveRecords();
            }
        });
    }


    private void initLabel() {
        JLabel l = new JLabel("Welcome to Animal Record App");
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setVerticalAlignment(SwingConstants.CENTER);
        l.setSize(500, 190);
        l.setVisible(true);
        l.setFont(new Font("Serif", Font.BOLD, 30));
        ctn.add(l);
    }
}