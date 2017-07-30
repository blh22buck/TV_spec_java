import java.util.HashMap;
import java.util.Map;

/**
 * Created by B on 7/30/2017.
 */
public class Main_Runner {

    public static void main(String []args){

        System.out.println("Running...");

        Map<String, String> temp = new HashMap<>();
        temp.put("1", "a");
        temp.put("2", "b");
        temp.put("3", "c");
        temp.put("4", "d");
        temp.put("5", "e");
        temp.put("6", "f");
        temp.put("7", "g");
        temp.put("8", "h");
        temp.put("9", "i");

        Television tv = new Television(temp);

        System.out.println("channel down= " + tv.channelDown());
        System.out.println("channel down= " + tv.channelDown());
        System.out.println("channel down= " + tv.channelDown());
        System.out.println("channel down= " + tv.channelDown());
        System.out.println("channel down= " + tv.channelDown());
        System.out.println("channel down= " + tv.channelDown());
        System.out.println("channel down= " + tv.channelDown());
        System.out.println("channel down= " + tv.channelDown());
        System.out.println("channel down= " + tv.channelDown());
        System.out.println("channel down= " + tv.channelDown());
        System.out.println("channel down= " + tv.channelDown());
        System.out.println("channel up= " + tv.channelUp());
        System.out.println("go to channel 5 "+tv.goToChannel("5"));
        System.out.println("channel up= " + tv.channelUp());
        System.out.println("channel up= " + tv.channelUp());
        System.out.println("channel up= " + tv.channelUp());
        System.out.println("channel up= " + tv.channelUp());
        System.out.println("channel up= " + tv.channelUp());
        System.out.println("channel up= " + tv.channelUp());
        System.out.println("channel up= " + tv.channelUp());
        System.out.println("channel up= " + tv.channelUp());
        System.out.println("channel up= " + tv.channelUp());
        System.out.println("go to channel 2 "+tv.goToChannel("22"));
        System.out.println("go to channel e "+tv.goToChannel("e"));
        System.out.println("channel up= " + tv.channelUp());
        System.out.println("channel down= " + tv.channelDown());
    }

}
