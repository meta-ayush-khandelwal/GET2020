package Question3;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculateMassTestCase {

    @Test
    public void test_calculateMolecularMass_withCompound_ShouldReturn_massAs29() {
        CalculateMass chemicalAtomicMass = new CalculateMass();
        assertEquals(29, chemicalAtomicMass.getMass("CHO"));
    }

    @Test
    public void test_calculateMolecularMass_withCompound_ShouldReturn_massAs45() {
        CalculateMass chemicalAtomicMass = new CalculateMass();
        assertEquals(45, chemicalAtomicMass.getMass("CHO2"));
    }

    @Test (expected=AssertionError.class)
    public void test_calculateMolecularMass_withInvalidCompound_ShouldThrowError() {
        CalculateMass chemicalAtomicMass = new CalculateMass();
        assertEquals(29, chemicalAtomicMass.getMass("CHA"));
    }

    @Test
    public void test_calculateMolecularMass_withNull_ShouldReturn_0() {
        CalculateMass chemicalAtomicMass = new CalculateMass();
        assertEquals(0, chemicalAtomicMass.getMass(""));
    }

}
