import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JUnitTest {
    SectionControl sectionControl;
    Duration duration;
    PenalData penalData;

    @Before
    public void setup(){
        sectionControl = new SectionControl(1000, 50);
    }

    @Test
    public void testPenalData(){
        sectionControl.newCarEntered("L3B4432", 0);
        sectionControl.carLeft("L3B4432", 10);
        assertEquals("L3B4432", sectionControl.getPenalDataList().get(0).getPlateNumber());

        sectionControl.newCarEntered("L3B6666", 0);
        sectionControl.carLeft("L3B6666", 15);
        assertEquals("L3B6666", sectionControl.getPenalDataList().get(1).getPlateNumber());

        sectionControl.newCarEntered("L3B6666", 0);
        sectionControl.carLeft("L3B6666", 50);
        assertEquals(20, sectionControl.calculateAverageSpeed(50), 1E-10);

        assertEquals(0, sectionControl.map.size());
    }
}
