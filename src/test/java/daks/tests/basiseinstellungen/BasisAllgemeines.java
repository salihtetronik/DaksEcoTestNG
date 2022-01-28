package daks.tests.basiseinstellungen;

import daks.pages.BasiseinstellungenPage;
import daks.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class BasisAllgemeines {

    BasiseinstellungenPage basis=new BasiseinstellungenPage();



    @Test
    public void defaultsprache() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(basis.defaultSprache);

        ArrayList<String> languageElement = new ArrayList<>();
        languageElement.add("Deutsch");
        languageElement.add("English");
        languageElement.add("Nederlands");

        for (int i = 0; i < languageElement.size(); i++) {

            if (basis.defaultSprache.getText().contains(languageElement.get(i))) {
                System.out.println(basis.defaultSprache.getText());
            } else {
                System.out.println("basis.defaultSprache.getText() enthält keine languageElement.get(i)");
            }
            Assert.assertEquals(basis.defaultSprache.getText(), "Deutsch\nEnglish\nNederlands");
            // Assert.assertTrue(basis.defaultSprache.getText().contains("DeutschEnglishNederlands"));
            break;

        }

    }





    @Test
    public void allgemeinsRundrufeAnzahHochpriorerProzesseTest() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(basis.anzahlHochpriorProsses);
        String  value = basis.anzahlHochpriorProssesOption2.getAttribute("value");

        if (value.equals("2")) {
            System.out.println(value);
        } else {
            System.out.println(value + " enthält keine anzahlHochpriorProssesOption.getAttribute()");
        }
        Assert.assertEquals(value,"2");

    }






    @Test
    public void allgemeinsRundrufeMaxRufzeitTest() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(basis.maximaleRufzeit);
        String value = basis.maximaleRufzeit.getAttribute("value");

        if (value.equals("35")) {
            System.out.println(value);
        } else {
            System.out.println("Value ist kein gleich 35");
        }
        Assert.assertEquals(value, "35");

    }




    @Test
    public void allgemeinsRundrufeNichtErreichtTest() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(basis.intervallBeiNichtErreicht);
        String value = basis.intervallBeiNichtErreicht.getAttribute("value");

        if (value.equals("20")) {
            System.out.println(value);
        } else {
            System.out.println("Value ist kein gleich 20");
        }
        Assert.assertEquals(value, "20");

    }




    @Test
    public void allgemeinsRundrufeBeiBesetztTest() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(basis.intervallBeiBesetzt);
        String value = basis.intervallBeiBesetzt.getAttribute("value");

        if (value.equals("60")) {
            System.out.println(value);
        } else {
            System.out.println("Value ist kein gleich 60");
        }
        Assert.assertEquals(value, "60");

    }




    @Test
    public void allgemeinsRundrufeMaxAnzeigeDauerTest() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(basis.maxAnzeigedauerNachAnsage);
        String value = basis.maxAnzeigedauerNachAnsage.getAttribute("value");

        if (value.equals("30")) {
            System.out.println(value);
        } else {
            System.out.println("Value ist kein gleich 30");
        }
        Assert.assertEquals(value, "30");

    }





    @Test
    public void allgemeinsRundrufeMaxAnzeigeDauerDMCTest() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(basis.maxAnzeigedauerDMC);
        String value = basis.maxAnzeigedauerDMC.getAttribute("value");

        if (value.equals("15")) {
            System.out.println(value);
        } else {
            System.out.println("Value ist kein gleich 15");
        }
        Assert.assertEquals(value, "15");

    }






    @Test
    public void allgemeinsRundrufeAnzahHochpriorerProzesseSelectTest() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(basis.anzahlHochpriorProsses);
        Select select = new Select(basis.anzahlHochpriorProsses);
        select.selectByValue("3");
        ReusableMethods.getVisibilityOfWait(basis.sichern).click();

    }





    @Test
    public void allgemeinsRundrufeAnzahHochpriorerProzesseSelectRandomTest() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(basis.anzahlHochpriorProsses);
        Select hochpriorer = new Select(basis.anzahlHochpriorProsses);
        hochpriorer.selectByIndex((int) (Math.random() * hochpriorer.getOptions().size()));
        ReusableMethods.getVisibilityOfWait(basis.sichern).click();

    }










}
