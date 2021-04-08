package persistence;

import model.Animal;
import model.SicknessCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class WriterTest {
    private static final String TEST_FILE = "./data/testAnimals.txt";
    private Writer testWriter;
    private Animal animal;
    private SicknessCase sicknessCase;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));
        sicknessCase = new SicknessCase("none", true, "none", "none");
        animal = new Animal("lily", "cat", 2, sicknessCase);
        sicknessCase = new SicknessCase("fracture"
                , false, "painkiller", "Dr.V");
        animal.getSicknessCase().addSicknessCase(sicknessCase);
    }

    @Test
    void testWriteAnimal(){
        testWriter.write(animal);
        testWriter.close();

        try{
            List<Animal> animals = Reader.readRecords(new File(TEST_FILE));
            Animal animal = animals.get(0);
            assertEquals("lily",animal.getName());
            assertEquals("cat",animal.getType());
            assertEquals("painkiller",animal.getSicknessCase().getMedication());
        } catch (IOException e){
            fail("IOException should not have been thrown");
        }
    }
}
