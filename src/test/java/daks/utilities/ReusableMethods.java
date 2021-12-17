package daks.utilities;

import daks.pages.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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



    public static WebElement getVisibilityOfWait(WebElement element){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;

    }


    public static void scrollToElement(WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",element);

    }



    public static void doubleClick(WebElement element){

        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }




    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }




}
