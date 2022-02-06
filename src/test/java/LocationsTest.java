import org.junit.Test;

import static org.junit.Assert.*;

public class LocationsTest {
    @Test
    public void createInstanceOfLocationsClass() {
        Locations location=setupLocations();
        assertEquals(true,location instanceof Locations);
    }
private Locations  setupLocations(){
    return new Locations("Near the river");
}

}