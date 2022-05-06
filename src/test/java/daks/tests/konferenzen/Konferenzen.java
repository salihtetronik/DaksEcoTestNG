package daks.tests.konferenzen;

import daks.pages.KonferenzenPage;
import daks.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Konferenzen {

    KonferenzenPage konferenzen = new KonferenzenPage();

    @BeforeClass
    void beforeclass() {

        ReusableMethods.getLogin();
    }

    @Test
    public void konferennz2_1() {

        ReusableMethods.getVisibilityOfWait(konferenzen.konferenzenButton).click();
        ReusableMethods.getVisibilityOfWait(konferenzen.tabelleBezeichnung1);
        ReusableMethods.doubleClick(konferenzen.tabelleBezeichnung1);
        ReusableMethods.getVisibilityOfWait(konferenzen.startId).clear();
        konferenzen.startId.sendKeys("1239");
        String value = konferenzen.startId.getAttribute("value");
        System.out.println(value);
        konferenzen.sichernButton.click();
    }

    @Test
    public void konferenz2_selectStartansage() {

        ReusableMethods.getVisibilityOfWait(konferenzen.konferenzenButton).click();
        ReusableMethods.getVisibilityOfWait(konferenzen.tabelleBezeichnung1);
        ReusableMethods.doubleClick(konferenzen.tabelleBezeichnung1);
        ReusableMethods.getVisibilityOfWait(konferenzen.startansage);
       // Select stansage = new Select(konferenzen.startansage);
       // stansage.selectByIndex((int) (Math.random() * stansage.getOptions().size()));
        ReusableMethods.selectMethod(konferenzen.startansage);
        konferenzen.sichernButton.click();

    }

    @Test
    public void konferenz2_selectEintrittsansage(){

        ReusableMethods.getVisibilityOfWait(konferenzen.konferenzenButton).click();
        ReusableMethods.getVisibilityOfWait(konferenzen.tabelleBezeichnung1);
        ReusableMethods.doubleClick(konferenzen.tabelleBezeichnung1);
        ReusableMethods.getVisibilityOfWait(konferenzen.eintrittsansage);
        ReusableMethods.selectMethod(konferenzen.eintrittsansage);
        konferenzen.sichernButton.click();
    }


    @Test
    public void konferenz2_initiator(){

        ReusableMethods.getVisibilityOfWait(konferenzen.konferenzenButton).click();
        ReusableMethods.getVisibilityOfWait(konferenzen.tabelleBezeichnung1);
        ReusableMethods.doubleClick(konferenzen.tabelleBezeichnung1);
        ReusableMethods.getVisibilityOfWait(konferenzen.mfvWandlungInitiator).click();
        konferenzen.sichernButton.click();
    }

























}
