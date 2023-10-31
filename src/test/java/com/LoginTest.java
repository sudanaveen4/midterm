import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    @Test
    public void testLoginWithValidCredentials() {
        boolean loggedIn = Login.login("ram", "3025");

        assertTrue(loggedIn);
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        boolean loggedIn = Login.login("suda", "incorrectPassword");

        assertFalse(loggedIn);
    }
}