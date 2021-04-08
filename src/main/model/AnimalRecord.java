package model;


import exceptions.AnimalNotFoundException;
import persistence.Saveable;

import java.io.PrintWriter;
import java.util.ArrayList;

//Represents records for all the animals
public class AnimalRecord {
    private ArrayList<Animal> data;

    //EFFECTS: constructs an empty animal record
    public AnimalRecord() {
        data = new ArrayList<>();
    }

    //EFFECTS: returns data
    public ArrayList<Animal> getData() {
        return data;
    }

    //EFFECTS: returns total number of animals in the record
    public int getTotalNumberOfAnimal() {
        return data.size();
    }

    //EFFECTS: returns the record for the animal with the given name
    public Animal getAnimal(String name) throws AnimalNotFoundException {
        for (Animal animal : data) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        throw new AnimalNotFoundException("Animal does not exist in file!");
    }

    //MODIFIES: this
    //EFFECTS: add a new animal to the animal record
    public void addAnimal(Animal animal) {
        data.add(new Animal(animal.getName(), animal.getType(), animal.getAge(), animal.getSicknessCase()));
    }
}
