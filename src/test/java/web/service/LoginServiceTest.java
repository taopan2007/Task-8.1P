package web.service;

import static org.junit.Assert.*;
import org.junit.Test;
import web.service.LoginService;

public class LoginServiceTest {

    @Test
    public void testLoginSuccess() {
        LoginService loginService = new LoginService();
        boolean result = loginService.login("admin", "admin", "1990-01-01");
        assertTrue(result);
    }

    @Test
    public void testLoginFailureInvalidDob() {
        LoginService loginService = new LoginService();
        boolean result = loginService.login("admin", "admin", "2000-01-01");
        assertFalse(result);
    }

    @Test
    public void testLoginFailureInvalidUsername() {
        LoginService loginService = new LoginService();
        boolean result = loginService.login("user", "admin", "1990-01-01");
        assertFalse(result);
    }

    @Test
    public void testLoginFailureInvalidPassword() {
        LoginService loginService = new LoginService();
        boolean result = loginService.login("admin", "password", "1990-01-01");
        assertFalse(result);
    }

    @Test
    public void testLoginFailureNullValues() {
        LoginService loginService = new LoginService();
        boolean result = loginService.login(null, null, null);
        assertFalse(result);
    }
}
