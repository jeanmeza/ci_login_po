package tests;

import POs.LoginFormPO;
import POs.LoginSuccessPO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class LoginTest extends DriverLifeCycle {

    private LoginFormPO login;
    private LoginSuccessPO loginSuccess;

    @Test
    public void testLoginOk() throws InterruptedException {
        login = new LoginFormPO(driver);
        login.with("user", "user");
        System.out.println(driver.getCurrentUrl());
        // we go to the login-success page
        loginSuccess = new LoginSuccessPO(driver);
        Thread.sleep(1000L);
        assertTrue(loginSuccess.successBoxIsPresent());
    }

    @Test
    public void testLoginNotOk() {
        login = new LoginFormPO(driver);
        login.with("user", "error");
        System.out.println(driver.getCurrentUrl());
        // we remain in the login page
        assertTrue(login.invalidBoxisPresent());
    }

    @ParameterizedTest
    @CsvSource({
            "invalid,invalid",  // invalid credentials
            "user,''",  // empty password
            "'',user",  // empty username
            "'',''",  // empty credentials
            "user,invalidPassword",  // invalid password
            "invalidUser,user"  //  invalid username
    })
    public void testLoginWithInvalidCredentials(String username, String password) {
        login = new LoginFormPO(driver);
        login.with(username, password);
        System.out.println(driver.getCurrentUrl());
        assertTrue(login.invalidBoxisPresent());
    }

}
