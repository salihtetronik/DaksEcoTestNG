package daks.tests.teilnehmer;

import daks.pages.TeilnehmerPage;
import daks.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeilnehmerNameTest {

    TeilnehmerPage teilnehmer = new TeilnehmerPage();

    @Test
    public void teilnehmerNameSpeichernTest1(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.scrollToElement(teilnehmer.tableRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).clear();
        teilnehmer.nameOrt.sendKeys("OM!-AXI$/Targät 5940_Ü'ÖÄ*öü#H");
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton).click();
        Assert.assertTrue(teilnehmer.bearbeitenButton.isEnabled());
    }

    @Test
    public void teilnehmerNameSpeichernTest2(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.scrollToElement(teilnehmer.tableRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).clear();
        teilnehmer.nameOrt.sendKeys("QWERTZUIOPÜASDFGHJKLÖÄYXCVBNM123456");
        String value = teilnehmer.nameOrt.getAttribute("value");
        System.out.println(value);
        System.out.println(value.length());
    }


    @Test
    public void teilnehmerNameSpeichernTest3(){

        ReusableMethods.getLogin();

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.scrollToElement(teilnehmer.tableRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).clear();
        teilnehmer.nameOrt.sendKeys("S");
        String value = teilnehmer.nameOrt.getAttribute("value");
        System.out.println(value);
        System.out.println(value.length());
    }


    @Test
    public void teilnehmerNameSpeichernTest4(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.scrollToElement(teilnehmer.tableRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).clear();
        teilnehmer.nameOrt.sendKeys("");
        String value = teilnehmer.nameOrt.getAttribute("value");
        System.out.println(value);
        System.out.println(value.length());
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);
        Assert.assertFalse(teilnehmer.sichernButton.isEnabled());
    }
}
