package daks.tests;

import daks.pages.LoginPage;
import daks.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void loginTest(){

        ReusableMethods.getLogin();
        System.out.println("login Test");
    }
}
