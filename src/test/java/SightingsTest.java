import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SightingsTest {

    @Rule
    public DatabaseRule databaseRule=new DatabaseRule();

    @Test
    public void createInstanceOfSightingsClass_true() {
        Sightings sighting= setupSightings();
        assertEquals(true,sighting instanceof Sightings);

    }
    @Test
    public void allInstancesAreSaved() {
        Sightings sightings = setupSightings();
        Sightings otherSighting = new Sightings(1, 1, 1);
        sightings.save();
        otherSighting.save();
        assertTrue(Sightings.find(sightings.getId()).equals(sightings));
    }

    @Test
    public void returnsLocationId() {
       Sightings sightings = setupSightings();
       assertEquals(3,sightings.getLocation_id());
    }
    @Test
    public void returnsLRangerId() {
        Sightings sightings = setupSightings();
        assertEquals(2,sightings.getRanger_Id());
    }
    @Test
    public void returnsAnimal_Id() {
        Sightings sightings = setupSightings();
        assertEquals(7,sightings.getAnimal_Id());
    }


    private  Sightings setupSightings(){
        return  new Sightings(2,3,7);
    }

}
