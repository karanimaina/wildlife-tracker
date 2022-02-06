import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class RangersTest {
    @Rule
    public DatabaseRule databaseRule=new DatabaseRule();

    @Test
    public void createInstanceOfRangersClass_true(){
        Rangers ranger= setupNewRanger();
        assertEquals(true,ranger instanceof Rangers);
    }

    @Test
    public void Ranger_getsName() {
        Rangers rangers = setupNewRanger();
        assertEquals("Felix maina",rangers.getNane());
    }
    @Test
    public void Ranger_getsBadgeNumber() {
        Rangers rangers = setupNewRanger();
        assertEquals("143234",rangers.getBadgeNumber());
    }
    @Test
    public void Ranger_getsPhoneNumber() {
        Rangers rangers = setupNewRanger();
        assertEquals("071234567",rangers.getPhoneNumber());
    }

    @Test
    public void ChecksRangerCorrectlySaves() {
        Rangers ranger = setupNewRanger();
        ranger.save();
        assertTrue(Rangers.all().get(0).equals(ranger));
    }

    @Test
    public void null_fieldsAreNotSaved() {
        Rangers rangers = new Rangers("","","12345");
        try {
            rangers.save();
            assertTrue(Rangers.all().get(0).equals(rangers));
        }catch (IllegalArgumentException ex){
            System.out.println(ex);
        }
    }
    @Test
    public void findById() {
        Rangers ranger= setupNewRanger();
        Rangers otherRanger=new Rangers("Maina","2537t841","0726108898");
        ranger.save();
        otherRanger.save();
        Rangers foundRanger=Rangers.find(ranger.getId());
        assertTrue(foundRanger.equals(ranger));

    }
    @Test
    public void entriesAreDeleted() {
        Rangers ranger= setupNewRanger();
        Rangers otherRanger=new Rangers("Maria","223456","077689583");
        ranger.save();
        otherRanger.save();
        ranger.delete();
        assertEquals(null,Rangers.find(ranger.getId()));

    }
    @Test
    public void allSightingsAreReturnedForRanger() {
        Rangers ranger= setupNewRanger();
        try {
            Locations location=new Locations("Zone A");
            ranger.save();
            location.save();
            Sightings sighting=new Sightings(location.getId(),ranger.getId(),1);
            Sightings otherSighting=new Sightings(1,ranger.getId(),1);
            sighting.save();
            otherSighting.save();
            assertEquals(ranger.getRangerSightings().get(0),sighting);
            assertEquals(ranger.getRangerSightings().get(1),otherSighting);
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }

    }

    private Rangers setupNewRanger(){
        return new Rangers("Felix maina","143234","071234567");
    }




}