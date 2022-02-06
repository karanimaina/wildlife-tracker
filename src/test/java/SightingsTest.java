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
    private  Sightings setupSightings(){
        return  new Sightings(2,3,7);
    }
}
