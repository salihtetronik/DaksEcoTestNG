package daks.tests.teilnehmer;

import daks.pages.TeilnehmerPage;
import daks.utilities.ReusableMethods;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class TeilnehmerLisensTest {

    TeilnehmerPage teilnehmer = new TeilnehmerPage();

    @BeforeMethod
    void beforeMethod() {

        ReusableMethods.getLogin();
    }


    @Test
    public void nameListHinzufugen() {

        List<List<String>> list = ReusableMethods.getListData("src/main/resources/TeilnehmerNameList.xlsx", "Tabelle1", 1);

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        //ReusableMethods.sleep(500);
        ReusableMethods.waitForPageToLoad(20);
        for (int i = 0; i < list.size(); i++) {
            ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton).click();
            ReusableMethods.waitForPageToLoad(20);
            ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).sendKeys(list.get(i).get(0));
            ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton).click();
            ReusableMethods.sleep(500);
            ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton);
            ReusableMethods.sleep(500);
            Assert.assertTrue(teilnehmer.neuButton.isEnabled());
        }
    }


    @Test
    public void tabelleRowLoschen() {

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(4000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste5).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.tabelleRufnummer1);
        System.out.println(teilnehmer.tabelleRow.size());
        for (int i = 0; i < teilnehmer.tabelleRow.size(); i++) {
            teilnehmer.tabelleRow.get(i).click();
            teilnehmer.loschenButton.click();
            ReusableMethods.getVisibilityOfWait(teilnehmer.jaButton).click();
        }
    }


    @Test
    public void tabelleRowEndeLoschen() {

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(20);
        ReusableMethods.sleep(1000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste7).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.tabelleRufnummer1);
        for (int i = 0; i < teilnehmer.tabelleRow.size(); i++) {
            System.out.println(teilnehmer.tabelleRow.size());
            System.out.println(teilnehmer.tabelleNameOrt.get(i).getText());
            teilnehmer.tabelleRow.get(i).click();
            teilnehmer.loschenButton.click();
            ReusableMethods.getVisibilityOfWait(teilnehmer.jaButton).click();
        }
    }


    @Test
    public void alleTabelleRowGrenzeKontrol() {

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(4000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste5);

        for (int i = 0; i < teilnehmer.richtungstasteList.size(); i++) {
            teilnehmer.richtungstasteList.get(i).click();
            for (int j = 0; i < teilnehmer.tabelleRow.size(); i++) {
                if (teilnehmer.tabelleRow.size() == 200) {
                    System.out.println(i + " TabelleRow.size() = " + teilnehmer.tabelleRow.size());
                    break;
                } else if (teilnehmer.tabelleRow.size() < 200) {
                    System.out.println(i + " TabelleRow.size() = " + teilnehmer.tabelleRow.size());
                    break;
                } else {
                    System.out.println(i - 1 + " TabelleRow.size() ist großer als  200");
                    break;
                }
            }
        }
    }


    @Test
    public void bestimmteTabelleRowGrenzeKontrol() {

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        // ReusableMethods.waitForPageToLoad(20);
        ReusableMethods.sleep(5000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste7).click();

        for (int i = 0; i < teilnehmer.tabelleRow.size(); i++) {
            if (teilnehmer.tabelleRow.size() == 200) {
                System.out.println("TabelleRow.size() = " + teilnehmer.tabelleRow.size());
                break;
            } else if (teilnehmer.tabelleRow.size() < 200) {
                System.out.println("TabelleRow.size() = " + teilnehmer.tabelleRow.size());
                break;
            } else {
                System.out.println("TabelleRow.size() ist großer als  200");
                break;
            }
        }
    }


    @Test
    public void gesuchtesWortInAlleTabelle() {

        String name = "yxcvbnmasdfghfklouqwertzueopa2";
        boolean gesuchtesWort = true;

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(4000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste);
        ReusableMethods.doubleClick(teilnehmer.tabelleRow1);
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt);

        for (int i = 0; i < 1000; i++) {
            ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt);
            String value = teilnehmer.nameOrt.getAttribute("value");
            if (value.contains(name)) {
                System.out.println(i + 1 + " , " + value + " steht in der Tabelle");
                Assert.assertEquals(value, name);
                gesuchtesWort = false;
                break;
            } else {
                ReusableMethods.getVisibilityOfWait(teilnehmer.nextButton).click();
            }
        }
        if (gesuchtesWort) {
            System.out.println(name + " wurde nicht gefunden");
        }
    }


    @Test
    public void gesuchtesWortInBestimmteTabelle() {

        String name = "xy19";
        boolean gesuchtesWort = true;

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(4000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste);
        teilnehmer.richtungstaste5.click();

        for (int i = 0; i < teilnehmer.tabelleNameOrt.size(); i++) {
            if (teilnehmer.tabelleNameOrt.get(i).getText().equalsIgnoreCase(name)) {
                System.out.println(name + " steht in der Tabelle = " + (i + 1));
                gesuchtesWort = false;
                break;
            }
        }
        if (gesuchtesWort) {
            System.out.println(name + " steht nicht in der Tabelle");
        }
    }




    @Test
    public void teilnehmerLisensTest() {

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(1000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton).click();
        ReusableMethods.waitForPageToLoad(5);
        ReusableMethods.sleep(1000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).sendKeys("POLAT1");
        ReusableMethods.sleep(1000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton).click();
        ReusableMethods.sleep(1000);
        ReusableMethods.waitForPageToLoad(5);
        ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton);
        ReusableMethods.sleep(1000);
        Assert.assertTrue(teilnehmer.neuButton.isEnabled());
    }


    @Test(dataProvider = "getData")
    public void teilnehmerLisensTest1(String name) {

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(500);
        ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).sendKeys(name);
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton);
        ReusableMethods.sleep(500);
        Assert.assertTrue(teilnehmer.neuButton.isEnabled());
    }


    @DataProvider
    public Object[] getData() {

        Object[] data = {

                "SPOLAT1",
                "SPOLAT12",
                "SPOLAT123",
                "SPOLAT1234",
                "SPOLAT12345",

        };
        return data;
    }




    @Test
    public void tabelleRowEndeLoschen2() {

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(20);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste7).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.tabelleRufnummer1);

        for (int i = 0; i < teilnehmer.tabelleRow.size(); i++) {
            System.out.println(teilnehmer.tabelleRow.size());
            System.out.println(teilnehmer.tabelleNameOrt.get(i).getText());
            if (teilnehmer.tabelleNameOrt.get(i).getText().length() != 0) {
                teilnehmer.tabelleRow.get(i).click();
                teilnehmer.loschenButton.click();
                ReusableMethods.getVisibilityOfWait(teilnehmer.jaButton).click();
            }
        }
    }


    @Test
    public void tabelleRowLoschen2() {

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(20);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste7).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.tabelleRufnummer1);

        for (int i = 0; i < teilnehmer.tabelleRow.size(); i++) {
            System.out.println(teilnehmer.tabelleEndgerätetd3.get(i).getText());
            if (teilnehmer.tabelleEndgerätetd3.get(i).getText().length() == 0) {
                teilnehmer.tabelleRow.get(i).click();
                teilnehmer.loschenButton.click();
                ReusableMethods.getVisibilityOfWait(teilnehmer.jaButton).click();
            }
        }
    }


    //Dieses Test ist noch nicht fertig...
    @Test
    public void tabelleRowLoschen3() {

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(3000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste2).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.tabelleRufnummer1);

        for (int i = 0; i < teilnehmer.tabelleRow.size(); i++) {
            // System.out.println(teilnehmer.tabelleEndgerätetd3.get(i).getText());
            if (teilnehmer.tabelleEndgerätetd3.get(i).getText().length() == 0) {

                teilnehmer.tabelleRow.get(i).click();
                teilnehmer.loschenButton.click();
                ReusableMethods.getVisibilityOfWait(teilnehmer.jaButton).click();

            } else {
                teilnehmer.tabelleRow.get(i).click();
                teilnehmer.loschenButton.click();
                ReusableMethods.getVisibilityOfWait(teilnehmer.datensatzButton).click();
                ReusableMethods.getVisibilityOfWait(teilnehmer.rundrufeButton).click();
                for (int j = 0; j < teilnehmer.tabelleRundrufeBezeichnung.size(); j++) {

                }

                if (teilnehmer.tabelleRundrufeBezeichnung.get(i).getText().contains(teilnehmer.datensatzText.getText())) {
                    ReusableMethods.waitForPageToLoad(20);
                    teilnehmer.tabelleRow.get(i).click();
                    ReusableMethods.getVisibilityOfWait(teilnehmer.loschenButton).click();
                    ReusableMethods.getVisibilityOfWait(teilnehmer.jaButton).click();
                    ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
                    teilnehmer.loschenButton.click();
                    ReusableMethods.getVisibilityOfWait(teilnehmer.jaButton).click();
                }
            }
        }

    }


}
