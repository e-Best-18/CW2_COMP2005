import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HandleJSON {

    public static String inline = "";
    //creating array for all data
    static JSONArray data_arr = new JSONArray();
    //creating the array of all airport sections
    static JSONArray airport_arr = new JSONArray();
    static JSONArray time_arr = new JSONArray();
    static JSONArray statistics_arr = new JSONArray();
    static JSONArray statistics_arr_arr = new JSONArray();
    static JSONArray no_of_delays_arr = new JSONArray();
    static JSONArray carriers_arr = new JSONArray();
    static JSONArray flights_arr = new JSONArray();
    static JSONArray mins_delayed_arr = new JSONArray();

    public static void parseJSON() {
        try {
            URL url = new URL("http://intelligent-social-robots-ws.com/airports");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {


                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();

                //Using json-simple parse the string into a json array
                JSONParser parse = new JSONParser();
                data_arr = (JSONArray) parse.parse(inline);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    //method to create arrays
    public static void createArrays() {
        //looping through each data
        for (int i = 0; i < data_arr.size(); i++) {
            //setting each data to a JSONObject
            JSONObject data = (JSONObject) data_arr.get(i);

            //adding all sections of that data to the respective arrays
            airport_arr.add(data.get("Airport"));
            time_arr.add(data.get("Time"));
            statistics_arr.add(data.get("Statistics"));

            //   for (int j = 0; j < data_arr.size(); j++) {

            //create objects for each section within statistics
            JSONObject stat = (JSONObject) statistics_arr.get(i);
            //add that object to arrays of respective section
            no_of_delays_arr.add(stat.get("# of Delays"));
            carriers_arr.add(stat.get("Carriers"));
            flights_arr.add(stat.get("Flights"));
            mins_delayed_arr.add(stat.get("Minutes Delayed"));
            //  }
        }
    }


}
