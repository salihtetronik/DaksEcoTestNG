package daks.tests.teilnehmer;

import daks.pages.TeilnehmerPage;
import daks.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeilnehmerRufnummerTest {

    TeilnehmerPage teilnehmer =new TeilnehmerPage();

    @Test
    public void teilnehmerRufnummerTest1(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.scrollToElement(teilnehmer.tabelleRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tabelleRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer).clear();
        teilnehmer.rufnummer.sendKeys("1234567890*#");
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);
        Assert.assertTrue(teilnehmer.sichernButton.isEnabled());
    }



    @Test
    public void teilnehmerRufnummerTest2(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.scrollToElement(teilnehmer.tabelleRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tabelleRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer).clear();
        teilnehmer.rufnummer.sendKeys("/");
        Assert.assertTrue(teilnehmer.sichernButton.isEnabled());
    }


    @Test
    public void teilnehmerRufnummerTest3(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.scrollToElement(teilnehmer.tabelleRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tabelleRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer).clear();
        teilnehmer.rufnummer.sendKeys("-");
        Assert.assertTrue(teilnehmer.sichernButton.isEnabled());
    }


    @Test
    public void teilnehmerRufnummerTest4(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.scrollToElement(teilnehmer.tabelleRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tabelleRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer).clear();
        teilnehmer.rufnummer.sendKeys("+");
        Assert.assertTrue(teilnehmer.sichernButton.isEnabled());
    }


    @Test
    public void teilnehmerRufnummerTest5(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.scrollToElement(teilnehmer.tabelleRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tabelleRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer).clear();
        teilnehmer.rufnummer.sendKeys(" ");
        Assert.assertTrue(teilnehmer.sichernButton.isEnabled());
    }




    @Test
    public void teilnehmerRufnummerTest6(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.scrollToElement(teilnehmer.tabelleRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tabelleRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer).clear();
        teilnehmer.rufnummer.sendKeys("%");
        Assert.assertFalse(teilnehmer.sichernButton.isEnabled());
    }




    @Test
    public void teilnehmerRufnummerTest7(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.scrollToElement(teilnehmer.tabelleRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tabelleRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer).clear();
        teilnehmer.rufnummer.sendKeys("Abcd");
        Assert.assertFalse(teilnehmer.sichernButton.isEnabled());
    }



    @Test
    public void teilnehmerRufnummerTest8(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.scrollToElement(teilnehmer.tabelleRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tabelleRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer).clear();
        teilnehmer.rufnummer.sendKeys("äüöÄÜÖ");
        Assert.assertFalse(teilnehmer.sichernButton.isEnabled());
    }


    @Test
    public void teilnehmerRufnummerTest9(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.scrollToElement(teilnehmer.tabelleRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tabelleRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer).clear();
        teilnehmer.rufnummer.sendKeys("ß");
        Assert.assertFalse(teilnehmer.sichernButton.isEnabled());
    }
}
