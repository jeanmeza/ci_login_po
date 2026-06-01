package tests;

import POs.LoginFormPO;
import POs.LoginSuccessPO;
import org.junit.jupiter.api.Test;

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

    @Test
    public void testLoginWithEmptyFields() {
        login = new LoginFormPO(driver);
        login.with("", "");
        System.out.println(driver.getCurrentUrl());
        // we remain in the login page
        assertTrue(login.invalidBoxisPresent());
    }

}
