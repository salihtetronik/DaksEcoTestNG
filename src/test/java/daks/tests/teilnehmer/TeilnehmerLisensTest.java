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
public void tabelleRowgerenzeKontrol(){

    ReusableMethods.getLogin();
    ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();

    if(teilnehmer.tabelleRow.size()>2000){

        System.out.println("teilnehmer.tabelleRow.size() ist gr0ßer als 2000");

    }else{
        System.out.println("teilnehmer.tabelleRow.size() ist kleiner und gleich 2000");
    }



/*

   List in size;

    //teilnehmer.tabelleRow.get(teilnehmer.tabelleRow.size()-1);

    if (arrayList != null && !arrayList.isEmpty()) {
        T item = arrayList.get(arrayList.size()-1);
    }


    for (WebElement element:teilnehmer.tabelleRow) {
        if (element != null) {
            WebElement item = teilnehmer.tabelleRow.get(teilnehmer.tabelleRow.size() - 1);

            System.out.println(item); // test ist Erfolgreich, ancak size yazdirmiyor
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
    public Object[] getData(){

        Object[] data={

             "SPOLAT12345",



        };
        return data;
    }
}
