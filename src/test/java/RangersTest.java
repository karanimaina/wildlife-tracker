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
    public void name() {
        Rangers ranger = setupNewRanger();
        ranger.save();
        assertTrue(ranger.all().get(0).equals(ranger));
    }

    private Rangers setupNewRanger(){
        return new Rangers("Felix maina","143234","071234567");
    }




}