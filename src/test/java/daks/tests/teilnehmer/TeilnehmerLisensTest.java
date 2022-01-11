package daks.tests.teilnehmer;

import daks.pages.TeilnehmerPage;
import daks.utilities.ReusableMethods;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();

        List<List<String>> list = ReusableMethods.getListData("src/main/resources/TeilnehmerNameList.xlsx", "Tabelle1", 1);

        for (int i = 0; i < list.size(); i++) {

            ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton).click();
            ReusableMethods.waitForPageToLoad(20);

            ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).sendKeys(list.get(i).get(0));
            // ReusableMethods.waitForPageToLoad(20);

            ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton).click();

            // ReusableMethods.waitForPageToLoad(20);
            ReusableMethods.sleep(500);
            ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton);

            ReusableMethods.sleep(500);
            // ReusableMethods.waitForPageToLoad(20);
            Assert.assertTrue(teilnehmer.neuButton.isEnabled());

        }

    }


    @Test
    public void tabelleRowLoschen() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        // ReusableMethods.waitForPageToLoad(30);
        ReusableMethods.sleep(5000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        //  ReusableMethods.waitForPageToLoad(20);
        ReusableMethods.sleep(5000);
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

        if (teilnehmer.tabelleRow.size() > 2000) {

            System.out.println("teilnehmer.tabelleRow.size() ist gr0ßer als 2000");

        } else {
            System.out.println("teilnehmer.tabelleRow.size() ist kleiner und gleich 2000");
        }


        /*
        for (int i = 0; i < teilnehmer.tabelleRow.size(); i++) { // size alamiyorum
            System.out.println(teilnehmer.tabelleRow.size());
        }
         */

    }




    @Test
    public void suchendeValueImList() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        //  ReusableMethods.waitForPageToLoad(20); // bunlarla kullanildiginda: java.lang.NullPointerException
        //  ReusableMethods.sleep(5000); // java.lang.NullPointerException

        for (WebElement element : teilnehmer.tabelleRow) {

            String value = element.getAttribute("value");
            if (value.contains("SPOLAT12345")) { // contains problem var sanirim ama yerine ne yazilacak
                System.out.println("Das List enthält die Worter"); // test geciyor ama hic birsey yazmiyor
            } else {
                System.out.println("Das List enthält keine Worter");
            }
        }

      /*

        for(int i=0;i<teilnehmer.tabelleRow.size();i++){  // test geciyor ama hic birsey yazmiyor

            String value = teilnehmer.tabelleRow.get(i).getAttribute("value");
            if(value.contains("SPOLAT12345")){
                System.out.println("Das List enthält die Worter");
            } else {
                System.out.println("Das List enthält keine Worter");
            }
            }
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
