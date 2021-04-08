package persistence;

import model.Animal;
import model.SicknessCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
    public static final String DELIMITER = ",";

    // EFFECTS: returns a list of animal records parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static ArrayList<Animal> readRecords(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of animal records parsed from list of strings
    // where each string contains data for one animal
    private static ArrayList<Animal> parseContent(List<String> fileContent) {
        ArrayList<Animal> records = new ArrayList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            records.add(parseAnimal(lineComponents));
        }

        return records;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has size 7 where element 0 represents the
    // name of the next animal record to be constructed, element 1 represents
    // the type, elements 2 represents the age, element 3 represents
    // the sickness, elements 4 represents if it is treated,elements 5 represents
    // the medication and elements 6 represents the vet of the animal record to be constructed
    // EFFECTS: returns an animal constructed from components
    private static Animal parseAnimal(List<String> components) {
        String animalName = components.get(0);
        String type = components.get(1);
        int age = Integer.parseInt(components.get(2));
        String sickness = components.get(3);
        Boolean treated = Boolean.getBoolean(components.get(4));
        String medication = components.get(5);
        String vet = components.get(6);
        SicknessCase sicknessCase = new SicknessCase(sickness, treated, medication, vet);
        return new Animal(animalName, type, age, sicknessCase);
    }
}
