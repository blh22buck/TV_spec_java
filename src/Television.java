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
            //channelNumberToNameMap will not be empty
            //if channel collection and channelNumberToNameMap passed is in not null
            if(channelCollection == null && channelNumberToNameMap != null) {
                //create new HashMap from Map passed in
                channelCollection = new HashMap<>(channelNumberToNameMap);
                //set default channel to 1
                currentChannel = 1;
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
            if(!isValidChannel (channelNumber)) {
                //if channel number is invalid let user know
                return "ERROR channel number is invalid.";
            } else if (channelCollection == null) {
                //if trying to access channels that do not exist let user know
                return "ERROR channels have not been established yet.";
            } else {
                //the channelNumber is valid and can be looked-up
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
                //if we add one to the current channel is it valid?
                if(isValidChannel(String.valueOf(currentChannel + 1))){
                    //the channelNumber is valid and can be looked-up
                    //add one to currentChannel and lookup
                    return channelCollection.get(String.valueOf(++currentChannel));
                } else {
                    //if we add one to the current channel it will go over the limit
                    //set currentChannel to the beginning of the list
                    currentChannel = 1;
                    return  channelCollection.get(String.valueOf(currentChannel));
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
            if (channelCollection != null) {
                //if we subtract one from the current channel is it valid?
                if (isValidChannel(String.valueOf(currentChannel - 1))) {
                    //the channelNumber is valid and can be looked up
                    //subtract one from it and lookup
                    return channelCollection.get(String.valueOf(--currentChannel));
                } else {
                    //if we subtract one from the current channel it will go below the range of channels
                    //set currentChannel to the end of the list
                    currentChannel = channelCollection.size();
                    return channelCollection.get(String.valueOf(currentChannel));
                }
            } else {
                return "ERROR channels have not been established yet.";
            }
        }

        /**
         * Checks if a string is within the range of TV channels.
         *
         * @return
        true if positive integer and within the range of TV channels, return false otherwise
         */
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
        true if positive integer, return false otherwise
         */
        private boolean isPositiveNumber(String s) {
            if (s != null && s.matches("[-+]?\\d*\\.?\\d+") && Integer.parseInt(s) > 0) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * Prints the current channel name to the console.
         */
        public void printCurrentChannel(){
            if(channelCollection != null){
                System.out.println("Channel: "+channelCollection.get(String.valueOf(currentChannel)));
            }
        }


    }