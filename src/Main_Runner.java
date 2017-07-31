import java.util.HashMap;
import java.util.Map;

/**
 * Created by B on 7/30/2017.
 */
public class Main_Runner {

    public static void main(String []args){

        System.out.println("Running...");

        Map<String, String> temp = new HashMap<>();
        temp.put("56", "f");
        temp.put("68", "h");
        temp.put("70", "i");
        temp.put("46", "e");
        temp.put("1", "a");
        temp.put("3", "b");
        temp.put("44", "c");
        temp.put("45", "d");
        temp.put("57", "g");


        Television tv = new Television(temp);

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
        System.out.println("go to channel 10 "+tv.goToChannel("10"));
        System.out.println("go to channel 1 "+tv.goToChannel("1"));
        System.out.println("go to channel 0 "+tv.goToChannel("0"));
        System.out.println("go to channel e "+tv.goToChannel("e"));
        System.out.println("channel up= " + tv.channelUp());
        System.out.println("channel down= " + tv.channelDown());
        System.out.println("channel down= " + tv.channelDown());
        System.out.println("channel up= " + tv.channelUp());

    }


}
