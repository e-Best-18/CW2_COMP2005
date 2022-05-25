public class Main {

    public static void main(String[] args) throws Exception, CustomException {
        //parsing API JSON to a JSONArray called data_arr
        HandleJSON.parseJSON(HandleJSON.getURL(HandleJSON.url_string));
        //filling JSONArrays with the information about each data
        HandleJSON.createArrays();

  //      HandleUserInput.handleUserInput(HandleUserInput.checkUserInput(HandleUserInput.getUserInput()));

        String input = HandleUserInput.handleUserInput(HandleUserInput.getUserInput());
        System.out.print("You have entered: "+ input + "\r\n");

        //method for each business requirement
        Requirement1.handleRequirement1(input);

//        System.out.println("times year matched input = " + temp_counter);

        //indicating process finished for testing
        System.out.println("done");

    }


}
