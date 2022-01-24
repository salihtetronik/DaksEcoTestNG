package daks.tests.teilnehmer;

import daks.pages.TeilnehmerPage;
import daks.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MailAdresseTest {

    TeilnehmerPage teilnehmer = new TeilnehmerPage();


    @Test
    public void mailAdresseTest1() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer3);
        ReusableMethods.getVisibilityOfWait(teilnehmer.mailAdresse).clear();
        teilnehmer.mailAdresse.sendKeys("salih@tetronik.com");
        String value = teilnehmer.mailAdresse.getAttribute("value");
        System.out.println(value);

        if (value.equals("salih@tetronik.com")) {
            System.out.println("Gratuliere! Sie haben eine richtige E-Mail eingegeben.");
        } else {
            System.out.println(" Sie sollen eine richtige E-Mail eingeben.");
        }

        Assert.assertEquals(value, "salih@tetronik.com");



    }

    @Test
    public void mailAdresseTest2() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste);
        //ReusableMethods.sleep(5000);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer3);
       // ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.mailAdresse).clear();
        teilnehmer.mailAdresse.sendKeys("salihtetronik.com");
        String value = teilnehmer.mailAdresse.getAttribute("value");
        System.out.println(value);

        if (value.contains("@")) {
            System.out.println("Gratuliere! Value enthält @ zeichen.");
        } else {
            System.out.println(" Sie sollen @ zeichen eingegeben werden");
        }
        Assert.assertTrue(value.contains("@"));
    }




    @Test
    public void mailAdresseTest3() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        // ReusableMethods.waitForPageToLoad(10);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer3);
        ReusableMethods.getVisibilityOfWait(teilnehmer.mailAdresse).clear();
        teilnehmer.mailAdresse.sendKeys("salih@tetronik");
        String value = teilnehmer.mailAdresse.getAttribute("value");
        System.out.println(value);

        if (value.contains(".com")) {
            System.out.println("Gratuliere! Value enthält .com zeichen");
        } else {
            System.out.println(" Sie sollen .com zeichen eingegeben werden");
        }

        Assert.assertTrue(value.contains(".com"));
    }



}
