import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class UseCase9Test {

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("Sleeper", 72), new Bogie("AC", 50));
        Map<String, List<Bogie>> result = Main.groupBogiesByType(list);

        assertTrue(result.containsKey("Sleeper"));
        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC").size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();
        Map<String, List<Bogie>> result = Main.groupBogiesByType(list);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>(Arrays.asList(new Bogie("Sleeper", 72)));
        Main.groupBogiesByType(list);
        assertEquals(1, list.size(), "Original list must remain unchanged");
    }
}
