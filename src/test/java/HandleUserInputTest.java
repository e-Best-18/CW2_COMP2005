import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HandleUserInputTest {

    HandleUserInput handle;

    @Before
    public void setUp() {
        handle = new HandleUserInput();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testHandleUserInputShouldBeWithinRange() throws CustomException, NumberFormatException {

        String correct_val_1 = handle.handleUserInput("2003");
        String correct_val_2 = handle.handleUserInput("2016");

        //assert valid results are valid
        assertTrue(2003 <= Integer.parseInt(correct_val_1) && Integer.parseInt(correct_val_1) <= 2016);
        assertTrue(2003 <= Integer.parseInt(correct_val_2) && Integer.parseInt(correct_val_2) <= 2016);

    }

    @Test
    public void testHandleUserInputOutsideRangeShouldThrowException() throws CustomException, NumberFormatException{
        assertThrows(CustomException.class, () -> {
            handle.handleUserInput("3");
        });
        assertThrows(CustomException.class, () -> {
            handle.handleUserInput("300000");
        });
    }

    @Test
    public void testHandleUserInputNoInputShouldThrowException() {
        assertThrows(NumberFormatException.class, () -> {
            handle.handleUserInput("");
        });
    }

    @Test
    public void testHandleUserInputDoesNotChangeTest() throws CustomException {
        String actual_value = handle.handleUserInput("2003");
        Assert.assertEquals(2003, Integer.parseInt(actual_value));
    }

}