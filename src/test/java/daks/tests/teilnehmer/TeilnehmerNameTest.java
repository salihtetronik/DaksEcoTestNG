package daks.tests.teilnehmer;

import daks.pages.TeilnehmerPage;
import daks.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeilnehmerNameTest {

    TeilnehmerPage teilnehmer = new TeilnehmerPage();

    // Die administerten Daten können abspeichern.
    @Test
    public void teilnehmerNameSpeichernTest1(){

        ReusableMethods.getLogin();
        ReusableMethods.waitUntilClickable(teilnehmer.teilnehmerButton).click();
       // ReusableMethods.waitForPageToLoad(20);
        ReusableMethods.sleep(6000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
       // ReusableMethods.sleep(6000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.tabelleRufnummer1);
        ReusableMethods.scrollToElement(teilnehmer.tabelleRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tabelleRufnummer197);
       // ReusableMethods.sleep(1000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).clear();
      //  ReusableMethods.sleep(1000);
        teilnehmer.nameOrt.sendKeys("SP!-AXI$/Targät Ü'ÖÄ*öü#H_5940");
        String value= teilnehmer.nameOrt.getAttribute("value");
        Assert.assertEquals(value,"SP!-AXI$/Targät Ü'ÖÄ*öü#H_5940");
        System.out.println(value);
        System.out.println(value.length());
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton).click();
        //  Erwartetes  Ergebnis ist True(bearbeitenButton soll isDisplayed sein), Aktueles Ergebnis  auch True. Test ist Erfolgreich
        Assert.assertTrue(teilnehmer.bearbeitenButton.isEnabled());
    }


    //Längenbegrenzungen wurden gemessen
    @Test
    public void teilnehmerNameSpeichernTest2(){

        ReusableMethods.getLogin();
        ReusableMethods.waitUntilClickable(teilnehmer.teilnehmerButton).click();
      //  ReusableMethods.waitForPageToLoad(10);
        ReusableMethods.sleep(6000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.scrollToElement(teilnehmer.tabelleRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tabelleRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).clear();
        ReusableMethods.sleep(1000);
        teilnehmer.nameOrt.sendKeys("QWERTZUIOPÜASDFGHJKLÖÄYXCVBNM123456"); // String length = 35
        String value = teilnehmer.nameOrt.getAttribute("value");

        if(value.length()<=30){
            System.out.println(value);
        }else{
            System.out.println("String length ist Groß als 30");
        }
        System.out.println(value.length());

        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton).click();

        //  Erwartetes  Ergebnis ist True(bearbeitenButton soll isDisplayed sein), Aktueles Ergebnis  auch True. Test ist Erfolgreich
        Assert.assertTrue(teilnehmer.bearbeitenButton.isDisplayed());
    }


    @Test
    public void teilnehmerNameSpeichernTest3(){

        ReusableMethods.getLogin();

        ReusableMethods.waitUntilClickable(teilnehmer.teilnehmerButton).click();
       // ReusableMethods.waitForPageToLoad(10);
        ReusableMethods.sleep(6000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.scrollToElement(teilnehmer.tabelleRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tabelleRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).clear();
        teilnehmer.nameOrt.sendKeys("S");
        String value = teilnehmer.nameOrt.getAttribute("value");
        System.out.println(value);
        System.out.println(value.length());
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton).click();
        //  Erwartetes  Ergebnis ist True(bearbeitenButton soll isDisplayed sein), Aktueles Ergebnis  auch True. Test ist Erfolgreich
        Assert.assertTrue(teilnehmer.bearbeitenButton.isDisplayed());
    }


    @Test
    public void teilnehmerNameSpeichernTest4(){

        ReusableMethods.getLogin();
        ReusableMethods.waitUntilClickable(teilnehmer.teilnehmerButton).click();
       // ReusableMethods.waitForPageToLoad(10);
        ReusableMethods.sleep(6000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.scrollToElement(teilnehmer.tabelleRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tabelleRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).clear();
        teilnehmer.nameOrt.sendKeys("");
        String value = teilnehmer.nameOrt.getAttribute("value");
        System.out.println(value);
        System.out.println(value.length());
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);
        //  Erwartetes  Ergebnis ist False(sichernButton soll deaktive sein), Aktueles Ergebnis  auch False. Test ist Erfolgreich
        Assert.assertFalse(teilnehmer.sichernButton.isEnabled());
    }
}
