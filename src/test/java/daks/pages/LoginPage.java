package daks.pages;

import daks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LoginPage {

    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='user']")
    public WebElement userName;


    @FindBy(xpath = "//input[@name='password']")

    public WebElement password;

    @FindBy(xpath = "//div[@class='loginButton de_DE']")

    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='WICButton_TEXT ']")

    public WebElement abmelden;

    @FindBy(xpath = "//div[@class='errorMesage']")

    public WebElement errorMesage;


    public static void main(String[] args) {

        ArrayList isimler=new ArrayList();

        isimler.add("Salih");
        isimler.add("ali");
        isimler.add("veli");
        isimler.add("deli");

        System.out.println(isimler);






    }


}