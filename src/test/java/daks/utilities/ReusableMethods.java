package daks.utilities;

import daks.pages.LoginPage;

public class ReusableMethods {

    public static void getLogin(){

        Driver.getDriver().get("http://127.0.0.1");

        LoginPage login = new LoginPage();

        if(ReusableMethods.isAlertReady()){

            Driver.getDriver().switchTo().alert().accept();

        }else
            System.out.println("kein alert");

        login.userName.sendKeys("sysadm");
        login.password.sendKeys("sysadm");
        login.loginButton.click();
    }

    public static boolean isAlertReady(){
       try {
           Driver.getDriver().switchTo().alert();
       }catch (Exception e){
           return false;
       }
       return true;

    }
}
