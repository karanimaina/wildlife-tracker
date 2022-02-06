import org.junit.Test;
import org.sql2o.Sql2oException;

import static org.junit.Assert.*;

public class LocationsTest {
    @Test
    public void createInstanceOfLocationsClass() {
        Locations location=setupLocations();
        assertEquals(true,location instanceof Locations);
    }

    @Test
    public void Locations_getsNameSuccesfuly() {
        Locations locations = setupLocations();
        assertEquals("Near the river",locations.getName());
    }


    @Test
    public void saveLocationInstances() {
        Locations locations = setupLocations();
        try{
            locations.save();
            assertTrue(Locations.all().get(0).equals(locations));
        }catch (IllegalArgumentException  ex){
        System.out.println(ex);
    }
    }

    private Locations  setupLocations(){
    return new Locations("Near the river");
}

}