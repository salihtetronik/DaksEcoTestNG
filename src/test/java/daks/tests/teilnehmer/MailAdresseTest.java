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
        teilnehmer.mailAdresse.sendKeys("salih@@tetronik.com");
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
        teilnehmer.mailAdresse.sendKeys("salih@t-online.de");
        String value = teilnehmer.mailAdresse.getAttribute("value");
        System.out.println(value);

        if (value.equals("salih@t-online.de")) {
            System.out.println("Gratuliere! Sie haben eine richtige E-Mail eingegeben.");
        } else {
            System.out.println("Sie sollen eine richtige E-Mail eingeben.");
        }

        Assert.assertEquals(value, "salih@t-online.de");
    }




    @Test
    public void mailAdresseTest4() {

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(4000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste);
        ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.mailAdresse).clear();
        teilnehmer.mailAdresse.sendKeys("salihh@gmail.com");
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
            System.out.println("Gmail Konto ist falsch! Sie sollen eine richtige Konto eingeben.");
        }
        if (nameMail.equals("salih") == false) {
            System.out.println("Name der Mail ist falsch! Sie sollen eine richtige Name eingeben.");
        }
        if (value.contains("@") && gmail.equals("gmail.com") && nameMail.equals("salih")) {
            System.out.println("Gratuliere! Sie haben eine richtige E-Mail eingegeben.");
        }
        Assert.assertTrue(value.contains("@") && gmail.equals("gmail.com") && nameMail.equals("salih"));
    }




    @Test
    public void mailSuchenInDerTabelleTest() {

        String name = "salih@tetronik.com";
        boolean suchendeWort = true;

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(4000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste);
        ReusableMethods.doubleClick(teilnehmer.tabelleRow1);
        ReusableMethods.getVisibilityOfWait(teilnehmer.mailAdresse);

        for (int i = 0; i < 1000; i++) {
            ReusableMethods.getVisibilityOfWait(teilnehmer.mailAdresse);
            if (teilnehmer.mailAdresse.getAttribute("value").contains(name)) {
                String value = teilnehmer.mailAdresse.getAttribute("value");
                System.out.println(i + 1 + " , " + "Value = " + value + " , das steht in der Tabelle");
                Assert.assertEquals(value, name);
                suchendeWort = false;
                break;
            } else {
                ReusableMethods.getVisibilityOfWait(teilnehmer.nextButton).click();
            }
        }
        if (suchendeWort) {
            System.out.println(name + " wurde nicht gefunden");
        }
    }







    public static void main(String[] args) {

        String mail ="salih@tetronik.com";
        String[] array= mail.split("@");
        System.out.println(array.length);
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(Arrays.toString(array));
    }





}
