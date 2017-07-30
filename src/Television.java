import java.util.HashMap;
import java.util.Map;

/**
 * Goal: Implement the constructor and methods below.
 *
 * Guidelines:
 * 1. Use any programming language you like. If you switch away from Java, please rewrite the code below in your
 *    desired language. Please use actual code (no pseudocode).
 * 2. Feel free to add any additional private member methods/variables/classes.
 * 3. Please capture any assumptions that you make about the program.
 * -> The channels and numbers cannot be changed once created
 *
 * 4. We want to see your best work - style, problem solving, etc. Your solution should handle every edge case you can
 *    think of.
 *
 * Question:
 * Is your solution optimal? If so, why?
 */

    /**
     * Class to Model a Television.
     */
    public class Television {
        private Map<String, String> channelCollection;
        private Integer currentChannel;

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
            if(channelCollection == null && channelNumberToNameMap != null) { //channelNumberToNameMap will not be empty
                channelCollection = new HashMap<>(channelNumberToNameMap);
                currentChannel = 1;
                System.out.print("Beginning with ");
                printCurrentChannel();
            } else {
                //do nothing
                //channelCollection has already been created
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
            //keys will all be numeric and positive
            if(!isValidChannel (channelNumber)) {
                return "ERROR channel number is invalid.";
            } else if (channelCollection == null) {
                return "ERROR channels have not been established yet.";
            } else {
                currentChannel = Integer.parseInt(channelNumber);
                return channelCollection.get(String.valueOf(currentChannel));
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
                if(isValidChannel(String.valueOf(currentChannel + 1))){
                    return channelCollection.get(String.valueOf(++currentChannel));
                } else {
                    currentChannel = 1;
                    return  channelCollection.get(String.valueOf(currentChannel));
                }
            } else {
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
            if (channelCollection != null) {
                if (isValidChannel(String.valueOf(currentChannel - 1))) {
                    return channelCollection.get(String.valueOf(--currentChannel));
                } else {
                    currentChannel = channelCollection.size();
                    return channelCollection.get(String.valueOf(currentChannel));
                }
            } else {
                return "ERROR channels have not been established yet.";
            }
        }


        private boolean isValidChannel(String s){
            if(s != null && !s.isEmpty() && isPositiveNumber(s)
                    && Integer.parseInt(s) <= channelCollection.size()){
                return true;
            } else {
                return false;
            }
        }

        /**
         * Checks if a string is a positive number.
         *
         * @return
        The name of the previous channel
         */
        private boolean isPositiveNumber(String s) {
            if (s != null && s.matches("[-+]?\\d*\\.?\\d+") && Integer.parseInt(s) > 0) {
                return true;
            } else {
                return false;
            }
        }

        public void printCurrentChannel(){
            if(channelCollection != null){
                System.out.println("Channel: "+channelCollection.get(String.valueOf(currentChannel)));
            }
        }


    }