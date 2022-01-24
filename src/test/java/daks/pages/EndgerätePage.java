package daks.pages;

import daks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EndgerätePage {

    public EndgerätePage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }




    @FindBy(xpath = "(//button[@name='MENU_BUTTON'])[9]")
    public WebElement endgeräteButton;

    @FindAll
            ({@FindBy(xpath = "(//table)[3]//tr/td[4]")})
    public WebElement tabelletd4;


    @FindBy(xpath = "(//table)[2]//tr/th[4]")
    public WebElement teilnehmerReferenz;
}
