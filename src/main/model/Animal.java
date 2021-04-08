package model;

import persistence.Reader;
import persistence.Saveable;


import java.io.PrintWriter;


//Represents an animal having name, age, type and sickness cases
public class Animal implements Saveable {
    private String animalName;
    private String type;
    private int age;
    private SicknessCase sicknessCase;

    //EFFECTS: constructs a report for an animal having name, age, type and sickness cases
    public Animal(String animalName, String type, int age, SicknessCase sicknessCase) {
        this.animalName = animalName;
        this.type = type;
        this.age = age;
        this.sicknessCase = sicknessCase;
    }

    //EFFECTS: return the name of the animal
    public String getName() {
        return animalName;
    }

    //EFFECTS: return the type of the animal
    public String getType() {
        return type;
    }

    //EFFECTS: return the age of the animal
    public int getAge() {
        return age;
    }

    //EFFECTS: return the health record of this animal
    public SicknessCase getSicknessCase() {
        return sicknessCase;
    }

    /*
     * EFFECTS: returns a string representation of an animal
     */
    @Override
    public String toString() {
        return "[ name = " + getName() + ", type = " + getType()
                + ", age = " + getAge() + ", "
                + "name of sickness = " + getSicknessCase().getSickness() + ", "
                + "is it treated = " + getSicknessCase().isTreated().toString() + ", "
                + "name of medication needed = " + getSicknessCase().getMedication() + ", "
                + "name of vet = " + getSicknessCase().getVet() + "]";
    }

    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(animalName);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(type);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(age);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(sicknessCase.getSickness());
        printWriter.print(Reader.DELIMITER);
        printWriter.print(sicknessCase.isTreated().toString());
        printWriter.print(Reader.DELIMITER);
        printWriter.print(sicknessCase.getMedication());
        printWriter.print(Reader.DELIMITER);
        printWriter.print(sicknessCase.getVet());
        printWriter.print("\n");
    }
}

