package daks.tests.teilnehmer;

import daks.pages.TeilnehmerPage;
import daks.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Scanner;

public class MailAdresseTest {


    TeilnehmerPage teilnehmer = new TeilnehmerPage();


    @BeforeMethod
    void beforeMethod() {

        ReusableMethods.getLogin();
    }


    @Test
    public void mailAdresseTest1() {

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(4000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste);
        ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.mailAdresse).clear();
        teilnehmer.mailAdresse.sendKeys("salihtetronik.com");
        String value = teilnehmer.mailAdresse.getAttribute("value");
        System.out.println(value);

        if (value.contains("@")) {
            System.out.println("Gratuliere! Value enthält @ zeichen.");
        } else {
            System.out.println("Sie sollen @ zeichen eingeben!");
        }
        // @ zeichen soll eingegeben werden
        Assert.assertTrue(value.contains("@"));
    }


    @Test
    public void mailAdresseTest2() {

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(4000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer3);
        ReusableMethods.getVisibilityOfWait(teilnehmer.mailAdresse).clear();
        teilnehmer.mailAdresse.sendKeys("salih@tetronik");
        String value = teilnehmer.mailAdresse.getAttribute("value");
        System.out.println(value);

        if (value.contains(".com")) {
            System.out.println("Gratuliere! Value enthält .com zeichen");
        } else {
            System.out.println("Sie sollen .com zeichen eingeben!");
        }
        //.com zeichen soll zum Felder eingegeben werden
        Assert.assertTrue(value.contains(".com"));
    }


    @Test
    public void mailAdresseTest3() {

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(4000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer3);
        ReusableMethods.getVisibilityOfWait(teilnehmer.mailAdresse).clear();
        teilnehmer.mailAdresse.sendKeys("salih@gmail.com");
        String value = teilnehmer.mailAdresse.getAttribute("value");
        System.out.println(value);

        if (value.equals("salih@gmail.com")) {
            System.out.println("Gratuliere! Sie haben eine richtige E-Mail eingegeben.");
        } else {
            System.out.println("Sie sollen eine richtige E-Mail eingeben.");
        }

        Assert.assertEquals(value, "salih@gmail.com");
    }


    @Test
    public void mailAdresseTest4() {

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(4000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste);
        ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.mailAdresse).clear();
        teilnehmer.mailAdresse.sendKeys("salih@gmail.com");
        String value = teilnehmer.mailAdresse.getAttribute("value");
        System.out.println(value);
        int index = value.indexOf("@");
        String gmail = value.substring(index + 1);
        System.out.println(gmail);
        String nameMail = value.substring(0, index);
        System.out.println(nameMail);

        if (value.contains("@") == false) {
            System.out.println("Sie sollen @ zeichen eingeben!");
        }
        if (gmail.equals("gmail.com") == false) {
            System.out.println("Gmail Konto ist falsch! Sie sollen ein richtiges Konto eingeben.");
        }
        if (nameMail.equals("salih") == false) {
            System.out.println("Name der Mail ist falsch! Sie sollen ein richtigen Name eingeben.");
        }
        if (value.contains("@") && gmail.equals("gmail.com") && nameMail.equals("salih")) {
            System.out.println("Gratuliere! Sie haben eine richtige E-Mail eingegeben.");
        }
        Assert.assertTrue(value.contains("@") && gmail.equals("gmail.com") && nameMail.equals("salih"));
    }




    @Test
    public void mailSuchenInDerTabelleTest() {

        String mailName = "salih@tetronik.com";
        boolean gesuchtesWort = true;

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(4000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste);
        ReusableMethods.doubleClick(teilnehmer.tabelleRow1);
        ReusableMethods.getVisibilityOfWait(teilnehmer.mailAdresse);

        for (int i = 0; i < 1000; i++) {
            ReusableMethods.getVisibilityOfWait(teilnehmer.mailAdresse);
            String valueMail = teilnehmer.mailAdresse.getAttribute("value");
            if (valueMail.contains(mailName)) {
                System.out.println(i + 1 + " , " + valueMail + " steht in der Tabelle.");
               // Assert.assertEquals(value, name);
                String valueNameOrt = teilnehmer.nameOrt.getAttribute("value");
                System.out.println("NameOrt = " + valueNameOrt);
                gesuchtesWort = false;
                break;
            } else {
                ReusableMethods.getVisibilityOfWait(teilnehmer.nextButton).click();
            }
        }
        if (gesuchtesWort) {
            System.out.println(mailName + " wurde nicht gefunden");
        }
    }










}