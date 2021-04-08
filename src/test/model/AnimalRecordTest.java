package model;

import static org.junit.jupiter.api.Assertions.*;

import exceptions.AnimalNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


//Unit tests for the AnimalRecord class
class AnimalRecordTest {
    AnimalRecord record;
    Animal animal1;
    Animal animal2;
    Animal animal3;
    SicknessCase case1;
    SicknessCase case2;


    @BeforeEach
    void runBefore() {
        animal1 = new Animal("Lily", "dog", 2, new SicknessCase("none", true,
                "none", "none"));
        animal2 = new Animal("Kitty", "cat", 4, new SicknessCase("none", true,
                "none", "none"));
        animal3 = new Animal("Fluffy", "dog", 10, new SicknessCase("none", true,
                "none", "none"));
        case1 = new SicknessCase("Fracture", false,
                "painKiller", "Dr Matt");
        case2 = new SicknessCase("Tick", false,
                "ticktreatment", "Dr Vivian");

        record = new AnimalRecord();
    }

    @Test
    void testGetTotalNumberOfAnimal() {
        record.addAnimal(animal1);
        assertEquals(1, record.getTotalNumberOfAnimal());
        record.addAnimal(animal2);
        record.addAnimal(animal3);
        assertEquals(3, record.getTotalNumberOfAnimal());
    }


    @Test
    void testGetAnimal() {
        try {
            record.addAnimal(animal1);
            record.addAnimal(animal2);
            assertEquals("Lily", record.getAnimal("Lily").getName());
            assertEquals("cat", record.getAnimal("Kitty").getType());
        } catch (AnimalNotFoundException e) {
            fail("Should not have thrown exception.");
        }
    }

    @Test
    void testGetAnimalNameNotFound() {
        try {
            record.addAnimal(animal1);
            record.addAnimal(animal2);
            assertEquals("Lily", record.getAnimal("Lily").getName());
            record.getAnimal("Kristy");
            fail("Should not have thrown exception.");
        } catch (AnimalNotFoundException e) {
        }
    }

    @Test
    void testGetSicknessCase() {
        try {
            record.addAnimal(animal1);
            record.addAnimal(animal2);
            record.addAnimal(animal3);
//            record.addSicknessCase(case1, "Lily");
            record.getAnimal("Lily").getSicknessCase().addSicknessCase(case1);
            animal2.getSicknessCase().addSicknessCase(case2);
            assertEquals("Fracture", record.getAnimal("Lily")
                    .getSicknessCase().getSickness());
            assertEquals("Dr Vivian", record.getAnimal("Kitty")
                    .getSicknessCase().getVet());
            assertEquals("none", record.getAnimal("Fluffy").getSicknessCase().getMedication());
        } catch (AnimalNotFoundException e) {
            fail("Should not have thrown exception.");
        }
    }

    @Test
    void testGetSicknessCaseWithNameNotFound() {
        try {
            record.addAnimal(animal1);
            record.addAnimal(animal2);
            record.addAnimal(animal3);
//            record.addSicknessCase(case1, "Lily");
            record.getAnimal("Lily").getSicknessCase().addSicknessCase(case1);
            animal2.getSicknessCase().addSicknessCase(case2);
            assertEquals("Fracture", record.getAnimal("Lily")
                    .getSicknessCase().getSickness());
            assertEquals("Dr Vivian", record.getAnimal("Kitty")
                    .getSicknessCase().getVet());
            record.getAnimal("John").getSicknessCase();
            fail("Should not have thrown exception.");
        } catch (AnimalNotFoundException e) {
        }
    }

    @Test
    void testGetData() {
        record.addAnimal(animal1);
        record.addAnimal(animal2);
        record.addAnimal(animal3);
        assertEquals(3, record.getData().size());
    }

    @Test
    void testToString() {
        try {
            record.addAnimal(animal1);
            assertEquals("[ name = Lily, type = dog, age = 2, name of sickness = none, is it treated = true, name of medication needed = none, name of vet = none]", record.getAnimal("Lily").toString());
        } catch (AnimalNotFoundException e) {
            fail("Should not have thrown exception.");
        }
    }

    @Test
    void testToStringWithNameMotFound() {
        try {
            record.addAnimal(animal1);
            record.getAnimal("Kitty").toString();
            fail("Should not have thrown exception.");
            record.getAnimal("Lily").toString();
        } catch (AnimalNotFoundException e) {
        }
    }
}