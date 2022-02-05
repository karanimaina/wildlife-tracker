import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalsTest {
    private Animals setupAnimals() {
        return new Animals("Zebra");
    }

    @Test
    public void Animal_instantiatesCorrectly() {
        Animals animals = setupAnimals();
        assertTrue(animals instanceof Animals);
    }

    @Test
    public void Animal_getsNameOfSavedAnimal() {
        Animals animals = setupAnimals();
        assertEquals("Zebra", animals.getName());
    }

    @Test
    public void Animal_returnsCategoryOfSavedAnimal() {
        Animals animals = setupAnimals();
        assertEquals(" not endangered",animals.getType());
    }

    @Test
    public void Animal_allInstancesAreSaved() {
        Animals animals = setupAnimals();
        animals.save();
        assertTrue(Animals.all().get(0).equals(animals));

    }
}