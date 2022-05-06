package daks.pages;

import daks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KonferenzenPage {

    public KonferenzenPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@class='WICButton CWebMainMenuButton'][11]")
    public WebElement konferenzenButton;

    @FindBy(xpath = "//div[@class='WICButton_TEXT ActionButton'][1]")
    public WebElement sichernButton;

    @FindBy(xpath = "//div[@class='WICButton_TEXT ActionButton'][2]")
    public WebElement abbrechenButton;

// tabelle3

    @FindBy(xpath = "(//table)[3]//tr[1]")
    public WebElement tabelleBezeichnung1;

    @FindBy(xpath = "(//table)[3]//tr[2]")
    public WebElement tabelleBezeichnung2;

    @FindBy(xpath = "(//table)[3]//tr[3]")
    public WebElement tabelleBezeichnung3;

    @FindBy(xpath = "(//table)[3]//tr[4]")
    public WebElement tabelleBezeichnung4;

    @FindBy(xpath = "(//table)[3]//tr[5]")
    public WebElement tabelleBezeichnung5;

    @FindBy(xpath = "(//table)[3]//tr[6]")
    public WebElement tabelleBezeichnung6;

    @FindBy(xpath = "(//table)[3]//tr[7]")
    public WebElement tabelleBezeichnung7;

    @FindBy(xpath = "(//table)[3]//tr[8]")
    public WebElement tabelleBezeichnung8;

    @FindBy(xpath = "(//table)[3]//tr[9]")
    public WebElement tabelleBezeichnung9;

    @FindBy(xpath = "(//table)[3]//tr[10]")
    public WebElement tabelleBezeichnung10;


    @FindBy(xpath = "//input[@class='WICEdit ConferenceEdit'][1]")
    public WebElement bezeichnung;

    @FindBy(xpath = "//input[@class='WICEdit ConferenceEdit'][2]")
    public WebElement startId;

    @FindBy(xpath = "//input[@class='WICEdit ConferenceEdit'][3]")
    public WebElement eintrittsId;

    @FindBy(xpath = "//input[@class='WICEdit ConferenceEdit'][4]")
    public WebElement maxWartezeitAufStart;

    @FindBy(xpath = "//input[@class='WICEdit ConferenceEdit'][5]")
    public WebElement maxWartezeitAufGesprach;

    @FindBy(xpath = "//input[@class='WICEdit ConferenceEdit'][6]")
    public WebElement maxKonferenzdauer;

    @FindBy(xpath = "//input[@class='WICEdit ConferenceEdit'][7]")
    public WebElement maxInaktivzeit;


    @FindBy(xpath = "//select[@class='WICSelect ConferenceSelect'][1]")
    public WebElement startansage;

    @FindBy(xpath = "//select[@class='WICSelect ConferenceSelect'][2]")
    public WebElement eintrittsansage;

    @FindBy(xpath = "//select[@class='WICSelect ConferenceSelect'][3]")
    public WebElement anwahlansage;

    @FindBy(xpath = "//select[@class='WICSelect ConferenceSelect'][4]")
    public WebElement maxEinwahlTeilnehmer;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement mfvWandlungInitiator;








    // tabella2
/*
    @FindBy(xpath = "(//table)[2]//tr/th[1]")
    public WebElement bezeichnung;

    @FindBy(xpath = "(//table)[2]//tr/th[2]")
    public WebElement startId;

    @FindBy(xpath = "(//table)[2]//tr/th[3]")
    public WebElement eintrittsId;

    @FindBy(xpath = "(//table)[2]//tr/th[4]")
    public WebElement startansage;

    @FindBy(xpath = "(//table)[2]//tr/th[5]")
    public WebElement eintrittsAnsage;

    @FindBy(xpath = "(//table)[2]//tr/th[6]")
    public WebElement anwahlAnsage;


    @FindBy(xpath = "(//table)[2]//tr/th[7]")
    public WebElement maxWarteZeitAufStart;

    @FindBy(xpath = "(//table)[2]//tr/th[8]")
    public WebElement maxWarteZeitAufGesprach;

    @FindBy(xpath = "(//table)[2]//tr/th[9]")
    public WebElement maxKonferenzDauer;

    @FindBy(xpath = "(//table)[2]//tr/th[10]")
    public WebElement maxInaktivzeit;

    @FindBy(xpath = "(//table)[2]//tr/th[11]")
    public WebElement maxEinwahlTeilnehmer;

    @FindBy(xpath = "(//table)[2]//tr/th[12]")
    public WebElement mfvWandlung;

 */

}
