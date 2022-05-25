import org.json.simple.JSONObject;

public class Requirement1 {

    //create array to hold airports and dates to be returned
    public static String[] requirement1_arr = new String[5];

    public static void processRequirement1(String user_input){

        //create a temporary array for checking the delayed and cancelled flights totals
        int[] min_delayed_cancelled_array = new int[5];

        //checks each data in time array
        for (int i = 0; i < HandleJSON.time_arr.size(); i++) {
            JSONObject time = (JSONObject) HandleJSON.time_arr.get(i);
            //gets the year from time_arr[i]
            String time_string = time.get("Year").toString();

            //if time.year is the same as user input, fills requirements array appropriately
            if (time_string.equals(user_input)) {
                //calculates number of delayed + cancelled flights
                JSONObject flight = (JSONObject) HandleJSON.flights_arr.get(i);

                int delayed_int = Integer.parseInt(flight.get("Delayed").toString());
                int cancelled_int = Integer.parseInt(flight.get("Cancelled").toString());
                int delayed_and_cancelled = delayed_int + cancelled_int;

                //loop through temp_delayed_and_cancelled_array
                for (int j = 0; j < min_delayed_cancelled_array.length; j++) {
                    //if the delayed + cancelled flights is smaller than the previous, it gets put into the array of minimums
                    if (delayed_and_cancelled < min_delayed_cancelled_array[j] || min_delayed_cancelled_array[j] == 0) {
                        min_delayed_cancelled_array[j] = delayed_and_cancelled;

                        //finds the element in airport_arr with a matching index to time_arr
                        JSONObject airport = (JSONObject) HandleJSON.airport_arr.get(i);

                        //creates a readable message to return including airport name and date
                        String requirement1_list_string = "Airport: " + airport.get("Name") + " - Date: " + time.get("Label").toString() + " - Delayed and Cancelled Flights: " + min_delayed_cancelled_array[j];
                        requirement1_arr[j] = requirement1_list_string;

                        break;
                    }
                }
            }
        }
        for (int i = 0; i < requirement1_arr.length; i++) {
            System.out.println(requirement1_arr[i]);
        }
    }

    public static void handleRequirement1(String input) throws Exception, CustomException {
        int input_int = Integer.parseInt(input);
        String output = "";
        do {
            //if input is in the range of 2003 - 2010, run the method
            if (input_int < 2003 || input_int > 2010) {
                System.out.println("This task requires a number within the range of 2003 - 2010");
                input_int = Integer.parseInt(HandleUserInput.handleUserInput(HandleUserInput.getUserInput()));
            }
        //loop while input is outside the range
        } while (input_int < 2003 || input_int > 2010);

        output = Integer.toString(input_int);

        processRequirement1(output);
    }
}
