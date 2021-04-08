package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Unit tests for the SicknessCase class
public class SicknessCaseTest {
    SicknessCase case1;
    SicknessCase case2;

    @BeforeEach
    void runBefore() {
        case1 = new SicknessCase("Fracture", false,
                "Pain Killer", "Dr Matt");
        case2 = new SicknessCase("Tick", true,
                "Tick Treatment", "Dr Vivian");
    }

    @Test
    void testGetSickness(){
        assertEquals("Fracture",case1.getSickness());
        assertEquals("Tick",case2.getSickness());
    }

    @Test
    void testGetMedication(){
        assertEquals("Pain Killer",case1.getMedication());
        assertEquals("Tick Treatment",case2.getMedication());
    }

    @Test
    void testGetVet(){
        assertEquals("Dr Matt",case1.getVet());
        assertEquals("Dr Vivian",case2.getVet());
    }

    @Test
    void testIsTreated(){
        assertFalse(case1.isTreated());
        assertTrue(case2.isTreated());
    }

    @Test
    void testAddSicknessCase(){
        case1.addSicknessCase(case2);
        assertEquals("Tick",case1.getSickness());
    }
}
