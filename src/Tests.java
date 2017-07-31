import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by B on 7/30/2017.
 */
public class Tests {
    private Television tv;

    @Before
    public void b4Tests(){
        Map<String, String> temp = new HashMap<>();
        temp.put("8", "h");
        temp.put("2", "b");
        temp.put("4", "d");
        temp.put("5", "e");
        temp.put("1", "a");
        temp.put("6", "f");
        temp.put("7", "g");
        temp.put("3", "c");
        temp.put("9", "i");

        tv = new Television(temp);
    }

    @Test
    public void test1() {
            assertEquals("channel must be 'h' ", "h", tv.goToChannel("8"));
    }

    @Test
    public void testInvalidChannel() {
        assertEquals("Channel is invalid", "ERROR channel number is invalid.", tv.goToChannel("88"));
    }
}
