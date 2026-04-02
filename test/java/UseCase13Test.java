import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class UseCase13Test {

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> list = Arrays.asList(new Bogie("A", 70), new Bogie("B", 50));
        List<Bogie> result = Main.filterWithLoop(list, 60);
        assertEquals(1, result.size());
        assertEquals(70, result.get(0).getCapacity());
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> list = Arrays.asList(new Bogie("A", 70), new Bogie("B", 50));
        List<Bogie> result = Main.filterWithStream(list, 60);
        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> list = Arrays.asList(new Bogie("A", 80), new Bogie("B", 40), new Bogie("C", 90));
        List<Bogie> loopRes = Main.filterWithLoop(list, 60);
        List<Bogie> streamRes = Main.filterWithStream(list, 60);
        assertEquals(loopRes.size(), streamRes.size(), "Both methods must return same number of items");
    }

    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        // Small delay simulation or operation
        Main.filterWithLoop(Arrays.asList(new Bogie("A", 70)), 60);
        long end = System.nanoTime();
        assertTrue((end - start) > 0, "Execution time should be a positive value");
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> largeList = new ArrayList<>();
        for(int i=0; i<1000; i++) largeList.add(new Bogie("Test", i%100));

        List<Bogie> result = Main.filterWithStream(largeList, 60);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}