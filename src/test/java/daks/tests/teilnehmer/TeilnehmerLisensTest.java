package daks.tests.teilnehmer;

import daks.pages.TeilnehmerPage;
import daks.utilities.ReusableMethods;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class TeilnehmerLisensTest {

    TeilnehmerPage teilnehmer = new TeilnehmerPage();


    @Test
    public void teilnehmerLisensTest() {

        ReusableMethods.getLogin();
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


    @Test
    public void nameListHinzufugen() {

        ReusableMethods.getLogin();

        List<List<String>> list = ReusableMethods.getListData("src/main/resources/TeilnehmerNameList.xlsx", "Tabelle1", 1);

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();

        for (int i = 0; i < list.size(); i++) {

            ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton).click();
            // ReusableMethods.waitForPageToLoad(20);
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

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(5000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.tabelleRufnummer1);

        for (int i = 0; i < teilnehmer.tabelleRow.size(); i++) {

            ReusableMethods.getVisibilityOfWait(teilnehmer.tabelleRow.get(i)).click();
            teilnehmer.loschenButton.click();
            ReusableMethods.getVisibilityOfWait(teilnehmer.jaButton).click();

        }
    }






    @Test
    public void tabelleRowgerenzeKontrol() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(20);
        ReusableMethods.sleep(5000);
       // ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();

        for (int i = 0; i < teilnehmer.richtungstasteList.size(); i++) {

            ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();

                if (teilnehmer.tabelleRow.size() <= 200) {

                    System.out.println("teilnehmer.tabelleRow.size() ist kleiner oder gleich  200");

                } else {
                    System.out.println("teilnehmer.tabelleRow.size() ist gr0ßer als 200");
                }

                System.out.println(teilnehmer.tabelleRow.size());
                //teilnehmer.tabelleRow.size() ist kleiner oder gleich  200
                //200  => bu sekilde 9 tane yazdiriyor. Ancak 9. sayfada 200 den az isim var. tikladigi sayfanin size ni aliyor
            }

        }








    @Test
    public void suchendeValueImList() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(5000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste);

        String value = teilnehmer.tabelleColumn.get(1).getAttribute("value");
        System.out.println(value);//null

        System.out.println(teilnehmer.tabelleColumn.indexOf("NST: 578920016"));// -1

        boolean b=teilnehmer.tabelleColumn.contains("NST: 578920016");
        System.out.println(b);// false veriyor, aslinda listede var, hem de ilk sayfada

        /*
        for (int i = 0; i < teilnehmer.richtungstasteList.size(); i++) {


            for (int j = 0; j < teilnehmer.tabelleColumn.size(); j++) {

                String value = teilnehmer.tabelleColumn.get(j).getAttribute("value");

                boolean b=teilnehmer.tabelleColumn.contains("NST: 578920016");
                System.out.println(b);


                if (value.equalsIgnoreCase("z01")) { // java.lang.NullPointerException
                    System.out.println(value);
                } else {
                    System.out.println("Das List enthält keiner Worter");
                }


                 */
            }














    @Test(dataProvider = "getData")
    public void teilnehmerLisensTest1(String name) {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(2000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton).click();
        ReusableMethods.waitForPageToLoad(5);
        ReusableMethods.sleep(1000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).sendKeys(name);
        ReusableMethods.sleep(1000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton).click();
        ReusableMethods.sleep(2000);
        ReusableMethods.waitForPageToLoad(5);
        ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton);
        ReusableMethods.sleep(2000);
        Assert.assertTrue(teilnehmer.neuButton.isEnabled());
    }


    @DataProvider
    public Object[] getData() {

        Object[] data = {

                "SPOLAT12345",


        };
        return data;
    }
}
