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

    @FindBy(xpath = "(//button[@name='MENU_BUTTON'])[11]")
    public WebElement rundrufeButton;

    // Jeder Seite hat locater geändert -> /a[5]  bis 5 Seite und dann ändern nochmal. Das bedutet, dass bis /a[5] benutzt wird.
    //  rechte richtung =   > richtungstaste = a[6] ,    >I = EndeRichtungstaste = a[7]
    @FindBy(xpath = "//div[@class='WICTable_PAGINATORDIV GMDTable']/a[1]")
    public WebElement richtungstaste;

    @FindBy(xpath = "//div[@class='WICTable_PAGINATORDIV GMDTable']/a[1]")
    public WebElement richtungstaste1;
    @FindBy(xpath = "//div[@class='WICTable_PAGINATORDIV GMDTable']/a[2]")
    public WebElement richtungstaste2;
    @FindBy(xpath = "//div[@class='WICTable_PAGINATORDIV GMDTable']/a[3]")
    public WebElement richtungstaste3;
    @FindBy(xpath = "//div[@class='WICTable_PAGINATORDIV GMDTable']/a[4]")
    public WebElement richtungstaste4;
    @FindBy(xpath = "//div[@class='WICTable_PAGINATORDIV GMDTable']/a[5]")
    public WebElement richtungstaste5;
    @FindBy(xpath = "//div[@class='WICTable_PAGINATORDIV GMDTable']/a[6]")
    public WebElement richtungstaste6;
    @FindBy(xpath = "//div[@class='WICTable_PAGINATORDIV GMDTable']/a[7]")
    public WebElement richtungstaste7;

    @FindAll({@FindBy(xpath = "//div[@class='WICTable_PAGINATORDIV GMDTable']/a")})
    public List<WebElement> richtungstasteList;

    @FindAll({@FindBy(xpath = "(//table)[3]//tr")})
    public List<WebElement> tabelleRow;

    @FindBy(xpath = "(//table)[3]//tr[1]")
    public WebElement tabelleRow1;

    @FindBy(xpath = "(//table)[3]//tr[11]")
    public WebElement tabelleRow11;

    @FindAll({@FindBy(xpath = "(//table)[3]//tr/td")})
    public List<WebElement> tabelleColumn;

    @FindAll({@FindBy(xpath = "(//table)[3]//tr/td[1]")})
    public List<WebElement> tabelleNameOrt;

    @FindAll({@FindBy(xpath = "(//table)[3]//tr/td[3]")})
    public List<WebElement> tabelleEndgerätetd3;


    @FindBy(xpath = "(//table)[3]//tr[1]/td[2]")
    public WebElement tabelleRufnummer1;

    @FindBy(xpath = "(//table)[3]//tr[3]/td[2]")
    public WebElement tableRufnummer3;

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

    @FindBy(xpath = "(//input[@class='WICEdit SubsValue'])[8]")
    public WebElement mailAdresse;


    @FindBy(xpath = "(//input[@class='WICEdit SubsValue'])[9]")
    public WebElement rufnummer;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement wirdUberwacht;

    @FindBy(xpath = "//button[@class='WICButton WICMessageBox_ButtonOK']")
    public WebElement datensatzButton;

    @FindBy(xpath = "//div[@class='WICView_CLIENTAREA WICMessageBox_Text']/br")
    public WebElement datensatzText;

    @FindAll({@FindBy(xpath = "(//table)[3]//tr/td[2]")})
    public List<WebElement> tabelleRundrufeBezeichnung;

    @FindBy(xpath = "(//button[@class='WICButton ActionButton'])[1]")
    public WebElement sichernButton;

    @FindBy(xpath = "(//button[@class='WICButton ActionButton'])[2]")
    public WebElement abbrechenButton;

    @FindBy(xpath = "//button[@title='Zum nächsten Eintrag springen']")
    public WebElement nextButton;


    @FindBy(xpath = "//button[@class='WICButton ActionButton PREVBTN']")
    public WebElement previousButton;






}
