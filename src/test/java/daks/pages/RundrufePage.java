package daks.pages;

import daks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.PortUnreachableException;

public class RundrufePage {

    public RundrufePage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }




    @FindBy(xpath = "//button[@class='WICButton CWebMainMenuButton'][10]")
    public WebElement rundrufButton;

    @FindBy(xpath = "(//table)[3]//tr[1]")
    public WebElement tr1;

    @FindBy(xpath = "(//table)[2]//tr/td[1]")
    public WebElement gruppenspezischeEinstellungen;

    @FindBy(xpath = "(//table)[2]//tr/td[1]")
    public WebElement rundrufmitglieder;

    @FindBy(xpath = "(//table)[2]//tr/td[1]")
    public WebElement funktionsdruppen;

    @FindBy(xpath = "//input[@class='WICEdit BdcValueID'][1]")
    public WebElement id;

    @FindBy(xpath = "//input[@class='WICEdit BdcValueName'][1]")
    public WebElement bezeichnung;

    @FindBy(xpath = "//button[@class='WICButton ActionButton'][1]")
    public WebElement sichernButton;


}
