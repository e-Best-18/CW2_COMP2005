import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;

public class HandleJSONTest {
    HandleJSON handle;

    @Before
    public void setUp() throws Exception {
        handle = new HandleJSON();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testValidURL() throws MalformedURLException, CustomException {

        URL url = handle.getURL(HandleJSON.url_string);
        String url_as_string = url.toString();

        assertEquals(url_as_string, ("http://intelligent-social-robots-ws.com/airports"));
    }

    @Test
    public void testInvalidURL() throws MalformedURLException, CustomException {

        assertThrows(CustomException.class, () -> {
            handle.getURL("hello_world");
        });
        assertThrows(CustomException.class, () -> {
            handle.getURL("");
        });
    }

    @Test
    public void testAirportsEndpoint() throws MalformedURLException, CustomException {
        URL url = new URL("http://intelligent-social-robots-ws.com/airpo");
        String url_string = url.toString();

        assertThrows(CustomException.class, () -> {
            handle.checkEndpoint(url_string);
        });
    }
    //not found exception

    //test the sections are airport, time, statistics { carriers, flights, minutes delayed}


}