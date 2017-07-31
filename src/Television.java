import java.util.*;

/**
 *  @author Bryce Hairabedian
 *  @date July 30th, 2017
 *
 */

/**
 * Goal: Implement the constructor and methods below.
 *
 * Guidelines:
 * 1. Use any programming language you like. If you switch away from Java, please rewrite the code below in your
 *    desired language. Please use actual code (no pseudocode).
 * 2. Feel free to add any additional private member methods/variables/classes.
 * 3. Please capture any assumptions that you make about the program.
 *      Assumption -> The channels and numbers cannot be changed once created
 *
 * 4. We want to see your best work - style, problem solving, etc. Your solution should handle every edge case you can
 *    think of.
 *
 * Question:
 * Is your solution optimal? If so, why? Yes,
 *      -> My solution checks for all edge cases. Below zero, out of range, or a non numeric value.
 *      The HashMap provides average case of O(1) lookups with all .get() and .put()'s.
 *      It also keeps track internally what channel is currently being tuned in with currentChannel.
 *      The Channel number is validated for range and numeric value before being looked-up.
 *      Errors are unique to let user know what went wrong.
 */

    /**
     * Class to Model a Television.
     */
    public class Television {
        private LinkedHashMap<String, String> channelCollection;
        private String keyCurrentChannel;
        private int currentChannel;
        private int largetsValue;
        private int smallestValue;

        /**
         * Constructor
         *
         * @param channelNumberToNameMap A map of every channel number and its corresponding channel name
         *
         * NOTE: It is safe to assume that the channelNumberToNameMap's keys will all be numeric and positive
         *       and the values will be non-null/whitespace. In addition, channelNumberToNameMap will not be empty.
         *       Do not make any other assumptions about channelNumberToNameMap or the data it contains.
         */
        public Television(Map<String, String> channelNumberToNameMap) {
            //channelNumberToNameMap will not be empty
            //if channel collection and channelNumberToNameMap passed is in not null
            if(channelCollection == null && channelNumberToNameMap != null) {
                //create new HashMap from Map passed in
                channelCollection = new LinkedHashMap<>(channelNumberToNameMap);
                setLargestValueForChannel();
                setSmallestValueForChannel();
                currentChannel = smallestValue;

                keyCurrentChannel = ((channelCollection.entrySet().iterator().next()).getKey());
                //let user know which channel TV is going to begin with
                System.out.print("Beginning with ");
                printCurrentChannel();
            } else {
                //do nothing
                //channelCollection has already been created
                //assumption -> The channels and numbers cannot be changed once created
            }
        }

        /**
         * Changes the Television to the desired channel.
         *
         * @param channelNumber The desired channel number
         * @return
        The name of the desired channel
         */
        public String goToChannel(String channelNumber) {
            //check to make sure the channelNumber is a valid number to lookup
            if(channelCollection.containsKey(channelNumber)){
                currentChannel = Integer.parseInt(channelNumber);
                return channelCollection.get(channelNumber);
            } else {
                return "ERROR: This channel number is invalid";
            }
        }

        /**
         * Changes the Television channel once in an ascending direction.
         *
         * @return
        The name of the next channel
         */
        public String channelUp() {
            if (channelCollection != null){
                if(currentChannel < largetsValue){
                    for(int i=currentChannel+1; i<=largetsValue; i++){
                        if(channelCollection.containsKey(String.valueOf(i))){
                            currentChannel = i;
                            return channelCollection.get(String.valueOf(currentChannel));
                        }
                    }
                    return "Couldn't find channel";
                } else { //current channel is the largest value
                    //revert back to beginning of channels list
                    currentChannel = smallestValue;
                    return channelCollection.get(String.valueOf(currentChannel));
                }
            } else {
                //if trying to access channels that do not exist let user know
                return "ERROR channels have not been established yet.";
            }
        }


        /**
         * Changes the Television channel once in a descending direction.
         *
         * @return
        The name of the previous channel
         */
        public String channelDown() {
            if (channelCollection != null){
                if(currentChannel > smallestValue){
                    for(int i=currentChannel - 1; i>=smallestValue; i--){
                        if(channelCollection.containsKey(String.valueOf(i))){
                            currentChannel = i;
                            return channelCollection.get(String.valueOf(currentChannel));
                        }
                    }
                    return "Couldn't find channel";
                } else { //current channel is the largest value
                    //revert to end of channels list
                    currentChannel = largetsValue;
                    return channelCollection.get(String.valueOf(currentChannel));
                }
            } else {
                //if trying to access channels that do not exist let user know
                return "ERROR channels have not been established yet.";
            }
        }

        private void setSmallestValueForChannel(){
            Iterator i = channelCollection.entrySet().iterator();
            int smallest = 0; int compareTo = 0;
            while (i.hasNext()){
                compareTo = Integer.parseInt((String) ((Map.Entry) i.next()).getKey());
                if(compareTo < smallest){
                    smallest = compareTo;
                }
            }
            smallestValue = smallest;
        }
        private void setLargestValueForChannel(){
            Iterator i = channelCollection.entrySet().iterator();
            int largest = 0; int compareTo = 0;
            while (i.hasNext()){
                compareTo = Integer.parseInt((String) ((Map.Entry) i.next()).getKey());
                if(compareTo > largest){
                    largest = compareTo;
                }
            }
            largetsValue = largest;
        }
        /**
         * Prints the current channel name to the console.
         */
        public void printCurrentChannel(){
            if(channelCollection != null){
                System.out.println("Channel: "+channelCollection.get(keyCurrentChannel));
            }
        }


    }