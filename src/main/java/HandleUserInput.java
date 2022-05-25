import java.util.Scanner;

public class HandleUserInput {
    public static String getUserInput() {
        String input;
            //read user input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a year within the range of 2003 - 2016: ");
            input = scanner.nextLine();
        return input;
    }

    public static String handleUserInput(String input) throws  NumNotInRangeException {
        int input_int = Integer.parseInt(input);

        String output;

        do {
            if (input_int < 2003 || input_int > 2016) {
                System.out.println(input_int + " is not in the range of 2003 - 2016");
                throw new NumNotInRangeException("Number not within range");
                //input_int = Integer.parseInt(getUserInput());
            }
        } while (input_int < 2003 || input_int > 2016);

        output = Integer.toString(input_int);

        return output;
    }
}
