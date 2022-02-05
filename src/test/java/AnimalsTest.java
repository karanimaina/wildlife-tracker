import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalsTest {
    private Animals setupAnimals(){
        return new Animals("Zebra");
    }

    @Test
    public void Animal_instantiatesCorrectly(){
        Animals animals = setupAnimals();
        assertTrue(animals instanceof Animals);
    }

    @Test
    public void Animal_getsNameOfSavedAnimal() {

    }
}