package daks.pages;

import daks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TeilnehmerPage {

    public TeilnehmerPage() {

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "(//button[@name='MENU_BUTTON'])[10]")
    public WebElement teilnehmerButton;


    // Jeder Seite hat locater geändert -> /a[5]  bis 5 Seite und dann ändern nochmal. Das bedutet, dass bis /a[5] benutzt wird.
    //  rechte richtung =   > richtungstaste = a[6] ,    >I = EndeRichtungstaste = a[7]
    @FindBy(xpath = "//div[@class='WICTable_PAGINATORDIV GMDTable']/a[5]")
    public WebElement richtungstaste;

    @FindAll({@FindBy(xpath = "(//table)[3]//tr")})
    public List<WebElement> tabelleRow;

    @FindBy(xpath = "(//table)[3]//tr[1]/td[2]")
    public WebElement tabelleRufnummer1;

    @FindBy(xpath = "(//table)[3]//tr[197]/td[2]")
    public WebElement tabelleRufnummer197;

    @FindBy(xpath = "(//table)[3]//tr[198]/td[2]")
    public WebElement tableRufnummer198;

    @FindBy(xpath = "(//button[@class='WICButton ActionButton'])[1]")
    public WebElement bearbeitenButton;

    @FindBy(xpath = "(//button[@class='WICButton ActionButton'])[2]")
    public WebElement neuButton;

    @FindBy(xpath = "//div[@class='WICButton_TEXT WICMessageBox_ButtonYes']")
    public WebElement jaButton;

    @FindBy(xpath = "(//button[@class='WICButton ActionButton'])[3]")
    public WebElement kopierenButton;

    @FindBy(xpath = "(//button[@class='WICButton ActionButton'])[4]")
    public WebElement loschenButton;

    @FindBy(xpath = "(//input[@class='WICEdit SubsValue'])[1]")
    public WebElement nameOrt;

    @FindBy(xpath = "(//input[@class='WICEdit SubsValue'])[2]")
    public WebElement vornameQualifikation;

    @FindBy(xpath = "(//input[@class='WICEdit SubsValue'])[3]")
    public WebElement kurzbeschreibung;

    @FindBy(xpath = "(//input[@class='WICEdit SubsValue'])[4]")
    public WebElement benutzername;

    @FindBy(xpath = "(//input[@class='WICEdit SubsValue'])[5]")
    public WebElement passwort;

    @FindBy(xpath = "(//input[@class='WICEdit SubsValue'])[6]")
    public WebElement passwortWiederholung;

    @FindBy(xpath = "(//input[@class='WICEdit SubsValue'])[9]")
    public WebElement rufnummer;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement wirdUberwacht;


    @FindBy(xpath = "(//button[@class='WICButton ActionButton'])[1]")
    public WebElement sichernButton;

    @FindBy(xpath = "(//td[@align='left'])[15]")
    public WebElement td;
}
