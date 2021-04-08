package persistence;


import model.Animal;
import model.SicknessCase;
import model.AnimalRecord;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ReaderTest {
    @Test
    void testParseAnimalRecordFile1(){
        try{
            List<Animal> animals = Reader.readRecords(new File("./data/testAnimalFile1.txt"));
            Animal animal1 = animals.get(0);
            assertEquals("lily",animal1.getName());
            assertEquals("cat",animal1.getType());
            assertEquals("painkiller",animal1.getSicknessCase().getMedication());

            Animal animal2 = animals.get(1);
            assertEquals("bob",animal2.getName());
            assertEquals("dog",animal2.getType());
            assertEquals(3,animal2.getAge());
            assertEquals("Dr.T",animal2.getSicknessCase().getVet());

        } catch (IOException e){
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testIOException() {
        try {
            Reader.readRecords(new File("./path/does/not/exist/testAnimal.txt"));
        } catch (IOException e) {
            // expected
        }
    }
}
