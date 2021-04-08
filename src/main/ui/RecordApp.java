package ui;

import exceptions.AnimalNotFoundException;
import model.Animal;
import model.SicknessCase;
import model.AnimalRecord;
import persistence.Reader;
import persistence.Writer;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RecordApp {
    private static final String RECORDS_FILE = "./data/animals.txt";
    private Scanner input;
    private AnimalRecord animalRecord;
    private Animal animal;

    //EFFECTS: checks the animal record application
    public RecordApp() {
        checkRecord();
    }

    //EFFECTS: processes user input
    private void checkRecord() {
        boolean keepChecking = true;
        String command = null;
        input = new Scanner(System.in);
        animalRecord = new AnimalRecord();

        loadRecords();


        while (keepChecking) {
            showMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepChecking = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nDone");
    }

    // MODIFIES: this
    // EFFECTS: loads animal records from RECORDS_FILE, if that file exists;
    // otherwise return empty animal record
    private void loadRecords() {
        try {
            ArrayList<Animal> records = Reader.readRecords(new File(RECORDS_FILE));
            for (int i = 0; i < records.size(); i++) {
                animal = records.get(i);
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
    @SuppressWarnings("checkstyle:WhitespaceAround")
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


    //EFFECTS: displays menu of options to user
    private void showMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add animal");
        System.out.println("\ts -> add a sickness case for the animal");
        System.out.println("\tn -> total number of animals");
        System.out.println("\tv -> view sickness case");
        System.out.println("\tt -> view animal information");
        System.out.println("\tk -> save records to file");
        System.out.println("\tq -> quit");

    }

    //MODIFIES: this
    //EFFECTS: process user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addAnimal();
        } else if (command.equals("s")) {
            addCase();
        } else if (command.equals("n")) {
            getNumAnimal();
//        } else if (command.equals("c")) {
//            getNumCases();
        } else if (command.equals("v")) {
            viewSicknessCase();
        } else if (command.equals("t")) {
            viewAnimalInformation();
        } else if (command.equals("k")) {
            saveRecords();
        } else {
            System.out.println("Selection not valid");
        }
    }

    //MODIFIES: animalRecord
    //EFFECTS: add an animal to the record
    private void addAnimal() {
        System.out.println("Enter animal name");
        String name = input.next();
        System.out.println("Enter animal type");
        String type = input.next();
        System.out.println("Enter animal age");
        int age = input.nextInt();
        SicknessCase healthy = new SicknessCase("none", true, "none", "none");
        Animal animal = new Animal(name, type, age, healthy);
        animalRecord.addAnimal(animal);
        System.out.println("Animal added");
    }

    //MODIFIES: animalRecord
    //EFFECTS: add a sickness case to animal to the record
    private void addCase() {
        System.out.println("Enter animal name");
        String name = input.next();
        System.out.println("Enter description of sickness");
        String sickness = input.next();
        System.out.println("Enter medication needed");
        String medication = input.next();
        System.out.println("Enter Veterinarian");
        String veterinarian = input.next();
        SicknessCase sick = new SicknessCase(sickness, false, medication, veterinarian);
        try {
            Animal animal = animalRecord.getAnimal(name);
            animal.getSicknessCase().addSicknessCase(sick);
        } catch (AnimalNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Sickness case added");
    }

    //EFFECTS: get total number of animals on record
    private void getNumAnimal() {
        System.out.println("Total number of animals in the animal record is "
                + animalRecord.getTotalNumberOfAnimal());
    }



    //EFFECTS: view sickness case of an animal
    private void viewSicknessCase() {
        System.out.println("Enter animal name");
        String name = input.next();
        try {
            Animal animal = animalRecord.getAnimal(name);
            System.out.println("Sickness name: "
                    + animal.getSicknessCase().getSickness());
            System.out.println("Is it treated?: "
                    + animal.getSicknessCase().isTreated().toString());
            System.out.println("Medication: "
                    + animal.getSicknessCase().getMedication());
            System.out.println("Veterinarian name: "
                    + animal.getSicknessCase().getVet());
        } catch (AnimalNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    //EFFECTS: view information of animal on record
    private void viewAnimalInformation() {
        System.out.println("Enter animal name");
        String name = input.next();
        try {
            Animal animal = animalRecord.getAnimal(name);
            System.out.println("Animal name: "
                    + animal.getName());
            System.out.println("Animal type: "
                    + animal.getType());
            System.out.println("Animal age: "
                    + animal.getAge());
        } catch (AnimalNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

