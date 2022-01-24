package daks.utilities;

import daks.pages.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;


public class ReusableMethods {

  static WebDriverWait wait =null;


    public static void getLogin(){

        Driver.getDriver().get("http://127.0.0.1");

        if(ReusableMethods.isAlertReady()){

            Driver.getDriver().switchTo().alert().accept();

        }else
            System.out.println("kein alert");

        LoginPage login = new LoginPage();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        //bu olmadan program nasil hatasiz calisiyor
        //  bu yokken zaten calisiyordu. acaba bunu ekleyerek sleep siz calisir mi diye eklendi. basarisiz
        //  bu eklendi ve sleepler silindikten yine ayni hata olan stale element hatasi vermeye basladi


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


    public static void sleep(int miliseconds){

        try {
            Thread.sleep(miliseconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }





    public static List<List<String>> getListData(String path, String sheetName, int columnCount) {

        List<List<String>> zuruckList= new ArrayList<>();

        Workbook workbook= null;

        try {
            FileInputStream inputStream= new FileInputStream(path);
            workbook=WorkbookFactory.create(inputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount=sheet.getPhysicalNumberOfRows();

        for(int i=0;i<rowCount;i++){

            List<String> rowList= new ArrayList<>();
            Row row=sheet.getRow(i);

            int cellCount = row.getPhysicalNumberOfCells();
            if(columnCount>cellCount) columnCount=cellCount;

            for(int j=0;j<columnCount;j++){

                rowList.add(row.getCell(j).toString());

            }
            zuruckList.add(rowList);
        }
        return zuruckList;
    }




    public static void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





    public static WebElement getVisibilityOfWait(WebElement element){


        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(element));

        return element;

    }


    public static void waitUntilVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }



    public static WebElement waitUntilClickable(WebElement element) {
        wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }




    public static List<WebElement> waitVisibleListAllElement(List<WebElement> elementList) {

        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        return elementList;
    }




    public static void clickFunction(WebElement element){
        try {
            scrollToElement(element);
            waitUntilVisible(element);
            waitUntilClickable(element);
            element.click();
        }catch (StaleElementReferenceException e){
            System.out.println(e.getMessage());
            clickFunction(element);
            element.click();
        }
    }

    public static boolean isDisplayed(WebElement element) {
        try {
            if(element.isDisplayed())
                return element.isDisplayed();
        }catch (NoSuchElementException ex) {
            return false;
        }
        return false;
    }



    public static void clickWithJS(WebElement element) {
        scrollToElement(element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }




    public static void clickTo(WebElement locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        try {
            element.click();
        } catch (StaleElementReferenceException st){
            wait.until(ExpectedConditions.refreshed( ExpectedConditions.elementToBeClickable(element))).click();
        } catch (ElementClickInterceptedException e){
            clickWithJS(element);
        }
    }
}
