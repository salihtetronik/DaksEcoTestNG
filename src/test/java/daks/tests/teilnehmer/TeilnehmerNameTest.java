package daks.tests.teilnehmer;

import daks.pages.TeilnehmerPage;
import daks.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeilnehmerNameTest {

    TeilnehmerPage teilnehmer = new TeilnehmerPage();

    // Die administerten Daten können abspeichern.
    @Test
    public void teilnehmerNameSpeichernTest1() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(3000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).clear();
        teilnehmer.nameOrt.sendKeys("yxcvbnmasdfghfklouqwertzueopa2"); //String length = 30
        String value = teilnehmer.nameOrt.getAttribute("value");
        System.out.println("value= " + value);
        System.out.println("String length= " + value.length());
        Assert.assertEquals(value, "yxcvbnmasdfghfklouqwertzueopa2");
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton).click();
        //  Erwartetes  Ergebnis ist True(neuButton soll isDisplayed sein), Aktueles Ergebnis  auch True. Test ist Erfolgreich
        Assert.assertTrue(teilnehmer.neuButton.isDisplayed());
    }


    //Längenbegrenzungen wurden gemessen
    @Test
    public void teilnehmerNameSpeichernTest2() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(3000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).clear();
        teilnehmer.nameOrt.sendKeys("QWERTZUIOPÜASDFGHJKLÖÄYXCVBNM123456"); // String length = 35
        String value = teilnehmer.nameOrt.getAttribute("value");

        if (value.length() > 30) {
            System.out.println("String length ist Groß als 30");
        } else {
            System.out.println("value= " + value + "\n" + "String length ist klein oder gleich 30");
        }

        System.out.println("String length= " + value.length());
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);

        //  Erwartetes  Ergebnis ist False( sichernButton soll  deaktive sein), Aktueles Ergebnis True.
        Assert.assertFalse(teilnehmer.sichernButton.isEnabled());
    }


    @Test
    public void teilnehmerNameSpeichernTest3() {

        ReusableMethods.getLogin();

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(3000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).clear();
        teilnehmer.nameOrt.sendKeys("z");
        String value = teilnehmer.nameOrt.getAttribute("value");
        System.out.println("value= " + value);
        System.out.println("String length= " + value.length());
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton);
        //  Erwartetes  Ergebnis ist True(neuButton soll Aktive sein), Aktueles Ergebnis  auch True. Test ist Erfolgreich
        Assert.assertTrue(teilnehmer.neuButton.isDisplayed());
    }


    @Test
    public void teilnehmerNameSpeichernTest4() {

        ReusableMethods.getLogin();
        ReusableMethods.sleep(3000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).clear();
        teilnehmer.nameOrt.sendKeys("");
        String value = teilnehmer.nameOrt.getAttribute("value");
        System.out.println("value= " + value);
        System.out.println("String length= " + value.length());
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);
        //  Erwartetes  Ergebnis ist False(sichernButton soll deaktive sein), Aktueles Ergebnis  auch False. Test ist Erfolgreich
        Assert.assertFalse(teilnehmer.sichernButton.isEnabled());
    }


}
