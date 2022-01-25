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
import java.util.Random;
import java.util.Scanner;


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

        List<List<String>> list = ReusableMethods.getListData("src/main/resources/TeilnehmerNameList.xlsx", "Tabelle6", 1);

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();

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
        ReusableMethods.getLogin();
        ReusableMethods.waitForPageToLoad(20);
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(1000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste3).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.tabelleRufnummer1);
        System.out.println(teilnehmer.tabelleRow.size());
        for (int i = 0; i < teilnehmer.tabelleRow.size(); i++) {
            teilnehmer.tabelleRow.get(i).click();
            teilnehmer.loschenButton.click();
            ReusableMethods.getVisibilityOfWait(teilnehmer.jaButton).click();
        }


    }


    @Test
    public void tabelleRowLoschen2() {
        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(20);
        ReusableMethods.sleep(3000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste3).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.tabelleRufnummer1);

        String name = "";

        for (WebElement element : teilnehmer.tabelleEndgerätetd3) {
            System.out.println(element.getText());
            name = element.getText();
        }

        for (int i = 0; i < teilnehmer.tabelleRow.size(); i++) {
            teilnehmer.tabelleRow.get(i).click();
            teilnehmer.loschenButton.click();
            ReusableMethods.getVisibilityOfWait(teilnehmer.jaButton).click();

            if (teilnehmer.tabelleRow.get(i).getText().contains(name)) {
                teilnehmer.datensatzButton.click();
                 teilnehmer.tabelleRow.get(i).click();
                teilnehmer.loschenButton.click();
                // ReusableMethods.getVisibilityOfWait(teilnehmer.jaButton).click();

            }
        }
// td3 teki tetleri yaziyor, bir tane row siliyor sonra hata veriyor, ancak hata yazmiyor
    }





        /*
        Silme testi Teilnehmer menusunde ilgili yere click yaptiktan sonra löschen Button nuna tiklanir ve jaButtonu cikar ona tiklanarak, ilgili row silinir
        Ancak;
        Endgeräte sutunu dolu olanlara gelince uyari veriyor. bu uyariyi ok deyip, solmenude yer alan Rundruf menusune gidip,
        Bezeichnung altinda yer alan ilgili elementi ordan sildikten sonra, tekrar Teilnehmer menusune gelip, ayni menuye tikladiktan sonra loschenButtonu sonra jaButtonuna
        tiklanarak siliniyor.
        Bunun icin;
        1. Datensatz uyarisi ciktiginda, o uyariya ok deyip, row tekrar click yapmak gerekir ve sonra tekrar löschen butonuna tiklayip, cikan jaButtonuna click yapmak gerekir.
        if() kurgusu nasil olacak?
        2.Datensatz uyarisi geldiginde on adimi atlayarak calismaya devam et. en kolay yol bu görunuyor ama nasil yapilacak?
        3.Datensatz uyarisi sadece Endgeräte kismi dolu olanlar icin cikyor. bir kontrol ile Endgeräte dolu olanlari görmezden gel veya atla seklinde bir program yazilmasi gerekir
         */


    @Test
    public void tabelleRowLoschen3() { //bu program cok hizli birsekilde sildi. yaklasik 1.36 sn
        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(10);
        ReusableMethods.sleep(5000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste2).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.tabelleRufnummer1);
        String name = "";
        boolean bos = true;

        if (bos) {
            for (int i = 0; i < teilnehmer.tabelleRow.size(); i++) {
                teilnehmer.tabelleRow.get(i).click();
                teilnehmer.loschenButton.click();
                ReusableMethods.getVisibilityOfWait(teilnehmer.jaButton).click();

            }
        }else{



        for (int j = 0; j < teilnehmer.tabelleEndgerätetd3.size(); j++) {
            teilnehmer.datensatzButton.click();
            teilnehmer.tabelleRow.get(j).click();
            teilnehmer.loschenButton.click();
            ReusableMethods.getVisibilityOfWait(teilnehmer.jaButton).click();
            name += teilnehmer.tabelleEndgerätetd3.get(j);
            //break;
        }
        }
    }





    @Test
    public void suchenValueInTabelleTest() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(4000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste);

        boolean gibtEs = true;

        for (int i = 0; i < teilnehmer.tabelletd1.size(); i++) {
            if (teilnehmer.tabelletd1.get(i).getText().contains("NST: 578920040")) {
                System.out.println(i + 1 + " , " + "name = " + teilnehmer.tabelletd1.get(i).getText());
                gibtEs = false;
                break;
            }
        }
        if (gibtEs) {
            System.out.println("NST: 578920040 steht nicht in der Tabelle");
        }
    }


    @Test
    public void suchenValueInTabelleTest2() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(4000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste);
        teilnehmer.richtungstaste4.click();

        String name = "x200";
        boolean gibtEs = true;

        for (int i = 0; i < teilnehmer.tabelletd1.size(); i++) {
            if (teilnehmer.tabelletd1.get(i).getText().equalsIgnoreCase(name)) {
                System.out.println(i + 1 + " , " + "name = " + name + " , das steht in der Tabelle");
                gibtEs = false;
                break;
            }
        }

        if (gibtEs) {
            System.out.println(name + " steht nicht in der Tabelle");

        }
    }


    @Test
    public void tabelleRowgerenzeKontrol() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(20);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste7).click();

        for (int i = 0; i < teilnehmer.tabelleRow.size(); i++) {

            if (teilnehmer.tabelleRow.size() == 200) {

                System.out.println("teilnehmer.tabelleRow.size() = " + teilnehmer.tabelleRow.size() + ", Das bedeutet : " + "teilnehmer.tabelleRow.size() ist gleich  200");
                break;
            } else if (teilnehmer.tabelleRow.size() < 200) {
                System.out.println("teilnehmer.tabelleRow.size() = " + teilnehmer.tabelleRow.size() + ", Das bedeutet : " + "teilnehmer.tabelleRow.size() ist  kleiner von 200");
                break;
            } else {
                System.out.println("teilnehmer.tabelleRow.size() ist großer als  200");
                break;
            }

        }

    }


    public static void main(String[] args) {

        long tcNo = 2345678900l;

        long ilkHane = tcNo / 10000000000l;

        boolean uzunlukDogruMu = ("" + tcNo).length() == 11;

        int sonRakam = (int) tcNo % 10;

        if (ilkHane != 0 && uzunlukDogruMu == true && sonRakam % 2 == 0) {

            System.out.println("Tebrikler!!! dogru no girdiniz...");
        }

        if (ilkHane == 0) {

            System.out.println("ilk hane 0 olamaz...");
        }

        if (sonRakam % 2 != 0) {

            System.out.println("son rakam 2 ile tam bolunebilmeli");
        }

        if (uzunlukDogruMu == false) {

            System.out.println("tc no 11 haneden olusmalidir");
        }


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

                "SPOLAT1",
                "SPOLAT12",
                "SPOLAT123",
                "SPOLAT1234",
                "SPOLAT12345",
                "SPOLAT123456",

        };
        return data;
    }
}
