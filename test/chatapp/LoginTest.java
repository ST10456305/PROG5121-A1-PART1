// File: LoginTest.java
// Location: test/chatApp/LoginTest.java
package chatapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void testValidRegistration() {
        Login login = new Login();
        String result = login.registerUser("cvh_", "Pass123!", "+27831234567");
        assertEquals("User registered successfully.", result);
    }

    @Test
    public void testInvalidUsername() {
        Login login = new Login();
        String result = login.registerUser("cvhuser", "Pass123!", "+27831234567");
        assertTrue(result.contains("Username is not correctly formatted"));
    }

    @Test
    public void testInvalidPassword() {
        Login login = new Login();
        String result = login.registerUser("cvh_", "password", "+27831234567");
        assertTrue(result.contains("Password is not correctly formatted"));
    }

    @Test
    public void testInvalidPhone() {
        Login login = new Login();
        String result = login.registerUser("cvh_", "Pass123!", "0831234567");
        assertTrue(result.contains("Cell number is incorrectly formatted"));
    }

    @Test
    public void testLoginSuccess() {
        Login login = new Login();
        login.registerUser("cvh_", "Pass123!", "+27831234567");
        assertTrue(login.loginUser("cvh_", "Pass123!"));
    }

    @Test
    public void testLoginFail() {
        Login login = new Login();
        login.registerUser("cvh_", "Pass123!", "+27831234567");
        assertFalse(login.loginUser("cvh_", "wrongPass"));
    }
}