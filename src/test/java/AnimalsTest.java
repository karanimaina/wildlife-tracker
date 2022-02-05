import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalsTest {
    private Animals setupAnimals() {
        return new Animals("Zebra");
    }
    @Rule
    DatabaseRule databaseRule = new DatabaseRule();

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
    public void Animal_returnsAge() {
        Animals animals = setupAnimals();
        assertEquals(" ",animals.getAge());
    }

    @Test
    public void testAnimal_returnsHealth() {
        Animals testAnimal = setupAnimals();
        assertEquals(" ",testAnimal.getHealth());
    }

    @Test
    public void AnimalRetrievesIdAndReturnsCrrectInfo() {
        Animals testAnimal = setupAnimals();
        testAnimal.save();
        Animals foundAnimal= Animals.find(testAnimal.getId());
        assertTrue(foundAnimal.equals(testAnimal));
    }

    @Test
    public void Animal_allInstancesAreSaved() {
        Animals animals = setupAnimals();
        animals.save();
        assertTrue(Animals.all().get(0).equals(animals));
    }


}